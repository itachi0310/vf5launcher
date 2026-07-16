package com.syu.util;

/* JADX INFO: loaded from: classes.dex */
public class ToolkitMath {
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }
}
