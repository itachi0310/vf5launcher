package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Luz_Toyota_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_LUZ_Toyato_All extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 106;
    public static final int U_AIR_BY_AUTO_KEY = 112;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 102;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 103;
    public static final int U_AUTOLOCK_BY_SPEED = 101;
    public static final int U_AVERAGE_SPEED = 148;
    public static final int U_CARAIR_CTRL_TYPE = 140;
    public static final int U_CARAUX_CTRL_TYPE = 139;
    public static final int U_CARINFO_AUTO_RELOCK_TIME = 116;
    public static final int U_CARINF_EQ_ASL = 129;
    public static final int U_CARINF_EQ_BAL = 125;
    public static final int U_CARINF_EQ_BASS = 126;
    public static final int U_CARINF_EQ_FAD = 124;
    public static final int U_CARINF_EQ_MID = 128;
    public static final int U_CARINF_EQ_POS = 142;
    public static final int U_CARINF_EQ_SUROUND = 131;
    public static final int U_CARINF_EQ_TREB = 127;
    public static final int U_CARINF_EQ_VOL = 130;
    public static final int U_CARINF_SYSEQ_VOL = 132;
    public static final int U_CARSET_OIL_UNIT = 146;
    public static final int U_CAR_ANDROID_UI_VOL = 141;
    public static final int U_CAR_BELT_STATE = 133;
    public static final int U_CAR_CAMERA_LOUCS = 114;
    public static final int U_CAR_HANDBRAKE_STATE = 134;
    public static final int U_CAR_LIGHT_FAR = 135;
    public static final int U_CAR_REARSCREEN_LOCK = 144;
    public static final int U_CAR_SCREEN_H = 137;
    public static final int U_CAR_SCREEN_W = 136;
    public static final int U_CAR_SET_TYPE = 143;
    public static final int U_CAR_UI_VOL = 138;
    public static final int U_CLOSE_BIGLAMP_TIME = 100;
    public static final int U_CLOSE_INSIDELAMP_TIME = 99;
    public static final int U_CNT_MAX = 149;
    public static final int U_CUR_OIL_EXPEND = 145;
    public static final int U_CUR_TRIP_OIL_EXPEND = 95;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 97;
    public static final int U_DRIVING_MILEAGE = 94;
    public static final int U_DRIVING_TIME = 147;
    public static final int U_INFO_CAR_AIR_INOUT_SENSOR = 117;
    public static final int U_INFO_CAR_DRIVE_MILEAGE = 120;
    public static final int U_INFO_CAR_SEAT_AUTO = 118;
    public static final int U_INFO_CAR_TOTAL_MILEAGE = 119;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 113;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 115;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 105;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 110;
    public static final int U_RADARR_ONOFF = 122;
    public static final int U_RADARR_VOL_LEV = 123;
    public static final int U_RADAR_REAR_DISTANCE = 121;
    public static final int U_REMOTE_2PRESS_UNLOCK = 104;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 98;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 109;
    public static final int U_TRIP_OIL_EXPEND = 96;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 107;
    public static final int U_UNLOCK_BY_SMART_DOOR = 108;
    public static final int U_WARNNING_LOW_OIL = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 149; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] != 2621894) {
            AirHelper.getInstance().buildUi(new Air_0439_Luz_Toyota_All(TheApp.getInstance()));
            for (int i2 = 10; i2 < 93; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 96:
                    TripOilExpand(updateCode, ints);
                    break;
                case 115:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 149) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
