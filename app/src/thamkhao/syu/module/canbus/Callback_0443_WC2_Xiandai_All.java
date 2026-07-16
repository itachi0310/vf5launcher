package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Xiandai_all;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Xiandai_All extends CallbackCanbusBase {
    public static final int U_CAREQ_DA6_D0_B70 = 102;
    public static final int U_CAREQ_DA6_D1_B70 = 103;
    public static final int U_CAREQ_DA6_D2_B70 = 104;
    public static final int U_CAREQ_DA6_D3_B70 = 105;
    public static final int U_CAREQ_DA6_D4_B70 = 106;
    public static final int U_CAREQ_DA6_D5_B70 = 107;
    public static final int U_CAREQ_DA6_D6_B70 = 108;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_FRONT_VIEW_INIT = 97;
    public static final int U_CARINFO_RADAR_DISPLAY = 96;
    public static final int U_CARINFO_REAR_VIEW_INIT = 98;
    public static final int U_CARINFO_TRACK_DISPLAY = 95;
    public static final int U_CARSEAT_BACK_STATE = 100;
    public static final int U_CARSEAT_SHOW_ENABLE = 101;
    public static final int U_CARSEAT_STATE = 99;
    public static final int U_CARSET_D61_D0_B5 = 117;
    public static final int U_CARSET_D61_D0_B6 = 116;
    public static final int U_CARSET_D61_D0_B7 = 109;
    public static final int U_CARSET_D61_D1_B4 = 113;
    public static final int U_CARSET_D61_D1_B5 = 112;
    public static final int U_CARSET_D61_D1_B6 = 111;
    public static final int U_CARSET_D61_D1_B7 = 110;
    public static final int U_CARSET_D61_D2_B74 = 114;
    public static final int U_CARSET_D61_D3_B70 = 115;
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Xiandai_all(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
