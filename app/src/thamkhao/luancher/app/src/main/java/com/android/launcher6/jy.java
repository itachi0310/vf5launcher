package com.android.launcher6;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class jy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f343a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ HashMap c;

    jy(jp jpVar, jn jnVar, HashMap map) {
        this.f343a = jpVar;
        this.b = jnVar;
        this.c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f343a.a(this.b);
        if (jnVarA != null) {
            jnVarA.a(this.c);
        }
    }
}
