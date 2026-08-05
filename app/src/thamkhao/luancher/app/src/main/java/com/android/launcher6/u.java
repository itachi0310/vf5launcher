package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f465a;

    u(t tVar) {
        this.f465a = tVar;
    }

    private void a() {
        this.f465a.f464a.e.setVisibility(8);
        PagedViewWidget.setRecyclePreviewsWhenDetachedFromWindow(false);
        this.f465a.f464a.e.removeAllViews();
        PagedViewWidget.setRecyclePreviewsWhenDetachedFromWindow(true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        a();
    }
}
