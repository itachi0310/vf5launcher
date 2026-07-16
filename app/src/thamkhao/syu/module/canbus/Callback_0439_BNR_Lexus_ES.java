package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_BNR_Toyota;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_BNR_Lexus_ES extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int U_CAR_AUDIO_ASL = 154;
    public static final int U_CAR_AUDIO_BAL = 150;
    public static final int U_CAR_AUDIO_BASS = 151;
    public static final int U_CAR_AUDIO_FAD = 149;
    public static final int U_CAR_AUDIO_MID = 153;
    public static final int U_CAR_AUDIO_SPEED = 156;
    public static final int U_CAR_AUDIO_STATE = 148;
    public static final int U_CAR_AUDIO_TREB = 152;
    public static final int U_CAR_AUDIO_VOL = 155;
    public static final int U_CAR_CD1_STATE = 96;
    public static final int U_CAR_CD1_TYPE = 104;
    public static final int U_CAR_CD2_STATE = 97;
    public static final int U_CAR_CD2_TYPE = 105;
    public static final int U_CAR_CD3_STATE = 98;
    public static final int U_CAR_CD3_TYPE = 106;
    public static final int U_CAR_CD4_STATE = 99;
    public static final int U_CAR_CD4_TYPE = 107;
    public static final int U_CAR_CD5_STATE = 100;
    public static final int U_CAR_CD5_TYPE = 108;
    public static final int U_CAR_CD6_STATE = 101;
    public static final int U_CAR_CD6_TYPE = 109;
    public static final int U_CAR_CD_BEGIN = 95;
    public static final int U_CAR_CD_END = 120;
    public static final int U_CAR_CD_HOUR_CUR = 117;
    public static final int U_CAR_CD_HOUR_TOTAL = 114;
    public static final int U_CAR_CD_MIN_CUR = 118;
    public static final int U_CAR_CD_MIN_TOTAL = 115;
    public static final int U_CAR_CD_NUM = 103;
    public static final int U_CAR_CD_RANDOM = 111;
    public static final int U_CAR_CD_REPEAT = 110;
    public static final int U_CAR_CD_SEC_CUR = 119;
    public static final int U_CAR_CD_SEC_TOTAL = 116;
    public static final int U_CAR_CD_TOTALTRACK = 112;
    public static final int U_CAR_CD_TRACK = 113;
    public static final int U_CAR_CD_WORKSTATE = 102;
    public static final int U_CAR_RADIO_BAND = 122;
    public static final int U_CAR_RADIO_BEGIN = 121;
    public static final int U_CAR_RADIO_END = 133;
    public static final int U_CAR_RADIO_FREQ = 126;
    public static final int U_CAR_RADIO_FREQ1 = 127;
    public static final int U_CAR_RADIO_FREQ2 = 128;
    public static final int U_CAR_RADIO_FREQ3 = 129;
    public static final int U_CAR_RADIO_FREQ4 = 130;
    public static final int U_CAR_RADIO_FREQ5 = 131;
    public static final int U_CAR_RADIO_FREQ6 = 132;
    public static final int U_CAR_RADIO_NUM = 125;
    public static final int U_CAR_RADIO_SCAN_STATE = 124;
    public static final int U_CAR_RADIO_ST_STATE = 123;
    public static final int U_CAR_REARCD_BEGIN = 134;
    public static final int U_CAR_REARCD_HOUR_CUR = 145;
    public static final int U_CAR_REARCD_HOUR_TOTAL = 142;
    public static final int U_CAR_REARCD_MIN_CUR = 146;
    public static final int U_CAR_REARCD_MIN_TOTAL = 143;
    public static final int U_CAR_REARCD_RANDOM = 139;
    public static final int U_CAR_REARCD_REPEAT = 138;
    public static final int U_CAR_REARCD_SEC_CUR = 147;
    public static final int U_CAR_REARCD_SEC_TOTAL = 144;
    public static final int U_CAR_REARCD_STATE = 135;
    public static final int U_CAR_REARCD_TOTALTRACK = 140;
    public static final int U_CAR_REARCD_TRACK = 141;
    public static final int U_CAR_REARCD_TYPE = 136;
    public static final int U_CAR_REARCD_WORKSTATE = 137;
    public static final int U_CNT_MAX = 157;
    public static final int U_RADAR_VOL = 94;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 157; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_BNR_Toyota(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 157) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
