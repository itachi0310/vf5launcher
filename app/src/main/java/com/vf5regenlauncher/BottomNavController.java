package com.vf5regenlauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class BottomNavController implements CanbusConnector.CanbusDataListener {
    private final Activity activity;
    private final TextView tvFanSpeed, tvClimateTemp, btnAc;
    private int currentFanSpeed = 1;
    private int currentTemp = 230;
    private boolean isAcOn = false;

    // Các mã ID dựa trên tài liệu tham khảo RZC VinFast
    private static final int AIR_AC_TOGGLE = 11; // Chuyển sang 11 theo trí nhớ của bạn
    private static final int AIR_FAN_DOWN = 7;
    private static final int AIR_FAN_UP = 8;
    private static final int AIR_TEMP_DOWN = 9;
    private static final int AIR_TEMP_UP = 10;   // Chuyển sang 10 (đi cặp với 9)
    
    // Đối với VinFast RZC, ID của SET lệnh (cmd 3) trùng với ID của DATA
    private static final int AIR_SET_FAN = 21;    // ID đặt tốc độ quạt
    private static final int AIR_SET_TEMP = 27;   // ID đặt nhiệt độ

    public BottomNavController(Activity activity) {
        this.activity = activity;
        this.tvFanSpeed = activity.findViewById(R.id.tv_fan_speed);
        this.tvClimateTemp = activity.findViewById(R.id.tv_climate_temp);
        this.btnAc = activity.findViewById(R.id.btn_ac_toggle);
        init();
    }

    private void init() {
        setupNavButtons();
        setupAirControls();
        updateFanDisplay();
        updateTempDisplay();
    }

    private void setupNavButtons() {
        View home = activity.findViewById(R.id.btn_nav_home);
        if (home != null) home.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
        });

        View apps = activity.findViewById(R.id.btn_nav_apps);
        if (apps != null) apps.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(activity, AppListActivity.class);
                activity.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void setupAirControls() {
        // Nút A/C: Chạm nhẹ để gửi lệnh Bitmask (Bit 1 = 2) qua CMD 2
        if (btnAc != null) {
            btnAc.setOnClickListener(v -> {
//                sendAirBitmaskPulse(new int[]{2, 0, 0, 0, 0, 0});\
                showAirActivity();
            });
//            btnAc.setOnLongClickListener(v -> {
//                showAirActivity();
//                return true;
//            });
        }
        
        View fanUp = activity.findViewById(R.id.btn_fan_up);
        if (fanUp != null) fanUp.setOnClickListener(v -> {
            sendAirBitmaskPulse(new int[]{0, 2, 0, 0, 0, 0});
        });
        
        View fanDown = activity.findViewById(R.id.btn_fan_down);
        if (fanDown != null) fanDown.setOnClickListener(v -> {
            sendAirBitmaskPulse(new int[]{0, 1, 0, 0, 0, 0});
        });
        
        View tempUp = activity.findViewById(R.id.btn_temp_up);
        if (tempUp != null) tempUp.setOnClickListener(v -> {
            sendAirBitmaskPulse(new int[]{0, 0, 0, 2, 0, 0});
        });
        
        View tempDown = activity.findViewById(R.id.btn_temp_down);
        if (tempDown != null) tempDown.setOnClickListener(v -> {
            sendAirBitmaskPulse(new int[]{0, 0, 0, 1, 0, 0});
        });
    }

    // Gửi lệnh Bitmask: Gửi mảng bit (Nhấn) rồi gửi mảng 0 (Nhả) sau 100ms
    // Phương thức sendAirCommand trong CanbusConnector mặc định gửi CMD 2
    private void sendAirBitmaskPulse(int[] data) {
        CanbusConnector.getInstance(activity).sendAirCommand(data);
        new Handler(Looper.getMainLooper()).postDelayed(() ->
            CanbusConnector.getInstance(activity).sendAirCommand(new int[]{0, 0, 0, 0, 0, 0}), 100);
    }

    private void showAirActivity() {
        try {
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.syu.ui.air", "com.syu.ui.air.Air_0453_Rzc_VinFast_Plus_23"));
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            activity.startActivity(intent);
            Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.syu.canbus.enter.air");
            if (intent != null) activity.startActivity(intent);
        } catch (Exception e) {
            try {
                Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.syu.canbus");
                if (intent != null) activity.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        if (moduleId == -1) {
            activity.runOnUiThread(() -> {
                updateFanDisplay();
                updateTempDisplay();
            });
            return;
        }
        if (moduleId != 7) return;
        activity.runOnUiThread(() -> {
            switch (code) {
                case 21: currentFanSpeed = value; updateFanDisplay(); break;
                case 27: currentTemp = value; updateTempDisplay(); break;
                case 11: // Cập nhật Case 11 cho trạng thái AC
                    isAcOn = (value != 0); 
                    if (btnAc != null) btnAc.setTextColor(isAcOn ? Color.CYAN : Color.WHITE); 
                    break;
            }
        });
    }

    private void updateTempDisplay() {
        if (tvClimateTemp == null) return;
        if (currentTemp == -2) tvClimateTemp.setText("LO");
        else if (currentTemp == -3) tvClimateTemp.setText("HI");
        else {
            if (currentTemp % 10 == 0) tvClimateTemp.setText((currentTemp / 10) + "°C");
            else tvClimateTemp.setText((currentTemp / 10.0) + "°C");
        }
    }

    private void updateFanDisplay() {
        if (tvFanSpeed == null) return;
        tvFanSpeed.setText(String.valueOf(currentFanSpeed));
        View down = activity.findViewById(R.id.btn_fan_down);
        View up = activity.findViewById(R.id.btn_fan_up);
        if (down != null) down.setVisibility(currentFanSpeed <= 0 ? View.INVISIBLE : View.VISIBLE);
        if (up != null) up.setVisibility(currentFanSpeed >= 8 ? View.INVISIBLE : View.VISIBLE);
    }
}
