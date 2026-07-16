package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_DJ_Dodge_JCUV;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_DJ_Dodge_JCUV extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 109;
    public static final int U_CAREQ_BASS = 111;
    public static final int U_CAREQ_FAD = 110;
    public static final int U_CAREQ_MID = 112;
    public static final int U_CAREQ_SPEED_VOL = 114;
    public static final int U_CAREQ_TREB = 113;
    public static final int U_CAREQ_VOL = 107;
    public static final int U_CAREQ_VOL_PERCENTATE = 108;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_D36_D0_B0 = 99;
    public static final int U_CARINFO_D36_D0_B1 = 98;
    public static final int U_CARINFO_D36_D0_B32 = 97;
    public static final int U_CARINFO_D36_D0_B54 = 96;
    public static final int U_CARINFO_D36_D0_B76 = 95;
    public static final int U_CARINFO_D36_D1_B21 = 105;
    public static final int U_CARINFO_D36_D1_B3 = 104;
    public static final int U_CARINFO_D36_D1_B4 = 103;
    public static final int U_CARINFO_D36_D1_B5 = 102;
    public static final int U_CARINFO_D36_D1_B6 = 101;
    public static final int U_CARINFO_D36_D1_B7 = 100;
    public static final int U_CARINFO_LANGUAGE = 116;
    public static final int U_CARINFO_UNIT = 115;
    public static final int U_CARSET_END = 106;
    public static final int U_CNT_MAX = 117;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_DJ_Dodge_JCUV(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 117) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
