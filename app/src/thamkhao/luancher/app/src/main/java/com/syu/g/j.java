package com.syu.g;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static boolean a(int[] iArr, int i) {
        return (iArr == null || iArr.length == 0 || iArr.length < i) ? false : true;
    }

    public static boolean a(String[] strArr, int i) {
        return (strArr == null || strArr.length == 0 || strArr.length < i) ? false : true;
    }
}
