package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.ToastInfo;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0117_XP1_LINGPAI extends CallbackCanbusBase {
    public static final int U_CARINDO_COMPASS_CAL = 161;
    public static final int U_CARINDO_COMPASS_POINT = 160;
    public static final int U_CARINFO_AMP_MODE = 172;
    public static final int U_CARINFO_AURO_DOOR_LOCK = 130;
    public static final int U_CARINFO_AURO_UNLOCK_ON_EXIT = 131;
    public static final int U_CARINFO_AUTO_ADJUST_SPEED_SOUND = 174;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 166;
    public static final int U_CARINFO_AUTO_ANTI_HIGH_BEAM = 127;
    public static final int U_CARINFO_AUTO_BRAKE = 164;
    public static final int U_CARINFO_AUTO_SEAT_START = 143;
    public static final int U_CARINFO_BEGIN = 115;
    public static final int U_CARINFO_BRAKE_LIST_ENABLE = 163;
    public static final int U_CARINFO_BRAKE_PARK_SENSE = 158;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 149;
    public static final int U_CARINFO_CD_CURRENT_INDEX = 178;
    public static final int U_CARINFO_CD_PLAYMODE = 177;
    public static final int U_CARINFO_CD_PLAY_TIME = 179;
    public static final int U_CARINFO_CD_PLAY_TOTALTIME = 180;
    public static final int U_CARINFO_CD_STATE = 176;
    public static final int U_CARINFO_CD_TOTAL_INDEX = 181;
    public static final int U_CARINFO_COMPASS_DEVIATION_VALUE = 162;
    public static final int U_CARINFO_CORNERLING_LIGHTS = 124;
    public static final int U_CARINFO_DAYTIME_LIGHTS = 123;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 170;
    public static final int U_CARINFO_ENGINE_OFF_POWER_DELAY = 141;
    public static final int U_CARINFO_FIRST_PRESS_KEY_UNLOCK = 136;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LIGHT = 121;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LOCK = 132;
    public static final int U_CARINFO_FRONT_COLLISION_WARN = 152;
    public static final int U_CARINFO_FRONT_COLLISION_WARN_AUTO_BRAKE = 153;
    public static final int U_CARINFO_FRONT_PARK_VOL = 150;
    public static final int U_CARINFO_GREETING_LIGHT = 129;
    public static final int U_CARINFO_HEADLIGHT_DELAYED = 120;
    public static final int U_CARINFO_HEADLIGHT_DELAYED_ENGINE = 140;
    public static final int U_CARINFO_HEADLIGHT_ILLUMI_ON_APPROACH = 122;
    public static final int U_CARINFO_HEADLIGHT_SENSI = 128;
    public static final int U_CARINFO_HORN_LOCK = 133;
    public static final int U_CARINFO_HORN_REMOTE = 138;
    public static final int U_CARINFO_INTER_CARLIGHT = 171;
    public static final int U_CARINFO_LANE_DEVIATION_CALI = 155;
    public static final int U_CARINFO_LANE_DEVIATION_WARN = 159;
    public static final int U_CARINFO_LANG = 114;
    public static final int U_CARINFO_MIRROR_DIMMING = 126;
    public static final int U_CARINFO_PARKVIEW_DYNAMIC_GUIDE_LINE = 146;
    public static final int U_CARINFO_PARKVIEW_STATIC_GUIDE_LINE = 147;
    public static final int U_CARINFO_PARK_SENSE = 144;
    public static final int U_CARINFO_PASSIVE_ENTRY = 137;
    public static final int U_CARINFO_POWER_LEFT_GATE_ALERT = 135;
    public static final int U_CARINFO_RAIN_SENS_WIPERS = 156;
    public static final int U_CARINFO_RAMP_START_ASSIST = 148;
    public static final int U_CARINFO_REAR_BRAKE_PARK_AUTO = 157;
    public static final int U_CARINFO_REAR_BRAKE_PARK_SENSE = 145;
    public static final int U_CARINFO_REAR_PARK_VOL = 151;
    public static final int U_CARINFO_REMOTE_DOOR_UNLOCK = 139;
    public static final int U_CARINFO_REMOTE_TIP_SOUND = 173;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 142;
    public static final int U_CARINFO_SMART_KEY_SETTINGS = 134;
    public static final int U_CARINFO_SURROUND = 175;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 154;
    public static final int U_CARINFO_TIRE_JACKS = 167;
    public static final int U_CARINFO_TRANSPORT_MODE = 168;
    public static final int U_CARINFO_UNIT_DISTANCE = 117;
    public static final int U_CARINFO_UNIT_FUEL = 116;
    public static final int U_CARINFO_UNIT_PRESS = 119;
    public static final int U_CARINFO_UNIT_TEMP = 118;
    public static final int U_CARINFO_UNIT_UNIT = 115;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 169;
    public static final int U_CARINFO_WIN_LIST = 165;
    public static final int U_CARINFO_WIPER_WITH_HEADLIGHT = 125;
    public static final int U_CNT_MAX = 182;
    public static final int U_MISC_BEGIN = 94;
    public static final int U_MISC_END = 113;
    ShowSeriviceInfos infos;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 182; i++) {
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
        if (updateCode >= 0 && updateCode < 182) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (165 == updateCode && DataCanbus.DATA[164] == 1) {
            updatedateInfos(DataCanbus.DATA[updateCode]);
        }
    }

    public void updatedateInfos(int i) {
        int resid = -1;
        switch (i) {
            case 0:
                resid = R.string.str_117_bnr_zyg_1;
                break;
            case 1:
                resid = R.string.str_117_bnr_zyg_2;
                break;
            case 2:
                resid = R.string.str_117_bnr_zyg_3;
                break;
            case 3:
                resid = R.string.str_117_bnr_zyg_4;
                break;
            case 4:
                resid = R.string.str_117_bnr_zyg_5;
                break;
            case 5:
                resid = R.string.str_117_bnr_zyg_6;
                break;
            case 6:
                resid = R.string.str_117_bnr_zyg_7;
                break;
            case 7:
                resid = R.string.str_117_bnr_zyg_8;
                break;
        }
        if (resid > -1) {
            String string = TheApp.getInstance().getString(resid);
            if (this.infos == null) {
                this.infos = new ShowSeriviceInfos();
            }
            this.infos.setText(string);
            HandlerRemove.getInstance().post(this.infos);
        }
    }

    public class ShowSeriviceInfos implements Runnable {
        public String string;

        public ShowSeriviceInfos() {
        }

        public void setText(String str) {
            this.string = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastInfo.showToast(TheApp.getInstance(), this.string);
        }
    }
}
