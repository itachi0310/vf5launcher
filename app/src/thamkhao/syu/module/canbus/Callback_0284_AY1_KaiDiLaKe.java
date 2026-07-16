package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0284_AY1_KaiDiLaKe extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 95;
    public static final int U_CNT_MAX = 99;
    public static final int U_CURRENT_SPEED = 94;
    public static final int U_CUR_OIL_EXPEND = 96;
    public static final int U_DRIVING_MILEAGE = 97;
    public static final int U_OPTIMAL_OIL_EXPEND = 98;

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
