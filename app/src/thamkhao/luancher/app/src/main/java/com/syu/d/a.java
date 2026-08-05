package com.syu.d;

import android.os.Handler;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class a {
    static a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f518a;
    TextView b;
    Handler c;
    StringBuffer d;

    public static void b(String str) {
        if (e == null) {
            return;
        }
        e.a(str);
    }

    public void a(String str) {
        if (this.f518a) {
            if (this.d.length() >= 20480) {
                this.d.replace(0, 4096, "");
            }
            this.d.append(String.valueOf(str) + "\n");
            this.c.post(new b(this));
        }
    }
}
