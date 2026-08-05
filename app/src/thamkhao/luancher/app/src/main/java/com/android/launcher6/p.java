package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f454a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ lw d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ int f;
    private final /* synthetic */ ArrayList g;

    p(AppsCustomizePagedView appsCustomizePagedView, int i, int i2, lw lwVar, boolean z, int i3, ArrayList arrayList) {
        this.f454a = appsCustomizePagedView;
        this.b = i;
        this.c = i2;
        this.d = lwVar;
        this.e = z;
        this.f = i3;
        this.g = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        int i2 = this.c;
        if (this.d.getChildCount() > 0) {
            int[] previewSize = ((PagedViewWidget) this.d.getChildAt(0)).getPreviewSize();
            i = previewSize[0];
            i2 = previewSize[1];
        }
        this.f454a.n.a(i, i2, this.f454a.aM);
        if (this.e) {
            y yVar = new y(this.f, this.g, i, i2, null, null, this.f454a.n);
            this.f454a.a((h) null, yVar);
            this.f454a.a(yVar);
        } else if (this.f454a.aZ) {
            this.f454a.bb.add(this);
        } else {
            this.f454a.a(this.f, this.g, i, i2, this.f454a.aI);
        }
        this.d.setOnLayoutListener(null);
    }
}
