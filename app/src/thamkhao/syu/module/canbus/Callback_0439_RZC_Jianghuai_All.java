package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Jianghuai_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_RZC_Jianghuai_All extends CallbackCanbusBase {
    public static final int U_CARSET_D3A_D10_B70 = 149;
    public static final int U_CARSET_D3A_D11_B70 = 150;
    public static final int U_CARSET_D3A_D12_B70 = 151;
    public static final int U_CARSET_D3A_DB_B70 = 144;
    public static final int U_CARSET_D3A_DC_B70 = 145;
    public static final int U_CARSET_D3A_DD_B70 = 146;
    public static final int U_CARSET_D3A_DE_B70 = 147;
    public static final int U_CARSET_D3A_DF_B70 = 148;
    public static final int U_CARSET_D40_D0_B76 = 140;
    public static final int U_CARSET_D40_D1_B5 = 143;
    public static final int U_CARSET_D40_D1_B6 = 142;
    public static final int U_CARSET_D40_D1_B7 = 141;
    public static final int U_CAR_AUTOLOCK_SPEED = 135;
    public static final int U_CAR_BACKLIGHT = 139;
    public static final int U_CAR_CHARGING_MODE = 121;
    public static final int U_CAR_CHARGING_TIME_MODE = 131;
    public static final int U_CAR_CHARGING_TIME_VALUE1_1 = 122;
    public static final int U_CAR_CHARGING_TIME_VALUE1_2 = 123;
    public static final int U_CAR_CHARGING_TIME_VALUE2_1 = 124;
    public static final int U_CAR_CHARGING_TIME_VALUE2_2 = 125;
    public static final int U_CAR_CHARGING_TIME_VALUE3_1 = 126;
    public static final int U_CAR_CHARGING_TIME_VALUE3_2 = 127;
    public static final int U_CAR_CHARGING_TIME_VALUE4_1 = 128;
    public static final int U_CAR_CHARGING_TIME_VALUE4_2 = 129;
    public static final int U_CAR_CHARGING_TIME_VALUE5 = 130;
    public static final int U_CAR_CURRENT = 110;
    public static final int U_CAR_DRIVE_MODE = 108;
    public static final int U_CAR_ELECTRICITY = 114;
    public static final int U_CAR_ENERGY_AIR = 118;
    public static final int U_CAR_ENERGY_AVG = 116;
    public static final int U_CAR_ENERGY_CUR = 117;
    public static final int U_CAR_ENERGY_DRIVE = 120;
    public static final int U_CAR_ENERGY_FLOW = 115;
    public static final int U_CAR_ENERGY_RECYCLE = 119;
    public static final int U_CAR_FORTIFICATION_BEEP = 136;
    public static final int U_CAR_GEAR = 109;
    public static final int U_CAR_INSIDE_LIGHT_DELAY_TIME = 134;
    public static final int U_CAR_LIGHT_POSITION = 137;
    public static final int U_CAR_LIGHT_TURN_AID = 138;
    public static final int U_CAR_MILEAGE = 112;
    public static final int U_CAR_OUT_LIGHT_DELAY_TIME = 133;
    public static final int U_CAR_REARVIEW_AUTO = 107;
    public static final int U_CAR_REMAIN_MILEAGE = 113;
    public static final int U_CAR_TOUCH_SENSITIVITY = 132;
    public static final int U_CAR_VOLTAGE = 111;
    public static final int U_CAR_WIN_AUTODOWN = 106;
    public static final int U_CNT_MAX = 152;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FR = 95;
    public static final int U_PRESSURE_RL = 96;
    public static final int U_PRESSURE_RR = 97;
    public static final int U_TEMP_FL = 98;
    public static final int U_TEMP_FR = 99;
    public static final int U_TEMP_RL = 100;
    public static final int U_TEMP_RR = 101;
    public static final int U_WARNING_FL = 102;
    public static final int U_WARNING_FR = 103;
    public static final int U_WARNING_RL = 104;
    public static final int U_WARNING_RR = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_Jianghuai_All(TheApp.getInstance()));
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 152) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
