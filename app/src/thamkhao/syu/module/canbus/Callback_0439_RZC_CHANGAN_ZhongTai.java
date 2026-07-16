package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Changan_ZhongTai;
import com.syu.ui.air.Air_0452_RZC_LeTin_Mangguo;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_RZC_CHANGAN_ZhongTai extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 166;
    public static final int U_CARINFO_D24_D2_B30 = 183;
    public static final int U_CARINFO_D24_D2_B74 = 182;
    public static final int U_CARINFO_D24_D3_B7 = 184;
    public static final int U_CARINFO_D41_D2_B30 = 187;
    public static final int U_CARINFO_D41_D2_B64 = 186;
    public static final int U_CARINFO_D41_D2_B7 = 185;
    public static final int U_CARINFO_D47_D0_D1 = 167;
    public static final int U_CARINFO_D47_D11_D12 = 175;
    public static final int U_CARINFO_D47_D13 = 176;
    public static final int U_CARINFO_D47_D14_D15 = 177;
    public static final int U_CARINFO_D47_D16 = 178;
    public static final int U_CARINFO_D47_D17_D18 = 179;
    public static final int U_CARINFO_D47_D19 = 180;
    public static final int U_CARINFO_D47_D20 = 181;
    public static final int U_CARINFO_D47_D2_D3 = 168;
    public static final int U_CARINFO_D47_D4 = 169;
    public static final int U_CARINFO_D47_D5 = 170;
    public static final int U_CARINFO_D47_D6 = 171;
    public static final int U_CARINFO_D47_D7 = 172;
    public static final int U_CARINFO_D47_D8 = 173;
    public static final int U_CARINFO_D47_D9_D10 = 174;
    public static final int U_CNT_MAX = 188;
    public static final int U_HOEM_LIGHT = 162;
    public static final int U_HOEM_LIGHT_ONOFF = 163;
    public static final int U_LIGHT_HEIGHT = 165;
    public static final int U_LIGHT_LEVL = 159;
    public static final int U_LIGHT_ONOFF = 160;
    public static final int U_PRESSURE_END = 158;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FL_AIRLINK_FAST = 106;
    public static final int U_PRESSURE_FL_AIRLINK_SLOW = 105;
    public static final int U_PRESSURE_FL_CHECKSELF = 98;
    public static final int U_PRESSURE_FL_ELIGHT = 99;
    public static final int U_PRESSURE_FL_ENABLE = 146;
    public static final int U_PRESSURE_FL_HIGH = 148;
    public static final int U_PRESSURE_FL_HIGHTEMP = 101;
    public static final int U_PRESSURE_FL_HIGHTEMP_S = 102;
    public static final int U_PRESSURE_FL_HIGH_AIR = 104;
    public static final int U_PRESSURE_FL_LOSE = 97;
    public static final int U_PRESSURE_FL_LOW = 147;
    public static final int U_PRESSURE_FL_LOW_AIR = 103;
    public static final int U_PRESSURE_FL_SYSTERM = 96;
    public static final int U_PRESSURE_FL_TEMP = 95;
    public static final int U_PRESSURE_FL_VLOW = 100;
    public static final int U_PRESSURE_FR = 107;
    public static final int U_PRESSURE_FR_AIRLINK_FAST = 119;
    public static final int U_PRESSURE_FR_AIRLINK_SLOW = 118;
    public static final int U_PRESSURE_FR_CHECKSELF = 111;
    public static final int U_PRESSURE_FR_ELIGHT = 112;
    public static final int U_PRESSURE_FR_ENABLE = 149;
    public static final int U_PRESSURE_FR_HIGH = 151;
    public static final int U_PRESSURE_FR_HIGHTEMP = 114;
    public static final int U_PRESSURE_FR_HIGHTEMP_S = 115;
    public static final int U_PRESSURE_FR_HIGH_AIR = 117;
    public static final int U_PRESSURE_FR_LOSE = 110;
    public static final int U_PRESSURE_FR_LOW = 150;
    public static final int U_PRESSURE_FR_LOW_AIR = 116;
    public static final int U_PRESSURE_FR_SYSTERM = 109;
    public static final int U_PRESSURE_FR_TEMP = 108;
    public static final int U_PRESSURE_FR_VLOW = 113;
    public static final int U_PRESSURE_RL = 120;
    public static final int U_PRESSURE_RL_AIRLINK_FAST = 132;
    public static final int U_PRESSURE_RL_AIRLINK_SLOW = 131;
    public static final int U_PRESSURE_RL_CHECKSELF = 124;
    public static final int U_PRESSURE_RL_ELIGHT = 125;
    public static final int U_PRESSURE_RL_ENABLE = 152;
    public static final int U_PRESSURE_RL_HIGH = 154;
    public static final int U_PRESSURE_RL_HIGHTEMP = 127;
    public static final int U_PRESSURE_RL_HIGHTEMP_S = 128;
    public static final int U_PRESSURE_RL_HIGH_AIR = 130;
    public static final int U_PRESSURE_RL_LOSE = 123;
    public static final int U_PRESSURE_RL_LOW = 153;
    public static final int U_PRESSURE_RL_LOW_AIR = 129;
    public static final int U_PRESSURE_RL_SYSTERM = 122;
    public static final int U_PRESSURE_RL_TEMP = 121;
    public static final int U_PRESSURE_RL_VLOW = 126;
    public static final int U_PRESSURE_RR = 133;
    public static final int U_PRESSURE_RR_AIRLINK_FAST = 145;
    public static final int U_PRESSURE_RR_AIRLINK_SLOW = 144;
    public static final int U_PRESSURE_RR_CHECKSELF = 137;
    public static final int U_PRESSURE_RR_ELIGHT = 138;
    public static final int U_PRESSURE_RR_ENABLE = 155;
    public static final int U_PRESSURE_RR_HIGH = 157;
    public static final int U_PRESSURE_RR_HIGHTEMP = 140;
    public static final int U_PRESSURE_RR_HIGHTEMP_S = 141;
    public static final int U_PRESSURE_RR_HIGH_AIR = 143;
    public static final int U_PRESSURE_RR_LOSE = 136;
    public static final int U_PRESSURE_RR_LOW = 156;
    public static final int U_PRESSURE_RR_LOW_AIR = 142;
    public static final int U_PRESSURE_RR_SYSTERM = 135;
    public static final int U_PRESSURE_RR_TEMP = 134;
    public static final int U_PRESSURE_RR_VLOW = 139;
    public static final int U_ROAD_AWAY = 164;
    public static final int U_SEAT_PLEASE = 161;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 188; i++) {
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
        if (DataCanbus.DATA[1000] == 13697476) {
            AirHelper.getInstance().buildUi(new Air_0452_RZC_LeTin_Mangguo(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0439_RZC_Changan_ZhongTai(TheApp.getInstance()));
        }
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
        if (updateCode >= 0 && updateCode < 188) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
