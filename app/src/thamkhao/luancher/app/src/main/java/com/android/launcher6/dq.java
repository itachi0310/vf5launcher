package com.android.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class dq {
    static dq c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185a;
    public int b;
    private final Paint d = new Paint();
    private final Paint e = new Paint();
    private final Paint f = new Paint();
    private BlurMaskFilter g;
    private BlurMaskFilter h;
    private BlurMaskFilter i;
    private BlurMaskFilter j;
    private BlurMaskFilter k;
    private BlurMaskFilter l;
    private BlurMaskFilter m;

    private dq(Context context) {
        float fK = ip.a().k();
        this.b = (int) (fK * 1.0f);
        this.f185a = (int) (fK * 12.0f);
        this.g = new BlurMaskFilter(12.0f * fK, BlurMaskFilter.Blur.OUTER);
        this.h = new BlurMaskFilter(fK * 6.0f, BlurMaskFilter.Blur.OUTER);
        this.i = new BlurMaskFilter(fK * 2.0f, BlurMaskFilter.Blur.OUTER);
        this.j = new BlurMaskFilter(fK * 1.0f, BlurMaskFilter.Blur.OUTER);
        this.l = new BlurMaskFilter(fK * 6.0f, BlurMaskFilter.Blur.NORMAL);
        this.k = new BlurMaskFilter(4.0f * fK, BlurMaskFilter.Blur.NORMAL);
        this.m = new BlurMaskFilter(fK * 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.d.setFilterBitmap(true);
        this.d.setAntiAlias(true);
        this.e.setFilterBitmap(true);
        this.e.setAntiAlias(true);
        this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f.setFilterBitmap(true);
        this.f.setAntiAlias(true);
    }

    public static dq a(Context context) {
        if (c == null) {
            c = new dq(context);
        }
        return c;
    }

    void a(Bitmap bitmap, Canvas canvas, int i, int i2) {
        a(bitmap, canvas, i, i2, 2);
    }

    void a(Bitmap bitmap, Canvas canvas, int i, int i2, int i3) {
        a(bitmap, canvas, i, i2, true, i3);
    }

    void a(Bitmap bitmap, Canvas canvas, int i, int i2, boolean z) {
        a(bitmap, canvas, i, i2, z, 1);
    }

    void a(Bitmap bitmap, Canvas canvas, int i, int i2, boolean z, int i3) {
        BlurMaskFilter blurMaskFilter;
        BlurMaskFilter blurMaskFilter2;
        if (z) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i4 = 0; i4 < iArr.length; i4++) {
                if ((iArr[i4] >>> 24) < 188) {
                    iArr[i4] = 0;
                }
            }
            bitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha();
        switch (i3) {
            case 0:
                blurMaskFilter = this.h;
                break;
            case 1:
                blurMaskFilter = this.i;
                break;
            case 2:
                blurMaskFilter = this.g;
                break;
            default:
                throw new RuntimeException("Invalid blur thickness");
        }
        this.e.setMaskFilter(blurMaskFilter);
        int[] iArr2 = new int[2];
        Bitmap bitmapExtractAlpha2 = bitmapExtractAlpha.extractAlpha(this.e, iArr2);
        if (i3 == 2) {
            this.e.setMaskFilter(this.i);
        } else {
            this.e.setMaskFilter(this.j);
        }
        int[] iArr3 = new int[2];
        Bitmap bitmapExtractAlpha3 = bitmapExtractAlpha.extractAlpha(this.e, iArr3);
        canvas.setBitmap(bitmapExtractAlpha);
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_OUT);
        switch (i3) {
            case 0:
                blurMaskFilter2 = this.k;
                break;
            case 1:
                blurMaskFilter2 = this.m;
                break;
            case 2:
                blurMaskFilter2 = this.l;
                break;
            default:
                throw new RuntimeException("Invalid blur thickness");
        }
        this.e.setMaskFilter(blurMaskFilter2);
        int[] iArr4 = new int[2];
        Bitmap bitmapExtractAlpha4 = bitmapExtractAlpha.extractAlpha(this.e, iArr4);
        canvas.setBitmap(bitmapExtractAlpha4);
        canvas.drawBitmap(bitmapExtractAlpha, -iArr4[0], -iArr4[1], this.f);
        canvas.drawRect(0.0f, 0.0f, -iArr4[0], bitmapExtractAlpha4.getHeight(), this.f);
        canvas.drawRect(0.0f, 0.0f, bitmapExtractAlpha4.getWidth(), -iArr4[1], this.f);
        canvas.setBitmap(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.d.setColor(i);
        canvas.drawBitmap(bitmapExtractAlpha4, iArr4[0], iArr4[1], this.d);
        canvas.drawBitmap(bitmapExtractAlpha2, iArr2[0], iArr2[1], this.d);
        this.d.setColor(i2);
        canvas.drawBitmap(bitmapExtractAlpha3, iArr3[0], iArr3[1], this.d);
        canvas.setBitmap(null);
        bitmapExtractAlpha3.recycle();
        bitmapExtractAlpha2.recycle();
        bitmapExtractAlpha4.recycle();
        bitmapExtractAlpha.recycle();
    }

    void b(Bitmap bitmap, Canvas canvas, int i, int i2) {
        a(bitmap, canvas, i, i2, 1);
    }
}
