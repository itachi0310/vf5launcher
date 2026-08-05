package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ew implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f214a;

    ew(Launcher launcher) {
        this.f214a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f214a.g = true;
    }
}
