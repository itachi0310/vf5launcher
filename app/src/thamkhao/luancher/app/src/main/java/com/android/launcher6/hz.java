package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class hz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f298a;

    hz(Launcher launcher) {
        this.f298a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        Launcher.as.ap();
    }
}
