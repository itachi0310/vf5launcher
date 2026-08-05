package com.vf5regenlauncher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.fyt.car.IUiRefresher;
import com.syu.car.CarStates;
import com.fyt.car.LauncherNotify;

import java.util.ArrayList;

/**
 * Port of DrivingAssistant to Launcher17 architecture.
 */
public class DrivingAssistant implements IUiRefresher {
    private static final String TAG = "DrivingAssistant";
    private final Context context;
    
    private float currentSpeedKmH = 0;
    private int currentRegenMode = -1;
    
    private boolean optionHighwayEnabled = false;
    private boolean optionSmartEnabled = false;

    private boolean isAboveHighwayThreshold = false;
    private float lastSpeedKmHForSmart = -1;
    private int decelCount = 0;

    private long highwayHighStartTime = 0;
    private long smartLowStartTime = 0;
    private long lastChangeTime = 0;
    private static final long LOCK_DURATION = 2500; 

    private static class SpeedPoint {
        float speed;
        long time;
        SpeedPoint(float s, long t) { this.speed = s; this.time = t; }
    }
    private final ArrayList<SpeedPoint> speedHistory = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public DrivingAssistant(Context context) {
        this.context = context.getApplicationContext();
        loadSettings();
        startPeriodicCheck();
        
        // Register to notifiers
        LauncherNotify.NOTIFY_MAINSTATE.addUiRefresher(this, true);
        LauncherNotify.NOTIFIER_REGEN_DATA.addUiRefresher(this, true);
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
    public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts) {
        if (ints == null || ints.length < 2) return;
        int code = ints[0];
        int value = ints[1];

        if (code == 101) { // Speed (Module 0)
            currentSpeedKmH = value;
            speedHistory.add(new SpeedPoint(currentSpeedKmH / 3.6f, System.currentTimeMillis()));
            if (speedHistory.size() > 20) speedHistory.remove(0);
        } else if (code == 110) { // Regen Mode (Module 7)
            currentRegenMode = value;
        }
    }

    private float calculateAcceleration() {
        if (speedHistory.size() < 2) return 0;
        long now = System.currentTimeMillis();
        SpeedPoint latest = speedHistory.get(speedHistory.size() - 1);
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
        if (now - lastChangeTime < LOCK_DURATION) return;

        if (optionHighwayEnabled) {
            if (currentSpeedKmH >= 75) {
                if (!isAboveHighwayThreshold) {
                    if (highwayHighStartTime == 0) highwayHighStartTime = now;
                    if (now - highwayHighStartTime >= 3000) {
                        if (currentRegenMode == 1) executeRegenChange(2, "Highway High");
                        isAboveHighwayThreshold = true;
                        highwayHighStartTime = 0;
                    }
                }
            } else {
                if (isAboveHighwayThreshold) {
                    if (currentRegenMode == 2) executeRegenChange(1, "Highway Low");
                    isAboveHighwayThreshold = false;
                }
                highwayHighStartTime = 0;
            }
        }

        if (optionSmartEnabled) {
            if (currentSpeedKmH < 20) {
                if (currentRegenMode == 2) executeRegenChange(1, "Smart Guard");
                lastSpeedKmHForSmart = currentSpeedKmH;
                decelCount = 0;
                return;
            }
            if (lastSpeedKmHForSmart != -1) {
                float speedDiff = lastSpeedKmHForSmart - currentSpeedKmH;
                if (speedDiff >= 3.0f) decelCount++;
                else if (speedDiff < -1.0f) decelCount = 0;
                if (decelCount >= 3) {
                    if (currentRegenMode == 1) executeRegenChange(2, "Smart Decel");
                    decelCount = 0;
                }
            }
            lastSpeedKmHForSmart = currentSpeedKmH;
            if (currentRegenMode == 2) {
                if (calculateAcceleration() > -0.1f) {
                    if (smartLowStartTime == 0) smartLowStartTime = now;
                    if (now - smartLowStartTime >= 2000) {
                        executeRegenChange(1, "Smart Stable");
                        smartLowStartTime = 0;
                    }
                } else smartLowStartTime = 0;
            }
        }
    }

    private void executeRegenChange(int mode, String reason) {
        if (currentRegenMode == mode) return;
        Log.d(TAG, "AUTO CHANGE: " + reason);
        lastChangeTime = System.currentTimeMillis();
        CarStates.getCar(context).getTools().sendInt(1, 34, mode);
    }
}
