package com.android.launcher6;

import android.animation.Animator;

/* JADX INFO: loaded from: classes.dex */
class nh implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ng f413a;

    nh(ng ngVar) {
        this.f413a = ngVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f413a.b.j.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
