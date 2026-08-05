package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ou extends io {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f448a;
    private final /* synthetic */ CellLayout b;
    private final /* synthetic */ int c;

    ou(Workspace workspace, CellLayout cellLayout, int i) {
        this.f448a = workspace;
        this.b = cellLayout;
        this.c = i;
    }

    @Override // com.android.launcher6.io
    public void a(float f, float f2) {
        this.b.setBackgroundAlpha((this.f448a.bN[this.c] * f) + (this.f448a.bP[this.c] * f2));
    }
}
