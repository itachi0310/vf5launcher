package com.vf5regenlauncher;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/**
 * Static Integrated AppEmbedManager.
 * Matches the 'init once, reuse always' pattern of professional SYU launchers.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    
    // Global shared states (init once)
    public static String currentPackage = ""; 
    public static boolean isPipShowing = false; 
    private static Intent persistentIntent;         
    private static Object iActivityManager;

    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /**
     * Call this in LauncherApplication.onCreate()
     */
    public static void init() {
        persistentIntent = new Intent();
        refreshPackageName();
        Log.d(TAG, "Initialized with package: " + currentPackage);
    }

    public static void refreshPackageName() {
        currentPackage = SystemPropertiesUtil.get("persist.launcher.packagename", "");
        if (currentPackage.isEmpty()) {
            currentPackage = "com.vietmap.vietmaplive"; // Default fallback
            SystemPropertiesUtil.set("persist.launcher.packagename", currentPackage);
        }
        updatePipIntent();
    }

    /**
     * Setup coordinate listener for the UI container
     */
    public static void attachContainer(Activity activity, FrameLayout container) {
        if (container == null) return;
        
        container.addOnLayoutChangeListener((v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
            if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
                measureAndSaveCoordinates(activity, container);
            }
        });
        
        // Initial measure
        container.post(() -> measureAndSaveCoordinates(activity, container));
    }

    private static void measureAndSaveCoordinates(Activity activity, FrameLayout container) {
        if (container == null) return;
        int[] location = new int[2];
        container.getLocationOnScreen(location);
        int w = container.getWidth();
        int h = container.getHeight();

        if (w <= 0 || h <= 0) {
            container.postDelayed(() -> measureAndSaveCoordinates(activity, container), 500);
            return;
        }

        String rect = String.format(Locale.US, "%d %d %d %d", 
                location[0], location[1], location[0] + w, location[1] + h);
        
        Log.d(TAG, "Measured PIP Rect: " + rect);
        SystemPropertiesUtil.set("sys.lsec.pip_rect", rect);
        
        SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        sp.edit().putString("pip_rect", rect).apply();
    }

    public static void showPip() {
        if (currentPackage == null || currentPackage.isEmpty()) return;

        // Use the system visibility check as the primary filter
        if (isPinnedStackVisible() && isPipShowing) {
            Log.d(TAG, "Open window filtered (already visible)");
            return;
        }

        Log.d(TAG, "showPip: " + currentPackage);
        
        // Early coordinate restoration (from professional launcher pattern)
        restorePipRect();

        // 2. Prepare system context
        SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
        SystemPropertiesUtil.set("sys.lsec.pip_show", "1");

        // Run in separate thread to avoid UI freezing and stack race conditions
        new Thread(() -> {
            updatePipIntent();
            if (persistentIntent != null) {
                if (currentPackage.equals("com.syu.camera360")) {
                    LauncherApplication.getAppContext().sendBroadcast(new Intent("com.syu.camera360.show"));
                }
                
                try {
                    // Re-enforce visibility before launch
                    setPinnedStackVisible(true);
                    
                    Log.d(TAG, "✓ Triggering PIP launch for " + currentPackage);
                    LauncherApplication.getAppContext().startActivity(persistentIntent);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to startActivity", e);
                }
            }
        }).start();

        isPipShowing = true;
    }

    private static void updatePipIntent() {
        if (currentPackage == null || currentPackage.isEmpty()) return;
        
        Context context = LauncherApplication.getAppContext();
        persistentIntent = createMapIntent(context, currentPackage);
        
        if (persistentIntent != null) {
            persistentIntent.putExtra("force_pip", true);
            persistentIntent.putExtra("pip_mode", 1);
            persistentIntent.putExtra("isPipMode", true);
            
            // Standard SYU launch flags: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
            persistentIntent.addFlags(270532608); // 0x10200000
        }
    }

    public static void hidePip() {
        if (currentPackage == null || currentPackage.isEmpty() || !isPipShowing) return;

        Log.d(TAG, "hidePip - Signal system to hide");
        SystemPropertiesUtil.set("sys.lsec.pip_show", "0");

        try {
            if (currentPackage.equals("com.syu.camera360")) {
                LauncherApplication.getAppContext().sendBroadcast(new Intent("com.syu.camera360.hide"));
            }
            setPinnedStackVisible(false);
        } catch (Exception e) {
            Log.e(TAG, "Reflection failed in hidePip", e);
        }
        isPipShowing = false;
    }

    public static void restorePipRect() {
        SharedPreferences sp = LauncherApplication.getAppContext().getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        String savedRect = sp.getString("pip_rect", "");
        if (!savedRect.isEmpty()) {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", savedRect);
            SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
        }
    }

    private static boolean isPinnedStackVisible() {
        try {
            Object am = getIActivityManager();
            if (am != null) {
                Method m = am.getClass().getMethod("getPinnedStackVisible");
                return (Boolean) m.invoke(am);
            }
        } catch (Exception ignored) {}
        return false;
    }

    private static void setPinnedStackVisible(boolean visible) {
        try {
            Object am = getIActivityManager();
            if (am != null) {
                Method m = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
                m.invoke(am, visible);
            }
        } catch (Exception ignored) {}
    }

    private static Object getIActivityManager() {
        if (iActivityManager != null) return iActivityManager;
        try {
            iActivityManager = Class.forName("android.app.ActivityManager").getMethod("getService").invoke(null);
        } catch (Exception ignored) {}
        if (iActivityManager == null) {
            try {
                iActivityManager = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault").invoke(null);
            } catch (Exception ignored) {}
        }
        return iActivityManager;
    }

    private static Intent createMapIntent(Context context, String pkg) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage(pkg);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        
        for (ResolveInfo ri : activities) {
            if (ri.activityInfo.packageName.equals(pkg)) {
                Intent launchIntent = new Intent(Intent.ACTION_MAIN);
                launchIntent.setFlags(270532608); // 0x10200000
                launchIntent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));
                return launchIntent;
            }
        }
        return pm.getLaunchIntentForPackage(pkg);
    }

    public static void launchApp(String pkg) {
        currentPackage = pkg;
        SystemPropertiesUtil.set("persist.launcher.packagename", pkg);
        isPipShowing = false;
        showPip();
    }
}
