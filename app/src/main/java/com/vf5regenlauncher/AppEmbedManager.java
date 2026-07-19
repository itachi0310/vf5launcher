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
 * Manages embedding map applications (Vietmap, Google Maps, etc.) into the Ember container.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        init();
    }

    private void setSystemProperty(String key, String value) {
        boolean success = false;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
            success = true;
        } catch (Exception e) {
            Log.w(TAG, "⚠ SystemProperties.set failed for " + key);
        }

        if (!success) {
            try {
                android.provider.Settings.System.putString(activity.getContentResolver(), key, value);
                success = true;
            } catch (Exception e) {
                Log.w(TAG, "⚠ Settings.System.putString failed for " + key);
            }
        }

        try {
            String[] actions = {"com.syu.set_system_property", "com.syu.ms.action.SET_PROP"};
            for (String action : actions) {
                Intent intent = new Intent(action);
                intent.putExtra("key", key);
                intent.putExtra("value", value);
                activity.sendBroadcast(intent);
            }
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

    private void init() {
        if (container == null) return;
        determineMapPackage();
        if (currentPackage == null || currentPackage.isEmpty()) return;
        container.post(this::setupAndLaunchPip);
    }

    private void determineMapPackage() {
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", null);
        if (currentPackage == null || currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "com.vietmap.vietmaplive");
        }
    }

    /**
     * Refresh the PIP region settings and ensure the app is visible.
     * Uses flags (0x10200000) and logic from standard SYU Launcher3.
     */
    public void refreshPipState() {
        if (container == null || currentPackage == null || currentPackage.isEmpty()) return;
        
        container.post(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if (count >= 3) return; 
                
                int[] location = new int[2];
                container.getLocationOnScreen(location);
                String pipRect = String.format(Locale.US, "%d %d %d %d", 
                        location[0], location[1], location[0] + container.getWidth(), location[1] + container.getHeight());
                
                setSystemProperty("sys.lsec.force_pip", "true");
                setSystemProperty("sys.lsec.pip_rect", pipRect);
                setSystemProperty("sys.lsec.pip_show", "1");
                setSystemProperty("sys.lsec.pip_mode", "1");

                try {
                    PackageManager pm = activity.getPackageManager();
                    Intent intent = pm.getLaunchIntentForPackage(currentPackage);
                    if (intent != null) {
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        intent.setFlags(270532608); // 0x10200000: NEW_TASK | RESET_TASK_IF_NEEDED
                        intent.putExtra("force_pip", true);
                        intent.putExtra("pip_mode", 1);
                        intent.putExtra("pip_rect", pipRect);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        activity.startActivity(intent);
                    }
                    Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
                    rectIntent.putExtra("pip_rect", pipRect);
                    rectIntent.putExtra("show", true);
                    activity.sendBroadcast(rectIntent);
                } catch (Exception e) {
                    Log.e(TAG, "PIP Refresh Error", e);
                }
                count++;
                container.postDelayed(this, 600);
            }
        });
    }

    public void hidePip() {
        Log.d(TAG, "Hiding PIP");
        setSystemProperty("sys.lsec.pip_show", "0");
        setSystemProperty("sys.lsec.pip_mode", "0");
        setSystemProperty("sys.lsec.pip_touch", "0");
        try {
            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", "0 0 0 0");
            rectIntent.putExtra("show", false);
            activity.sendBroadcast(rectIntent);
            Intent showIntent = new Intent("com.syu.pip.show");
            showIntent.putExtra("show", false);
            showIntent.putExtra("packagename", ""); 
            activity.sendBroadcast(showIntent);
        } catch (Exception ignored) {}
    }

    private void setupAndLaunchPip() {
        if (container == null) return;
        int[] location = new int[2];
        container.getLocationOnScreen(location);
        int w = container.getWidth();
        int h = container.getHeight();
        if (w <= 0 || h <= 0) {
            container.postDelayed(this::setupAndLaunchPip, 300);
            return;
        }
        String pipRect = String.format(Locale.US, "%d %d %d %d", location[0], location[1], location[0] + w, location[1] + h);
        applyPipSettings(pipRect);
        new Handler(Looper.getMainLooper()).postDelayed(this::launchMapApp, 300);
        android.view.View statusView = container.findViewById(R.id.tv_widget_status);
        if (statusView != null) statusView.setVisibility(android.view.View.GONE);
    }

    private void applyPipSettings(String pipRect) {
        setSystemProperty("sys.lsec.pip_rect", pipRect);
        setSystemProperty("persist.launcher.packagename", currentPackage);
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        setSystemProperty("sys.lsec.pip_touch", "1");
        try {
            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", pipRect);
            rectIntent.putExtra("show", true);
            rectIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(rectIntent);
            Intent showIntent = new Intent("com.syu.pip.show");
            showIntent.putExtra("show", true);
            showIntent.putExtra("rect", pipRect);
            showIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(showIntent);
        } catch (Exception ignored) {}
    }

    private void launchMapApp() {
        if (currentPackage == null || currentPackage.isEmpty()) return;
        try {
            PackageManager pm = activity.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(currentPackage);
            if (intent == null) return;
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setFlags(270532608);
            intent.putExtra("force_pip", true);
            intent.putExtra("pip_mode", 1);
            intent.putExtra("pip_show", true);
            activity.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error launching map app", e);
        }
    }

    public void launchApp(String packageName) {
        this.currentPackage = packageName;
        setSystemProperty("persist.launcher.packagename", packageName);
        launchMapApp();
    }

    public String getCurrentPackage() {
        return currentPackage;
    }
}
