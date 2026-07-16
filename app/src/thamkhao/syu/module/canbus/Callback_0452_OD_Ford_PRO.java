package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Ford_PRO;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_Ford_PRO extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B70 = 102;
    public static final int U_CARSET_D41_D10_B70 = 116;
    public static final int U_CARSET_D41_D11_B70 = 117;
    public static final int U_CARSET_D41_D1_B70 = 103;
    public static final int U_CARSET_D41_D2_B70 = 104;
    public static final int U_CARSET_D41_D3_B70 = 105;
    public static final int U_CARSET_D41_D4_B70 = 106;
    public static final int U_CARSET_D41_D5_B70 = 107;
    public static final int U_CARSET_D41_D6_B70 = 108;
    public static final int U_CARSET_D41_D7_B70 = 113;
    public static final int U_CARSET_D41_D8_B70 = 114;
    public static final int U_CARSET_D41_D9_B70 = 115;
    public static final int U_CARSET_D42_D0_B70 = 118;
    public static final int U_CARSET_D42_D10_B70 = 124;
    public static final int U_CARSET_D42_D11_B70 = 125;
    public static final int U_CARSET_D42_D12_B70 = 126;
    public static final int U_CARSET_D42_D1_D2_B70 = 119;
    public static final int U_CARSET_D42_D3_B70 = 120;
    public static final int U_CARSET_D42_D4_D5_D6 = 121;
    public static final int U_CARSET_D42_D7_D8_B70 = 122;
    public static final int U_CARSET_D42_D9_B70 = 123;
    public static final int U_CNT_MAX = 127;
    public static final int U_TIRE_ALARM_FL = 109;
    public static final int U_TIRE_ALARM_FR = 110;
    public static final int U_TIRE_ALARM_RL = 111;
    public static final int U_TIRE_ALARM_RR = 112;
    public static final int U_TIRE_PRESSURE_FL = 94;
    public static final int U_TIRE_PRESSURE_FR = 95;
    public static final int U_TIRE_PRESSURE_RL = 96;
    public static final int U_TIRE_PRESSURE_RR = 97;
    public static final int U_TIRE_TEMP_FL = 98;
    public static final int U_TIRE_TEMP_FR = 99;
    public static final int U_TIRE_TEMP_RL = 100;
    public static final int U_TIRE_TEMP_RR = 101;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0452_OD_Ford_PRO(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
