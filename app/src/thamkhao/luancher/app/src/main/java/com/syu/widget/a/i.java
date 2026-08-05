package com.syu.widget.a;

import com.android.launcher6.Launcher;

/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f558a;

    i(h hVar) {
        this.f558a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Launcher.o != null) {
            Launcher.o.runOnUiThread(new j(this));
        }
    }
}
