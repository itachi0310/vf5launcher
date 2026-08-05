package com.android.launcher6;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class mr implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f398a = 1.3f;

    public void a() {
        this.f398a = 0.0f;
    }

    public void a(int i) {
        this.f398a = i > 0 ? 1.3f / i : 1.3f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.f398a + 1.0f)) + this.f398a) * f2 * f2) + 1.0f;
    }
}
