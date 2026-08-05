package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class ao extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ am f112a;

    ao(am amVar) {
        this.f112a = amVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f112a.d = 0.0f;
        this.f112a.e = 0.0f;
        this.f112a.g = this.f112a.i.getChildrenScale();
    }
}
