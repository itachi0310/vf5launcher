package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class bu implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DragLayer f143a;

    bu(DragLayer dragLayer) {
        this.f143a = dragLayer;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f143a.k.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
