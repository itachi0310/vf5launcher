package com.syu.d;

/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f519a;

    b(a aVar) {
        this.f519a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f519a.b.setText(this.f519a.d.toString());
    }
}
