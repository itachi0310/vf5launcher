package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class oi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f436a;

    oi(Workspace workspace) {
        this.f436a = workspace;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f436a.aQ.a(true, false, (Runnable) null);
    }
}
