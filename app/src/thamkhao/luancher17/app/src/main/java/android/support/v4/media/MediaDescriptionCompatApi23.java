package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/MediaDescriptionCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
    MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object descriptionObj) {
        return ((MediaDescription) descriptionObj).getMediaUri();
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/MediaDescriptionCompatApi23$Builder.class
  classes.dex
 */
    static class Builder extends MediaDescriptionCompatApi21.Builder {
        Builder() {
        }

        public static void setMediaUri(Object builderObj, Uri mediaUri) {
            ((MediaDescription.Builder) builderObj).setMediaUri(mediaUri);
        }
    }
}
