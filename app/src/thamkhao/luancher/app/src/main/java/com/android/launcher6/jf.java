package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jf implements com.syu.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f326a;

    jf(iv ivVar) {
        this.f326a = ivVar;
    }

    @Override // com.syu.a.e
    public void a() {
        if ((this.f326a.r == null || !this.f326a.r.a()) && iv.v != null) {
            iv.v.removeCallbacks(this.f326a.l);
            iv.v.postDelayed(this.f326a.l, 100L);
        }
    }
}
