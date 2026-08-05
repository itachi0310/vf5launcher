package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class bb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f125a;
    final /* synthetic */ ba b;

    bb(ba baVar, Runnable runnable) {
        this.b = baVar;
        this.f125a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f125a.run();
    }
}
