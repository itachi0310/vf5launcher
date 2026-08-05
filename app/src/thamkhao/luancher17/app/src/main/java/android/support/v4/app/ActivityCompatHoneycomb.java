package android.support.v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatHoneycomb.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ActivityCompatHoneycomb {
    ActivityCompatHoneycomb() {
    }

    static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    static void dump(Activity activity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        activity.dump(prefix, fd, writer, args);
    }
}
