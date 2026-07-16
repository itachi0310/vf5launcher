package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.hava.ActivityHavaH7CarCD;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0244_RZC_HavaH2S_HongBiao;
import com.syu.ui.air.Air_0244_RZC_HavaH2_HongBiao;
import com.syu.ui.air.Air_0244_RZC_HavaH2_LanBiao;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0244_RZC_XP1_HavalH2 extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String Title = null;
    public static final int U_CAREQ_BAL = 136;
    public static final int U_CAREQ_BASS = 135;
    public static final int U_CAREQ_FAD = 137;
    public static final int U_CAREQ_MID = 134;
    public static final int U_CAREQ_SPEED_VOL = 139;
    public static final int U_CAREQ_SURROUND_VOL = 138;
    public static final int U_CAREQ_TREB = 133;
    public static final int U_CAREQ_VOL = 132;
    public static final int U_CARINFO_ALL_TERRAIN = 112;
    public static final int U_CARINFO_ALS = 102;
    public static final int U_CARINFO_ANTITHEFT = 108;
    public static final int U_CARINFO_AUTO_BRAKE = 114;
    public static final int U_CARINFO_BATTERY_VOLGATE = 95;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_CARTOP = 111;
    public static final int U_CARINFO_COLLISION_WARN = 113;
    public static final int U_CARINFO_COOLANT_TEMP = 96;
    public static final int U_CARINFO_D29_D03_B70 = 155;
    public static final int U_CARINFO_D31_D03_B02 = 119;
    public static final int U_CARINFO_D31_D04_B00 = 126;
    public static final int U_CARINFO_D31_D04_B01 = 125;
    public static final int U_CARINFO_D31_D04_B02 = 124;
    public static final int U_CARINFO_D31_D04_B03 = 123;
    public static final int U_CARINFO_D31_D04_B06 = 121;
    public static final int U_CARINFO_D31_D04_B07 = 120;
    public static final int U_CARINFO_D31_D04_B54 = 122;
    public static final int U_CARINFO_D31_D05_B03 = 131;
    public static final int U_CARINFO_D31_D05_B04 = 130;
    public static final int U_CARINFO_D31_D05_B05 = 129;
    public static final int U_CARINFO_D31_D05_B06 = 128;
    public static final int U_CARINFO_D31_D05_B07 = 127;
    public static final int U_CARINFO_D31_D05_B20 = 161;
    public static final int U_CARINFO_D31_D07_B32 = 163;
    public static final int U_CARINFO_D31_D07_B7 = 162;
    public static final int U_CARINFO_D31_D08_B10 = 166;
    public static final int U_CARINFO_D31_D08_B32 = 165;
    public static final int U_CARINFO_D31_D08_B7 = 164;
    public static final int U_CARINFO_D31_D09_B03 = 154;
    public static final int U_CARINFO_D31_D09_B4 = 159;
    public static final int U_CARINFO_D31_D09_B5 = 158;
    public static final int U_CARINFO_D31_D09_B6 = 157;
    public static final int U_CARINFO_D31_D09_B7 = 156;
    public static final int U_CARINFO_DOMEDELAY = 98;
    public static final int U_CARINFO_DOORCTRL = 109;
    public static final int U_CARINFO_END = 117;
    public static final int U_CARINFO_FOLLOWHOME = 99;
    public static final int U_CARINFO_FRONT_LIGHT = 105;
    public static final int U_CARINFO_INTELLIGENT_START_STOP = 115;
    public static final int U_CARINFO_NEWADD = 118;
    public static final int U_CARINFO_PARKING = 107;
    public static final int U_CARINFO_POWERSAVE = 100;
    public static final int U_CARINFO_RAINFALLSENSOR = 101;
    public static final int U_CARINFO_REARVIEW_ATUO = 104;
    public static final int U_CARINFO_SEAT_REM = 106;
    public static final int U_CARINFO_SIDESTEP = 110;
    public static final int U_CARINFO_TRAILER = 116;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 97;
    public static final int U_CAR_AMP_ONOFF = 152;
    public static final int U_CAR_AMP_T = 141;
    public static final int U_CAR_AMP_V = 140;
    public static final int U_CAR_CD_ALBUM = 150;
    public static final int U_CAR_CD_ARTIST = 151;
    public static final int U_CAR_CD_ONOFF = 153;
    public static final int U_CAR_CD_PALYTIME = 148;
    public static final int U_CAR_CD_PLAYSTATE = 143;
    public static final int U_CAR_CD_STATE = 142;
    public static final int U_CAR_CD_TIME_TOTAL = 147;
    public static final int U_CAR_CD_TITLE = 149;
    public static final int U_CAR_CD_TRACK = 146;
    public static final int U_CAR_CD_TRACK_CNT = 145;
    public static final int U_CAR_CD_WORKSTATE = 144;
    public static final int U_CNT_MAX = 167;
    public static final int U_SCREEN_BRIGHT_ADJUST = 103;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 160;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 167; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 262388 || DataCanbus.DATA[1000] == 244 || DataCanbus.DATA[1000] == 327924) {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_LanBiao(TheApp.getInstance()));
        } else if (DataCanbus.DATA[1000] == 393460 || DataCanbus.DATA[1000] == 721140) {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2S_HongBiao(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_HongBiao(TheApp.getInstance()));
        }
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 167) {
            switch (updateCode) {
                case 142:
                    if (DataCanbus.DATA[updateCode] == 1 && !ActivityHavaH7CarCD.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hava.ActivityHavaH7CarCD");
                        break;
                    }
                    break;
                case 149:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 150:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 151:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 167) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
