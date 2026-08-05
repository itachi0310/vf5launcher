package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class bj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f133a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ cg c;

    bj(DeleteDropTarget deleteDropTarget, boolean z, cg cgVar) {
        this.f133a = deleteDropTarget;
        this.b = z;
        this.c = cgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.b) {
            this.f133a.b.L();
            this.f133a.m(this.c);
        }
        this.f133a.b.t().a(this.c);
    }
}
