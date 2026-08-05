package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f333a;

    jm(iv ivVar) {
        this.f333a = ivVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            notifyAll();
            this.f333a.t = false;
        }
    }
}
