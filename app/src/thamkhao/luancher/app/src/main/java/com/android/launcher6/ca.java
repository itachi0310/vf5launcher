package com.android.launcher6;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class ca extends View {
    private static float b = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ValueAnimator f146a;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private int f;
    private int g;
    private Point h;
    private Rect i;
    private DragLayer j;
    private boolean k;
    private float l;
    private float m;
    private float n;
    private float o;

    public ca(Launcher launcher, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        super(launcher);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 1.0f;
        this.j = launcher.f();
        this.o = f;
        Resources resources = getResources();
        float dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dragViewOffsetX);
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.dragViewOffsetY);
        float dimensionPixelSize3 = (resources.getDimensionPixelSize(R.dimen.dragViewScale) + i5) / i5;
        setScaleX(f);
        setScaleY(f);
        this.f146a = ik.a(this, 0.0f, 1.0f);
        this.f146a.setDuration(150L);
        this.f146a.addUpdateListener(new cb(this, dimensionPixelSize, dimensionPixelSize2, f, dimensionPixelSize3));
        this.c = Bitmap.createBitmap(bitmap, i3, i4, i5, i6);
        setDragRegion(new Rect(0, 0, i5, i6));
        this.f = i;
        this.g = i2;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.e = new Paint(2);
    }

    public void a() {
        this.o = getScaleX();
    }

    public void a(int i) {
        ValueAnimator valueAnimatorA = ik.a(this, 0.0f, 1.0f);
        valueAnimatorA.setDuration(i);
        valueAnimatorA.setInterpolator(new DecelerateInterpolator(1.5f));
        valueAnimatorA.addUpdateListener(new cc(this));
        valueAnimatorA.start();
    }

    public void a(int i, int i2) {
        this.j.addView(this);
        bw bwVar = new bw(0, 0);
        bwVar.width = this.c.getWidth();
        bwVar.height = this.c.getHeight();
        bwVar.c = true;
        setLayoutParams(bwVar);
        setTranslationX(i - this.f);
        setTranslationY(i2 - this.g);
        post(new cd(this));
    }

    void b(int i, int i2) {
        setTranslationX((i - this.f) + ((int) this.m));
        setTranslationY((i2 - this.g) + ((int) this.n));
    }

    public boolean b() {
        return this.k;
    }

    public void c() {
        if (this.f146a == null || !this.f146a.isRunning()) {
            return;
        }
        this.f146a.cancel();
    }

    public void d() {
        this.n = 0.0f;
        this.m = 0.0f;
        requestLayout();
    }

    void e() {
        if (getParent() != null) {
            this.j.removeView(this);
        }
    }

    public Rect getDragRegion() {
        return this.i;
    }

    public int getDragRegionHeight() {
        return this.i.height();
    }

    public int getDragRegionLeft() {
        return this.i.left;
    }

    public int getDragRegionTop() {
        return this.i.top;
    }

    public int getDragRegionWidth() {
        return this.i.width();
    }

    public Point getDragVisualizeOffset() {
        return this.h;
    }

    public float getInitialScale() {
        return this.o;
    }

    public float getOffsetY() {
        return this.n;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.k = true;
        boolean z = this.l > 0.0f && this.d != null;
        if (z) {
            this.e.setAlpha(z ? (int) ((1.0f - this.l) * 255.0f) : 255);
        }
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.e);
        if (z) {
            this.e.setAlpha((int) (this.l * 255.0f));
            canvas.save();
            canvas.scale((this.c.getWidth() * 1.0f) / this.d.getWidth(), (this.c.getHeight() * 1.0f) / this.d.getHeight());
            canvas.drawBitmap(this.d, 0.0f, 0.0f, this.e);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.c.getWidth(), this.c.getHeight());
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        this.e.setAlpha((int) (255.0f * f));
        invalidate();
    }

    public void setColor(int i) {
        if (this.e == null) {
            this.e = new Paint(2);
        }
        if (i != 0) {
            this.e.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        } else {
            this.e.setColorFilter(null);
        }
        invalidate();
    }

    public void setCrossFadeBitmap(Bitmap bitmap) {
        this.d = bitmap;
    }

    public void setDragRegion(Rect rect) {
        this.i = rect;
    }

    public void setDragVisualizeOffset(Point point) {
        this.h = point;
    }
}
