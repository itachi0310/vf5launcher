package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC_nissan_ruiqi;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Nissan_Ruiqi6 extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_FUEL = 95;
    public static final int U_CARINFO_AVG_SPEED = 97;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_CURRENT = 99;
    public static final int U_CARINFO_SOC = 100;
    public static final int U_CARINFO_TOTAL_MILEAGE = 96;
    public static final int U_CARINFO_VOLTAGE = 98;
    public static final int U_CARINF_END = 101;
    public static final int U_CARSET_AUTOLOCK_DRIVING = 112;
    public static final int U_CARSET_AUTOUNLOCK_STOP = 113;
    public static final int U_CARSET_BEGIN = 111;
    public static final int U_CARSET_D61_D0_B4 = 115;
    public static final int U_CARSET_HOME_LIGHT = 114;
    public static final int U_CAR_TIRE_BEGIN = 101;
    public static final int U_CAR_TIRE_END = 110;
    public static final int U_CAR_TIRE_TEMP_FL = 106;
    public static final int U_CAR_TIRE_TEMP_FR = 107;
    public static final int U_CAR_TIRE_TEMP_RL = 108;
    public static final int U_CAR_TIRE_TEMP_RR = 109;
    public static final int U_CAR_TIRE_VALUE_FL = 102;
    public static final int U_CAR_TIRE_VALUE_FR = 103;
    public static final int U_CAR_TIRE_VALUE_RL = 104;
    public static final int U_CAR_TIRE_VALUE_RR = 105;
    public static final int U_CNT_MAX = 116;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                if (TheApp.getConfiguration() != 1) {
                    AirHelper.getInstance().buildUi(new Air_0443_WC_nissan_ruiqi(TheApp.getInstance()));
                    for (int i3 = 10; i3 < 93; i3++) {
                        DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                    }
                }
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0443_WC_nissan_ruiqi(TheApp.getInstance()));
                for (int i4 = 10; i4 < 93; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
