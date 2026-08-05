package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class bt extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DragLayer f142a;
    private final /* synthetic */ Runnable b;
    private final /* synthetic */ int c;

    bt(DragLayer dragLayer, Runnable runnable, int i) {
        this.f142a = dragLayer;
        this.b = runnable;
        this.c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.b != null) {
            this.b.run();
        }
        switch (this.c) {
            case 0:
                this.f142a.b();
                break;
            case 1:
                this.f142a.e();
                break;
        }
    }
}
