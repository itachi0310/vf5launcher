package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
abstract class io implements ValueAnimator.AnimatorUpdateListener {
    io() {
    }

    abstract void a(float f, float f2);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        a(1.0f - fFloatValue, fFloatValue);
    }
}
