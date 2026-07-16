package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0320_WC2_HavaH6;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0320_WC2_HavalH6 extends CallbackCanbusBase {
    public static final int U_CARINFO2_ALTITUDE = 111;
    public static final int U_CARINFO2_BEGIN = 105;
    public static final int U_CARINFO2_FRONTWHEEL = 108;
    public static final int U_CARINFO2_INCLINATION = 109;
    public static final int U_CARINFO2_PRESSURE = 106;
    public static final int U_CARINFO2_SLOPE = 107;
    public static final int U_CARINFO2_STEER = 152;
    public static final int U_CARINFO2_TRAILER = 110;
    public static final int U_CARINFO_ALLTERRAIN = 124;
    public static final int U_CARINFO_ANTITHEFT_SET = 118;
    public static final int U_CARINFO_BATTERY_VOLGATE = 95;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_BIAOZHI_INFO = 127;
    public static final int U_CARINFO_CARTOP_MODE = 123;
    public static final int U_CARINFO_CETA_SET = 122;
    public static final int U_CARINFO_COLLISION_SAFE = 129;
    public static final int U_CARINFO_COLOR_MONOR = 135;
    public static final int U_CARINFO_COOLANT_TEMP = 96;
    public static final int U_CARINFO_D62_D2_B31 = 155;
    public static final int U_CARINFO_D62_D2_B54 = 154;
    public static final int U_CARINFO_D62_D2_B76 = 153;
    public static final int U_CARINFO_D62_D3_B31 = 158;
    public static final int U_CARINFO_D62_D3_B54 = 157;
    public static final int U_CARINFO_D62_D3_B76 = 156;
    public static final int U_CARINFO_D62_D4_B0 = 163;
    public static final int U_CARINFO_D62_D4_B1 = 162;
    public static final int U_CARINFO_D62_D4_B32 = 161;
    public static final int U_CARINFO_D62_D4_B54 = 160;
    public static final int U_CARINFO_D62_D4_B76 = 159;
    public static final int U_CARINFO_D62_D5_B2 = 168;
    public static final int U_CARINFO_D62_D5_B3 = 167;
    public static final int U_CARINFO_D62_D5_B4 = 166;
    public static final int U_CARINFO_D62_D5_B65 = 165;
    public static final int U_CARINFO_D62_D5_B7 = 164;
    public static final int U_CARINFO_D62_D6_B5 = 171;
    public static final int U_CARINFO_D62_D6_B6 = 170;
    public static final int U_CARINFO_D62_D6_B7 = 169;
    public static final int U_CARINFO_D67_D0_B10 = 177;
    public static final int U_CARINFO_D67_D0_B5 = 173;
    public static final int U_CARINFO_D67_D0_B76 = 172;
    public static final int U_CARINFO_D68_D0_B5 = 148;
    public static final int U_CARINFO_D68_D0_B6 = 147;
    public static final int U_CARINFO_D68_D0_B7 = 146;
    public static final int U_CARINFO_D68_D1_B0 = 149;
    public static final int U_CARINFO_D68_D2_B2 = 178;
    public static final int U_CARINFO_D68_D3_B0 = 137;
    public static final int U_CARINFO_D68_D3_B1 = 136;
    public static final int U_CARINFO_D68_D3_B32 = 151;
    public static final int U_CARINFO_D68_D3_B4 = 150;
    public static final int U_CARINFO_D68_D4_B20 = 176;
    public static final int U_CARINFO_D68_D4_B3 = 175;
    public static final int U_CARINFO_D68_D4_B54 = 174;
    public static final int U_CARINFO_D68_D4_B6 = 179;
    public static final int U_CARINFO_D68_D5_B10 = 184;
    public static final int U_CARINFO_D68_D5_B2 = 183;
    public static final int U_CARINFO_D68_D5_B3 = 182;
    public static final int U_CARINFO_D68_D5_B4 = 181;
    public static final int U_CARINFO_D68_D5_B75 = 180;
    public static final int U_CARINFO_DA6_D0_B70 = 138;
    public static final int U_CARINFO_DA6_D1_B70 = 139;
    public static final int U_CARINFO_DA6_D2_B70 = 140;
    public static final int U_CARINFO_DA6_D3_B70 = 141;
    public static final int U_CARINFO_DA6_D4_B70 = 142;
    public static final int U_CARINFO_DA6_D5_B70 = 143;
    public static final int U_CARINFO_DA6_D6_B10 = 145;
    public static final int U_CARINFO_DA6_D6_B32 = 144;
    public static final int U_CARINFO_DOMEDELAY = 112;
    public static final int U_CARINFO_DOORLOCK_SET = 120;
    public static final int U_CARINFO_FATIGUE_WARN = 128;
    public static final int U_CARINFO_FOLLOWHOME = 113;
    public static final int U_CARINFO_FRONTLIGHT_MODE = 116;
    public static final int U_CARINFO_OPENDOOR_WARN = 134;
    public static final int U_CARINFO_PARALLEL_SYS = 132;
    public static final int U_CARINFO_PARK_SET = 117;
    public static final int U_CARINFO_PEDESTRIAN_SAFE = 130;
    public static final int U_CARINFO_POWERSAVE = 114;
    public static final int U_CARINFO_RAINFALLSENSOR = 115;
    public static final int U_CARINFO_REARVIEW_AUTO = 119;
    public static final int U_CARINFO_REARVIEW_SIDE_SYS = 133;
    public static final int U_CARINFO_ROADAWAY_WARN = 126;
    public static final int U_CARINFO_SEAT_MEMORY = 121;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 97;
    public static final int U_CARINFO_WARN_SNESOR = 131;
    public static final int U_CNT_MAX = 185;
    public static final int U_CUR_SPEED = 101;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 100;
    public static final int U_ENGINE_SPEED = 102;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 99;
    public static final int U_REAR_MIRROR = 103;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 98;
    public static final int U_SMART_STARTSOTP = 104;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 125;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 185; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0320_WC2_HavaH6(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 185) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
