package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_TATA_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_MHD_SCORPIO extends CallbackCanbusBase {
    public static final int U_CARINF_D13_D0_D1 = 96;
    public static final int U_CARINF_D13_D2_D3 = 97;
    public static final int U_CARINF_D13_D4_D5 = 98;
    public static final int U_CARINF_D13_D6_D7 = 99;
    public static final int U_CARINF_D13_D8_B70 = 100;
    public static final int U_CARSET_D61_D0_B0 = 95;
    public static final int U_CARSET_D61_D0_B1 = 94;
    public static final int U_CNT_MAX = 118;
    public static final int U_PRESSURE_BACK = 107;
    public static final int U_PRESSURE_BACK_TEMP = 112;
    public static final int U_PRESSURE_BACK_WARN = 117;
    public static final int U_PRESSURE_ENABLE = 101;
    public static final int U_PRESSURE_FL = 103;
    public static final int U_PRESSURE_FL_TEMP = 108;
    public static final int U_PRESSURE_FL_WARN = 113;
    public static final int U_PRESSURE_FR = 104;
    public static final int U_PRESSURE_FR_TEMP = 109;
    public static final int U_PRESSURE_FR_WARN = 114;
    public static final int U_PRESSURE_RL = 105;
    public static final int U_PRESSURE_RL_TEMP = 110;
    public static final int U_PRESSURE_RL_WARN = 115;
    public static final int U_PRESSURE_RR = 106;
    public static final int U_PRESSURE_RR_TEMP = 111;
    public static final int U_PRESSURE_RR_WARN = 116;
    public static final int U_PRESSURE_WARN = 102;

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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_TATA_All(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
