package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.R;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_Tangdu_Toyota_All extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 100;
    public static final int U_CARINF_BEGIN = 94;
    public static final int U_CARSET_D26_D0_B10 = 119;
    public static final int U_CARSET_D26_D0_B32 = 118;
    public static final int U_CARSET_D26_D0_B64 = 117;
    public static final int U_CARSET_D26_D0_B7 = 116;
    public static final int U_CARSET_D26_D1_B20 = 124;
    public static final int U_CARSET_D26_D1_B4 = 123;
    public static final int U_CARSET_D26_D1_B5 = 122;
    public static final int U_CARSET_D26_D1_B6 = 121;
    public static final int U_CARSET_D26_D1_B7 = 120;
    public static final int U_CARSET_D26_D2_B3 = 129;
    public static final int U_CARSET_D26_D2_B4 = 128;
    public static final int U_CARSET_D26_D2_B5 = 127;
    public static final int U_CARSET_D26_D2_B6 = 126;
    public static final int U_CARSET_D26_D2_B7 = 125;
    public static final int U_CARSET_D26_D3_B6 = 131;
    public static final int U_CARSET_D26_D3_B7 = 130;
    public static final int U_CARSET_D26_D4_B10 = 132;
    public static final int U_CARSET_D26_D5_B20 = 133;
    public static final int U_CARSET_OIL_UNIT = 106;
    public static final int U_CAR_D1E_D4_B20 = 146;
    public static final int U_CAR_D1E_D4_B4 = 145;
    public static final int U_CAR_D1E_D4_B5 = 144;
    public static final int U_CAR_D1E_D4_B6 = 143;
    public static final int U_CAR_D1E_D4_B7 = 142;
    public static final int U_CAR_D53_D0_B10 = 153;
    public static final int U_CAR_D53_D0_B4 = 152;
    public static final int U_CAR_D53_D0_B5 = 151;
    public static final int U_CAR_D53_D0_B6 = 150;
    public static final int U_CAR_D53_D0_B7 = 149;
    public static final int U_CAR_D53_D1_B5 = 156;
    public static final int U_CAR_D53_D1_B6 = 155;
    public static final int U_CAR_D53_D1_B7 = 154;
    public static final int U_CAR_D53_D2_B6 = 158;
    public static final int U_CAR_D53_D2_B7 = 157;
    public static final int U_CAR_D66_D2_B6 = 148;
    public static final int U_CAR_D66_D2_B7 = 147;
    public static final int U_CAR_D68_D0_B0 = 159;
    public static final int U_CAR_D68_D0_B1 = 160;
    public static final int U_CAR_D68_D0_B2 = 161;
    public static final int U_CAR_D68_D0_B3 = 162;
    public static final int U_CAR_D68_D0_B4 = 163;
    public static final int U_CAR_D68_D0_B5 = 164;
    public static final int U_CAR_ECO_MODE = 98;
    public static final int U_CAR_EC_LEV = 95;
    public static final int U_CAR_EQ_ASL = 140;
    public static final int U_CAR_EQ_BAL = 136;
    public static final int U_CAR_EQ_BASS = 137;
    public static final int U_CAR_EQ_FAD = 135;
    public static final int U_CAR_EQ_MID = 139;
    public static final int U_CAR_EQ_TRE = 138;
    public static final int U_CAR_EQ_VOL = 141;
    public static final int U_CAR_EV_MODE = 99;
    public static final int U_CAR_PE_ENABLE = 96;
    public static final int U_CAR_PE_STATE = 97;
    public static final int U_CNT_MAX = 165;
    public static final int U_CUR_OIL_EXPEND = 103;
    public static final int U_CUR_TRIP_OIL_EXPEND = 104;
    public static final int U_DRIVING_MILEAGE = 102;
    public static final int U_DRIVING_TIME = 101;
    public static final int U_EXIST_TPMS = 107;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 134;
    public static final int U_PRESSURE_BACKUP = 115;
    public static final int U_PRESSURE_FL = 111;
    public static final int U_PRESSURE_FR = 112;
    public static final int U_PRESSURE_RL = 113;
    public static final int U_PRESSURE_RR = 114;
    public static final int U_SHOW_TIRE_BACKUP = 109;
    public static final int U_TIRE_SHOW_STATE = 110;
    public static final int U_TPMS_STATE = 108;
    public static final int U_TRIP_OIL_EXPEND = 105;
    public static int[] mOilNum0 = {0, 10, 20, 30};
    public static int[] mOilNum1 = {0, 20, 40, 60};
    public static int[] mPEDrawableId = {R.drawable.ic_battery_level_0, R.drawable.ic_battery_level_1, R.drawable.ic_battery_level_2, R.drawable.ic_battery_level_3, R.drawable.ic_battery_level_4, R.drawable.ic_battery_level_5, R.drawable.ic_battery_level_6, R.drawable.ic_battery_level_7, R.drawable.ic_battery_level_8};

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 165; i++) {
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

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 165) {
            switch (updateCode) {
                case 105:
                    TripOilExpand(updateCode, ints);
                    break;
                case 134:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 165) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
