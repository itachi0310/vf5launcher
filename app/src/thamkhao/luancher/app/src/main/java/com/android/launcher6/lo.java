package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class lo extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ln f379a;

    lo(ln lnVar) {
        this.f379a = lnVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f379a.f378a.aR = false;
        this.f379a.f378a.K();
        this.f379a.f378a.E();
    }
}
