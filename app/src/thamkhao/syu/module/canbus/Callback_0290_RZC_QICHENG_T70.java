package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0290_RZC_QICHENG_T70 extends CallbackCanbusBase {
    public static final int U_AVM_61_D00 = 106;
    public static final int U_AVM_61_D01 = 105;
    public static final int U_AVM_61_D02 = 104;
    public static final int U_AVM_61_D03 = 103;
    public static final int U_BELT_LEFT = 101;
    public static final int U_BELT_RIGHT = 102;
    public static final int U_CARINFO_MILEAGE = 99;
    public static final int U_CARINO_BEGIN = 97;
    public static final int U_CARINO_END = 100;
    public static final int U_CNT_MAX = 108;
    public static final int U_CUR_OIL_EXPEND = 94;
    public static final int U_CUR_SPEED = 97;
    public static final int U_DRIVING_MILEAGE = 95;
    public static final int U_ENGINE_SPEED = 98;
    public static final int U_LIGHT_TRAVEL_MODE = 107;
    public static final int U_OPTIMAL_OIL_EXPEND = 96;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
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
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
