package com.syu.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends Binder implements g {
    public static g a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.ipc.IRemoteToolkit");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new i(iBinder) : (g) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.syu.ipc.IRemoteToolkit");
                d dVarA = a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(dVarA != null ? dVarA.asBinder() : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.syu.ipc.IRemoteToolkit");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
