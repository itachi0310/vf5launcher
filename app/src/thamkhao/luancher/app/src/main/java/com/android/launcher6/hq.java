package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f289a;

    hq(Launcher launcher) {
        this.f289a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f289a.setRequestedOrientation(-1);
    }
}
