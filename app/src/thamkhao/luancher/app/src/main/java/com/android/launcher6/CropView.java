package com.android.launcher6;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class CropView extends com.android.c.a.f implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    az f76a;
    Matrix b;
    Matrix c;
    private ScaleGestureDetector f;
    private long g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private RectF p;
    private float[] q;
    private float[] r;
    private float[] s;
    private float[] t;
    private float[] u;

    public CropView(Context context) {
        this(context, null);
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = true;
        this.p = new RectF();
        this.q = new float[]{0.0f, 0.0f};
        this.r = new float[]{0.0f, 0.0f};
        this.s = new float[]{0.0f, 0.0f};
        this.t = new float[]{0.0f, 0.0f};
        this.u = new float[]{0.0f, 0.0f};
        this.f = new ScaleGestureDetector(context, this);
        this.b = new Matrix();
        this.c = new Matrix();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000d A[Catch: all -> 0x0033, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000d, B:8:0x0031), top: B:13:0x0005 }] */
    private void a(int i, int i2, com.android.c.a.e eVar, boolean z) {
        synchronized (this.d) {
            if (z) {
                this.e.f68a = 1.0f;
                if (eVar != null) {
                    float[] imageDims = getImageDims();
                    this.n = Math.max(i / imageDims[0], i2 / imageDims[1]);
                    this.e.f68a = Math.max(this.n, this.e.f68a);
                }
            } else if (eVar != null) {
                float[] imageDims2 = getImageDims();
                this.n = Math.max(i / imageDims2[0], i2 / imageDims2[1]);
                this.e.f68a = Math.max(this.n, this.e.f68a);
            }
            throw th;
        }
    }

    private void a(RectF rectF) {
        float width = getWidth();
        float height = getHeight();
        float[] imageDims = getImageDims();
        float f = imageDims[0];
        float f2 = imageDims[1];
        float fB = this.e.e.b() / 2.0f;
        float fC = this.e.e.c() / 2.0f;
        float[] fArr = this.u;
        fArr[0] = this.l - fB;
        fArr[1] = this.m - fC;
        this.b.mapPoints(fArr);
        fArr[0] = fArr[0] + (f / 2.0f);
        fArr[1] = fArr[1] + (f2 / 2.0f);
        float f3 = this.e.f68a;
        float f4 = (width / 2.0f) + ((((width / 2.0f) - fArr[0]) + ((f - width) / 2.0f)) * f3);
        float f5 = (height / 2.0f) + ((((height / 2.0f) - fArr[1]) + ((f2 - height) / 2.0f)) * f3);
        float f6 = f4 - ((f / 2.0f) * f3);
        rectF.left = f6;
        rectF.right = f4 + ((f / 2.0f) * f3);
        rectF.top = f5 - ((f2 / 2.0f) * f3);
        rectF.bottom = f5 + ((f2 / 2.0f) * f3);
    }

    private void b() {
        this.e.b = Math.round(this.l);
        this.e.c = Math.round(this.m);
    }

    private float[] getImageDims() {
        float fB = this.e.e.b();
        float fC = this.e.e.c();
        float[] fArr = this.t;
        fArr[0] = fB;
        fArr[1] = fC;
        this.b.mapPoints(fArr);
        fArr[0] = Math.abs(fArr[0]);
        fArr[1] = Math.abs(fArr[1]);
        return fArr;
    }

    public void a() {
        if (getWidth() == 0 || getHeight() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ay(this));
        }
        RectF rectF = this.p;
        a(rectF);
        this.l = (float) (Math.ceil(rectF.left / this.e.f68a) + ((double) this.l));
        b();
    }

    @Override // com.android.c.a.f
    public void a(com.android.c.a.e eVar, Runnable runnable) {
        super.a(eVar, runnable);
        this.l = this.e.b;
        this.m = this.e.c;
        this.b.reset();
        this.b.setRotate(this.e.d);
        this.c.reset();
        this.c.setRotate(-this.e.d);
        a(getWidth(), getHeight(), eVar, true);
    }

    public RectF getCrop() {
        RectF rectF = this.p;
        a(rectF);
        float f = this.e.f68a;
        float f2 = (-rectF.left) / f;
        float f3 = (-rectF.top) / f;
        return new RectF(f2, f3, (getWidth() / f) + f2, (getHeight() / f) + f3);
    }

    public int getImageRotation() {
        return this.e.d;
    }

    public Point getSourceDimensions() {
        return new Point(this.e.e.b(), this.e.e.c());
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.e.f68a *= scaleGestureDetector.getScaleFactor();
        this.e.f68a = Math.max(this.n, this.e.f68a);
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        a(i, i2, this.e.e, false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean z = actionMasked == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float y = 0.0f;
        float x = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                x += motionEvent.getX(i);
                y += motionEvent.getY(i);
            }
        }
        int i2 = z ? pointerCount - 1 : pointerCount;
        float f = x / i2;
        float f2 = y / i2;
        if (actionMasked == 0) {
            this.h = f;
            this.i = f2;
            this.g = System.currentTimeMillis();
            if (this.f76a != null) {
                this.f76a.a();
            }
        } else if (actionMasked == 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            float f3 = ((this.h - f) * (this.h - f)) + ((this.i - f2) * (this.i - f2));
            float scaledTouchSlop = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f76a != null) {
                if (f3 < scaledTouchSlop && jCurrentTimeMillis < this.g + ((long) ViewConfiguration.getTapTimeout())) {
                    this.f76a.b();
                }
                this.f76a.c();
            }
        }
        if (this.o) {
            synchronized (this.d) {
                this.f.onTouchEvent(motionEvent);
                switch (actionMasked) {
                    case 2:
                        float[] fArr = this.q;
                        fArr[0] = (this.j - f) / this.e.f68a;
                        fArr[1] = (this.k - f2) / this.e.f68a;
                        this.c.mapPoints(fArr);
                        this.l += fArr[0];
                        this.m = fArr[1] + this.m;
                        b();
                        invalidate();
                        break;
                }
                if (this.e.e != null) {
                    RectF rectF = this.p;
                    a(rectF);
                    float f4 = this.e.f68a;
                    float[] fArr2 = this.r;
                    fArr2[0] = 1.0f;
                    fArr2[1] = 1.0f;
                    this.b.mapPoints(fArr2);
                    float[] fArr3 = this.s;
                    this.s[0] = 0.0f;
                    this.s[1] = 0.0f;
                    if (rectF.left > 0.0f) {
                        fArr3[0] = rectF.left / f4;
                    } else if (rectF.right < getWidth()) {
                        fArr3[0] = (rectF.right - getWidth()) / f4;
                    }
                    if (rectF.top > 0.0f) {
                        fArr3[1] = FloatMath.ceil(rectF.top / f4);
                    } else if (rectF.bottom < getHeight()) {
                        fArr3[1] = (rectF.bottom - getHeight()) / f4;
                    }
                    for (int i3 = 0; i3 <= 1; i3++) {
                        if (fArr2[i3] > 0.0f) {
                            fArr3[i3] = FloatMath.ceil(fArr3[i3]);
                        }
                    }
                    this.c.mapPoints(fArr3);
                    this.l += fArr3[0];
                    this.m += fArr3[1];
                    b();
                }
            }
            this.j = f;
            this.k = f2;
        }
        return true;
    }

    public void setScale(float f) {
        synchronized (this.d) {
            this.e.f68a = f;
        }
    }

    public void setTouchCallback(az azVar) {
        this.f76a = azVar;
    }

    public void setTouchEnabled(boolean z) {
        this.o = z;
    }
}
