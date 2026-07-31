package com.vf5regenlauncher;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.reflect.Method;

public class LauncherApplication extends Application {
    private static final String TAG = "LauncherApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        
        // Match original LauncherApplication.onCreate() logic
        SystemPropertiesUtil.set("persist.syu.launcher.haspip", "true");
        
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels == 1280 && displayMetrics.heightPixels == 720) {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "128 88 802 474");
        } else {
            SystemPropertiesUtil.set("sys.lsec.pip_rect", "98 76 656 396");
        }
    }
}
