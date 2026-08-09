package com.vf5regenlauncher;

import android.util.Log;
import java.lang.reflect.Method;

public class SystemPropertiesUtil {
    private static final String TAG = "SystemPropertiesUtil";
    private static Method sGetMethod;
    private static Method sSetMethod;

    static {
        try {
            Class<?> sClass = Class.forName("android.os.SystemProperties");
            sGetMethod = sClass.getMethod("get", String.class, String.class);
            sSetMethod = sClass.getMethod("set", String.class, String.class);
        } catch (Exception e) {
            Log.e(TAG, "Failed to initialize SystemProperties reflection", e);
        }
    }

    public static String get(String key, String def) {
        try {
            if (sGetMethod != null) {
                return (String) sGetMethod.invoke(null, key, def);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error calling SystemProperties.get for " + key, e);
        }
        return def;
    }

    public static void set(String key, String value) {
        try {
            if (sSetMethod != null) {
                sSetMethod.invoke(null, key, value);
            }
        } catch (Exception e) {
            // Log only the message to avoid excessive stack traces in logs, 
            // but keep the key/value for debugging.
            Log.e(TAG, "Error calling SystemProperties.set: " + key + "=" + value + " -> " + e.getMessage());
        }
    }
}
