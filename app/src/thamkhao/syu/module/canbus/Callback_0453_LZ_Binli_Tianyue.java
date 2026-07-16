package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_LZ_Binli_Tianyue extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 23;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTO_RIGHT = 12;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 19;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 32;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 31;
    public static final int U_AIR_BLOW_UP_LEFT = 17;
    public static final int U_AIR_BLOW_UP_RIGHT = 30;
    public static final int U_AIR_BLOW_WIN_LEFT = 16;
    public static final int U_AIR_BLOW_WIN_RIGHT = 29;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_D07_D1_B2 = 52;
    public static final int U_AIR_D07_D1_B3 = 51;
    public static final int U_AIR_D07_D1_B4 = 50;
    public static final int U_AIR_D07_D1_B5 = 49;
    public static final int U_AIR_D07_D1_B6 = 48;
    public static final int U_AIR_D07_D1_B7 = 47;
    public static final int U_AIR_END = 46;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SEAT_AUTO_LEFT = 24;
    public static final int U_AIR_SEAT_AUTO_RIGHT = 25;
    public static final int U_AIR_SEAT_COLD_AUTO_LEFT = 34;
    public static final int U_AIR_SEAT_COLD_AUTO_RIGHT = 35;
    public static final int U_AIR_SEAT_COLD_LEFT = 36;
    public static final int U_AIR_SEAT_COLD_LEFT_BOTTOM = 43;
    public static final int U_AIR_SEAT_COLD_LEFT_WAIST = 42;
    public static final int U_AIR_SEAT_COLD_RIGHT = 37;
    public static final int U_AIR_SEAT_COLD_RIGHT_BOTTOM = 45;
    public static final int U_AIR_SEAT_COLD_RIGHT_WAIST = 44;
    public static final int U_AIR_SEAT_HOT_LEFT = 27;
    public static final int U_AIR_SEAT_HOT_LEFT_BOTTOM = 39;
    public static final int U_AIR_SEAT_HOT_LEFT_WAIST = 38;
    public static final int U_AIR_SEAT_HOT_RIGHT = 28;
    public static final int U_AIR_SEAT_HOT_RIGHT_BOTTOM = 41;
    public static final int U_AIR_SEAT_HOT_RIGHT_WAIST = 40;
    public static final int U_AIR_SYNC = 13;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 22;
    public static final int U_AIR_TEMP_UNIT = 26;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 33;
    public static final int U_CNT_MAX = 53;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 53; i++) {
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
        if (updateCode >= 0 && updateCode < 53) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
