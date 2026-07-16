package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_19Sprinter;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_Benz_Metris extends CallbackCanbusBase {
    public static String Title = null;
    public static final int U_CARINF_D9B_STR = 110;
    public static final int U_CARSET_BEGIN = 94;
    public static final int U_CARSET_D61_D0_B30 = 96;
    public static final int U_CARSET_D61_D0_B4 = 95;
    public static final int U_CARSET_D61_D0_B5 = 109;
    public static final int U_CARSET_D61_D1_B30 = 98;
    public static final int U_CARSET_D61_D1_B4 = 97;
    public static final int U_CARSET_D61_D2_B4 = 99;
    public static final int U_CARSET_D61_D3_B0 = 101;
    public static final int U_CARSET_D61_D3_B74 = 100;
    public static final int U_CARSET_D61_D4_B0 = 103;
    public static final int U_CARSET_D61_D4_B4 = 102;
    public static final int U_CARSET_D61_D5_B30 = 105;
    public static final int U_CARSET_D61_D5_B4 = 104;
    public static final int U_CARSET_D61_D6_B0 = 107;
    public static final int U_CARSET_D61_D6_B4 = 106;
    public static final int U_CARSET_D61_D7_B4 = 108;
    public static final int U_CNT_MAX = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_19Sprinter(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 111) {
            switch (updateCode) {
                case 110:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = null;
                    }
                    Log.v("zed", "U_CARINF_D9B_STR updateCode" + updateCode + "== Title == " + Title);
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
