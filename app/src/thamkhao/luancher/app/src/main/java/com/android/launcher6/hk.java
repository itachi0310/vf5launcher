package com.android.launcher6;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class hk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f283a;
    private final /* synthetic */ HashMap b;

    hk(Launcher launcher, HashMap map) {
        this.f283a = launcher;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f283a.a(this.b);
    }
}
