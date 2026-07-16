package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0447_OD_RZC_19Tusheng;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0447_OD_RZC3_19Tusheng extends CallbackCanbusBase {
    public static final int U_CARINFO_D52_D10_B70 = 169;
    public static final int U_CARINFO_D52_D11_B70 = 170;
    public static final int U_CARINFO_D52_D12_B70 = 171;
    public static final int U_CARINFO_D52_D13_B70 = 188;
    public static final int U_CARINFO_D52_D14_B70 = 179;
    public static final int U_CARINFO_D52_D20_B70 = 151;
    public static final int U_CARINFO_D52_D21_B70 = 152;
    public static final int U_CARINFO_D52_D22_B70 = 153;
    public static final int U_CARINFO_D52_D23_B70 = 154;
    public static final int U_CARINFO_D52_D30_B70 = 155;
    public static final int U_CARINFO_D52_D31_B70 = 156;
    public static final int U_CARINFO_D52_D32_B70 = 157;
    public static final int U_CARINFO_D52_D33_B70 = 158;
    public static final int U_CARINFO_D52_D34_B70 = 159;
    public static final int U_CARINFO_D52_D35_B70 = 160;
    public static final int U_CARINFO_D52_D36_B70 = 161;
    public static final int U_CARINFO_D52_D37_D1_D2 = 162;
    public static final int U_CARINFO_D52_D38_D1_D2 = 163;
    public static final int U_CARINFO_D52_D40_B70 = 164;
    public static final int U_CARINFO_D52_D50_B70 = 165;
    public static final int U_CARINFO_D52_D60_B70 = 166;
    public static final int U_CARINFO_D52_D61_B70 = 167;
    public static final int U_CARINFO_D52_D62_B70 = 168;
    public static final int U_CARINFO_D52_D70_B70 = 172;
    public static final int U_CARINFO_D52_D71_B70 = 173;
    public static final int U_CARINFO_D52_D72_B70 = 174;
    public static final int U_CARINFO_D52_D73_B70 = 175;
    public static final int U_CARINFO_D52_D7_B70 = 110;
    public static final int U_CARINFO_D52_D80_B70 = 176;
    public static final int U_CARINFO_D52_D81_B70 = 177;
    public static final int U_CARINFO_D52_D82_B70 = 178;
    public static final int U_CARINFO_D52_D83_B70 = 179;
    public static final int U_CARINFO_D52_D8_B70 = 111;
    public static final int U_CARINFO_D52_D90_B70 = 180;
    public static final int U_CARINFO_D52_D91_B70 = 181;
    public static final int U_CARINFO_D52_D92_B70 = 182;
    public static final int U_CARINFO_D52_D9_B70 = 112;
    public static final int U_CARINFO_D52_DA0_B70 = 183;
    public static final int U_CARINFO_D52_DA1_B70 = 184;
    public static final int U_CARINFO_D52_DA2_B70 = 185;
    public static final int U_CARINFO_D52_DA3_B70 = 186;
    public static final int U_CARINFO_D52_DA4_B70 = 187;
    public static final int U_CARINFO_D52_DA_B70 = 113;
    public static final int U_CARINFO_D52_DB_B70 = 114;
    public static final int U_CARINFO_D52_DC_B70 = 115;
    public static final int U_CARINFO_D52_DD_B70 = 116;
    public static final int U_CARINFO_D52_DE_B70 = 117;
    public static final int U_CARINFO_D52_DF_B70 = 118;
    public static final int U_CARINFO_D53_D0_B70 = 119;
    public static final int U_CARINFO_D53_D10_B10 = 134;
    public static final int U_CARINFO_D53_D10_B32 = 133;
    public static final int U_CARINFO_D53_D10_B4 = 132;
    public static final int U_CARINFO_D53_D10_B5 = 131;
    public static final int U_CARINFO_D53_D10_B6 = 130;
    public static final int U_CARINFO_D53_D10_B7 = 129;
    public static final int U_CARINFO_D53_D11_B70 = 135;
    public static final int U_CARINFO_D53_D1_B70 = 120;
    public static final int U_CARINFO_D53_D2_B70 = 121;
    public static final int U_CARINFO_D53_D3_B70 = 122;
    public static final int U_CARINFO_D53_D4_B70 = 123;
    public static final int U_CARINFO_D53_D5_B70 = 124;
    public static final int U_CARINFO_D53_D6_B70 = 125;
    public static final int U_CARINFO_D53_D7_B70 = 126;
    public static final int U_CARINFO_D53_D8_B70 = 127;
    public static final int U_CARINFO_D53_D9_B70 = 128;
    public static final int U_CARINFO_D54_D0_B70 = 136;
    public static final int U_CARINFO_D54_D10_D11 = 142;
    public static final int U_CARINFO_D54_D1_D2 = 137;
    public static final int U_CARINFO_D54_D3_D4 = 138;
    public static final int U_CARINFO_D54_D5_B70 = 139;
    public static final int U_CARINFO_D54_D6_B70 = 140;
    public static final int U_CARINFO_D54_D7_D8_D9 = 141;
    public static final int U_CARINFO_D55_D0_D1 = 143;
    public static final int U_CARINFO_D55_D11_B30 = 150;
    public static final int U_CARINFO_D55_D11_B74 = 149;
    public static final int U_CARINFO_D55_D2_D3 = 144;
    public static final int U_CARINFO_D55_D4_D5 = 145;
    public static final int U_CARINFO_D55_D6_B70 = 146;
    public static final int U_CARINFO_D55_D7_D8 = 147;
    public static final int U_CARINFO_D55_D9_D10 = 148;
    public static final int U_CARINFO_EQ_BAL = 98;
    public static final int U_CARINFO_EQ_BASS = 94;
    public static final int U_CARINFO_EQ_FAD = 97;
    public static final int U_CARINFO_EQ_MID = 95;
    public static final int U_CARINFO_EQ_TREB = 96;
    public static final int U_CARINFO_LAGUAGE = 190;
    public static final int U_CARSET_AUTO_TEMP_CTRL = 105;
    public static final int U_CARSET_BEGIN = 99;
    public static final int U_CARSET_BLIND_POINT = 104;
    public static final int U_CARSET_GUIJI = 100;
    public static final int U_CARSET_RADAR = 101;
    public static final int U_CARSET_SEAT_HOTBLOW = 109;
    public static final int U_CARSET_STEER_HOT = 108;
    public static final int U_CARSET_THIRD_SEAT_LEFT = 106;
    public static final int U_CARSET_THIRD_SEAT_RIGHT = 107;
    public static final int U_CARSET_VIEW_FRONT = 102;
    public static final int U_CARSET_VIEW_REAR = 103;
    public static final int U_CNT_MAX = 191;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 191; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0447_OD_RZC_19Tusheng(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 191) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
