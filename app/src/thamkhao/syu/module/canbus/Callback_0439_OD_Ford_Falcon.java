package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Ford_Falcon;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_OD_Ford_Falcon extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_FUEL = 111;
    public static final int U_CARINFO_AVG_SPEED = 113;
    public static final int U_CARINFO_INST_FUEL = 112;
    public static final int U_CARINFO_RANGE = 114;
    public static final int U_CARINFO_TRIPTIME_HOUR = 109;
    public static final int U_CARINFO_TRIPTIME_MUNITE = 110;
    public static final int U_CARSET_BEGIN = 94;
    public static final int U_CARSET_LIGHT2_B30 = 108;
    public static final int U_CARSET_LIGHT2_B74 = 107;
    public static final int U_CARSET_LIGHT_B20 = 106;
    public static final int U_CARSET_LIGHT_B3 = 105;
    public static final int U_CARSET_LIGHT_B4 = 104;
    public static final int U_CARSET_LIGHT_B5 = 103;
    public static final int U_CARSET_LIGHT_B6 = 102;
    public static final int U_CARSET_LIGHT_B7 = 101;
    public static final int U_CARSET_LOCK_UNLOCK_B2 = 100;
    public static final int U_CARSET_LOCK_UNLOCK_B3 = 99;
    public static final int U_CARSET_LOCK_UNLOCK_B4 = 98;
    public static final int U_CARSET_LOCK_UNLOCK_B5 = 97;
    public static final int U_CARSET_LOCK_UNLOCK_B6 = 96;
    public static final int U_CARSET_LOCK_UNLOCK_B7 = 95;
    public static final int U_CNT_MAX = 115;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0439_OD_Ford_Falcon(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 115) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
