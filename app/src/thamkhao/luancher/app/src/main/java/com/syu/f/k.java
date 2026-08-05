package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f532a;
    private final /* synthetic */ f b;
    private final /* synthetic */ int[] c;

    k(g gVar, f fVar, int[] iArr) {
        this.f532a = gVar;
        this.b = fVar;
        this.c = iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            for (int i : this.c) {
                this.b.b(i);
            }
        }
    }
}
