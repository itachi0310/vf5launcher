package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaControllerCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompatApi23 {
    MediaControllerCompatApi23() {
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/session/MediaControllerCompatApi23$TransportControls.class
  classes.dex
 */
    public static class TransportControls extends MediaControllerCompatApi21.TransportControls {
        public static void playFromUri(Object controlsObj, Uri uri, Bundle extras) {
            ((MediaController.TransportControls) controlsObj).playFromUri(uri, extras);
        }
    }
}
