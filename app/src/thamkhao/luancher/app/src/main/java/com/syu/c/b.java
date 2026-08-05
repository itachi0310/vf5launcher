package com.syu.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements a {
    public b() {
        attachInterface(this, "com.syu.ipc.IModuleCallback");
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.ipc.IModuleCallback");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new c(iBinder) : (a) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.syu.ipc.IModuleCallback");
                a(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createStringArray());
                return true;
            case 1598968902:
                parcel2.writeString("com.syu.ipc.IModuleCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
