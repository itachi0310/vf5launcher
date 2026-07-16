package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_ALFA_ROMEO;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_ALFA_ROMEO extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 143;
    public static final int U_CARINFO_EQ_BASS = 139;
    public static final int U_CARINFO_EQ_CARVOL = 144;
    public static final int U_CARINFO_EQ_FAD = 142;
    public static final int U_CARINFO_EQ_MID = 140;
    public static final int U_CARINFO_EQ_SPEEDVOL = 145;
    public static final int U_CARINFO_EQ_TREB = 141;
    public static final int U_CARINF_D35_D10_B30 = 126;
    public static final int U_CARINF_D35_D10_B6 = 125;
    public static final int U_CARINF_D35_D10_B7 = 124;
    public static final int U_CARINF_D35_D11_B30 = 127;
    public static final int U_CARINF_D35_D2_D3 = 122;
    public static final int U_CARINF_D35_D7_D8_D9 = 123;
    public static final int U_CARINF_D37_D0_B70 = 99;
    public static final int U_CARINF_D38_D0_B10 = 105;
    public static final int U_CARINF_D38_D0_B32 = 104;
    public static final int U_CARINF_D38_D0_B4 = 103;
    public static final int U_CARINF_D38_D0_B5 = 102;
    public static final int U_CARINF_D38_D0_B6 = 101;
    public static final int U_CARINF_D38_D0_B7 = 100;
    public static final int U_CARINF_D38_D1_B70 = 106;
    public static final int U_CARINF_D38_D2_B10 = 113;
    public static final int U_CARINF_D38_D2_B2 = 112;
    public static final int U_CARINF_D38_D2_B3 = 111;
    public static final int U_CARINF_D38_D2_B4 = 110;
    public static final int U_CARINF_D38_D2_B5 = 109;
    public static final int U_CARINF_D38_D2_B6 = 108;
    public static final int U_CARINF_D38_D2_B7 = 107;
    public static final int U_CARINF_D38_D3_B20 = 116;
    public static final int U_CARINF_D38_D3_B43 = 115;
    public static final int U_CARINF_D38_D3_B75 = 114;
    public static final int U_CARINF_D38_D4_B2 = 120;
    public static final int U_CARINF_D38_D4_B3 = 119;
    public static final int U_CARINF_D38_D4_B54 = 118;
    public static final int U_CARINF_D38_D4_B76 = 117;
    public static final int U_CARINF_D38_D5_B70 = 121;
    public static final int U_CARINF_D38_D6_B0 = 135;
    public static final int U_CARINF_D38_D6_B1 = 134;
    public static final int U_CARINF_D38_D6_B2 = 133;
    public static final int U_CARINF_D38_D6_B3 = 132;
    public static final int U_CARINF_D38_D6_B4 = 131;
    public static final int U_CARINF_D38_D6_B5 = 130;
    public static final int U_CARINF_D38_D6_B6 = 129;
    public static final int U_CARINF_D38_D6_B7 = 128;
    public static final int U_CARINF_D38_D7_B5 = 138;
    public static final int U_CARINF_D38_D7_B6 = 137;
    public static final int U_CARINF_D38_D7_B7 = 136;
    public static final int U_CNT_MAX = 146;
    public static final int U_TIRE_PRESSURE_FL = 94;
    public static final int U_TIRE_PRESSURE_FR = 95;
    public static final int U_TIRE_PRESSURE_RL = 96;
    public static final int U_TIRE_PRESSURE_RR = 97;
    public static final int U_TIRE_PRESSURE_UNIT = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_LZ_ALFA_ROMEO(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 146) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
