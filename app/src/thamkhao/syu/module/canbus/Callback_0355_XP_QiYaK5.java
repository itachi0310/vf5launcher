package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0355_XP_QiYaK5;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0355_XP_QiYaK5 extends CallbackCanbusBase {
    public static final int CMD_SET_CTRL = 1;
    public static final int C_CMD_AIR = 0;
    public static final int U_BTLINK_BTSTATE = 106;
    public static final int U_BTLINK_NAME = 102;
    public static final int U_BTLINK_NAVI_END_ADDR = 104;
    public static final int U_BTLINK_NAVI_END_NAME = 103;
    public static final int U_BTLINK_NAVI_END_TEL = 105;
    public static final int U_BTLINK_SPEAKING = 100;
    public static final int U_BTLINK_TALKING_TIME = 101;
    public static final int U_CARSET_BEGIN = 95;
    public static final int U_CARSET_GUIJI = 96;
    public static final int U_CARSET_RADAR = 97;
    public static final int U_CARSET_VIEW_FRONT = 98;
    public static final int U_CARSET_VIEW_REAR = 99;
    public static final int U_CAR_EQ_BASS = 109;
    public static final int U_CAR_EQ_MID = 110;
    public static final int U_CAR_EQ_ON = 108;
    public static final int U_CAR_EQ_TREB = 111;
    public static final int U_CAR_LANGUAGE = 94;
    public static final int U_CNT_MAX = 112;
    public static final int U_JUMP_SOS_PAGE = 107;

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
        AirHelper.getInstance().buildUi(new Air_0355_XP_QiYaK5(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 107:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 112) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 107) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }
}
