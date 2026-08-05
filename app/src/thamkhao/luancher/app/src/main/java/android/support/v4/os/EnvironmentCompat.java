package android.support.v4.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/EnvironmentCompat.class */
public final class EnvironmentCompat {
    private static final String TAG = "EnvironmentCompat";
    public static final String MEDIA_UNKNOWN = "unknown";

    public static String getStorageState(File path) {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return EnvironmentCompatKitKat.getStorageState(path);
        }
        try {
            String canonicalPath = path.getCanonicalPath();
            String canonicalExternal = Environment.getExternalStorageDirectory().getCanonicalPath();
            if (canonicalPath.startsWith(canonicalExternal)) {
                return Environment.getExternalStorageState();
            }
            return MEDIA_UNKNOWN;
        } catch (IOException e) {
            Log.w(TAG, "Failed to resolve canonical path: " + e);
            return MEDIA_UNKNOWN;
        }
    }

    private EnvironmentCompat() {
    }
}
