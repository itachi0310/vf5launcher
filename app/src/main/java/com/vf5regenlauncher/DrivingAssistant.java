package com.vf5regenlauncher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;

public class DrivingAssistant implements CanbusConnector.CanbusDataListener {
    private static final String TAG = "DrivingAssistant";
    private final Context context;
    
    private float currentSpeedKmH = 0;
    private int currentRegenMode = -1;
    private int lastAssignedRegen = -1; // Để biết xe đổi do ta hay do người dùng
    
    private boolean optionHighwayEnabled = false;
    private boolean optionSmartEnabled = false;

    // State tracking to ensure one-time execution per threshold crossing
    private boolean isAboveHighwayThreshold = false;

    // Timer logic
    private long highwayHighStartTime = 0;
    private long highwayLowStartTime = 0;
    private long smartHighStartTime = 0;
    private long smartLowStartTime = 0;
    private long lastChangeTime = 0;
    private static final long LOCK_DURATION = 2500; // Khóa 2.5s để xe ổn định

    // History for acceleration (window 500ms)
    private static class SpeedPoint {
        float speed;
        long time;
        SpeedPoint(float s, long t) { this.speed = s; this.time = t; }
    }
    private final ArrayList<SpeedPoint> speedHistory = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public DrivingAssistant(Context context) {
        this.context = context;
        loadSettings();
        startPeriodicCheck();
    }

    private void loadSettings() {
        SharedPreferences sp = context.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        optionHighwayEnabled = sp.getBoolean("highway_assist", false);
        optionSmartEnabled = sp.getBoolean("smart_assist", false);
    }

    private void startPeriodicCheck() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                processLogic();
                handler.postDelayed(this, 100);
            }
        }, 100);
    }

    @Override
    public void onDataReceived(int moduleId, int code, int value) {
        if (moduleId == 0 && code == 101) {
            currentSpeedKmH = value;
            // Lưu lịch sử tốc độ để tính gia tốc
            speedHistory.add(new SpeedPoint(currentSpeedKmH / 3.6f, System.currentTimeMillis()));
            if (speedHistory.size() > 20) speedHistory.remove(0); // Giữ khoảng 2s dữ liệu
        } else if (moduleId == 7 && code == 110) {
            currentRegenMode = value;
        }
    }

    private float calculateAcceleration() {
        if (speedHistory.size() < 2) return 0;
        long now = System.currentTimeMillis();
        SpeedPoint latest = speedHistory.get(speedHistory.size() - 1);
        
        // Tìm điểm dữ liệu cách đây khoảng 500ms
        SpeedPoint reference = null;
        for (int i = speedHistory.size() - 1; i >= 0; i--) {
            reference = speedHistory.get(i);
            if (now - reference.time >= 500) break;
        }
        
        if (reference == null || reference == latest) return 0;
        float dt = (latest.time - reference.time) / 1000f;
        return (latest.speed - reference.speed) / dt;
    }

    private void processLogic() {
        loadSettings();
        long now = System.currentTimeMillis();
        
        // Không làm gì nếu đang trong thời gian khóa
        if (now - lastChangeTime < LOCK_DURATION) return;

        // --- OPTION 1: HIGHWAY ---
        if (optionHighwayEnabled) {
            if (currentSpeedKmH >= 75) {
                if (!isAboveHighwayThreshold) {
                    if (highwayHighStartTime == 0) highwayHighStartTime = now;
                    if (now - highwayHighStartTime >= 3000) {
                        if (currentRegenMode == 1) {
                            executeRegenChange(2, "Highway High (>=75kmh for 3s)");
                        }
                        isAboveHighwayThreshold = true; // Mark as handled for this speed bracket
                        highwayHighStartTime = 0;
                    }
                }
                highwayLowStartTime = 0;
            } else {
                // Below 75km/h
                if (isAboveHighwayThreshold) {
                    // Just crossed from above to below 75
                    if (currentRegenMode == 2) {
                        executeRegenChange(1, "Highway Low (<75kmh)");
                    }
                    isAboveHighwayThreshold = false; // Reset state for next time we cross 75
                }
                highwayHighStartTime = 0;
            }
        }

        // --- OPTION 2: SMART ---
        if (optionSmartEnabled) {
            float accel = calculateAcceleration();
            
            // Speed Guard < 20km/h
            if (currentSpeedKmH < 20) {
                if (currentRegenMode == 2) executeRegenChange(1, "Smart Guard < 20");
                return;
            }

            if (currentRegenMode == 1) { // Muốn lên HIGH
                if (accel < -0.4f) {
                    if (smartHighStartTime == 0) smartHighStartTime = now;
                    if (now - smartHighStartTime >= 500) {
                        executeRegenChange(2, "Smart Decel HIGH (a=" + accel + ")");
                        smartHighStartTime = 0;
                    }
                } else {
                    smartHighStartTime = 0;
                }
            } else if (currentRegenMode == 2) { // Muốn về LOW
                if (accel > -0.1f) {
                    if (smartLowStartTime == 0) smartLowStartTime = now;
                    if (now - smartLowStartTime >= 2000) {
                        executeRegenChange(1, "Smart Resume LOW (a=" + accel + ")");
                        smartLowStartTime = 0;
                    }
                } else {
                    smartLowStartTime = 0;
                }
            }
        }
    }

    private void executeRegenChange(int mode, String reason) {
        if (currentRegenMode == mode) return;
        Log.d(TAG, "AUTO CHANGE: " + reason);
        lastChangeTime = System.currentTimeMillis();
        lastAssignedRegen = mode;
        CanbusConnector.getInstance(context).sendCarCommand(34, mode);
    }
}
