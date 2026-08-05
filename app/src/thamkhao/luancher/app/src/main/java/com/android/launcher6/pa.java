package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class pa implements lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float[] f455a;
    int b;
    int c;
    int d;
    int e;
    ca f;
    View g;
    final /* synthetic */ Workspace h;

    public pa(Workspace workspace, float[] fArr, int i, int i2, int i3, int i4, ca caVar, View view) {
        this.h = workspace;
        this.f455a = fArr;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.g = view;
        this.f = caVar;
    }

    @Override // com.android.launcher6.lf
    public void a(a aVar) {
        int[] iArr = new int[2];
        this.h.aI = this.h.a((int) this.h.aW[0], (int) this.h.aW[1], this.b, this.c, this.h.aN, this.h.aI);
        this.h.bE = this.h.aI[0];
        this.h.bF = this.h.aI[1];
        this.h.aI = this.h.aN.a((int) this.h.aW[0], (int) this.h.aW[1], this.b, this.c, this.d, this.e, this.g, this.h.aI, iArr, 0);
        if (this.h.aI[0] < 0 || this.h.aI[1] < 0) {
            this.h.aN.g();
        } else {
            this.h.setDragMode(3);
        }
        this.h.aN.a(this.g, this.h.bi, (int) this.h.aW[0], (int) this.h.aW[1], this.h.aI[0], this.h.aI[1], iArr[0], iArr[1], (iArr[0] == this.d && iArr[1] == this.e) ? false : true, this.f.getDragVisualizeOffset(), this.f.getDragRegion());
    }
}
