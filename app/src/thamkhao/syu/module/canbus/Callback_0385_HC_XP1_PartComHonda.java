package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0385_HC_Accord8;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0385_HC_XP1_PartComHonda extends CallbackCanbusBase {
    public static String CdTextInfo = null;
    public static int CdTextType = 0;
    public static String CdUsbList = null;
    public static int CdUsbListType = 0;
    public static String MenuList = null;
    public static int MenuListType = 0;
    public static String TelTextInfo = null;
    public static int TelTextType = 0;
    public static final int U_CARCD_BEGIN = 94;
    public static final int U_CARCD_CDDISPLAY_STATE = 100;
    public static final int U_CARCD_CDTEXT_INFO = 103;
    public static final int U_CARCD_CDTEXT_TYPE = 102;
    public static final int U_CARCD_CDUSB_LIST1 = 105;
    public static final int U_CARCD_CDUSB_LIST2 = 106;
    public static final int U_CARCD_CDUSB_LIST3 = 107;
    public static final int U_CARCD_CDUSB_LIST_TYPE = 104;
    public static final int U_CARCD_DISC_INFO = 95;
    public static final int U_CARCD_END = 128;
    public static final int U_CARCD_FOLD_INFO = 101;
    public static final int U_CARCD_PLAY_MINUTE = 126;
    public static final int U_CARCD_PLAY_MODE = 98;
    public static final int U_CARCD_PLAY_SECOND = 127;
    public static final int U_CARCD_PLAY_TIME = 97;
    public static final int U_CARCD_TRACK_INFO = 96;
    public static final int U_CARCD_WORK_STATE = 99;
    public static final int U_CARRADIO_BEGIN = 129;
    public static final int U_CARRADIO_END = 135;
    public static final int U_CAR_DISC1_INFO = 108;
    public static final int U_CAR_DISC2_INFO = 109;
    public static final int U_CAR_DISC3_INFO = 110;
    public static final int U_CAR_DISC4_INFO = 111;
    public static final int U_CAR_DISC5_INFO = 112;
    public static final int U_CAR_DISC6_INFO = 113;
    public static final int U_CAR_MENULIST1_INFO = 115;
    public static final int U_CAR_MENULIST2_INFO = 116;
    public static final int U_CAR_MENULIST3_INFO = 117;
    public static final int U_CAR_MENULIST_TYPE = 114;
    public static final int U_CAR_TIME_FUNC = 118;
    public static final int U_CAR_TIME_HOUR = 119;
    public static final int U_CAR_TIME_MINUTE = 120;
    public static final int U_CNT_MAX = 135;
    public static final int U_CUR_BAND = 130;
    public static final int U_CUR_CHANNEL = 131;
    public static final int U_CUR_FREQ = 129;
    public static final int U_ICON_DISPLAY = 125;
    public static final int U_PRESET_CHANNEL = 133;
    public static final int U_RECEIVE_STATE = 134;
    public static final int U_SOURCE_STATE = 121;
    public static final int U_STATE_ST = 132;
    public static final int U_TEL_ENABLE = 123;
    public static final int U_TEL_PHONE = 122;
    public static final int U_VOL_VALUE = 124;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        for (int i = 0; i < 135; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0385_HC_Accord8(TheApp.getInstance()));
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 103:
                if (ints != null && ints.length >= 1) {
                    CdTextType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    CdTextInfo = strs[0];
                } else {
                    CdTextInfo = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 105:
                if (ints != null && ints.length >= 1) {
                    CdUsbListType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    CdUsbList = strs[0];
                } else {
                    CdUsbList = "";
                }
                Log.i("canbus", "Callback_CdUsbListType=" + CdUsbListType + "CdUsbList=" + CdUsbList);
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 115:
                if (ints != null && ints.length >= 1) {
                    MenuListType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    MenuList = strs[0];
                } else {
                    MenuList = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 122:
                if (ints != null && ints.length >= 1) {
                    TelTextType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    TelTextInfo = strs[0];
                } else {
                    TelTextInfo = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            default:
                if (updateCode >= 0 && updateCode < 135) {
                    Log.i("canbus", "updateCode" + updateCode);
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }
}
