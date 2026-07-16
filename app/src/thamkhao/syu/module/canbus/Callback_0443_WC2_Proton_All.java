package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Proton_All;
import com.syu.ui.air.Air_0443_WC2_Proton_X90;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Proton_All extends CallbackCanbusBase {
    public static final int U_CARINF_D32_D6_B70 = 94;
    public static final int U_CARINF_D32_D7_B70 = 95;
    public static final int U_CARINF_D32_D8_D9 = 116;
    public static final int U_CARINF_D61_D0_B32 = 97;
    public static final int U_CARINF_D61_D0_B54 = 114;
    public static final int U_CARINF_D61_D0_B6 = 117;
    public static final int U_CARINF_D61_D0_B7 = 96;
    public static final int U_CARINF_D61_D1_B0 = 105;
    public static final int U_CARINF_D61_D1_B1 = 104;
    public static final int U_CARINF_D61_D1_B2 = 103;
    public static final int U_CARINF_D61_D1_B3 = 102;
    public static final int U_CARINF_D61_D1_B4 = 101;
    public static final int U_CARINF_D61_D1_B5 = 100;
    public static final int U_CARINF_D61_D1_B6 = 99;
    public static final int U_CARINF_D61_D1_B7 = 98;
    public static final int U_CARINF_D61_D2_B0 = 111;
    public static final int U_CARINF_D61_D2_B1 = 110;
    public static final int U_CARINF_D61_D2_B32 = 109;
    public static final int U_CARINF_D61_D2_B4 = 108;
    public static final int U_CARINF_D61_D2_B5 = 107;
    public static final int U_CARINF_D61_D2_B6 = 106;
    public static final int U_CARINF_D61_D2_B7 = 115;
    public static final int U_CARINF_D61_D3_B10 = 123;
    public static final int U_CARINF_D61_D3_B2 = 122;
    public static final int U_CARINF_D61_D3_B3 = 121;
    public static final int U_CARINF_D61_D3_B4 = 120;
    public static final int U_CARINF_D61_D3_B5 = 119;
    public static final int U_CARINF_D61_D3_B6 = 113;
    public static final int U_CARINF_D61_D3_B7 = 112;
    public static final int U_CARINF_D61_D4_B0 = 127;
    public static final int U_CARINF_D61_D4_B1 = 126;
    public static final int U_CARINF_D61_D4_B2 = 125;
    public static final int U_CARINF_D61_D4_B43 = 124;
    public static final int U_CARINF_D61_D4_B75 = 118;
    public static final int U_CARINF_D61_D5_B30 = 135;
    public static final int U_CARINF_D61_D5_B4 = 136;
    public static final int U_CARINF_D61_D5_B5 = 130;
    public static final int U_CARINF_D61_D5_B6 = 129;
    public static final int U_CARINF_D61_D5_B7 = 128;
    public static final int U_CARINF_D61_D6_B20 = 151;
    public static final int U_CARINF_D61_D6_B43 = 134;
    public static final int U_CARINF_D61_D6_B5 = 133;
    public static final int U_CARINF_D61_D6_B6 = 132;
    public static final int U_CARINF_D61_D6_B7 = 131;
    public static final int U_CARINF_D61_D7_B0 = 150;
    public static final int U_CARINF_D61_D7_B1 = 149;
    public static final int U_CARINF_D61_D7_B2 = 148;
    public static final int U_CARINF_D61_D7_B3 = 147;
    public static final int U_CARINF_D61_D7_B4 = 140;
    public static final int U_CARINF_D61_D7_B5 = 139;
    public static final int U_CARINF_D61_D7_B6 = 138;
    public static final int U_CARINF_D61_D7_B7 = 137;
    public static final int U_CARINF_D62_D0_B5 = 143;
    public static final int U_CARINF_D62_D0_B6 = 142;
    public static final int U_CARINF_D62_D0_B7 = 141;
    public static final int U_CARINF_D62_D1_B43 = 146;
    public static final int U_CARINF_D62_D1_B65 = 145;
    public static final int U_CARINF_D62_D1_B7 = 144;
    public static final int U_CNT_MAX = 152;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
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
        if (DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            AirHelper.getInstance().buildUi(new Air_0443_WC2_Proton_X90(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0443_WC2_Proton_All(TheApp.getInstance()));
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
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 152) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
