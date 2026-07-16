package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.sbd.x80.TianLai09Act;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0388_HC_XP1_9TianLai;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0388_HC_OLD_9TianLai extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CAR_VOL = 111;
    public static final int U_CD_BEGIN = 100;
    public static final int U_CD_CURRENT_DISC_TRACK = 103;
    public static final int U_CD_CURRENT_TIME = 104;
    public static final int U_CD_DISC_STATE = 102;
    public static final int U_CD_DISC_WORK_STATE = 105;
    public static final int U_CD_END = 107;
    public static final int U_CD_STATE = 101;
    public static final int U_CD_TEXT = 106;
    public static final int U_CNT_MAX = 113;
    public static final int U_MEDIA_BEGIN = 108;
    public static final int U_MEDIA_END = 110;
    public static final int U_MEDIA_STATE = 109;
    public static final int U_RADIO_BAND = 96;
    public static final int U_RADIO_CHANNEL_FREQ = 97;
    public static final int U_RADIO_END = 99;
    public static final int U_RADIO_STATE = 95;
    public static final int U_RADIO_TEXT = 98;
    public static final int U_SOURCE_STATE = 112;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 113; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0388_HC_XP1_9TianLai(TheApp.getInstance()));
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
        if (updateCode == 97 || updateCode == 98 || updateCode == 106) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 112) {
            if ((ints[0] == 2 || ints[0] == 1) && !TianLai09Act.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.x80.TianLai09Act");
            }
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
