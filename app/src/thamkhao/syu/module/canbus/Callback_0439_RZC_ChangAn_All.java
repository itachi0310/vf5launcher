package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_ChangAn_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_RZC_ChangAn_All extends CallbackCanbusBase {
    public static final int C_CARSET = 1;
    public static final int C_TURN_RIGHT_ENTER_CAMERA = 0;
    public static final int U_AIRSET_AIRAUTO_DRY = 116;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 114;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 115;
    public static final int U_AIR_AUTO_CLEAR = 124;
    public static final int U_AIR_BLUET_WIN_DOWN = 130;
    public static final int U_BACK_RAINASSIST = 109;
    public static final int U_BOXVOL_BAOJING = 122;
    public static final int U_BOXVOL_TISHI = 121;
    public static final int U_BOXVOL_YINGBING = 120;
    public static final int U_CNT_MAX = 136;
    public static final int U_CUR_OIL_EXPEND = 134;
    public static final int U_DIANLABA_VOLSET = 128;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 112;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 111;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 113;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 110;
    public static final int U_DRIVING_MILEAGE = 135;
    public static final int U_LIGHT_ATMOSPHERE_LIGHT = 132;
    public static final int U_LIGHT_DAY_LIGHT = 131;
    public static final int U_LIGHT_FORNTDELAY = 117;
    public static final int U_LIGHT_ONEKEYTURN = 118;
    public static final int U_OPTIMAL_OIL_EXPEND = 133;
    public static final int U_PART_AUTO_UNLOCK = 123;
    public static final int U_RESORE_CARSET = 108;
    public static final int U_SET_FOLD_REARMIRROR = 94;
    public static final int U_TIRE_ALARM_FL = 104;
    public static final int U_TIRE_ALARM_FR = 105;
    public static final int U_TIRE_ALARM_RL = 106;
    public static final int U_TIRE_ALARM_RR = 107;
    public static final int U_TIRE_PRESSURE_FL = 96;
    public static final int U_TIRE_PRESSURE_FR = 97;
    public static final int U_TIRE_PRESSURE_RL = 98;
    public static final int U_TIRE_PRESSURE_RR = 99;
    public static final int U_TIRE_RESET = 119;
    public static final int U_TIRE_TEMP_FL = 100;
    public static final int U_TIRE_TEMP_FR = 101;
    public static final int U_TIRE_TEMP_RL = 102;
    public static final int U_TIRE_TEMP_RR = 103;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 95;
    public static final int U_UNLOCK_REC_SET = 129;
    public static final int U_WINDOW_DELAY_TIME = 125;
    public static final int U_WINDOW_LIGHT = 126;
    public static final int U_WINDOW_YAOKONG = 127;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 136; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_ChangAn_All(TheApp.getInstance()));
        for (int i4 = 10; i4 < 93; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 136) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
