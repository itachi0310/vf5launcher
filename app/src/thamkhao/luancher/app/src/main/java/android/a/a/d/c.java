package android.a.a.d;

import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21a;
    private int b;
    private float c;
    private float d;
    private float j;
    private int k;
    private long e = Long.MIN_VALUE;
    private long i = -1;
    private long f = 0;
    private int g = 0;
    private int h = 0;

    private float a(float f) {
        return ((-4.0f) * f * f) + (4.0f * f);
    }

    private float a(long j) {
        if (j < this.e) {
            return 0.0f;
        }
        if (this.i < 0 || j < this.i) {
            return a.b((j - this.e) / this.f21a, 0.0f, 1.0f) * 0.5f;
        }
        return (a.b((j - this.i) / this.k, 0.0f, 1.0f) * this.j) + (1.0f - this.j);
    }

    public void a() {
        this.e = AnimationUtils.currentAnimationTimeMillis();
        this.i = -1L;
        this.f = this.e;
        this.j = 0.5f;
        this.g = 0;
        this.h = 0;
    }

    public void a(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public void a(int i) {
        this.f21a = i;
    }

    public void b() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.k = a.b((int) (jCurrentAnimationTimeMillis - this.e), 0, this.b);
        this.j = a(jCurrentAnimationTimeMillis);
        this.i = jCurrentAnimationTimeMillis;
    }

    public void b(int i) {
        this.b = i;
    }

    public boolean c() {
        return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
    }

    public void d() {
        if (this.f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float fA = a(a(jCurrentAnimationTimeMillis));
        long j = jCurrentAnimationTimeMillis - this.f;
        this.f = jCurrentAnimationTimeMillis;
        this.g = (int) (j * fA * this.c);
        this.h = (int) (j * fA * this.d);
    }

    public int e() {
        return (int) (this.c / Math.abs(this.c));
    }

    public int f() {
        return (int) (this.d / Math.abs(this.d));
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }
}
