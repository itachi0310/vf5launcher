package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f336a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ long d;

    jr(jp jpVar, jn jnVar, boolean z, long j) {
        this.f336a = jpVar;
        this.b = jnVar;
        this.c = z;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f336a.a(this.b);
        if (jnVarA != null) {
            jnVarA.k(this.c);
        }
        this.f336a.d = false;
    }
}
