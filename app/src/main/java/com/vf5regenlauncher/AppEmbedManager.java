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
 * Final Integrated AppEmbedManager.
 * Combines exact porting of com.syu.g.n logic with project 17's enforcement properties.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    
    public static String f541a = ""; 
    public static boolean b = false; 
    private static Intent c;         

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        c = new Intent();
        refreshPackageName();
    }

    public void refreshPackageName() {
        f541a = SystemPropertiesUtil.get("persist.launcher.packagename", "");
        if (f541a.isEmpty()) {
            f541a = "com.vietmap.vietmaplive";
            SystemPropertiesUtil.set("persist.launcher.packagename", f541a);
        }
        if (container != null) {
            container.post(this::measureAndSaveCoordinates);
        }
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
        
        SystemPropertiesUtil.set("sys.lsec.pip_rect", rect);
        SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        sp.edit().putString("pip_rect", rect).apply();
    }

    /**
     * Port of com.syu.g.n.a(View view) - startMapPip
     * Refined with onRestart logic to prevent full-screen bung.
     */
    public void showPip() {
        if (f541a == null || f541a.isEmpty()) return;

        // Use the system visibility check as the primary filter
        if (isPinnedStackVisible() && b) {
            Log.d(TAG, "WindowUtil --- Open window filtered (already visible in PIP)");
            return;
        }

        Log.d(TAG, "showPip (startMapPip): " + f541a);
        
        // 1. Prepare system context IMMEDIATELY (Before Thread)
        SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
        SystemPropertiesUtil.set("sys.lsec.pip_show", "1");
        
        new Thread(() -> {
            try {
                // Port of com.syu.util.WindowUtil strategy:
                // Use a handler to schedule the startActivity with a small delay
                mainHandler.postDelayed(() -> {
                    c = createMapIntent(f541a);
                    if (c != null) {
                        if (f541a.equals("com.syu.camera360")) {
                            activity.sendBroadcast(new Intent("com.syu.camera360.show"));
                        }

                        c.putExtra("force_pip", true);
                        // Add legacy keys for broader compatibility
                        c.putExtra("pip_mode", 1);
                        c.putExtra("isPipMode", true);
                        
                        try {
                            // Ensure stack is visible just before starting
                            setPinnedStackVisible(true);
                            
                            activity.startActivity(c);
                            Log.d(TAG, "✓ startActivity for PIP executed from Handler");
                            
                            // Re-enforce visibility shortly after launch
                            mainHandler.postDelayed(() -> setPinnedStackVisible(true), 200);
                        } catch (Exception e) {
                            Log.e(TAG, "Failed to startActivity", e);
                        }
                    }
                }, 50); // 50ms is enough to let properties settle
            } catch (Exception e) {
                Log.e(TAG, "Thread error in showPip", e);
            }
        }).start();
        b = true;
    }

    public void hidePip() {
        if (f541a == null || f541a.isEmpty() || !b) return;

        Log.d(TAG, "removePip - Clearing PIP state");
        SystemPropertiesUtil.set("sys.lsec.force_pip", "false");

        try {
            if (f541a.equals("com.syu.camera360")) {
                activity.sendBroadcast(new Intent("com.syu.camera360.hide"));
            }
            setPinnedStackVisible(false);
        } catch (Exception e) {
            Log.e(TAG, "Reflection failed in hidePip", e);
        }
        b = false;
    }

    private boolean isPinnedStackVisible() {
        try {
            Object am = getIActivityManager();
            if (am != null) {
                Method m = am.getClass().getMethod("getPinnedStackVisible");
                return (Boolean) m.invoke(am);
            }
        } catch (Exception ignored) {}
        return false;
    }

    private void setPinnedStackVisible(boolean visible) {
        try {
            Object am = getIActivityManager();
            if (am != null) {
                Method m = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
                m.invoke(am, visible);
            }
        } catch (Exception ignored) {}
    }

    private Object getIActivityManager() {
        try {
            return Class.forName("android.app.ActivityManager").getMethod("getService").invoke(null);
        } catch (Exception ignored) {}
        try {
            return Class.forName("android.app.ActivityManagerNative").getMethod("getDefault").invoke(null);
        } catch (Exception ignored) {}
        return null;
    }

    private Intent createMapIntent(String pkg) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage(pkg);
        PackageManager pm = activity.getPackageManager();
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

    public void launchApp(String pkg) {
        f541a = pkg;
        SystemPropertiesUtil.set("persist.launcher.packagename", pkg);
        b = false; 
        showPip();
    }
    
    public void refreshPipState() {
        showPip();
    }
}
