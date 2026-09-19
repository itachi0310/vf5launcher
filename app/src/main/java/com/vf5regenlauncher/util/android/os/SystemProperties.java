package com.vf5regenlauncher.util.android.os;

import java.lang.reflect.Method;

/**
 * Reflection-based wrapper for android.os.SystemProperties to allow compilation
 * and correct runtime behavior on Android devices.
 */
public class SystemProperties {
    private static Class<?> classType;
    private static Method getMethod;
    private static Method getIntMethod;
    private static Method getLongMethod;
    private static Method getBooleanMethod;
    private static Method setMethod;

    static {
        try {
            classType = Class.forName("android.os.SystemProperties");
            getMethod = classType.getDeclaredMethod("get", String.class, String.class);
            getIntMethod = classType.getDeclaredMethod("getInt", String.class, int.class);
            getLongMethod = classType.getDeclaredMethod("getLong", String.class, long.class);
            getBooleanMethod = classType.getDeclaredMethod("getBoolean", String.class, boolean.class);
            setMethod = classType.getDeclaredMethod("set", String.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return get(key, "");
    }

    public static String get(String key, String def) {
        try {
            if (getMethod != null) {
                return (String) getMethod.invoke(classType, key, def);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    public static int getInt(String key, int def) {
        try {
            if (getIntMethod != null) {
                return (Integer) getIntMethod.invoke(classType, key, def);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    public static long getLong(String key, long def) {
        try {
            if (getLongMethod != null) {
                return (Long) getLongMethod.invoke(classType, key, def);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    public static boolean getBoolean(String key, boolean def) {
        try {
            if (getBooleanMethod != null) {
                return (Boolean) getBooleanMethod.invoke(classType, key, def);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    public static void set(String key, String val) {
        try {
            if (setMethod != null) {
                setMethod.invoke(classType, key, val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
