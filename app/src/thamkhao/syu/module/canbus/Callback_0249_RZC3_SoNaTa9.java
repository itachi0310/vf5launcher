package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0249_RZC3_SoNaTa9 extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 98;
    public static final int U_CARINFO_EQ_BASS = 94;
    public static final int U_CARINFO_EQ_FAD = 97;
    public static final int U_CARINFO_EQ_MID = 95;
    public static final int U_CARINFO_EQ_TREB = 96;
    public static final int U_CNT_MAX = 99;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 99) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
