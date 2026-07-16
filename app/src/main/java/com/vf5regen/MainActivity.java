package com.vf5regen;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.vf5regenlauncher.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvSpeed, tvBattery, tvBrake, tvExplorerStatus, tvExplorerLog, tvDrivingLog;
    private EditText etMin, etMax;
    private Button btnStartScan;
    
    private final List<String> explorerLogs = new ArrayList<>();
    private final List<String> drivingLogs = new ArrayList<>();
    private final List<Integer> foundModules = new ArrayList<>();
    private static final int MAX_LOGS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Logger.init(this);

        tvSpeed = findViewById(R.id.tv_speed);
        tvBattery = findViewById(R.id.tv_battery);
        tvBrake = findViewById(R.id.tv_brake);
        
        tvExplorerStatus = findViewById(R.id.tv_explorer_status);
        tvExplorerLog = findViewById(R.id.tv_explorer_log);
        tvDrivingLog = findViewById(R.id.tv_driving_debug_log);

        etMin = findViewById(R.id.et_scan_min);
        etMax = findViewById(R.id.et_scan_max);
        btnStartScan = findViewById(R.id.btn_start_scan);

        // Core Monitoring (Module 7 & 0)
        CanbusManager.getInstance(this).connect(new CanbusManager.OnDataListener() {
            @Override
            public void onDataUpdate(int code, int value) {
                runOnUiThread(() -> {
                    if (code == CanbusManager.U_BATTERY_SOC) tvBattery.setText("SOC: " + value + "%");
                });
            }
            @Override
            public void onConnectionStatus(boolean connected) {}
        });

        DrivingManager.getInstance(this).connect(new DrivingManager.OnDataListener() {
            @Override
            public void onDataUpdate(int code, int value) {
                runOnUiThread(() -> {
                    if (code == DrivingManager.D_SPEED) tvSpeed.setText(value + " km/h");
                    if (code == 114 || code == 115 || code == 139) {
                        tvBrake.setText(value > 0 ? "BRAKING (" + code + ")" : "RELEASED");
                        tvBrake.setTextColor(value > 0 ? Color.RED : Color.GREEN);
                    }
                    if (code != 41) {
                        String entry = "D[" + code + "]: " + value;
                        updateLog(drivingLogs, tvDrivingLog, entry);
                    }
                });
            }
            @Override
            public void onConnectionStatus(boolean connected) {}
        });

        // Dynamic Scanner
        Module5Manager.getInstance(this).connect(new Module5Manager.OnExplorerListener() {
            @Override
            public void onDataUpdate(int moduleId, int code, int value) {
                runOnUiThread(() -> {
                    String entry = "M[" + moduleId + "] C:" + code + " = " + value;
                    Logger.log(entry);
                    updateLog(explorerLogs, tvExplorerLog, entry);
                });
            }

            @Override
            public void onServiceStatus(boolean connected) {
                runOnUiThread(() -> {
                    if (connected) tvExplorerStatus.setText("SYU Service Connected. Ready.");
                    else tvExplorerStatus.setText("SYU Service Disconnected.");
                });
            }

            @Override
            public void onNewModuleDiscovered(int moduleId) {
                runOnUiThread(() -> {
                    if (!foundModules.contains(moduleId)) {
                        foundModules.add(moduleId);
                        updateModuleHeader();
                        
                        String msg = ">>> CONNECTED MODULE: " + moduleId + " (Registered IDs 0-1000)";
                        explorerLogs.add(0, msg);
                        Logger.log(msg);
                        
                        StringBuilder sb = new StringBuilder();
                        for (String log : explorerLogs) sb.append(log).append("\n");
                        tvExplorerLog.setText(sb.toString());
                    }
                });
            }
        });

        btnStartScan.setOnClickListener(v -> startManualScan());
    }

    private void startManualScan() {
        try {
            int min = Integer.parseInt(etMin.getText().toString());
            int max = Integer.parseInt(etMax.getText().toString());

            if (min > max) {
                Toast.makeText(this, "Min cannot be greater than Max", Toast.LENGTH_SHORT).show();
                return;
            }

            foundModules.clear();
            explorerLogs.clear();
            tvExplorerLog.setText("Starting scan..."); 
            updateModuleHeader();
            
            Logger.log(">>> MANUAL SCAN STARTED: " + min + " to " + max);

            Module5Manager.getInstance(this).startScan(min, max);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateModuleHeader() {
        StringBuilder sb = new StringBuilder("Found Modules: ");
        if (foundModules.isEmpty()) sb.append("None");
        else {
            for (int id : foundModules) sb.append(id).append(", ");
        }
        tvExplorerStatus.setText(sb.toString());
    }

    private void updateLog(List<String> logList, TextView textView, String entry) {
        logList.add(0, entry);
        if (logList.size() > MAX_LOGS) logList.remove(logList.size() - 1);
        
        StringBuilder sb = new StringBuilder();
        for (String log : logList) sb.append(log).append("\n");
        textView.setText(sb.toString());
    }
}
