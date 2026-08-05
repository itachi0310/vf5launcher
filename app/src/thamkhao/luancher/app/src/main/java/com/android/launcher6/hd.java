package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class hd extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f276a;
    private final /* synthetic */ View b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ View d;
    private final /* synthetic */ Runnable e;

    hd(Launcher launcher, View view, boolean z, View view2, Runnable runnable) {
        this.f276a = launcher;
        this.b = view;
        this.c = z;
        this.d = view2;
        this.e = runnable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.setVisibility(8);
        this.f276a.c(this.b, this.c, true);
        this.f276a.c(this.d, this.c, true);
        if (this.e != null) {
            this.e.run();
        }
        this.f276a.bA.p();
        this.f276a.bA.r();
    }
}
