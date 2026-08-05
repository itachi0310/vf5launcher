package com.android.launcher6;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gy implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f270a;
    private final /* synthetic */ View b;
    private final /* synthetic */ AppsCustomizeTabHost c;

    gy(Launcher launcher, View view, AppsCustomizeTabHost appsCustomizeTabHost) {
        this.f270a = launcher;
        this.b = view;
        this.c = appsCustomizeTabHost;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            throw new RuntimeException("animation is null");
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f270a.b(this.b, fFloatValue);
        this.f270a.b(this.c, fFloatValue);
    }
}
