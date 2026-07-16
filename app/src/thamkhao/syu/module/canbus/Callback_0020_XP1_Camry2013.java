package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0020_XP1_Camry2013;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0020_XP1_Camry2013 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 121;
    public static final int U_AIR_BY_AUTO_KEY = 127;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 117;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 118;
    public static final int U_AUTOLOCK_BY_SPEED = 116;
    public static final int U_AVERAGE_SPEED = 97;
    public static final int U_BATTERY_VOLTAGE = 94;
    public static final int U_BELT_LEFT = 155;
    public static final int U_BELT_RIGHT = 156;
    public static final int U_CARINFO_D1E_D4_B20 = 191;
    public static final int U_CARINFO_D1E_D4_B4 = 190;
    public static final int U_CARINFO_D1E_D4_B5 = 189;
    public static final int U_CARINFO_D1E_D4_B6 = 188;
    public static final int U_CARINFO_D1E_D4_B7 = 187;
    public static final int U_CARINF_EQ_ASL = 184;
    public static final int U_CARINF_EQ_BAL = 180;
    public static final int U_CARINF_EQ_BASS = 181;
    public static final int U_CARINF_EQ_FAD = 179;
    public static final int U_CARINF_EQ_MID = 183;
    public static final int U_CARINF_EQ_SUROUND = 186;
    public static final int U_CARINF_EQ_TREB = 182;
    public static final int U_CARINF_EQ_VOL = 185;
    public static final int U_CARSET_D26_D1_B3 = 194;
    public static final int U_CARSET_D26_D3_B10 = 196;
    public static final int U_CARSET_D26_D3_B54 = 195;
    public static final int U_CARSET_D26_D4_B10 = 200;
    public static final int U_CARSET_D26_D4_B32 = 199;
    public static final int U_CARSET_D26_D4_B4 = 198;
    public static final int U_CARSET_D26_D4_B65 = 197;
    public static final int U_CARSET_D26_D5_B30 = 202;
    public static final int U_CARSET_D26_D5_B54 = 201;
    public static final int U_CAR_CAMERA_LOUCS = 129;
    public static final int U_CAR_CAMERA_LOUCS_ENABLE = 130;
    public static final int U_CAR_EC_LEV = 193;
    public static final int U_CAR_PE_ENABLE = 95;
    public static final int U_CAR_PE_STATE = 96;
    public static final int U_CD_CURRENT_INDEX = 159;
    public static final int U_CD_CUR_DISC = 162;
    public static final int U_CD_CUR_INDEX = 165;
    public static final int U_CD_CUR_PLAYMODE = 163;
    public static final int U_CD_CUR_TIME = 167;
    public static final int U_CD_EXIST = 157;
    public static final int U_CD_MEDIA_STATE = 161;
    public static final int U_CD_STATE = 158;
    public static final int U_CD_TOTAL_INDEX = 164;
    public static final int U_CD_TOTAL_TIME = 166;
    public static final int U_CD_TYPE = 160;
    public static final int U_CLOSE_BIGLAMP_TIME = 115;
    public static final int U_CLOSE_INSIDELAMP_TIME = 114;
    public static final int U_CNT_MAX = 194;
    public static final int U_CUR_ENGINE_SPEED = 153;
    public static final int U_CUR_OIL_EXPEND = 100;
    public static final int U_CUR_SPEED = 154;
    public static final int U_CUR_TRIP_OIL_EXPEND = 101;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 112;
    public static final int U_DISPLAY_ENABLE_0 = 132;
    public static final int U_DISPLAY_ENABLE_1 = 133;
    public static final int U_DISPLAY_ENABLE_10 = 142;
    public static final int U_DISPLAY_ENABLE_11 = 143;
    public static final int U_DISPLAY_ENABLE_12 = 144;
    public static final int U_DISPLAY_ENABLE_13 = 145;
    public static final int U_DISPLAY_ENABLE_2 = 134;
    public static final int U_DISPLAY_ENABLE_3 = 135;
    public static final int U_DISPLAY_ENABLE_4 = 136;
    public static final int U_DISPLAY_ENABLE_5 = 137;
    public static final int U_DISPLAY_ENABLE_6 = 138;
    public static final int U_DISPLAY_ENABLE_7 = 139;
    public static final int U_DISPLAY_ENABLE_8 = 140;
    public static final int U_DISPLAY_ENABLE_9 = 141;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 98;
    public static final int U_ENGINE_SPEED = 151;
    public static final int U_EXIST_TPMS = 103;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 128;
    public static final int U_JUMP_SOS_PAGE = 192;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 131;
    public static final int U_LAST_OIL = 150;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 120;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 125;
    public static final int U_PARK_BESIDE_ROAD = 152;
    public static final int U_PRESSURE_BACKUP = 111;
    public static final int U_PRESSURE_FL = 107;
    public static final int U_PRESSURE_FR = 108;
    public static final int U_PRESSURE_RL = 109;
    public static final int U_PRESSURE_RR = 110;
    public static final int U_REMOTE_2PRESS_UNLOCK = 119;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 113;
    public static final int U_SHOW_TIRE_BACKUP = 105;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 124;
    public static final int U_TIRE_SHOW_STATE = 106;
    public static final int U_TPMS_STATE = 104;
    public static final int U_TRIP_OIL_EXPEND = 102;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 122;
    public static final int U_UNLOCK_BY_SMART_DOOR = 123;
    public static final int U_WARNNING_CLEANNING_FLUID = 148;
    public static final int U_WARNNING_HANDLE_BRAKE = 149;
    public static final int U_WARNNING_LIFE_BELT = 147;
    public static final int U_WARNNING_LOW_BATTERY = 146;
    public static final int U_WARNNING_LOW_OIL = 126;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 194; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0020_XP1_Camry2013(TheApp.getInstance()));
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
                case 102:
                    TripOilExpand(updateCode, ints);
                    break;
                case 131:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 192:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 194) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 192) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
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
