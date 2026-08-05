package android.support.v4.os;

import android.os.Trace;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/TraceJellybeanMR2.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
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
