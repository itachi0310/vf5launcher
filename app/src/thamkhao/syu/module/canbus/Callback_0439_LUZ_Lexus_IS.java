package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Luz_LexusIS;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_LUZ_Lexus_IS extends CallbackCanbusBase {
    public static final int U_CARCD_ASL = 134;
    public static final int U_CARCD_BAL = 133;
    public static final int U_CARCD_BASS = 135;
    public static final int U_CARCD_CURTIME_HOUR = 131;
    public static final int U_CARCD_CURTIME_MIN = 130;
    public static final int U_CARCD_CURTIME_SEC = 129;
    public static final int U_CARCD_CURTRACK = 125;
    public static final int U_CARCD_DISC1 = 102;
    public static final int U_CARCD_DISC2 = 103;
    public static final int U_CARCD_DISC3 = 104;
    public static final int U_CARCD_DISC4 = 105;
    public static final int U_CARCD_DISC5 = 106;
    public static final int U_CARCD_DISC6 = 107;
    public static final int U_CARCD_MID = 137;
    public static final int U_CARCD_NUM = 109;
    public static final int U_CARCD_RANDOM = 123;
    public static final int U_CARCD_REPEAT = 122;
    public static final int U_CARCD_STATE = 108;
    public static final int U_CARCD_TOTALTIME_HOUR = 128;
    public static final int U_CARCD_TOTALTIME_MIN = 127;
    public static final int U_CARCD_TOTALTIME_SEC = 126;
    public static final int U_CARCD_TOTALTRACK = 124;
    public static final int U_CARCD_TRE = 136;
    public static final int U_CARCD_VOL = 138;
    public static final int U_CARCD_WORKSTATE = 110;
    public static final int U_CAREQ_FAD = 132;
    public static final int U_CARINFO_D35_D0_D1 = 139;
    public static final int U_CARINFO_D35_D2_D3 = 140;
    public static final int U_CARINFO_D35_D4_D5 = 141;
    public static final int U_CARINFO_D35_D6_D7 = 142;
    public static final int U_CARINFO_D35_D8_D9 = 143;
    public static final int U_CARRADIO_BAND = 111;
    public static final int U_CARRADIO_CHNEL = 112;
    public static final int U_CARRADIO_FRQ = 115;
    public static final int U_CARRADIO_FRQ1 = 116;
    public static final int U_CARRADIO_FRQ2 = 117;
    public static final int U_CARRADIO_FRQ3 = 118;
    public static final int U_CARRADIO_FRQ4 = 119;
    public static final int U_CARRADIO_FRQ5 = 120;
    public static final int U_CARRADIO_FRQ6 = 121;
    public static final int U_CARRADIO_SCAN = 113;
    public static final int U_CARRADIO_ST = 114;
    public static final int U_CARUSB_FOLDERNUM = 101;
    public static final int U_CARUSB_PLAYTIME_MIN = 97;
    public static final int U_CARUSB_PLAYTIME_SEC = 98;
    public static final int U_CARUSB_STATE = 96;
    public static final int U_CARUSB_TOTALTRACK = 100;
    public static final int U_CARUSB_TRACK = 99;
    public static final int U_CAR_EC_LEV = 144;
    public static final int U_CAR_PE_ENABLE = 145;
    public static final int U_CAR_PE_STATE = 146;
    public static final int U_CNT_MAX = 147;
    public static final int U_CUR_SPEED = 94;
    public static final int U_ENGINE_SPEED = 95;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_Luz_LexusIS(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
