package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0151_DAOJUN_XP1_BYDG6;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0151_DAOJUN_XP1_BYDG6 extends CallbackCanbusBase {
    public static final int U_AIR_DATA1 = 96;
    public static final int U_AIR_DATA2 = 97;
    public static final int U_AIR_DATA3 = 98;
    public static final int U_AIR_DATA4 = 99;
    public static final int U_AIR_DATA5 = 100;
    public static final int U_AIR_DATA6 = 101;
    public static final int U_AIR_DATA7 = 102;
    public static final int U_AMP_SWITCH = 104;
    public static final int U_CNT_MAX = 105;
    public static final int U_CUR_SPEED = 94;
    public static final int U_ENGINE_SPEED = 95;
    public static final int U_RADAR_SWITCH = 103;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 105; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0151_DAOJUN_XP1_BYDG6(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 105) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
