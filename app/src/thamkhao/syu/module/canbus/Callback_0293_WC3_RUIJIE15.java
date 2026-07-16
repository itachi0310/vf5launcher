package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0293_WC3_15RuiJie;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0293_WC3_RUIJIE15 extends CallbackCanbusBase {
    public static final int U_AUDIO_CHANNEL_VALUE = 107;
    public static final int U_CARINFO_END = 104;
    public static final int U_CAR_BT_STATE = 98;
    public static final int U_CAR_CURRENT_SPEED = 94;
    public static final int U_CAR_WARN = 103;
    public static final int U_CNT_MAX = 108;
    public static final int U_CUR_SPEED = 105;
    public static final int U_DISPLAY_MODE = 97;
    public static final int U_DRIVING_TIME = 95;
    public static final int U_ENGINE_SPEED = 106;
    public static final int U_LINE_GROUP = 102;
    public static final int U_OPTIMAL_OIL_EXPEND = 96;
    public static final int U_PLAY_TIME = 99;
    public static final int U_SCREEN_ICON = 101;
    public static final int U_SCREEN_ID = 100;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0293_WC3_15RuiJie(TheApp.getInstance()));
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
        if (updateCode == 107) {
            DataCanbus.DATA[updateCode] = ints[0];
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        } else {
            if (updateCode == 103) {
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode >= 0 && updateCode < 108) {
                if (strs == null) {
                    HandlerCanbus.update(updateCode, ints);
                } else {
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                }
            }
        }
    }
}
