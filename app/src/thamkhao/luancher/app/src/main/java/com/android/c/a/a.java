package com.android.c.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pools;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Pools.Pool h = new Pools.SynchronizedPool(64);
    private boolean B;
    private int C;
    private int D;
    private View E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f62a;
    protected int d;
    protected int e;
    protected float f;
    protected int g;
    private int i;
    private e j;
    private com.android.b.c.a k;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean x;
    private int l = 0;
    private final RectF q = new RectF();
    private final RectF r = new RectF();
    private final android.a.a.b.b s = new android.a.a.b.b();
    private final Object t = new Object();
    private final d u = new d(null);
    private final d v = new d(0 == true ? 1 : 0);
    private final d w = new d(0 == true ? 1 : 0);
    protected int b = -1;
    protected int c = -1;
    private final Rect y = new Rect();
    private final Rect[] z = {new Rect(), new Rect()};
    private c A = new c(this, 0 == true ? 1 : 0);

    public a(View view) {
        this.E = view;
        this.A.start();
    }

    public static int a(Context context) {
        return b(context) ? 512 : 256;
    }

    private b a(int i, int i2, int i3) {
        b bVarA;
        synchronized (this.t) {
            bVarA = this.u.a();
            if (bVarA != null) {
                bVarA.n = 1;
                bVarA.a(i, i2, i3);
            } else {
                bVarA = new b(this, i, i2, i3);
            }
        }
        return bVarA;
    }

    private void a(Rect rect, int i, int i2, int i3, float f, int i4) {
        double radians = Math.toRadians(-i4);
        double d = this.C;
        double d2 = this.D;
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        int iCeil = (int) Math.ceil(Math.max(Math.abs((dCos * d) - (dSin * d2)), Math.abs((dCos * d) + (dSin * d2))));
        int iCeil2 = (int) Math.ceil(Math.max(Math.abs((dSin * d) + (dCos * d2)), Math.abs((dSin * d) - (dCos * d2))));
        int iFloor = (int) Math.floor(i - (iCeil / (2.0f * f)));
        int iFloor2 = (int) Math.floor(i2 - (iCeil2 / (2.0f * f)));
        int iCeil3 = (int) Math.ceil(iFloor + (iCeil / f));
        int iCeil4 = (int) Math.ceil((iCeil2 / f) + iFloor2);
        int i5 = this.i << i3;
        rect.set(Math.max(0, (iFloor / i5) * i5), Math.max(0, (iFloor2 / i5) * i5), Math.min(this.b, iCeil3), Math.min(this.c, iCeil4));
    }

    private void a(Rect rect, int i, int i2, int i3, int i4) {
        a(rect, i, i2, i3, 1.0f / (1 << (i3 + 1)), i4);
    }

    private void a(com.android.b.c.c cVar, int i, int i2, int i3, float f, float f2, float f3) {
        RectF rectF = this.q;
        RectF rectF2 = this.r;
        rectF2.set(f, f2, f + f3, f2 + f3);
        rectF.set(0.0f, 0.0f, this.i, this.i);
        b bVarC = c(i, i2, i3);
        if (bVarC != null) {
            if (!bVarC.n()) {
                if (bVarC.n == 8) {
                    if (this.o > 0) {
                        this.o--;
                        bVarC.c(cVar);
                    } else {
                        this.p = false;
                    }
                } else if (bVarC.n != 16) {
                    this.p = false;
                    a(bVarC);
                }
            }
            if (a(bVarC, cVar, rectF, rectF2)) {
                return;
            }
        }
        if (this.k != null) {
            int i4 = this.i << i3;
            float fC = this.k.c() / this.b;
            float fD = this.k.d() / this.c;
            rectF.set(i * fC, i2 * fD, fC * (i + i4), (i4 + i2) * fD);
            cVar.a(this.k, rectF, rectF2);
        }
    }

    private void a(b bVar) {
        synchronized (this.t) {
            if (bVar.n == 1) {
                bVar.n = 2;
                if (this.w.a(bVar)) {
                    this.t.notifyAll();
                }
            }
        }
    }

    private boolean a(b bVar, com.android.b.c.c cVar, RectF rectF, RectF rectF2) {
        while (!bVar.n()) {
            b bVarP = bVar.p();
            if (bVarP == null) {
                return false;
            }
            if (bVar.h == bVarP.h) {
                rectF.left /= 2.0f;
                rectF.right /= 2.0f;
            } else {
                rectF.left = (this.i + rectF.left) / 2.0f;
                rectF.right = (this.i + rectF.right) / 2.0f;
            }
            if (bVar.j == bVarP.j) {
                rectF.top /= 2.0f;
                rectF.bottom /= 2.0f;
            } else {
                rectF.top = (this.i + rectF.top) / 2.0f;
                rectF.bottom = (this.i + rectF.bottom) / 2.0f;
            }
            bVar = bVarP;
        }
        cVar.a(bVar, rectF, rectF2);
        return true;
    }

    private void b(int i, int i2, int i3) {
        long jD = d(i, i2, i3);
        b bVar = (b) this.s.a(jD);
        if (bVar == null) {
            this.s.b(jD, a(i, i2, i3));
        } else if (bVar.n == 2) {
            bVar.n = 1;
        }
    }

    private void b(com.android.b.c.c cVar) {
        this.B = true;
        int iB = this.s.b();
        for (int i = 0; i < iB; i++) {
            b bVar = (b) this.s.c(i);
            if (!bVar.n()) {
                a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        synchronized (this.t) {
            if (bVar.n != 2) {
                return;
            }
            bVar.n = 4;
            boolean zO = bVar.o();
            synchronized (this.t) {
                if (bVar.n == 32) {
                    bVar.n = 64;
                    if (bVar.m != null) {
                        h.release(bVar.m);
                        bVar.m = null;
                    }
                    this.u.a(bVar);
                    return;
                }
                bVar.n = zO ? 8 : 16;
                if (zO) {
                    this.v.a(bVar);
                    d();
                }
            }
        }
    }

    private static boolean b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels > 2048 || displayMetrics.widthPixels > 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b c(int i, int i2, int i3) {
        return (b) this.s.a(d(i, i2, i3));
    }

    private void c(com.android.b.c.c cVar) {
        int i = 1;
        b bVarA = null;
        while (i > 0) {
            synchronized (this.t) {
                bVarA = this.v.a();
            }
            if (bVarA == null) {
                break;
            }
            if (!bVarA.n()) {
                if (bVarA.n == 8) {
                    bVarA.c(cVar);
                    i--;
                } else {
                    Log.w("TiledImageRenderer", "Tile in upload queue has invalid state: " + bVarA.n);
                }
            }
        }
        if (bVarA != null) {
            d();
        }
    }

    private void c(b bVar) {
        synchronized (this.t) {
            if (bVar.n == 4) {
                bVar.n = 32;
                return;
            }
            bVar.n = 64;
            if (bVar.m != null) {
                h.release(bVar.m);
                bVar.m = null;
            }
            this.u.a(bVar);
        }
    }

    private static long d(int i, int i2, int i3) {
        return (((((long) i) << 16) | ((long) i2)) << 16) | ((long) i3);
    }

    private void d() {
        this.E.postInvalidate();
    }

    private void e() {
        if (this.k != null) {
            this.f62a = Math.max(0, com.android.b.a.b.a(this.b / this.k.c()));
            return;
        }
        int i = 1;
        int iMax = Math.max(this.b, this.c);
        int i2 = this.i;
        while (i2 < iMax) {
            i2 <<= 1;
            i++;
        }
        this.f62a = i;
    }

    private void f() {
        int i;
        if (this.C == 0 || this.D == 0 || !this.x) {
            return;
        }
        this.x = false;
        this.l = com.android.b.a.b.a(com.android.b.a.b.b(1.0f / this.f), 0, this.f62a);
        if (this.l != this.f62a) {
            Rect rect = this.y;
            a(rect, this.d, this.e, this.l, this.f, this.g);
            this.m = Math.round((this.C / 2.0f) + ((rect.left - this.d) * this.f));
            this.n = Math.round((this.D / 2.0f) + ((rect.top - this.e) * this.f));
            i = this.f * ((float) (1 << this.l)) > 0.75f ? this.l - 1 : this.l;
        } else {
            i = this.l - 2;
            this.m = Math.round((this.C / 2.0f) - (this.d * this.f));
            this.n = Math.round((this.D / 2.0f) - (this.e * this.f));
        }
        int iMax = Math.max(0, Math.min(i, this.f62a - 2));
        int iMin = Math.min(iMax + 2, this.f62a);
        Rect[] rectArr = this.z;
        for (int i2 = iMax; i2 < iMin; i2++) {
            a(rectArr[i2 - iMax], this.d, this.e, i2, this.g);
        }
        if (this.g % 90 == 0) {
            synchronized (this.t) {
                this.w.b();
                this.v.b();
                this.B = false;
                int iB = this.s.b();
                int i3 = 0;
                while (i3 < iB) {
                    b bVar = (b) this.s.c(i3);
                    int i4 = bVar.k;
                    if (i4 < iMax || i4 >= iMin || !rectArr[i4 - iMax].contains(bVar.h, bVar.j)) {
                        this.s.a(i3);
                        i3--;
                        iB--;
                        c(bVar);
                    }
                    iB = iB;
                    i3++;
                }
            }
            for (int i5 = iMax; i5 < iMin; i5++) {
                int i6 = this.i << i5;
                Rect rect2 = rectArr[i5 - iMax];
                int i7 = rect2.top;
                int i8 = rect2.bottom;
                for (int i9 = i7; i9 < i8; i9 += i6) {
                    int i10 = rect2.right;
                    for (int i11 = rect2.left; i11 < i10; i11 += i6) {
                        b(i11, i9, i5);
                    }
                }
            }
            d();
        }
    }

    private void g() {
        synchronized (this.t) {
            this.w.b();
            this.v.b();
            int iB = this.s.b();
            for (int i = 0; i < iB; i++) {
                c((b) this.s.c(i));
            }
            this.s.c();
        }
    }

    public void a() {
        g();
        if (this.j == null) {
            this.b = 0;
            this.c = 0;
            this.f62a = 0;
            this.k = null;
        } else {
            this.b = this.j.b();
            this.c = this.j.c();
            this.k = this.j.d();
            this.i = this.j.a();
            e();
        }
        this.x = true;
    }

    public void a(int i, int i2) {
        this.C = i;
        this.D = i2;
    }

    public void a(int i, int i2, float f) {
        if (this.d == i && this.e == i2 && this.f == f) {
            return;
        }
        this.d = i;
        this.e = i2;
        this.f = f;
        this.x = true;
    }

    public void a(e eVar, int i) {
        if (this.j != eVar) {
            this.j = eVar;
            a();
        }
        if (this.g != i) {
            this.g = i;
            this.x = true;
        }
    }

    public boolean a(com.android.b.c.c cVar) {
        f();
        c(cVar);
        this.o = 1;
        this.p = true;
        int i = this.l;
        int i2 = this.g;
        int i3 = i2 != 0 ? 2 : 0;
        if (i3 != 0) {
            cVar.a(i3);
            if (i2 != 0) {
                int i4 = this.C / 2;
                int i5 = this.D / 2;
                cVar.a(i4, i5);
                cVar.a(i2, 0.0f, 0.0f, 1.0f);
                cVar.a(-i4, -i5);
            }
        }
        try {
            if (i != this.f62a) {
                int i6 = this.i << i;
                float f = i6 * this.f;
                Rect rect = this.y;
                int i7 = rect.top;
                int i8 = 0;
                while (i7 < rect.bottom) {
                    float f2 = this.n + (i8 * f);
                    int i9 = rect.left;
                    int i10 = 0;
                    while (i9 < rect.right) {
                        a(cVar, i9, i7, i, this.m + (i10 * f), f2, f);
                        i9 += i6;
                        i10++;
                    }
                    i7 += i6;
                    i8++;
                }
            } else if (this.k != null) {
                this.k.a(cVar, this.m, this.n, Math.round(this.b * this.f), Math.round(this.c * this.f));
            }
            if (i3 != 0) {
                cVar.b();
            }
            if (!this.p) {
                d();
            } else if (!this.B) {
                b(cVar);
            }
            return this.p || this.k != null;
        } catch (Throwable th) {
            if (i3 != 0) {
                cVar.b();
            }
            throw th;
        }
    }

    public void b() {
        this.x = true;
        this.A.a();
        synchronized (this.t) {
            this.v.b();
            this.w.b();
            b bVarA = this.u.a();
            while (bVarA != null) {
                bVarA.j();
                bVarA = this.u.a();
            }
        }
        int iB = this.s.b();
        for (int i = 0; i < iB; i++) {
            ((b) this.s.c(i)).j();
        }
        this.s.c();
        this.y.set(0, 0, 0, 0);
        while (h.acquire() != null) {
        }
    }
}
