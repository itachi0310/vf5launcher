package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NavUtilsJB.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class NavUtilsJB {
    NavUtilsJB() {
    }

    public static Intent getParentActivityIntent(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
        return activity.shouldUpRecreateTask(targetIntent);
    }

    public static void navigateUpTo(Activity activity, Intent upIntent) {
        activity.navigateUpTo(upIntent);
    }

    public static String getParentActivityName(ActivityInfo info) {
        return info.parentActivityName;
    }
}
