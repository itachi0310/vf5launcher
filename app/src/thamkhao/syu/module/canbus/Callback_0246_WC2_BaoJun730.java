package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0246_WC_20Baojun530;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0246_WC2_BaoJun730 extends CallbackCanbusBase {
    public static final int U_AIR_COOL = 97;
    public static final int U_AIR_SMOKE = 98;
    public static final int U_AIR_SNOW = 99;
    public static final int U_AIR_WARM = 96;
    public static final int U_CARSET_D61_D0_B0 = 105;
    public static final int U_CARSET_D61_D0_B1 = 104;
    public static final int U_CARSET_D61_D0_B2 = 103;
    public static final int U_CARSET_D61_D0_B3 = 102;
    public static final int U_CARSET_D61_D0_B54 = 101;
    public static final int U_CARSET_D61_D0_B76 = 100;
    public static final int U_CARSET_D61_D1_B0 = 107;
    public static final int U_CARSET_D61_D1_B1 = 106;
    public static final int U_CNT_MAX = 108;
    public static final int U_REARV_AUTO_ENABLE = 94;
    public static final int U_REARV_AUTO_INFO = 95;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
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
        if (DataCanbus.DATA[1000] == 393462 || DataCanbus.DATA[1000] == 458998) {
            for (int i3 = 10; i3 < 93; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            AirHelper.getInstance().buildUi(new Air_0246_WC_20Baojun530(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
