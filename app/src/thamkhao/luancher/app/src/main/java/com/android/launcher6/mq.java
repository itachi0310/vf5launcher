package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes.dex */
public abstract class mq extends li {
    private static final float b = (float) (0.016d / Math.log(0.75d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f397a;
    private float c;
    private float d;
    private Interpolator e;

    public mq(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public mq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.af = false;
        this.ag = this.f397a != 1;
    }

    private void b(int i, int i2, boolean z) {
        int i3;
        int iMax = Math.max(0, Math.min(i, getChildCount() - 1));
        int iMax2 = Math.max(1, Math.abs(iMax - this.v));
        int iJ = j(iMax) - this.U;
        int i4 = (iMax2 + 1) * 100;
        if (!this.A.isFinished()) {
            this.A.abortAnimation();
        }
        if (z) {
            ((mr) this.e).a(iMax2);
        } else {
            ((mr) this.e).a();
        }
        int iAbs = Math.abs(i2);
        if (iAbs > 0) {
            i3 = (int) (((i4 / (iAbs / this.c)) * this.d) + i4);
        } else {
            i3 = i4 + 100;
        }
        a_(iMax, iJ, i3);
    }

    @Override // com.android.launcher6.li
    protected void F() {
        if (this.f397a == 1) {
            super.F();
        } else {
            b(getPageNearestToCenterOfScreen(), 0);
        }
    }

    @Override // com.android.launcher6.li
    protected void a() {
        super.a();
        this.f397a = getScrollMode();
        if (this.f397a == 0) {
            this.c = 2500.0f;
            this.d = 0.4f;
            this.e = new mr();
            this.A = new Scroller(getContext(), this.e);
        }
    }

    @Override // com.android.launcher6.li
    protected void b(int i, int i2) {
        if (this.f397a == 1) {
            super.b(i, i2);
        } else {
            b(i, 0, true);
        }
    }

    @Override // com.android.launcher6.li, android.view.View
    public void computeScroll() {
        if (this.f397a == 1) {
            super.computeScroll();
            return;
        }
        if (x() || this.F != 1) {
            return;
        }
        float fNanoTime = System.nanoTime() / 1.0E9f;
        float fExp = (float) Math.exp((fNanoTime - this.s) / b);
        float f = this.t - this.U;
        scrollTo(Math.round((fExp * f) + this.U), getScrollY());
        this.s = fNanoTime;
        if (f > 1.0f || f < -1.0f) {
            invalidate();
        }
    }

    protected int getScrollMode() {
        return 1;
    }

    @Override // com.android.launcher6.li
    protected void n(int i) {
        if (this.f397a == 1) {
            super.n(i);
        } else {
            b(i, 0, false);
        }
    }
}
