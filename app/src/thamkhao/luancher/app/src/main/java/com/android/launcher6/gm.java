package com.android.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class gm implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f258a;
    private boolean b = false;

    gm(Launcher launcher) {
        this.f258a = launcher;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.b) {
            return;
        }
        this.b = true;
        Launcher.as.postDelayed(this.f258a.ct, 500L);
        Launcher.as.post(new gn(this, this));
    }
}
