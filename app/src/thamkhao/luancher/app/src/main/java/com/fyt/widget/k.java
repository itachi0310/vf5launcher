package com.fyt.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f502a;
    public int b;
    public int c;
    private int d;
    private int e;
    private Handler f;
    private Bitmap g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private l n;

    private void a(int i, boolean z) {
        if (i < 6) {
            i = this.d;
        } else if (i > this.d) {
            i = 6;
        }
        this.h = i;
        invalidate();
        if (!z || this.n == null) {
            return;
        }
        this.n.a((this.h - 6) / this.e);
    }

    public void a(int i, int i2, int i3) {
        int i4 = (int) (6.0f + ((this.e * (i - i2)) / (i3 - i2)));
        if (this.h == i4) {
            return;
        }
        float fAbs = Math.abs((this.h - i4) / this.e);
        this.k = this.h;
        this.j = i4;
        this.l = (int) (700.0f * fAbs);
        this.m = SystemClock.uptimeMillis();
        this.f.sendEmptyMessage(0);
    }

    public int getmCurMark() {
        return this.h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.g != null) {
            if (this.h < 80) {
                this.h = 80;
            } else if (this.h > this.d) {
                this.h = this.d;
            }
            canvas.drawBitmap(this.g, this.h - this.i, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 6;
        this.f502a = motionEvent.getAction();
        if (this.f502a == 0) {
            this.b = (int) motionEvent.getX();
            this.c = this.b;
            return false;
        }
        if (this.f502a == 2) {
            this.b = (int) motionEvent.getX();
            if (Math.abs(this.c - this.b) <= 5) {
                return false;
            }
            this.c = this.b;
            a(this.b, true);
            return false;
        }
        if (this.f502a != 1) {
            return false;
        }
        int x = (int) motionEvent.getX();
        if (x >= 6) {
            i = x > this.d ? this.d : x;
        }
        int i2 = i - 6;
        if (this.n == null) {
            return false;
        }
        float f = i2 / this.e;
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.n.a(f);
        this.n.a(i2, this.e);
        return false;
    }

    public void setCallback(l lVar) {
        this.n = lVar;
    }
}
