package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class cl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cj f156a;
    private final /* synthetic */ ValueAnimator b;

    cl(cj cjVar, ValueAnimator valueAnimator) {
        this.f156a = cjVar;
        this.b = valueAnimator;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeUpdateListener(this.f156a);
    }
}
