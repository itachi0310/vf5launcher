package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class de extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ da f175a;

    de(da daVar) {
        this.f175a = daVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f175a.j != null) {
            this.f175a.j.b(this.f175a);
        }
        if (this.f175a.e != null) {
            this.f175a.e.i.setVisibility(0);
        }
    }
}
