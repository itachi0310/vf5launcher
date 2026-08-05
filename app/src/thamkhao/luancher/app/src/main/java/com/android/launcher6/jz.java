package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f344a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ it c;

    jz(jp jpVar, jn jnVar, it itVar) {
        this.f344a = jpVar;
        this.b = jnVar;
        this.c = itVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f344a.a(this.b);
        if (jnVarA != null) {
            jnVarA.b(this.c);
        }
    }
}
