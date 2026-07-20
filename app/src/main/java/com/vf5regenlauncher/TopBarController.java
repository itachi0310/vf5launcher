package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.widget.TextView;

public class TopBarController implements CanbusConnector.CanbusDataListener {
    private final Activity activity;
    private final TextView tvCarId;

    public TopBarController(Activity activity) {
        this.activity = activity;
        this.tvCarId = activity.findViewById(R.id.tv_car_id);
        
        setupListeners();
    }

    private void setupListeners() {
        android.view.View btnSettings = activity.findViewById(R.id.btn_top_settings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(activity, SettingsActivity.class);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private String lastLog1 = "", lastLog2 = "", lastLog3 = "";
    private int valC7 = -1, valC12 = -1;

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        // Theo dõi Code 7 và 12 cho Cần số
        if (moduleId == 0) {
            if (code == 7) valC7 = value;
            if (code == 12) valC12 = value;
        }

        // Lọc bỏ triệt để các mã dữ liệu cảm biến thay đổi liên tục
        if (moduleId == 0) {
            // Loại bỏ các mã từ 101 trở đi (Tốc độ, góc lái, cảm biến...) và các mã gây nhiễu
            if ((code >= 101 && code <= 150) || code == 41 || code == 10 || code == 11) return;
        }
        
        if (moduleId == 7) {
            // Loại bỏ các thông số pin/nhiệt độ/quãng đường nhảy số liên tục
            if (code == 114 || code == 113 || code == 115 || code == 120 || code == 109 || code == 110) return;
        }

        // Hiển thị 3 mã gần nhất + Giá trị C7, C12 để dò cần số
        String newLog = String.format(java.util.Locale.US, "M%d:C%d:V%d", moduleId, code, value);
        if (!newLog.equals(lastLog1)) {
            lastLog3 = lastLog2;
            lastLog2 = lastLog1;
            lastLog1 = newLog;

            activity.runOnUiThread(() -> {
                if (tvCarId != null) {
                    tvCarId.setText(String.format("C7:%d C12:%d | %s | %s", 
                            valC7, valC12, lastLog1, lastLog2));
                }
            });
        }
    }
}
