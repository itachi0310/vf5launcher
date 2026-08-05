package com.syu.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import com.vf5regenlauncher.LauncherApplication;
import com.vf5regenlauncher.SystemPropertiesUtil;
import java.lang.reflect.Method;
import android.os.Handler;
import android.os.Looper;

/**
 * Port of WindowUtil from launcher17.
 * Professional management of PiP windows and system stack synchronization.
 */
public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static Intent persistentIntent;
    private static Object iActivityManager;
    public static String AppPackageName = "";
    public static boolean visible = true;

    public static void initDefaultApp() {
        persistentIntent = new Intent();
        AppPackageName = SystemPropertiesUtil.get("persist.launcher.packagename", "");
        if (AppPackageName.isEmpty()) {
            AppPackageName = FytPackage.GaodeACTION;
            SystemPropertiesUtil.set("persist.launcher.packagename", AppPackageName);
        }
    }

    public static void startMapPip() {
        new Thread(() -> openPip()).start();
    }

    private static void openPip() {
        Log.d(TAG, "openPip: " + AppPackageName);
        try {
            if (!isPinnedStackVisible()) {
                persistentIntent = FytPackage.getIntent(LauncherApplication.getAppContext(), AppPackageName);
                
                // Professional Delay (100ms) to ensure stack stability
                LauncherApplication.handler.postDelayed(() -> {
                    if (persistentIntent != null) {
                        persistentIntent.putExtra("force_pip", true);
                        persistentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
                        SystemPropertiesUtil.set("sys.lsec.pip_show", "1");
                        LauncherApplication.getAppContext().startActivity(persistentIntent);
                        visible = true;
                    }
                }, 100);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to open PIP", e);
        }
    }

    public static void removePip() {
        Log.d(TAG, "removePip");
        try {
            if (isPinnedStackVisible()) {
                setPinnedStackVisible(false);
                SystemPropertiesUtil.set("sys.lsec.pip_show", "0");
                visible = false;
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to remove PIP", e);
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
}
