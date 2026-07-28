package com.vf5regenlauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/**
 * AppEmbedManager matching com.syu.g.n and com.syu.g.o logic from reference launcher.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;
    private boolean isPipShown = false;

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        init();
    }

    private void init() {
        if (container == null) return;
        determineMapPackage();
        // Measure and save for next boot
        container.post(this::measureAndSaveCoordinates);
    }

    private void determineMapPackage() {
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", "");
        if (currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "com.vietmap.vietmaplive");
        }
        if (currentPackage.isEmpty()) currentPackage = "com.vietmap.vietmaplive";
        
        // Sync to system
        setSystemProperty("persist.launcher.packagename", currentPackage);
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
        
        Log.d(TAG, "Saving PIP coordinates: " + rect);
        SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        sp.edit().putString("pip_rect", rect).apply();
        
        // Match reference: only set rect, not show/mode
        setSystemProperty("sys.lsec.pip_rect", rect);
    }

    /**
     * Logic from com.syu.g.n.a(View)
     */
    public void showPip() {
        if (currentPackage == null || currentPackage.isEmpty()) return;
        
        if (isPipShown) {
            Log.d(TAG, "PIP already shown, skipping startActivity");
            return;
        }

        Log.d(TAG, "Starting PIP for: " + currentPackage);
        isPipShown = true;
        
        // Match com.syu.g.o logic
        new Thread(() -> {
            Intent intent = createMapIntent(currentPackage);
            if (intent != null) {
                intent.putExtra("force_pip", true);
                try {
                    activity.startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to start map activity", e);
                    isPipShown = false;
                }
            } else {
                isPipShown = false;
            }
        }).start();
    }

    /**
     * Logic from com.syu.g.n.b(View)
     */
    public void hidePip() {
        if (!isPipShown) return;

        Log.d(TAG, "Hiding PIP stack");
        try {
            Object am = null;
            try {
                Method getService = activity.getSystemService(Context.ACTIVITY_SERVICE).getClass().getMethod("getService");
                am = getService.invoke(null);
            } catch (Exception ignored) {}

            if (am == null) {
                try {
                    Class<?> amnClass = Class.forName("android.app.ActivityManagerNative");
                    Method getDefault = amnClass.getMethod("getDefault");
                    am = getDefault.invoke(null);
                } catch (Exception ignored) {}
            }

            if (am != null) {
                Method setPinnedStackVisible = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
                setPinnedStackVisible.invoke(am, false);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to hide PIP via reflection", e);
        }
        isPipShown = false;
    }

    /**
     * Match com.syu.g.g.a(Context, String) logic
     */
    private Intent createMapIntent(String pkg) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage(pkg);
        
        PackageManager pm = activity.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        
        for (ResolveInfo ri : activities) {
            if (ri.activityInfo.packageName.equals(pkg)) {
                Intent launchIntent = new Intent(Intent.ACTION_MAIN);
                // Exact flags from reference: 270532608 = 0x10200000
                // FLAG_ACTIVITY_NEW_TASK (0x10000000) | FLAG_ACTIVITY_RESET_TASK_IF_NEEDED (0x00200000)
                launchIntent.setFlags(270532608);
                launchIntent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));
                return launchIntent;
            }
        }
        
        // Fallback
        return pm.getLaunchIntentForPackage(pkg);
    }

    // === System Property Helpers ===

    private void setSystemProperty(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
        } catch (Exception e) {
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

    public void refreshPipState() {
        showPip();
    }
    
    public void launchApp(String pkg) {
        this.currentPackage = pkg;
        setSystemProperty("persist.launcher.packagename", pkg);
        isPipShown = false; // Force re-launch
        showPip();
    }
}
