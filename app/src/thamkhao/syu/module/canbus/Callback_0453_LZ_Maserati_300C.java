package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Maserati300C;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_Maserati_300C extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 156;
    public static final int U_CARINFO_EQ_BASS = 152;
    public static final int U_CARINFO_EQ_CARVOL = 157;
    public static final int U_CARINFO_EQ_FAD = 155;
    public static final int U_CARINFO_EQ_MID = 153;
    public static final int U_CARINFO_EQ_SPEEDVOL = 159;
    public static final int U_CARINFO_EQ_SUROUND = 158;
    public static final int U_CARINFO_EQ_TREB = 154;
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_D38_D0_B10 = 100;
    public static final int U_CARINF_D38_D0_B2 = 99;
    public static final int U_CARINF_D38_D0_B3 = 98;
    public static final int U_CARINF_D38_D0_B4 = 97;
    public static final int U_CARINF_D38_D0_B65 = 96;
    public static final int U_CARINF_D38_D0_B7 = 95;
    public static final int U_CARINF_D38_D1_B0 = 107;
    public static final int U_CARINF_D38_D1_B1 = 106;
    public static final int U_CARINF_D38_D1_B2 = 105;
    public static final int U_CARINF_D38_D1_B3 = 104;
    public static final int U_CARINF_D38_D1_B4 = 103;
    public static final int U_CARINF_D38_D1_B5 = 102;
    public static final int U_CARINF_D38_D1_B76 = 101;
    public static final int U_CARINF_D38_D2_B0 = 115;
    public static final int U_CARINF_D38_D2_B1 = 114;
    public static final int U_CARINF_D38_D2_B2 = 113;
    public static final int U_CARINF_D38_D2_B3 = 112;
    public static final int U_CARINF_D38_D2_B4 = 111;
    public static final int U_CARINF_D38_D2_B5 = 110;
    public static final int U_CARINF_D38_D2_B6 = 109;
    public static final int U_CARINF_D38_D2_B7 = 108;
    public static final int U_CARINF_D38_D3_B0 = 121;
    public static final int U_CARINF_D38_D3_B1 = 120;
    public static final int U_CARINF_D38_D3_B2 = 119;
    public static final int U_CARINF_D38_D3_B3 = 118;
    public static final int U_CARINF_D38_D3_B54 = 117;
    public static final int U_CARINF_D38_D3_B76 = 116;
    public static final int U_CARINF_D38_D4_B70 = 122;
    public static final int U_CARINF_D38_D5_B0 = 130;
    public static final int U_CARINF_D38_D5_B1 = 129;
    public static final int U_CARINF_D38_D5_B2 = 128;
    public static final int U_CARINF_D38_D5_B3 = 127;
    public static final int U_CARINF_D38_D5_B4 = 126;
    public static final int U_CARINF_D38_D5_B5 = 125;
    public static final int U_CARINF_D38_D5_B6 = 124;
    public static final int U_CARINF_D38_D5_B7 = 123;
    public static final int U_CARINF_D38_D6_B10 = 134;
    public static final int U_CARINF_D38_D6_B32 = 133;
    public static final int U_CARINF_D38_D6_B54 = 132;
    public static final int U_CARINF_D38_D6_B76 = 131;
    public static final int U_CARINF_D38_D7_B0 = 140;
    public static final int U_CARINF_D38_D7_B1 = 139;
    public static final int U_CARINF_D38_D7_B2 = 138;
    public static final int U_CARINF_D38_D7_B3 = 137;
    public static final int U_CARINF_D38_D7_B54 = 136;
    public static final int U_CARINF_D38_D7_B76 = 135;
    public static final int U_CARINF_D38_D8_B10 = 147;
    public static final int U_CARINF_D38_D8_B2 = 146;
    public static final int U_CARINF_D38_D8_B3 = 145;
    public static final int U_CARINF_D38_D8_B4 = 144;
    public static final int U_CARINF_D38_D8_B5 = 143;
    public static final int U_CARINF_D38_D8_B6 = 142;
    public static final int U_CARINF_D38_D8_B7 = 141;
    public static final int U_CARINF_D38_D9_B21 = 151;
    public static final int U_CARINF_D38_D9_B3 = 150;
    public static final int U_CARINF_D38_D9_B54 = 149;
    public static final int U_CARINF_D38_D9_B76 = 148;
    public static final int U_CNT_MAX = 160;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 160; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0453_LZ_Maserati300C(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 160) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
