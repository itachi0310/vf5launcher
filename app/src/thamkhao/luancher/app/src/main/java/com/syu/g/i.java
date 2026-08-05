package com.syu.g;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f538a = "JLog";
    static boolean b = true;
    static i c;
    static long d;

    public i() {
        d = SystemClock.uptimeMillis();
    }

    public static i a() {
        if (c == null) {
            c = new i();
        }
        return c;
    }

    public void a(String str) {
        if (b) {
            Log.e(f538a, "=====" + str);
        }
    }
}
