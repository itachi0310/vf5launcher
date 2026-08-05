package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class cd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f149a;

    cd(ca caVar) {
        this.f149a = caVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f149a.f146a.start();
    }
}
