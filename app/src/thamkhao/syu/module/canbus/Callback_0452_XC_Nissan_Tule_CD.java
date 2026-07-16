package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xinchi_Nissan_Tule_CD;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_XC_Nissan_Tule_CD extends CallbackCanbusBase {
    public static final int U_CARCD_PLAYSTATE = 118;
    public static final int U_CARCD_PLAY_TIME = 121;
    public static final int U_CARCD_PLAY_TRACK = 123;
    public static final int U_CARCD_RANDOM = 119;
    public static final int U_CARCD_REPEAT = 120;
    public static final int U_CARCD_TOTAL_TIME = 122;
    public static final int U_CARCD_TOTAL_TRACK = 124;
    public static final int U_CAREQ_BAL = 139;
    public static final int U_CAREQ_BASS = 137;
    public static final int U_CAREQ_BOSS_CENTERPOINT = 142;
    public static final int U_CAREQ_DRIVER = 144;
    public static final int U_CAREQ_FAD = 140;
    public static final int U_CAREQ_SPEED_VOL = 141;
    public static final int U_CAREQ_SURROUND = 143;
    public static final int U_CAREQ_TRE = 138;
    public static final int U_CAREQ_VOL = 136;
    public static final int U_CARINFO_AVG_OIL = 106;
    public static final int U_CARINFO_MILE = 105;
    public static final int U_CARINFO_TOTAL_MILE = 104;
    public static final int U_CARRADIO_BAND = 109;
    public static final int U_CARRADIO_CUR_CH = 111;
    public static final int U_CARRADIO_CUR_FRQ = 110;
    public static final int U_CARRADIO_FRQ1 = 112;
    public static final int U_CARRADIO_FRQ2 = 113;
    public static final int U_CARRADIO_FRQ3 = 114;
    public static final int U_CARRADIO_FRQ4 = 115;
    public static final int U_CARRADIO_FRQ5 = 116;
    public static final int U_CARRADIO_FRQ6 = 117;
    public static final int U_CARRADIO_SCAN = 108;
    public static final int U_CARSET_D6C_D0_B70 = 126;
    public static final int U_CARSET_D6C_D1_B70 = 127;
    public static final int U_CARSET_D6C_D2_B70 = 128;
    public static final int U_CARSET_D6D_D0_B0 = 133;
    public static final int U_CARSET_D6D_D0_B1 = 132;
    public static final int U_CARSET_D6D_D0_B2 = 131;
    public static final int U_CARSET_D6D_D0_B3 = 130;
    public static final int U_CARSET_D6D_D0_B4 = 129;
    public static final int U_CARSET_D6D_D1_B70 = 134;
    public static final int U_CARSET_D6D_D2_B70 = 135;
    public static final int U_CARSET_D70_D0_B70 = 158;
    public static final int U_CARSET_D70_D1_B70 = 159;
    public static final int U_CARSET_D70_D2_B70 = 160;
    public static final int U_CARSET_D70_D3_B70 = 161;
    public static final int U_CARSET_D70_D4_B70 = 162;
    public static final int U_CARSET_D71_D0_B0 = 168;
    public static final int U_CARSET_D71_D0_B1 = 167;
    public static final int U_CARSET_D71_D0_B2 = 166;
    public static final int U_CARSET_D71_D0_B3 = 165;
    public static final int U_CARSET_D71_D0_B4 = 164;
    public static final int U_CARSET_D71_D0_B5 = 163;
    public static final int U_CAR_REAR_D72_D0_B0 = 149;
    public static final int U_CAR_REAR_D72_D0_B1 = 148;
    public static final int U_CAR_REAR_D72_D0_B32 = 147;
    public static final int U_CAR_REAR_D72_D0_B54 = 146;
    public static final int U_CAR_REAR_D72_D0_B76 = 145;
    public static final int U_CAR_REAR_D72_D1_B6 = 151;
    public static final int U_CAR_REAR_D72_D1_B7 = 150;
    public static final int U_CAR_REAR_D73_ALBUM = 157;
    public static final int U_CAR_REAR_D73_ARTIST = 156;
    public static final int U_CAR_REAR_D73_D0_B65 = 153;
    public static final int U_CAR_REAR_D73_D0_B7 = 152;
    public static final int U_CAR_REAR_D73_PLAYTIME = 154;
    public static final int U_CAR_REAR_D73_TITLE = 155;
    public static final int U_CAR_SOURCE_ID = 125;
    public static final int U_CAR_TIRE_BEGIN = 94;
    public static final int U_CAR_TIRE_END = 103;
    public static final int U_CAR_TIRE_VALUE_FL = 95;
    public static final int U_CAR_TIRE_VALUE_FR = 96;
    public static final int U_CAR_TIRE_VALUE_RL = 97;
    public static final int U_CAR_TIRE_VALUE_RR = 98;
    public static final int U_CAR_TIRE_WARN_FL = 99;
    public static final int U_CAR_TIRE_WARN_FR = 100;
    public static final int U_CAR_TIRE_WARN_RL = 101;
    public static final int U_CAR_TIRE_WARN_RR = 102;
    public static final int U_CNT_MAX = 169;
    public static final int U_CUR_MOTOR_SPEED = 107;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 169; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_Xinchi_Nissan_Tule_CD(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 169) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
