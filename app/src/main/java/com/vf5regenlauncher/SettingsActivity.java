package com.vf5regenlauncher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Switch swHighway, swStoplight;
    private TextView tvCurrentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        swHighway = findViewById(R.id.sw_highway_assist);
        swStoplight = findViewById(R.id.sw_stoplight_assist);
        tvCurrentMap = findViewById(R.id.tv_current_map);

        loadSettings();

        swHighway.setOnCheckedChangeListener((buttonView, isChecked) -> saveSetting("highway_assist", isChecked));
        swStoplight.setOnCheckedChangeListener((buttonView, isChecked) -> saveSetting("stoplight_assist", isChecked));
        
        tvCurrentMap.setOnClickListener(v -> showMapPicker());

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
    }

    private void showMapPicker() {
        String[] maps = {"Google Maps", "Vietmap Live", "Vietmap S2", "Navitel", "Waze"};
        String[] packages = {
            "com.google.android.apps.maps",
            "vn.vietmap.live",
            "vn.vietmap.s2",
            "com.navitel.navigation",
            "com.waze"
        };

        new AlertDialog.Builder(this)
            .setTitle("Chọn bản đồ mặc định")
            .setItems(maps, (dialog, which) -> {
                saveMapSetting(packages[which], maps[which]);
            })
            .show();
    }

    private void loadSettings() {
        SharedPreferences sp = getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        swHighway.setChecked(sp.getBoolean("highway_assist", true));
        swStoplight.setChecked(sp.getBoolean("stoplight_assist", true));
        
        String mapName = sp.getString("default_map_name", "Chưa chọn");
        tvCurrentMap.setText("Hiện tại: " + mapName);
    }

    private void saveSetting(String key, boolean value) {
        SharedPreferences sp = getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    private void saveMapSetting(String pkg, String name) {
        SharedPreferences sp = getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        sp.edit()
            .putString("default_map_package", pkg)
            .putString("default_map_name", name)
            .apply();
        if (tvCurrentMap != null) tvCurrentMap.setText("Hiện tại: " + name);
        
        // Cập nhật lại app embed ngay lập tức nếu launcher đang chạy
        if (AndrewLauncherActivity.getInstance() != null && AndrewLauncherActivity.getInstance().getAppEmbedManager() != null) {
            AndrewLauncherActivity.getInstance().getAppEmbedManager().launchApp(pkg);
        }
    }
}
