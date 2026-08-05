package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class kf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kc f351a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;

    kf(kc kcVar, jn jnVar, ArrayList arrayList) {
        this.f351a = kcVar;
        this.b = jnVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVar = this.f351a.c.y != null ? (jn) this.f351a.c.y.get() : null;
        if (this.b != jnVar || jnVar == null) {
            return;
        }
        this.b.e(this.c);
    }
}
