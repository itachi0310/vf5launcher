package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing;
import com.syu.carinfo.sbd.fordlieying.InfoSBDFordLieYing;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0398_SBD_FORD_LIEYING;
import com.syu.util.HandlerUI;
import com.syu.util.ObjApp;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0398_SBD_FORD_LIEYING extends CallbackCanbusBase {
    public static final int AIR_CONTROL_CMD = 1;
    public static final int CAR_COMM_CONTROL = 2;
    public static final int SYS_START_VER = 0;
    public static final int U_CAR_JUMP_INFO = 115;
    public static final int U_CAR_TABLE_INT_1 = 97;
    public static final int U_CAR_TABLE_INT_2 = 98;
    public static final int U_CAR_TABLE_INT_3 = 99;
    public static final int U_CAR_TABLE_INT_INTER1_1 = 106;
    public static final int U_CAR_TABLE_INT_INTER1_2 = 107;
    public static final int U_CAR_TABLE_INT_INTER1_3 = 108;
    public static final int U_CAR_TABLE_INT_INTER2_1 = 109;
    public static final int U_CAR_TABLE_INT_INTER2_2 = 110;
    public static final int U_CAR_TABLE_INT_INTER2_3 = 111;
    public static final int U_CAR_TABLE_INT_INTER3_1 = 112;
    public static final int U_CAR_TABLE_INT_INTER3_2 = 113;
    public static final int U_CAR_TABLE_INT_INTER3_3 = 114;
    public static final int U_CAR_TABLE_INT_MAX_1 = 100;
    public static final int U_CAR_TABLE_INT_MAX_2 = 101;
    public static final int U_CAR_TABLE_INT_MAX_3 = 102;
    public static final int U_CAR_TABLE_INT_MIN_1 = 103;
    public static final int U_CAR_TABLE_INT_MIN_2 = 104;
    public static final int U_CAR_TABLE_INT_MIN_3 = 105;
    public static final int U_CAR_TABLE_STR_1 = 94;
    public static final int U_CAR_TABLE_STR_2 = 95;
    public static final int U_CAR_TABLE_STR_3 = 96;
    public static final int U_CNT_MAX = 116;
    public final IUiNotify SHOW_AIR_LIEYING = new IUiNotify() { // from class: com.syu.module.canbus.Callback_0398_SBD_FORD_LIEYING.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { // from class: com.syu.module.canbus.Callback_0398_SBD_FORD_LIEYING.2
        @Override // java.lang.Runnable
        public void run() {
            if (AirSBDFordLieYing.mIsFront && AirSBDFordLieYing.mInstance != null) {
                AirSBDFordLieYing.mInstance.finish();
                Callback_0398_SBD_FORD_LIEYING.jump = false;
            }
            ObjApp.getMsgView().msg2("jump2 " + Callback_0398_SBD_FORD_LIEYING.jump);
        }
    };
    public static boolean jump = false;
    public static boolean delay = false;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0398_SBD_FORD_LIEYING(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(this.SHOW_AIR_LIEYING);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.SHOW_AIR_LIEYING);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 94 && updateCode <= 96) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        }
        if (115 == updateCode) {
            convDrivingMode(updateCode, ints);
        } else if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 115) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !AirSBDFordLieYing.mIsFront && !InfoSBDFordLieYing.mIsFront && !delay) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing");
                jump = true;
            }
            ObjApp.getMsgView().msg2("jump1 " + jump);
            if (jump) {
                HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
                HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 3000L);
            }
        }
    }
}
