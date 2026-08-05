package com.android.launcher6;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class in implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ im f309a;
    private final /* synthetic */ View b;
    private final /* synthetic */ ViewTreeObserver.OnDrawListener c;

    in(im imVar, View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        this.f309a = imVar;
        this.b = view;
        this.c = onDrawListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.getViewTreeObserver().removeOnDrawListener(this.c);
    }
}
