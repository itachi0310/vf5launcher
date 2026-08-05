package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class db implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ da f172a;
    private final /* synthetic */ int b;

    db(da daVar, int i) {
        this.f172a = daVar;
        this.b = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f172a.c = ((0.3f * fFloatValue) + 1.0f) * this.b;
        this.f172a.d = ((fFloatValue * 0.15f) + 1.0f) * this.b;
        if (this.f172a.j != null) {
            this.f172a.j.invalidate();
        }
    }
}
