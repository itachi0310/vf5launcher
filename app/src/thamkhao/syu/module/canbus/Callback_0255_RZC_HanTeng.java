package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0255_RZC_HanTeng;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0255_RZC_HanTeng extends CallbackCanbusBase {
    public static final int U_360_SHOW = 134;
    public static final int U_AMBIENT_LIGHT_BLUE_GREEN_RED = 122;
    public static final int U_AMBIENT_LIGHT_BLUE_PURPLE_RED = 123;
    public static final int U_AMBIENT_LIGHT_BRIGHT_LEVEL = 117;
    public static final int U_AMBIENT_LIGHT_COLOR = 136;
    public static final int U_AMBIENT_LIGHT_CONTROL_METHOD = 120;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SAMPLING = 125;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SETTING = 124;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SPEED = 126;
    public static final int U_AMBIENT_LIGHT_LEV = 137;
    public static final int U_AMBIENT_LIGHT_STATIC_SET = 121;
    public static final int U_AMBIENT_LIGHT_SWITCH = 118;
    public static final int U_AUTO_MIRROR = 132;
    public static final int U_AVM_ONOFF = 128;
    public static final int U_CNT_MAX = 139;
    public static final int U_DAY_LIGHT = 130;
    public static final int U_RETURN_HOME = 133;
    public static final int U_SEAT_COURTESY_SWITCH = 119;
    public static final int U_SJ_NOW = 135;
    public static final int U_TEMP_UNIT = 138;
    public static final int U_TIRE_BEGIN = 94;
    public static final int U_TIRE_END = 116;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 105;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 104;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 103;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 108;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 107;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 106;
    public static final int U_TIRE_PRESSURE_FL = 95;
    public static final int U_TIRE_PRESSURE_FR = 96;
    public static final int U_TIRE_PRESSURE_RL = 97;
    public static final int U_TIRE_PRESSURE_RR = 98;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 114;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 113;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 112;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 111;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 110;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 109;
    public static final int U_TIRE_SYS_FAILURE = 115;
    public static final int U_TIRE_TEMP_FL = 99;
    public static final int U_TIRE_TEMP_FR = 100;
    public static final int U_TIRE_TEMP_RL = 101;
    public static final int U_TIRE_TEMP_RR = 102;
    public static final int U_WELCOME_LIGHT = 131;
    public static final int U_YK_AUTO_WINDOW = 129;
    public static final int U_YK_UNLOCK = 127;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 139; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0255_RZC_HanTeng(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 139) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
