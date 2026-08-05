package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class oj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f437a;
    private final /* synthetic */ md b;
    private final /* synthetic */ ec c;
    private final /* synthetic */ long d;
    private final /* synthetic */ long e;

    oj(Workspace workspace, md mdVar, ec ecVar, long j, long j2) {
        this.f437a = workspace;
        this.b = mdVar;
        this.c = ecVar;
        this.d = j;
        this.e = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        switch (this.b.g) {
            case 1:
                this.f437a.aQ.a(this.b.f390a, this.d, this.e, this.f437a.aI, (int[]) null);
                return;
            case 2:
            case 3:
            default:
                throw new IllegalStateException("Unknown item type: " + this.b.g);
            case 4:
                this.f437a.aQ.a((mf) this.b, this.d, this.e, this.f437a.aI, new int[]{this.c.l, this.c.m}, (int[]) null);
                return;
        }
    }
}
