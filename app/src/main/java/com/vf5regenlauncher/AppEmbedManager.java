package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Simplified AppEmbedManager following FYT/SYU framework flow.
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

        // Step 2: Read target package
        determineMapPackage();

        // Step 1 (Refinement): Measure and save for next boot
        container.post(this::measureAndSaveCoordinates);
    }

    private void determineMapPackage() {
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", "");

        if (currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "com.vietmap.vietmaplive");
        }
        
        if (currentPackage.isEmpty()) {
            currentPackage = "com.vietmap.vietmaplive";
        }
        
        // Sync back to system property
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
            
            // Save for LauncherApplication's next boot
            SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
            sp.edit().putString("pip_rect", rect).apply();
            
            // Apply to current session
            setSystemProperty("sys.lsec.pip_rect", rect);
        }
    }

    /**
     * Step 3 & 4: Logic for showing PIP
     * Called in Activity.onResume()
     */
    public void showPip() {
        if (currentPackage == null || currentPackage.isEmpty()) return;

        Log.d(TAG, "Showing PIP for: " + currentPackage);
        
        // Ensure system properties are set
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        
        // Broadcasts for immediate update
        sendPipBroadcast(true);

        // Force launch into PIP area
        launchMapInPip();
    }

    /**
     * Logic for hiding PIP
     * Called in Activity.onPause()
     */
    public void hidePip() {
        Log.d(TAG, "Hiding PIP");
        setSystemProperty("sys.lsec.pip_show", "0");
        sendPipBroadcast(false);
    }

    private void launchMapInPip() {
        try {
            PackageManager pm = activity.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(currentPackage);
            if (intent == null) return;

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            // The magical flags
            intent.putExtra("force_pip", true);
            intent.putExtra("pip_mode", 1);
            intent.putExtra("pip_show", true);
            if (!lastRect.isEmpty()) {
                intent.putExtra("pip_rect", lastRect);
            }

            activity.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error launching map", e);
        }
    }

    private void sendPipBroadcast(boolean show) {
        try {
            Intent intent = new Intent("com.syu.pip.show");
            intent.putExtra("show", show);
            intent.putExtra("packagename", currentPackage);
            if (show && !lastRect.isEmpty()) {
                intent.putExtra("rect", lastRect);
            }
            activity.sendBroadcast(intent);

            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", show ? lastRect : "0 0 0 0");
            rectIntent.putExtra("show", show);
            activity.sendBroadcast(rectIntent);
        } catch (Exception ignored) {}
    }

    // === System Property Helpers ===

    private void setSystemProperty(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
        } catch (Exception e) {
            // Fallback to Settings.System for non-privileged apps
            try {
                android.provider.Settings.System.putString(activity.getContentResolver(), key, value);
            } catch (Exception ignored) {}
        }
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

    // Compat with previous calls
    public void refreshPipState() {
        showPip();
    }
    
    public void launchApp(String pkg) {
        this.currentPackage = pkg;
        setSystemProperty("persist.launcher.packagename", pkg);
        showPip();
    }
}
