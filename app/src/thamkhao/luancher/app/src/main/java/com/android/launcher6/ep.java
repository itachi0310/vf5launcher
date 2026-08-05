package com.android.launcher6;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
class ep implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f207a;

    ep(Launcher launcher) {
        this.f207a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.syu.widget.a.h.a(Launcher.o);
        this.f207a.sendBroadcast(new Intent("com.syu.show_time"));
    }
}
