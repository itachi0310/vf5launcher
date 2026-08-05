package com.android.launcher17;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
abstract class LauncherAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    abstract void onAnimationUpdate(float f, float f2);

    LauncherAnimatorUpdateListener() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        float b = ((Float) animation.getAnimatedValue()).floatValue();
        float a = 1.0f - b;
        onAnimationUpdate(a, b);
    }
}
