package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.luz.binli.BinliCarSet;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_LZ_Binli;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_LUZ_Binli extends CallbackCanbusBase {
    public static final int U_CARINFO_INTERIOR_ALARM = 146;
    public static final int U_CARINFO_LIGHT_DELAY = 145;
    public static final int U_CARINFO_MOVE_ALARM = 147;
    public static final int U_CARSET_BEGIN = 94;
    public static final int U_CARSET_CAR_LEV = 111;
    public static final int U_CARSET_CUR_SPEED = 113;
    public static final int U_CARSET_DRIVENABLE_MILE = 114;
    public static final int U_CARSET_END = 130;
    public static final int U_CARSET_ENGINE_SPEED = 115;
    public static final int U_CARSET_HANG_LEV = 110;
    public static final int U_CARSET_HANG_ON = 109;
    public static final int U_CARSET_LIGHT_STATE = 112;
    public static final int U_CARSET_MILE_UNIT = 119;
    public static final int U_CARSET_PARK_MODE = 96;
    public static final int U_CARSET_RADAR_BEEP = 95;
    public static final int U_CARSET_TEMP_UNIT = 118;
    public static final int U_CARSET_TIRE_CALI = 107;
    public static final int U_CARSET_TIRE_ERROR = 108;
    public static final int U_CARSET_TIRE_FL = 102;
    public static final int U_CARSET_TIRE_FR = 103;
    public static final int U_CARSET_TIRE_MONITOR_TYPE = 106;
    public static final int U_CARSET_TIRE_ONOFF = 101;
    public static final int U_CARSET_TIRE_RL = 104;
    public static final int U_CARSET_TIRE_RR = 105;
    public static final int U_CARSET_TIRE_SPEED = 99;
    public static final int U_CARSET_TIRE_TYPE = 100;
    public static final int U_CARSET_TIRE_UNIT = 98;
    public static final int U_CARSET_TOTAL_MILE = 116;
    public static final int U_CARSET_TRIPA_AVG_SPEED = 122;
    public static final int U_CARSET_TRIPA_MILE = 120;
    public static final int U_CARSET_TRIPA_OIL = 121;
    public static final int U_CARSET_TRIPA_UNIT = 123;
    public static final int U_CARSET_TRIPB_AVG_OIL = 126;
    public static final int U_CARSET_TRIPB_AVG_SPEED = 127;
    public static final int U_CARSET_TRIPB_MILE = 124;
    public static final int U_CARSET_TRIPB_OIL = 125;
    public static final int U_CARSET_TRIPB_TIME = 129;
    public static final int U_CARSET_TRIPB_UNIT = 128;
    public static final int U_CARSET_VOLTAGE = 117;
    public static final int U_CARSET_WIPER_STATE = 97;
    public static final int U_CAR_CD1_STATE = 131;
    public static final int U_CAR_CD2_STATE = 132;
    public static final int U_CAR_CD3_STATE = 133;
    public static final int U_CAR_CD4_STATE = 134;
    public static final int U_CAR_CD5_STATE = 135;
    public static final int U_CAR_CD6_STATE = 136;
    public static final int U_CAR_CD_MIN = 143;
    public static final int U_CAR_CD_NUM = 141;
    public static final int U_CAR_CD_PLAYSTATE = 137;
    public static final int U_CAR_CD_PREVIEW = 140;
    public static final int U_CAR_CD_RANDOM = 139;
    public static final int U_CAR_CD_REPEAT = 138;
    public static final int U_CAR_CD_SEC = 144;
    public static final int U_CAR_CD_TRACK = 142;
    public static final int U_CNT_MAX = 148;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 148; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_LZ_Binli(TheApp.getInstance()));
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

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 109) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 0:
                    if (BinliCarSet.mIsFront && BinliCarSet.mInstance != null) {
                        BinliCarSet.mInstance.finish();
                        break;
                    }
                    break;
                case 1:
                    if (!BinliCarSet.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.luz.binli.BinliCarSet");
                    }
                    break;
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 148) {
            switch (updateCode) {
                case 109:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 148) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
