package android.support.v4.media;

import android.media.VolumeProvider;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/VolumeProviderCompatApi21.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/VolumeProviderCompatApi21$Delegate.class
  classes.dex
 */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int volumeControl, int maxVolume, int currentVolume, final Delegate delegate) {
        return new VolumeProvider(volumeControl, maxVolume, currentVolume) { // from class: android.support.v4.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int volume) {
                delegate.onSetVolumeTo(volume);
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int direction) {
                delegate.onAdjustVolume(direction);
            }
        };
    }

    public static void setCurrentVolume(Object volumeProviderObj, int currentVolume) {
        ((VolumeProvider) volumeProviderObj).setCurrentVolume(currentVolume);
    }
}
