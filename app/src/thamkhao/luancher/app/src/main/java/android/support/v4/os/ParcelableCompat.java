package android.support.v4.os;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompat.class */
public final class ParcelableCompat {
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
        if (Build.VERSION.SDK_INT >= 13) {
            return ParcelableCompatCreatorHoneycombMR2Stub.instantiate(callbacks);
        }
        return new CompatCreator(callbacks);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompat$CompatCreator.class */
    static class CompatCreator<T> implements Parcelable.Creator<T> {
        final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
            this.mCallbacks = callbacks;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel source) {
            return this.mCallbacks.createFromParcel(source, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int size) {
            return this.mCallbacks.newArray(size);
        }
    }

    private ParcelableCompat() {
    }
}
