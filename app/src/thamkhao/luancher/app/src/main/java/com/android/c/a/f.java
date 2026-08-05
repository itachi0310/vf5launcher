package com.android.c.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class f extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f65a;
    private static final boolean b;
    private GLSurfaceView c;
    protected Object d;
    protected i e;
    private boolean f;
    private Choreographer.FrameCallback g;
    private float[] h;
    private Runnable i;
    private RectF j;

    static {
        f65a = Build.VERSION.SDK_INT >= 16;
        b = Build.VERSION.SDK_INT >= 16;
    }

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.h = new float[9];
        this.d = new Object();
        this.i = new g(this);
        this.j = new RectF();
        if (f65a) {
            this.e = new i();
            this.e.g = new a(this);
            this.c = new GLSurfaceView(context);
            this.c.setEGLContextClientVersion(2);
            this.c.setRenderer(new j(this, null));
            this.c.setRenderMode(0);
            addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @TargetApi(16)
    private void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.g == null) {
            this.g = new h(this);
        }
        Choreographer.getInstance().postFrameCallback(this.g);
    }

    private void a(i iVar) {
        if (iVar == null || iVar.e == null || iVar.f68a > 0.0f || getWidth() == 0) {
            return;
        }
        iVar.f68a = Math.min(getWidth() / iVar.e.b(), getHeight() / iVar.e.c());
    }

    public void a(e eVar, Runnable runnable) {
        if (f65a) {
            synchronized (this.d) {
                this.e.e = eVar;
                this.e.f = runnable;
                this.e.b = eVar != null ? eVar.b() / 2 : 0;
                this.e.c = eVar != null ? eVar.c() / 2 : 0;
                this.e.d = eVar != null ? eVar.e() : 0;
                this.e.f68a = 0.0f;
                a(this.e);
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (f65a) {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        if (f65a) {
            if (b) {
                a();
            } else {
                this.c.requestRender();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (f65a) {
            synchronized (this.d) {
                a(this.e);
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void setTranslationX(float f) {
        if (f65a) {
            super.setTranslationX(f);
        }
    }
}
