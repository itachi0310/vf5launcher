package com.syu.c;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f514a;

    c(IBinder iBinder) {
        this.f514a = iBinder;
    }

    @Override // com.syu.c.a
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IModuleCallback");
            parcelObtain.writeInt(i);
            parcelObtain.writeIntArray(iArr);
            parcelObtain.writeFloatArray(fArr);
            parcelObtain.writeStringArray(strArr);
            this.f514a.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f514a;
    }
}
