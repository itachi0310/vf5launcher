package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Feiyate_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Fieyate_All extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_END = 106;
    public static final int U_CARINFO_TRIPA_AVG_OIL = 98;
    public static final int U_CARINFO_TRIPA_AVG_SPEEDL = 99;
    public static final int U_CARINFO_TRIPA_DRIVED_TIME = 101;
    public static final int U_CARINFO_TRIPA_TOTAL_MILE = 100;
    public static final int U_CARINFO_TRIPB_AVG_OIL = 102;
    public static final int U_CARINFO_TRIPB_AVG_SPEEDL = 103;
    public static final int U_CARINFO_TRIPB_DRIVED_TIME = 105;
    public static final int U_CARINFO_TRIPB_TOTAL_MILE = 104;
    public static final int U_CARINFO_TRIP_CUR_OIL = 95;
    public static final int U_CARINFO_TRIP_DRIVENABLE_OIL = 96;
    public static final int U_CARINFO_TRIP_TOTAL_MILE = 97;
    public static final int U_CARSET_BEGIN = 107;
    public static final int U_CARSET_CORERING_LIGHTS = 118;
    public static final int U_CARSET_COURTESYLIGHT_DELAY = 123;
    public static final int U_CARSET_COURTESY_LIGHTS = 119;
    public static final int U_CARSET_D76_D0_B20 = 149;
    public static final int U_CARSET_D76_D0_B3 = 152;
    public static final int U_CARSET_D76_D0_B4 = 151;
    public static final int U_CARSET_D76_D0_B65 = 150;
    public static final int U_CARSET_D76_D0_B7 = 148;
    public static final int U_CARSET_D76_D1_B10 = 157;
    public static final int U_CARSET_D76_D1_B3 = 156;
    public static final int U_CARSET_D76_D1_B4 = 155;
    public static final int U_CARSET_D76_D1_B6 = 154;
    public static final int U_CARSET_D76_D1_B7 = 153;
    public static final int U_CARSET_D76_D3_B5 = 126;
    public static final int U_CARSET_D76_D3_B76 = 125;
    public static final int U_CARSET_D79_D2_B10 = 162;
    public static final int U_CARSET_D79_D2_B32 = 161;
    public static final int U_CARSET_D79_D2_B54 = 160;
    public static final int U_CARSET_D79_D2_B6 = 159;
    public static final int U_CARSET_D79_D2_B7 = 158;
    public static final int U_CARSET_D79_D3_B10 = 134;
    public static final int U_CARSET_D79_D3_B32 = 133;
    public static final int U_CARSET_D79_D3_B54 = 132;
    public static final int U_CARSET_D79_D3_B76 = 131;
    public static final int U_CARSET_D79_D4_B0 = 139;
    public static final int U_CARSET_D79_D4_B1 = 138;
    public static final int U_CARSET_D79_D4_B32 = 137;
    public static final int U_CARSET_D79_D4_B54 = 136;
    public static final int U_CARSET_D79_D4_B76 = 135;
    public static final int U_CARSET_D79_D5_B0 = 142;
    public static final int U_CARSET_D79_D5_B1 = 141;
    public static final int U_CARSET_D79_D5_B32 = 140;
    public static final int U_CARSET_D79_D5_B4 = 164;
    public static final int U_CARSET_D79_D5_B5 = 163;
    public static final int U_CARSET_D79_D6_B0 = 145;
    public static final int U_CARSET_D79_D6_B31 = 144;
    public static final int U_CARSET_D79_D6_B74 = 143;
    public static final int U_CARSET_D79_D7_B70 = 146;
    public static final int U_CARSET_D94_D0_B70 = 124;
    public static final int U_CARSET_DAY_LIGHT = 112;
    public static final int U_CARSET_DOOR_AUTOLOCK = 111;
    public static final int U_CARSET_FLAHLIGHT_LOCK = 117;
    public static final int U_CARSET_HEADLIGHT_DELAY = 122;
    public static final int U_CARSET_MEASURE_UNIT = 114;
    public static final int U_CARSET_MILE_UNIT = 108;
    public static final int U_CARSET_OIL_UNIT = 109;
    public static final int U_CARSET_PARKSENSE = 120;
    public static final int U_CARSET_PRESSURE_UNIT = 147;
    public static final int U_CARSET_REARPARK_VOL = 116;
    public static final int U_CARSET_REARVIEW_DELAY = 121;
    public static final int U_CARSET_REARV_GUID = 115;
    public static final int U_CARSET_TEMP_UNIT = 110;
    public static final int U_CARSET_TRIB_ONOFF = 113;
    public static final int U_CNT_MAX = 165;
    public static final int U_PRESSURE_FL = 127;
    public static final int U_PRESSURE_FR = 128;
    public static final int U_PRESSURE_RL = 129;
    public static final int U_PRESSURE_RR = 130;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 165; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Feiyate_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 165) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
