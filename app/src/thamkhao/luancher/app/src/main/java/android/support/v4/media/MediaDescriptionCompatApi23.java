package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/MediaDescriptionCompatApi23.class */
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
    MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaUri();
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/MediaDescriptionCompatApi23$Builder.class */
    static class Builder extends MediaDescriptionCompatApi21.Builder {
        Builder() {
        }

        public static void setMediaUri(Object builderObj, Uri mediaUri) {
            ((MediaDescription.Builder) builderObj).setMediaUri(mediaUri);
        }
    }
}
