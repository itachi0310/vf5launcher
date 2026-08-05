package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ol implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f439a;
    private final /* synthetic */ View b;
    private final /* synthetic */ cg c;
    private final /* synthetic */ boolean d;
    private final /* synthetic */ boolean e;

    ol(Workspace workspace, View view, cg cgVar, boolean z, boolean z2) {
        this.f439a = workspace;
        this.b = view;
        this.c = cgVar;
        this.d = z;
        this.e = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f439a.a(this.b, this.c, this.d, this.e);
        this.f439a.bT = null;
    }
}
