package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedSetActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0118_XP1_BiaoZhi2008;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0281_XP_PSA_ALL extends CallbackCanbusBase {
    public static final int U_174008_PANNEL_LEFT = 167;
    public static final int U_174008_PANNEL_RIGHT = 168;
    public static final int U_CARCD_PLAYTIME_M = 192;
    public static final int U_CARCD_PLAYTIME_S = 193;
    public static final int U_CARCD_TRACK = 190;
    public static final int U_CARCD_TRACK_TOTAL = 191;
    public static final int U_CAREQ_AMPON = 210;
    public static final int U_CAREQ_AUTO_VOL = 209;
    public static final int U_CAREQ_BAL = 205;
    public static final int U_CAREQ_BASS = 203;
    public static final int U_CAREQ_FAD = 206;
    public static final int U_CAREQ_LOUND = 208;
    public static final int U_CAREQ_TREB = 204;
    public static final int U_CAREQ_TYPE = 207;
    public static final int U_CARINF_D38_D4_B30 = 211;
    public static final int U_CARRADIO_BAND = 185;
    public static final int U_CARRADIO_D4_B0 = 189;
    public static final int U_CARRADIO_D4_B1 = 188;
    public static final int U_CARRADIO_D4_B2 = 187;
    public static final int U_CARRADIO_FRQ = 186;
    public static final int U_CARRADIO_TXT = 202;
    public static final int U_CARSET_BLACKLIGHT = 169;
    public static final int U_CARSET_CARDOOR_LOCK_STATE = 170;
    public static final int U_CARSET_CENTER_LOCK = 171;
    public static final int U_CARSET_DRIVER_ASSIST = 162;
    public static final int U_CARSET_OIL_UNIT = 175;
    public static final int U_CARSET_ONLY_UNLOOK_BACKDOOR = 164;
    public static final int U_CARSET_PILAO_DETECT = 165;
    public static final int U_CARSET_PULL_CONTROL_SYS = 166;
    public static final int U_CARSET_THEME_COLOR = 172;
    public static final int U_CARSET_TURNLIGHT_BYDRIVER = 163;
    public static final int U_CAR_D28_D0_B70 = 212;
    public static final int U_CAR_D28_D1_B70 = 213;
    public static final int U_CAR_DISCBOX_NUM = 194;
    public static final int U_CAR_DISCBOX_PLAYTIME_M = 197;
    public static final int U_CAR_DISCBOX_PLAYTIME_S = 198;
    public static final int U_CAR_DISCBOX_RANDOM = 201;
    public static final int U_CAR_DISCBOX_REPEAT = 199;
    public static final int U_CAR_DISCBOX_SCAN = 200;
    public static final int U_CAR_DISCBOX_TRACK = 195;
    public static final int U_CAR_DISCBOX_TRACK_TOTAL = 196;
    public static final int U_CAR_SOURCE_ID = 184;
    public static final int U_CNT_MAX = 214;
    public static final int U_ECOMIC_MODE = 174;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 173;
    public static final int U_MEM_SPEED1 = 179;
    public static final int U_MEM_SPEED2 = 180;
    public static final int U_MEM_SPEED3 = 181;
    public static final int U_MEM_SPEED4 = 182;
    public static final int U_MEM_SPEED5 = 183;
    public static final int U_MEM_SPEED_ONOFF = 176;
    public static final int U_MEM_SPEED_SELECT = 177;
    public static final int U_MEM_SPEED_SHOW = 178;
    public static String RadioText = "";
    public static int mSum = -1;
    public static int mCurrPage = -1;
    public static String mCarId = null;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 214; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0118_XP1_BiaoZhi2008(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 214) {
            if (updateCode == 161) {
                if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(mCarId, strs[0])) {
                    mCarId = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            if (updateCode == 150) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[150];
                if (value == 1 && !BZ408OilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi");
                    return;
                }
                return;
            }
            if (updateCode == 178) {
                if (ints != null) {
                    if (ints[0] == 1 && !PsaC4L_MemSpeedSetActi.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedSetActi");
                        return;
                    } else {
                        if (ints[0] == 0 && PsaC4L_MemSpeedSetActi.mIsFront && PsaC4L_MemSpeedSetActi.mInstance != null) {
                            PsaC4L_MemSpeedSetActi.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (updateCode == 202) {
                if (strs != null && strs.length > 0) {
                    RadioText = strs[0];
                } else {
                    RadioText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
