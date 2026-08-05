package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class bv extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DragLayer f144a;

    bv(DragLayer dragLayer) {
        this.f144a = dragLayer;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f144a.k != null) {
            this.f144a.f77a.a(this.f144a.k);
        }
        this.f144a.k = null;
        this.f144a.invalidate();
    }
}
