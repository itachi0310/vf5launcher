package com.android.launcher6;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class jt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f338a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ ArrayList c;

    jt(jp jpVar, jn jnVar, ArrayList arrayList) {
        this.f338a = jpVar;
        this.b = jnVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemClock.uptimeMillis();
        jn jnVarA = this.f338a.a(this.b);
        if (jnVarA != null) {
            jnVarA.c(this.c);
        } else {
            Log.i("Launcher.Model", "not binding apps: no Launcher activity");
        }
    }
}
