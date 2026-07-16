package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0080_RZC_TianLai;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_RZC_QiJun;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0080_RZC_XP1_QiJun extends CallbackCanbusBase {
    public static final int U_CARINF_D38_D4_B70 = 119;
    public static final int U_CARINF_D38_D5_B70 = 120;
    public static final int U_CARINF_D38_D6_B70 = 121;
    public static final int U_CARINF_D38_D7_B70 = 122;
    public static final int U_CARINF_D41_D0_B5 = 112;
    public static final int U_CARINF_D41_D0_B6 = 111;
    public static final int U_CARINF_D41_D0_B7 = 110;
    public static final int U_CARINF_D41_D12_D13 = 118;
    public static final int U_CARINF_D41_D1_D2 = 113;
    public static final int U_CARINF_D41_D3_D4 = 114;
    public static final int U_CARINF_D41_D5_D6 = 115;
    public static final int U_CARINF_D41_D7_D8 = 116;
    public static final int U_CARINF_D41_D9_D11 = 117;
    public static final int U_CNT_MAX = 123;
    public static final int U_JUMP_SOS_PAGE = 108;
    public static final int U_PARK_BTN = 96;
    public static final int U_PARK_CAMERA = 97;
    public static final int U_PARK_PAGE = 95;
    public static final int U_PARK_TXTMSG = 94;
    public static final int U_SETTING_93D0 = 109;
    public static final int U_SETTING_93D1 = 104;
    public static final int U_SETTING_93D2 = 105;
    public static final int U_SETTING_93D3 = 106;
    public static final int U_SETTING_93D4 = 107;
    public static final int U_SETTING_93D5 = 99;
    public static final int U_SETTING_93D6 = 100;
    public static final int U_SETTING_93D7 = 101;
    public static final int U_SETTING_93D8 = 102;
    public static final int U_SETTING_BEGIN = 98;
    public static final int U_SETTING_LANGUAGE = 103;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0080_RZC_TianLai(TheApp.getInstance()));
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (458832 == DataCanbus.DATA[1000]) {
            ParkingHelper.getInstance().buildUi(new Parking_RZC_QiJun(TheApp.getInstance()));
            DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
            for (int i4 = 94; i4 <= 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(ParkingHelper.getInstance(), 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        if (458832 == DataCanbus.DATA[1000]) {
            for (int i = 94; i <= 97; i++) {
                DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
            }
            DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
            ParkingHelper.getInstance().destroyUi();
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        for (int i3 = 10; i3 < 93; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 108) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 123) {
            switch (updateCode) {
                case 108:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 213) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
