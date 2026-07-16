package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_TD_LandRover_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class Callback_0453_TD_LandRover_All extends CallbackCanbusBase {
    public static final int U_CARSET_D07_D0_B01 = 295;
    public static final int U_CARSET_D07_D0_B23 = 296;
    public static final int U_CARSET_D07_D0_B45 = 297;
    public static final int U_CARSET_D07_D0_B67 = 298;
    public static final int U_CARSET_D07_D1_B01 = 299;
    public static final int U_CARSET_D07_D1_B23 = 300;
    public static final int U_CARSET_D07_D1_B45 = 301;
    public static final int U_CARSET_D07_D1_B67 = 302;
    public static final int U_CARSET_D07_D2_B01 = 111;
    public static final int U_CARSET_D07_D2_B23 = 112;
    public static final int U_CARSET_D07_D2_B45 = 113;
    public static final int U_CARSET_D07_D2_B67 = 114;
    public static final int U_CARSET_D07_D3_B02 = 115;
    public static final int U_CARSET_D07_D3_B3 = 116;
    public static final int U_CARSET_D07_D3_B46 = 117;
    public static final int U_CARSET_D07_D3_B7 = 118;
    public static final int U_CARSET_D07_D4_B02 = 119;
    public static final int U_CARSET_D07_D4_B46 = 120;
    public static final int U_CARSET_D07_D5_B02 = 121;
    public static final int U_CARSET_D07_D5_B3 = 122;
    public static final int U_CARSET_D07_D5_B46 = 123;
    public static final int U_CARSET_D07_D5_B7 = 124;
    public static final int U_CARSET_D07_D6_B02 = 125;
    public static final int U_CARSET_D07_D6_B46 = 126;
    public static final int U_CARSET_D07_D7_B06 = 127;
    public static final int U_CARSET_D07_D7_B7 = 128;
    public static final int U_CARSET_D08_D3_B7 = 304;
    public static final int U_CARSET_D08_D6_B60 = 305;
    public static final int U_CARSET_D0A_D1_D2 = 303;
    public static final int U_CARSET_D0B_D0_B0 = 94;
    public static final int U_CARSET_D0B_D0_B1 = 95;
    public static final int U_CARSET_D0B_D0_B23 = 96;
    public static final int U_CARSET_D0B_D0_B45 = 97;
    public static final int U_CARSET_D0B_D0_B67 = 98;
    public static final int U_CARSET_D0B_D1_B01 = 99;
    public static final int U_CARSET_D0B_D1_B23 = 100;
    public static final int U_CARSET_D0B_D1_B7 = 101;
    public static final int U_CARSET_D0B_D2_B0 = 102;
    public static final int U_CARSET_D0B_D2_B1 = 103;
    public static final int U_CARSET_D0B_D2_B2 = 104;
    public static final int U_CARSET_D0B_D2_B3 = 105;
    public static final int U_CARSET_D0B_D2_B4 = 106;
    public static final int U_CARSET_D0B_D2_B5 = 107;
    public static final int U_CARSET_D0B_D2_B6 = 108;
    public static final int U_CARSET_D0B_D2_B7 = 109;
    public static final int U_CARSET_D0B_D3_B0 = 110;
    public static final int U_CARSET_D35_D2_D3 = 129;
    public static final int U_CARSET_D35_D7_D10 = 130;
    public static final int U_CARSET_D36_D0_B30 = 307;
    public static final int U_CARSET_D36_D0_B74 = 306;
    public static final int U_CARSET_D37_D0_D1 = 131;
    public static final int U_CARSET_D37_D2_D3 = 132;
    public static final int U_CARSET_D37_D4_D5 = 133;
    public static final int U_CARSET_D38_D0_B70 = 134;
    public static final int U_CARSET_D38_D10_B30 = 157;
    public static final int U_CARSET_D38_D10_B74 = 156;
    public static final int U_CARSET_D38_D11_B30 = 162;
    public static final int U_CARSET_D38_D11_B4 = 161;
    public static final int U_CARSET_D38_D11_B5 = 160;
    public static final int U_CARSET_D38_D11_B6 = 159;
    public static final int U_CARSET_D38_D11_B7 = 158;
    public static final int U_CARSET_D38_D12_B3 = 165;
    public static final int U_CARSET_D38_D12_B54 = 164;
    public static final int U_CARSET_D38_D12_B76 = 163;
    public static final int U_CARSET_D38_D1_B10 = 140;
    public static final int U_CARSET_D38_D1_B2 = 139;
    public static final int U_CARSET_D38_D1_B3 = 138;
    public static final int U_CARSET_D38_D1_B54 = 137;
    public static final int U_CARSET_D38_D1_B6 = 136;
    public static final int U_CARSET_D38_D1_B7 = 135;
    public static final int U_CARSET_D38_D2_B1 = 147;
    public static final int U_CARSET_D38_D2_B2 = 146;
    public static final int U_CARSET_D38_D2_B3 = 145;
    public static final int U_CARSET_D38_D2_B4 = 144;
    public static final int U_CARSET_D38_D2_B5 = 143;
    public static final int U_CARSET_D38_D2_B6 = 142;
    public static final int U_CARSET_D38_D2_B7 = 141;
    public static final int U_CARSET_D38_D3_B70 = 148;
    public static final int U_CARSET_D38_D4_B30 = 150;
    public static final int U_CARSET_D38_D4_B74 = 149;
    public static final int U_CARSET_D38_D5_B70 = 151;
    public static final int U_CARSET_D38_D6_B70 = 152;
    public static final int U_CARSET_D38_D7_B70 = 153;
    public static final int U_CARSET_D38_D8_B70 = 154;
    public static final int U_CARSET_D38_D9_B70 = 155;
    public static final int U_CARSET_D65_D0_B2 = 171;
    public static final int U_CARSET_D65_D0_B3 = 170;
    public static final int U_CARSET_D65_D0_B4 = 169;
    public static final int U_CARSET_D65_D0_B5 = 168;
    public static final int U_CARSET_D65_D0_B6 = 167;
    public static final int U_CARSET_D65_D0_B7 = 166;
    public static final int U_CARSET_D65_D1_B4 = 175;
    public static final int U_CARSET_D65_D1_B5 = 174;
    public static final int U_CARSET_D65_D1_B6 = 173;
    public static final int U_CARSET_D65_D1_B7 = 172;
    public static final int U_CARSET_D65_D2_B70 = 176;
    public static final int U_CARSET_D66_D0_B50 = 177;
    public static final int U_CARSET_D66_D1_B50 = 178;
    public static final int U_CARSET_D66_D2_B50 = 179;
    public static final int U_CARSET_D66_D3_B60 = 181;
    public static final int U_CARSET_D66_D3_B7 = 180;
    public static final int U_CARSET_D66_D4_B50 = 182;
    public static final int U_CARSET_D66_D5_B50 = 183;
    public static final int U_CARSET_D66_D6_B50 = 184;
    public static final int U_CARSET_D67_D0_B32 = 188;
    public static final int U_CARSET_D67_D0_B4 = 187;
    public static final int U_CARSET_D67_D0_B5 = 186;
    public static final int U_CARSET_D67_D0_B6 = 185;
    public static final int U_CARSET_D67_D0_D1_D2 = 189;
    public static final int U_CARSET_D67_D10_B50 = 194;
    public static final int U_CARSET_D67_D11_B50 = 195;
    public static final int U_CARSET_D67_D12_B50 = 196;
    public static final int U_CARSET_D67_D13_B60 = 197;
    public static final int U_CARSET_D67_D14_D15 = 198;
    public static final int U_CARSET_D67_D3_B71 = 190;
    public static final int U_CARSET_D67_D4_1B70 = 191;
    public static final int U_CARSET_D67_D5_D6 = 192;
    public static final int U_CARSET_D67_D7_D8_D9 = 193;
    public static final int U_CARSET_D68_D0_B32 = 201;
    public static final int U_CARSET_D68_D0_B4 = 200;
    public static final int U_CARSET_D68_D0_B5 = 199;
    public static final int U_CARSET_D68_D0_D1_D2 = 202;
    public static final int U_CARSET_D68_D10_B50 = 207;
    public static final int U_CARSET_D68_D11_B50 = 208;
    public static final int U_CARSET_D68_D12_B50 = 209;
    public static final int U_CARSET_D68_D13_B60 = 210;
    public static final int U_CARSET_D68_D14_B30 = 211;
    public static final int U_CARSET_D68_D15_B50 = 212;
    public static final int U_CARSET_D68_D16_B50 = 213;
    public static final int U_CARSET_D68_D17_B50 = 214;
    public static final int U_CARSET_D68_D3_B71 = 203;
    public static final int U_CARSET_D68_D4_1B70 = 204;
    public static final int U_CARSET_D68_D5_D6 = 205;
    public static final int U_CARSET_D68_D7_D8_D9 = 206;
    public static final int U_CARSET_D69_D0_B32 = 217;
    public static final int U_CARSET_D69_D0_B4 = 216;
    public static final int U_CARSET_D69_D0_B5 = 215;
    public static final int U_CARSET_D69_D0_D1_D2 = 218;
    public static final int U_CARSET_D69_D10_B50 = 223;
    public static final int U_CARSET_D69_D11_B50 = 224;
    public static final int U_CARSET_D69_D12_B50 = 225;
    public static final int U_CARSET_D69_D13_B60 = 226;
    public static final int U_CARSET_D69_D14_B30 = 227;
    public static final int U_CARSET_D69_D15_B50 = 228;
    public static final int U_CARSET_D69_D16_B50 = 229;
    public static final int U_CARSET_D69_D17_B50 = 230;
    public static final int U_CARSET_D69_D3_B71 = 219;
    public static final int U_CARSET_D69_D4_1B70 = 220;
    public static final int U_CARSET_D69_D5_D6 = 221;
    public static final int U_CARSET_D69_D7_D8_D9 = 222;
    public static final int U_CARSET_D6A_D0_B32 = 233;
    public static final int U_CARSET_D6A_D0_B4 = 232;
    public static final int U_CARSET_D6A_D0_B5 = 231;
    public static final int U_CARSET_D6A_D0_D1_D2 = 234;
    public static final int U_CARSET_D6A_D10_B50 = 239;
    public static final int U_CARSET_D6A_D11_B50 = 240;
    public static final int U_CARSET_D6A_D12_B50 = 241;
    public static final int U_CARSET_D6A_D13_B60 = 242;
    public static final int U_CARSET_D6A_D14_B30 = 243;
    public static final int U_CARSET_D6A_D15_B50 = 244;
    public static final int U_CARSET_D6A_D16_B50 = 245;
    public static final int U_CARSET_D6A_D17_B50 = 246;
    public static final int U_CARSET_D6A_D3_B71 = 235;
    public static final int U_CARSET_D6A_D4_1B70 = 236;
    public static final int U_CARSET_D6A_D5_D6 = 237;
    public static final int U_CARSET_D6A_D7_D8_D9 = 238;
    public static final int U_CARSET_D6B_D0_B32 = 249;
    public static final int U_CARSET_D6B_D0_B4 = 248;
    public static final int U_CARSET_D6B_D0_B5 = 247;
    public static final int U_CARSET_D6B_D0_D1_D2 = 250;
    public static final int U_CARSET_D6B_D10_B50 = 255;
    public static final int U_CARSET_D6B_D11_B50 = 256;
    public static final int U_CARSET_D6B_D12_B50 = 257;
    public static final int U_CARSET_D6B_D13_B60 = 258;
    public static final int U_CARSET_D6B_D14_B30 = 259;
    public static final int U_CARSET_D6B_D15_B50 = 260;
    public static final int U_CARSET_D6B_D16_B50 = 261;
    public static final int U_CARSET_D6B_D17_B50 = 262;
    public static final int U_CARSET_D6B_D3_B71 = 251;
    public static final int U_CARSET_D6B_D4_1B70 = 252;
    public static final int U_CARSET_D6B_D5_D6 = 253;
    public static final int U_CARSET_D6B_D7_D8_D9 = 254;
    public static final int U_CARSET_D6C_D0_B32 = 265;
    public static final int U_CARSET_D6C_D0_B4 = 264;
    public static final int U_CARSET_D6C_D0_B5 = 263;
    public static final int U_CARSET_D6C_D0_D1_D2 = 266;
    public static final int U_CARSET_D6C_D10_B50 = 271;
    public static final int U_CARSET_D6C_D11_B50 = 272;
    public static final int U_CARSET_D6C_D12_B50 = 273;
    public static final int U_CARSET_D6C_D13_B60 = 274;
    public static final int U_CARSET_D6C_D14_B30 = 275;
    public static final int U_CARSET_D6C_D15_B50 = 276;
    public static final int U_CARSET_D6C_D16_B50 = 277;
    public static final int U_CARSET_D6C_D17_B50 = 278;
    public static final int U_CARSET_D6C_D3_B71 = 267;
    public static final int U_CARSET_D6C_D4_1B70 = 268;
    public static final int U_CARSET_D6C_D5_D6 = 269;
    public static final int U_CARSET_D6C_D7_D8_D9 = 270;
    public static final int U_CARSET_D6D_D0_B32 = 281;
    public static final int U_CARSET_D6D_D0_B4 = 280;
    public static final int U_CARSET_D6D_D0_B5 = 279;
    public static final int U_CARSET_D6D_D0_D1_D2 = 282;
    public static final int U_CARSET_D6D_D10_B50 = 287;
    public static final int U_CARSET_D6D_D11_B50 = 288;
    public static final int U_CARSET_D6D_D12_B50 = 289;
    public static final int U_CARSET_D6D_D13_B60 = 290;
    public static final int U_CARSET_D6D_D14_B30 = 291;
    public static final int U_CARSET_D6D_D15_B50 = 292;
    public static final int U_CARSET_D6D_D16_B50 = 293;
    public static final int U_CARSET_D6D_D17_B50 = 294;
    public static final int U_CARSET_D6D_D3_B71 = 283;
    public static final int U_CARSET_D6D_D4_1B70 = 284;
    public static final int U_CARSET_D6D_D5_D6 = 285;
    public static final int U_CARSET_D6D_D7_D8_D9 = 286;
    public static final int U_CNT_MAX = 308;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 308; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0453_TD_LandRover_All(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 308) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
