package android.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c f6a;

    public b(c cVar) {
        this.f6a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f6a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f6a.a(i);
    }
}
