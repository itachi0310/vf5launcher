package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_DJ_08Prado_H extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_JUMP_EQ = 2;
    public static final int CMD_SET_CTRL = 1;
    public static final int CMD_SET_CTRL2 = 3;
    public static final int CMD_SET_CTRL3 = 4;
    public static final int CMD_SET_CTRL4 = 5;
    public static final int U_CAR_CD1_STATE = 113;
    public static final int U_CAR_CD2_STATE = 114;
    public static final int U_CAR_CD3_STATE = 115;
    public static final int U_CAR_CD4_STATE = 116;
    public static final int U_CAR_CD5_STATE = 117;
    public static final int U_CAR_CD6_STATE = 118;
    public static final int U_CAR_CD_ASL = 112;
    public static final int U_CAR_CD_DISC_RANDOM = 109;
    public static final int U_CAR_CD_DISC_REPEAT = 108;
    public static final int U_CAR_CD_MIN = 110;
    public static final int U_CAR_CD_NUM = 103;
    public static final int U_CAR_CD_RANDOM = 107;
    public static final int U_CAR_CD_REPEAT = 106;
    public static final int U_CAR_CD_SCAN = 119;
    public static final int U_CAR_CD_SEC = 111;
    public static final int U_CAR_CD_TOTALTRACK = 105;
    public static final int U_CAR_CD_TRACK = 104;
    public static final int U_CAR_RADIO_BAND = 94;
    public static final int U_CAR_RADIO_FREQ = 95;
    public static final int U_CAR_RADIO_FREQ1 = 96;
    public static final int U_CAR_RADIO_FREQ2 = 97;
    public static final int U_CAR_RADIO_FREQ3 = 98;
    public static final int U_CAR_RADIO_FREQ4 = 99;
    public static final int U_CAR_RADIO_FREQ5 = 100;
    public static final int U_CAR_RADIO_FREQ6 = 101;
    public static final int U_CAR_RADIO_STATE = 102;
    public static final int U_CAR_SET_INFO1 = 121;
    public static final int U_CAR_SET_INFO2 = 122;
    public static final int U_CAR_VOL = 120;
    public static final int U_CNT_MAX = 123;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
