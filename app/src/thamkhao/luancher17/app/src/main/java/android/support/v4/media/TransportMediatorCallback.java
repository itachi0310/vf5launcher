package android.support.v4.media;

import android.view.KeyEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/TransportMediatorCallback.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
interface TransportMediatorCallback {
    long getPlaybackPosition();

    void handleAudioFocusChange(int i);

    void handleKey(KeyEvent keyEvent);

    void playbackPositionUpdate(long j);
}
