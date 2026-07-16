package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0423_CYT_F3;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0423_CYT_ShuPing_QiYaK3 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 94;
    public static final int U_AIR_DATA0 = 94;
    public static final int U_AIR_DATA1 = 95;
    public static final int U_AIR_DATA2 = 96;
    public static final int U_AIR_DATA3 = 97;
    public static final int U_AIR_DATA4 = 98;
    public static final int U_AIR_DATA5 = 99;
    public static final int U_CNT_MAX = 100;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.sCanbusId == 131495) {
            AirHelper.getInstance().buildUi(new Air_0423_CYT_F3(TheApp.getInstance()));
            for (int i2 = 10; i2 < 93; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 100) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
