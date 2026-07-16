package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OUDI_Jianghuai_Ruifeng_all;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0452_Oudi_Jianghuai_Ruifeng extends CallbackCanbusBase {
    public static final int U_CAR_AUTOLOCK = 109;
    public static final int U_CAR_D40_D010_B70 = 116;
    public static final int U_CAR_D40_D011_B70 = 117;
    public static final int U_CAR_D40_D012_B70 = 118;
    public static final int U_CAR_D40_D013_B70 = 119;
    public static final int U_CAR_D40_D014_B70 = 120;
    public static final int U_CAR_D40_D015_B70 = 121;
    public static final int U_CAR_D40_D016_B3 = 126;
    public static final int U_CAR_D40_D016_B4 = 125;
    public static final int U_CAR_D40_D016_B5 = 124;
    public static final int U_CAR_D40_D016_B6 = 123;
    public static final int U_CAR_D40_D016_B7 = 122;
    public static final int U_CAR_D40_D017_B70 = 127;
    public static final int U_CAR_D40_D06_B70 = 112;
    public static final int U_CAR_D40_D07_B70 = 113;
    public static final int U_CAR_D40_D08_B70 = 114;
    public static final int U_CAR_D40_D09_B70 = 115;
    public static final int U_CAR_D42_D0_B70 = 128;
    public static final int U_CAR_D42_D10_B70 = 137;
    public static final int U_CAR_D42_D11_B70 = 138;
    public static final int U_CAR_D42_D12_D13 = 139;
    public static final int U_CAR_D42_D14_B4 = 143;
    public static final int U_CAR_D42_D14_B5 = 142;
    public static final int U_CAR_D42_D14_B6 = 141;
    public static final int U_CAR_D42_D14_B7 = 140;
    public static final int U_CAR_D42_D1_D2 = 129;
    public static final int U_CAR_D42_D3_B70 = 130;
    public static final int U_CAR_D42_D4_B70 = 131;
    public static final int U_CAR_D42_D5_B70 = 132;
    public static final int U_CAR_D42_D6_B70 = 133;
    public static final int U_CAR_D42_D7_B70 = 134;
    public static final int U_CAR_D42_D8_B70 = 135;
    public static final int U_CAR_D42_D9_B70 = 136;
    public static final int U_CAR_INTERLIGHT = 108;
    public static final int U_CAR_LOCALIGHT = 111;
    public static final int U_CAR_OUTLIGHT = 107;
    public static final int U_CAR_PROMPTLL = 110;
    public static final int U_CAR_TISHIVOL = 106;
    public static final int U_CNT_MAX = 144;
    public static final int U_PRESSURE_FL = 94;
    public static final int U_PRESSURE_FR = 95;
    public static final int U_PRESSURE_RL = 96;
    public static final int U_PRESSURE_RR = 97;
    public static final int U_TEMP_FL = 98;
    public static final int U_TEMP_FR = 99;
    public static final int U_TEMP_RL = 100;
    public static final int U_TEMP_RR = 101;
    public static final int U_WARNING_FL = 102;
    public static final int U_WARNING_FR = 103;
    public static final int U_WARNING_RL = 104;
    public static final int U_WARNING_RR = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OUDI_Jianghuai_Ruifeng_all(TheApp.getInstance()));
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 144) {
            HandlerCanbus.update(updateCode, ints);
            if ((updateCode == 105 || updateCode == 104 || updateCode == 103 || updateCode == 102) && !JhRuiFengS7TireAct.bNotShowingWarning) {
                if ((DataCanbus.DATA[105] != 0 || DataCanbus.DATA[104] != 0 || DataCanbus.DATA[103] != 0 || DataCanbus.DATA[102] != 0) && !JhRuiFengS7TireAct.bFront) {
                    try {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
