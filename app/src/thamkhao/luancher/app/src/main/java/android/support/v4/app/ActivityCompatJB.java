package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatJB.class */
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
