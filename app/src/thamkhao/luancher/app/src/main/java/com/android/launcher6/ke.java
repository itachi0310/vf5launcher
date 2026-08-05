package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ke implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kc f350a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ ArrayList d;
    private final /* synthetic */ boolean e;

    ke(kc kcVar, jn jnVar, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        this.f350a = kcVar;
        this.b = jnVar;
        this.c = arrayList;
        this.d = arrayList2;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVar = this.f350a.c.y != null ? (jn) this.f350a.c.y.get() : null;
        if (this.b != jnVar || jnVar == null) {
            return;
        }
        this.b.a(this.c, this.d, this.e);
    }
}
