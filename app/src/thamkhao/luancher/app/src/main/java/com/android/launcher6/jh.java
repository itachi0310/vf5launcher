package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class jh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jg f328a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ ArrayList d;
    private final /* synthetic */ ArrayList e;

    jh(jg jgVar, jn jnVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f328a = jgVar;
        this.b = jnVar;
        this.c = arrayList;
        this.d = arrayList2;
        this.e = arrayList3;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVar = this.f328a.f327a.y != null ? (jn) this.f328a.f327a.y.get() : null;
        if (this.b != jnVar || jnVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!this.c.isEmpty()) {
            long j = ((ec) this.c.get(this.c.size() - 1)).i;
            for (ec ecVar : this.c) {
                if (ecVar.i == j) {
                    arrayList.add(ecVar);
                } else {
                    arrayList2.add(ecVar);
                }
            }
        }
        this.b.a(this.d, arrayList2, arrayList, this.e);
    }
}
