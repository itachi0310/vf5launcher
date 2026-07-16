package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xincheng_Infeinidi_Q70;
import com.syu.ui.air.Air_0452_Xincheng_Nissan_Tule;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_Xincheng_Infiniti_All extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 141;
    public static final int U_CAREQ_BASS = 139;
    public static final int U_CAREQ_BEGIN = 137;
    public static final int U_CAREQ_BOSE = 144;
    public static final int U_CAREQ_DRIVER = 146;
    public static final int U_CAREQ_FAD = 142;
    public static final int U_CAREQ_SPEED_VOL = 143;
    public static final int U_CAREQ_SURROUND = 145;
    public static final int U_CAREQ_TREBL = 140;
    public static final int U_CAREQ_VOL = 138;
    public static final int U_CARINFO_BEGIN = 100;
    public static final int U_CARINFO_D71_D1D0 = 101;
    public static final int U_CARINFO_D71_D3D2 = 102;
    public static final int U_CARINFO_D71_D6D5D4 = 103;
    public static final int U_CARINFO_D72_D1D0 = 104;
    public static final int U_CARINFO_D72_D2 = 105;
    public static final int U_CARSET_D74_D0_B0 = 111;
    public static final int U_CARSET_D74_D0_B1 = 110;
    public static final int U_CARSET_D74_D0_B2 = 109;
    public static final int U_CARSET_D74_D0_B3 = 108;
    public static final int U_CARSET_D74_D0_B4 = 107;
    public static final int U_CARSET_D74_D0_B5 = 106;
    public static final int U_CARSET_D74_D0_B6 = 148;
    public static final int U_CARSET_D74_D1_B02 = 112;
    public static final int U_CARSET_D74_D1_B35 = 113;
    public static final int U_CARSET_D74_D1_B67 = 114;
    public static final int U_CARSET_D74_D2_B01 = 115;
    public static final int U_CARSET_D74_D2_B23 = 116;
    public static final int U_CARSET_D74_D2_B45 = 117;
    public static final int U_CARSET_D74_D2_B6 = 118;
    public static final int U_CARSET_D74_D3_B02 = 119;
    public static final int U_CARSET_D74_D3_B3 = 149;
    public static final int U_CARSET_D74_D3_B4 = 150;
    public static final int U_CARSET_D74_D3_B75 = 151;
    public static final int U_CARSET_D74_D4_B1 = 156;
    public static final int U_CARSET_D74_D4_B2 = 155;
    public static final int U_CARSET_D74_D4_B3 = 154;
    public static final int U_CARSET_D74_D4_B4 = 153;
    public static final int U_CARSET_D74_D4_B75 = 152;
    public static final int U_CARSET_D75_D0_B0 = 125;
    public static final int U_CARSET_D75_D0_B1 = 124;
    public static final int U_CARSET_D75_D0_B2 = 123;
    public static final int U_CARSET_D75_D0_B3 = 122;
    public static final int U_CARSET_D75_D0_B4 = 121;
    public static final int U_CARSET_D75_D0_B65 = 120;
    public static final int U_CARSET_D75_D1_B07 = 126;
    public static final int U_CARSET_D75_D2_B07 = 127;
    public static final int U_CARSET_D75_D3_B07 = 128;
    public static final int U_CARSET_D75_D4_B0 = 135;
    public static final int U_CARSET_D75_D4_B1 = 134;
    public static final int U_CARSET_D75_D4_B2 = 133;
    public static final int U_CARSET_D75_D4_B3 = 132;
    public static final int U_CARSET_D75_D4_B4 = 131;
    public static final int U_CARSET_D75_D4_B5 = 130;
    public static final int U_CARSET_D75_D4_B6 = 129;
    public static final int U_CARSET_D75_D5_B07 = 136;
    public static final int U_CARSET_D7A_D0_B20 = 164;
    public static final int U_CARSET_D7A_D0_B4 = 163;
    public static final int U_CARSET_D7A_D0_B75 = 162;
    public static final int U_CARSET_D7A_D1_B0 = 168;
    public static final int U_CARSET_D7A_D1_B1 = 167;
    public static final int U_CARSET_D7A_D1_B42 = 166;
    public static final int U_CARSET_D7A_D1_B75 = 165;
    public static final int U_CARSET_END = 137;
    public static final int U_CAR_BELT_STATE = 160;
    public static final int U_CAR_CUR_SPEED = 157;
    public static final int U_CAR_EN_SPEED = 158;
    public static final int U_CAR_HANDBRAKE_STATE = 159;
    public static final int U_CAR_JUMP_AIR = 161;
    public static final int U_CAR_TIRE_BEGIN = 93;
    public static final int U_CAR_TIRE_END = 100;
    public static final int U_CAR_TIRE_SYS_VALUE = 99;
    public static final int U_CAR_TIRE_VALUE_FL = 94;
    public static final int U_CAR_TIRE_VALUE_FR = 95;
    public static final int U_CAR_TIRE_VALUE_RL = 96;
    public static final int U_CAR_TIRE_VALUE_RR = 97;
    public static final int U_CAR_TIRE_WARN_VALUE = 98;
    public static final int U_CNT_MAX = 169;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 147;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 169; i++) {
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
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (2032068 == DataCanbus.DATA[1000]) {
            AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Infeinidi_Q70(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Nissan_Tule(TheApp.getInstance()));
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 169) {
            if (updateCode == 161) {
                if (5046724 == DataCanbus.DATA[1000] || 5112260 == DataCanbus.DATA[1000]) {
                    int value = ints[0];
                    if (value == 1) {
                        if (!Xincheng_Nissan_Tule_AirControlActi.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi");
                            return;
                        }
                        return;
                    } else {
                        if (value == 0 && Xincheng_Nissan_Tule_AirControlActi.mIsFront && Xincheng_Nissan_Tule_AirControlActi.mInstance != null) {
                            Xincheng_Nissan_Tule_AirControlActi.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
