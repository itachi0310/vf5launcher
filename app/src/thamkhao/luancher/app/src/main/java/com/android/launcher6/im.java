package com.android.launcher6;

import android.animation.Animator;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class im implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f308a = false;
    private final /* synthetic */ Animator b;
    private final /* synthetic */ View c;

    im(Animator animator, View view) {
        this.b = animator;
        this.c = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.f308a) {
            return;
        }
        this.f308a = true;
        if (this.b.getDuration() != 0) {
            this.b.start();
            this.c.post(new in(this, this.c, this));
        }
    }
}
