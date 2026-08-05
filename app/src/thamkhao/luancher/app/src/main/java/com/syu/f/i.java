package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f530a;
    private final /* synthetic */ int b;

    i(g gVar, int i) {
        this.f530a = gVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        if (this.f530a.d == null) {
            return;
        }
        try {
            com.syu.c.d dVarA = this.f530a.d.a(this.b);
            if (dVarA == null || (fVar = (f) this.f530a.c.get(this.b)) == null) {
                return;
            }
            fVar.a(dVarA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
