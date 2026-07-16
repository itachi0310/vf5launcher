package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Nissan_Guishi;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_HC_TianLai_Gongjue extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 105;
    public static final int U_CAREQ_BASS = 103;
    public static final int U_CAREQ_BEGIN = 101;
    public static final int U_CAREQ_BOSE_CENTERPOINT = 108;
    public static final int U_CAREQ_END = 110;
    public static final int U_CAREQ_FAD = 106;
    public static final int U_CAREQ_SPEED_VOL = 109;
    public static final int U_CAREQ_SURROUND_VOL = 107;
    public static final int U_CAREQ_TRE = 104;
    public static final int U_CAREQ_VOL = 102;
    public static final int U_CARINFO_DRIVE_ENABLE = 119;
    public static final int U_CARSET_BEGIN = 111;
    public static final int U_CARSET_END = 118;
    public static final int U_CARSET_HEADLIGHTS_DELAYTIME = 116;
    public static final int U_CARSET_HEADLIGHTS_SENSITIVITY = 113;
    public static final int U_CARSET_INTELLIGENT_KEY = 115;
    public static final int U_CARSET_INTERIOR_ILLUMINATION = 112;
    public static final int U_CARSET_SPEED_SENSING_WIPER = 114;
    public static final int U_CARSET_UNLOCK_SELECTE = 117;
    public static final int U_CD_BEGIN = 94;
    public static final int U_CD_END = 100;
    public static final int U_CD_PLAYSTATE = 96;
    public static final int U_CD_START = 95;
    public static final int U_CD_TIME_M = 98;
    public static final int U_CD_TIME_S = 99;
    public static final int U_CD_TRACK = 97;
    public static final int U_CNT_MAX = 120;

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
        if (DataCanbus.DATA[1000] == 7799223 || DataCanbus.DATA[1000] == 65988 || DataCanbus.DATA[1000] == 1442245) {
            AirHelper.getInstance().buildUi(new Air_0439_HC_Nissan_Guishi(TheApp.getInstance()));
            for (int i3 = 10; i3 < 93; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
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
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
