package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Rongwei950;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_HC_Rongwei950 extends CallbackCanbusBase {
    public static final int C_CARSET_CONTROL = 1;
    public static final int U_CARSET_AIR_AUTOBLOW_MODE = 95;
    public static final int U_CARSET_AIR_DUAL_TEMP = 97;
    public static final int U_CARSET_AIR_FRONT = 99;
    public static final int U_CARSET_AIR_REAR = 98;
    public static final int U_CARSET_AIR_SENSOR_LEVEL = 96;
    public static final int U_CARSET_AUTOLOCK_OPENDOOR = 102;
    public static final int U_CARSET_AUTOLOCK_START = 103;
    public static final int U_CARSET_AUTOUNLOCK_STOP = 104;
    public static final int U_CARSET_BACK_REARWIPER = 109;
    public static final int U_CARSET_BEGIN = 94;
    public static final int U_CARSET_CONTRL_SIGN = 112;
    public static final int U_CARSET_FOUND_LIGHT = 100;
    public static final int U_CARSET_LOCK_DELAY = 105;
    public static final int U_CARSET_LOCK_DELAY_LIGHT = 101;
    public static final int U_CARSET_REMOTE_LOCK_AGAIN = 110;
    public static final int U_CARSET_REMOTE_LOCK_LIGHT = 107;
    public static final int U_CARSET_REMOTE_START = 111;
    public static final int U_CARSET_REMOTE_UNLOCK = 108;
    public static final int U_CARSET_REMOTE_UNLOCK_LIGHT = 106;
    public static final int U_CNT_MAX = 113;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 113; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0439_HC_Rongwei950(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
