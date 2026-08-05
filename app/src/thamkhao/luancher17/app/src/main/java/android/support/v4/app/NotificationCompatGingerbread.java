package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatGingerbread.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class NotificationCompatGingerbread {
    NotificationCompatGingerbread() {
    }

    public static Notification add(Notification notification, Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent, PendingIntent fullScreenIntent) {
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.fullScreenIntent = fullScreenIntent;
        return notification;
    }
}
