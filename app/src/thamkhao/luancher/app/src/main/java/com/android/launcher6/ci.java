package com.android.launcher6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class ci extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f153a;
    private int c;
    private int d;
    private final Paint e = new Paint(2);
    private int b = 255;

    ci(Bitmap bitmap) {
        this.f153a = bitmap;
        if (bitmap != null) {
            this.c = this.f153a.getWidth();
            this.d = this.f153a.getHeight();
        } else {
            this.d = 0;
            this.c = 0;
        }
    }

    public Bitmap a() {
        return this.f153a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f153a, (Rect) null, getBounds(), this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b = i;
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
    }
}
