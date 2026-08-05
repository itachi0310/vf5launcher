package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ed implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f195a;

    ed(Launcher launcher) {
        this.f195a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Launcher.as != null) {
            Launcher.as.am();
        }
    }
}
