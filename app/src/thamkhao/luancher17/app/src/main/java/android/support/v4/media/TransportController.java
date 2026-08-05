package android.support.v4.media;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/media/TransportController.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransportController {
    public abstract int getBufferPercentage();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract int getTransportControlFlags();

    public abstract boolean isPlaying();

    public abstract void pausePlaying();

    public abstract void registerStateListener(TransportStateListener transportStateListener);

    public abstract void seekTo(long j);

    public abstract void startPlaying();

    public abstract void stopPlaying();

    public abstract void unregisterStateListener(TransportStateListener transportStateListener);
}
