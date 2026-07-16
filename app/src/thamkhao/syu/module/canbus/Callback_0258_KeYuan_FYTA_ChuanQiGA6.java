package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0258_KeYuan_FYTA_ChuanQiGA6;
import com.syu.ui.air.Air_0258_KeYuan_FYTA_X7;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0258_KeYuan_FYTA_ChuanQiGA6 extends CallbackCanbusBase {
    public static final int U_ATMOSPHERE_LIGHTS = 95;
    public static final int U_CNT_MAX = 97;
    public static final int U_HOME_WITH_BIGLIGHT = 96;
    public static final int U_SEAT_COMITY = 94;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 97; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.carId == 2 || DataCanbus.carId == 3 || DataCanbus.carId == 4) {
            AirHelper.getInstance().buildUi(new Air_0258_KeYuan_FYTA_X7(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0258_KeYuan_FYTA_ChuanQiGA6(TheApp.getInstance()));
        }
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
