package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0307_XBS_15ZhongHuaV3;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0307_XBS_XP1_15ZhongHuaV3 extends CallbackCanbusBase {
    public static final int C_CMD_CARINFO = 0;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 96;
    public static final int U_CARINFO_AUTO_DOOR_RELOCK = 97;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 95;
    public static final int U_CARINFO_BACKCAR_MUTE_INHIBITION = 103;
    public static final int U_CARINFO_BACK_CAMERA = 102;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_D4_D03_B54 = 106;
    public static final int U_CARINFO_D4_D03_B6 = 105;
    public static final int U_CARINFO_D4_D03_B7 = 104;
    public static final int U_CARINFO_D4_D04_B32 = 111;
    public static final int U_CARINFO_D4_D04_B64 = 110;
    public static final int U_CARINFO_D4_D04_B7 = 107;
    public static final int U_CARINFO_D4_D05_B70 = 108;
    public static final int U_CARINFO_D4_D06_B70 = 109;
    public static final int U_CARINFO_LOCK_FLASH = 99;
    public static final int U_CARINFO_ONE_DOOR_UNLOCK = 98;
    public static final int U_CARINFO_REAR_MIRROR_AUTO_FOLD = 101;
    public static final int U_CARINFO_UNLOCK_FLASH = 100;
    public static final int U_CNT_MAX = 112;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0307_XBS_15ZhongHuaV3(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
