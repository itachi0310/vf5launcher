package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class oy implements lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CellLayout f452a;
    int b;
    int c;
    final /* synthetic */ Workspace d;

    public oy(Workspace workspace, CellLayout cellLayout, int i, int i2) {
        this.d = workspace;
        this.f452a = cellLayout;
        this.b = i;
        this.c = i2;
    }

    @Override // com.android.launcher6.lf
    public void a(a aVar) {
        if (this.d.bv != null) {
            this.d.bv.b();
        }
        this.d.bv = new da(this.d.aQ, null);
        this.d.bv.a(this.b, this.c);
        this.d.bv.a(this.f452a);
        this.d.bv.a();
        this.f452a.a(this.d.bv);
        this.f452a.f();
        this.d.setDragMode(1);
    }
}
