package com.android.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class gn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gm f259a;
    private final /* synthetic */ ViewTreeObserver.OnDrawListener b;

    gn(gm gmVar, ViewTreeObserver.OnDrawListener onDrawListener) {
        this.f259a = gmVar;
        this.b = onDrawListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Launcher.as == null || Launcher.as.getViewTreeObserver() == null) {
            return;
        }
        Launcher.as.getViewTreeObserver().removeOnDrawListener(this.b);
    }
}
