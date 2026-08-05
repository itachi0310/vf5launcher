package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class kg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kc f352a;
    private final /* synthetic */ jn b;

    kg(kc kcVar, jn jnVar) {
        this.f352a = kcVar;
        this.b = jnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        jn jnVar = this.f352a.c.y != null ? (jn) this.f352a.c.y.get() : null;
        if (this.b != jnVar || jnVar == null) {
            return;
        }
        this.b.ak();
    }
}
