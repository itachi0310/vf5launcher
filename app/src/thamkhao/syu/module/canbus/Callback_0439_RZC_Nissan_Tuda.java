package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_rzc_nissan_qijun;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_RZC_Nissan_Tuda extends CallbackCanbusBase {
    public static final int U_AVG_FUEL = 112;
    public static final int U_CNT_MAX = 114;
    public static final int U_DRIVING_MILEAGE = 111;
    public static final int U_PRESSURE_END = 110;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FL_ENABLE = 97;
    public static final int U_PRESSURE_FL_HIGH_WARN = 95;
    public static final int U_PRESSURE_FL_LOW_WARN = 96;
    public static final int U_PRESSURE_FR = 98;
    public static final int U_PRESSURE_FR_ENABLE = 101;
    public static final int U_PRESSURE_FR_HIGH_WARN = 99;
    public static final int U_PRESSURE_FR_LOW_WARN = 100;
    public static final int U_PRESSURE_RL = 102;
    public static final int U_PRESSURE_RL_ENABLE = 105;
    public static final int U_PRESSURE_RL_HIGH_WARN = 103;
    public static final int U_PRESSURE_RL_LOW_WARN = 104;
    public static final int U_PRESSURE_RR = 106;
    public static final int U_PRESSURE_RR_ENABLE = 109;
    public static final int U_PRESSURE_RR_HIGH_WARN = 107;
    public static final int U_PRESSURE_RR_LOW_WARN = 108;
    public static final int U_TOTAL_MILEAGE = 113;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_rzc_nissan_qijun(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
