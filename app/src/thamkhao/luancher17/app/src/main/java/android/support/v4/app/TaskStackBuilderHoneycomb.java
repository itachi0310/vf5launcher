package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/TaskStackBuilderHoneycomb.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class TaskStackBuilderHoneycomb {
    TaskStackBuilderHoneycomb() {
    }

    public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode, Intent[] intents, int flags) {
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }
}
