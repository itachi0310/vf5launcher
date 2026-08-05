package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class hx extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f296a;
    private final /* synthetic */ TextView b;

    hx(Launcher launcher, TextView textView) {
        this.f296a = launcher;
        this.b = textView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.setVisibility(8);
    }
}
