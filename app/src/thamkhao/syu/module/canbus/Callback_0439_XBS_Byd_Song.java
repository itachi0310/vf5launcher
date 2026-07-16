package com.syu.module.canbus;

import android.content.Intent;
import android.os.RemoteException;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0178_FYTA_BYDF3_SuRui_TopHp;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.WarnDialgAct;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_XBS_Byd_Song extends CallbackCanbusBase {
    public static final int U_AIR_PM25_CAR_IN = 101;
    public static final int U_AIR_PM25_CAR_OUT = 102;
    public static final int U_AIR_PM25_LEVEL_IN = 103;
    public static final int U_AIR_PM25_LEVEL_OUT = 104;
    public static final int U_AIR_PM25_STATUS = 105;
    public static final int U_AIR_WARN_SOUND = 94;
    public static final int U_CARINFO_AIRAUTO_WINLEV = 119;
    public static final int U_CARINFO_AIR_AUTOMODE = 118;
    public static final int U_CARINFO_BEGIN = 110;
    public static final int U_CARINFO_BT_BLOW = 116;
    public static final int U_CARINFO_CHARGING_LOCK = 113;
    public static final int U_CARINFO_DATA0 = 114;
    public static final int U_CARINFO_END = 120;
    public static final int U_CARINFO_ENERGY_FEEDBACK = 112;
    public static final int U_CARINFO_SOC_PORT = 115;
    public static final int U_CARINFO_STEERING_ASSIT = 111;
    public static final int U_CARINFO_STOP_CYCLEIN = 117;
    public static final int U_CNT_MAX = 129;
    public static final int U_PM25_DETECT_INNER = 106;
    public static final int U_PM25_DETECT_OUTER = 107;
    public static final int U_PM25_WARN = 108;
    public static final int U_SET_FULL_CAMERA_SWITCH = 100;
    public static final int U_SET_LONGPRESS_CLOSE_LIFTTING_WINDOW = 97;
    public static final int U_SET_LONGPRESS_OPEN_LIFTTING_WINDOW = 98;
    public static final int U_SET_REMOTE_DOWN_WINDOW = 96;
    public static final int U_SET_REMOTE_LIFT_WINDOW = 95;
    public static final int U_SET_RIGHT_CAMERA_SWITCH = 99;
    public static final int U_SET_WINDOW_VALUE = 109;
    public static final int U_TIRE_ALARM_FL = 125;
    public static final int U_TIRE_ALARM_FR = 126;
    public static final int U_TIRE_ALARM_RL = 127;
    public static final int U_TIRE_ALARM_RR = 128;
    public static final int U_TIRE_PRESSURE_FL = 121;
    public static final int U_TIRE_PRESSURE_FR = 122;
    public static final int U_TIRE_PRESSURE_RL = 123;
    public static final int U_TIRE_PRESSURE_RR = 124;
    boolean isShow = false;
    private Runnable showDlgWarn = new Runnable() { // from class: com.syu.module.canbus.Callback_0439_XBS_Byd_Song.1
        @Override // java.lang.Runnable
        public void run() {
            Callback_0439_XBS_Byd_Song.this.isShow = true;
            Intent ii = new Intent();
            ii.putExtra(WarnDialgAct.INFO, TheApp.getInstance().getString(R.string.str_178_byd_12));
            ii.putExtra(WarnDialgAct.TITLE, TheApp.getInstance().getString(R.string.str_178_byd_11));
            ii.setClass(TheApp.getInstance(), WarnDialgAct.class);
            ii.setFlags(268435456);
            TheApp.getInstance().startActivity(ii);
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0178_FYTA_BYDF3_SuRui_TopHp(TheApp.getInstance()));
        for (int i2 = 10; i2 < 93; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
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
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode == 108 && DataCanbus.DATA[updateCode] == 1) {
            if (this.isShow) {
                this.isShow = false;
                HandlerRemove.getInstance().removeCallbacks(this.showDlgWarn);
            }
            HandlerRemove.getInstance().postDelayed(this.showDlgWarn, 3L);
        }
    }
}
