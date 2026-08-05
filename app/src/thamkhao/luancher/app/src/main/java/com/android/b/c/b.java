package com.android.b.c;

import android.graphics.Bitmap;
import junit.framework.Assert;

/* JADX INFO: loaded from: classes.dex */
public class b extends l {
    protected Bitmap h;

    public b(Bitmap bitmap) {
        this(bitmap, false);
    }

    public b(Bitmap bitmap, boolean z) {
        super(z);
        Assert.assertTrue((bitmap == null || bitmap.isRecycled()) ? false : true);
        this.h = bitmap;
    }

    @Override // com.android.b.c.l
    protected void a(Bitmap bitmap) {
    }

    @Override // com.android.b.c.l
    protected Bitmap a_() {
        return this.h;
    }
}
