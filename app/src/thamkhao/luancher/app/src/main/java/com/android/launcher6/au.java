package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class au extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Cling f118a;
    private final /* synthetic */ Runnable b;

    au(Cling cling, Runnable runnable) {
        this.f118a = cling;
        this.b = runnable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f118a.setVisibility(8);
        this.b.run();
    }
}
