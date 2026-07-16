package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0061_RZC_XP1_GM;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0061_RZC_XP1_GM extends CallbackCanbusBase {
    public static final int REQUEST_CAR_INFO = 8;
    public static final int U_AIR_PARTITION_TEMP = 96;
    public static final int U_AIR_QUALITY_SENSOR = 95;
    public static final int U_AIR_START_MODE_SET = 100;
    public static final int U_ANJIXING_PHONE_STATE = 114;
    public static final int U_ANJIXING_STATE = 115;
    public static final int U_AUTO_COLLISION = 123;
    public static final int U_AUTO_FRONT_GOFOG_ON = 98;
    public static final int U_AUTO_REAR_GOFOG_ON = 97;
    public static final int U_AUTO_WIND_MODE = 94;
    public static final int U_AUTO_WIPERS = 120;
    public static final int U_BLIND_SIDE = 121;
    public static final int U_CARINFO_RESERVE = 113;
    public static final int U_CARINF_D05_D1_B4 = 159;
    public static final int U_CARINF_D05_D1_B5 = 158;
    public static final int U_CARINF_D06_D1_B0 = 160;
    public static final int U_CARINF_D0A_D1_B10 = 143;
    public static final int U_CARINF_D0A_D1_B2 = 142;
    public static final int U_CARINF_D0A_D1_B3 = 141;
    public static final int U_CARINF_D0A_D1_B4 = 140;
    public static final int U_CARINF_D0A_D2_B0 = 150;
    public static final int U_CARINF_D0A_D2_B1 = 149;
    public static final int U_CARINF_D0A_D2_B32 = 148;
    public static final int U_CARINF_D0A_D2_B4 = 147;
    public static final int U_CARINF_D0A_D2_B5 = 146;
    public static final int U_CARINF_D0A_D2_B6 = 145;
    public static final int U_CARINF_D0A_D2_B7 = 144;
    public static final int U_CARINF_D0A_D3_B10 = 157;
    public static final int U_CARINF_D0A_D3_B2 = 156;
    public static final int U_CARINF_D0A_D3_B3 = 155;
    public static final int U_CARINF_D0A_D3_B4 = 154;
    public static final int U_CARINF_D0A_D3_B5 = 153;
    public static final int U_CARINF_D0A_D3_B6 = 152;
    public static final int U_CARINF_D0A_D3_B7 = 151;
    public static final int U_CARINF_D0A_D4_B0 = 167;
    public static final int U_CARINF_D0A_D4_B1 = 166;
    public static final int U_CARINF_D0A_D4_B2 = 165;
    public static final int U_CARINF_D0A_D4_B3 = 164;
    public static final int U_CARINF_D0A_D4_B4 = 163;
    public static final int U_CARINF_D0A_D4_B65 = 162;
    public static final int U_CARINF_D0A_D4_B7 = 161;
    public static final int U_CARINF_D47_D0_B7 = 128;
    public static final int U_CARINF_D47_D1_B2 = 134;
    public static final int U_CARINF_D47_D1_B3 = 133;
    public static final int U_CARINF_D47_D1_B4 = 132;
    public static final int U_CARINF_D47_D1_B5 = 131;
    public static final int U_CARINF_D47_D1_B6 = 130;
    public static final int U_CARINF_D47_D1_B7 = 129;
    public static final int U_CARINF_D47_D2_B4 = 138;
    public static final int U_CARINF_D47_D2_B5 = 137;
    public static final int U_CARINF_D47_D2_B6 = 136;
    public static final int U_CARINF_D47_D2_B7 = 135;
    public static final int U_CARINF_D47_D3_B70 = 139;
    public static final int U_CARINF_D4A_D001_D1_B70 = 169;
    public static final int U_CARINF_D4A_D001_D2_B70 = 170;
    public static final int U_CARINF_D4A_D001_D3_B70 = 171;
    public static final int U_CARINF_D4A_D001_D4_B70 = 172;
    public static final int U_CARINF_D4A_D001_D5_B70 = 173;
    public static final int U_CARINF_D4A_D002_D1_D2 = 174;
    public static final int U_CARINF_D4A_D002_D3_D4 = 175;
    public static final int U_CARINF_D4A_D002_D5_D6 = 193;
    public static final int U_CARINF_D4A_D003_D10_D11_D12 = 185;
    public static final int U_CARINF_D4A_D003_D13_B70 = 186;
    public static final int U_CARINF_D4A_D003_D14_D15 = 187;
    public static final int U_CARINF_D4A_D003_D16_D17 = 188;
    public static final int U_CARINF_D4A_D003_D1_B32 = 180;
    public static final int U_CARINF_D4A_D003_D1_B4 = 179;
    public static final int U_CARINF_D4A_D003_D1_B5 = 178;
    public static final int U_CARINF_D4A_D003_D1_B6 = 177;
    public static final int U_CARINF_D4A_D003_D1_B7 = 176;
    public static final int U_CARINF_D4A_D003_D2_D3_D4 = 181;
    public static final int U_CARINF_D4A_D003_D5_B70 = 182;
    public static final int U_CARINF_D4A_D003_D6_D7 = 183;
    public static final int U_CARINF_D4A_D003_D8_D9 = 184;
    public static final int U_CARINF_D4A_D004_D1_B70 = 196;
    public static final int U_CARINF_D4A_D004_D2_B70 = 197;
    public static final int U_CARINF_D4A_D004_D3_B70 = 198;
    public static final int U_CARINF_D4A_D004_D4_D5 = 199;
    public static final int U_CARINF_D4A_D004_D6_D7 = 200;
    public static final int U_CARINF_D4A_D004_D8_B70 = 201;
    public static final int U_CARINF_D4A_D004_D9_B70 = 202;
    public static final int U_CARINF_D4B_CD_TXT = 192;
    public static final int U_CARINF_D4B_D00_B3 = 191;
    public static final int U_CARINF_D4B_D00_B64 = 190;
    public static final int U_CARINF_D4B_D00_B7 = 189;
    public static final int U_CARSET_D44_D0_B20 = 209;
    public static final int U_CARSET_D44_D0_B43 = 208;
    public static final int U_CARSET_D44_D0_B5 = 207;
    public static final int U_CARSET_D44_D0_B6 = 206;
    public static final int U_CARSET_D44_D0_B7 = 205;
    public static final int U_CARSET_D44_D1_B3 = 212;
    public static final int U_CARSET_D44_D1_B4 = 211;
    public static final int U_CARSET_D44_D1_B75 = 210;
    public static final int U_CARTIME_SET = 168;
    public static final int U_CAR_BUTTON_DOWN = 195;
    public static final int U_CAR_BUTTON_UP = 194;
    public static final int U_CAR_LANGUAGE = 127;
    public static final int U_CAR_STATUS = 124;
    public static final int U_CNT_MAX = 213;
    public static final int U_DELAY_TO_LOCK_SET = 106;
    public static final int U_DRIVER_PERSONAL_SET = 118;
    public static final int U_FORGET_KEY = 117;
    public static final int U_LEARVER_CAR_LOCK = 122;
    public static final int U_LOOKING_FOR_LIGHT = 101;
    public static final int U_LUOSUO_DELAY_SET = 102;
    public static final int U_NEAR_CAR_UNLOCK = 116;
    public static final int U_PARKING_AUTO_UNLOCK = 105;
    public static final int U_PREVENT_AUTO_LUOSUO = 103;
    public static final int U_RADAR_SWITCH = 126;
    public static final int U_REAR_WIPERS_AUTO_START = 110;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 119;
    public static final int U_REMOTE_AGAIN_LOCK_DOOR = 111;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 108;
    public static final int U_REMOTE_LOCK_SET = 109;
    public static final int U_REMOTE_START_CAR = 112;
    public static final int U_REMOTE_START_HEAT_SEAT = 99;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 107;
    public static final int U_START_AUTO_LUOSUO = 104;
    public static final int U_WARN_VOLUME = 125;
    public static final int U_WIFI_NAME = 203;
    public static final int U_WIFI_PSWORD = 204;
    public static String WifiName;
    public static String WifiPsword;
    public static String cdText;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 213; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0061_RZC_XP1_GM(TheApp.getInstance()));
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
        switch (updateCode) {
            case 114:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 192:
                if (strs != null && strs.length > 0) {
                    cdText = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 203:
                if (strs != null && strs.length > 0) {
                    WifiName = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            case 204:
                if (strs != null && strs.length > 0) {
                    WifiPsword = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
                break;
            default:
                if (updateCode >= 0 && updateCode < 213) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }
}
