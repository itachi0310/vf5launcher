package android.support.v4.content;

import android.content.Context;
import java.io.File;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContextCompatFroyo.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ContextCompatFroyo {
    ContextCompatFroyo() {
    }

    public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    public static File getExternalFilesDir(Context context, String type) {
        return context.getExternalFilesDir(type);
    }
}
