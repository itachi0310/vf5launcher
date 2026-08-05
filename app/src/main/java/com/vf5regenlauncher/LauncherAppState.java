package com.vf5regenlauncher;

import android.content.Context;
import android.util.Log;

/**
 * Port of LauncherAppState from launcher17.
 * Manages global singleton state for the launcher.
 */
public class LauncherAppState {
    private static LauncherAppState INSTANCE;
    private static Context sContext;

    public static LauncherAppState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LauncherAppState();
        }
        return INSTANCE;
    }

    public static void setApplicationContext(Context context) {
        if (sContext != null) {
            Log.w("Launcher", "setApplicationContext called twice!");
        }
        sContext = context.getApplicationContext();
    }

    private LauncherAppState() {
        if (sContext == null) {
            throw new IllegalStateException("LauncherAppState inited before app context set");
        }
        Log.v("Launcher", "LauncherAppState inited");
    }

    public Context getContext() {
        return sContext;
    }
}
