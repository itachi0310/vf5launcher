package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ah extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f105a = false;
    final /* synthetic */ CellLayout b;
    private final /* synthetic */ al c;
    private final /* synthetic */ View d;

    ah(CellLayout cellLayout, al alVar, View view) {
        this.b = cellLayout;
        this.c = alVar;
        this.d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f105a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f105a) {
            this.c.h = true;
            this.d.requestLayout();
        }
        if (this.b.V.containsKey(this.c)) {
            this.b.V.remove(this.c);
        }
    }
}
