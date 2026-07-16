package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0022_XP1_Focus2012;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0022_XP1_Focus2012 extends CallbackCanbusBase {
    public static final int U_AUTO_REQUEST = 106;
    public static final int U_BT_STATE = 99;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_END = 108;
    public static final int U_CARSET_BRIGHTNESS = 114;
    public static final int U_CARSET_D24_D1_B6 = 121;
    public static final int U_CARSET_D24_D1_B7 = 122;
    public static final int U_CARSET_D24_D3_B20 = 124;
    public static final int U_CARSET_D24_D3_B53 = 123;
    public static final int U_CARSET_D24_D5_B2 = 125;
    public static final int U_CARSET_D24_D5_B3 = 126;
    public static final int U_CARSET_D24_D5_B5 = 127;
    public static final int U_CARSET_D24_D5_B6 = 128;
    public static final int U_CARSET_D27_B70 = 129;
    public static final int U_CARSET_INFORMATION = 112;
    public static final int U_CARSET_INTERIORLIGHTING = 118;
    public static final int U_CARSET_RAINSENSOR = 120;
    public static final int U_CARSET_TOWSYSTEM = 111;
    public static final int U_CARSET_TURNLIGHT = 117;
    public static final int U_CARSET_TYREMONITOR = 119;
    public static final int U_CARSET_UNIT = 115;
    public static final int U_CARSET_VOICEMODE = 116;
    public static final int U_CARSET_WARNING = 113;
    public static final int U_CAR_ENGINE_SPEED = 110;
    public static final int U_CAR_SPEED = 109;
    public static final int U_CAR_WARN = 107;
    public static final int U_CNT_MAX = 130;
    public static final int U_CUR_WORK_MODE = 103;
    public static final int U_DISPLAY_MODE = 98;
    public static final int U_LINE_GROUP = 96;
    public static final int U_LIST_INFO = 101;
    public static final int U_MODE_STATE = 104;
    public static final int U_PARM_WARM = 100;
    public static final int U_PHONE_STATE = 105;
    public static final int U_PHONE_TIME = 102;
    public static final int U_PLAY_TIME = 97;
    public static final int U_SCREEN_ICON = 95;
    public static final int U_SCREEN_ID = 94;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 130; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0022_XP1_Focus2012(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 37; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 95 || updateCode == 96 || updateCode == 101 || updateCode == 107 || updateCode == 106) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        } else if (updateCode >= 0 && updateCode < 130) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
