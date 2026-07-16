package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0404_RZC_QiRUiGX;
import com.syu.ui.air.Air_0404_RZC_RuiHu7;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0404_RZC_XP1_QiRuiAiRuiZe5 extends CallbackCanbusBase {
    public static final int U_CARINFO_AMAY_ROAD = 110;
    public static final int U_CARINFO_AMBIENT_LIGHTt = 118;
    public static final int U_CARINFO_AUTO_LOCK = 97;
    public static final int U_CARINFO_AUTO_UNLOCK = 106;
    public static final int U_CARINFO_BEGIN = 93;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 98;
    public static final int U_CARINFO_BLIND_SIDE = 109;
    public static final int U_CARINFO_BLOWER_DELAY = 120;
    public static final int U_CARINFO_BLOWER_EARLY = 119;
    public static final int U_CARINFO_CHANGE_WAY_LIGHT = 115;
    public static final int U_CARINFO_D40_D1C_B70 = 122;
    public static final int U_CARINFO_D40_D1D_B70 = 123;
    public static final int U_CARINFO_D40_D1E_B70 = 124;
    public static final int U_CARINFO_D40_D1F_B70 = 125;
    public static final int U_CARINFO_D40_D20_B70 = 126;
    public static final int U_CARINFO_D40_D21_B70 = 127;
    public static final int U_CARINFO_D40_D22_B70 = 128;
    public static final int U_CARINFO_D40_D23_B70 = 129;
    public static final int U_CARINFO_D40_D24_B70 = 130;
    public static final int U_CARINFO_D40_D25_B70 = 131;
    public static final int U_CARINFO_D40_D26_B70 = 132;
    public static final int U_CARINFO_D40_D27_B70 = 133;
    public static final int U_CARINFO_D40_D28_B70 = 134;
    public static final int U_CARINFO_D40_D29_B70 = 135;
    public static final int U_CARINFO_D40_D2A_B70 = 136;
    public static final int U_CARINFO_D40_D2B_B70 = 154;
    public static final int U_CARINFO_D40_D2C_B70 = 155;
    public static final int U_CARINFO_D40_D2D_B70 = 156;
    public static final int U_CARINFO_D40_D2E_B70 = 157;
    public static final int U_CARINFO_D40_D2F_B70 = 158;
    public static final int U_CARINFO_D40_D30_B70 = 150;
    public static final int U_CARINFO_D40_D30_B70_RZC = 162;
    public static final int U_CARINFO_D40_D31_B70 = 151;
    public static final int U_CARINFO_D40_D31_B70_RZC = 163;
    public static final int U_CARINFO_D40_D32_B70 = 152;
    public static final int U_CARINFO_D40_D32_B70_RZC = 164;
    public static final int U_CARINFO_D40_D33_B70 = 153;
    public static final int U_CARINFO_D40_D33_B70_RZC = 165;
    public static final int U_CARINFO_D40_D34_B70 = 159;
    public static final int U_CARINFO_D40_D34_B70_RZC = 166;
    public static final int U_CARINFO_D40_D35_B70 = 160;
    public static final int U_CARINFO_D40_D35_B70_RZC = 167;
    public static final int U_CARINFO_D40_D36_B30 = 172;
    public static final int U_CARINFO_D40_D36_B70_RZC = 168;
    public static final int U_CARINFO_D40_D36_B74 = 171;
    public static final int U_CARINFO_D40_D37_B70_RZC = 169;
    public static final int U_CARINFO_D40_D38_B70_RZC = 170;
    public static final int U_CARINFO_D40_DFE_B70 = 137;
    public static final int U_CARINFO_D41_D0_B0 = 145;
    public static final int U_CARINFO_D41_D0_B1 = 144;
    public static final int U_CARINFO_D41_D0_B2 = 143;
    public static final int U_CARINFO_D41_D0_B3 = 142;
    public static final int U_CARINFO_D41_D0_B4 = 141;
    public static final int U_CARINFO_D41_D0_B5 = 140;
    public static final int U_CARINFO_D41_D0_B7 = 139;
    public static final int U_CARINFO_D41_D1_B70 = 146;
    public static final int U_CARINFO_D41_D2_B70 = 147;
    public static final int U_CARINFO_D41_D3_D4 = 148;
    public static final int U_CARINFO_D41_D5_B70 = 149;
    public static final int U_CARINFO_D41_D6_B70 = 161;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 104;
    public static final int U_CARINFO_DAYLIGHT = 99;
    public static final int U_CARINFO_EPS_SYSTERM = 117;
    public static final int U_CARINFO_GESTURE_KNOW = 112;
    public static final int U_CARINFO_GESTURE_WINDOW = 113;
    public static final int U_CARINFO_HOME_LIGHT = 114;
    public static final int U_CARINFO_LAN = 94;
    public static final int U_CARINFO_ONLY_REMOTE_OPEN_BACK_DOOR = 107;
    public static final int U_CARINFO_POWER_ON_SHOWS_POWER_FLOW = 108;
    public static final int U_CARINFO_REARVIEW_AUTO = 111;
    public static final int U_CARINFO_SPEED_ALARM = 103;
    public static final int U_CARINFO_STEERING_ANIM = 101;
    public static final int U_CARINFO_STEERING_AUXILIARY_LIGHTING = 105;
    public static final int U_CARINFO_STEERING_AVM = 100;
    public static final int U_CARINFO_TRUNK_DEGREE = 121;
    public static final int U_CARINFO_VEHICLE_GUIDES = 102;
    public static final int U_CARINFO_WARN = 95;
    public static final int U_CARINFO_WARN_EXIST = 96;
    public static final int U_CARINFO_WELCOME_LIGHT = 116;
    public static final int U_CARSET_RIGHT_VIEW = 138;
    public static final int U_CNT_MAX = 173;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 173) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 173; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        initDoor();
        if (DataCanbus.DATA[1000] == 262548 || DataCanbus.DATA[1000] == 2359700 || DataCanbus.DATA[1000] == 393620 || DataCanbus.DATA[1000] == 459156 || DataCanbus.DATA[1000] == 590228 || DataCanbus.DATA[1000] == 655764 || DataCanbus.DATA[1000] == 328084) {
            AirHelper.getInstance().buildUi(new Air_0404_RZC_QiRUiGX(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0404_RZC_RuiHu7(TheApp.getInstance()));
        }
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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

    private void initDoor() {
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
        }
    }
}
