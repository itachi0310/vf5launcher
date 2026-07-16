package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0190_RZC_TianLai;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0190_RZC_XP1_TianLai extends CallbackCanbusBase {
    public static String CarCdText = "";
    public static String CarRadioText = "";
    public static final int U_CAREQ_D92_D0_B70 = 159;
    public static final int U_CAREQ_D92_D1_B70 = 160;
    public static final int U_CAREQ_D92_D2_B70 = 161;
    public static final int U_CAREQ_D92_D3_B70 = 162;
    public static final int U_CAREQ_D92_D4_B70 = 163;
    public static final int U_CAREQ_D92_D5_B70 = 164;
    public static final int U_CAREQ_D92_D6_B70 = 165;
    public static final int U_CAREQ_D92_D7_B70 = 166;
    public static final int U_CAREQ_D93_D0_B70 = 143;
    public static final int U_CAREQ_D93_D1_B70 = 144;
    public static final int U_CAREQ_D93_D2_B70 = 145;
    public static final int U_CAREQ_D93_D3_B70 = 146;
    public static final int U_CAREQ_D93_D4_B70 = 147;
    public static final int U_CAREQ_D93_D5_B70 = 148;
    public static final int U_CAREQ_D93_D6_B70 = 149;
    public static final int U_CAREQ_D93_D7_B70 = 150;
    public static final int U_CAREQ_D93_D8_B70 = 151;
    public static final int U_CAREQ_D95_D0_B5 = 154;
    public static final int U_CAREQ_D95_D0_B6 = 153;
    public static final int U_CAREQ_D95_D0_B7 = 152;
    public static final int U_CAREQ_D95_D1_B30 = 170;
    public static final int U_CAREQ_D95_D1_B4 = 169;
    public static final int U_CAREQ_D95_D1_B65 = 168;
    public static final int U_CAREQ_D95_D1_B7 = 167;
    public static final int U_CAREQ_D95_D2_B5 = 173;
    public static final int U_CAREQ_D95_D2_B6 = 172;
    public static final int U_CAREQ_D95_D2_B7 = 171;
    public static final int U_CAREQ_D95_D3_B5 = 176;
    public static final int U_CAREQ_D95_D3_B6 = 175;
    public static final int U_CAREQ_D95_D3_B7 = 174;
    public static final int U_CAREQ_D95_D4_B3 = 182;
    public static final int U_CAREQ_D95_D4_B4 = 181;
    public static final int U_CAREQ_D95_D4_B65 = 180;
    public static final int U_CAREQ_D95_D4_B7 = 179;
    public static final int U_CARINF_D27_D0_B0 = 156;
    public static final int U_CARINF_D27_D0_B1 = 155;
    public static final int U_CARINF_D27_D1_D2_D3 = 157;
    public static final int U_CARINF_D27_D4_D5 = 158;
    public static final int U_CAR_CD_BEGIN = 112;
    public static final int U_CAR_CD_DISC1 = 120;
    public static final int U_CAR_CD_DISC2 = 121;
    public static final int U_CAR_CD_DISC3 = 122;
    public static final int U_CAR_CD_DISC4 = 123;
    public static final int U_CAR_CD_DISC5 = 124;
    public static final int U_CAR_CD_DISC6 = 125;
    public static final int U_CAR_CD_END = 132;
    public static final int U_CAR_CD_NUM = 126;
    public static final int U_CAR_CD_STATE = 113;
    public static final int U_CAR_CD_STATE_FOLD = 114;
    public static final int U_CAR_CD_STATE_MP3 = 116;
    public static final int U_CAR_CD_STATE_PLAY = 130;
    public static final int U_CAR_CD_STATE_SCAN = 117;
    public static final int U_CAR_CD_STATE_TXT = 118;
    public static final int U_CAR_CD_STATE_WMA = 115;
    public static final int U_CAR_CD_STATE_WORK = 119;
    public static final int U_CAR_CD_TEXT = 131;
    public static final int U_CAR_CD_TIME_M = 128;
    public static final int U_CAR_CD_TIME_S = 129;
    public static final int U_CAR_CD_TRACK = 127;
    public static final int U_CAR_EQ_BAL = 137;
    public static final int U_CAR_EQ_BAS = 134;
    public static final int U_CAR_EQ_BEEP = 138;
    public static final int U_CAR_EQ_BEGIN = 133;
    public static final int U_CAR_EQ_END = 140;
    public static final int U_CAR_EQ_FAD = 136;
    public static final int U_CAR_EQ_TREB = 135;
    public static final int U_CAR_EQ_VOL = 139;
    public static final int U_CAR_F_RADAR_SET = 177;
    public static final int U_CAR_MODE_STATE = 141;
    public static final int U_CAR_RADIO_BAND = 101;
    public static final int U_CAR_RADIO_BEGIN = 94;
    public static final int U_CAR_RADIO_END = 111;
    public static final int U_CAR_RADIO_FREQ = 103;
    public static final int U_CAR_RADIO_FREQ1 = 104;
    public static final int U_CAR_RADIO_FREQ2 = 105;
    public static final int U_CAR_RADIO_FREQ3 = 106;
    public static final int U_CAR_RADIO_FREQ4 = 107;
    public static final int U_CAR_RADIO_FREQ5 = 108;
    public static final int U_CAR_RADIO_FREQ6 = 109;
    public static final int U_CAR_RADIO_NUM = 102;
    public static final int U_CAR_RADIO_STATE = 95;
    public static final int U_CAR_RADIO_STATE_AUTO = 99;
    public static final int U_CAR_RADIO_STATE_RDS = 96;
    public static final int U_CAR_RADIO_STATE_SCAN = 97;
    public static final int U_CAR_RADIO_STATE_ST = 98;
    public static final int U_CAR_RADIO_STATE_TXT = 100;
    public static final int U_CAR_RADIO_TXT = 110;
    public static final int U_CAR_RIGHT_LIGHT_CAM = 142;
    public static final int U_CAR_R_RADAR_SET = 178;
    public static final int U_CNT_MAX = 183;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 183; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0190_RZC_TianLai(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 183) {
            switch (updateCode) {
                case 110:
                    if (strs != null && strs.length > 0) {
                        CarRadioText = strs[0];
                    } else {
                        CarRadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 131:
                    if (strs != null && strs.length > 0) {
                        CarCdText = strs[0];
                    } else {
                        CarCdText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 141:
                    if (ints[0] == 2 && !XBS09TianlaiCarCDAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct");
                        break;
                    } else if (ints[0] == 1 && !XBS09TianlaiCarRadioAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct");
                        break;
                    } else if (ints[0] == 3) {
                        if (XBS09TianlaiCarRadioAct.mIsFront && XBS09TianlaiCarRadioAct.mInstance != null) {
                            XBS09TianlaiCarRadioAct.mInstance.finish();
                        }
                        if (XBS09TianlaiCarCDAct.mIsFront && XBS09TianlaiCarCDAct.mInstance != null) {
                            XBS09TianlaiCarCDAct.mInstance.finish();
                            break;
                        }
                    }
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
