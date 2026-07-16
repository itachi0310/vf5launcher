package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0041_XP1_Accord;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0041_XP1_ACCORD9_Lo extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 117;
    public static final int U_ACC_SETTING_FAIL = 129;
    public static final int U_AIR_BY_AUTO_KEY = 122;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 113;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 114;
    public static final int U_AUTOLOCK_BY_SPEED = 112;
    public static final int U_CAR_CAMERA_TYPE = 131;
    public static final int U_CAR_RIGHTCAMERA_STATE = 127;
    public static final int U_CNT_MAX = 133;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 128;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 116;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 121;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 132;
    public static final int U_REMOTE_2PRESS_UNLOCK = 115;
    public static final int U_SETTING_FAIL = 130;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 120;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 118;
    public static final int U_UNLOCK_BY_SMART_DOOR = 119;
    public static final int U_WARNNING_CLEANNING_FLUID = 126;
    public static final int U_WARNNING_LIFE_BELT = 125;
    public static final int U_WARNNING_LOW_BATTERY = 124;
    public static final int U_WARNNING_LOW_OIL = 123;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 133; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0041_XP1_Accord(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 133) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
