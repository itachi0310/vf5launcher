package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/BundleCompatJellybeanMR2.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class BundleCompatJellybeanMR2 {
    BundleCompatJellybeanMR2() {
    }

    public static IBinder getBinder(Bundle bundle, String key) {
        return bundle.getBinder(key);
    }

    public static void putBinder(Bundle bundle, String key, IBinder binder) {
        bundle.putBinder(key, binder);
    }
}
