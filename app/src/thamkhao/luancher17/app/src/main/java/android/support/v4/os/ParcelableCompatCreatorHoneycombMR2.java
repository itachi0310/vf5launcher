package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompatCreatorHoneycombMR2.class
  classes.dex
 */
/* JADX INFO: compiled from: ParcelableCompatHoneycombMR2.java */
/* JADX INFO: loaded from: classes.dex */
class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> callbacks) {
        this.mCallbacks = callbacks;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel in) {
        return this.mCallbacks.createFromParcel(in, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public T createFromParcel(Parcel in, ClassLoader loader) {
        return this.mCallbacks.createFromParcel(in, loader);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int size) {
        return this.mCallbacks.newArray(size);
    }
}
