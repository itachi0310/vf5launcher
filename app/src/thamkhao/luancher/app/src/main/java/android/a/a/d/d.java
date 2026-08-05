package android.a.a.d;

import android.a.a.c.r;

/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f22a;

    private d(a aVar) {
        this.f22a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f22a.o) {
            if (this.f22a.m) {
                this.f22a.m = false;
                this.f22a.f20a.a();
            }
            c cVar = this.f22a.f20a;
            if (cVar.c() || !this.f22a.b()) {
                this.f22a.o = false;
                return;
            }
            if (this.f22a.n) {
                this.f22a.n = false;
                this.f22a.e();
            }
            cVar.d();
            this.f22a.a(cVar.g(), cVar.h());
            r.a(this.f22a.c, this);
        }
    }
}
