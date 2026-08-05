package com.fyt.car;

import com.android.launcher6.Launcher;

/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SetWallpaperReceiver f486a;

    d(SetWallpaperReceiver setWallpaperReceiver) {
        this.f486a = setWallpaperReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Launcher.G() == null) {
            this.f486a.d.postDelayed(this, 1000L);
        } else {
            Launcher.G().ag();
        }
    }
}
