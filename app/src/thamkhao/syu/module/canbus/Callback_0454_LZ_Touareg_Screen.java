package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_LZ_Touareg_Screen;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0454_LZ_Touareg_Screen extends CallbackCanbusBase {
    public static final int U_CARSET_D35_D2_D3 = 105;
    public static final int U_CARSET_D35_D7_D10 = 106;
    public static final int U_CAR_ANDROID_UI_VOL = 110;
    public static final int U_CAR_AUDI_TYPE = 113;
    public static final int U_CAR_BELT_STATE = 98;
    public static final int U_CAR_CUR_SPEED = 101;
    public static final int U_CAR_D39_D0_B70 = 114;
    public static final int U_CAR_EN_SPEED = 103;
    public static final int U_CAR_FOOTBRAKE_STATE = 99;
    public static final int U_CAR_HANDBRAKE_STATE = 100;
    public static final int U_CAR_LIGHT_FAR = 95;
    public static final int U_CAR_LIGHT_LEFT = 96;
    public static final int U_CAR_LIGHT_NEAR = 94;
    public static final int U_CAR_LIGHT_RIGHT = 97;
    public static final int U_CAR_LVDS_MODE = 112;
    public static final int U_CAR_OIL_REMAINED = 102;
    public static final int U_CAR_SCREEN_H = 108;
    public static final int U_CAR_SCREEN_W = 107;
    public static final int U_CAR_TOTAL_MILE = 104;
    public static final int U_CAR_UI_VOL = 109;
    public static final int U_CAR_VOICE_ANDROID = 111;
    public static final int U_CNT_MAX = 115;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0454_LZ_Touareg_Screen(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 115) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
