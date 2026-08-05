package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
public class mt implements lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f400a = 500;
    final long b = 950;
    final long c = 200;
    a d = new a();
    private CellLayout e;
    private Launcher f;

    public mt(Launcher launcher) {
        this.f = launcher;
        this.d.a(this);
    }

    public void a() {
        this.d.a();
    }

    public void a(CellLayout cellLayout) {
        this.d.a();
        this.d.a(cellLayout == null ? 950L : 500L);
        this.e = cellLayout;
    }

    @Override // com.android.launcher6.lf
    public void a(a aVar) {
        if (this.e == null) {
            this.f.t().b();
            return;
        }
        Workspace workspaceI = this.f.I();
        int iIndexOfChild = workspaceI.indexOfChild(this.e);
        if (iIndexOfChild != workspaceI.getCurrentPage()) {
            workspaceI.n(iIndexOfChild);
        }
    }
}
