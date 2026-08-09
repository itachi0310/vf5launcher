package com.vf5regenlauncher;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fyt.car.IUiRefresher;
import com.syu.car.CarStates;

/**
 * Port of Dashboard logic to Launcher17 architecture.
 * Implements IUiRefresher to receive centralized updates.
 */
public class DashboardController implements IUiRefresher {
    private final TextView tvSpeed, tvGear, tvSOC, tvRange;
    private final TextView btnModeSport, btnModeEco;
    private final TextView btnRegenOff, btnRegenLow, btnRegenHigh;
    
    // Charging UI
    private final View layoutDriving, layoutCharging;
    private final TextView tvChargeSOC, tvChargeTime;
    private final ProgressBar pbCharge;
    
    private final Activity activity;
    private int currentDriveMode = 0; // 0: ECO, 1: SPORT
    private int currentRegenMode = 1; // 0: OFF, 1: LOW, 2: HIGH

    public DashboardController(Activity activity) {
        this.activity = activity;
        tvSpeed = activity.findViewById(R.id.tv_launcher_speed);
        tvGear = activity.findViewById(R.id.tv_launcher_gear);
        tvSOC = activity.findViewById(R.id.tv_launcher_soc);
        tvRange = activity.findViewById(R.id.tv_launcher_range);

        btnModeSport = activity.findViewById(R.id.btn_mode_sport);
        btnModeEco = activity.findViewById(R.id.btn_mode_eco);
        btnRegenOff = activity.findViewById(R.id.btn_regen_off);
        btnRegenLow = activity.findViewById(R.id.btn_regen_low);
        btnRegenHigh = activity.findViewById(R.id.btn_regen_high);

        layoutDriving = activity.findViewById(R.id.layout_driving_dashboard);
        layoutCharging = activity.findViewById(R.id.layout_charging_dashboard);
        tvChargeSOC = activity.findViewById(R.id.tv_charge_soc);
        tvChargeTime = activity.findViewById(R.id.tv_charge_time);
        pbCharge = activity.findViewById(R.id.pb_charge_progress);

        init();
        
        // Register to Global Notifiers
        com.fyt.car.LauncherNotify.NOTIFY_MAINSTATE.addUiRefresher(this, true);
        com.fyt.car.LauncherNotify.NOTIFIER_REGEN_DATA.addUiRefresher(this, true);
    }

    private void init() {
        if (btnModeEco != null) btnModeEco.setOnClickListener(v -> sendCarCmd(33, 0));
        if (btnModeSport != null) btnModeSport.setOnClickListener(v -> sendCarCmd(33, 1));
        if (btnRegenOff != null) btnRegenOff.setOnClickListener(v -> sendCarCmd(34, 0));
        if (btnRegenLow != null) btnRegenLow.setOnClickListener(v -> sendCarCmd(34, 1));
        if (btnRegenHigh != null) btnRegenHigh.setOnClickListener(v -> sendCarCmd(34, 2));
        View btnStopCharge = activity.findViewById(R.id.btn_stop_charging);
        if (btnStopCharge != null) btnStopCharge.setOnClickListener(v -> sendCarCmd(51, 1));
    }

    private void sendCarCmd(int id, int val) {
        // MODULE_MAIN = 0 is standard for SYU car command delivery
        CarStates.getCar(activity).getTools().sendInt(0, id, val); 
    }

    @Override
    public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts) {
        if (ints == null || ints.length < 2) return;
        
        // After our CarStates fix, ints[0] is updateCode, ints[1] is the first value
        int updateCode = ints[0];
        int value = ints[1];
        
        activity.runOnUiThread(() -> {
            switch (updateCode) {
                case 101: if (tvSpeed != null) tvSpeed.setText(String.valueOf(value)); break;
                case 114: 
                    updateGearDisplay(value); // Module 0: Gear
                    if (tvSOC != null) tvSOC.setText(value + "%"); // Module 7: SOC
                    if (tvChargeSOC != null) tvChargeSOC.setText(value + "%");
                    if (pbCharge != null) pbCharge.setProgress(value);
                    break;
                case 115: 
                    updateBrakeDisplay(value == 1); // Module 0: Brake
                    updateChargingMode(value == 1); // Module 7: Charging
                    break;
                case 113: if (tvRange != null) tvRange.setText(value + " km"); break;
                case 116: updateChargeTime(value); break;
                case 109: currentDriveMode = value; updateDriveModeDisplay(value); break;
                case 110: currentRegenMode = value; updateRegenModeDisplay(value); break;
            }
        });
    }

    private void updateChargingMode(boolean charging) {
        if (layoutDriving != null) layoutDriving.setVisibility(charging ? View.GONE : View.VISIBLE);
        if (layoutCharging != null) layoutCharging.setVisibility(charging ? View.VISIBLE : View.GONE);
        if (charging) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    private void updateChargeTime(int totalMinutes) {
        if (tvChargeTime == null) return;
        if (totalMinutes >= 255 || totalMinutes <= 0) {
            tvChargeTime.setText("Thời gian còn lại: --");
            return;
        }
        int hours = totalMinutes / 60;
        int mins = totalMinutes % 60;
        tvChargeTime.setText(String.format(java.util.Locale.US, "Thời gian còn lại: %dh %02dmin", hours, mins));
    }

    public void toggleDriveMode() {
        sendCarCmd(33, (currentDriveMode == 0) ? 1 : 0);
    }

    private void updateDriveModeDisplay(int value) {
        if (btnModeEco != null) btnModeEco.setBackgroundResource(value == 0 ? R.drawable.bg_button_selected : 0);
        if (btnModeSport != null) btnModeSport.setBackgroundResource(value == 1 ? R.drawable.bg_button_selected : 0);
    }

    private void updateRegenModeDisplay(int value) {
        if (btnRegenOff != null) btnRegenOff.setBackgroundResource(value == 0 ? R.drawable.bg_button_selected : 0);
        if (btnRegenLow != null) btnRegenLow.setBackgroundResource(value == 1 ? R.drawable.bg_button_selected : 0);
        if (btnRegenHigh != null) btnRegenHigh.setBackgroundResource(value == 2 ? R.drawable.bg_button_selected : 0);
    }

    private void updateGearDisplay(int value) {
        if (tvGear == null) return;
        String gears = "R N D";
        SpannableString spannable = new SpannableString(gears);
        int start = -1;
        switch (value) {
            case 1: start = 0; break; // Reverse
            case 0: start = 2; break; // Neutral
            case 2: start = 4; break; // Drive
        }
        if (start != -1) {
            spannable.setSpan(new ForegroundColorSpan(Color.WHITE), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tvGear.setText(spannable);
    }

    private void updateBrakeDisplay(boolean isPressed) {
        if (tvSpeed != null) tvSpeed.setTextColor(isPressed ? Color.RED : Color.WHITE);
    }
}
