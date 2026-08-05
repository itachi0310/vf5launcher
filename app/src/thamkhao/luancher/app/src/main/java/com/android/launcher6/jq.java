package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f335a;

    jq(jp jpVar) {
        this.f335a = jpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f335a) {
            this.f335a.f = true;
            this.f335a.notify();
        }
    }
}
