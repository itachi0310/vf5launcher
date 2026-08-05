package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class kd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kc f349a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;

    kd(kc kcVar, jn jnVar, ArrayList arrayList) {
        this.f349a = kcVar;
        this.b = jnVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVar = this.f349a.c.y != null ? (jn) this.f349a.c.y.get() : null;
        if (this.b != jnVar || jnVar == null) {
            return;
        }
        this.b.d(this.c);
    }
}
