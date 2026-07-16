package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0056_WC2_XueTieLong2008 extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 114;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 115;
    public static final int U_CLOSE_BIGLAMP_TIME = 125;
    public static final int U_CLOSE_INSIDELAMP_TIME = 123;
    public static final int U_CNT_MAX = 135;
    public static final int U_EXIST_TPMS = 133;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 117;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 118;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 116;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 121;
    public static final int U_MUTIL_ECO_TIPS = 119;
    public static final int U_MUTIL_TRAVELLING_TIME = 120;
    public static final int U_PRESSURE_BACKUP = 132;
    public static final int U_PRESSURE_FL = 128;
    public static final int U_PRESSURE_FR = 129;
    public static final int U_PRESSURE_RL = 130;
    public static final int U_PRESSURE_RR = 131;
    public static final int U_RADAR_MUTE = 113;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 124;
    public static final int U_SHOW_TIRE_BACKUP = 134;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 122;
    public static final int U_UNIT_CONSUMPTION = 127;
    public static final int U_UNIT_TEMPERATURE = 126;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 135; i++) {
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
        if (updateCode >= 0 && updateCode < 135) {
            if (updateCode == 111) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[111];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa.PsaOilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 112) {
                HandlerCanbus.update(updateCode, ints);
                int value2 = DataCanbus.DATA[112];
                if (value2 == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa.PsaAlarmRecordActi");
                    return;
                } else {
                    if (value2 == 0 && PsaAllAlarmRecordActi.mIsFront && PsaAllAlarmRecordActi.mInstance != null) {
                        PsaAllAlarmRecordActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
