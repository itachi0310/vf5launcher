package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class cs extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Folder f162a;

    cs(Folder folder) {
        this.f162a = folder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f162a.u();
        this.f162a.setLayerType(0, null);
        this.f162a.n = 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f162a.a(32, this.f162a.getContext().getString(R.string.folder_closed));
        this.f162a.n = 1;
    }
}
