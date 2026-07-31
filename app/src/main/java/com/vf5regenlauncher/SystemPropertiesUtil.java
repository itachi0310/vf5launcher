package com.vf5regenlauncher;

import android.util.Log;
import java.lang.reflect.Method;

public class SystemPropertiesUtil {
    private static final String TAG = "SystemPropertiesUtil";
    private static Class<?> sClass;
    private static Method sGetMethod;
    private static Method sSetMethod;

    static {
        try {
            sClass = Class.forName("android.os.SystemProperties");
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
            Log.e(TAG, "Error calling SystemProperties.get", e);
        }
        return def;
    }

    public static void set(String key, String value) {
        try {
            if (sSetMethod != null) {
                sSetMethod.invoke(null, key, value);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error calling SystemProperties.set", e);
        }
    }
}
