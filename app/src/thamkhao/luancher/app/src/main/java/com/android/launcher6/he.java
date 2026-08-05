package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class he implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f277a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ Runnable c;

    he(Launcher launcher, boolean z, Runnable runnable) {
        this.f277a = launcher;
        this.b = z;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.b) {
            this.f277a.L();
        } else {
            this.f277a.bz.setVisibility(8);
            this.f277a.a(true, this.c);
        }
    }
}
