package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class iu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LauncherApplication f315a;

    iu(LauncherApplication launcherApplication) {
        this.f315a = launcherApplication;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (le.g > 0) {
            if (this.f315a.getResources().getBoolean(R.bool.apps_widget_design)) {
                com.syu.widget.a.l.a(LauncherApplication.f88a);
            } else if (Launcher.G() != null) {
                Launcher.G().n();
            }
        }
        LauncherApplication.b.postDelayed(this, 250L);
    }
}
