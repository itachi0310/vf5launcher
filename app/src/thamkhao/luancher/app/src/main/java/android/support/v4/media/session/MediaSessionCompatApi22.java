package android.support.v4.media.session;

import android.media.session.MediaSession;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi22.class */
class MediaSessionCompatApi22 {
    MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object sessionObj, int type) {
        ((MediaSession) sessionObj).setRatingType(type);
    }
}
