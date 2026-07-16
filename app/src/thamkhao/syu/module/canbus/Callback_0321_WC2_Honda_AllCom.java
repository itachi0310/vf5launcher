package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0321_WC2_17_guandao;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0321_WC2_Honda_AllCom extends CallbackCanbusBase {
    public static final int U_CARINFO_RIGHT_TURN_LIGHT_TIME = 142;
    public static final int U_CARINF_DE8_D6_B4 = 170;
    public static final int U_CARINF_DE8_D6_B5 = 169;
    public static final int U_CAR_BACK_GUID_AUTO = 164;
    public static final int U_CAR_BACK_GUID_STATIC = 165;
    public static final int U_CAR_BACK_SIDE = 162;
    public static final int U_CAR_BACK_VIEW = 163;
    public static final int U_CAR_INSTRUMENT_PANEL_CONFIG = 168;
    public static final int U_CAR_TURN_BY_TURN_DISPLAY = 166;
    public static final int U_CAR_WARNING_MESSAGE = 167;
    public static final int U_CNT_MAX = 178;
    public static final int U_CUR_SPEED = 140;
    public static final int U_DRIVED_TIME_H = 160;
    public static final int U_DRIVED_TIME_M = 161;
    public static final int U_ENGINE_SPEED = 141;
    public static final int U_LANE_WATCH_DURTION = 151;
    public static final int U_LANE_WATCH_LIGHT = 150;
    public static final int U_MEMORY_POSITION_SEAT = 155;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    public static final int U_PLAYER_MDI = 175;
    public static final int U_PLAYER_PROGRESS = 176;
    public static final int U_PLAYER_STATES = 177;
    public static final int U_PLAYER_TIME = 172;
    public static final int U_PLAYER_TOTAL_TRACK = 174;
    public static final int U_PLAYER_TRACK = 173;
    public static final int U_REAR_VIEW_REMINDER = 152;
    public static final int U_RIGHT_CAREAR_STATE = 115;
    public static final int U_RISE_DRIVER_ATTENTION_MONITOR = 154;
    public static final int U_RISE_WARNING = 153;
    public static final int U_SEAT_BELT_MODE_SET = 156;
    public static final int U_SETTING_65D10 = 127;
    public static final int U_SETTING_65D11 = 126;
    public static final int U_SETTING_65D13 = 125;
    public static final int U_SETTING_65D14 = 144;
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
    public static final int U_SETTING_68D031 = 158;
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
    public static final int U_SETTING_69D17 = 159;
    public static final int U_SETTING_75D10 = 146;
    public static final int U_SETTING_75D11 = 147;
    public static final int U_SETTING_A6D60 = 149;
    public static final int U_SETTING_A6D61 = 148;
    public static final int U_SWITCH_LOCK = 157;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 114;
    public static final int U_USB_TYPE = 171;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 178; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0321_WC2_17_guandao(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 178) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
