package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WY_BBA_All extends CallbackCanbusBase {
    public static final int U_CARINF_D12_D2_B70 = 25;
    public static final int U_CARINF_D12_D5_B70 = 18;
    public static final int U_CARINF_D12_D6_B54 = 20;
    public static final int U_CARINF_D12_D6_B76 = 19;
    public static final int U_CARINF_D47_D0_B70 = 21;
    public static final int U_CARSET_AUX_CH_CHANGE = 26;
    public static final int U_CARSET_BACKCAR_TYPE = 22;
    public static final int U_CARSET_CARUI_ONOFF = 24;
    public static final int U_CARSET_SPLIT_ONOFF = 23;
    public static final int U_CAR_BELT_STATE = 11;
    public static final int U_CAR_CUR_SPEED = 14;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_FOOTBRAKE_STATE = 12;
    public static final int U_CAR_HANDBRAKE_STATE = 13;
    public static final int U_CAR_LIGHT_FAR = 8;
    public static final int U_CAR_LIGHT_LEFT = 9;
    public static final int U_CAR_LIGHT_NEAR = 7;
    public static final int U_CAR_LIGHT_RIGHT = 10;
    public static final int U_CAR_OIL_REMAINED = 15;
    public static final int U_CAR_TOTAL_MILE = 17;
    public static final int U_CNT_MAX = 27;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 27; i++) {
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
        if (updateCode >= 0 && updateCode < 27) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
