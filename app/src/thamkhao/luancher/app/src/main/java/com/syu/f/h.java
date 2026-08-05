package com.syu.f;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f529a;
    private final /* synthetic */ Handler b;

    h(g gVar, Handler handler) {
        this.f529a = gVar;
        this.b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f529a.h && this.f529a.d == null) {
            this.f529a.a();
        }
        this.b.removeCallbacks(this);
    }
}
