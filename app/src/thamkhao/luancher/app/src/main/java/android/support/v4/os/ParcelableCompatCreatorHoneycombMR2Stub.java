package android.support.v4.os;

import android.os.Parcelable;

/* JADX INFO: compiled from: ParcelableCompatHoneycombMR2.java */
/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompatCreatorHoneycombMR2Stub.class */
class ParcelableCompatCreatorHoneycombMR2Stub {
    ParcelableCompatCreatorHoneycombMR2Stub() {
    }

    static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(callbacks);
    }
}
