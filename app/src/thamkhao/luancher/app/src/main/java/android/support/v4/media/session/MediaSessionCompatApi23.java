package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi23.class */
class MediaSessionCompatApi23 {

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi23$Callback.class */
    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaSessionCompatApi23$CallbackProxy.class */
    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T callback) {
            super(callback);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle extras) {
            ((Callback) this.mCallback).onPlayFromUri(uri, extras);
        }
    }
}
