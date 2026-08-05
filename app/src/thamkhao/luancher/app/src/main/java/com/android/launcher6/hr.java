package com.android.launcher6;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
class hr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f290a;
    private final /* synthetic */ Cling b;
    private final /* synthetic */ Runnable c;
    private final /* synthetic */ Intent d;

    hr(Launcher launcher, Cling cling, Runnable runnable, Intent intent) {
        this.f290a = launcher;
        this.b = cling;
        this.c = runnable;
        this.d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a();
        new hs(this, "dismissClingThread", this.d).start();
        if (this.c != null) {
            this.c.run();
        }
    }
}
