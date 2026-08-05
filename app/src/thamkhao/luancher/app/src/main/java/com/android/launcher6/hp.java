package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class hp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f288a;
    private final /* synthetic */ ArrayList b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ boolean d;

    hp(Launcher launcher, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        this.f288a = launcher;
        this.b = arrayList;
        this.c = arrayList2;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f288a.a(this.b, this.c, this.d);
    }
}
