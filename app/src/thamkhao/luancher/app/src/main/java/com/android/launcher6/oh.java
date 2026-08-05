package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class oh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f435a;
    private final /* synthetic */ Runnable b;

    oh(Workspace workspace, Runnable runnable) {
        this.f435a = workspace;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f435a.g = false;
        this.f435a.e(false);
        if (this.b != null) {
            this.b.run();
        }
        this.f435a.X();
    }
}
