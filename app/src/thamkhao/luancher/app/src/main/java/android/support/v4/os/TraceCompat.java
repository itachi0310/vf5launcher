package android.support.v4.os;

import android.os.Build;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/TraceCompat.class */
public final class TraceCompat {
    public static void beginSection(String sectionName) {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.beginSection(sectionName);
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.endSection();
        }
    }

    private TraceCompat() {
    }
}
