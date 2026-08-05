package com.android.c.a;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
class j implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f69a;
    private com.android.b.c.d b;

    private j(f fVar) {
        this.f69a = fVar;
    }

    /* synthetic */ j(f fVar, j jVar) {
        this(fVar);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Runnable runnable;
        this.b.c();
        synchronized (this.f69a.d) {
            runnable = this.f69a.e.f;
            this.f69a.e.g.a(this.f69a.e.e, this.f69a.e.d);
            this.f69a.e.g.a(this.f69a.e.b, this.f69a.e.c, this.f69a.e.f68a);
        }
        if (!this.f69a.e.g.a(this.b) || runnable == null) {
            return;
        }
        synchronized (this.f69a.d) {
            if (this.f69a.e.f == runnable) {
                this.f69a.e.f = null;
            }
        }
        if (runnable != null) {
            this.f69a.post(runnable);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.b.a(i, i2);
        this.f69a.e.g.a(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.b = new com.android.b.c.d();
        com.android.b.c.a.k();
        this.f69a.e.g.a(this.f69a.e.e, this.f69a.e.d);
    }
}
