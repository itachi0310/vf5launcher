package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_RZC_MahindraTata_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0454_RZC_MahindraTata_All extends CallbackCanbusBase {
    public static final int U_CARINF_D60_D0_B70 = 110;
    public static final int U_CARINF_D60_D11_D12 = 116;
    public static final int U_CARINF_D60_D13_D14 = 117;
    public static final int U_CARINF_D60_D15_D16 = 118;
    public static final int U_CARINF_D60_D1_B70 = 111;
    public static final int U_CARINF_D60_D2_D3 = 112;
    public static final int U_CARINF_D60_D4_D5 = 113;
    public static final int U_CARINF_D60_D6_D7 = 114;
    public static final int U_CARINF_D60_D8_B70 = 115;
    public static final int U_CARSET_D3F_D10_B70 = 102;
    public static final int U_CARSET_D3F_D11_B70 = 103;
    public static final int U_CARSET_D3F_D20_B70 = 104;
    public static final int U_CARSET_D3F_D21_B70 = 105;
    public static final int U_CARSET_D3F_D22_B70 = 106;
    public static final int U_CARSET_D3F_D30_B70 = 107;
    public static final int U_CARSET_D3F_D31_B70 = 108;
    public static final int U_CARSET_D3F_D32_B70 = 109;
    public static final int U_CNT_MAX = 119;
    public static final int U_TIRE_TEMP_FL = 98;
    public static final int U_TIRE_TEMP_FR = 99;
    public static final int U_TIRE_TEMP_RL = 100;
    public static final int U_TIRE_TEMP_RR = 101;
    public static final int U_TIRE_VALUE_FL = 94;
    public static final int U_TIRE_VALUE_FR = 95;
    public static final int U_TIRE_VALUE_RL = 96;
    public static final int U_TIRE_VALUE_RR = 97;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0454_RZC_MahindraTata_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
