package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Fengye_80V;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_Fengye_80V extends CallbackCanbusBase {
    public static final int U_CARSET_D4F_D0_B10 = 131;
    public static final int U_CARSET_D4F_D0_B2 = 130;
    public static final int U_CARSET_D4F_D1_B5 = 134;
    public static final int U_CARSET_D4F_D1_B6 = 133;
    public static final int U_CARSET_D4F_D1_B7 = 132;
    public static final int U_CARSET_D4F_D2_B3 = 136;
    public static final int U_CARSET_D4F_D2_B65 = 135;
    public static final int U_CARSET_D4F_D3_B0 = 140;
    public static final int U_CARSET_D4F_D3_B1 = 139;
    public static final int U_CARSET_D4F_D3_B2 = 138;
    public static final int U_CARSET_D4F_D3_B43 = 137;
    public static final int U_CARSET_D4F_D4_B0 = 147;
    public static final int U_CARSET_D4F_D4_B1 = 146;
    public static final int U_CARSET_D4F_D4_B32 = 145;
    public static final int U_CARSET_D4F_D4_B4 = 144;
    public static final int U_CARSET_D4F_D4_B5 = 143;
    public static final int U_CARSET_D4F_D4_B6 = 142;
    public static final int U_CARSET_D4F_D4_B7 = 141;
    public static final int U_CARSET_D4F_D5_B5 = 150;
    public static final int U_CARSET_D4F_D5_B6 = 149;
    public static final int U_CARSET_D4F_D5_B7 = 148;
    public static final int U_CARSET_D4F_D6_B70 = 151;
    public static final int U_CARSET_D4F_D7_B6 = 153;
    public static final int U_CARSET_D4F_D7_B7 = 152;
    public static final int U_CARSET_D4F_D8_B70 = 154;
    public static final int U_CARSET_D50_D0_B10 = 94;
    public static final int U_CARSET_D50_D1_B10 = 96;
    public static final int U_CARSET_D50_D1_B2 = 117;
    public static final int U_CARSET_D50_D1_B3 = 116;
    public static final int U_CARSET_D50_D1_B74 = 95;
    public static final int U_CARSET_D50_D2_B10 = 101;
    public static final int U_CARSET_D50_D2_B2 = 100;
    public static final int U_CARSET_D50_D2_B3 = 99;
    public static final int U_CARSET_D50_D2_B4 = 98;
    public static final int U_CARSET_D50_D2_B65 = 97;
    public static final int U_CARSET_D50_D3_B0 = 103;
    public static final int U_CARSET_D50_D3_B1 = 102;
    public static final int U_CARSET_D50_D4_B5 = 120;
    public static final int U_CARSET_D50_D4_B6 = 119;
    public static final int U_CARSET_D50_D4_B7 = 118;
    public static final int U_CARSET_D50_D5_B70 = 121;
    public static final int U_CARSET_D50_D6_B30 = 123;
    public static final int U_CARSET_D50_D6_B54 = 122;
    public static final int U_CARSET_D50_D7_B70 = 124;
    public static final int U_CARSET_D50_D8_B20 = 129;
    public static final int U_CARSET_D50_D8_B4 = 128;
    public static final int U_CARSET_D50_D8_B5 = 127;
    public static final int U_CARSET_D50_D8_B6 = 126;
    public static final int U_CARSET_D50_D8_B7 = 125;
    public static final int U_CNT_MAX = 155;
    public static final int U_TIRE_STATE_FL = 104;
    public static final int U_TIRE_STATE_FR = 105;
    public static final int U_TIRE_STATE_RL = 106;
    public static final int U_TIRE_STATE_RR = 107;
    public static final int U_TIRE_TEMP_FL = 112;
    public static final int U_TIRE_TEMP_FR = 113;
    public static final int U_TIRE_TEMP_RL = 114;
    public static final int U_TIRE_TEMP_RR = 115;
    public static final int U_TIRE_VALUE_FL = 108;
    public static final int U_TIRE_VALUE_FR = 109;
    public static final int U_TIRE_VALUE_RL = 110;
    public static final int U_TIRE_VALUE_RR = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 155; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Fengye_80V(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 155) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
