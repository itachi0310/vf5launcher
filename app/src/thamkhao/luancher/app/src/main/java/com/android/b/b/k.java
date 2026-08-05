package com.android.b.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class k {
    private static final int[] d = {0, 1, 2, 3, 4};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f53a;
    private final Map b = new HashMap();
    private int c = 0;

    k(int i) {
        this.f53a = i;
    }

    protected static int[] a() {
        return d;
    }

    protected j a(j jVar) {
        jVar.b(this.f53a);
        return (j) this.b.put(Short.valueOf(jVar.b()), jVar);
    }

    protected j a(short s) {
        return (j) this.b.get(Short.valueOf(s));
    }

    protected j[] b() {
        return (j[]) this.b.values().toArray(new j[this.b.size()]);
    }

    protected int c() {
        return this.f53a;
    }

    protected int d() {
        return this.b.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (kVar.c() == this.f53a && kVar.d() == d()) {
                for (j jVar : kVar.b()) {
                    if (!c.a(jVar.b()) && !jVar.equals((j) this.b.get(Short.valueOf(jVar.b())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
