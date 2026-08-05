package cn.kuwo.autosdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
class w implements Parcelable.Creator {
    w() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v createFromParcel(Parcel parcel) {
        return new v(parcel, (v) null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v[] newArray(int i) {
        return new v[i];
    }
}
