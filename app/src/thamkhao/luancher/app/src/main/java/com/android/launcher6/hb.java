package com.android.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class hb implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f274a;
    private final /* synthetic */ Runnable b;
    private final /* synthetic */ AppsCustomizeTabHost c;

    hb(Launcher launcher, Runnable runnable, AppsCustomizeTabHost appsCustomizeTabHost) {
        this.f274a = launcher;
        this.b = runnable;
        this.c = appsCustomizeTabHost;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.b.run();
        this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
