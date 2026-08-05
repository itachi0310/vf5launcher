package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class NotificationCompatBase {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatBase$Action.class
  classes.dex
 */
    public static abstract class Action {

        /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatBase$Action$Factory.class
  classes.dex
 */
        public interface Factory {
            Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr);

            Action[] newArray(int i);
        }

        public abstract PendingIntent getActionIntent();

        public abstract Bundle getExtras();

        public abstract int getIcon();

        public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

        public abstract CharSequence getTitle();
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatBase$UnreadConversation.class
  classes.dex
 */
    public static abstract class UnreadConversation {

        /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/NotificationCompatBase$UnreadConversation$Factory.class
  classes.dex
 */
        public interface Factory {
            UnreadConversation build(String[] strArr, RemoteInputCompatBase.RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j);
        }

        abstract long getLatestTimestamp();

        abstract String[] getMessages();

        abstract String getParticipant();

        abstract String[] getParticipants();

        abstract PendingIntent getReadPendingIntent();

        abstract RemoteInputCompatBase.RemoteInput getRemoteInput();

        abstract PendingIntent getReplyPendingIntent();
    }

    public static Notification add(Notification notification, Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent) {
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        return notification;
    }
}
