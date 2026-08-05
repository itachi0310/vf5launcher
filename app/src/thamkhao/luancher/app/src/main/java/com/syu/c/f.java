package com.syu.c;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f515a;

    f(IBinder iBinder) {
        this.f515a = iBinder;
    }

    @Override // com.syu.c.d
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IRemoteModule");
            parcelObtain.writeInt(i);
            parcelObtain.writeIntArray(iArr);
            parcelObtain.writeFloatArray(fArr);
            parcelObtain.writeStringArray(strArr);
            this.f515a.transact(1, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.syu.c.d
    public void a(a aVar, int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IRemoteModule");
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            parcelObtain.writeInt(i);
            this.f515a.transact(4, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.syu.c.d
    public void a(a aVar, int i, int i2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IRemoteModule");
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            this.f515a.transact(3, parcelObtain, parcelObtain2, 1);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f515a;
    }

    @Override // com.syu.c.d
    public j b(int i, int[] iArr, float[] fArr, String[] strArr) {
        j jVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.syu.ipc.IRemoteModule");
            parcelObtain.writeInt(i);
            parcelObtain.writeIntArray(iArr);
            parcelObtain.writeFloatArray(fArr);
            parcelObtain.writeStringArray(strArr);
            this.f515a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() != 0) {
                jVar = new j();
                jVar.f517a = parcelObtain2.createIntArray();
                jVar.b = parcelObtain2.createFloatArray();
                jVar.c = parcelObtain2.createStringArray();
            } else {
                jVar = null;
            }
            return jVar;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
