package com.syu.g;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f534a;
    String b;
    int c;

    public e(String str, String str2, int i) {
        this.f534a = str;
        this.b = str2;
        this.c = i;
    }

    public String a() {
        return this.f534a;
    }

    public int b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        boolean zEquals = this.f534a.equals(eVar.f534a);
        if (this.b == null && eVar.b == null) {
            return zEquals;
        }
        if (this.b != null) {
            return zEquals && (eVar.b != null ? this.b.equals(eVar.b) : false);
        }
        return zEquals && (eVar.b == null);
    }
}
