package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_JiangHuai_IEV6E;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Jianghuai_IEV6E extends CallbackCanbusBase {
    public static final int U_CARSET_D87_D5_B30 = 123;
    public static final int U_CARSET_D87_D5_B74 = 122;
    public static final int U_CARSET_D87_D6_B70 = 124;
    public static final int U_CARSET_D87_D7_B70 = 125;
    public static final int U_CARSET_DE8_D0_B32 = 127;
    public static final int U_CARSET_DE8_D0_B74 = 126;
    public static final int U_CARSET_DE8_D1_B70 = 128;
    public static final int U_CAR_CURRENT = 111;
    public static final int U_CAR_DRIVE_MODE = 109;
    public static final int U_CAR_ELECTRICITY = 115;
    public static final int U_CAR_ENERGY_AIR = 119;
    public static final int U_CAR_ENERGY_AVG = 117;
    public static final int U_CAR_ENERGY_CUR = 118;
    public static final int U_CAR_ENERGY_DRIVE = 121;
    public static final int U_CAR_ENERGY_FLOW = 116;
    public static final int U_CAR_ENERGY_RECYCLE = 120;
    public static final int U_CAR_GEAR = 110;
    public static final int U_CAR_MILEAGE = 113;
    public static final int U_CAR_REMAIN_MILEAGE = 114;
    public static final int U_CAR_VOLTAGE = 112;
    public static final int U_CNT_MAX = 129;
    public static final int U_PRESSURE_FL = 99;
    public static final int U_PRESSURE_FR = 100;
    public static final int U_PRESSURE_RL = 101;
    public static final int U_PRESSURE_RR = 102;
    public static final int U_SYSTEM_UNWORK_WARN = 107;
    public static final int U_TEMP_END = 108;
    public static final int U_TEMP_FL = 95;
    public static final int U_TEMP_FR = 96;
    public static final int U_TEMP_RL = 97;
    public static final int U_TEMP_RR = 98;
    public static final int U_TEMP_WARN_FLW = 103;
    public static final int U_TEMP_WARN_FRW = 104;
    public static final int U_TEMP_WARN_RLW = 105;
    public static final int U_TEMP_WARN_RRW = 106;
    public static final int U_TIRE_BEGIN = 94;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_JiangHuai_IEV6E(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
