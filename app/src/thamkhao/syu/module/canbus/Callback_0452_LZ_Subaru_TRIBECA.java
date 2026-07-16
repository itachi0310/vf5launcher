package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Subaru;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_LZ_Subaru_TRIBECA extends CallbackCanbusBase {
    public static final int U_CARINFO_CD_NUM = 126;
    public static final int U_CARINFO_CD_RANDOM = 128;
    public static final int U_CARINFO_CD_REAPEAT = 127;
    public static final int U_CARINFO_CD_TIME_M = 130;
    public static final int U_CARINFO_CD_TIME_S = 131;
    public static final int U_CARINFO_CD_TRACK = 129;
    public static final int U_CARINFO_RADIO_BAND = 115;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 123;
    public static final int U_CARINFO_RADIO_FREQ = 116;
    public static final int U_CARINFO_RADIO_FREQ1 = 117;
    public static final int U_CARINFO_RADIO_FREQ2 = 118;
    public static final int U_CARINFO_RADIO_FREQ3 = 119;
    public static final int U_CARINFO_RADIO_FREQ4 = 120;
    public static final int U_CARINFO_RADIO_FREQ5 = 121;
    public static final int U_CARINFO_RADIO_FREQ6 = 122;
    public static final int U_CARINFO_RADIO_SCAN = 125;
    public static final int U_CARINFO_RADIO_ST = 124;
    public static final int U_CARINF_D31_D0_B70 = 94;
    public static final int U_CARINF_D31_D1_B70 = 95;
    public static final int U_CARINF_D31_D2_B70 = 96;
    public static final int U_CARINF_D31_D3_B70 = 97;
    public static final int U_CARINF_D31_D4_B70 = 98;
    public static final int U_CARINF_D31_D5_B70 = 99;
    public static final int U_CARINF_D31_D6_B70 = 132;
    public static final int U_CARINF_D35_D0_D1 = 100;
    public static final int U_CARINF_D35_D10_D11 = 105;
    public static final int U_CARINF_D35_D13_B70 = 106;
    public static final int U_CARINF_D35_D2_D3 = 101;
    public static final int U_CARINF_D35_D4_D5 = 102;
    public static final int U_CARINF_D35_D6_D7 = 103;
    public static final int U_CARINF_D35_D8_D9 = 104;
    public static final int U_CARINF_D38_D0_B10 = 111;
    public static final int U_CARINF_D38_D0_B2 = 110;
    public static final int U_CARINF_D38_D0_B3 = 109;
    public static final int U_CARINF_D38_D0_B64 = 108;
    public static final int U_CARINF_D38_D0_B7 = 107;
    public static final int U_CARINF_D38_D1_B6 = 113;
    public static final int U_CARINF_D38_D1_B7 = 112;
    public static final int U_CARINF_LEFT_TEMP_ADD = 135;
    public static final int U_CARINF_RIGHT_TEMP_ADD = 136;
    public static final int U_CARINF_UNIT_MILE = 133;
    public static final int U_CARINF_UNIT_OIL = 134;
    public static final int U_CAR_SOURCE_ID = 114;
    public static final int U_CNT_MAX = 137;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 137; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Subaru(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 137) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
