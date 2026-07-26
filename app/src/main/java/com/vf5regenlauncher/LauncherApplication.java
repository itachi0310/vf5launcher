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
        
        // Step 1: Set PIP rectangle from saved coordinates
        SharedPreferences sp = getSharedPreferences("pip_prefs", Context.MODE_PRIVATE);
        String savedRect = sp.getString("pip_rect", "");
        
        if (!savedRect.isEmpty()) {
            Log.d(TAG, "Restoring saved PIP rect: " + savedRect);
            setSystemProperty("sys.lsec.pip_rect", savedRect);
        } else {
            // Default for 1280x720 if not yet measured
            setSystemProperty("sys.lsec.pip_rect", "128 88 802 474");
        }
        
        // Ensure system knows we have PIP capability
        setSystemProperty("persist.syu.launcher.haspip", "true");
    }

    private void setSystemProperty(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set property: " + key, e);
        }
    }
}
