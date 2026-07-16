package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0329_DJ_Dongnan_X7;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0329_RZC_XP1_DongNanDX7 extends CallbackCanbusBase {
    public static final int U_CARINFO_D32_D2_B70 = 117;
    public static final int U_CARINFO_D33_D11_B70 = 119;
    public static final int U_CARINFO_D33_D12_B70 = 120;
    public static final int U_CARINFO_D33_D9_D10 = 118;
    public static final int U_CARINFO_D34_D0_B0 = 116;
    public static final int U_CARINFO_D34_D0_B1 = 115;
    public static final int U_CARINFO_D34_D0_B2 = 114;
    public static final int U_CARINFO_D34_D0_B3 = 113;
    public static final int U_CARINFO_D34_D0_B4 = 112;
    public static final int U_CARINFO_D34_D0_B5 = 111;
    public static final int U_CARINFO_D34_D0_B6 = 110;
    public static final int U_CARINFO_D34_D0_B7 = 109;
    public static final int U_CARINFO_D34_D1_B70 = 121;
    public static final int U_CARINFO_D34_D2_B70 = 122;
    public static final int U_CNT_MAX = 123;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_DRIVE_BACK_SHOW = 105;
    public static final int U_DRIVE_BLIND_WARN = 104;
    public static final int U_DRIVE_TURN_CAMERA = 102;
    public static final int U_DRIVE_TURN_LIGHT = 103;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_LAST_OIL = 101;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FR = 95;
    public static final int U_PRESSURE_RL = 96;
    public static final int U_PRESSURE_RR = 97;
    public static final int U_RAIN_CLOSE_WINDOW = 108;
    public static final int U_RL_VIDEO_STATUS = 106;
    public static final int U_SPEED_INFO = 107;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0329_DJ_Dongnan_X7(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
