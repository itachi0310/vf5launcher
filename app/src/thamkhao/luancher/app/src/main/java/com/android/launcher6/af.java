package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class af extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CellLayout f103a;
    private final /* synthetic */ ea b;

    af(CellLayout cellLayout, ea eaVar) {
        this.f103a = cellLayout;
        this.b = eaVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (((Float) ((ValueAnimator) animator).getAnimatedValue()).floatValue() == 0.0f) {
            this.b.a((Object) null);
        }
    }
}
