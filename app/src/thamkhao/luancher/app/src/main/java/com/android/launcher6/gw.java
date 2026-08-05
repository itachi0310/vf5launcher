package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class gw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f268a;

    gw(Launcher launcher) {
        this.f268a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f268a.t().a() && this.f268a.ah == ii.WORKSPACE) {
            this.f268a.a(pb.SPRING_LOADED, false, true, (Runnable) null);
            this.f268a.ah = ii.APPS_CUSTOMIZE_SPRING_LOADED;
        }
    }
}
