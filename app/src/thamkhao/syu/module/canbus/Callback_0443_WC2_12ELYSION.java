package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0443_WC2_12ELYSION extends CallbackCanbusBase {
    public static String STR_SHOW1 = null;
    public static String STR_SHOW2 = null;
    public static String STR_SHOW3 = null;
    public static String STR_SHOW4 = null;
    public static final int U_AVERAGE_OIL_CONSUMPTION = 97;
    public static final int U_AVERAGE_OIL_CONSUMPTION_1 = 107;
    public static final int U_AVERAGE_OIL_CONSUMPTION_2 = 109;
    public static final int U_AVERAGE_OIL_CONSUMPTION_3 = 111;
    public static final int U_AVERAGE_OIL_CONSUMPTION_UNIT = 102;
    public static final int U_CARCD_D0_D18_B5 = 123;
    public static final int U_CARCD_D0_D18_B6 = 122;
    public static final int U_CARCD_D0_D18_B7 = 121;
    public static final int U_CARCD_D0_D19_B30 = 124;
    public static final int U_CARCD_D0_D1_B0 = 116;
    public static final int U_CARCD_D0_D1_B31 = 115;
    public static final int U_CARCD_D0_D1_B74 = 114;
    public static final int U_CARCD_D0_D20_B30 = 126;
    public static final int U_CARCD_D0_D20_B7 = 125;
    public static final int U_CARCD_D0_D21_B20 = 129;
    public static final int U_CARCD_D0_D21_B53 = 128;
    public static final int U_CARCD_D0_D21_B7 = 127;
    public static final int U_CARCD_D0_STR_SHOW1 = 117;
    public static final int U_CARCD_D0_STR_SHOW2 = 118;
    public static final int U_CARCD_D0_STR_SHOW3 = 119;
    public static final int U_CARCD_D0_STR_SHOW4 = 120;
    public static final int U_CARCD_VOL = 130;
    public static final int U_CNT_MAX = 131;
    public static final int U_CURRENT_AVERAGE_OIL_CONSUMPTION = 95;
    public static final int U_CURRENT_OIL_CONSUMPTION = 94;
    public static final int U_CURRENT_OIL_CONSUMPTION_UNIT = 100;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION = 96;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION_UNIT = 101;
    public static final int U_LIFE_MILEAGE = 99;
    public static final int U_LIFE_MILEAGE_UNIT = 104;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    public static final int U_OIL_CONSUMPTION_COUNT = 105;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 112;
    public static final int U_TRIPA = 98;
    public static final int U_TRIPA_1 = 106;
    public static final int U_TRIPA_2 = 108;
    public static final int U_TRIPA_3 = 110;
    public static final int U_TRIPA_UNIT = 103;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
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
        if (updateCode >= 0 && updateCode < 131) {
            switch (updateCode) {
                case 117:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW1 = strs[0];
                    } else {
                        STR_SHOW1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 118:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW2 = strs[0];
                    } else {
                        STR_SHOW2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 119:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW3 = strs[0];
                    } else {
                        STR_SHOW3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 120:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW4 = strs[0];
                    } else {
                        STR_SHOW4 = "";
                    }
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
