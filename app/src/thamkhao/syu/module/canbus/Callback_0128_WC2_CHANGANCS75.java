package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0128_WC2_ChangAn17Cs75;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0128_WC2_CHANGANCS75 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARSET_D78_D3_B43 = 130;
    public static final int U_CARSET_D78_D3_B65 = 129;
    public static final int U_CARSET_D78_D3_B7 = 128;
    public static final int U_CARSET_D78_D4_B32 = 134;
    public static final int U_CARSET_D78_D4_B54 = 133;
    public static final int U_CARSET_D78_D4_B6 = 132;
    public static final int U_CARSET_D78_D4_B7 = 131;
    public static final int U_CARSET_D87_D5_B10 = 137;
    public static final int U_CARSET_D87_D5_B5 = 136;
    public static final int U_CAR_1KEY_TURN = 100;
    public static final int U_CAR_AIR_SELFDRYING = 105;
    public static final int U_CAR_AMBIENT_LIGHTCOLOR = 114;
    public static final int U_CAR_AMBIENT_LIGHTLEV = 115;
    public static final int U_CAR_BACKCAR_REAR_SWIPER = 99;
    public static final int U_CAR_BTCALL_AIRSLOW = 117;
    public static final int U_CAR_DAY_LIGHTL = 116;
    public static final int U_CAR_DELAY_WINDOW = 108;
    public static final int U_CAR_DIANKABA_VOL = 107;
    public static final int U_CAR_DRIVING_AUTO_LOCK = 103;
    public static final int U_CAR_FRONTLIGHT_DELAY = 101;
    public static final int U_CAR_KEY_LONGTOUCH_AIR = 110;
    public static final int U_CAR_REAR_MIRROR_AUTOFOLD = 98;
    public static final int U_CAR_REMOTE_UNLOCK = 104;
    public static final int U_CAR_REMOTE_WINDOW = 109;
    public static final int U_CAR_SKYLIGHT_RAIN = 113;
    public static final int U_CAR_SKYLIGHT_REMOTE = 112;
    public static final int U_CAR_SKYLIGHT_VOICE = 111;
    public static final int U_CAR_TURNOFF_AUTO_UNLOCK = 102;
    public static final int U_CAR_UNLOCK_ACTIVE_VENTILATION = 97;
    public static final int U_CAR_UNLOCK_WINDOWAIR = 106;
    public static final int U_CNT_MAX = 146;
    public static final int U_CUR_SPEED = 95;
    public static final int U_ENGINE_SPEED = 96;
    public static final int U_TIRE_BEGIN = 118;
    public static final int U_TIRE_D48_D12_B70 = 142;
    public static final int U_TIRE_D48_D13_B70 = 143;
    public static final int U_TIRE_D48_D14_B70 = 144;
    public static final int U_TIRE_D48_D15_B70 = 145;
    public static final int U_TIRE_D48_D1_B4 = 141;
    public static final int U_TIRE_D48_D1_B5 = 140;
    public static final int U_TIRE_D48_D1_B6 = 139;
    public static final int U_TIRE_D48_D1_B7 = 138;
    public static final int U_TIRE_PRESSURE_FL = 120;
    public static final int U_TIRE_PRESSURE_FR = 121;
    public static final int U_TIRE_PRESSURE_RL = 122;
    public static final int U_TIRE_PRESSURE_RR = 123;
    public static final int U_TIRE_TEMP_FL = 124;
    public static final int U_TIRE_TEMP_FR = 125;
    public static final int U_TIRE_TEMP_RL = 126;
    public static final int U_TIRE_TEMP_RR = 127;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 135;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0128_WC2_ChangAn17Cs75(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 146) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
