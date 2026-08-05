package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class om implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f440a;

    om(Workspace workspace) {
        this.f440a = workspace;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f440a.aQ.a(true, true, (Runnable) null);
    }
}
