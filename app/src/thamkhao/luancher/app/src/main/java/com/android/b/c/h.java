package com.android.b.c;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes.dex */
public class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f58a = new int[1];

    @Override // com.android.b.c.i
    public int a() {
        GLES20.glGenTextures(1, this.f58a, 0);
        d.e();
        return this.f58a[0];
    }

    @Override // com.android.b.c.i
    public void a(int i, int[] iArr, int i2) {
        GLES20.glGenBuffers(i, iArr, i2);
        d.e();
    }
}
