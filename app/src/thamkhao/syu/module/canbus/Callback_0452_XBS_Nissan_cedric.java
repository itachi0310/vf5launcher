package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_XBS_Nissan_Cedric;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_XBS_Nissan_cedric extends CallbackCanbusBase {
    public static final int U_CARINF_D6B_D0_D1_D2_D3 = 94;
    public static final int U_CARINF_D6B_D4_D5 = 95;
    public static final int U_CARINF_D6B_D6_D7 = 96;
    public static final int U_CARINF_D6D_D0_B0 = 97;
    public static final int U_CARINF_D6D_D0_B1 = 98;
    public static final int U_CARINF_D6D_D0_B3 = 99;
    public static final int U_CARINF_D6D_D0_B4 = 100;
    public static final int U_CARINF_D6D_D1_B70 = 101;
    public static final int U_CARINF_D6D_D2_B70 = 102;
    public static final int U_CARINF_D93_D0_B70 = 103;
    public static final int U_CARINF_D93_D1_B70 = 104;
    public static final int U_CARINF_D93_D2_B70 = 105;
    public static final int U_CARINF_D93_D3_B70 = 106;
    public static final int U_CARINF_D93_D4_B70 = 107;
    public static final int U_CARINF_D93_D5_B70 = 108;
    public static final int U_CARINF_D93_D6_B70 = 109;
    public static final int U_CARINF_D93_D7_B70 = 110;
    public static final int U_CNT_MAX = 112;
    public static final int U_JUMP_SOS_PAGE = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_XBS_Nissan_Cedric(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 111) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 112) {
            switch (updateCode) {
                case 111:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 213) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
