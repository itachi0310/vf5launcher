package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class bq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bo f139a;
    private int b;

    bq(bo boVar) {
        this.f139a = boVar;
    }

    void a(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f139a.s != null) {
            if (this.b == 0) {
                this.f139a.s.c_();
            } else {
                this.f139a.s.d_();
            }
            this.f139a.t = 0;
            this.f139a.z = 0;
            this.f139a.s.i();
            this.f139a.d.f().c();
            if (this.f139a.a()) {
                this.f139a.b(this.f139a.x[0], this.f139a.x[1]);
            }
        }
    }
}
