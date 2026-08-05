package android.support.v4.os;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/TraceCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
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
