package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_Sanwu_Nissan_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0454_Sanwu_Nissan_All extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 118;
    public static final int U_SETTING_93D0 = 94;
    public static final int U_SETTING_93D1 = 95;
    public static final int U_SETTING_93D2 = 96;
    public static final int U_SETTING_93D3 = 97;
    public static final int U_SETTING_93D4 = 98;
    public static final int U_SETTING_93D5 = 99;
    public static final int U_SETTING_93D6 = 100;
    public static final int U_SETTING_93D7 = 101;
    public static final int U_SETTING_93D8 = 102;
    public static final int U_SETTING_D74_D0_B0 = 107;
    public static final int U_SETTING_D74_D0_B1 = 106;
    public static final int U_SETTING_D74_D0_B2 = 105;
    public static final int U_SETTING_D74_D0_B3 = 104;
    public static final int U_SETTING_D74_D0_B4 = 103;
    public static final int U_SETTING_D74_D1_B02 = 108;
    public static final int U_SETTING_D74_D1_B35 = 109;
    public static final int U_SETTING_D74_D1_B67 = 110;
    public static final int U_SETTING_D74_D2_B01 = 111;
    public static final int U_SETTING_D74_D2_B23 = 112;
    public static final int U_SETTING_D74_D2_B45 = 113;
    public static final int U_SETTING_D74_D2_B6 = 114;
    public static final int U_SETTING_D74_D3_B02 = 115;
    public static final int U_SETTING_D74_D3_B3 = 116;
    public static final int U_SETTING_TEMP_UNIT = 117;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0454_Sanwu_Nissan_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
