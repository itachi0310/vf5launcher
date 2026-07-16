package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Captiva;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_CAOTIVA_GM extends CallbackCanbusBase {
    public static final int U_CARINFO_D33_D1_D2 = 94;
    public static final int U_CARINFO_D33_D3_D4 = 95;
    public static final int U_CARINFO_D33_D5_B54 = 96;
    public static final int U_CARINFO_D33_D5_B7 = 97;
    public static final int U_CARINFO_D33_D6_B70 = 98;
    public static final int U_CNT_MAX = 111;
    public static final int U_TIRE_ALARM_FL = 107;
    public static final int U_TIRE_ALARM_FR = 108;
    public static final int U_TIRE_ALARM_RL = 109;
    public static final int U_TIRE_ALARM_RR = 110;
    public static final int U_TIRE_PRESSURE_FL = 99;
    public static final int U_TIRE_PRESSURE_FR = 100;
    public static final int U_TIRE_PRESSURE_RL = 101;
    public static final int U_TIRE_PRESSURE_RR = 102;
    public static final int U_TIRE_TEMP_FL = 103;
    public static final int U_TIRE_TEMP_FR = 104;
    public static final int U_TIRE_TEMP_RL = 105;
    public static final int U_TIRE_TEMP_RR = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Captiva(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
