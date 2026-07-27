package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Optimized AppEmbedManager for FYT/SYU framework.
 * Focuses on "forcing" existing activities back into the PIP area.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;
    private String lastRect = "";

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        init();
    }

    private void init() {
        if (container == null) return;
        determineMapPackage();
        container.post(this::measureAndSaveCoordinates);
    }

    private void determineMapPackage() {
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", "");
        if (currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "com.vietmap.vietmaplive");
        }
        if (currentPackage.isEmpty()) currentPackage = "com.vietmap.vietmaplive";
        
        setSystemProperty("persist.launcher.packagename", currentPackage);
        Log.d(TAG, "Target Map Package: " + currentPackage);
    }

    private void measureAndSaveCoordinates() {
        int[] location = new int[2];
        container.getLocationOnScreen(location);
        int w = container.getWidth();
        int h = container.getHeight();

        if (w <= 0 || h <= 0) {
            container.postDelayed(this::measureAndSaveCoordinates, 500);
            return;
        }

        String rect = String.format(Locale.US, "%d %d %d %d", 
                location[0], location[1], location[0] + w, location[1] + h);
        
        if (!rect.equals(lastRect)) {
            lastRect = rect;
            Log.d(TAG, "Saving PIP coordinates: " + rect);
            SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
            sp.edit().putString("pip_rect", rect).apply();
            
            // Sync to system
            setSystemProperty("sys.lsec.pip_rect", rect);
        }
    }

    public void showPip() {
        if (currentPackage == null || currentPackage.isEmpty()) return;

        Log.d(TAG, "Enforcing PIP for: " + currentPackage);
        
        // 1. Prepare system state (CRITICAL: Set before launching)
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        setSystemProperty("sys.lsec.pip_touch", "1"); // Ensure touch works in PIP
        
        // 2. Broadcast current state
        sendPipBroadcast(true);

        // 3. Force the app back into the designated area
        launchMapInPip();
    }

    public void hidePip() {
        Log.d(TAG, "Hiding PIP area");
        setSystemProperty("sys.lsec.pip_show", "0");
        setSystemProperty("sys.lsec.pip_touch", "0");
        sendPipBroadcast(false);
    }

    private void launchMapInPip() {
        try {
            PackageManager pm = activity.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(currentPackage);
            if (intent == null) return;

            // Flags to handle existing activities and "re-embedding" them
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // Helps bring hidden task to front correctly
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            // ⭐ THE COMPREHENSIVE PIP EXTRAS
            intent.putExtra("force_pip", true);
            intent.putExtra("pip_mode", 1);
            intent.putExtra("pip_show", true);
            intent.putExtra("fyt_pip_mode", 1);
            intent.putExtra("isPipMode", true);
            intent.putExtra("com.syu.action.PIP", true);
            
            if (!lastRect.isEmpty()) {
                intent.putExtra("pip_rect", lastRect);
                intent.putExtra("rect", lastRect); // Some apps use "rect" instead of "pip_rect"
            }

            activity.startActivity(intent);
            Log.d(TAG, "✓ StartActivity sent with PIP flags");
        } catch (Exception e) {
            Log.e(TAG, "Error enforcing PIP launch", e);
        }
    }

    private void sendPipBroadcast(boolean show) {
        try {
            // General SYU PIP Show broadcast
            Intent intent = new Intent("com.syu.pip.show");
            intent.putExtra("show", show);
            intent.putExtra("packagename", currentPackage);
            if (show && !lastRect.isEmpty()) {
                intent.putExtra("rect", lastRect);
            }
            activity.sendBroadcast(intent);

            // SYU Rect update broadcast
            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", show ? lastRect : "0 0 0 0");
            rectIntent.putExtra("show", show);
            rectIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(rectIntent);
        } catch (Exception ignored) {}
    }

    // === System Property Helpers with Broadcast Backdoor ===

    private void setSystemProperty(String key, String value) {
        // Attempt 1: Reflection
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
        } catch (Exception e) {
            // Attempt 2: Settings.System
            try {
                android.provider.Settings.System.putString(activity.getContentResolver(), key, value);
            } catch (Exception ignored) {}
        }
        
        // Attempt 3: FYT/SYU Broadcast Backdoor (Most reliable for non-system apps)
        try {
            Intent intent = new Intent("com.syu.set_system_property");
            intent.putExtra("key", key);
            intent.putExtra("value", value);
            activity.sendBroadcast(intent);
        } catch (Exception ignored) {}
    }

    private String getSystemProperty(String key, String def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            get.setAccessible(true);
            return (String) get.invoke(null, key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public void refreshPipState() {
        showPip();
    }
    
    public void launchApp(String pkg) {
        this.currentPackage = pkg;
        setSystemProperty("persist.launcher.packagename", pkg);
        showPip();
    }
}
