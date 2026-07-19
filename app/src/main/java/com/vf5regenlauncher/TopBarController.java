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

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        // Lọc bỏ các mã dữ liệu thay đổi quá thường xuyên để dễ quan sát các mã khác
        if (moduleId == 0) {
            if (code == 101 || // Tốc độ
                code == 41  || // Góc lái vô lăng
                code == 139 || // Phanh tay / Trạng thái ổn định
                code == 146    // Dữ liệu quét liên tục khác
            ) {
                return; 
            }
        }

        // Hiển thị các code và value "quan trọng" hoặc ít thay đổi lên TopBar để debug
        activity.runOnUiThread(() -> {
            if (tvCarId != null) {
                tvCarId.setText(String.format(java.util.Locale.US, "M%d:C%d:V%d", moduleId, code, value));
            }
        });
        
        if (code == 1000) {
            android.util.Log.d("TopBarController", "Received Car ID: " + value);
        }
    }
}
