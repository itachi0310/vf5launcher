package com.android.b.c;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import java.util.HashMap;
import junit.framework.Assert;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends a {
    private static HashMap h = new HashMap();
    private static m j = new m(null);
    private static int o;
    protected Bitmap i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int p;

    protected l() {
        this(false);
    }

    protected l(boolean z) {
        super(null, 0, 0);
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = false;
        if (z) {
            a(true);
            this.p = 1;
        }
    }

    private static Bitmap a(boolean z, Bitmap.Config config, int i) {
        m mVar = j;
        mVar.f59a = z;
        mVar.b = config;
        mVar.c = i;
        Bitmap bitmapCreateBitmap = (Bitmap) h.get(mVar);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = z ? Bitmap.createBitmap(1, i, config) : Bitmap.createBitmap(i, 1, config);
            h.put(mVar.clone(), bitmapCreateBitmap);
        }
        return bitmapCreateBitmap;
    }

    private void d(c cVar) {
        boolean z = false;
        Bitmap bitmapO = o();
        if (bitmapO == null) {
            this.b = -1;
            throw new RuntimeException("Texture load fail, no bitmap");
        }
        try {
            int width = bitmapO.getWidth();
            int height = bitmapO.getHeight();
            int i = (this.p * 2) + width;
            int i2 = (this.p * 2) + height;
            int iE = e();
            int iF = f();
            if (width <= iE && height <= iF) {
                z = true;
            }
            Assert.assertTrue(z);
            this.f55a = cVar.a().a();
            cVar.b(this);
            if (width == iE && height == iF) {
                cVar.a(this, bitmapO);
            } else {
                int internalFormat = GLUtils.getInternalFormat(bitmapO);
                int type = GLUtils.getType(bitmapO);
                Bitmap.Config config = bitmapO.getConfig();
                cVar.a(this, internalFormat, type);
                cVar.a(this, this.p, this.p, bitmapO, internalFormat, type);
                if (this.p > 0) {
                    cVar.a(this, 0, 0, a(true, config, iF), internalFormat, type);
                    cVar.a(this, 0, 0, a(false, config, iE), internalFormat, type);
                }
                if (this.p + width < iE) {
                    cVar.a(this, this.p + width, 0, a(true, config, iF), internalFormat, type);
                }
                if (this.p + height < iF) {
                    cVar.a(this, 0, this.p + height, a(false, config, iE), internalFormat, type);
                }
            }
            p();
            a(cVar);
            this.b = 1;
            this.k = true;
        } catch (Throwable th) {
            p();
            throw th;
        }
    }

    private Bitmap o() {
        if (this.i == null) {
            this.i = a_();
            int width = this.i.getWidth() + (this.p * 2);
            int height = this.i.getHeight() + (this.p * 2);
            if (this.c == -1) {
                a(width, height);
            }
        }
        return this.i;
    }

    private void p() {
        Assert.assertTrue(this.i != null);
        a(this.i);
        this.i = null;
    }

    protected abstract void a(Bitmap bitmap);

    protected abstract Bitmap a_();

    @Override // com.android.b.c.a
    protected boolean b(c cVar) {
        c(cVar);
        return n();
    }

    @Override // com.android.b.c.a
    public int c() {
        if (this.c == -1) {
            o();
        }
        return this.c;
    }

    public void c(c cVar) {
        if (!i()) {
            if (this.n) {
                int i = o + 1;
                o = i;
                if (i > 100) {
                    return;
                }
            }
            d(cVar);
            return;
        }
        if (this.k) {
            return;
        }
        Bitmap bitmapO = o();
        cVar.a(this, this.p, this.p, bitmapO, GLUtils.getInternalFormat(bitmapO), GLUtils.getType(bitmapO));
        p();
        this.k = true;
    }

    @Override // com.android.b.c.a
    public int d() {
        if (this.c == -1) {
            o();
        }
        return this.d;
    }

    @Override // com.android.b.c.a
    protected int h() {
        return 3553;
    }

    @Override // com.android.b.c.a
    public void j() {
        super.j();
        if (this.i != null) {
            p();
        }
    }

    @Override // com.android.b.c.k
    public boolean l() {
        return this.m;
    }

    protected void m() {
        if (this.i != null) {
            p();
        }
        this.k = false;
        this.c = -1;
        this.d = -1;
    }

    public boolean n() {
        return i() && this.k;
    }
}
