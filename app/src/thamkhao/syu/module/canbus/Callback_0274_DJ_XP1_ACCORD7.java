package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0274_DJ_XP1_ACCORD7;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0274_DJ_XP1_ACCORD7 extends CallbackCanbusBase {
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_LEFT = 100;
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_RIGHT = 101;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_LEFT = 104;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_RIGHT = 105;
    public static final int U_CARINFO_BEGIN = 96;
    public static final int U_CARINFO_BLOWER_MOTOR = 103;
    public static final int U_CARINFO_END = 110;
    public static final int U_CARINFO_ENGINER_COOLANT = 109;
    public static final int U_CARINFO_EVAPORATOR_TEMP = 107;
    public static final int U_CARINFO_EVAPORATOR_TEMP_SENSOR = 99;
    public static final int U_CARINFO_INTER_TEMP = 108;
    public static final int U_CARINFO_INTER_TEMP_SENSOR = 96;
    public static final int U_CARINFO_MODE_CONTROL_MOTOR = 102;
    public static final int U_CARINFO_OUTER_TEMP_SENSOR = 97;
    public static final int U_CARINFO_SUNLIGHT_LEVEL = 106;
    public static final int U_CARINFO_SUNLIGHT_LEVEL_SENSOR = 98;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_SPEED = 94;
    public static final int U_ENGINE_SPEED = 95;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0274_DJ_XP1_ACCORD7(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
