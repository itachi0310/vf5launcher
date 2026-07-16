package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0170_XP1_AnKeSela extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_CARCDENDI = 100;
    public static final int U_CARCDSTATE = 94;
    public static final int U_CAR_PLAY_PROGRESS = 96;
    public static final int U_CAR_PLAY_STATE = 97;
    public static final int U_CAR_TRACK_INFO = 98;
    public static final int U_CNT_MAX = 100;
    public static final int U_DISPLAY_ENABLE_0 = 99;
    public static final int U_SYNC_LINE_GROUP_STR = 95;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
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
        if (updateCode >= 0 && updateCode < 100) {
            if (updateCode == 95) {
                if (ints != null && ints.length >= 1) {
                    infoType = ints[0];
                    if (strs != null && strs.length > 0) {
                        Songname = strs[0];
                    } else {
                        Songname = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
