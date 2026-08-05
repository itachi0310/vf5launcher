package com.android.launcher6;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f193a;
    private float b;
    private float c;
    private ValueAnimator d;
    private boolean e = true;
    private Object f = null;
    private int g = 0;

    public ea(View view, long j, float f, float f2) {
        this.d = ik.a(view, f, f2).setDuration(j);
        this.f193a = j;
        this.b = f;
        this.c = f2;
        this.d.addListener(new eb(this));
    }

    private void a(int i) {
        long currentPlayTime = this.d.getCurrentPlayTime();
        float f = i == 1 ? this.c : this.b;
        float fFloatValue = this.e ? this.b : ((Float) this.d.getAnimatedValue()).floatValue();
        a();
        this.g = i;
        this.d.setDuration(Math.max(0L, Math.min(this.f193a - currentPlayTime, this.f193a)));
        this.d.setFloatValues(fFloatValue, f);
        this.d.start();
        this.e = false;
    }

    public void a() {
        this.d.cancel();
        this.g = 0;
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public void b() {
        a(1);
    }

    public void c() {
        a(2);
    }

    public Object d() {
        return this.f;
    }

    public ValueAnimator e() {
        return this.d;
    }
}
