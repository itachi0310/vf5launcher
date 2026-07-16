package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_ChangfeiLiebao_CS9;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_OD_ChangfengLiebao_CS9 extends CallbackCanbusBase {
    public static final int U_CARINF_D42_D0_B70 = 94;
    public static final int U_CARINF_D42_D10_D11 = 101;
    public static final int U_CARINF_D42_D12_D13 = 102;
    public static final int U_CARINF_D42_D14_B70 = 103;
    public static final int U_CARINF_D42_D15_B70 = 104;
    public static final int U_CARINF_D42_D16_B70 = 105;
    public static final int U_CARINF_D42_D1_B70 = 95;
    public static final int U_CARINF_D42_D2_D3 = 96;
    public static final int U_CARINF_D42_D4_D5 = 97;
    public static final int U_CARINF_D42_D6_D7 = 98;
    public static final int U_CARINF_D42_D8_B70 = 99;
    public static final int U_CARINF_D42_D9_B70 = 100;
    public static final int U_CNT_MAX = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 106; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_ChangfeiLiebao_CS9(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 106) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
