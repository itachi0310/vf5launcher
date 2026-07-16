package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0454_TD_Lexus_All extends CallbackCanbusBase {
    public static final int U_CARCD_ASL = 134;
    public static final int U_CARCD_BAL = 133;
    public static final int U_CARCD_BASS = 135;
    public static final int U_CARCD_CURTIME_HOUR = 129;
    public static final int U_CARCD_CURTIME_MIN = 128;
    public static final int U_CARCD_CURTIME_SEC = 127;
    public static final int U_CARCD_CURTRACK = 123;
    public static final int U_CARCD_DISC1 = 94;
    public static final int U_CARCD_DISC1_TYPE = 102;
    public static final int U_CARCD_DISC2 = 95;
    public static final int U_CARCD_DISC2_TYPE = 103;
    public static final int U_CARCD_DISC3 = 96;
    public static final int U_CARCD_DISC3_TYPE = 104;
    public static final int U_CARCD_DISC4 = 97;
    public static final int U_CARCD_DISC4_TYPE = 105;
    public static final int U_CARCD_DISC5 = 98;
    public static final int U_CARCD_DISC5_TYPE = 106;
    public static final int U_CARCD_DISC6 = 99;
    public static final int U_CARCD_DISC6_TYPE = 107;
    public static final int U_CARCD_MID = 137;
    public static final int U_CARCD_NUM = 101;
    public static final int U_CARCD_RANDOM = 121;
    public static final int U_CARCD_REPEAT = 120;
    public static final int U_CARCD_STATE = 100;
    public static final int U_CARCD_TOTALTIME_HOUR = 126;
    public static final int U_CARCD_TOTALTIME_MIN = 125;
    public static final int U_CARCD_TOTALTIME_SEC = 124;
    public static final int U_CARCD_TOTALTRACK = 122;
    public static final int U_CARCD_TRE = 136;
    public static final int U_CARCD_VOL = 138;
    public static final int U_CARCD_WORKSTATE = 108;
    public static final int U_CAREQ_FAD = 132;
    public static final int U_CARRADIO_BAND = 109;
    public static final int U_CARRADIO_CHNEL = 110;
    public static final int U_CARRADIO_FRQ = 113;
    public static final int U_CARRADIO_FRQ1 = 114;
    public static final int U_CARRADIO_FRQ2 = 115;
    public static final int U_CARRADIO_FRQ3 = 116;
    public static final int U_CARRADIO_FRQ4 = 117;
    public static final int U_CARRADIO_FRQ5 = 118;
    public static final int U_CARRADIO_FRQ6 = 119;
    public static final int U_CARRADIO_SCAN = 111;
    public static final int U_CARRADIO_ST = 112;
    public static final int U_CARUSB_CURTIME_HOUR = 139;
    public static final int U_CARUSB_CURTIME_MIN = 138;
    public static final int U_CARUSB_CURTIME_SEC = 137;
    public static final int U_CARUSB_RANDOM = 131;
    public static final int U_CARUSB_REPEAT = 130;
    public static final int U_CARUSB_TOTALTIME_HOUR = 136;
    public static final int U_CARUSB_TOTALTIME_MIN = 135;
    public static final int U_CARUSB_TOTALTIME_SEC = 134;
    public static final int U_CARUSB_TOTALTRACK = 133;
    public static final int U_CARUSB_TRACK = 132;
    public static final int U_CAR_D66_D2_B6 = 140;
    public static final int U_CAR_D66_D2_B7 = 139;
    public static final int U_CAR_D68_D0_B0 = 141;
    public static final int U_CAR_D68_D0_B1 = 142;
    public static final int U_CAR_D68_D0_B2 = 143;
    public static final int U_CAR_D68_D0_B3 = 144;
    public static final int U_CAR_D68_D0_B4 = 145;
    public static final int U_CAR_D68_D0_B5 = 146;
    public static final int U_CAR_D70_D0_D1 = 147;
    public static final int U_CAR_D70_D2_D3 = 148;
    public static final int U_CAR_D70_D4_D5 = 149;
    public static final int U_CAR_D70_D6_D7 = 150;
    public static final int U_CAR_D70_D8_B70 = 151;
    public static final int U_CNT_MAX = 152;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
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
        if (updateCode >= 0 && updateCode < 152) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
