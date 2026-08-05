package com.android.launcher6;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class js implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f337a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;

    js(jp jpVar, jn jnVar, ArrayList arrayList) {
        this.f337a = jpVar;
        this.b = jnVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.uptimeMillis();
        jn jnVarA = this.f337a.a(this.b);
        if (jnVarA != null) {
            jnVarA.c(this.c);
        }
    }
}
