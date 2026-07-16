package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XC_Xiandai_Suolantuo;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_XC_Xiandai_Suolantuo extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 95;
    public static final int U_CAREQ_BASS = 97;
    public static final int U_CAREQ_FAD = 96;
    public static final int U_CAREQ_MID = 98;
    public static final int U_CAREQ_TREB = 99;
    public static final int U_CAREQ_VOL = 94;
    public static final int U_CNT_MAX = 100;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0439_XC_Xiandai_Suolantuo(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 100) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
