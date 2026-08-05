package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106a;
    int b;
    int c;
    int d;
    final /* synthetic */ CellLayout e;

    public ai(CellLayout cellLayout) {
        this.e = cellLayout;
    }

    public ai(CellLayout cellLayout, int i, int i2, int i3, int i4) {
        this.e = cellLayout;
        this.f106a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public void a(ai aiVar) {
        aiVar.f106a = this.f106a;
        aiVar.b = this.b;
        aiVar.c = this.c;
        aiVar.d = this.d;
    }

    public String toString() {
        return "(" + this.f106a + ", " + this.b + ": " + this.c + ", " + this.d + ")";
    }
}
