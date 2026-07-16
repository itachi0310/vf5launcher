package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Hongqi_H7;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_Hongqi_H7 extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B70 = 114;
    public static final int U_CARSET_D41_D1_B70 = 115;
    public static final int U_CARSET_D41_D2_B70 = 116;
    public static final int U_CARSET_D41_D3_B70 = 117;
    public static final int U_CARSET_D41_D4_B70 = 118;
    public static final int U_CARSET_D41_D5_B70 = 119;
    public static final int U_CARSET_D41_D6_B4 = 123;
    public static final int U_CARSET_D41_D6_B5 = 122;
    public static final int U_CARSET_D41_D6_B6 = 121;
    public static final int U_CARSET_D41_D6_B7 = 120;
    public static final int U_CARSET_D41_D7_B4 = 127;
    public static final int U_CARSET_D41_D7_B5 = 126;
    public static final int U_CARSET_D41_D7_B6 = 125;
    public static final int U_CARSET_D41_D7_B7 = 124;
    public static final int U_CARSET_D41_D8_B6 = 129;
    public static final int U_CARSET_D41_D8_B7 = 128;
    public static final int U_CNT_MAX = 130;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 104;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 103;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 102;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 107;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 106;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 105;
    public static final int U_TIRE_PRESSURE_FL = 94;
    public static final int U_TIRE_PRESSURE_FR = 95;
    public static final int U_TIRE_PRESSURE_RL = 96;
    public static final int U_TIRE_PRESSURE_RR = 97;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 113;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 112;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 111;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 110;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 109;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 108;
    public static final int U_TIRE_TEMP_FL = 98;
    public static final int U_TIRE_TEMP_FR = 99;
    public static final int U_TIRE_TEMP_RL = 100;
    public static final int U_TIRE_TEMP_RR = 101;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 130; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0452_OD_Hongqi_H7(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 130) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
