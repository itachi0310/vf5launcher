package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build;
import android.support.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityManagerCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(@NonNull ActivityManager am) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ActivityManagerCompatKitKat.isLowRamDevice(am);
        }
        return false;
    }
}
