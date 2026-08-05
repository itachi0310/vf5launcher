package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f531a;

    j(g gVar) {
        this.f531a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f531a.c.size()) {
                return;
            }
            f fVar = (f) this.f531a.c.get(this.f531a.c.keyAt(i2));
            if (fVar != null) {
                fVar.b();
            }
            i = i2 + 1;
        }
    }
}
