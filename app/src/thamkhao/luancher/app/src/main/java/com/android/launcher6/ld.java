package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
public class ld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f370a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long[] f = new long[256];
    public long[] g = new long[256];
    public long h = 1;
    public int i = 0;

    public ld(int i, String str, long j) {
        this.f370a = i;
        this.b = str;
        this.c = j;
    }

    public long a() {
        return System.currentTimeMillis() - this.c;
    }
}
