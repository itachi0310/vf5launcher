package com.vf5regenlauncher;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
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
            sGetMethod.setAccessible(true);
            sSetMethod.setAccessible(true);
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
        if (key == null || value == null) {
            Log.w(TAG, "Attempted to set null property key or value");
            return;
        }
        try {
            if (sSetMethod != null) {
                sSetMethod.invoke(null, key, value);
            } else {
                Log.e(TAG, "sSetMethod is null, cannot set: " + key);
            }
        } catch (InvocationTargetException e) {
            Throwable cause = e.getTargetException();
            Log.e(TAG, "InvocationTargetException calling SystemProperties.set(" + key + ", " + value + "): " + cause);
            // On some devices, try fallback to shell if it's a security exception
            if (cause instanceof SecurityException) {
                try {
                    Runtime.getRuntime().exec("setprop " + key + " " + value);
                } catch (Exception ignored) {}
            }
        } catch (Exception e) {
            Log.e(TAG, "Error calling SystemProperties.set for " + key, e);
        }
    }
}
