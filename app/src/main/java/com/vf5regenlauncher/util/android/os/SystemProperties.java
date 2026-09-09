package com.vf5regenlauncher.util.android.os;

/**
 * Stub class for android.os.SystemProperties to allow compilation.
 * This class is not included in the standard Android SDK.
 */
public class SystemProperties {
    public static String get(String key) {
        return "";
    }

    public static String get(String key, String def) {
        return def;
    }

    public static int getInt(String key, int def) {
        return def;
    }

    public static long getLong(String key, long def) {
        return def;
    }

    public static boolean getBoolean(String key, boolean def) {
        return def;
    }

    public static void set(String key, String val) {
    }
}
