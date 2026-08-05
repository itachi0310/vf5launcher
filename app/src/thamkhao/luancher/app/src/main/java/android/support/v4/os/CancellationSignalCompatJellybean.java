package android.support.v4.os;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/CancellationSignalCompatJellybean.class */
class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static Object create() {
        return new android.os.CancellationSignal();
    }

    public static void cancel(Object cancellationSignalObj) {
        ((android.os.CancellationSignal) cancellationSignalObj).cancel();
    }
}
