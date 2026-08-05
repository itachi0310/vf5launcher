package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f284a;
    private final /* synthetic */ it b;

    hl(Launcher launcher, it itVar) {
        this.f284a = launcher;
        this.b = itVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f284a.b(this.b);
    }
}
