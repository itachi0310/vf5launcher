package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xincheng_Lexus;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_XC_Lexus extends CallbackCanbusBase {
    public static final int U_CARCD_CURFILE = 131;
    public static final int U_CARCD_CURTIME_HOUR = 142;
    public static final int U_CARCD_CURTIME_MIN = 141;
    public static final int U_CARCD_CURTIME_SEC = 140;
    public static final int U_CARCD_CURTRACK = 133;
    public static final int U_CARCD_D72_ASL = 101;
    public static final int U_CARCD_D72_BAL = 99;
    public static final int U_CARCD_D72_BASS = 96;
    public static final int U_CARCD_D72_FAD = 100;
    public static final int U_CARCD_D72_MID = 97;
    public static final int U_CARCD_D72_TRE = 98;
    public static final int U_CARCD_D73_ASL = 107;
    public static final int U_CARCD_D73_BAL = 103;
    public static final int U_CARCD_D73_BASS = 104;
    public static final int U_CARCD_D73_FAD = 102;
    public static final int U_CARCD_D73_MID = 106;
    public static final int U_CARCD_D73_TRE = 105;
    public static final int U_CARCD_DISC1 = 110;
    public static final int U_CARCD_DISC2 = 111;
    public static final int U_CARCD_DISC3 = 112;
    public static final int U_CARCD_DISC4 = 113;
    public static final int U_CARCD_DISC5 = 114;
    public static final int U_CARCD_DISC6 = 115;
    public static final int U_CARCD_NUM = 117;
    public static final int U_CARCD_RANDOM = 138;
    public static final int U_CARCD_REPEAT = 137;
    public static final int U_CARCD_SCAN = 139;
    public static final int U_CARCD_STATE = 116;
    public static final int U_CARCD_TOTALFILE = 130;
    public static final int U_CARCD_TOTALTIME_HOUR = 136;
    public static final int U_CARCD_TOTALTIME_MIN = 135;
    public static final int U_CARCD_TOTALTIME_SEC = 134;
    public static final int U_CARCD_TOTALTRACK = 132;
    public static final int U_CARCD_WORKSTATE = 118;
    public static final int U_CAREQ_D72_MUTE = 94;
    public static final int U_CAREQ_D72_VOL = 95;
    public static final int U_CAREQ_D73_MUTE = 108;
    public static final int U_CAREQ_D73_VOL = 109;
    public static final int U_CARRADIO_BAND = 119;
    public static final int U_CARRADIO_CHNEL = 122;
    public static final int U_CARRADIO_FRQ = 123;
    public static final int U_CARRADIO_FRQ1 = 124;
    public static final int U_CARRADIO_FRQ2 = 125;
    public static final int U_CARRADIO_FRQ3 = 126;
    public static final int U_CARRADIO_FRQ4 = 127;
    public static final int U_CARRADIO_FRQ5 = 128;
    public static final int U_CARRADIO_FRQ6 = 129;
    public static final int U_CARRADIO_SCAN = 121;
    public static final int U_CARRADIO_ST = 120;
    public static final int U_CNT_MAX = 143;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 143; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Lexus(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 143) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
