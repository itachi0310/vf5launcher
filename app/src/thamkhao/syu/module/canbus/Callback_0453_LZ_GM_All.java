package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_GM_All extends CallbackCanbusBase {
    public static final int U_CARSET_D35_D10_B70 = 119;
    public static final int U_CARSET_D35_D11_B6 = 121;
    public static final int U_CARSET_D35_D11_B7 = 120;
    public static final int U_CARSET_D35_D2_D3 = 117;
    public static final int U_CARSET_D35_D7_D8_D9 = 118;
    public static final int U_CARSET_D36_D0_D1 = 122;
    public static final int U_CARSET_D36_D2_B70 = 123;
    public static final int U_CARSET_D36_D3_B70 = 124;
    public static final int U_CARSET_D36_D4_B70 = 125;
    public static final int U_CARSET_D38_D0_B0 = 94;
    public static final int U_CARSET_D38_D0_B1 = 95;
    public static final int U_CARSET_D38_D0_B32 = 96;
    public static final int U_CARSET_D38_D0_B54 = 97;
    public static final int U_CARSET_D38_D0_B76 = 98;
    public static final int U_CARSET_D38_D1_B10 = 99;
    public static final int U_CARSET_D38_D1_B3 = 100;
    public static final int U_CARSET_D38_D2_B0 = 101;
    public static final int U_CARSET_D38_D2_B21 = 102;
    public static final int U_CARSET_D38_D2_B3 = 103;
    public static final int U_CARSET_D38_D2_B4 = 104;
    public static final int U_CARSET_D38_D2_B65 = 105;
    public static final int U_CARSET_D38_D2_B7 = 106;
    public static final int U_CARSET_D38_D3_B0 = 107;
    public static final int U_CARSET_D38_D3_B1 = 108;
    public static final int U_CARSET_D38_D3_B2 = 109;
    public static final int U_CARSET_D38_D3_B3 = 110;
    public static final int U_CARSET_D38_D3_B4 = 111;
    public static final int U_CARSET_D38_D3_B65 = 112;
    public static final int U_CARSET_D38_D3_B7 = 113;
    public static final int U_CARSET_D38_D4_B70 = 114;
    public static final int U_CARSET_D38_D5_B70 = 115;
    public static final int U_CARSET_D39_D0_B70 = 116;
    public static final int U_CNT_MAX = 126;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
