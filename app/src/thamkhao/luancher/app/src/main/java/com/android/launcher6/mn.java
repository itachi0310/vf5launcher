package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class mn extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchDropTargetBar f394a;
    private final /* synthetic */ View b;

    mn(SearchDropTargetBar searchDropTargetBar, View view) {
        this.f394a = searchDropTargetBar;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.setLayerType(0, null);
    }
}
