package com.android.c.a;

import android.graphics.Bitmap;
import android.util.Log;
import com.android.b.c.l;

/* JADX INFO: loaded from: classes.dex */
class b extends l {
    public int h;
    public int j;
    public int k;
    public b l;
    public Bitmap m;
    public volatile int n = 1;
    final /* synthetic */ a o;

    public b(a aVar, int i, int i2, int i3) {
        this.o = aVar;
        this.h = i;
        this.j = i2;
        this.k = i3;
    }

    public void a(int i, int i2, int i3) {
        this.h = i;
        this.j = i2;
        this.k = i3;
        m();
    }

    @Override // com.android.b.c.l
    protected void a(Bitmap bitmap) {
        a.h.release(bitmap);
    }

    @Override // com.android.b.c.l
    protected Bitmap a_() {
        com.android.b.a.b.a(this.n == 8);
        a(Math.min(this.o.i, (this.o.b - this.h) >> this.k), Math.min(this.o.i, (this.o.c - this.j) >> this.k));
        Bitmap bitmap = this.m;
        this.m = null;
        this.n = 1;
        return bitmap;
    }

    @Override // com.android.b.c.a
    public int e() {
        return this.o.i;
    }

    @Override // com.android.b.c.a
    public int f() {
        return this.o.i;
    }

    boolean o() {
        try {
            Bitmap bitmap = (Bitmap) a.h.acquire();
            if (bitmap != null && bitmap.getWidth() != this.o.i) {
                bitmap = null;
            }
            this.m = this.o.j.a(this.k, this.h, this.j, bitmap);
        } catch (Throwable th) {
            Log.w("TiledImageRenderer", "fail to decode tile", th);
        }
        return this.m != null;
    }

    public b p() {
        if (this.k + 1 == this.o.f62a) {
            return null;
        }
        int i = this.o.i << (this.k + 1);
        return this.o.c((this.h / i) * i, i * (this.j / i), this.k + 1);
    }

    public String toString() {
        return String.format("tile(%s, %s, %s / %s)", Integer.valueOf(this.h / this.o.i), Integer.valueOf(this.j / this.o.i), Integer.valueOf(this.o.l), Integer.valueOf(this.o.f62a));
    }
}
