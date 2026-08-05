package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gz extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f271a;
    private final /* synthetic */ AppsCustomizeTabHost b;
    private final /* synthetic */ View c;
    private final /* synthetic */ boolean d;

    gz(Launcher launcher, AppsCustomizeTabHost appsCustomizeTabHost, View view, boolean z) {
        this.f271a = launcher;
        this.b = appsCustomizeTabHost;
        this.c = view;
        this.d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f271a.c(this.c, this.d, false);
        this.f271a.c((View) this.b, this.d, false);
        if (this.f271a.by != null) {
            this.f271a.by.b(false);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.b.setTranslationX(0.0f);
        this.b.setTranslationY(0.0f);
        this.b.setVisibility(0);
    }
}
