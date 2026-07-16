package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0416_WC_RongWei_Rx5;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0416_WC2_RongWeiRX5 extends CallbackCanbusBase {
    public static final int U_CARINFO_BATTERY_VOLTAGE = 94;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_D14_D1_D50 = 164;
    public static final int U_CARINFO_D15_D1_D50 = 165;
    public static final int U_CARINFO_D34_D10_D11 = 160;
    public static final int U_CARINFO_D34_D12_D13 = 161;
    public static final int U_CARINFO_D34_D15_D16 = 162;
    public static final int U_CARINFO_D34_D20_D21 = 163;
    public static final int U_CARINFO_D34_D4_D5_D6 = 158;
    public static final int U_CARINFO_D34_D7_D8 = 159;
    public static final int U_CARINFO_D35_D2_B10 = 96;
    public static final int U_CARINFO_D35_D2_B76 = 95;
    public static final int U_CARINFO_D35_D3_B1 = 97;
    public static final int U_CARINFO_D35_D4_B3 = 98;
    public static final int U_CARINFO_D3F_D1_D2 = 166;
    public static final int U_CARINFO_D3F_D3_B70 = 167;
    public static final int U_CARINFO_D3F_D6_D7 = 168;
    public static final int U_CARINFO_D3F_D8_D9 = 169;
    public static final int U_CARINFO_D66_D0_B0 = 105;
    public static final int U_CARINFO_D66_D0_B1 = 104;
    public static final int U_CARINFO_D66_D0_B2 = 103;
    public static final int U_CARINFO_D66_D0_B3 = 102;
    public static final int U_CARINFO_D66_D0_B4 = 101;
    public static final int U_CARINFO_D66_D0_B5 = 100;
    public static final int U_CARINFO_D66_D0_B7 = 99;
    public static final int U_CARINFO_D66_D10_B0 = 153;
    public static final int U_CARINFO_D66_D10_B1 = 152;
    public static final int U_CARINFO_D66_D10_B2 = 151;
    public static final int U_CARINFO_D66_D10_B3 = 150;
    public static final int U_CARINFO_D66_D10_B4 = 149;
    public static final int U_CARINFO_D66_D10_B5 = 148;
    public static final int U_CARINFO_D66_D10_B6 = 147;
    public static final int U_CARINFO_D66_D10_B7 = 146;
    public static final int U_CARINFO_D66_D11_B70 = 154;
    public static final int U_CARINFO_D66_D12_B70 = 155;
    public static final int U_CARINFO_D66_D13_B70 = 156;
    public static final int U_CARINFO_D66_D14_B70 = 157;
    public static final int U_CARINFO_D66_D2_B1 = 112;
    public static final int U_CARINFO_D66_D2_B2 = 111;
    public static final int U_CARINFO_D66_D2_B3 = 110;
    public static final int U_CARINFO_D66_D2_B4 = 109;
    public static final int U_CARINFO_D66_D2_B5 = 108;
    public static final int U_CARINFO_D66_D2_B6 = 107;
    public static final int U_CARINFO_D66_D2_B7 = 106;
    public static final int U_CARINFO_D66_D3_B10 = 116;
    public static final int U_CARINFO_D66_D3_B32 = 115;
    public static final int U_CARINFO_D66_D3_B4 = 114;
    public static final int U_CARINFO_D66_D3_B5 = 113;
    public static final int U_CARINFO_D66_D4_B0 = 124;
    public static final int U_CARINFO_D66_D4_B1 = 123;
    public static final int U_CARINFO_D66_D4_B2 = 122;
    public static final int U_CARINFO_D66_D4_B3 = 121;
    public static final int U_CARINFO_D66_D4_B4 = 120;
    public static final int U_CARINFO_D66_D4_B5 = 119;
    public static final int U_CARINFO_D66_D4_B6 = 118;
    public static final int U_CARINFO_D66_D4_B7 = 117;
    public static final int U_CARINFO_D66_D5_B30 = 126;
    public static final int U_CARINFO_D66_D5_B74 = 125;
    public static final int U_CARINFO_D66_D6_B10 = 130;
    public static final int U_CARINFO_D66_D6_B32 = 129;
    public static final int U_CARINFO_D66_D6_B4 = 128;
    public static final int U_CARINFO_D66_D6_B5 = 127;
    public static final int U_CARINFO_D66_D7_B10 = 134;
    public static final int U_CARINFO_D66_D7_B32 = 133;
    public static final int U_CARINFO_D66_D7_B54 = 132;
    public static final int U_CARINFO_D66_D7_B76 = 131;
    public static final int U_CARINFO_D66_D8_B10 = 140;
    public static final int U_CARINFO_D66_D8_B2 = 139;
    public static final int U_CARINFO_D66_D8_B3 = 138;
    public static final int U_CARINFO_D66_D8_B54 = 137;
    public static final int U_CARINFO_D66_D8_B6 = 136;
    public static final int U_CARINFO_D66_D8_B7 = 135;
    public static final int U_CARINFO_D66_D9_B10 = 145;
    public static final int U_CARINFO_D66_D9_B32 = 144;
    public static final int U_CARINFO_D66_D9_B54 = 143;
    public static final int U_CARINFO_D66_D9_B6 = 142;
    public static final int U_CARINFO_D66_D9_B7 = 141;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int[] U_CARINFO_OIL_LIST = new int[50];
    public static final int U_CNT_MAX = 170;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 165) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
        } else if (updateCode == 164) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_OIL_LIST[ints[0]] = ints[1];
        } else if (updateCode >= 0 && updateCode < 170) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 170; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0416_WC_RongWei_Rx5(TheApp.getInstance()));
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
}
