package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f285a;
    private final /* synthetic */ boolean b;

    hm(Launcher launcher, boolean z) {
        this.f285a = launcher;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f285a.k(this.b);
    }
}
