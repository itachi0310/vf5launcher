package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.carvol.CarVolHelper;
import com.syu.ui.carvol.CarVolView;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0414_XFY_XP1_TianLai extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 105;
    public static final int U_CUR_SPEED = 103;
    public static final int U_ENGINE_SPEED = 104;
    public static final int U_INFO_CAR_BOSE_POINT = 102;
    public static final int U_INFO_CAR_DRIVER_FIELD = 100;
    public static final int U_INFO_CAR_FIELD_F_B = 97;
    public static final int U_INFO_CAR_FIELD_L_R = 98;
    public static final int U_INFO_CAR_ROUND_VOL = 101;
    public static final int U_INFO_CAR_SOUND_H = 95;
    public static final int U_INFO_CAR_SOUND_L = 96;
    public static final int U_INFO_CAR_SPEED_LINK = 99;
    public static final int U_INFO_CAR_VOL = 94;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 105) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 105; i++) {
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
        CarVolHelper.mCarVol_ID = 94;
        CarVolHelper.getInstance().buildUi(new CarVolView(TheApp.getInstance()));
        DataCanbus.NOTIFY_EVENTS[94].addNotify(CarVolHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        CarVolHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(CarVolHelper.SHOW_AND_REFRESH);
    }
}
