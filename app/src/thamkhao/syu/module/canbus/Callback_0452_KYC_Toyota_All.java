package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_kyc_toyota_all;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_KYC_Toyota_All extends CallbackCanbusBase {
    public static final int U_CARCD_CURTIME_HOUR = 162;
    public static final int U_CARCD_CURTIME_MIN = 161;
    public static final int U_CARCD_CURTIME_SEC = 160;
    public static final int U_CARCD_CURTRACK = 156;
    public static final int U_CARCD_DISC1 = 127;
    public static final int U_CARCD_DISC2 = 128;
    public static final int U_CARCD_DISC3 = 129;
    public static final int U_CARCD_DISC4 = 130;
    public static final int U_CARCD_DISC5 = 131;
    public static final int U_CARCD_DISC6 = 132;
    public static final int U_CARCD_NUM = 134;
    public static final int U_CARCD_RANDOM = 154;
    public static final int U_CARCD_REPEAT = 153;
    public static final int U_CARCD_SCAN = 163;
    public static final int U_CARCD_STATE = 133;
    public static final int U_CARCD_TOTALTIME_HOUR = 159;
    public static final int U_CARCD_TOTALTIME_MIN = 158;
    public static final int U_CARCD_TOTALTIME_SEC = 157;
    public static final int U_CARCD_TOTALTRACK = 155;
    public static final int U_CARCD_WORKSTATE = 135;
    public static final int U_CARRADIO_BAND = 136;
    public static final int U_CARRADIO_CHNEL = 137;
    public static final int U_CARRADIO_FRQ = 140;
    public static final int U_CARRADIO_FRQ1 = 141;
    public static final int U_CARRADIO_FRQ10 = 150;
    public static final int U_CARRADIO_FRQ11 = 151;
    public static final int U_CARRADIO_FRQ12 = 152;
    public static final int U_CARRADIO_FRQ2 = 142;
    public static final int U_CARRADIO_FRQ3 = 143;
    public static final int U_CARRADIO_FRQ4 = 144;
    public static final int U_CARRADIO_FRQ5 = 145;
    public static final int U_CARRADIO_FRQ6 = 146;
    public static final int U_CARRADIO_FRQ7 = 147;
    public static final int U_CARRADIO_FRQ8 = 148;
    public static final int U_CARRADIO_FRQ9 = 149;
    public static final int U_CARRADIO_SCAN = 138;
    public static final int U_CARRADIO_ST = 139;
    public static final int U_CARSET_D26_D0_B10 = 97;
    public static final int U_CARSET_D26_D0_B32 = 96;
    public static final int U_CARSET_D26_D0_B64 = 95;
    public static final int U_CARSET_D26_D0_B7 = 94;
    public static final int U_CARSET_D26_D1_B20 = 102;
    public static final int U_CARSET_D26_D1_B4 = 101;
    public static final int U_CARSET_D26_D1_B5 = 100;
    public static final int U_CARSET_D26_D1_B6 = 99;
    public static final int U_CARSET_D26_D1_B7 = 98;
    public static final int U_CARSET_D26_D2_B20 = 108;
    public static final int U_CARSET_D26_D2_B3 = 107;
    public static final int U_CARSET_D26_D2_B4 = 106;
    public static final int U_CARSET_D26_D2_B5 = 105;
    public static final int U_CARSET_D26_D2_B6 = 104;
    public static final int U_CARSET_D26_D2_B7 = 103;
    public static final int U_CARSET_D26_D3_B10 = 111;
    public static final int U_CARSET_D26_D3_B6 = 110;
    public static final int U_CARSET_D26_D3_B7 = 109;
    public static final int U_CARSET_D26_D5_B30 = 113;
    public static final int U_CARSET_D26_D5_B54 = 112;
    public static final int U_CARSET_D26_D6_B75 = 114;
    public static final int U_CARSET_D31_D0_B30 = 116;
    public static final int U_CARSET_D31_D0_B74 = 115;
    public static final int U_CARSET_D31_D1_B30 = 118;
    public static final int U_CARSET_D31_D1_B74 = 117;
    public static final int U_CARSET_D31_D2_B30 = 120;
    public static final int U_CARSET_D31_D2_B74 = 119;
    public static final int U_CARSET_D31_D3_B70 = 121;
    public static final int U_CARSET_D31_D4_B0 = 122;
    public static final int U_CARSET_D31_D4_B32 = 164;
    public static final int U_CARSET_D32_D0_B0 = 124;
    public static final int U_CARSET_D32_D0_B6 = 166;
    public static final int U_CARSET_D32_D0_B7 = 165;
    public static final int U_CARSET_D34_D0_D1_D2 = 123;
    public static final int U_CNT_MAX = 167;
    public static final int U_REAR_SCREEN_POWER = 125;
    public static final int U_REAR_SYS_LOCK = 126;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 167; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_kyc_toyota_all(TheApp.getInstance()));
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
