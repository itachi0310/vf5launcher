package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0067_WC3_SiYu extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 103;
    public static final int U_COMPASS_STATUS = 102;
    public static final int U_CUR_SPEED = 94;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 103;
    public static final int U_PLAYER_MDI = 99;
    public static final int U_PLAYER_PROGRESS = 100;
    public static final int U_PLAYER_STATES = 101;
    public static final int U_PLAYER_TIME = 96;
    public static final int U_PLAYER_TOTAL_TRACK = 98;
    public static final int U_PLAYER_TRACK = 97;
    public static final int U_USB_TYPE = 95;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 103; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 103) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
