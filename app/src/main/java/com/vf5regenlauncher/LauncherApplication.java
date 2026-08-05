package com.vf5regenlauncher;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.syu.car.CarStates;
import com.syu.util.WindowUtil;

/**
 * Standardized LauncherApplication following Launcher17 architecture.
 */
public class LauncherApplication extends Application {
    private static final String TAG = "LauncherApplication";
    public static LauncherApplication sApp;
    public static Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        
        Log.d(TAG, "Starting VF5 Regen Launcher (SYU Core Architecture)");
        
        // 0. Initialize App State
        LauncherAppState.setApplicationContext(this);
        LauncherAppState.getInstance();

        // 1. Initialize Car State IPC Binding
        CarStates.getCar(this);
        
        // 2. Initialize Window/PiP Framework
        WindowUtil.initDefaultApp();
        
        // 3. System Property Defaults
        SystemPropertiesUtil.set("persist.syu.launcher.haspip", "true");
        SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
        
        setupDefaultPipRect();
    }

    private void setupDefaultPipRect() {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels == 1280) {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "128 88 802 474");
        } else {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "98 76 656 396");
        }
    }

    public static Context getAppContext() {
        return sApp.getApplicationContext();
    }
}
