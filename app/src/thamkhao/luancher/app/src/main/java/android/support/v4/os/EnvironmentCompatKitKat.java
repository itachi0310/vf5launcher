package android.support.v4.os;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/EnvironmentCompatKitKat.class */
class EnvironmentCompatKitKat {
    EnvironmentCompatKitKat() {
    }

    public static String getStorageState(File path) {
        return Environment.getStorageState(path);
    }
}
