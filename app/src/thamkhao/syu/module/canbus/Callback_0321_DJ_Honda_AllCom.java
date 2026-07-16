package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.honda.Activity17CRVAirControl;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0192_WC2_15_BinZhi;
import com.syu.ui.air.Air_0321_WC2_17_guandao;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0321_DJ_Honda_AllCom extends CallbackCanbusBase {
    public static final int U_CARINFO_RIGHT_TURN_LIGHT_TIME = 142;
    public static final int U_CNT_MAX = 177;
    public static final int U_CUR_SPEED = 140;
    public static final int U_DJ_BEGIN = 158;
    public static final int U_DJ_CARSET_FUNC = 160;
    public static final int U_DJ_CARSET_STATUS = 161;
    public static final int U_DJ_END = 162;
    public static final int U_DJ_REMOTE_LOCK = 159;
    public static final int U_ENGINE_SPEED = 141;
    public static final int U_LANE_WATCH_DURTION = 151;
    public static final int U_LANE_WATCH_LIGHT = 150;
    public static final int U_MEMORY_POSITION_SEAT = 155;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    public static final int U_RADIO_AM_LIST_FREQ = 168;
    public static final int U_RADIO_AM_LIST_INFO = 169;
    public static final int U_RADIO_BAND = 163;
    public static final int U_RADIO_BEGIN = 163;
    public static final int U_RADIO_CHANNEL = 171;
    public static final int U_RADIO_CHANNEL_AMFREQ_PRESET = 164;
    public static final int U_RADIO_CHANNEL_AM_CNT = 173;
    public static final int U_RADIO_CHANNEL_FMFREQ_PRESET = 165;
    public static final int U_RADIO_CHANNEL_FM_CNT = 174;
    public static final int U_RADIO_END = 176;
    public static final int U_RADIO_FM_LIST_FREQ = 166;
    public static final int U_RADIO_FM_LIST_INFO = 167;
    public static final int U_RADIO_FREQ = 170;
    public static final int U_RADIO_LIGHT_ID = 175;
    public static final int U_RADIO_SEARCH_STATE = 172;
    public static final int U_REAR_VIEW_REMINDER = 152;
    public static final int U_RIGHT_CAREAR_STATE = 115;
    public static final int U_RISE_DRIVER_ATTENTION_MONITOR = 154;
    public static final int U_RISE_WARNING = 153;
    public static final int U_SEAT_BELT_MODE_SET = 156;
    public static final int U_SETTING_65D10 = 127;
    public static final int U_SETTING_65D11 = 126;
    public static final int U_SETTING_65D13 = 125;
    public static final int U_SETTING_65D14 = 145;
    public static final int U_SETTING_65D16 = 143;
    public static final int U_SETTING_66D10 = 124;
    public static final int U_SETTING_66D11 = 123;
    public static final int U_SETTING_66D12 = 122;
    public static final int U_SETTING_66D13 = 121;
    public static final int U_SETTING_67D00 = 117;
    public static final int U_SETTING_67D03 = 116;
    public static final int U_SETTING_67D10 = 120;
    public static final int U_SETTING_67D12 = 119;
    public static final int U_SETTING_67D14 = 118;
    public static final int U_SETTING_68D10 = 131;
    public static final int U_SETTING_68D12 = 130;
    public static final int U_SETTING_68D13 = 129;
    public static final int U_SETTING_68D14 = 128;
    public static final int U_SETTING_69D00 = 136;
    public static final int U_SETTING_69D02 = 135;
    public static final int U_SETTING_69D03 = 134;
    public static final int U_SETTING_69D04 = 133;
    public static final int U_SETTING_69D05 = 132;
    public static final int U_SETTING_69D06 = 145;
    public static final int U_SETTING_69D10 = 139;
    public static final int U_SETTING_69D13 = 138;
    public static final int U_SETTING_69D15 = 137;
    public static final int U_SETTING_75D10 = 146;
    public static final int U_SETTING_75D11 = 147;
    public static final int U_SETTING_A6D60 = 149;
    public static final int U_SETTING_A6D61 = 148;
    public static final int U_SWITCH_LOCK = 157;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 114;
    int carId;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 177; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        this.carId = (DataCanbus.DATA[1000] >> 16) & 255;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (this.carId == 5 || this.carId == 6) {
            AirHelper.getInstance().buildUi(new Air_0321_WC2_17_guandao(TheApp.getInstance()));
            for (int i2 = 10; i2 < 93; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0192_WC2_15_BinZhi(TheApp.getInstance()));
            for (int i3 = 10; i3 < 93; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 0; i4 < 6; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
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
            case 64:
                if (this.carId == 7 || this.carId == 8 || this.carId == 9) {
                    if (ints[0] == 1 && !Activity17CRVAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.Activity17CRVAirControl");
                        break;
                    } else if (ints[0] == 1 && Activity17CRVAirControl.mIsFront && Activity17CRVAirControl.mInstance != null) {
                        Activity17CRVAirControl.mInstance.finish();
                        break;
                    }
                } else if (ints[0] == 1 && !ActivityAirControl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
                    break;
                } else if (ints[0] == 1 && ActivityAirControl.mIsFront && ActivityAirControl.mInstance != null) {
                    ActivityAirControl.mInstance.finish();
                    break;
                }
                break;
            default:
                if (updateCode >= 0 && updateCode < 177) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }
}
