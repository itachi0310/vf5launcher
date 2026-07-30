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
 * Enhanced AppEmbedManager using "Double-Force" strategy.
 * Combines Intent Flags with direct Stack Manipulation.
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;
    private String lastRect = "";
    private boolean isPipShown = false;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        
        SharedPreferences sp = activity.getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        this.lastRect = sp.getString("pip_rect", "");
        
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
            setSystemProperty("sys.lsec.pip_rect", rect);
        }
    }

    public void showPip() {
        if (currentPackage == null || currentPackage.isEmpty()) return;

        Log.d(TAG, "showPip() called for: " + currentPackage);
        
        // 1. Force system properties BEFORE launch
        setSystemProperty("sys.lsec.pip_rect", lastRect);
        setSystemProperty("sys.lsec.force_pip", "true");
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        setSystemProperty("sys.lsec.pip_touch", "1");

        // 2. Launch Map after a small delay to allow properties to settle
        mainHandler.postDelayed(() -> {
            new Thread(() -> {
                Intent intent = createMapIntent(currentPackage);
                if (intent != null) {
                    intent.putExtra("force_pip", true);
                    intent.putExtra("pip_rect", lastRect);
                    intent.putExtra("pip_mode", 1);
                    
                    try {
                        activity.startActivity(intent);
                        isPipShown = true;
                        
                        // 3. Force Stack Visibility (The "Double-Force" part)
                        setPinnedStackVisible(true);
                        
                        // 4. Repeatedly enforce PIP state
                        enforcePipState(3); 
                    } catch (Exception e) {
                        Log.e(TAG, "Failed to start map activity", e);
                        isPipShown = false;
                    }
                }
            }).start();
        }, 200);
    }

    private void enforcePipState(int retries) {
        if (retries <= 0) return;
        
        mainHandler.postDelayed(() -> {
            if (!isPipShown) return;
            
            sendPipBroadcast(true);
            setSystemProperty("sys.lsec.pip_show", "1");
            setSystemProperty("sys.lsec.force_pip", "true");
            setPinnedStackVisible(true); // Force it back if it tried to bung
            
            Log.d(TAG, "Enforcing PIP state, retries left: " + (retries - 1));
            enforcePipState(retries - 1);
        }, 500);
    }

    public void hidePip() {
        Log.d(TAG, "hidePip() called");
        isPipShown = false;
        
        setSystemProperty("sys.lsec.pip_show", "0");
        setSystemProperty("sys.lsec.force_pip", "false");
        sendPipBroadcast(false);
        
        setPinnedStackVisible(false);
    }

    private void setPinnedStackVisible(boolean visible) {
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
                setPinnedStackVisible.invoke(am, visible);
                Log.d(TAG, "✓ setPinnedStackVisible(" + visible + ") success");
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to set stack visibility", e);
        }
    }

    private Intent createMapIntent(String pkg) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setPackage(pkg);
        
        PackageManager pm = activity.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        
        for (ResolveInfo ri : activities) {
            if (ri.activityInfo.packageName.equals(pkg)) {
                Intent launchIntent = new Intent(Intent.ACTION_MAIN);
                // Flag 270532608 = 0x10200000
                launchIntent.setFlags(270532608);
                launchIntent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));
                return launchIntent;
            }
        }
        return pm.getLaunchIntentForPackage(pkg);
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
        // Broadcast backdoor
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
