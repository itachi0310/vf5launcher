package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_BNR_Nissan_Tule;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_BNR_Nissan_Tule extends CallbackCanbusBase {
    public static final int U_CARINF_AVGFUEL = 106;
    public static final int U_CARINF_BEGIN = 104;
    public static final int U_CARINF_END = 109;
    public static final int U_CARINF_MILEAGE = 105;
    public static final int U_CARINF_TRAVELABLE = 107;
    public static final int U_CAR_TIRE_BEGIN = 94;
    public static final int U_CAR_TIRE_END = 103;
    public static final int U_CAR_TIRE_VALUE_FL = 95;
    public static final int U_CAR_TIRE_VALUE_FR = 96;
    public static final int U_CAR_TIRE_VALUE_RL = 97;
    public static final int U_CAR_TIRE_VALUE_RR = 98;
    public static final int U_CAR_TIRE_WARN_FL = 99;
    public static final int U_CAR_TIRE_WARN_FR = 100;
    public static final int U_CAR_TIRE_WARN_RL = 101;
    public static final int U_CAR_TIRE_WARN_RR = 102;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_MOTOR_SPEED = 108;

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
        AirHelper.getInstance().buildUi(new Air_0439_BNR_Nissan_Tule(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
