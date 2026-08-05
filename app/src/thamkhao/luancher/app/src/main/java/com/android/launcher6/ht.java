package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ht implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f292a;
    private final /* synthetic */ Cling b;
    private final /* synthetic */ Runnable c;
    private final /* synthetic */ String d;

    ht(Launcher launcher, Cling cling, Runnable runnable, String str) {
        this.f292a = launcher;
        this.b = cling;
        this.c = runnable;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a();
        new hu(this, "dismissClingThread", this.d).start();
        if (this.c != null) {
            this.c.run();
        }
    }
}
