package com.android.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.android.b.c.b;
import com.android.c.a.e;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(15)
public class a implements e {
    private static final boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BitmapRegionDecoder f61a;
    int b;
    int c;
    int d;
    private com.android.b.c.a f;
    private final int g;
    private Rect h;
    private Rect i;
    private BitmapFactory.Options j;
    private Canvas k;

    static {
        e = Build.VERSION.SDK_INT >= 16;
    }

    public a(Context context, Uri uri, int i, int i2) {
        this(null, context, null, uri, 0, i, i2);
    }

    public a(Context context, String str, int i, int i2) {
        this(null, context, str, null, 0, i, i2);
    }

    public a(Resources resources, Context context, int i, int i2, int i3) {
        this(resources, context, null, null, i, i2, i3);
    }

    private a(Resources resources, Context context, String str, Uri uri, int i, int i2, int i3) {
        this.h = new Rect();
        this.i = new Rect();
        this.d = com.android.c.a.a.a(context);
        this.g = i3;
        try {
            if (str != null) {
                this.f61a = BitmapRegionDecoder.newInstance(str, true);
            } else if (uri != null) {
                this.f61a = BitmapRegionDecoder.newInstance((InputStream) new BufferedInputStream(context.getContentResolver().openInputStream(uri)), true);
            } else {
                this.f61a = BitmapRegionDecoder.newInstance((InputStream) new BufferedInputStream(resources.openRawResource(i)), true);
            }
            this.b = this.f61a.getWidth();
            this.c = this.f61a.getHeight();
        } catch (IOException e2) {
            Log.w("BitmapRegionTileSource", "ctor failed", e2);
        }
        this.j = new BitmapFactory.Options();
        this.j.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.j.inPreferQualityOverSpeed = true;
        this.j.inTempStorage = new byte[16384];
        if (i2 != 0) {
            Bitmap bitmapA = a(resources, context, str, uri, i, Math.min(i2, 1024));
            if (bitmapA.getWidth() > 2048 || bitmapA.getHeight() > 2048) {
                Log.w("BitmapRegionTileSource", String.format("Failed to create preview of apropriate size!  in: %dx%d, out: %dx%d", Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(bitmapA.getWidth()), Integer.valueOf(bitmapA.getHeight())));
            } else {
                this.f = new b(bitmapA);
            }
        }
    }

    private Bitmap a(int i, int i2, int i3, int i4) {
        int i5 = i4 << i;
        this.h.set(i2, i3, i2 + i5, i5 + i3);
        this.i.set(0, 0, this.b, this.c);
        this.j.inSampleSize = 1 << i;
        Bitmap bitmapDecodeRegion = this.f61a.decodeRegion(this.i, this.j);
        if (bitmapDecodeRegion == null) {
            Log.w("BitmapRegionTileSource", "fail in decoding region");
        }
        if (this.h.equals(this.i)) {
            return bitmapDecodeRegion;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
        if (this.k == null) {
            this.k = new Canvas();
        }
        this.k.setBitmap(bitmapCreateBitmap);
        this.k.drawBitmap(bitmapDecodeRegion, (this.i.left - this.h.left) >> i, (this.i.top - this.h.top) >> i, (Paint) null);
        this.k.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private Bitmap a(Resources resources, Context context, String str, Uri uri, int i, int i2) {
        Bitmap bitmapDecodeStream;
        this.j.inSampleSize = com.android.b.a.a.a(i2 / Math.max(this.b, this.c));
        this.j.inJustDecodeBounds = false;
        if (str != null) {
            bitmapDecodeStream = BitmapFactory.decodeFile(str, this.j);
        } else if (uri != null) {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(new BufferedInputStream(context.getContentResolver().openInputStream(uri)), null, this.j);
            } catch (IOException e2) {
                Log.w("BitmapRegionTileSource", "getting preview failed", e2);
                bitmapDecodeStream = null;
            }
        } else {
            bitmapDecodeStream = BitmapFactory.decodeResource(resources, i, this.j);
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        float fMax = i2 / Math.max(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
        if (fMax <= 0.5d) {
            bitmapDecodeStream = com.android.b.a.a.a(bitmapDecodeStream, fMax, true);
        }
        return a(bitmapDecodeStream);
    }

    private static Bitmap a(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != null) {
            return bitmap;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        bitmap.recycle();
        return bitmapCopy;
    }

    @Override // com.android.c.a.e
    public int a() {
        return this.d;
    }

    @Override // com.android.c.a.e
    public Bitmap a(int i, int i2, int i3, Bitmap bitmap) {
        int iA = a();
        if (!e) {
            return a(i, i2, i3, iA);
        }
        int i4 = iA << i;
        this.h.set(i2, i3, i2 + i4, i4 + i3);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(iA, iA, Bitmap.Config.ARGB_8888);
        }
        this.j.inSampleSize = 1 << i;
        this.j.inBitmap = bitmap;
        try {
            Bitmap bitmapDecodeRegion = this.f61a.decodeRegion(this.h, this.j);
            if (this.j.inBitmap != bitmapDecodeRegion && this.j.inBitmap != null) {
                this.j.inBitmap = null;
            }
            if (bitmapDecodeRegion != null) {
                return bitmapDecodeRegion;
            }
            Log.w("BitmapRegionTileSource", "fail in decoding region");
            return bitmapDecodeRegion;
        } catch (Throwable th) {
            if (this.j.inBitmap != bitmap && this.j.inBitmap != null) {
                this.j.inBitmap = null;
            }
            throw th;
        }
    }

    @Override // com.android.c.a.e
    public int b() {
        return this.b;
    }

    @Override // com.android.c.a.e
    public int c() {
        return this.c;
    }

    @Override // com.android.c.a.e
    public com.android.b.c.a d() {
        return this.f;
    }

    @Override // com.android.c.a.e
    public int e() {
        return this.g;
    }
}
