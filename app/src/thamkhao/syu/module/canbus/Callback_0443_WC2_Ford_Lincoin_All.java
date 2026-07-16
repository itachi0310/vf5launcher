package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Ford_Lincoin_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Ford_Lincoin_All extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String RadioText = null;
    public static String Title = null;
    public static final int U_CARCD_ARTIST = 153;
    public static final int U_CARCD_BEGIN = 145;
    public static final int U_CARCD_END = 154;
    public static final int U_CARCD_PLAYTIME = 148;
    public static final int U_CARCD_PLAYTRACK = 150;
    public static final int U_CARCD_RANDOM = 147;
    public static final int U_CARCD_REPEAT = 146;
    public static final int U_CARCD_STATE = 145;
    public static final int U_CARCD_TITLE = 152;
    public static final int U_CARCD_TOTALTIME = 149;
    public static final int U_CARCD_TOTALTRACK = 151;
    public static final int U_CAREQ_BAL = 108;
    public static final int U_CAREQ_BASS = 110;
    public static final int U_CAREQ_BEGIN = 107;
    public static final int U_CAREQ_END = 115;
    public static final int U_CAREQ_FAD = 109;
    public static final int U_CAREQ_MID = 111;
    public static final int U_CAREQ_SURROUND = 114;
    public static final int U_CAREQ_TREB = 112;
    public static final int U_CAREQ_VOL = 107;
    public static final int U_CAREQ_VOL_LINK_SPEED = 113;
    public static final int U_CARINFO_AMBIENT_LIGHT = 102;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_DAY = 96;
    public static final int U_CARINFO_DRIVING_TIME = 103;
    public static final int U_CARINFO_END = 106;
    public static final int U_CARINFO_HOUR = 97;
    public static final int U_CARINFO_LANGUAGE = 100;
    public static final int U_CARINFO_MEASURE = 101;
    public static final int U_CARINFO_MINUTE = 98;
    public static final int U_CARINFO_MONTH = 95;
    public static final int U_CARINFO_PASSWORD_PROMPT = 105;
    public static final int U_CARINFO_RADAR_DISPLAY = 104;
    public static final int U_CARINFO_SECOND = 98;
    public static final int U_CARINFO_TOTAL_DISTANCE = 99;
    public static final int U_CARINFO_YEAR = 94;
    public static final int U_CARRADIO_AUTOP = 140;
    public static final int U_CARRADIO_BAND = 117;
    public static final int U_CARRADIO_BAND_TYPE = 143;
    public static final int U_CARRADIO_BEGIN = 116;
    public static final int U_CARRADIO_END = 144;
    public static final int U_CARRADIO_FRQ = 118;
    public static final int U_CARRADIO_FRQ1 = 119;
    public static final int U_CARRADIO_FRQ10 = 128;
    public static final int U_CARRADIO_FRQ11 = 129;
    public static final int U_CARRADIO_FRQ12 = 130;
    public static final int U_CARRADIO_FRQ13 = 131;
    public static final int U_CARRADIO_FRQ14 = 132;
    public static final int U_CARRADIO_FRQ15 = 133;
    public static final int U_CARRADIO_FRQ16 = 134;
    public static final int U_CARRADIO_FRQ17 = 135;
    public static final int U_CARRADIO_FRQ18 = 136;
    public static final int U_CARRADIO_FRQ2 = 120;
    public static final int U_CARRADIO_FRQ3 = 121;
    public static final int U_CARRADIO_FRQ4 = 122;
    public static final int U_CARRADIO_FRQ5 = 123;
    public static final int U_CARRADIO_FRQ6 = 124;
    public static final int U_CARRADIO_FRQ7 = 125;
    public static final int U_CARRADIO_FRQ8 = 126;
    public static final int U_CARRADIO_FRQ9 = 127;
    public static final int U_CARRADIO_RDS = 137;
    public static final int U_CARRADIO_SCAN = 138;
    public static final int U_CARRADIO_ST = 139;
    public static final int U_CARRADIO_TXT_INFO = 142;
    public static final int U_CARRADIO_TXT_SHOW = 141;
    public static final int U_CARSET_D61_D9_B70 = 157;
    public static final int U_CARSET_DE8_D0_B2 = 156;
    public static final int U_CARSET_DE8_D0_B3 = 155;
    public static final int U_CNT_MAX = 158;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 158; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Ford_Lincoin_All(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 158) {
            switch (updateCode) {
                case 152:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 153:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 158) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
