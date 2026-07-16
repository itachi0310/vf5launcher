package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Porsche_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_Porsche_All extends CallbackCanbusBase {
    public static final int U_CARSEt_D40_D00 = 101;
    public static final int U_CARSEt_D40_D01 = 102;
    public static final int U_CARSEt_D40_D02 = 103;
    public static final int U_CARSEt_D40_D03 = 104;
    public static final int U_CARSEt_D40_D04 = 105;
    public static final int U_CARSEt_D40_D05 = 106;
    public static final int U_CARSEt_D40_D06 = 107;
    public static final int U_CARSEt_D40_D07 = 108;
    public static final int U_CARSEt_D40_D08 = 109;
    public static final int U_CARSEt_D40_D09 = 110;
    public static final int U_CARSEt_D40_D0A = 111;
    public static final int U_CARSEt_D40_D0B = 112;
    public static final int U_CARSEt_D40_D0C = 113;
    public static final int U_CARSEt_D40_D0D = 114;
    public static final int U_CARSEt_D40_D0E = 115;
    public static final int U_CNT_MAX = 116;
    public static final int U_NEWADD_D68_D0 = 99;
    public static final int U_NEWADD_D68_D1 = 100;
    public static final int U_TIRE_PRESSURE_FL = 94;
    public static final int U_TIRE_PRESSURE_FR = 95;
    public static final int U_TIRE_PRESSURE_RL = 96;
    public static final int U_TIRE_PRESSURE_RR = 97;
    public static final int U_TIRE_UNIT = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Porsche_All(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
