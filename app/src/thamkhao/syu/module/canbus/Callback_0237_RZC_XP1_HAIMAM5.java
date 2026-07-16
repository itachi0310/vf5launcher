package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAM55;
import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAV70;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0237_RZC_XP1_HAIMAM5 extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 115;
    public static final int U_CARSET_END = 117;
    public static final int U_CARSET_HOME_LIGHT = 116;
    public static final int U_CNT_MAX = 118;
    public static final int U_CUR_SPEED = 94;
    public static final int U_ENGINE_SPEED = 95;
    public static final int U_SYSTEM_SELFDETECT = 97;
    public static final int U_TIRE_BATTERY_FL = 100;
    public static final int U_TIRE_BATTERY_FR = 104;
    public static final int U_TIRE_BATTERY_RL = 108;
    public static final int U_TIRE_BATTERY_RR = 112;
    public static final int U_TIRE_BEGIN = 96;
    public static final int U_TIRE_END = 114;
    public static final int U_TIRE_PRESS_FL = 98;
    public static final int U_TIRE_PRESS_FR = 102;
    public static final int U_TIRE_PRESS_RL = 106;
    public static final int U_TIRE_PRESS_RR = 110;
    public static final int U_TIRE_TEMP_FL = 99;
    public static final int U_TIRE_TEMP_FR = 103;
    public static final int U_TIRE_TEMP_RL = 107;
    public static final int U_TIRE_TEMP_RR = 111;
    public static final int U_TIRE_WARN_FL = 101;
    public static final int U_TIRE_WARN_FR = 105;
    public static final int U_TIRE_WARN_RL = 109;
    public static final int U_TIRE_WARN_RR = 113;

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
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 131309 || DataCanbus.DATA[1000] == 262381) {
            AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAV70(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAM55(TheApp.getInstance()));
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
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
