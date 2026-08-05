package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ot extends io {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f447a;
    private final /* synthetic */ CellLayout b;
    private final /* synthetic */ int c;

    ot(Workspace workspace, CellLayout cellLayout, int i) {
        this.f447a = workspace;
        this.b = cellLayout;
        this.c = i;
    }

    @Override // com.android.launcher6.io
    public void a(float f, float f2) {
        this.b.setBackgroundAlpha((this.f447a.bN[this.c] * f) + (this.f447a.bP[this.c] * f2));
    }
}
