package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Sanlin_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_RZC_Sanlin_Yige extends CallbackCanbusBase {
    public static final int U_CAREQ_D17_D0_B70 = 129;
    public static final int U_CAREQ_D17_D10_B70 = 139;
    public static final int U_CAREQ_D17_D11_B70 = 140;
    public static final int U_CAREQ_D17_D12_B70 = 141;
    public static final int U_CAREQ_D17_D13_B70 = 142;
    public static final int U_CAREQ_D17_D1_B70 = 130;
    public static final int U_CAREQ_D17_D2_B70 = 131;
    public static final int U_CAREQ_D17_D3_B70 = 132;
    public static final int U_CAREQ_D17_D4_B70 = 133;
    public static final int U_CAREQ_D17_D5_B70 = 134;
    public static final int U_CAREQ_D17_D6_B70 = 135;
    public static final int U_CAREQ_D17_D7_B70 = 136;
    public static final int U_CAREQ_D17_D8_B70 = 137;
    public static final int U_CAREQ_D17_D9_B70 = 138;
    public static final int U_CARINFO_AVG_FUEL_AUTO = 98;
    public static final int U_CARINFO_AVG_FUEL_HAND = 99;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_CUR_FUEL = 97;
    public static final int U_CARINFO_MILE_DRIVENABLE = 96;
    public static final int U_CARINFO_UNIT = 95;
    public static final int U_CARSAT_AIR_CONDITIONER_1 = 120;
    public static final int U_CARSAT_AIR_CONDITIONER_2 = 121;
    public static final int U_CARSAT_AIR_CONDITIONER_3 = 122;
    public static final int U_CARSAT_AIR_CONDITIONER_4 = 123;
    public static final int U_CARSAT_AIR_CONDITIONER_5 = 124;
    public static final int U_CARSAT_AIR_CONDITIONER_6 = 125;
    public static final int U_CARSAT_DOOR_LOCK_1 = 117;
    public static final int U_CARSAT_DOOR_LOCK_2 = 118;
    public static final int U_CARSAT_DOOR_LOCK_3 = 119;
    public static final int U_CARSAT_KEYLESS_1 = 101;
    public static final int U_CARSAT_KEYLESS_2 = 102;
    public static final int U_CARSAT_KEYLESS_3 = 103;
    public static final int U_CARSAT_LIGHTS_1 = 109;
    public static final int U_CARSAT_LIGHTS_2 = 110;
    public static final int U_CARSAT_LIGHTS_3 = 111;
    public static final int U_CARSAT_LIGHTS_4 = 112;
    public static final int U_CARSAT_LIGHTS_5 = 113;
    public static final int U_CARSAT_OTHER_1 = 126;
    public static final int U_CARSAT_OTHER_2 = 127;
    public static final int U_CARSAT_OTHER_3 = 128;
    public static final int U_CARSAT_TOUCH_SENSE = 100;
    public static final int U_CARSAT_TUM_SIGNAL_1 = 114;
    public static final int U_CARSAT_TUM_SIGNAL_2 = 115;
    public static final int U_CARSAT_TUM_SIGNAL_3 = 116;
    public static final int U_CARSAT_WIPERS_1 = 104;
    public static final int U_CARSAT_WIPERS_2 = 105;
    public static final int U_CARSAT_WIPERS_3 = 106;
    public static final int U_CARSAT_WIPERS_4 = 107;
    public static final int U_CARSAT_WIPERS_5 = 108;
    public static final int U_CNT_MAX = 143;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 143; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = ConstRzcAddData.U_DOOR_ENGINE_ADD;
        DoorHelper.sUcDoorFl = ConstRzcAddData.U_DOOR_FL_ADD;
        DoorHelper.sUcDoorFr = ConstRzcAddData.U_DOOR_FR_ADD;
        DoorHelper.sUcDoorRl = ConstRzcAddData.U_DOOR_RL_ADD;
        DoorHelper.sUcDoorRr = ConstRzcAddData.U_DOOR_RR_ADD;
        DoorHelper.sUcDoorBack = ConstRzcAddData.U_DOOR_BACK_ADD;
        DoorHelper.getInstance().buildUi();
        for (int i3 = ConstRzcAddData.U_DOOR_ENGINE_ADD; i3 <= 558; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_Sanlin_All(TheApp.getInstance()));
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = ConstRzcAddData.U_DOOR_ENGINE_ADD; i <= 558; i++) {
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
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 0 && updateCode < 143) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
