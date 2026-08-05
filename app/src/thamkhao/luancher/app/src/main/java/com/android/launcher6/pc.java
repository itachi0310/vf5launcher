package com.android.launcher6;

import android.util.Log;
import android.view.Choreographer;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class pc implements Choreographer.FrameCallback {
    boolean c;
    boolean f;
    long g;
    float h;
    int i;
    final /* synthetic */ Workspace j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f457a = 0.0f;
    float b = 0.5f;
    private final int k = 250;
    private final int l = 3;
    Choreographer d = Choreographer.getInstance();
    Interpolator e = new DecelerateInterpolator(1.5f);

    public pc(Workspace workspace) {
        this.j = workspace;
    }

    private void a(boolean z) {
        if (this.c || z) {
            this.c = false;
            if (!a() || this.j.aA == null) {
                return;
            }
            try {
                this.j.az.setWallpaperOffsets(this.j.aA, this.j.j.c(), 0.5f);
                i();
            } catch (IllegalArgumentException e) {
                Log.e("JLog", "Error updating wallpaper offset: " + e);
            }
        }
    }

    private float e() {
        if (this.j.getChildCount() <= 1) {
            return 0.0f;
        }
        int iF = f();
        int iAh = this.j.ah();
        int childCount = (this.j.getChildCount() - 1) - iF;
        if (!this.j.m()) {
            childCount = iAh;
            iAh = childCount;
        }
        int iJ = this.j.j(childCount);
        int iJ2 = this.j.j(iAh) - iJ;
        if (iJ2 == 0) {
            return 0.0f;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, ((this.j.getScrollX() - iJ) - (this.j.m() ? this.j.c(this.j.getChildCount() - 1).getLeft() - this.j.getFirstChildLeft() : 0)) / iJ2));
        int iG = g();
        int iMax = Math.max(3, iG - 1);
        return (fMax * ((iG + (this.j.m() ? (iMax - iG) + 1 : 0)) - 1)) / iMax;
    }

    private int f() {
        return (this.j.getChildCount() - this.j.ah() < 3 || !this.j.V()) ? 0 : 1;
    }

    private int g() {
        return (this.j.getChildCount() - f()) - this.j.ah();
    }

    private void h() {
        this.f = true;
        this.h = this.b;
        this.g = System.currentTimeMillis();
    }

    private void i() {
        this.j.az.setWallpaperOffsetSteps(1.0f / (this.j.getChildCount() - 1), 1.0f);
    }

    private void j() {
        if (this.c) {
            return;
        }
        this.d.postFrameCallback(this);
        this.c = true;
    }

    public void a(float f) {
        j();
        this.f457a = Math.max(0.0f, Math.min(f, 1.0f));
        if (g() != this.i) {
            if (this.i > 0) {
                h();
            }
            this.i = g();
        }
    }

    public boolean a() {
        float f = this.b;
        if (this.f) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.g;
            this.b = (this.e.getInterpolation(jCurrentTimeMillis / 250.0f) * (this.f457a - this.h)) + this.h;
            this.f = jCurrentTimeMillis < 250;
        } else {
            this.b = this.f457a;
        }
        if (Math.abs(this.b - this.f457a) > 1.0E-7f) {
            j();
        }
        return Math.abs(f - this.b) > 1.0E-7f;
    }

    public void b() {
        this.j.j.a(e());
        a(true);
    }

    public float c() {
        return this.b;
    }

    public void d() {
        this.b = this.f457a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        a(false);
    }
}
