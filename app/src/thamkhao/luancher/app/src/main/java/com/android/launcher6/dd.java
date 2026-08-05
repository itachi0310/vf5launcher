package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class dd implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ da f174a;
    private final /* synthetic */ int b;

    dd(da daVar, int i) {
        this.f174a = daVar;
        this.b = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f174a.c = (((1.0f - fFloatValue) * 0.3f) + 1.0f) * this.b;
        this.f174a.d = (((1.0f - fFloatValue) * 0.15f) + 1.0f) * this.b;
        if (this.f174a.j != null) {
            this.f174a.j.invalidate();
        }
    }
}
