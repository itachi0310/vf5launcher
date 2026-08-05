package android.a.a.d;

import android.a.a.c.r;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    private final View c;
    private Runnable d;
    private int g;
    private int h;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f20a = new c();
    private final Interpolator b = new AccelerateInterpolator();
    private float[] e = {0.0f, 0.0f};
    private float[] f = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] i = {0.0f, 0.0f};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};

    public a(View view) {
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a(i, i);
        b(i2, i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        d(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float fB = b(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, fB) - f(f4, fB);
        if (f5 < 0.0f) {
            interpolation = -this.b.getInterpolation(-f5);
        } else {
            if (f5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.b.getInterpolation(f5);
        }
        return b(interpolation, -1.0f, 1.0f);
    }

    private float a(int i, float f, float f2, float f3) {
        float fA = a(this.e[i], f2, this.f[i], f);
        if (fA == 0.0f) {
            return 0.0f;
        }
        float f4 = this.i[i];
        float f5 = this.j[i];
        float f6 = this.k[i];
        float f7 = f4 * f3;
        return fA > 0.0f ? b(fA * f7, f5, f6) : -b((-fA) * f7, f5, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        c cVar = this.f20a;
        int iF = cVar.f();
        int iE = cVar.e();
        return (iF != 0 && f(iF)) || (iE != 0 && e(iE));
    }

    private void c() {
        if (this.d == null) {
            this.d = new d(this);
        }
        this.o = true;
        this.m = true;
        if (this.l || this.h <= 0) {
            this.d.run();
        } else {
            r.a(this.c, this.d, this.h);
        }
        this.l = true;
    }

    private void d() {
        if (this.m) {
            this.o = false;
        } else {
            this.f20a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                return (this.o && this.g == 1) ? 1.0f : 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    public a a(float f, float f2) {
        this.k[0] = f / 1000.0f;
        this.k[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.g = i;
        return this;
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public boolean a() {
        return this.p;
    }

    public a b(float f, float f2) {
        this.j[0] = f / 1000.0f;
        this.j[1] = f2 / 1000.0f;
        return this;
    }

    public a b(int i) {
        this.h = i;
        return this;
    }

    public a b(boolean z) {
        this.q = z;
        return this;
    }

    public a c(float f, float f2) {
        this.i[0] = f / 1000.0f;
        this.i[1] = f2 / 1000.0f;
        return this;
    }

    public a c(int i) {
        this.f20a.a(i);
        return this;
    }

    public a d(float f, float f2) {
        this.e[0] = f;
        this.e[1] = f2;
        return this;
    }

    public a d(int i) {
        this.f20a.b(i);
        return this;
    }

    public a e(float f, float f2) {
        this.f[0] = f;
        this.f[1] = f2;
        return this;
    }

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        switch (android.a.a.c.g.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                this.f20a.a(a(0, motionEvent.getX(), view.getWidth(), this.c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.c.getHeight()));
                if (!this.o && b()) {
                    c();
                }
                break;
            case 1:
            case 3:
                d();
                break;
            case 2:
                this.f20a.a(a(0, motionEvent.getX(), view.getWidth(), this.c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.c.getHeight()));
                if (!this.o) {
                    c();
                }
                break;
        }
        return this.q && this.o;
    }
}
