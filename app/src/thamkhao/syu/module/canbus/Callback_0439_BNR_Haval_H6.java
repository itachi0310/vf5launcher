package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_BNR_HavaH6;
import com.syu.ui.air.Air_0439_BNR_Haval_H9;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0439_BNR_Haval_H6 extends CallbackCanbusBase {
    public static final int U_CARINFO2_ALTITUDE = 138;
    public static final int U_CARINFO_D10_D0_D1 = 108;
    public static final int U_CARINFO_D10_D2_B70 = 109;
    public static final int U_CARINFO_D10_D3_B70 = 110;
    public static final int U_CARINFO_D10_D4_B70 = 111;
    public static final int U_CARINFO_D10_D5_B70 = 112;
    public static final int U_CARINFO_D10_D6_B70 = 113;
    public static final int U_CARINFO_D11_D0_B70 = 114;
    public static final int U_CARINFO_D11_D1_B70 = 115;
    public static final int U_CARINFO_D11_D2_B70 = 116;
    public static final int U_CARINFO_D12_D0_B70 = 117;
    public static final int U_CARINFO_D12_D1_B70 = 118;
    public static final int U_CARINFO_D12_D2_B70 = 119;
    public static final int U_CARINFO_D12_D3_B70 = 120;
    public static final int U_CARINFO_D12_D4_B70 = 121;
    public static final int U_CARINFO_D13_D0_B30 = 123;
    public static final int U_CARINFO_D13_D0_B74 = 122;
    public static final int U_CARINFO_D13_D1_B30 = 125;
    public static final int U_CARINFO_D13_D1_B74 = 124;
    public static final int U_CARINFO_D13_D2_B30 = 127;
    public static final int U_CARINFO_D13_D2_B74 = 126;
    public static final int U_CARINFO_D13_D3_B30 = 129;
    public static final int U_CARINFO_D13_D3_B74 = 128;
    public static final int U_CARINFO_D31_D0_B70 = 130;
    public static final int U_CARINFO_D31_D1_B70 = 131;
    public static final int U_CARINFO_D31_D2_B70 = 132;
    public static final int U_CARINFO_D31_D3_B70 = 133;
    public static final int U_CARINFO_D31_D4_B70 = 134;
    public static final int U_CARINFO_D31_D5_B70 = 135;
    public static final int U_CARINFO_D31_D6_B70 = 136;
    public static final int U_CARINFO_D31_D7_B70 = 137;
    public static final int U_CARINFO_D4_D3_B0 = 97;
    public static final int U_CARINFO_D4_D3_B1 = 98;
    public static final int U_CARINFO_D4_D4_B10 = 99;
    public static final int U_CARINFO_D4_D4_B2 = 100;
    public static final int U_CARINFO_D4_D4_B3 = 101;
    public static final int U_CARINFO_D4_D4_B4 = 102;
    public static final int U_CARINFO_D4_D4_B5 = 103;
    public static final int U_CARINFO_D4_D4_B6 = 104;
    public static final int U_CARINFO_D4_D5_B0 = 105;
    public static final int U_CARINFO_D4_D5_B1 = 106;
    public static final int U_CARINFO_D4_D5_B2 = 107;
    public static final int U_CARINFO_DOMEDELAY = 94;
    public static final int U_CARINFO_FOLLOWHOME = 95;
    public static final int U_CARINFO_POWERSAVE = 96;
    public static final int U_CNT_MAX = 140;
    public static final int U_JUMP_CARSEAT_SET = 139;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 140; i++) {
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
        if (DataCanbus.DATA[1000] == 16384439) {
            AirHelper.getInstance().buildUi(new Air_0439_BNR_Haval_H9(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0439_BNR_HavaH6(TheApp.getInstance()));
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

    private void showCotrolSeat(int updateCode, int[] ints) {
        if (updateCode == 139) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !BNRActivityHavaH8SeatSetAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct");
            } else if (BNRActivityHavaH8SeatSetAct.mIsFront && BNRActivityHavaH8SeatSetAct.mInstance != null) {
                BNRActivityHavaH8SeatSetAct.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 140) {
            switch (updateCode) {
                case 139:
                    showCotrolSeat(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
