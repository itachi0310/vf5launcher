package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0427_XFY_K3 extends CallbackCanbusBase {
    public static final int U_CARINDO_END = 119;
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CNT_MAX = 122;
    public static final int U_CUR_SPEED = 120;
    public static final int U_D0B00 = 113;
    public static final int U_D0B02 = 112;
    public static final int U_D0B04 = 95;
    public static final int U_D1B00 = 97;
    public static final int U_D1B02 = 96;
    public static final int U_D2B00 = 102;
    public static final int U_D2B02 = 101;
    public static final int U_D2B04 = 100;
    public static final int U_D2B06 = 99;
    public static final int U_D2B07 = 98;
    public static final int U_D3B04 = 106;
    public static final int U_D3B05 = 105;
    public static final int U_D3B06 = 104;
    public static final int U_D3B07 = 103;
    public static final int U_D4B06 = 108;
    public static final int U_D4B07 = 107;
    public static final int U_D5B02 = 118;
    public static final int U_D5B03 = 117;
    public static final int U_D5B04 = 116;
    public static final int U_D5B05 = 115;
    public static final int U_D5B06 = 114;
    public static final int U_DTS_SURROUND = 111;
    public static final int U_ENGINE_SPEED = 121;
    public static final int U_LOUD = 109;
    public static final int U_SPEED_VOL = 110;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
