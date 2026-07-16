package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_Tangdu_Porsche extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_D40_D0_B30 = 95;
    public static final int U_CARINFO_D40_D0_B4 = 96;
    public static final int U_CARINFO_D40_D0_B5 = 97;
    public static final int U_CARINFO_D40_D0_B6 = 98;
    public static final int U_CARINFO_D40_D0_B7 = 99;
    public static final int U_CARINFO_D40_D1_B0 = 100;
    public static final int U_CARINFO_D40_D1_B12 = 101;
    public static final int U_CARINFO_D40_D1_B34 = 102;
    public static final int U_CARINFO_D40_D1_B5 = 103;
    public static final int U_CARINFO_D40_D1_B6 = 104;
    public static final int U_CARINFO_D40_D2_B04 = 105;
    public static final int U_CARINFO_D40_D2_B5 = 106;
    public static final int U_CARINFO_D40_D3_B70 = 107;
    public static final int U_CARINFO_D41_D11_D13 = 112;
    public static final int U_CARINFO_D41_D4_D5 = 108;
    public static final int U_CARINFO_D41_D6_D7 = 109;
    public static final int U_CARINFO_D41_D8_B70 = 110;
    public static final int U_CARINFO_D41_D9_D10 = 111;
    public static final int U_CARSET_EQ_BAL = 114;
    public static final int U_CARSET_EQ_BASS = 115;
    public static final int U_CARSET_EQ_D4_B0 = 119;
    public static final int U_CARSET_EQ_D4_B1 = 120;
    public static final int U_CARSET_EQ_D4_B2 = 121;
    public static final int U_CARSET_EQ_D4_B3 = 122;
    public static final int U_CARSET_EQ_FAD = 113;
    public static final int U_CARSET_EQ_MID = 116;
    public static final int U_CARSET_EQ_TREB = 117;
    public static final int U_CARSET_EQ_VOL = 118;
    public static final int U_CNT_MAX = 123;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
        if (updateCode >= 0 && updateCode < 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
