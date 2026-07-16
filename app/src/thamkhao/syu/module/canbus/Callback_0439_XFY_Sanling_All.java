package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_XFY_Sanling_All extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 108;
    public static final int U_CAREQ_BASS = 110;
    public static final int U_CAREQ_DOLBY_VOLUME = 119;
    public static final int U_CAREQ_FAD = 107;
    public static final int U_CAREQ_MID = 112;
    public static final int U_CAREQ_POSITION = 116;
    public static final int U_CAREQ_POWERON = 120;
    public static final int U_CAREQ_PREMIDIA_HD = 117;
    public static final int U_CAREQ_PUNCH = 113;
    public static final int U_CAREQ_SCV = 118;
    public static final int U_CAREQ_SURROUND = 115;
    public static final int U_CAREQ_TRE = 111;
    public static final int U_CAREQ_TYPE = 109;
    public static final int U_CAREQ_VOL = 114;
    public static final int U_CNT_MAX = 121;
    public static final int U_PRESSURE_END = 106;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FL_TEMP = 95;
    public static final int U_PRESSURE_FL_VOLTAGE = 96;
    public static final int U_PRESSURE_FR = 97;
    public static final int U_PRESSURE_FR_TEMP = 98;
    public static final int U_PRESSURE_FR_VOLTAGE = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RL_TEMP = 101;
    public static final int U_PRESSURE_RL_VOLTAGE = 102;
    public static final int U_PRESSURE_RR = 103;
    public static final int U_PRESSURE_RR_TEMP = 104;
    public static final int U_PRESSURE_RR_VOLTAGE = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 121; i++) {
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
        if (updateCode >= 0 && updateCode < 121) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
