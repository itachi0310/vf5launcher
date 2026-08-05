package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ct implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Folder f163a;
    private final /* synthetic */ View b;
    private final /* synthetic */ cg c;
    private final /* synthetic */ boolean d;
    private final /* synthetic */ boolean e;

    ct(Folder folder, View view, cg cgVar, boolean z, boolean z2) {
        this.f163a = folder;
        this.b = view;
        this.c = cgVar;
        this.d = z;
        this.e = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f163a.a(this.b, this.c, this.d, this.e);
        this.f163a.T = null;
    }
}
