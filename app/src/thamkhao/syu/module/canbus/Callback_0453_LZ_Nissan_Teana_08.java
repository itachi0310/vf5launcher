package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AIR_0453_LZ_Nissan_Teana_08;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_Nissan_Teana_08 extends CallbackCanbusBase {
    public static String Str_Line1 = null;
    public static String Str_Line2 = null;
    public static final int U_CARCD_DISC1 = 152;
    public static final int U_CARCD_DISC2 = 151;
    public static final int U_CARCD_DISC3 = 150;
    public static final int U_CARCD_DISC4 = 149;
    public static final int U_CARCD_DISC5 = 148;
    public static final int U_CARCD_DISC6 = 147;
    public static final int U_CARCD_END = 159;
    public static final int U_CARCD_NUM = 154;
    public static final int U_CARCD_PLAYSTATE = 153;
    public static final int U_CARCD_REPEAT = 155;
    public static final int U_CARCD_TIME_M = 157;
    public static final int U_CARCD_TIME_S = 158;
    public static final int U_CARCD_TRACK = 156;
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_D35_D10_B6 = 102;
    public static final int U_CARINF_D35_D10_B7 = 101;
    public static final int U_CARINF_D35_D2_D3 = 99;
    public static final int U_CARINF_D35_D7_D8_D9 = 100;
    public static final int U_CARINF_D37_D0_D1 = 95;
    public static final int U_CARINF_D37_D2_D3 = 96;
    public static final int U_CARINF_D37_D4_D5_D6 = 97;
    public static final int U_CARINF_D37_D7_D8 = 98;
    public static final int U_CARINF_D3B_D0_B70 = 107;
    public static final int U_CARINF_D3B_D1_B70 = 108;
    public static final int U_CARINF_D3B_D2_B70 = 109;
    public static final int U_CARINF_D3B_D3_B70 = 110;
    public static final int U_CARINF_D3B_D4_B70 = 111;
    public static final int U_CARINF_D3B_D5_B30 = 114;
    public static final int U_CARINF_D3B_D5_B4 = 113;
    public static final int U_CARINF_D3B_D5_B5 = 112;
    public static final int U_CARINF_D3B_D6_B70 = 115;
    public static final int U_CARINF_D3C_D1_ALL_STR = 116;
    public static final int U_CARINF_D3C_D2_ALL_STR = 117;
    public static final int U_CARINF_D3C_D3_D1_B0 = 118;
    public static final int U_CARINF_D3C_D3_D1_B1 = 119;
    public static final int U_CARINF_D3C_D3_D1_B2 = 120;
    public static final int U_CARINF_D3C_D3_D1_B3 = 121;
    public static final int U_CARINF_D3C_D3_D1_B4 = 122;
    public static final int U_CARINF_D3C_D3_D1_B5 = 123;
    public static final int U_CARINF_D3C_D3_D1_B6 = 124;
    public static final int U_CARINF_D3C_D3_D1_B7 = 125;
    public static final int U_CARINF_D3C_D3_D2_B0 = 126;
    public static final int U_CARINF_D3C_D3_D2_B1 = 127;
    public static final int U_CARINF_D3C_D3_D2_B2 = 128;
    public static final int U_CARINF_D3C_D3_D2_B3 = 129;
    public static final int U_CARINF_D3C_D3_D2_B4 = 130;
    public static final int U_CARINF_D3C_D3_D2_B5 = 131;
    public static final int U_CARINF_D3C_D3_D2_B6 = 132;
    public static final int U_CARINF_D3C_D3_D2_B7 = 133;
    public static final int U_CARINF_D3C_D3_D3_B0 = 134;
    public static final int U_CARINF_D3C_D3_D3_B1 = 135;
    public static final int U_CARRADIO_BAND = 137;
    public static final int U_CARRADIO_BEGIN = 136;
    public static final int U_CARRADIO_CHANNELE = 138;
    public static final int U_CARRADIO_END = 146;
    public static final int U_CARRADIO_FRQ = 139;
    public static final int U_CARRADIO_FRQ1 = 140;
    public static final int U_CARRADIO_FRQ2 = 141;
    public static final int U_CARRADIO_FRQ3 = 142;
    public static final int U_CARRADIO_FRQ4 = 143;
    public static final int U_CARRADIO_FRQ5 = 144;
    public static final int U_CARRADIO_FRQ6 = 145;
    public static final int U_CAR_AIR_TYPR = 160;
    public static final int U_CNT_MAX = 161;
    public static final int U_PRESSURE_FL = 103;
    public static final int U_PRESSURE_FR = 104;
    public static final int U_PRESSURE_RL = 105;
    public static final int U_PRESSURE_RR = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 161; i++) {
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
        AirHelper.getInstance().buildUi(new AIR_0453_LZ_Nissan_Teana_08(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        switch (updateCode) {
            case 116:
                if (strs != null && strs.length > 0) {
                    Str_Line1 = strs[0];
                } else {
                    Str_Line1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 117:
                if (strs != null && strs.length > 0) {
                    Str_Line2 = strs[0];
                } else {
                    Str_Line2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 161) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }
}
