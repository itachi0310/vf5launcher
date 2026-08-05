package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaControllerCompatApi23.class */
class MediaControllerCompatApi23 {
    MediaControllerCompatApi23() {
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaControllerCompatApi23$TransportControls.class */
    public static class TransportControls extends MediaControllerCompatApi21.TransportControls {
        public static void playFromUri(Object controlsObj, Uri uri, Bundle extras) {
            ((MediaController.TransportControls) controlsObj).playFromUri(uri, extras);
        }
    }
}
