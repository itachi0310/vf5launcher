package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Luz_Infinit_Fx35;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_LZ_Infinit_FX35 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_CUR_SPEED = 96;
    public static final int U_CARINFO_ENGINE_SPEED = 98;
    public static final int U_CARINFO_MILE_DRIVENABLE = 97;
    public static final int U_CARINFO_MILE_UNIT = 100;
    public static final int U_CARINFO_TEMP_UNIT = 99;
    public static final int U_CARINFO_WATER_TEMP = 95;
    public static final int U_CARSET_BEIGIN = 106;
    public static final int U_CARSET_DATA38_VALUE0 = 107;
    public static final int U_CARSET_DATA38_VALUE1 = 108;
    public static final int U_CARSET_DATA38_VALUE10 = 117;
    public static final int U_CARSET_DATA38_VALUE2 = 109;
    public static final int U_CARSET_DATA38_VALUE3 = 110;
    public static final int U_CARSET_DATA38_VALUE4 = 111;
    public static final int U_CARSET_DATA38_VALUE5 = 112;
    public static final int U_CARSET_DATA38_VALUE6 = 113;
    public static final int U_CARSET_DATA38_VALUE7 = 114;
    public static final int U_CARSET_DATA38_VALUE8 = 115;
    public static final int U_CARSET_DATA38_VALUE9 = 116;
    public static final int U_CAR_TIRE_BEGIN = 101;
    public static final int U_CAR_TIRE_VALUE1 = 102;
    public static final int U_CAR_TIRE_VALUE2 = 103;
    public static final int U_CAR_TIRE_VALUE3 = 104;
    public static final int U_CAR_TIRE_VALUE4 = 105;
    public static final int U_CNT_MAX = 118;

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
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_Luz_Infinit_Fx35(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
