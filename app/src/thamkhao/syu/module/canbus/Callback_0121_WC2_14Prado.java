package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0121_WC2_14Prado extends CallbackCanbusBase {
    public static final int MINUTEOILEXPENDMAX = 15;
    public static final int U_2TIMES_KEY_UNLOCK = 101;
    public static final int U_AIR_BY_AUTO_KEY = 112;
    public static final int U_AVERAGE_SPEED = 96;
    public static final int U_CLOSE_BIGLAMP_TIME = 113;
    public static final int U_CLOSE_INSIDELAMP_TIME = 98;
    public static final int U_CNT_MAX = 119;
    public static final int U_CURRENT_SPEED = 114;
    public static final int U_CUR_OIL_EXPEND = 94;
    public static final int U_CUR_SPEED = 117;
    public static final int U_DRIVING_MILEAGE = 95;
    public static final int U_DRIVING_TIME = 97;
    public static final int U_DSP_SURROUND = 116;
    public static final int U_DSP_VOL_LINK_SPEED = 115;
    public static final int U_ENGINE_SPEED = 118;
    public static final int U_FRONT_RADAR_DISTANCE = 109;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 111;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 105;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 102;
    public static final int U_OPTIMAL_OIL_EXPEND = 106;
    public static final int U_RADAR_VOL = 108;
    public static final int U_REAR_RADAR_DISTANCE = 110;
    public static final int U_REMOTE_2PRESS_UNLOCK = 99;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 100;
    public static final int U_SHOW_RADAR = 107;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 104;
    public static final int U_UNLOCK_BY_SMART_DOOR = 103;
    public static int[][] mMinuteoilexpend = new int[15][];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 105:
                    lastMinoldexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 119) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }

    private void lastMinoldexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 15) {
            mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
