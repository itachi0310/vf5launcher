package com.android.launcher6;

import android.content.Intent;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f261a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Intent c;
    private final /* synthetic */ Object d;

    gp(Launcher launcher, View view, Intent intent, Object obj) {
        this.f261a = launcher;
        this.b = view;
        this.c = intent;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.i("hy", "easyconnACTION");
        this.f261a.af = this.f261a.c(this.b, this.c, this.d);
    }
}
