package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0103_RZC_XP1_ELYSION extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL = 98;
    public static final int U_AVERAGE_SPEED = 100;
    public static final int U_A_DIS_CONTROL_BIT = 96;
    public static final int U_B_DIS_CONTROL_BIT = 97;
    public static final int U_CAR_SPEED_INFO = 103;
    public static final int U_CNT_MAX = 111;
    public static final int U_DIS_CONTROL_BIT = 95;
    public static final int U_FRONT_FOG_LIGHTS_SWITCH = 107;
    public static final int U_HEADLIGHT_SWITCH = 105;
    public static final int U_HIGH_BEAM_SWITCH = 106;
    public static final int U_INSTRUMENT_LIGHT_BRIGHT = 109;
    public static final int U_OIL_BEGIN = 94;
    public static final int U_OIL_END = 110;
    public static final int U_REAR_FOG_LAMPS_SWITCH = 108;
    public static final int U_SMALL_LIGHTS_SWITCH = 104;
    public static final int U_TRAVEL_DISTANCE = 99;
    public static final int U_TRAVEL_TIME = 101;

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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
