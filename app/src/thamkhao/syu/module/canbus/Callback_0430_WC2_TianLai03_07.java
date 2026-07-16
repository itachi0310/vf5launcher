package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.wc.tianlai.ActivityWCTianLaiCarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0430_wc2_TianLai03;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0430_WC2_TianLai03_07 extends CallbackCanbusBase {
    public static final int U_CARINFO_JY_TOTAL_MILES = 105;
    public static final int U_CDC_BEGIN = 94;
    public static final int U_CDC_END = 104;
    public static final int U_CD_CURRENT_DISC_TRACK = 97;
    public static final int U_CD_CURRENT_TIME = 98;
    public static final int U_CD_DISC_STATE = 95;
    public static final int U_CD_DISC_TYPE = 96;
    public static final int U_CD_DISC_WORK_STATE = 99;
    public static final int U_CD_SHOW = 101;
    public static final int U_CD_STATE = 100;
    public static final int U_CNT_MAX = 108;
    public static final int U_CUR_SPEED = 106;
    public static final int U_ENGINE_SPEED = 107;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0430_wc2_TianLai03(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 101) {
                if (!ActivityWCTianLaiCarCD.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlai.ActivityWCTianLaiCarCD");
                } else if (ActivityWCTianLaiCarCD.mIsFront && ActivityWCTianLaiCarCD.mInstance != null) {
                    ActivityWCTianLaiCarCD.mInstance.finish();
                }
            }
        }
    }
}
