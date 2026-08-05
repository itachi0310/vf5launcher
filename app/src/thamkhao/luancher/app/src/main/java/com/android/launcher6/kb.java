package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class kb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f347a;
    private final /* synthetic */ jn b;
    private final /* synthetic */ int c;

    kb(jp jpVar, jn jnVar, int i) {
        this.f347a = jpVar;
        this.b = jnVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVarA = this.f347a.a(this.b);
        if (jnVarA != null) {
            jnVarA.d(this.c);
        }
    }
}
