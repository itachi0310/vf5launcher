package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0424_XP_Renault_Dacia;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0424_XP_KeLeiAo extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 94;
    public static final int U_CARINFO_CAR_LANG = 101;
    public static final int U_CARINFO_CAR_PARK = 102;
    public static final int U_CARINFO_END = 103;
    public static final int U_CARINFO_MILE_UNIT = 95;
    public static final int U_CARINFO_OIL_AVG = 97;
    public static final int U_CARINFO_OIL_UNIT = 96;
    public static final int U_CARINFO_SPEED_AVG = 100;
    public static final int U_CARINFO_TOTAL_MILE = 98;
    public static final int U_CARINFO_TOTAL_OIL = 99;
    public static final int U_CARSET_D17_D1_B70 = 151;
    public static final int U_CARSET_D17_D2_B70 = 152;
    public static final int U_CARSET_D17_D3_B70 = 153;
    public static final int U_CARSET_D17_D4_B70 = 154;
    public static final int U_CARSET_D17_D5_B70 = 155;
    public static final int U_CARSET_D17_D7_B54 = 157;
    public static final int U_CARSET_D17_D7_B7 = 156;
    public static final int U_CARSET_D40_D0_B70 = 105;
    public static final int U_CARSET_D40_D1_B0 = 131;
    public static final int U_CARSET_D40_D1_B1 = 111;
    public static final int U_CARSET_D40_D1_B2 = 110;
    public static final int U_CARSET_D40_D1_B3 = 109;
    public static final int U_CARSET_D40_D1_B4 = 108;
    public static final int U_CARSET_D40_D1_B5 = 107;
    public static final int U_CARSET_D40_D1_B76 = 106;
    public static final int U_CARSET_D40_D2_B0 = 117;
    public static final int U_CARSET_D40_D2_B1 = 116;
    public static final int U_CARSET_D40_D2_B2 = 115;
    public static final int U_CARSET_D40_D2_B3 = 114;
    public static final int U_CARSET_D40_D2_B54 = 113;
    public static final int U_CARSET_D40_D2_B76 = 112;
    public static final int U_CARSET_D40_D3_B0 = 122;
    public static final int U_CARSET_D40_D3_B1 = 121;
    public static final int U_CARSET_D40_D3_B2 = 120;
    public static final int U_CARSET_D40_D3_B3 = 134;
    public static final int U_CARSET_D40_D3_B4 = 133;
    public static final int U_CARSET_D40_D3_B5 = 132;
    public static final int U_CARSET_D40_D3_B6 = 119;
    public static final int U_CARSET_D40_D3_B7 = 118;
    public static final int U_CARSET_D40_D4_B0 = 137;
    public static final int U_CARSET_D40_D4_B1 = 136;
    public static final int U_CARSET_D40_D4_B32 = 135;
    public static final int U_CARSET_D40_D4_B4 = 126;
    public static final int U_CARSET_D40_D4_B5 = 125;
    public static final int U_CARSET_D40_D4_B6 = 124;
    public static final int U_CARSET_D40_D4_B7 = 123;
    public static final int U_CARSET_D40_D5_B0 = 130;
    public static final int U_CARSET_D40_D5_B21 = 139;
    public static final int U_CARSET_D40_D5_B4 = 138;
    public static final int U_CARSET_D40_D5_B5 = 129;
    public static final int U_CARSET_D40_D5_B6 = 128;
    public static final int U_CARSET_D40_D5_B7 = 127;
    public static final int U_CARSET_D60_D0_B70 = 140;
    public static final int U_CARSET_D60_D1_B10 = 144;
    public static final int U_CARSET_D60_D1_B32 = 143;
    public static final int U_CARSET_D60_D1_B54 = 142;
    public static final int U_CARSET_D60_D1_B76 = 141;
    public static final int U_CARSET_D60_D2_B1 = 148;
    public static final int U_CARSET_D60_D2_B2 = 147;
    public static final int U_CARSET_D60_D2_B3 = 146;
    public static final int U_CARSET_D60_D2_B74 = 145;
    public static final int U_CARSET_D60_D3_B70 = 149;
    public static final int U_CARSET_D60_D4_B76 = 150;
    public static final int U_CARSET_D61_D0_B30 = 159;
    public static final int U_CARSET_D61_D0_B74 = 158;
    public static final int U_CARSET_D61_D1_B70 = 160;
    public static final int U_CARSET_D61_D2_B7 = 161;
    public static final int U_CNT_MAX = 162;
    public static final int U_JUMP_SOS_PAGE = 104;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 162; i++) {
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
        if (DataCanbus.DATA[1000] != 917928 && DataCanbus.DATA[1000] != 983464) {
            AirHelper.getInstance().buildUi(new Air_0424_XP_Renault_Dacia(TheApp.getInstance()));
            for (int i3 = 10; i3 < 93; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
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

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 104) {
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
        switch (updateCode) {
            case 104:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 162) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
                break;
        }
    }
}
