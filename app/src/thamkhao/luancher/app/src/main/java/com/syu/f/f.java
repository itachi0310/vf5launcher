package com.syu.f;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f527a = new a();
    int[] b;
    com.syu.c.d c;

    final int a(int i, int i2, int... iArr) {
        try {
            com.syu.c.j jVarB = this.c.b(i2, iArr, null, null);
            return (jVarB == null || jVarB.f517a == null || jVarB.f517a.length <= 0) ? i : jVarB.f517a[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return i;
        }
    }

    abstract void a();

    void a(com.syu.c.a aVar, int i) {
        if (this.c != null) {
            try {
                this.c.a(aVar, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    void a(com.syu.c.a aVar, int i, boolean z) {
        if (this.c != null) {
            try {
                this.c.a(aVar, i, z ? 1 : 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    void a(com.syu.c.d dVar) {
        this.c = dVar;
        a();
    }

    void a(e eVar) {
        if (eVar != null) {
            this.f527a.a(eVar);
        }
    }

    void a(e eVar, int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        for (int i : iArr) {
            if (eVar != null) {
                this.f527a.a(eVar, i);
            }
        }
    }

    void a(int... iArr) {
        if (iArr == null) {
            return;
        }
        this.b = iArr;
        for (int i : iArr) {
            a((com.syu.c.a) this.f527a, i, true);
        }
    }

    void b() {
        if (this.b == null || this.b.length == 0) {
            return;
        }
        for (int i : this.b) {
            a(this.f527a, i);
        }
    }

    void b(int... iArr) {
        if (iArr == null || iArr.length <= 0 || this.c == null) {
            return;
        }
        for (int i : iArr) {
            a((com.syu.c.a) this.f527a, i, true);
        }
    }

    com.syu.c.d c() {
        return this.c;
    }
}
