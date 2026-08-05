package android.support.v4.os;

import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompatCreatorCallbacks.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
