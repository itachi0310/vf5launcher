package com.syu.widget;

/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RestartService f555a;

    a(RestartService restartService) {
        this.f555a = restartService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f555a.f554a.removeCallbacks(this.f555a.b);
        this.f555a.f554a.postDelayed(this.f555a.b, 500L);
    }
}
