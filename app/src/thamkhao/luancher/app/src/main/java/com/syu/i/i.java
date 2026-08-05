package com.syu.i;

/* JADX INFO: loaded from: classes.dex */
class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f549a;

    i(e eVar) {
        this.f549a = eVar;
    }

    @Override // com.syu.i.c
    public void a(boolean z) {
        if (!z) {
            this.f549a.b();
            return;
        }
        this.f549a.a();
        if (!this.f549a.c || this.f549a.j == null) {
            return;
        }
        this.f549a.a(Double.valueOf(this.f549a.j.getLatitude()), Double.valueOf(this.f549a.j.getLongitude()), "gogogo");
    }
}
