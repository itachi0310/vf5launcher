package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0303_DJ_WC2_DS5 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 123;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 119;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 120;
    public static final int U_AUTOLOCK_BY_SPEED = 118;
    public static final int U_AUTO_AC_ENABLED = 102;
    public static final int U_AVERAGE_SPEED = 99;
    public static final int U_BATTERY_VOLTAGE = 136;
    public static final int U_CLOSE_BIGLAMP_TIME = 108;
    public static final int U_CLOSE_INSIDELAMP_TIME = 107;
    public static final int U_CNT_MAX = 138;
    public static final int U_CUR_OIL_EXPEND = 94;
    public static final int U_CUR_TRIP_OIL_EXPEND = 98;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 106;
    public static final int U_DRIVING_MILEAGE = 95;
    public static final int U_DRIVING_TIME = 97;
    public static final int U_ENGINE_SPEED = 137;
    public static final int U_EXIST_TPMS = 114;
    public static final int U_FEEDBACK_LAMP_ENABLED = 101;
    public static final int U_LAST_OIL = 135;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 122;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 127;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 105;
    public static final int U_OPTIMAL_OIL_EXPEND = 96;
    public static final int U_PARK_BESIDE_ROAD = 130;
    public static final int U_PRESSURE_BACKUP = 113;
    public static final int U_PRESSURE_FL = 109;
    public static final int U_PRESSURE_FR = 110;
    public static final int U_PRESSURE_RL = 111;
    public static final int U_PRESSURE_RR = 112;
    public static final int U_RADAR_VOL = 129;
    public static final int U_REMOTE_2PRESS_UNLOCK = 121;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 104;
    public static final int U_SHOW_RADAR = 128;
    public static final int U_SHOW_TIRE_BACKUP = 115;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 126;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 100;
    public static final int U_TIRE_SHOW_STATE = 116;
    public static final int U_TPMS_STATE = 117;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 124;
    public static final int U_UNLOCK_BY_SMART_DOOR = 125;
    public static final int U_VALID_VENTILATION_ENABLED = 103;
    public static final int U_WARNNING_CLEANNING_FLUID = 133;
    public static final int U_WARNNING_HANDLE_BRAKE = 134;
    public static final int U_WARNNING_LIFE_BELT = 132;
    public static final int U_WARNNING_LOW_OIL = 131;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 138) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
