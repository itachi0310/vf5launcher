package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatJB.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ActivityCompatJB {
    ActivityCompatJB() {
    }

    public static void startActivity(Context context, Intent intent, Bundle options) {
        context.startActivity(intent, options);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
        activity.startActivityForResult(intent, requestCode, options);
    }

    public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }
}
