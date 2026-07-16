package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0327_HC_TianLai;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0327_HC_OLD_TianLai extends CallbackCanbusBase {
    public static final int U_CARINFO_OIL = 117;
    public static final int U_CARSET_BEGIN = 103;
    public static final int U_CARSET_DX30_D0_B02 = 106;
    public static final int U_CARSET_DX30_D0_B04 = 105;
    public static final int U_CARSET_DX30_D0_B65 = 104;
    public static final int U_CARSET_DX30_D1_B30 = 108;
    public static final int U_CARSET_DX30_D1_B76 = 107;
    public static final int U_CARSET_DX30_D2_B01 = 114;
    public static final int U_CARSET_DX30_D2_B05 = 111;
    public static final int U_CARSET_DX30_D2_B06 = 110;
    public static final int U_CARSET_DX30_D2_B07 = 109;
    public static final int U_CARSET_DX30_D2_B21 = 113;
    public static final int U_CARSET_DX30_D2_B43 = 112;
    public static final int U_CD_BEGIN = 94;
    public static final int U_CD_CURRENT_DISC_TRACK = 97;
    public static final int U_CD_CURRENT_TIME = 98;
    public static final int U_CD_DISC_ID = 96;
    public static final int U_CD_DISC_RANDOM_STATE = 101;
    public static final int U_CD_DISC_REPEATE_STATE = 100;
    public static final int U_CD_DISC_STATE = 95;
    public static final int U_CD_DISC_WORK_STATE = 99;
    public static final int U_CD_END = 102;
    public static final int U_CNT_MAX = 118;
    public static final int U_CUR_SPEED = 115;
    public static final int U_ENGINE_SPEED = 116;

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
        AirHelper.getInstance().buildUi(new Air_0327_HC_TianLai(TheApp.getInstance()));
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
