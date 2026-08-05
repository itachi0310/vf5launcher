package com.syu.jni;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ToolsJni {
    public static int cmd_104_write_gamma(byte[] bArr) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("param0", bArr);
        return SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_104_WRITE_GAMMA, bundle, null);
    }

    public static int cmd_105_set_bl_adj(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_105_SET_BL_ADJ, bundle, null);
    }

    public static int[] cmd_109_get_bl_limit() {
        int[] iArr = new int[3];
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_109_GET_BL_DUTY, null, bundle);
        if (bundle != null) {
            iArr[0] = bundle.getInt("param0", 0);
            iArr[1] = bundle.getInt("param1", 0);
            iArr[2] = bundle.getInt("param2", 0);
        }
        return iArr;
    }

    public static int cmd_10_little_hom(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(10, bundle, null);
    }

    public static int cmd_110_set_bl_limit(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        bundle.putInt("param1", i2);
        return SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_110_SET_BL_DUTY, bundle, null);
    }

    public static int cmd_11_video_ntsc_pal(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(11, bundle, null);
    }

    public static int cmd_12_get_usb_speed() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(12, null, bundle);
        if (bundle != null) {
            return bundle.getInt("param0", 0);
        }
        return 0;
    }

    public static int cmd_13_write_usb_speed(int i) {
        Bundle bundle = new Bundle();
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(13, bundle, null);
    }

    public static int cmd_14_set_backcar_type(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 1;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(14, bundle, null);
    }

    public static int cmd_15_get_backcar_type() {
        Bundle bundle = new Bundle();
        try {
            if (!SyuJniNative.bLoadLibOk) {
                return 0;
            }
            SyuJniNative.getInstance().syu_jni_command(15, null, bundle);
            if (bundle != null) {
                return bundle.getInt("param0", 0);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int cmd_16_set_led_colors(int i, int i2) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        bundle.putInt("param1", i2);
        return SyuJniNative.getInstance().syu_jni_command(16, bundle, null);
    }

    public static int cmd_17_get_led_colors() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(17, null, bundle);
        if (bundle != null) {
            return bundle.getInt("param0", 0);
        }
        return 0;
    }

    public static int cmd_1_backcarMirror(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(1, bundle, null);
    }

    public static int cmd_27_set_bl_param(int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("param3", i);
        bundle.putInt("param4", i2);
        bundle.putInt("param5", i3);
        return SyuJniNative.getInstance().syu_jni_command(27, bundle, null);
    }

    public static int[] cmd_28_get_bl_param() {
        int[] iArr = new int[6];
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(28, null, bundle);
        if (bundle != null) {
            iArr[0] = bundle.getInt("param0");
            iArr[1] = bundle.getInt("param1");
            iArr[2] = bundle.getInt("param2");
            iArr[3] = bundle.getInt("param3");
            iArr[4] = bundle.getInt("param4");
            iArr[5] = bundle.getInt("param5");
        }
        return iArr;
    }

    public static int cmd_2_soundMix(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(2, bundle, null);
    }

    public static int cmd_3_encarption_result() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(3, null, bundle);
        if (bundle != null) {
            return bundle.getInt("param0", 1);
        }
        return 0;
    }

    public static int cmd_4_audio_state() {
        if (!SyuJniNative.bLoadLibOk) {
            return 1;
        }
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(4, null, bundle);
        if (bundle != null) {
            return bundle.getInt("param0", 0);
        }
        return 1;
    }

    public static int cmd_5_turnoff_lcdc(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(5, bundle, null);
    }

    public static int cmd_6_mute_amp(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(6, bundle, null);
    }

    public static int cmd_7_get_amp_state() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(7, null, bundle);
        if (bundle != null) {
            return bundle.getInt("param0", 0);
        }
        return 0;
    }

    public static int cmd_8_reset_gps() {
        if (SyuJniNative.bLoadLibOk) {
            return SyuJniNative.getInstance().syu_jni_command(8, null, null);
        }
        return 0;
    }

    public static int cmd_9_poweron_screen(int i) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param0", i);
        return SyuJniNative.getInstance().syu_jni_command(9, bundle, null);
    }

    public static int testJni() {
        int iSyu_jni_command = 0;
        if (SyuJniNative.bLoadLibOk) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            bundle.putInt("test_param", 100);
            iSyu_jni_command = SyuJniNative.getInstance().syu_jni_command(0, bundle, bundle2);
            if (bundle2 != null) {
                bundle2.getDouble("test_param");
            }
        }
        return iSyu_jni_command;
    }
}
