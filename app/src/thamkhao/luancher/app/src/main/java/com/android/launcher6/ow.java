package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ow implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f450a;
    private final /* synthetic */ Runnable b;

    ow(Workspace workspace, Runnable runnable) {
        this.f450a = workspace;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f450a.v()) {
            this.b.run();
        } else {
            this.f450a.bp = this.b;
        }
    }
}
