package android.support.v4.media;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/TransportController.class */
public abstract class TransportController {
    public abstract void registerStateListener(TransportStateListener transportStateListener);

    public abstract void unregisterStateListener(TransportStateListener transportStateListener);

    public abstract void startPlaying();

    public abstract void pausePlaying();

    public abstract void stopPlaying();

    public abstract long getDuration();

    public abstract long getCurrentPosition();

    public abstract void seekTo(long j);

    public abstract boolean isPlaying();

    public abstract int getBufferPercentage();

    public abstract int getTransportControlFlags();
}
