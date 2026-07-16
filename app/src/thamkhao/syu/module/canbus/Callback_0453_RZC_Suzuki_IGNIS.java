package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_rzc_suzuki_ignis;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_RZC_Suzuki_IGNIS extends CallbackCanbusBase {
    public static final int U_CARINFO_D33_TYPE1_D11_D12 = 96;
    public static final int U_CARINFO_D33_TYPE1_D13_B10 = 101;
    public static final int U_CARINFO_D33_TYPE1_D13_B32 = 100;
    public static final int U_CARINFO_D33_TYPE1_D13_B54 = 99;
    public static final int U_CARINFO_D33_TYPE1_D13_B6 = 98;
    public static final int U_CARINFO_D33_TYPE1_D13_B7 = 97;
    public static final int U_CARINFO_D33_TYPE1_D14_B70 = 102;
    public static final int U_CARINFO_D33_TYPE1_D1_B70 = 94;
    public static final int U_CARINFO_D33_TYPE1_D2_D3 = 95;
    public static final int U_CARINFO_D33_TYPE2_D1_D2 = 103;
    public static final int U_CARINFO_D33_TYPE2_D3_D4 = 104;
    public static final int U_CARINFO_D33_TYPE2_D5_D6 = 105;
    public static final int U_CARINFO_D33_TYPE2_D7_D8 = 106;
    public static final int U_CARINFO_D33_TYPE2_D9_D10 = 107;
    public static final int U_CARINFO_D33_TYPE3_D10_B70 = 116;
    public static final int U_CARINFO_D33_TYPE3_D11_D12 = 117;
    public static final int U_CARINFO_D33_TYPE3_D13_B70 = 118;
    public static final int U_CARINFO_D33_TYPE3_D14_B70 = 119;
    public static final int U_CARINFO_D33_TYPE3_D15_B70 = 120;
    public static final int U_CARINFO_D33_TYPE3_D16_B70 = 121;
    public static final int U_CARINFO_D33_TYPE3_D17_D18 = 122;
    public static final int U_CARINFO_D33_TYPE3_D19_B70 = 123;
    public static final int U_CARINFO_D33_TYPE3_D1_B70 = 108;
    public static final int U_CARINFO_D33_TYPE3_D20_B70 = 124;
    public static final int U_CARINFO_D33_TYPE3_D21_B70 = 125;
    public static final int U_CARINFO_D33_TYPE3_D22_B70 = 126;
    public static final int U_CARINFO_D33_TYPE3_D23_D24 = 127;
    public static final int U_CARINFO_D33_TYPE3_D25_B70 = 128;
    public static final int U_CARINFO_D33_TYPE3_D26_B70 = 129;
    public static final int U_CARINFO_D33_TYPE3_D27_B70 = 130;
    public static final int U_CARINFO_D33_TYPE3_D28_B70 = 131;
    public static final int U_CARINFO_D33_TYPE3_D29_D30 = 132;
    public static final int U_CARINFO_D33_TYPE3_D2_B70 = 109;
    public static final int U_CARINFO_D33_TYPE3_D3_B70 = 110;
    public static final int U_CARINFO_D33_TYPE3_D4_B70 = 111;
    public static final int U_CARINFO_D33_TYPE3_D5_D6 = 112;
    public static final int U_CARINFO_D33_TYPE3_D7_B70 = 113;
    public static final int U_CARINFO_D33_TYPE3_D8_B70 = 114;
    public static final int U_CARINFO_D33_TYPE3_D9_B70 = 115;
    public static final int U_CNT_MAX = 133;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 133; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_rzc_suzuki_ignis(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 133) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
