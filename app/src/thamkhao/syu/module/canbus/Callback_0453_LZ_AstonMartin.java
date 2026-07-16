package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_AstonMartin extends CallbackCanbusBase {
    public static final int U_CARINF_D36_VINID = 106;
    public static final int U_CARINF_D38_D0_B0 = 101;
    public static final int U_CARINF_D38_D0_B1 = 100;
    public static final int U_CARINF_D38_D0_B2 = 99;
    public static final int U_CARINF_D38_D0_B3 = 98;
    public static final int U_CARINF_D38_D0_B4 = 97;
    public static final int U_CARINF_D38_D0_B5 = 96;
    public static final int U_CARINF_D38_D0_B6 = 95;
    public static final int U_CARINF_D38_D0_B7 = 94;
    public static final int U_CARINF_D38_D1_B43 = 104;
    public static final int U_CARINF_D38_D1_B65 = 103;
    public static final int U_CARINF_D38_D1_B7 = 102;
    public static final int U_CARINF_D39_D7_D8_D9 = 105;
    public static final int U_CNT_MAX = 107;
    public static String VinId = "";

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 106) {
            if (strs != null && strs.length > 0) {
                VinId = strs[0];
            } else {
                VinId = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
