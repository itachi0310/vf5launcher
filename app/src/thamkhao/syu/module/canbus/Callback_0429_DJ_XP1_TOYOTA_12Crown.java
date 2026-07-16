package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.dj.huangguan.ActivityCarCD;
import com.syu.carinfo.dj.huangguan.ActivityCarRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0429_DJ_XP1_TOYOTA_12Crown_Low;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0429_DJ_XP1_TOYOTA_12Crown extends CallbackCanbusBase {
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int U_AVERAGE_SPEED = 121;
    public static final int U_CAREQ_ACOUSTIC = 117;
    public static final int U_CAREQ_BAL = 111;
    public static final int U_CAREQ_BASS = 112;
    public static final int U_CAREQ_FAD = 110;
    public static final int U_CAREQ_MID = 114;
    public static final int U_CAREQ_POSITION = 118;
    public static final int U_CAREQ_TRE = 113;
    public static final int U_CAREQ_VOL = 115;
    public static final int U_CAREQ_VOL_SPEED = 116;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 102;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 107;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 106;
    public static final int U_CARINFO_DVD_ID = 101;
    public static final int U_CARINFO_DVD_PLAYTIME = 108;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 105;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 104;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 103;
    public static final int U_CARINFO_END = 109;
    public static final int U_CARINFO_RADIO_BAND = 95;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 97;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 99;
    public static final int U_CARINFO_RADIO_FREQ = 96;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 98;
    public static final int U_CARINFO_SOURCE = 94;
    public static final int U_CARSET_D26_D0_B10 = 133;
    public static final int U_CARSET_D26_D0_B32 = 132;
    public static final int U_CARSET_D26_D0_B64 = 131;
    public static final int U_CARSET_D26_D0_B7 = 130;
    public static final int U_CARSET_D26_D1_B20 = 138;
    public static final int U_CARSET_D26_D1_B4 = 137;
    public static final int U_CARSET_D26_D1_B5 = 136;
    public static final int U_CARSET_D26_D1_B6 = 135;
    public static final int U_CARSET_D26_D1_B7 = 134;
    public static final int U_CARSET_D26_D2_B20 = 144;
    public static final int U_CARSET_D26_D2_B3 = 143;
    public static final int U_CARSET_D26_D2_B4 = 142;
    public static final int U_CARSET_D26_D2_B5 = 141;
    public static final int U_CARSET_D26_D2_B6 = 140;
    public static final int U_CARSET_D26_D2_B7 = 139;
    public static final int U_CARSET_D26_D3_B10 = 148;
    public static final int U_CARSET_D26_D3_B32 = 147;
    public static final int U_CARSET_D26_D3_B6 = 146;
    public static final int U_CARSET_D26_D3_B7 = 145;
    public static final int U_CARSET_D50_D0_B10 = 151;
    public static final int U_CARSET_D50_D0_B32 = 150;
    public static final int U_CARSET_D50_D0_B54 = 149;
    public static final int U_CARSET_D50_D1_B70 = 152;
    public static final int U_CARSET_D52_D0_B7 = 153;
    public static final int U_CARSET_D52_D1_B7 = 154;
    public static final int U_CARSET_D52_D2_B20 = 155;
    public static final int U_CARSET_D5A_D0_D1 = 156;
    public static final int U_CARSET_D5A_D10_B1 = 165;
    public static final int U_CARSET_D5A_D10_B2 = 164;
    public static final int U_CARSET_D5A_D10_B3 = 163;
    public static final int U_CARSET_D5A_D10_B54 = 162;
    public static final int U_CARSET_D5A_D10_B76 = 161;
    public static final int U_CARSET_D5A_D2_D3 = 157;
    public static final int U_CARSET_D5A_D4_D5 = 158;
    public static final int U_CARSET_D5A_D6_D7 = 159;
    public static final int U_CARSET_D5A_D8_D9 = 160;
    public static final int U_CARSET_OIL_UNIT = 128;
    public static final int U_CAR_JUMP_DISC = 120;
    public static final int U_CAR_JUMP_RADIO = 119;
    public static final int U_CNT_MAX = 166;
    public static final int U_CUR_OIL_EXPEND = 124;
    public static final int U_CUR_TRIP_OIL_EXPEND = 125;
    public static final int U_DRIVING_MILEAGE = 123;
    public static final int U_DRIVING_TIME = 122;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 129;
    public static final int U_TRIP_OIL_EXPEND = 126;
    public static final int U_WARNNING_LIFE_BELT = 127;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 166; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0429_DJ_XP1_TOYOTA_12Crown_Low(TheApp.getInstance()));
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
        if (updateCode >= 0) {
            if (updateCode == 99) {
                CHANNEL_FREQ_PRESET = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode == 119) {
                int value = ints[0];
                if (value == 1 && !ActivityCarRadio.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarRadio");
                    return;
                }
                return;
            }
            if (updateCode == 120) {
                int value2 = ints[0];
                if (value2 == 1 && !ActivityCarCD.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarCD");
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
