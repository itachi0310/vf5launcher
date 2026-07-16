package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xbs.tule.XBS_TuleDZSJ_AirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XBS_Nissan_Tule;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_XBS_Nissan_Tul extends CallbackCanbusBase {
    public static final int U_CARINF2_BEGIN = 116;
    public static final int U_CARINF2_BLIND_SPOT = 124;
    public static final int U_CARINF2_BLIND_SPOT_WARN = 127;
    public static final int U_CARINF2_COLLISION_WARN = 125;
    public static final int U_CARINF2_DISTANCE_ASSIT = 122;
    public static final int U_CARINF2_END = 130;
    public static final int U_CARINF2_INTERRUPT_DISPLAY = 119;
    public static final int U_CARINF2_REARVIEW_LEFT = 128;
    public static final int U_CARINF2_REARVIEW_RIGHT = 129;
    public static final int U_CARINF2_ROADAWAY = 123;
    public static final int U_CARINF2_ROADAWAY_WARN = 126;
    public static final int U_CARINF2_SENAR = 117;
    public static final int U_CARINF2_SENAR_FR = 118;
    public static final int U_CARINF2_SENAR_SENSITIVITY = 120;
    public static final int U_CARINF2_SENAR_VOLUME = 121;
    public static final int U_CARINF_AVGFUEL = 97;
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARINF_CENTRE_SENSOR = 100;
    public static final int U_CARINF_CORNER_SENSOR = 99;
    public static final int U_CARINF_DOOR_UNLOCK = 103;
    public static final int U_CARINF_END = 107;
    public static final int U_CARINF_INTER_LIGHT = 101;
    public static final int U_CARINF_KEY_UNLOCK = 104;
    public static final int U_CARINF_LIGHTOFF_DELAY = 106;
    public static final int U_CARINF_LIGHT_SENSOR = 105;
    public static final int U_CARINF_MILEAGE = 95;
    public static final int U_CARINF_PARK_SENSOR = 98;
    public static final int U_CARINF_SPEED_WIPER = 102;
    public static final int U_CARINF_TRAVELABLE = 96;
    public static final int U_CAR_TIRE_BEGIN = 107;
    public static final int U_CAR_TIRE_END = 116;
    public static final int U_CAR_TIRE_VALUE_FL = 108;
    public static final int U_CAR_TIRE_VALUE_FR = 109;
    public static final int U_CAR_TIRE_VALUE_RL = 110;
    public static final int U_CAR_TIRE_VALUE_RR = 111;
    public static final int U_CAR_TIRE_WARN_FL = 112;
    public static final int U_CAR_TIRE_WARN_FR = 113;
    public static final int U_CAR_TIRE_WARN_RL = 114;
    public static final int U_CAR_TIRE_WARN_RR = 115;
    public static final int U_CNT_MAX = 133;
    public static final int U_CUR_MOTOR_SPEED = 132;
    public static final int U_CUR_SPEED = 131;
    Runnable mDismissAir = new Runnable() { // from class: com.syu.module.canbus.Callback_0439_XBS_Nissan_Tul.1
        @Override // java.lang.Runnable
        public void run() {
            if (XBS_TuleDZSJ_AirControlActi.mIsFront && XBS_TuleDZSJ_AirControlActi.mInstance != null) {
                XBS_TuleDZSJ_AirControlActi.mInstance.finish();
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 133; i++) {
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
        if (DataCanbus.DATA[1000] != 8716727) {
            AirHelper.getInstance().buildUi(new Air_0439_XBS_Nissan_Tule(TheApp.getInstance()));
            for (int i3 = 10; i3 < 93; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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

    private void showCotrolAir(int updateCode, int[] ints) {
        if (DataCanbus.DATA[1000] == 8716727) {
            if (!XBS_TuleDZSJ_AirControlActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tule.XBS_TuleDZSJ_AirControlActi");
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissAir);
            HandlerUI.getInstance().postDelayed(this.mDismissAir, 3500L);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 133) {
            if (updateCode >= 10 && updateCode < 93) {
                if (DataCanbus.DATA[1000] == 8716727) {
                    showCotrolAir(updateCode, ints);
                }
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
