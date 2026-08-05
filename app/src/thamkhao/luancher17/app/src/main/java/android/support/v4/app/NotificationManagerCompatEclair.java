package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationManagerCompatEclair.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class NotificationManagerCompatEclair {
    NotificationManagerCompatEclair() {
    }

    static void cancelNotification(NotificationManager notificationManager, String tag, int id) {
        notificationManager.cancel(tag, id);
    }

    public static void postNotification(NotificationManager notificationManager, String tag, int id, Notification notification) {
        notificationManager.notify(tag, id, notification);
    }
}
