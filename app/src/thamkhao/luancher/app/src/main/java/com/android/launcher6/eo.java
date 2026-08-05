package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class eo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f206a;

    eo(Launcher launcher) {
        this.f206a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f206a.e(this.f206a.ef);
        this.f206a.ef = null;
    }
}
