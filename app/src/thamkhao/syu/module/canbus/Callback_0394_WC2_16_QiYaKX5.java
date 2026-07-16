package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0351_WC2_16_QiyaK5;
import com.syu.ui.air.Air_0394_WC2_18_Zhipao;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0394_WC2_16_QiYaKX5 extends CallbackCanbusBase {
    public static final int U_AIR_DATA0 = 102;
    public static final int U_AIR_DATA1 = 103;
    public static final int U_AIR_DATA2 = 104;
    public static final int U_AIR_DATA3 = 105;
    public static final int U_AIR_DATA4 = 106;
    public static final int U_AIR_DATA5 = 107;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_END = 101;
    public static final int U_CARINFO_FRONT_VIEW_INIT = 97;
    public static final int U_CARINFO_RADAR_DISPLAY = 96;
    public static final int U_CARINFO_REAR_VIEW_INIT = 98;
    public static final int U_CARINFO_TRACK_DISPLAY = 95;
    public static final int U_CARSEAT_BACK_STATE = 100;
    public static final int U_CARSEAT_STATE = 99;
    public static final int U_CNT_MAX = 103;
    public static final int U_CYTK3_AIR_BEGIN = 102;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 103; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 786826) {
            AirHelper.getInstance().buildUi(new Air_0394_WC2_18_Zhipao(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0351_WC2_16_QiyaK5(TheApp.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
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
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 103) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
