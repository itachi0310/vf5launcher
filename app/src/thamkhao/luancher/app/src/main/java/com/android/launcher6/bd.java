package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class bd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f127a;
    private final /* synthetic */ cg b;

    bd(DeleteDropTarget deleteDropTarget, cg cgVar) {
        this.f127a = deleteDropTarget;
        this.b = cgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f127a.m(this.b);
        this.f127a.c.b();
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_all_disable)) {
            return;
        }
        this.f127a.b.L();
    }
}
