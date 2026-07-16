package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_OD_Weima_EX5 extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B10 = 111;
    public static final int U_CARSET_D41_D0_B4 = 110;
    public static final int U_CARSET_D41_D0_B5 = 109;
    public static final int U_CARSET_D41_D0_B6 = 108;
    public static final int U_CARSET_D41_D0_B7 = 107;
    public static final int U_CARSET_D41_D1_B70 = 112;
    public static final int U_CARSET_D41_D2_B70 = 113;
    public static final int U_CARSET_D41_D3_B0 = 121;
    public static final int U_CARSET_D41_D3_B1 = 120;
    public static final int U_CARSET_D41_D3_B2 = 119;
    public static final int U_CARSET_D41_D3_B3 = 118;
    public static final int U_CARSET_D41_D3_B4 = 117;
    public static final int U_CARSET_D41_D3_B5 = 116;
    public static final int U_CARSET_D41_D3_B6 = 115;
    public static final int U_CARSET_D41_D3_B7 = 114;
    public static final int U_CARSET_D41_D5_B70 = 123;
    public static final int U_CARSET_TIRE_UNIT = 122;
    public static final int U_CNT_MAX = 124;
    public static final int U_TIRE_BEGIN = 93;
    public static final int U_TIRE_END = 106;
    public static final int U_TIRE_FL_WARN = 102;
    public static final int U_TIRE_FR_WARN = 103;
    public static final int U_TIRE_PRESSURE_FL = 94;
    public static final int U_TIRE_PRESSURE_FR = 95;
    public static final int U_TIRE_PRESSURE_RL = 96;
    public static final int U_TIRE_PRESSURE_RR = 97;
    public static final int U_TIRE_RL_WARN = 105;
    public static final int U_TIRE_RR_WARN = 104;
    public static final int U_TIRE_TEMP_FL = 98;
    public static final int U_TIRE_TEMP_FR = 99;
    public static final int U_TIRE_TEMP_RL = 100;
    public static final int U_TIRE_TEMP_RR = 101;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
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
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
