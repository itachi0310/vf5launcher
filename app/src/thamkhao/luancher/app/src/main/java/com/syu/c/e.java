package com.syu.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Binder implements d {
    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.ipc.IRemoteModule");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new f(iBinder) : (d) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.syu.ipc.IRemoteModule");
                a(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createStringArray());
                return true;
            case 2:
                parcel.enforceInterface("com.syu.ipc.IRemoteModule");
                j jVarB = b(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createStringArray());
                parcel2.writeNoException();
                if (jVarB == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                parcel2.writeIntArray(jVarB.f517a);
                parcel2.writeFloatArray(jVarB.b);
                parcel2.writeStringArray(jVarB.c);
                return true;
            case 3:
                parcel.enforceInterface("com.syu.ipc.IRemoteModule");
                a(b.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 4:
                parcel.enforceInterface("com.syu.ipc.IRemoteModule");
                a(b.a(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 1598968902:
                parcel2.writeString("com.syu.ipc.IRemoteModule");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
