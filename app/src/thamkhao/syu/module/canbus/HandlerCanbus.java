package com.syu.module.canbus;

import com.syu.canbus.CarBtActi;
import com.syu.canbus.JumpPage;
import com.syu.module.IUiNotify;

/* JADX INFO: loaded from: classes.dex */
public class HandlerCanbus {
    private static final IUiNotify NTF_CANBUS_ID = new IUiNotify() { // from class: com.syu.module.canbus.HandlerCanbus.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            CallbackCanbusBase callbackCanbus = HandlerCanbus.getCallbackCanbusById(DataCanbus.DATA[updateCode]);
            ModuleCallbackCanbusProxy.getInstance().setCallbackCanbus(callbackCanbus);
        }
    };

    public static void update(int updateCode, int[] ints) {
        if (ints != null && ints.length != 0 && DataCanbus.DATA[updateCode] != ints[0]) {
            DataCanbus.DATA[updateCode] = ints[0];
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int value) {
        if (DataCanbus.DATA[updateCode] != value) {
            DataCanbus.DATA[updateCode] = value;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        if ((ints != null && ints.length != 0) || (strs != null && strs.length != 0)) {
            if (ints != null && DataCanbus.DATA[updateCode] != ints[0]) {
                DataCanbus.DATA[updateCode] = ints[0];
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, flts, strs);
        }
    }

    public static void canbusId(int updateCode, int value) {
        if (DataCanbus.DATA[updateCode] != value) {
            DataCanbus.DATA[updateCode] = value;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void updateCarBt(int value) {
        if (value == 1) {
            if (!CarBtActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.canbus.CarBtActi");
            }
        } else if (value == 0 && CarBtActi.mIsFront && CarBtActi.mInstance != null) {
            CarBtActi.mInstance.finish();
        }
    }

    static {
        DataCanbus.NOTIFY_EVENTS[1000].addNotify(NTF_CANBUS_ID, 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:1037:0x113a  */
    /* JADX WARN: Removed duplicated region for block: B:1038:0x1141  */
    /* JADX WARN: Removed duplicated region for block: B:1523:0x15c1  */
    /* JADX WARN: Removed duplicated region for block: B:1525:0x15ca A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.syu.module.canbus.CallbackCanbusBase getCallbackCanbusById(int r9) {
        /*
            Method dump skipped, instruction units count: 11226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.module.canbus.HandlerCanbus.getCallbackCanbusById(int):com.syu.module.canbus.CallbackCanbusBase");
    }
}
