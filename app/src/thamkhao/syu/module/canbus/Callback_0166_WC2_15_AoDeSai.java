package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0166_WC2_15_AoDeSai extends CallbackCanbusBase {
    public static final int U_CARSHOW_DATA1 = 114;
    public static final int U_CARSHOW_DATA10 = 123;
    public static final int U_CARSHOW_DATA11 = 124;
    public static final int U_CARSHOW_DATA12 = 125;
    public static final int U_CARSHOW_DATA13 = 126;
    public static final int U_CARSHOW_DATA14 = 127;
    public static final int U_CARSHOW_DATA15 = 128;
    public static final int U_CARSHOW_DATA16 = 129;
    public static final int U_CARSHOW_DATA17 = 130;
    public static final int U_CARSHOW_DATA17_2 = 143;
    public static final int U_CARSHOW_DATA18 = 131;
    public static final int U_CARSHOW_DATA19 = 132;
    public static final int U_CARSHOW_DATA2 = 115;
    public static final int U_CARSHOW_DATA20 = 133;
    public static final int U_CARSHOW_DATA21 = 134;
    public static final int U_CARSHOW_DATA22 = 135;
    public static final int U_CARSHOW_DATA23 = 136;
    public static final int U_CARSHOW_DATA24 = 137;
    public static final int U_CARSHOW_DATA25 = 138;
    public static final int U_CARSHOW_DATA26 = 139;
    public static final int U_CARSHOW_DATA27 = 140;
    public static final int U_CARSHOW_DATA28 = 141;
    public static final int U_CARSHOW_DATA29 = 142;
    public static final int U_CARSHOW_DATA3 = 116;
    public static final int U_CARSHOW_DATA4 = 117;
    public static final int U_CARSHOW_DATA5 = 118;
    public static final int U_CARSHOW_DATA6 = 119;
    public static final int U_CARSHOW_DATA7 = 120;
    public static final int U_CARSHOW_DATA8 = 121;
    public static final int U_CARSHOW_DATA9 = 122;
    public static final int U_CNT_MAX = 144;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
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

    private void updateWarningNum(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 4) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 144) {
            switch (updateCode) {
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                    updateWarningNum(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
