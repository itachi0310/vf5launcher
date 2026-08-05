package com.android.launcher6;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class hc implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f275a;
    private final /* synthetic */ View b;
    private final /* synthetic */ View c;

    hc(Launcher launcher, View view, View view2) {
        this.f275a = launcher;
        this.b = view;
        this.c = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = 1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f275a.b(this.b, fFloatValue);
        this.f275a.b(this.c, fFloatValue);
    }
}
