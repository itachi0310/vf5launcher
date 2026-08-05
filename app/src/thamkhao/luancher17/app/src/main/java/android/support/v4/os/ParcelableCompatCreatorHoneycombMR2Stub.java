package android.support.v4.os;

import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/ParcelableCompatCreatorHoneycombMR2Stub.class
  classes.dex
 */
/* JADX INFO: compiled from: ParcelableCompatHoneycombMR2.java */
/* JADX INFO: loaded from: classes.dex */
class ParcelableCompatCreatorHoneycombMR2Stub {
    ParcelableCompatCreatorHoneycombMR2Stub() {
    }

    static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(callbacks);
    }
}
