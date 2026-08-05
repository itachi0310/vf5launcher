package com.vf5regenlauncher;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.reflect.Method;

public class LauncherApplication extends Application {
    private static final String TAG = "LauncherApplication";
    private static LauncherApplication mInstance;

    public static LauncherApplication getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        
        // SYU Architecture: Application class often registers itself as a lifecycle observer
        // or uses static triggers like com.syu.g.n.a()
        
        // Match original LauncherApplication.onCreate() logic
        SystemPropertiesUtil.set("persist.syu.launcher.haspip", "true");
        
        // Initial rect setup
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels == 1280 && displayMetrics.heightPixels == 720) {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "128 88 802 474");
        } else {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "98 76 656 396");
        }
        
        // Initialize the PiP state like SYU g.n.a()
        // This sets up the initial Intent and reads the persist.launcher.packagename
        SystemPropertiesUtil.set("sys.lsec.force_pip", "true");
        
        // Final Integrated Init: One-time setup of persistent members
        AppEmbedManager.init();
    }
}
