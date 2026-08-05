package android.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public class d implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f7a;

    public d(c cVar) {
        this.f7a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f7a.a(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f7a.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f7a.a(i);
    }
}
