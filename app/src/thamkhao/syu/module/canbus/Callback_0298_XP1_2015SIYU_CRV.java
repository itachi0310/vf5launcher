package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0298_BNR_2016GuanDao;
import com.syu.ui.air.Air_0298_XP1_2015SIYU_CRV;
import com.syu.ui.air.Air_0298_XP1_2016SIYU;
import com.syu.ui.air.Air_0298_zx_6606_honda;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Air_RZC_23Yage;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0298_XP1_2015SIYU_CRV extends CallbackCanbusBase {
    public static final int U_CAMERAMODE_DRIVING = 207;
    public static final int U_CAMERA_APANORAMA_EXIT = 202;
    public static final int U_CAMERA_AUTO_OPEN_TUNK = 206;
    public static final int U_CAMERA_BACK_PARKMODE = 211;
    public static final int U_CAMERA_CROSSROADS_MONITOR = 212;
    public static final int U_CAMERA_FRONTORLR_VIEW = 203;
    public static final int U_CAMERA_LOWSPEED_START = 209;
    public static final int U_CAMERA_PARKING_ASSISTANCE = 205;
    public static final int U_CAMERA_PRE_PARKMODE = 210;
    public static final int U_CAMERA_REAR_VIEW = 204;
    public static final int U_CAMERA_START_REARVIEW = 208;
    public static final int U_CARINFO_ACC_DISCOVERY_VEHICLE_IN_FRONT_TONE = 140;
    public static final int U_CARINFO_ADJUST_ALARM_VOLUME = 131;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 125;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 124;
    public static final int U_CARINFO_AUTO_HEADLIGHT_WIPER = 137;
    public static final int U_CARINFO_AUTO_INTER_ILLUMINATION = 130;
    public static final int U_CARINFO_AUTO_LIGHT_SENSITIVITY = 118;
    public static final int U_CARINFO_AWD_INFO = 190;
    public static final int U_CARINFO_BACK_CAR_BEEP_TONE = 149;
    public static final int U_CARINFO_BEGIN = 114;
    public static final int U_CARINFO_DOOR_UNLOCK_MODE = 128;
    public static final int U_CARINFO_DRIVER_WATCH_MONITOR = 188;
    public static final int U_CARINFO_DRIVING_POSITION_REMORY = 152;
    public static final int U_CARINFO_DYNAMIC_LINE = 196;
    public static final int U_CARINFO_ELE_DOOR_OPEN_AUTO_OR_MANULE = 151;
    public static final int U_CARINFO_ELE_DOOR_REMOTE_OPEN_CONDITION = 150;
    public static final int U_CARINFO_ENERGY_SAVE_AUTO_ENGHINE = 139;
    public static final int U_CARINFO_FUEL_EFFIC_BACKLIGHT = 132;
    public static final int U_CARINFO_HEADLIGHT_AUTO_OFF_TIME = 119;
    public static final int U_CARINFO_INOUT_SEAT_SPORT = 153;
    public static final int U_CARINFO_INTERIOR_LIGHT_DIMMING_TIME = 120;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEP = 126;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEPVOL = 148;
    public static final int U_CARINFO_KEYLESS_ACCESS_LIGHT_FLASH = 129;
    public static final int U_CARINFO_KEY_AND_REMOTE_UNLOCK_MODE = 122;
    public static final int U_CARINFO_KEY_LOCK_ANSWER = 121;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE = 177;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_PN_UNIT = 176;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_UNIT = 175;
    public static final int U_CARINFO_MEMORY_SEAT = 193;
    public static final int U_CARINFO_MINOR_LANE_DEPARTURE_SYS_SETTINGS = 143;
    public static final int U_CARINFO_MULTI_FUNCTION = 201;
    public static final int U_CARINFO_NEW_MSG_NOTIF = 133;
    public static final int U_CARINFO_OUT_TEMP_SHOW = 117;
    public static final int U_CARINFO_PANORAMIC_IMAGE = 200;
    public static final int U_CARINFO_PARK_SPACE = 198;
    public static final int U_CARINFO_PAUSE_LKAS_TONE = 141;
    public static final int U_CARINFO_PILAO_DRIVER = 189;
    public static final int U_CARINFO_REMAIN_EC = 214;
    public static final int U_CARINFO_REMINDER_SYSTEM = 199;
    public static final int U_CARINFO_REMOTE_START_SYS = 127;
    public static final int U_CARINFO_RISE_WARNING = 192;
    public static final int U_CARINFO_SEAT_BELT = 194;
    public static final int U_CARINFO_SECURITY_RELOCK_TIME = 123;
    public static final int U_CARINFO_SET_FRONT_HAZARD_DISTANCE = 142;
    public static final int U_CARINFO_SHOW_CAMERA = 197;
    public static final int U_CARINFO_SPEED_DISTANCE_UNIT = 134;
    public static final int U_CARINFO_STATIC_LINE = 195;
    public static final int U_CARINFO_TACHOMETER = 135;
    public static final int U_CARINFO_TACHOMETER_SET = 144;
    public static final int U_CARINFO_TRAFFIC_SIGN = 191;
    public static final int U_CARINFO_TRIP_A = 115;
    public static final int U_CARINFO_TRIP_B = 116;
    public static final int U_CARINFO_VOLUME_ALARM_SYS = 138;
    public static final int U_CARINFO_WALK_AWAY_AUTO_LOCK = 136;
    public static final int U_CARINF_DAY_HOUR = 221;
    public static final int U_CARINF_DAY_MDAY = 224;
    public static final int U_CARINF_DAY_MIN = 222;
    public static final int U_CARINF_DAY_MONTH = 223;
    public static final int U_CARINF_DAY_WEEKDAY = 225;
    public static final int U_CARINF_GEAR = 227;
    public static final int U_CARINF_TEMPOUT = 226;
    public static final int U_CARRADIO_BEGIN = 233;
    public static final int U_CARRADIO_END = 245;
    public static final int U_CARRADIO_GUIJ = 220;
    public static final int U_CARSET_BACKCAR_DELAY = 228;
    public static final int U_CARSET_D32_D10_B2 = 232;
    public static final int U_CARSET_D32_D10_B3 = 231;
    public static final int U_CARSET_D32_D10_B4 = 219;
    public static final int U_CARSET_D32_D10_B5 = 218;
    public static final int U_CARSET_D32_D10_B6 = 217;
    public static final int U_CARSET_D32_D10_B7 = 216;
    public static final int U_CARSET_D32_D11_B0 = 301;
    public static final int U_CARSET_D32_D11_B1 = 300;
    public static final int U_CARSET_D32_D11_B2 = 299;
    public static final int U_CARSET_D32_D11_B3 = 298;
    public static final int U_CARSET_D32_D11_B4 = 297;
    public static final int U_CARSET_D32_D11_B75 = 296;
    public static final int U_CARSET_D32_D8_B4 = 230;
    public static final int U_CARSET_D32_D8_B5 = 215;
    public static final int U_CARSET_D32_D8_B6 = 213;
    public static final int U_CARSET_D33_D05_D11_D13 = 250;
    public static final int U_CARSET_D33_D05_D14_D15 = 251;
    public static final int U_CARSET_D33_D05_D16_D18 = 252;
    public static final int U_CARSET_D33_D05_D19_D20 = 253;
    public static final int U_CARSET_D33_D05_D1_D3 = 246;
    public static final int U_CARSET_D33_D05_D21_B10 = 258;
    public static final int U_CARSET_D33_D05_D21_B32 = 257;
    public static final int U_CARSET_D33_D05_D21_B54 = 256;
    public static final int U_CARSET_D33_D05_D21_B6 = 255;
    public static final int U_CARSET_D33_D05_D21_B7 = 254;
    public static final int U_CARSET_D33_D05_D22 = 259;
    public static final int U_CARSET_D33_D05_D4_D5 = 247;
    public static final int U_CARSET_D33_D05_D6_D8 = 248;
    public static final int U_CARSET_D33_D05_D9_D10 = 249;
    public static final int U_CARSET_D35_D0_B30 = 266;
    public static final int U_CARSET_D35_D1_B70 = 267;
    public static final int U_CARSET_D35_D2_B70 = 268;
    public static final int U_CARSET_D35_D3_B1 = 275;
    public static final int U_CARSET_D35_D3_B2 = 274;
    public static final int U_CARSET_D35_D3_B3 = 273;
    public static final int U_CARSET_D35_D3_B4 = 272;
    public static final int U_CARSET_D35_D3_B5 = 271;
    public static final int U_CARSET_D35_D3_B6 = 270;
    public static final int U_CARSET_D35_D3_B7 = 269;
    public static final int U_CARSET_D35_D4_B70 = 276;
    public static final int U_CARSET_D36_D0_B0 = 284;
    public static final int U_CARSET_D36_D0_B1 = 283;
    public static final int U_CARSET_D36_D0_B2 = 282;
    public static final int U_CARSET_D36_D0_B3 = 281;
    public static final int U_CARSET_D36_D0_B4 = 280;
    public static final int U_CARSET_D36_D0_B5 = 279;
    public static final int U_CARSET_D36_D0_B6 = 278;
    public static final int U_CARSET_D36_D0_B7 = 277;
    public static final int U_CARSET_D36_D1_B4 = 288;
    public static final int U_CARSET_D36_D1_B5 = 287;
    public static final int U_CARSET_D36_D1_B6 = 286;
    public static final int U_CARSET_D36_D1_B7 = 285;
    public static final int U_CARSET_D36_D2_B70 = 289;
    public static final int U_CARSET_D36_D3_B7 = 290;
    public static final int U_CARSET_D52_D0_B70 = 304;
    public static final int U_CARSET_D52_D1_B70 = 305;
    public static final int U_CARSET_DF2_D07_D0_B70 = 260;
    public static final int U_CARSET_DF2_D07_D1_B70 = 261;
    public static final int U_CARSET_DF2_D07_D2_B70 = 262;
    public static final int U_CARSET_DF2_D07_D3_B70 = 263;
    public static final int U_CARSET_DF2_D07_D4_B70 = 264;
    public static final int U_CARSET_DF2_D08_D0_B70 = 265;
    public static final int U_CARSET_DF2_D17_D0_B70 = 292;
    public static final int U_CARSET_DF2_D18_D0_B70 = 293;
    public static final int U_CARSET_DF2_D19_D0_B70 = 294;
    public static final int U_CARSET_DF2_D1A_D0_B70 = 295;
    public static final int U_CARSET_DF2_D1B_D0_B70 = 302;
    public static final int U_CARSET_DF2_D1B_D1_B70 = 303;
    public static final int U_CARSET_DOORLOCK = 229;
    public static final int U_CNT_MAX = 306;
    public static final int U_CUR_SPEED = 145;
    public static final int U_DRIVER_ATTENTION_MONITOR = 154;
    public static final int U_ENGINE_SPEED = 147;
    public static final int U_GUANDAO_AMP_0 = 179;
    public static final int U_GUANDAO_AMP_1 = 180;
    public static final int U_GUANDAO_AMP_2 = 181;
    public static final int U_GUANDAO_AMP_3 = 182;
    public static final int U_GUANDAO_AMP_4 = 183;
    public static final int U_GUANDAO_AMP_5 = 184;
    public static final int U_GUANDAO_AMP_6 = 185;
    public static final int U_GUANDAO_AMP_7 = 186;
    public static final int U_GUANDAO_AMP_8 = 187;
    public static final int U_INFO_BEGIN = 155;
    public static final int U_INFO_CAR_BT_BATTERY = 169;
    public static final int U_INFO_CAR_BT_SINGAL = 168;
    public static final int U_INFO_CAR_BT_STATE = 167;
    public static final int U_INFO_CAR_CD_STATE = 164;
    public static final int U_INFO_CAR_RADIO_AUTOSELECT = 161;
    public static final int U_INFO_CAR_RADIO_SCAN = 163;
    public static final int U_INFO_CAR_RADIO_ST = 162;
    public static final int U_INFO_CAR_SOUND_CHANNEL = 174;
    public static final int U_INFO_CAR_TIME_AMPM = 171;
    public static final int U_INFO_CAR_TIME_FORMAT = 170;
    public static final int U_INFO_CAR_TIME_HOUR = 172;
    public static final int U_INFO_CAR_TIME_MINTUS = 173;
    public static final int U_INFO_CAR_USB_PLAYSTATE = 166;
    public static final int U_INFO_CAR_USB_PLUGINSTATE = 165;
    public static final int U_INFO_CAR_VOL = 160;
    public static final int U_INFO_CAR_VOL_SHOW = 159;
    public static final int U_INFO_CONTENT = 158;
    public static final int U_INFO_END = 178;
    public static final int U_INFO_HILIGHT = 157;
    public static final int U_INFO_TITLE = 156;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    public static final int U_STEER_BUTTON_SET = 291;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 146;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 306; i++) {
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
        if (DataCanbus.DATA[1000] == 196906 || DataCanbus.DATA[1000] == 262442 || DataCanbus.DATA[1000] == 2818346 || DataCanbus.DATA[1000] == 2883882 || DataCanbus.DATA[1000] == 786730 || DataCanbus.DATA[1000] == 852266 || DataCanbus.DATA[1000] == 917802 || DataCanbus.DATA[1000] == 4981034 || DataCanbus.DATA[1000] == 5046570 || DataCanbus.DATA[1000] == 5112106 || DataCanbus.DATA[1000] == 5177642 || DataCanbus.DATA[1000] == 5243178 || DataCanbus.DATA[1000] == 5308714 || DataCanbus.DATA[1000] == 1835306 || DataCanbus.DATA[1000] == 1900842 || DataCanbus.DATA[1000] == 2425130 || DataCanbus.DATA[1000] == 2490666 || DataCanbus.DATA[1000] == 2687274 || DataCanbus.DATA[1000] == 3211562 || DataCanbus.DATA[1000] == 3277098 || DataCanbus.DATA[1000] == 2752810 || DataCanbus.DATA[1000] == 1179946 || DataCanbus.DATA[1000] == 2359594 || DataCanbus.DATA[1000] == 2949418 || DataCanbus.DATA[1000] == 1507626 || DataCanbus.DATA[1000] == 1769770 || DataCanbus.DATA[1000] == 2556202 || DataCanbus.DATA[1000] == 1573162 || DataCanbus.DATA[1000] == 2162986 || DataCanbus.DATA[1000] == 1245482 || DataCanbus.DATA[1000] == 2228522 || DataCanbus.DATA[1000] == 4915498 || DataCanbus.DATA[1000] == 1311018 || DataCanbus.DATA[1000] == 1376554 || DataCanbus.DATA[1000] == 3146026 || DataCanbus.DATA[1000] == 3342634 || DataCanbus.DATA[1000] == 1442090) {
            AirHelper.getInstance().buildUi(new Air_0298_XP1_2016SIYU(TheApp.getInstance()));
        } else if (DataCanbus.DATA[1000] == 524586 || DataCanbus.DATA[1000] == 590122 || DataCanbus.DATA[1000] == 2031914 || DataCanbus.DATA[1000] == 2097450 || DataCanbus.DATA[1000] == 983338) {
            AirHelper.getInstance().buildUi(new Air_0298_BNR_2016GuanDao(TheApp.getInstance()));
        } else if (DataCanbus.DATA[1000] == 3014954 || DataCanbus.DATA[1000] == 3080490 || DataCanbus.DATA[1000] == 3932458 || DataCanbus.DATA[1000] == 4194602 || DataCanbus.DATA[1000] == 4784426 || DataCanbus.DATA[1000] == 4849962 || DataCanbus.DATA[1000] == 3997994) {
            AirHelper.getInstance().buildUi(new Air_0298_zx_6606_honda(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0298_XP1_2015SIYU_CRV(TheApp.getInstance()));
        }
        if (DataCanbus.DATA[1000] == 4260138) {
            Air_BenzHelper.getInstance().buildUi(new Air_RZC_23Yage(TheApp.getInstance()));
            DataCanbus.NOTIFY_EVENTS[289].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
        }
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
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 158) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 64) {
            int value = ints[0];
            if (value == 1) {
                if (!ActivityAirControl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
                    return;
                } else {
                    if (ActivityAirControl.mIsFront && ActivityAirControl.mInstance != null) {
                        ActivityAirControl.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (updateCode >= 0 && updateCode < 306) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    public static void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }
}
