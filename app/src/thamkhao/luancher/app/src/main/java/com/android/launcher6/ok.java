package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ok implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f438a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Runnable c;

    ok(Workspace workspace, View view, Runnable runnable) {
        this.f438a = workspace;
        this.b = view;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            this.b.setVisibility(0);
        }
        if (this.c != null) {
            this.c.run();
        }
    }
}
