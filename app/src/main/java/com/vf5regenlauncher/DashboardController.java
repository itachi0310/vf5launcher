package com.vf5regenlauncher;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DashboardController implements CanbusConnector.CanbusDataListener {
    private final TextView tvSpeed, tvGear, tvSOC, tvRange;
    private final TextView btnModeSport, btnModeEco;
    private final TextView btnRegenOff, btnRegenLow, btnRegenHigh;
    
    // Charging UI
    private final View layoutDriving, layoutCharging;
    private final TextView tvChargeStatus, tvChargeSOC, tvChargeTime, btnStopCharge;
    private final ProgressBar pbCharge;
    
    private final Activity activity;
    private int currentDriveMode = 0; // 0: ECO, 1: SPORT
    private int currentRegenMode = 1; // 0: OFF, 1: LOW, 2: HIGH
    private boolean isCharging = false;

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

        // Charging UI Init
        layoutDriving = activity.findViewById(R.id.layout_driving_dashboard);
        layoutCharging = activity.findViewById(R.id.layout_charging_dashboard);
        tvChargeStatus = activity.findViewById(R.id.tv_charge_status);
        tvChargeSOC = activity.findViewById(R.id.tv_charge_soc);
        tvChargeTime = activity.findViewById(R.id.tv_charge_time);
        btnStopCharge = activity.findViewById(R.id.btn_stop_charging);
        pbCharge = activity.findViewById(R.id.pb_charge_progress);

        init();
    }

    private void init() {
        // Chế độ lái (ID 33 trong cmd 1 gửi đi)
        if (btnModeEco != null) btnModeEco.setOnClickListener(v -> sendCarCmd(33, 0));
        if (btnModeSport != null) btnModeSport.setOnClickListener(v -> sendCarCmd(33, 1));
        
        // Chế độ phục hồi (ID 34 trong cmd 1 gửi đi)
        if (btnRegenOff != null) btnRegenOff.setOnClickListener(v -> sendCarCmd(34, 0));
        if (btnRegenLow != null) btnRegenLow.setOnClickListener(v -> sendCarCmd(34, 1));
        if (btnRegenHigh != null) btnRegenHigh.setOnClickListener(v -> sendCarCmd(34, 2));

        // Nút dừng sạc (ID 51, Value 1 trong cmd 1)
        if (btnStopCharge != null) btnStopCharge.setOnClickListener(v -> sendCarCmd(51, 1));
    }

    private void sendCarCmd(int id, int val) {
        CanbusConnector.getInstance(activity).sendCarCommand(id, val);
    }

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        if (moduleId == -1) {
            activity.runOnUiThread(() -> {
                updateGearDisplay(-1);
                updateDriveModeDisplay(currentDriveMode);
            });
            return;
        }
        activity.runOnUiThread(() -> {
            // Module 0: Dữ liệu lái
            if (moduleId == 0) {
                switch (code) {
                    case 101: // Tốc độ
                        tvSpeed.setText(String.valueOf(value));
                        break;
                    case 7:  // Nghi vấn Cần số
                    case 12: // Nghi vấn Cần số
                        updateGearDisplay(value);
                        break;
                    case 115: // Chân phanh (Brake Pedal)
                        updateBrakeDisplay(value == 1);
                        break;
                    case 139: // Phanh tay (Handbrake)
                        // Có thể hiển thị icon phanh tay nếu cần
                        break;
                    case 4: // Thường là trạng thái Ready (Sẵn sàng)
                    case 10:
                        updateReadyStatus(value);
                        break;
                }
                
                // Logic cũ cho phím Mode nếu nó gửi qua module 0
                if ((code == 1 || code == 2 || code == 45) && value == 1) {
                    toggleDriveMode();
                }
            } 
            // Module 7: Canbus / Air / Charging
            else if (moduleId == 7) {
                switch (code) {
                    case 114: // SOC Pin
                        tvSOC.setText(value + "%"); 
                        if (tvChargeSOC != null) tvChargeSOC.setText(value + "%");
                        if (pbCharge != null) pbCharge.setProgress(value);
                        break;
                    case 113: // Quãng đường còn lại
                        tvRange.setText(value + " km"); 
                        break;
                    case 115: // Trạng thái sạc (1: Đang sạc, 0: Không sạc)
                        updateChargingMode(value == 1);
                        break;
                    case 116: // Thời gian sạc (phút)
                        updateChargeTime(value);
                        break;
                    case 109: // Chế độ lái hiện tại
                        currentDriveMode = value;
                        updateDriveModeDisplay(value); 
                        break;
                    case 110: // Chế độ Regen hiện tại
                        updateRegenModeDisplay(value); 
                        break;
                }
            }
        });
    }

    private void updateChargingMode(boolean charging) {
        this.isCharging = charging;
        if (layoutDriving != null) layoutDriving.setVisibility(charging ? View.GONE : View.VISIBLE);
        if (layoutCharging != null) layoutCharging.setVisibility(charging ? View.VISIBLE : View.GONE);
        
        // Giữ màn hình luôn sáng khi đang sạc
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
        tvChargeTime.setText(String.format("Thời gian còn lại: %dh %02dmin", hours, mins));
    }

    public void toggleDriveMode() {
        int nextMode = (currentDriveMode == 0) ? 1 : 0;
        sendCarCmd(33, nextMode);
    }

    public void toggleRegenMode() {
        // Chuyển đổi giữa Low (1) và High (2)
        int nextMode = (currentRegenMode == 1) ? 2 : 1;
        sendCarCmd(34, nextMode);
    }

    private void updateDriveModeDisplay(int value) {
        this.currentDriveMode = value; // Đồng bộ biến nội bộ
        if (btnModeEco != null) btnModeEco.setBackgroundResource(value == 0 ? R.drawable.bg_button_selected : 0);
        if (btnModeSport != null) btnModeSport.setBackgroundResource(value == 1 ? R.drawable.bg_button_selected : 0);
    }

    private void updateRegenModeDisplay(int value) {
        this.currentRegenMode = value; // Đồng bộ biến nội bộ
        if (btnRegenOff != null) btnRegenOff.setBackgroundResource(value == 0 ? R.drawable.bg_button_selected : 0);
        if (btnRegenLow != null) btnRegenLow.setBackgroundResource(value == 1 ? R.drawable.bg_button_selected : 0);
        if (btnRegenHigh != null) btnRegenHigh.setBackgroundResource(value == 2 ? R.drawable.bg_button_selected : 0);
    }

    private void updateGearDisplay(int value) {
        // Cập nhật mapping theo thực tế: 1=R, 2=D, 0=N
        String gears = "R N D";
        SpannableString spannable = new SpannableString(gears);
        int start = -1;
        switch (value) {
            case 1: start = 0; break; // R
            case 0: start = 2; break; // N
            case 2: start = 4; break; // D
        }
        if (start != -1) {
            spannable.setSpan(new ForegroundColorSpan(Color.WHITE), start, start + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tvGear.setText(spannable);
    }

    private void updateBrakeDisplay(boolean isPressed) {
        if (tvSpeed != null) {
            // Thay đổi màu chữ tốc độ thành đỏ khi đạp phanh để dễ nhận biết
            tvSpeed.setTextColor(isPressed ? Color.RED : Color.WHITE);
        }
    }

    private void updateReadyStatus(int value) {
        // Log để bạn kiểm tra giá trị của code 4 hoặc 10
        Log.d("SCAN_DATA", "System Status (Ready?): " + value);
        
        // Trên VF5, READY thường hiện khi xe đã khởi động xong.
        // Bạn có thể gán logic này cho một TextView trên TopBar hoặc Dashboard
    }
}
