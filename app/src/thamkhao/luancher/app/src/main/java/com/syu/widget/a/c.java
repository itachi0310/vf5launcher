package com.syu.widget.a;

import com.android.launcher6.LauncherApplication;

/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f556a;

    c(b bVar) {
        this.f556a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l.a(LauncherApplication.f88a);
        LauncherApplication.b.postDelayed(this, 500L);
    }
}
