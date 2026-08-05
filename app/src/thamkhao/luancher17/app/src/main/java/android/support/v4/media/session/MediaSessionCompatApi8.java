package android.support.v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi8.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi8 {
    MediaSessionCompatApi8() {
    }

    public static void registerMediaButtonEventReceiver(Context context, ComponentName mbr) {
        AudioManager am = (AudioManager) context.getSystemService("audio");
        am.registerMediaButtonEventReceiver(mbr);
    }

    public static void unregisterMediaButtonEventReceiver(Context context, ComponentName mbr) {
        AudioManager am = (AudioManager) context.getSystemService("audio");
        am.unregisterMediaButtonEventReceiver(mbr);
    }
}
