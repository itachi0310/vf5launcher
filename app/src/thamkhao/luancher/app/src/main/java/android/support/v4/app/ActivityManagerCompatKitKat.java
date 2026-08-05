package android.support.v4.app;

import android.app.ActivityManager;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityManagerCompatKitKat.class */
class ActivityManagerCompatKitKat {
    ActivityManagerCompatKitKat() {
    }

    public static boolean isLowRamDevice(ActivityManager am) {
        return am.isLowRamDevice();
    }
}
