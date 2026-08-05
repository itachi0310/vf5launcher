package com.syu.jni;

/* JADX INFO: loaded from: classes.dex */
public class CurrentMethod {
    static final boolean bDebug = false;

    public static void gotoAdjustMode(boolean z) {
        try {
            ToolsJni.cmd_105_set_bl_adj(z ? 1 : 0);
        } catch (Exception e) {
        }
    }

    public static int[] readBlLimit() {
        int[] iArr = new int[3];
        try {
            return ToolsJni.cmd_109_get_bl_limit();
        } catch (Exception e) {
            return iArr;
        }
    }

    public static void setBlLimit(int i, int i2) {
        try {
            ToolsJni.cmd_110_set_bl_limit(i2, i);
        } catch (Exception e) {
        }
    }
}
