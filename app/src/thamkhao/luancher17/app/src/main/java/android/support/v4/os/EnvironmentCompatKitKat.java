package android.support.v4.os;

import android.os.Environment;
import java.io.File;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/EnvironmentCompatKitKat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class EnvironmentCompatKitKat {
    EnvironmentCompatKitKat() {
    }

    public static String getStorageState(File path) {
        return Environment.getStorageState(path);
    }
}
