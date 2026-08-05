package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class lm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ li f377a;
    private final /* synthetic */ Runnable b;

    lm(li liVar, Runnable runnable) {
        this.f377a = liVar;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.run();
        this.f377a.C();
    }
}
