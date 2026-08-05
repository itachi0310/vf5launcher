package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f526a;

    d(c cVar) {
        this.f526a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (b bVar : this.f526a.f.b) {
            if (bVar.b == this.f526a.f525a) {
                bVar.f524a.a(this.f526a.f525a, this.f526a.b, this.f526a.c, this.f526a.d);
            }
        }
    }
}
