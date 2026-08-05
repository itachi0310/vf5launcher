package com.syu.c;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f516a;

    i(IBinder iBinder) {
        this.f516a = iBinder;
    }

    @Override // com.syu.c.g
    public d a(int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IRemoteToolkit");
            parcelObtain.writeInt(i);
            this.f516a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return e.a(parcelObtain2.readStrongBinder());
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f516a;
    }
}
