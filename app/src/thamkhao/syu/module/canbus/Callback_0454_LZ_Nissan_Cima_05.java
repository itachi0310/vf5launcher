package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_LZ_Nissan_05Cima;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0454_LZ_Nissan_Cima_05 extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 115;
    public static final int U_CARINFO_EQ_BASS = 113;
    public static final int U_CARINFO_EQ_CARVOL = 112;
    public static final int U_CARINFO_EQ_D5_B4 = 118;
    public static final int U_CARINFO_EQ_D5_B5 = 117;
    public static final int U_CARINFO_EQ_FAD = 116;
    public static final int U_CARINFO_EQ_TREB = 114;
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_D35_D10_B6 = 101;
    public static final int U_CARINF_D35_D10_B7 = 100;
    public static final int U_CARINF_D35_D1_B70 = 96;
    public static final int U_CARINF_D35_D2_D3 = 97;
    public static final int U_CARINF_D35_D4_D5 = 98;
    public static final int U_CARINF_D35_D7_D9 = 99;
    public static final int U_CARINF_D37_D2_D3 = 95;
    public static final int U_CARSET_D38_D0_B70 = 106;
    public static final int U_CARSET_D38_D13_B54 = 111;
    public static final int U_CARSET_D38_D13_B6 = 110;
    public static final int U_CARSET_D38_D13_B7 = 109;
    public static final int U_CARSET_D38_D1_B70 = 107;
    public static final int U_CARSET_D38_D6_B70 = 108;
    public static final int U_CNT_MAX = 119;
    public static final int U_TIRE_VALUE_FL = 102;
    public static final int U_TIRE_VALUE_FR = 103;
    public static final int U_TIRE_VALUE_RL = 104;
    public static final int U_TIRE_VALUE_RR = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0454_LZ_Nissan_05Cima(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
