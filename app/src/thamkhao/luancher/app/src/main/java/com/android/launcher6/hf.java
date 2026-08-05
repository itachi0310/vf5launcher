package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class hf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f278a;
    private final /* synthetic */ ArrayList b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ ArrayList d;
    private final /* synthetic */ ArrayList e;

    hf(Launcher launcher, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f278a = launcher;
        this.b = arrayList;
        this.c = arrayList2;
        this.d = arrayList3;
        this.e = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f278a.a(this.b, this.c, this.d, this.e);
    }
}
