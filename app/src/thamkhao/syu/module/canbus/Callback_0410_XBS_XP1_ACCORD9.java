package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0410_XBS_XP1_ACCORD9;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0410_XBS_XP1_ACCORD9 extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 12;
    public static final int U_AVERAGE_OIL_CONSUMPTION = 97;
    public static final int U_AVERAGE_OIL_CONSUMPTION_1 = 107;
    public static final int U_AVERAGE_OIL_CONSUMPTION_2 = 109;
    public static final int U_AVERAGE_OIL_CONSUMPTION_3 = 111;
    public static final int U_AVERAGE_OIL_CONSUMPTION_UNIT = 102;
    public static final int U_CARINDFO_END = 149;
    public static final int U_CARINFO_ACC_DISCOVERY_VEHICLE_IN_FRONT_TONE = 130;
    public static final int U_CARINFO_AUTO_LIGHT_SENSITIVITY = 118;
    public static final int U_CARINFO_BACK_BRIGHT = 114;
    public static final int U_CARINFO_BEGIN = 114;
    public static final int U_CARINFO_BRIGHT_MODE = 144;
    public static final int U_CARINFO_CAMERA_LINKAGE_LAMP = 148;
    public static final int U_CARINFO_ENERGY_SAVE_AUTO_ENGHINE = 128;
    public static final int U_CARINFO_FUEL_EFFIC_BACKLIGHT = 125;
    public static final int U_CARINFO_HEADLIGHT_AUTO_OFF_TIME = 119;
    public static final int U_CARINFO_INTERIOR_LIGHT_DIMMING_TIME = 120;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEP = 123;
    public static final int U_CARINFO_KEY_LOCK_ANSWER = 121;
    public static final int U_CARINFO_LANGUAGE = 129;
    public static final int U_CARINFO_MINOR_LANE_DEPARTURE_SYS_SETTINGS = 143;
    public static final int U_CARINFO_MODE_BRIGHT = 145;
    public static final int U_CARINFO_MODE_CONTRAST = 146;
    public static final int U_CARINFO_MODE_STATURTION = 147;
    public static final int U_CARINFO_OUT_TEMP_SHOW = 117;
    public static final int U_CARINFO_PAUSE_LKAS_TONE = 131;
    public static final int U_CARINFO_REMOTE_START_SYS = 124;
    public static final int U_CARINFO_SECURITY_RELOCK_TIME = 122;
    public static final int U_CARINFO_SET_FRONT_HAZARD_DISTANCE = 132;
    public static final int U_CARINFO_SMART_KEY_START_GUIDE = 126;
    public static final int U_CARINFO_TRAFFIC_SIGN_RECOGNITION_SYS = 142;
    public static final int U_CARINFO_TRIP_A = 115;
    public static final int U_CARINFO_TRIP_B = 116;
    public static final int U_CARINFO_VOLUME_ALARM_SYS = 127;
    public static final int U_CARRADIO_BEGIN = 128;
    public static final int U_CARRADIO_END = 141;
    public static final int U_CHANNEL_CNT = 133;
    public static final int U_CHANNEL_FREQ = 131;
    public static final int U_CNT_MAX = 149;
    public static final int U_CURRENT_AVERAGE_OIL_CONSUMPTION = 95;
    public static final int U_CURRENT_OIL_CONSUMPTION = 94;
    public static final int U_CURRENT_OIL_CONSUMPTION_UNIT = 100;
    public static final int U_CUR_BAND = 129;
    public static final int U_CUR_CHANNEL = 130;
    public static final int U_CUR_FREQ = 128;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION = 96;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION_UNIT = 101;
    public static final int U_LIFE_MILEAGE = 99;
    public static final int U_LIFE_MILEAGE_UNIT = 104;
    public static final int U_LIST_CNT = 135;
    public static final int U_LIST_FREQ = 134;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    public static final int U_OIL_CONSUMPTION_COUNT = 105;
    public static final int U_STATE_REFRESH = 137;
    public static final int U_STATE_SCAN = 136;
    public static final int U_STATE_ST = 138;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 112;
    public static final int U_TRIPA = 98;
    public static final int U_TRIPA_1 = 106;
    public static final int U_TRIPA_2 = 108;
    public static final int U_TRIPA_3 = 110;
    public static final int U_TRIPA_UNIT = 103;
    public static final int[] CHANNEL_FREQ_REFRESH = new int[12];
    public static final int[] CHANNEL_FREQ_LIST = new int[256];

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 149) {
            if (updateCode == 64) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                    return;
                } else {
                    AirHelper.getInstance().showAndRefresh();
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }

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
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0410_XBS_XP1_ACCORD9(TheApp.getInstance()));
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
}
