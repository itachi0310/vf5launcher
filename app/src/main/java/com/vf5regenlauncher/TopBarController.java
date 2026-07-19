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

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        // Lọc bỏ các mã gây nhiễu
        if (moduleId == 0 && (code == 101 || code == 41 || code == 139 || code == 146)) return;

        // Lưu lịch sử 3 mã gần nhất
        String newLog = String.format(java.util.Locale.US, "M%d:C%d:V%d", moduleId, code, value);
        if (!newLog.equals(lastLog1)) {
            lastLog3 = lastLog2;
            lastLog2 = lastLog1;
            lastLog1 = newLog;

            activity.runOnUiThread(() -> {
                if (tvCarId != null) {
                    tvCarId.setText(String.format("%s | %s | %s", lastLog1, lastLog2, lastLog3));
                }
            });
        }
        
        if (code == 1000) {
            android.util.Log.d("TopBarController", "Received Car ID: " + value);
        }
    }
}
