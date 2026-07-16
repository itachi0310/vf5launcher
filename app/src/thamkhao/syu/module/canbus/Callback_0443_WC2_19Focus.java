package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_19focus;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_19Focus extends CallbackCanbusBase {
    public static final int U_AIR_RADAR_BEEP = 106;
    public static final int U_CARINF_D61_D0_B0 = 118;
    public static final int U_CARINF_D61_D0_B4 = 117;
    public static final int U_CARINF_D61_D0_B5 = 116;
    public static final int U_CARINF_D62_D0_B0 = 108;
    public static final int U_CARINF_D62_D0_B21 = 107;
    public static final int U_CARINF_D62_D1_B70 = 109;
    public static final int U_CARINF_D62_D3_B70 = 110;
    public static final int U_CARINF_D67_D1_B0 = 111;
    public static final int U_CARINF_D67_D1_B1 = 112;
    public static final int U_CARINF_D67_D1_B3 = 113;
    public static final int U_CARINF_D67_D1_B4 = 114;
    public static final int U_CARINF_D85_D1_B0 = 119;
    public static final int U_CARINF_D85_D1_B21 = 120;
    public static final int U_CARINF_D85_D1_B3 = 121;
    public static final int U_CARINF_D85_D1_B4 = 122;
    public static final int U_CARINF_D85_D1_B5 = 123;
    public static final int U_CARINF_D94_D0_B70 = 115;
    public static final int U_CAR_EQ_BAL = 99;
    public static final int U_CAR_EQ_BASS = 101;
    public static final int U_CAR_EQ_FAD = 100;
    public static final int U_CAR_EQ_MID = 102;
    public static final int U_CAR_EQ_SPEED_VOL = 104;
    public static final int U_CAR_EQ_SURROUND = 105;
    public static final int U_CAR_EQ_TREB = 103;
    public static final int U_CAR_EQ_VOL = 98;
    public static final int U_CAR_SET_AMBIENT_LIGHT = 97;
    public static final int U_CAR_SET_BEGIN = 95;
    public static final int U_CAR_SET_MILE_UNIT = 96;
    public static final int U_CNT_MAX = 124;
    public static final int U_DRIVING_TIME = 94;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_19focus(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
