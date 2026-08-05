package com.android.b.c;

import android.util.Log;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements k {
    private static WeakHashMap i = new WeakHashMap();
    private static ThreadLocal j = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f55a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected c g;
    private boolean h;

    protected a() {
        this(null, 0, 0);
    }

    protected a(c cVar, int i2, int i3) {
        this.f55a = -1;
        this.c = -1;
        this.d = -1;
        this.g = null;
        a(cVar);
        this.f55a = i2;
        this.b = i3;
        synchronized (i) {
            i.put(this, null);
        }
    }

    public static void k() {
        synchronized (i) {
            for (a aVar : i.keySet()) {
                aVar.b = 0;
                aVar.a((c) null);
            }
        }
    }

    private void m() {
        c cVar = this.g;
        if (cVar != null && this.f55a != -1) {
            cVar.a(this);
            this.f55a = -1;
        }
        this.b = 0;
        a((c) null);
    }

    public void a(int i2, int i3) {
        this.c = i2;
        this.d = i3;
        this.e = i2 > 0 ? com.android.b.a.b.a(i2) : 0;
        this.f = i3 > 0 ? com.android.b.a.b.a(i3) : 0;
        if (this.e > 4096 || this.f > 4096) {
            Log.w("BasicTexture", String.format("texture is too large: %d x %d", Integer.valueOf(this.e), Integer.valueOf(this.f)), new Exception());
        }
    }

    protected void a(c cVar) {
        this.g = cVar;
    }

    public void a(c cVar, int i2, int i3, int i4, int i5) {
        cVar.a(this, i2, i3, i4, i5);
    }

    protected void a(boolean z) {
        this.h = z;
    }

    public boolean a() {
        return false;
    }

    public int b() {
        return this.f55a;
    }

    protected abstract boolean b(c cVar);

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    protected void finalize() {
        j.set(a.class);
        j();
        j.set(null);
    }

    public boolean g() {
        return this.h;
    }

    protected abstract int h();

    public boolean i() {
        return this.b == 1;
    }

    public void j() {
        m();
    }
}
