package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_08_12Tianlai;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_08_12Tianlai extends CallbackCanbusBase {
    public static String CDText = null;
    public static String RadioText = null;
    public static final int U_CARCD_BEGIN = 115;
    public static final int U_CARCD_DISC1 = 123;
    public static final int U_CARCD_DISC1_TYPE = 129;
    public static final int U_CARCD_DISC2 = 122;
    public static final int U_CARCD_DISC2_TYPE = 128;
    public static final int U_CARCD_DISC3 = 121;
    public static final int U_CARCD_DISC3_TYPE = 127;
    public static final int U_CARCD_DISC4 = 120;
    public static final int U_CARCD_DISC4_TYPE = 126;
    public static final int U_CARCD_DISC5 = 119;
    public static final int U_CARCD_DISC5_TYPE = 125;
    public static final int U_CARCD_DISC6 = 118;
    public static final int U_CARCD_DISC6_TYPE = 124;
    public static final int U_CARCD_END = 139;
    public static final int U_CARCD_FLODER = 136;
    public static final int U_CARCD_NUM = 116;
    public static final int U_CARCD_PLAYSTATE = 137;
    public static final int U_CARCD_RANDOM = 135;
    public static final int U_CARCD_REPEAT = 134;
    public static final int U_CARCD_SCAN = 133;
    public static final int U_CARCD_TEXT = 138;
    public static final int U_CARCD_TIME_M = 131;
    public static final int U_CARCD_TIME_S = 132;
    public static final int U_CARCD_TRACK = 130;
    public static final int U_CARCD_TXT_SHOW = 117;
    public static final int U_CAREQ_BAL = 141;
    public static final int U_CAREQ_BASS = 143;
    public static final int U_CAREQ_BEEP = 145;
    public static final int U_CAREQ_BEGIN = 139;
    public static final int U_CAREQ_FAD = 142;
    public static final int U_CAREQ_TRE = 144;
    public static final int U_CAREQ_VOL = 140;
    public static final int U_CARRADIO_AUTOP = 112;
    public static final int U_CARRADIO_BAND = 95;
    public static final int U_CARRADIO_BEGIN = 94;
    public static final int U_CARRADIO_CH = 148;
    public static final int U_CARRADIO_END = 115;
    public static final int U_CARRADIO_FRQ = 96;
    public static final int U_CARRADIO_FRQ1 = 97;
    public static final int U_CARRADIO_FRQ10 = 106;
    public static final int U_CARRADIO_FRQ11 = 107;
    public static final int U_CARRADIO_FRQ12 = 108;
    public static final int U_CARRADIO_FRQ2 = 98;
    public static final int U_CARRADIO_FRQ3 = 99;
    public static final int U_CARRADIO_FRQ4 = 100;
    public static final int U_CARRADIO_FRQ5 = 101;
    public static final int U_CARRADIO_FRQ6 = 102;
    public static final int U_CARRADIO_FRQ7 = 103;
    public static final int U_CARRADIO_FRQ8 = 104;
    public static final int U_CARRADIO_FRQ9 = 105;
    public static final int U_CARRADIO_RDS = 109;
    public static final int U_CARRADIO_SCAN = 110;
    public static final int U_CARRADIO_ST = 111;
    public static final int U_CARRADIO_TXT_INFO = 114;
    public static final int U_CARRADIO_TXT_SHOW = 113;
    public static final int U_CAR_JUMP_CD = 147;
    public static final int U_CAR_JUMP_EQ = 146;
    public static final int U_CNT_MAX = 149;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 149; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_08_12Tianlai(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 147) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 1:
                    if (!WC08TianlaiCarRadioAct.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct");
                    }
                    break;
                case 2:
                    if (DataCanbus.DATA[116] == 15) {
                        if (!WC08TianlaiCarCDAct.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct");
                        }
                    } else if (!WC08TianlaiCar6Cd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd");
                    }
                    break;
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 149) {
            switch (updateCode) {
                case 114:
                    if (strs != null && strs.length > 0) {
                        RadioText = strs[0];
                    } else {
                        RadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 138:
                    if (strs != null && strs.length > 0) {
                        CDText = strs[0];
                    } else {
                        CDText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 147:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 149) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
