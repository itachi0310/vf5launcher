package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.wc.gs4.GS4SOSAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0260_WC2_ChuangQiGa6;
import com.syu.ui.air.Air_0289_WC2_ChuanQiGs3;
import com.syu.ui.air.Air_0289_WC2_ChuanQiGs4;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0289_WC2_ChuanQiGS4 extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 114;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 115;
    public static final int U_AUTOLOCK_BY_SPEED = 112;
    public static final int U_AUTO_AC_ENABLED = 105;
    public static final int U_AVERAGE_SPEED = 99;
    public static final int U_CARINFO_LIGHT_ATMOSPHERE = 123;
    public static final int U_CARINFO_SOS = 122;
    public static final int U_CLOSE_BIGLAMP_TIME = 111;
    public static final int U_CLOSE_INSIDELAMP_TIME = 110;
    public static final int U_CNT_MAX = 140;
    public static final int U_CUR_OIL_EXPEND = 94;
    public static final int U_CUR_TRIP_OIL_EXPEND = 102;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 109;
    public static final int U_DISPLAY_ENABLE_0 = 97;
    public static final int U_DISPLAY_ENABLE_1 = 100;
    public static final int U_DISPLAY_ENABLE_2 = 101;
    public static final int U_DISPLAY_ENABLE_3 = 113;
    public static final int U_DRIVING_MILEAGE = 95;
    public static final int U_DRIVING_TIME = 98;
    public static final int U_ENERGY_BEGIN = 124;
    public static final int U_ENERGY_CHARGING_CYCLE_N1 = 132;
    public static final int U_ENERGY_CHARGING_CYCLE_N2 = 133;
    public static final int U_ENERGY_CHARGING_CYCLE_N3 = 134;
    public static final int U_ENERGY_CHARGING_CYCLE_N4 = 135;
    public static final int U_ENERGY_CHARGING_CYCLE_N5 = 136;
    public static final int U_ENERGY_CHARGING_CYCLE_N6 = 137;
    public static final int U_ENERGY_CHARGING_CYCLE_N7 = 138;
    public static final int U_ENERGY_CHARGING_CYCLE_ONOFF = 131;
    public static final int U_ENERGY_CHARGING_ENDTIME_H = 129;
    public static final int U_ENERGY_CHARGING_ENDTIME_M = 130;
    public static final int U_ENERGY_CHARGING_MODE = 126;
    public static final int U_ENERGY_CHARGING_STARTTIME_H = 127;
    public static final int U_ENERGY_CHARGING_STARTTIME_M = 128;
    public static final int U_ENERGY_CYCLE_MODE = 139;
    public static final int U_ENERGY_FLOW_MODE = 125;
    public static final int U_ENGINESPEED = 119;
    public static final int U_ENGINE_BEGIN = 119;
    public static final int U_ENGINE_END = 121;
    public static final int U_FEEDBACK_LAMP_ENABLED = 104;
    public static final int U_INSTANTANEOUSSPEED = 120;
    public static final int U_LOCK_UNLOCK_BLOW_TONE = 118;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 117;
    public static final int U_MISC_END = 119;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 108;
    public static final int U_OPTIMAL_OIL_EXPEND = 96;
    public static final int U_REMOTE_2PRESS_UNLOCK = 116;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 107;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 103;
    public static final int U_VALID_VENTILATION_ENABLED = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 140; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 262433) {
            AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs3(TheApp.getInstance()));
        } else if (DataCanbus.DATA[1000] == 260 || DataCanbus.DATA[1000] == 65796 || DataCanbus.DATA[1000] == 131332) {
            AirHelper.getInstance().buildUi(new Air_0260_WC2_ChuangQiGa6(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs4(TheApp.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showSoS(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if ((value == 1 || value == 2) && !GS4SOSAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.gs4.GS4SOSAct");
        } else if (GS4SOSAct.mIsFront && value == 0 && GS4SOSAct.mIsFront && GS4SOSAct.mInstance != null) {
            GS4SOSAct.mInstance.finish();
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
        if (updateCode >= 0 && updateCode < 140) {
            switch (updateCode) {
                case 122:
                    showSoS(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
