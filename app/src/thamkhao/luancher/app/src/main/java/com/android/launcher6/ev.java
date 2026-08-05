package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ev implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f213a;
    private final /* synthetic */ int b;

    ev(Launcher launcher, int i) {
        this.f213a = launcher;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f213a.a(this.b != 0, false, (Runnable) null);
    }
}
