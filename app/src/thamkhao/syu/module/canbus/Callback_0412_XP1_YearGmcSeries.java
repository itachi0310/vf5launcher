package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0412_XP1_YearGmcSeries extends CallbackCanbusBase {
    public static final int U_CARSET_D38_D0_B10 = 95;
    public static final int U_CARSET_D38_D0_B2 = 96;
    public static final int U_CARSET_D38_D0_B3 = 97;
    public static final int U_CARSET_D38_D0_B4 = 98;
    public static final int U_CARSET_D38_D0_B5 = 99;
    public static final int U_CARSET_D38_D0_B6 = 100;
    public static final int U_CARSET_D38_D0_B7 = 101;
    public static final int U_CARSET_D38_D1_B0 = 102;
    public static final int U_CARSET_D38_D1_B1 = 103;
    public static final int U_CARSET_D38_D1_B2 = 104;
    public static final int U_CARSET_D38_D1_B3 = 105;
    public static final int U_CARSET_D38_D1_B4 = 106;
    public static final int U_CARSET_D38_D1_B75 = 107;
    public static final int U_CARSET_D38_D2_B0 = 108;
    public static final int U_CARSET_D38_D2_B1 = 109;
    public static final int U_CARSET_D38_D2_B2 = 110;
    public static final int U_CARSET_D38_D2_B3 = 111;
    public static final int U_CARSET_D38_D2_B4 = 112;
    public static final int U_CARSET_D38_D3_B70 = 113;
    public static final int U_CAR_SPEED = 94;
    public static final int U_CNT_MAX = 114;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
