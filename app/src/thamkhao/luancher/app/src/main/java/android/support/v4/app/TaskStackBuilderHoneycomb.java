package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/TaskStackBuilderHoneycomb.class */
class TaskStackBuilderHoneycomb {
    TaskStackBuilderHoneycomb() {
    }

    public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode, Intent[] intents, int flags) {
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }
}
