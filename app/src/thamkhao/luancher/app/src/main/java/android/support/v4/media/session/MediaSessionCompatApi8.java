package android.support.v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi8.class */
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
