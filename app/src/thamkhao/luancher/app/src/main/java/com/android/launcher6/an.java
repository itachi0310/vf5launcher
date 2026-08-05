package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class an implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ am f111a;

    an(am amVar) {
        this.f111a = amVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = (this.f111a.b * fFloatValue) + ((1.0f - fFloatValue) * this.f111a.d);
        float f2 = (this.f111a.c * fFloatValue) + ((1.0f - fFloatValue) * this.f111a.e);
        this.f111a.f110a.setTranslationX(f);
        this.f111a.f110a.setTranslationY(f2);
        float f3 = ((1.0f - fFloatValue) * this.f111a.g) + (this.f111a.f * fFloatValue);
        this.f111a.f110a.setScaleX(f3);
        this.f111a.f110a.setScaleY(f3);
    }
}
