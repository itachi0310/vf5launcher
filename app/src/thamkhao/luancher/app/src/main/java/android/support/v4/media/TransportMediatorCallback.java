package android.support.v4.media;

import android.view.KeyEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/TransportMediatorCallback.class */
interface TransportMediatorCallback {
    void handleKey(KeyEvent keyEvent);

    void handleAudioFocusChange(int i);

    long getPlaybackPosition();

    void playbackPositionUpdate(long j);
}
