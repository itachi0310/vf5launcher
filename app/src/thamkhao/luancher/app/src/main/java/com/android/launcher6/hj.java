package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f282a;
    private final /* synthetic */ int b;
    private final /* synthetic */ Runnable c;

    hj(Launcher launcher, int i, Runnable runnable) {
        this.f282a = launcher;
        this.b = i;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Launcher.as.n(this.b);
        Launcher.as.postDelayed(this.c, Launcher.an);
    }
}
