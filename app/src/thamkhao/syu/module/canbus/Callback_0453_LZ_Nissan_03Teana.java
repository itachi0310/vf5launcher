package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Nissan_03Teana;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_Nissan_03Teana extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D10_B6 = 102;
    public static final int U_CARINF_D35_D10_B7 = 101;
    public static final int U_CARINF_D35_D1_B70 = 98;
    public static final int U_CARINF_D35_D2_D3 = 99;
    public static final int U_CARINF_D35_D7_D8_D9 = 100;
    public static final int U_CARINF_D37_D0_D1 = 94;
    public static final int U_CARINF_D37_D2_D3 = 95;
    public static final int U_CARINF_D37_D4_D5_D6 = 96;
    public static final int U_CARINF_D37_D7_D8 = 97;
    public static final int U_CARINF_D39_D0_B0 = 112;
    public static final int U_CARINF_D39_D0_B1 = 111;
    public static final int U_CARINF_D39_D0_B2 = 110;
    public static final int U_CARINF_D39_D0_B3 = 109;
    public static final int U_CARINF_D39_D0_B4 = 108;
    public static final int U_CARINF_D39_D0_B5 = 107;
    public static final int U_CARINF_D39_D1_B30 = 114;
    public static final int U_CARINF_D39_D1_B74 = 113;
    public static final int U_CARINF_D39_D2_B30 = 116;
    public static final int U_CARINF_D39_D2_B74 = 115;
    public static final int U_CARINF_D39_D3_B70 = 117;
    public static final int U_CARINF_D39_D4_B70 = 118;
    public static final int U_CARINF_D39_D5_B70 = 119;
    public static final int U_CNT_MAX = 120;
    public static final int U_TIRE_VALUE_FL = 103;
    public static final int U_TIRE_VALUE_FR = 104;
    public static final int U_TIRE_VALUE_RL = 105;
    public static final int U_TIRE_VALUE_RR = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_LZ_Nissan_03Teana(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
