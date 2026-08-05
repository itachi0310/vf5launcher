package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f524a;
    int b;
    final /* synthetic */ a c;

    public b(a aVar, e eVar, int i) {
        this.c = aVar;
        this.f524a = eVar;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.b == ((b) obj).b && ((b) obj).f524a.equals(this.f524a);
        }
        return super.equals(obj);
    }
}
