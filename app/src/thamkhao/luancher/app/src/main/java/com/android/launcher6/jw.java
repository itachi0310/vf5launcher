package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class jw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f341a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;

    jw(jp jpVar, jn jnVar, ArrayList arrayList) {
        this.f341a = jpVar;
        this.b = jnVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f341a.a(this.b);
        if (jnVarA != null) {
            jnVarA.a(this.c);
        }
    }
}
