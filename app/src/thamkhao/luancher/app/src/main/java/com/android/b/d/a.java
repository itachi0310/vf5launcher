package com.android.b.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f60a = new int[8];
    private int b = 0;

    public int a() {
        this.b--;
        return this.f60a[this.b];
    }

    public void a(int i) {
        if (this.f60a.length == this.b) {
            int[] iArr = new int[this.b + this.b];
            System.arraycopy(this.f60a, 0, iArr, 0, this.b);
            this.f60a = iArr;
        }
        int[] iArr2 = this.f60a;
        int i2 = this.b;
        this.b = i2 + 1;
        iArr2[i2] = i;
    }
}
