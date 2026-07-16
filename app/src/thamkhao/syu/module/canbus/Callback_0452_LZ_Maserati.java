package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Maserati;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_LZ_Maserati extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_D35_D0_B70 = 95;
    public static final int U_CARINF_D35_D1_B70 = 96;
    public static final int U_CARINF_D35_D2_D3 = 97;
    public static final int U_CARINF_D35_D4_D5 = 98;
    public static final int U_CARINF_D35_D7_D8_D9_D10 = 99;
    public static final int U_CARINF_D37_D0_B70 = 100;
    public static final int U_CARINF_D37_D10_D11 = 108;
    public static final int U_CARINF_D37_D12_D13 = 109;
    public static final int U_CARINF_D37_D1_B70 = 101;
    public static final int U_CARINF_D37_D2_B70 = 102;
    public static final int U_CARINF_D37_D3_D4 = 103;
    public static final int U_CARINF_D37_D5_D6 = 104;
    public static final int U_CARINF_D37_D7_B70 = 105;
    public static final int U_CARINF_D37_D8_B70 = 106;
    public static final int U_CARINF_D37_D9_B70 = 107;
    public static final int U_CARINF_D38_D0_B70 = 110;
    public static final int U_CARINF_D38_D1_B30 = 114;
    public static final int U_CARINF_D38_D1_B54 = 113;
    public static final int U_CARINF_D38_D1_B6 = 112;
    public static final int U_CARINF_D38_D1_B7 = 111;
    public static final int U_CARINF_D38_D2_B1 = 121;
    public static final int U_CARINF_D38_D2_B2 = 120;
    public static final int U_CARINF_D38_D2_B3 = 119;
    public static final int U_CARINF_D38_D2_B4 = 118;
    public static final int U_CARINF_D38_D2_B5 = 117;
    public static final int U_CARINF_D38_D2_B6 = 116;
    public static final int U_CARINF_D38_D2_B7 = 115;
    public static final int U_CARINF_D38_D3_B30 = 122;
    public static final int U_CARINF_D38_D4_B70 = 123;
    public static final int U_CARINF_D39_D0_D1 = 124;
    public static final int U_CARINF_D39_D2_B70 = 125;
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Maserati(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
