package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0255_rzc_xp1_fengshenax7;
import com.syu.ui.door.DoorHelper;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0255_RZC_XP1_FengShenAX7 extends CallbackCanbusBase {
    public static int[][] LIST_EX1_EN = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 31, 10);
    public static final int U_CARSET_BEGIN = 102;
    public static final int U_CARSET_BLIND_PORT = 100;
    public static final int U_CARSET_D29_D0_B0 = 109;
    public static final int U_CARSET_D29_D0_B1 = 108;
    public static final int U_CARSET_D29_D0_B2 = 107;
    public static final int U_CARSET_D29_D0_B3 = 106;
    public static final int U_CARSET_D29_D0_B4 = 105;
    public static final int U_CARSET_D29_D0_B5 = 104;
    public static final int U_CARSET_D29_D0_B76 = 103;
    public static final int U_CARSET_D29_D1_B3 = 114;
    public static final int U_CARSET_D29_D1_B4 = 113;
    public static final int U_CARSET_D29_D1_B5 = 112;
    public static final int U_CARSET_D29_D1_B6 = 111;
    public static final int U_CARSET_D29_D1_B7 = 110;
    public static final int U_CARSET_D29_D2_B1 = 121;
    public static final int U_CARSET_D29_D2_B2 = 120;
    public static final int U_CARSET_D29_D2_B3 = 119;
    public static final int U_CARSET_D29_D2_B4 = 118;
    public static final int U_CARSET_D29_D2_B5 = 117;
    public static final int U_CARSET_D29_D2_B6 = 116;
    public static final int U_CARSET_D29_D2_B7 = 115;
    public static final int U_CARSET_D29_D3_B30 = 123;
    public static final int U_CARSET_D29_D3_B74 = 122;
    public static final int U_CARSET_D29_D4_B30 = 126;
    public static final int U_CARSET_D29_D4_B4 = 125;
    public static final int U_CARSET_D29_D4_B75 = 124;
    public static final int U_CARSET_D29_D5_B74 = 127;
    public static final int U_CARSET_D29_D6_B1 = 142;
    public static final int U_CARSET_D29_D6_B42 = 131;
    public static final int U_CARSET_D29_D6_B5 = 130;
    public static final int U_CARSET_D29_D6_B6 = 129;
    public static final int U_CARSET_D29_D6_B7 = 128;
    public static final int U_CARSET_D29_D7_B3 = 135;
    public static final int U_CARSET_D29_D7_B4 = 134;
    public static final int U_CARSET_D29_D7_B5 = 133;
    public static final int U_CARSET_D29_D7_B76 = 132;
    public static final int U_CARSET_D29_D8_B10 = 138;
    public static final int U_CARSET_D29_D8_B42 = 137;
    public static final int U_CARSET_D29_D8_B75 = 136;
    public static final int U_CARSET_D29_D9_B5 = 141;
    public static final int U_CARSET_D29_D9_B6 = 140;
    public static final int U_CARSET_D29_D9_B7 = 139;
    public static final int U_CARSET_D40_D0_B70 = 143;
    public static final int U_CARSET_D40_D1_B70 = 144;
    public static final int U_CARSET_D40_D2_D3 = 145;
    public static final int U_CARSET_D40_D4_D5 = 146;
    public static final int U_CARSET_D40_D6_B70 = 147;
    public static final int U_CARSET_D40_D7_B70 = 148;
    public static final int U_CARSET_D40_D8_D9 = 149;
    public static final int U_CARSET_D41_N0_ALL = 150;
    public static final int U_CARSET_MODE = 101;
    public static final int U_CARSET_TRUNAUTO_RCAM = 99;
    public static final int U_CNT_MAX = 151;
    public static final int U_CUR_SPEED = 94;
    public static final int U_CUR_SPEED_NOTIFFTIME = 96;
    public static final int U_ENGINE_SPEED = 95;
    public static final int U_ENGINE_SPEED_NOTIFFTIME = 97;
    public static final int U_TURN_CAM_STATUS = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0255_rzc_xp1_fengshenax7(TheApp.getInstance()));
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode == 150) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            for (int i = 0; i < 10; i++) {
                LIST_EX1_EN[ints[0]][i] = ints[i + 1];
            }
            return;
        }
        if (updateCode >= 0 && updateCode < 151) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
