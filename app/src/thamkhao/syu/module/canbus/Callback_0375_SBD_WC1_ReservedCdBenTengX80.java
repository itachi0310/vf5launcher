package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0375_SBD_BenTengX80;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0375_SBD_WC1_ReservedCdBenTengX80 extends CallbackCanbusBase {
    public static String Str1 = null;
    public static String Str2 = null;
    public static String Str3 = null;
    public static String Str4 = null;
    public static String Str5 = null;
    public static String Str6 = null;
    public static final int U_2TIMES_KEY_UNLOCK = 120;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 107;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 113;
    public static final int U_AUTOLOCK_BY_SPEED = 111;
    public static final int U_AUTO_AC_ENABLED = 103;
    public static final int U_BATTERY_VOLTAGE = 135;
    public static final int U_CARINFO_START = 94;
    public static final int U_CAR_CURR_SOURCE = 139;
    public static final int U_CAR_MID_ENABLE = 140;
    public static final int U_CAR_PLAY_PROGRESS = 141;
    public static final int U_CAR_PLAY_STATE = 142;
    public static final int U_CAR_STRS_STATE_FIVE = 118;
    public static final int U_CAR_STRS_STATE_FOUR = 117;
    public static final int U_CAR_STRS_STATE_ONE = 112;
    public static final int U_CAR_STRS_STATE_THERE = 116;
    public static final int U_CAR_STRS_STATE_TWO = 115;
    public static final int U_CLOSE_BIGLAMP_TIME = 110;
    public static final int U_CLOSE_INSIDELAMP_TIME = 109;
    public static final int U_CNT_MAX = 144;
    public static final int U_CUR_OIL_EXPEND = 97;
    public static final int U_CUR_TRIP_OIL_EXPEND = 100;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 108;
    public static final int U_DISPLAY_ENABLE_0 = 96;
    public static final int U_DISPLAY_ENABLE_11 = 136;
    public static final int U_DISPLAY_ENABLE_16 = 143;
    public static final int U_DISPLAY_ENABLE_19 = 95;
    public static final int U_DRIVING_TIME = 99;
    public static final int U_FEEDBACK_LAMP_ENABLED = 102;
    public static final int U_LAST_OIL = 134;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 119;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 124;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 106;
    public static final int U_OPTIMAL_OIL_EXPEND = 98;
    public static final int U_PARK_BESIDE_ROAD = 137;
    public static final int U_PARK_IN_CARPORT = 138;
    public static final int U_PRESSURE_FL = 128;
    public static final int U_PRESSURE_FR = 129;
    public static final int U_RADAR_VOL = 126;
    public static final int U_REMOTE_2PRESS_UNLOCK = 114;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 105;
    public static final int U_SHOW_RADAR = 125;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 123;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 101;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 121;
    public static final int U_UNLOCK_BY_SMART_DOOR = 122;
    public static final int U_VALID_VENTILATION_ENABLED = 104;
    public static final int U_WARNNING_CLEANNING_FLUID = 132;
    public static final int U_WARNNING_HANDLE_BRAKE = 133;
    public static final int U_WARNNING_LIFE_BELT = 131;
    public static final int U_WARNNING_LOW_BATTERY = 130;
    public static final int U_WARNNING_LOW_OIL = 127;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carId != 3) {
            AirHelper.getInstance().buildUi(new Air_0375_SBD_BenTengX80(TheApp.getInstance()));
            for (int i2 = 10; i2 < 93; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 112:
                if (strs != null && strs.length > 0) {
                    Str1 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 113:
            case 114:
            default:
                if (updateCode >= 0 && updateCode < 144) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
            case 115:
                if (strs != null && strs.length > 0) {
                    Str2 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 116:
                if (strs != null && strs.length > 0) {
                    Str3 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 117:
                if (strs != null && strs.length > 0) {
                    Str4 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 118:
                if (strs != null && strs.length > 0) {
                    Str5 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
        }
    }
}
