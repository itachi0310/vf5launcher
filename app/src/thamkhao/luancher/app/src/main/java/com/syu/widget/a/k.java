package com.syu.widget.a;

import com.android.launcher6.Launcher;
import com.android.launcher6.LauncherApplication;

/* JADX INFO: loaded from: classes.dex */
class k implements com.syu.i.m {
    k() {
    }

    @Override // com.syu.i.m
    public void a(com.syu.i.d dVar) {
        if (dVar == null || !dVar.f()) {
            return;
        }
        Launcher.G().q = dVar;
        l.a(LauncherApplication.f88a);
    }
}
