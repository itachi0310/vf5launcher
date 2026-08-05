package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class hg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f279a;
    private final /* synthetic */ ArrayList b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean e;

    hg(Launcher launcher, ArrayList arrayList, int i, int i2, boolean z) {
        this.f279a = launcher;
        this.b = arrayList;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f279a.a(this.b, this.c, this.d, this.e);
    }
}
