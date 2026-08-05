package com.android.launcher6;

import android.animation.Animator;

/* JADX INFO: loaded from: classes.dex */
class il implements Animator.AnimatorListener {
    il() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ik.f307a.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ik.f307a.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ik.f307a.add(animator);
    }
}
