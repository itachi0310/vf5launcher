package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_ChangAn_CS95;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_OD_ChangAn_CS95 extends CallbackCanbusBase {
    public static final int U_AUTO_LOCK_DRIVING = 98;
    public static final int U_AUTO_UNLOCK_LIGHTOFF = 99;
    public static final int U_CNT_MAX = 106;
    public static final int U_DRIVING_MILEAGE = 95;
    public static final int U_FRONT_LIGHT_DELAY = 100;
    public static final int U_ONKEY_TURN_OFF = 101;
    public static final int U_REMOTE_UNLOCK_MODE = 97;
    public static final int U_REVERSE_AUTO_WIPER = 102;
    public static final int U_SET_FOLD_REARMIRROR = 94;
    public static final int U_SMART_AIR_PURIFY = 105;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 96;
    public static final int U_UNLOCK_AUTO_VENTILATION = 103;
    public static final int U_UNLOCK_AUTO_WINDOW = 104;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 106; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_OD_ChangAn_CS95(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 106) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
