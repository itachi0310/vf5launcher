package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC_Jili_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Jili_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_D32_D6_B70 = 95;
    public static final int U_CARINF_D32_D7_B70 = 96;
    public static final int U_CARSET_D35_D2_B76 = 145;
    public static final int U_CARSET_D35_D4_B1 = 148;
    public static final int U_CARSET_D35_D4_B2 = 147;
    public static final int U_CARSET_D35_D4_B3 = 146;
    public static final int U_CARSET_D61_D0_B0 = 103;
    public static final int U_CARSET_D61_D0_B1 = 102;
    public static final int U_CARSET_D61_D0_B32 = 101;
    public static final int U_CARSET_D61_D0_B4 = 100;
    public static final int U_CARSET_D61_D0_B5 = 99;
    public static final int U_CARSET_D61_D0_B6 = 98;
    public static final int U_CARSET_D61_D0_B7 = 97;
    public static final int U_CARSET_D61_D1_B0 = 111;
    public static final int U_CARSET_D61_D1_B1 = 110;
    public static final int U_CARSET_D61_D1_B2 = 109;
    public static final int U_CARSET_D61_D1_B3 = 108;
    public static final int U_CARSET_D61_D1_B4 = 107;
    public static final int U_CARSET_D61_D1_B5 = 106;
    public static final int U_CARSET_D61_D1_B6 = 105;
    public static final int U_CARSET_D61_D1_B7 = 104;
    public static final int U_CARSET_D61_D2_B0 = 118;
    public static final int U_CARSET_D61_D2_B1 = 117;
    public static final int U_CARSET_D61_D2_B2 = 116;
    public static final int U_CARSET_D61_D2_B3 = 115;
    public static final int U_CARSET_D61_D2_B54 = 114;
    public static final int U_CARSET_D61_D2_B6 = 113;
    public static final int U_CARSET_D61_D2_B7 = 112;
    public static final int U_CARSET_D61_D3_B10 = 124;
    public static final int U_CARSET_D61_D3_B32 = 123;
    public static final int U_CARSET_D61_D3_B4 = 122;
    public static final int U_CARSET_D61_D3_B5 = 121;
    public static final int U_CARSET_D61_D3_B6 = 120;
    public static final int U_CARSET_D61_D3_B7 = 119;
    public static final int U_CARSET_D61_D4_B0 = 129;
    public static final int U_CARSET_D61_D4_B21 = 128;
    public static final int U_CARSET_D61_D4_B3 = 127;
    public static final int U_CARSET_D61_D4_B4 = 126;
    public static final int U_CARSET_D61_D4_B5 = 125;
    public static final int U_CARSET_D61_D5_B0 = 135;
    public static final int U_CARSET_D61_D5_B1 = 134;
    public static final int U_CARSET_D61_D5_B2 = 133;
    public static final int U_CARSET_D61_D5_B3 = 132;
    public static final int U_CARSET_D61_D5_B65 = 131;
    public static final int U_CARSET_D61_D5_B7 = 130;
    public static final int U_CARSET_D61_D6_B0 = 140;
    public static final int U_CARSET_D61_D6_B1 = 139;
    public static final int U_CARSET_D61_D6_B2 = 138;
    public static final int U_CARSET_D61_D6_B3 = 137;
    public static final int U_CARSET_D61_D6_B74 = 136;
    public static final int U_CARSET_D61_D7_B30 = 144;
    public static final int U_CARSET_D61_D7_B4 = 143;
    public static final int U_CARSET_D61_D7_B65 = 142;
    public static final int U_CARSET_D61_D7_B7 = 141;
    public static final int U_CNT_MAX = 149;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 149; i++) {
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
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC_Jili_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 149) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
