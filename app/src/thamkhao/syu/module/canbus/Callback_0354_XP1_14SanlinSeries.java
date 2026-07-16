package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0354_XP_Sanlin;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0354_XP1_14SanlinSeries extends CallbackCanbusBase {
    public static final int U_CARSET_D40_D0_B32 = 96;
    public static final int U_CARSET_D40_D0_B75 = 95;
    public static final int U_CARSET_D40_D1_B01 = 101;
    public static final int U_CARSET_D40_D1_B04 = 99;
    public static final int U_CARSET_D40_D1_B05 = 98;
    public static final int U_CARSET_D40_D1_B32 = 100;
    public static final int U_CARSET_D40_D1_B76 = 97;
    public static final int U_CARSET_D40_D2_B07 = 102;
    public static final int U_CARSET_D40_D2_B31 = 104;
    public static final int U_CARSET_D40_D2_B64 = 103;
    public static final int U_CARSET_D40_D3_B20 = 107;
    public static final int U_CARSET_D40_D3_B54 = 106;
    public static final int U_CARSET_D40_D3_B76 = 105;
    public static final int U_CARSET_D40_D4_B02 = 112;
    public static final int U_CARSET_D40_D4_B05 = 110;
    public static final int U_CARSET_D40_D4_B06 = 109;
    public static final int U_CARSET_D40_D4_B07 = 108;
    public static final int U_CARSET_D40_D4_B10 = 113;
    public static final int U_CARSET_D40_D4_B43 = 111;
    public static final int U_CARSET_D40_D5_B01 = 118;
    public static final int U_CARSET_D40_D5_B06 = 115;
    public static final int U_CARSET_D40_D5_B07 = 114;
    public static final int U_CARSET_D40_D5_B32 = 117;
    public static final int U_CARSET_D40_D5_B54 = 116;
    public static final int U_CARSET_D40_D6_B54 = 120;
    public static final int U_CARSET_D40_D6_B76 = 119;
    public static final int U_CARSET_EQ_D17_D0_B70 = 121;
    public static final int U_CARSET_EQ_D17_D10_B70 = 131;
    public static final int U_CARSET_EQ_D17_D11_B70 = 132;
    public static final int U_CARSET_EQ_D17_D12_B70 = 133;
    public static final int U_CARSET_EQ_D17_D1_B70 = 122;
    public static final int U_CARSET_EQ_D17_D2_B70 = 123;
    public static final int U_CARSET_EQ_D17_D3_B70 = 124;
    public static final int U_CARSET_EQ_D17_D4_B70 = 125;
    public static final int U_CARSET_EQ_D17_D5_B70 = 126;
    public static final int U_CARSET_EQ_D17_D6_B70 = 127;
    public static final int U_CARSET_EQ_D17_D7_B70 = 128;
    public static final int U_CARSET_EQ_D17_D8_B70 = 129;
    public static final int U_CARSET_EQ_D17_D9_B70 = 130;
    public static final int U_CAR_TYPE = 94;
    public static final int U_CNT_MAX = 134;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 134; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0354_XP_Sanlin(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode >= 0 && updateCode < 134) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
