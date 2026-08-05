package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f115a;
    private boolean b;
    private as c;

    public ar(View view) {
        this.f115a = view;
    }

    public void a() {
        this.b = false;
        if (this.c == null) {
            this.c = new as(this);
        }
        this.f115a.postDelayed(this.c, ip.a().l());
    }

    public void b() {
        this.b = false;
        if (this.c != null) {
            this.f115a.removeCallbacks(this.c);
            this.c = null;
        }
    }

    public boolean c() {
        return this.b;
    }
}
