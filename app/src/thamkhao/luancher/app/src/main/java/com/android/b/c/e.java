package com.android.b.c;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes.dex */
class e extends f {
    public e(String str) {
        super(str);
    }

    @Override // com.android.b.c.f
    public void a(int i) {
        this.f57a = GLES20.glGetAttribLocation(i, this.b);
        d.e();
    }
}
