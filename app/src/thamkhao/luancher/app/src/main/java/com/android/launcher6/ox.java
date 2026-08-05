package com.android.launcher6;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ox implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f451a;

    public ox(View view) {
        this.f451a = view;
    }

    public static void a(View view) {
        int i = Workspace.aE ? 8 : 4;
        if (view.getAlpha() < 0.01f && view.getVisibility() != i) {
            view.setVisibility(i);
        } else {
            if (view.getAlpha() <= 0.01f || view.getVisibility() == 0) {
                return;
            }
            view.setVisibility(0);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        a(this.f451a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f451a.setVisibility(0);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        a(this.f451a);
    }
}
