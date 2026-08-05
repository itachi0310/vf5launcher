package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f346a;
    private final /* synthetic */ jn b;

    ka(jp jpVar, jn jnVar) {
        this.f346a = jpVar;
        this.b = jnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f346a.a(this.b);
        if (jnVarA != null) {
            jnVarA.R();
        }
    }
}
