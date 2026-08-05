package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class mg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreloadReceiver f391a;
    private final /* synthetic */ LauncherProvider b;
    private final /* synthetic */ int c;

    mg(PreloadReceiver preloadReceiver, LauncherProvider launcherProvider, int i) {
        this.f391a = preloadReceiver;
        this.b = launcherProvider;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.c);
    }
}
