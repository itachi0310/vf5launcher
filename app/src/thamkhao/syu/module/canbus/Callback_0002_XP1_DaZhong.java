package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0002_XP1_DaZhong;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0002_XP1_DaZhong extends CallbackCanbusBase {
    public static final int U_AIR_TEMP_OUT = 117;
    public static final int U_BATTERY_VOLTAGE = 101;
    public static final int U_CAR_TIRE_BEGIN = 109;
    public static final int U_CAR_TIRE_CHECK = 114;
    public static final int U_CAR_TIRE_END = 116;
    public static final int U_CAR_TIRE_STATE = 115;
    public static final int U_CAR_TIRE_VALUE_FL = 110;
    public static final int U_CAR_TIRE_VALUE_FR = 111;
    public static final int U_CAR_TIRE_VALUE_RL = 112;
    public static final int U_CAR_TIRE_VALUE_RR = 113;
    public static final int U_CLEAN_FLUIT_WARN = 98;
    public static final int U_CNT_MAX = 118;
    public static final int U_CUR_OIL_EXPEND = 94;
    public static final int U_CUR_SPEED = 105;
    public static final int U_DRIVE_MILE = 102;
    public static final int U_ENGINE_SPEED = 106;
    public static final int U_HANDLE_BRAKE_WARN = 99;
    public static final int U_LIFE_BELT_WARN = 97;
    public static final int U_LOW_BATTERY_WARN = 96;
    public static final int U_LOW_OIL_WARN = 95;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 108;
    public static final int U_OUT_TEMP = 107;
    public static final int U_PARK = 103;
    public static final int U_RADAR_MUTE = 104;
    public static final int U_RESIDUAL_OIL = 100;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0002_XP1_DaZhong(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 5; i++) {
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
