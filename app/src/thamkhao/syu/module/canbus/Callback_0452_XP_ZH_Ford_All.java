package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_XP_ZH_Ford_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_XP_ZH_Ford_All extends CallbackCanbusBase {
    public static final int U_AUTO_REQUEST = 103;
    public static final int U_BT_STATE = 110;
    public static final int U_CARSET_D25_D0_B2 = 95;
    public static final int U_CARSET_D25_D0_B3 = 96;
    public static final int U_CARSET_D27_D0_B70 = 132;
    public static final int U_CARSET_D48_D0_B30 = 113;
    public static final int U_CARSET_D48_D1_B30 = 116;
    public static final int U_CARSET_D48_D1_B54 = 115;
    public static final int U_CARSET_D48_D1_B76 = 114;
    public static final int U_CARSET_D48_D2_B30 = 118;
    public static final int U_CARSET_D48_D2_B74 = 117;
    public static final int U_CARSET_D48_D3_B30 = 121;
    public static final int U_CARSET_D48_D3_B54 = 120;
    public static final int U_CARSET_D48_D3_B76 = 119;
    public static final int U_CARSET_D48_D4_B30 = 123;
    public static final int U_CARSET_D48_D4_B74 = 122;
    public static final int U_CARSET_D48_D5_B30 = 125;
    public static final int U_CARSET_D48_D5_B74 = 124;
    public static final int U_CARSET_D48_D6_B30 = 126;
    public static final int U_CARSET_D48_D7_B30 = 128;
    public static final int U_CARSET_D48_D7_B74 = 127;
    public static final int U_CARSET_D48_D8_B0 = 130;
    public static final int U_CARSET_D48_D8_B76 = 129;
    public static final int U_CARSET_D48_D9_B70 = 131;
    public static final int U_CARSET_MILE_UNIT = 94;
    public static final int U_CARSET_SEAT_SET_TYPE = 133;
    public static final int U_CAR_ENGINE_SPEED = 112;
    public static final int U_CAR_SPEED = 111;
    public static final int U_CAR_WARN = 104;
    public static final int U_CNT_MAX = 134;
    public static final int U_CUR_WORK_MODE = 100;
    public static final int U_DISPLAY_MODE = 109;
    public static final int U_LINE_GROUP = 107;
    public static final int U_LIST_INFO = 98;
    public static final int U_MODE_STATE = 101;
    public static final int U_PARM_WARM = 97;
    public static final int U_PHONE_STATE = 102;
    public static final int U_PHONE_TIME = 99;
    public static final int U_PLAY_TIME = 108;
    public static final int U_SCREEN_ICON = 106;
    public static final int U_SCREEN_ID = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 134; i++) {
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
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().buildUi(new Air_0452_XP_ZH_Ford_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 134) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
