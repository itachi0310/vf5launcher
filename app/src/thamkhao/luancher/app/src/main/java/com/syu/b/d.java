package com.syu.b;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f512a;
    private int b;
    private int c;
    private int d;
    private double e;
    private double f;
    private double g;
    private double h;
    private int[] i;

    public d(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, int[] iArr) {
        this.f512a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = d;
        this.f = d2;
        this.g = d3;
        this.h = d4;
        this.i = iArr;
    }

    public int[] a() {
        return this.i;
    }

    public String toString() {
        return String.format("fileCode: %d, fileLength: %d, version: %d, shapeType: %d, minX: %f, minY: %f, maxX: %f, maxY: %f", Integer.valueOf(this.f512a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f), Double.valueOf(this.g), Double.valueOf(this.h));
    }
}
