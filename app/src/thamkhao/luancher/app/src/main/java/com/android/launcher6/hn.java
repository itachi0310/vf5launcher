package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f286a;

    hn(Launcher launcher) {
        this.f286a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f286a.j();
    }
}
