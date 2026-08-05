package android.support.v4.os;

import android.os.Trace;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/TraceJellybeanMR2.class */
class TraceJellybeanMR2 {
    TraceJellybeanMR2() {
    }

    public static void beginSection(String section) {
        Trace.beginSection(section);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
