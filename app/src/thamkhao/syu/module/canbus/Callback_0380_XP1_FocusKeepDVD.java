package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.carinfo.xp.ylford.YLFordCarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0380_XP1_Focus2012;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0380_XP1_FocusKeepDVD extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AUTO_REQUEST = 106;
    public static final int U_BT_STATE = 99;
    public static final int U_CARCDINFO_STR = 114;
    public static final int U_CARCDMODE = 109;
    public static final int U_CARCDPLAYMODE = 111;
    public static final int U_CARCDPLAYTIME = 113;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_END = 108;
    public static final int U_CARSET_BRIGHTNESS = 120;
    public static final int U_CARSET_INFORMATION = 118;
    public static final int U_CARSET_INTERIORLIGHTING = 124;
    public static final int U_CARSET_RAINSENSOR = 126;
    public static final int U_CARSET_TOWSYSTEM = 117;
    public static final int U_CARSET_TURNLIGHT = 123;
    public static final int U_CARSET_TYREMONITOR = 125;
    public static final int U_CARSET_UNIT = 121;
    public static final int U_CARSET_VOICEMODE = 122;
    public static final int U_CARSET_WARNING = 119;
    public static final int U_CAR_TRACK_INFO = 112;
    public static final int U_CAR_WARN = 107;
    public static final int U_CNT_MAX = 127;
    public static final int U_CUR_WORK_MODE = 103;
    public static final int U_DISPLAY_MODE = 98;
    public static final int U_JUMPCD = 116;
    public static final int U_JUMPSYNC = 115;
    public static final int U_LINE_GROUP = 96;
    public static final int U_LIST_INFO = 101;
    public static final int U_MODE_STATE = 104;
    public static final int U_PARM_WARM = 100;
    public static final int U_PHONE_STATE = 105;
    public static final int U_PHONE_TIME = 102;
    public static final int U_PLAY_TIME = 97;
    public static final int U_SCREEN_ICON = 95;
    public static final int U_SCREEN_ID = 94;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.sUcDoorEngine = 0;
        AirHelper.getInstance().buildUi(new Air_0380_XP1_Focus2012(TheApp.getInstance()));
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
        if (updateCode == 95 || updateCode == 96 || updateCode == 101 || updateCode == 107 || updateCode == 106) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 114) {
            if (ints != null && ints.length >= 2) {
                infoType = ints[0];
                infoIndex = ints[1];
            }
            if (strs != null && strs.length > 0) {
                Songname = strs[0];
            } else {
                Songname = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            return;
        }
        if (updateCode == 116) {
            if (!YLFordCarCD.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ylford.YLFordCarCD");
            }
        } else if (updateCode == 115) {
            if (!FocusSyncBtActi.isFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.focus.FocusSyncBtActi");
            }
        } else if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
