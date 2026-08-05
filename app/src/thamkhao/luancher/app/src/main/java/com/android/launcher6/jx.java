package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class jx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f342a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;

    jx(jp jpVar, jn jnVar, ArrayList arrayList, int i, int i2) {
        this.f342a = jpVar;
        this.b = jnVar;
        this.c = arrayList;
        this.d = i;
        this.e = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f342a.a(this.b);
        if (jnVarA != null) {
            jnVarA.a(this.c, this.d, this.d + this.e, false);
        }
    }
}
