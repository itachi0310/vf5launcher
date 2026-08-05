package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class og implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f434a;

    og(Workspace workspace) {
        this.f434a = workspace;
    }

    @Override // java.lang.Runnable
    public void run() {
        Launcher.r().f();
    }
}
