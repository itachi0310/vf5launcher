package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0376_SBD_RuiFengS5;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0376_SBD_WC1_ForeginVersionRuiFengS5 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_END = 111;
    public static final int U_CNT_MAX = 112;
    public static final int U_PRESSURE_FL = 99;
    public static final int U_PRESSURE_FR = 100;
    public static final int U_PRESSURE_RL = 101;
    public static final int U_PRESSURE_RR = 102;
    public static final int U_TEMP_FL = 95;
    public static final int U_TEMP_FR = 96;
    public static final int U_TEMP_RL = 97;
    public static final int U_TEMP_RR = 98;
    public static final int U_TEMP_WARN_FLW = 104;
    public static final int U_TEMP_WARN_FL_H = 103;
    public static final int U_TEMP_WARN_FRW = 106;
    public static final int U_TEMP_WARN_FR_H = 105;
    public static final int U_TEMP_WARN_RLW = 108;
    public static final int U_TEMP_WARN_RL_H = 107;
    public static final int U_TEMP_WARN_RRW = 110;
    public static final int U_TEMP_WARN_RR_H = 109;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0376_SBD_RuiFengS5(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
