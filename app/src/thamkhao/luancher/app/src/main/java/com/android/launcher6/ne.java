package com.android.launcher6;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ne extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Uri f411a;
    Context b;
    String c;
    byte[] d;
    int e;
    InputStream f;
    RectF g;
    int h;
    int i;
    int j;
    String k;
    boolean l;
    boolean m;
    Bitmap n;
    Runnable o;
    Resources p;
    nf q;
    boolean r;

    public ne(Context context, Resources resources, int i, RectF rectF, int i2, int i3, int i4, boolean z, boolean z2, Runnable runnable) {
        this.f411a = null;
        this.e = 0;
        this.g = null;
        this.k = "jpg";
        this.b = context;
        this.e = i;
        this.p = resources;
        a(rectF, i2, i3, i4, z, z2, runnable);
    }

    public ne(Context context, Uri uri, RectF rectF, int i, int i2, int i3, boolean z, boolean z2, Runnable runnable) {
        this.f411a = null;
        this.e = 0;
        this.g = null;
        this.k = "jpg";
        this.b = context;
        this.f411a = uri;
        a(rectF, i, i2, i3, z, z2, runnable);
    }

    public ne(Context context, String str, RectF rectF, int i, int i2, int i3, boolean z, boolean z2, Runnable runnable) {
        this.f411a = null;
        this.e = 0;
        this.g = null;
        this.k = "jpg";
        this.b = context;
        this.c = str;
        a(rectF, i, i2, i3, z, z2, runnable);
    }

    public ne(byte[] bArr, RectF rectF, int i, int i2, int i3, boolean z, boolean z2, Runnable runnable) {
        this.f411a = null;
        this.e = 0;
        this.g = null;
        this.k = "jpg";
        this.d = bArr;
        a(rectF, i, i2, i3, z, z2, runnable);
    }

    private void a(RectF rectF, int i, int i2, int i3, boolean z, boolean z2, Runnable runnable) {
        this.g = rectF;
        this.j = i;
        this.h = i2;
        this.i = i3;
        this.l = z;
        this.m = z2;
        this.o = runnable;
    }

    private void d() {
        if (this.f411a == null && this.e == 0 && this.c == null && this.d == null) {
            Log.w("Launcher3.CropActivity", "cannot read original file, no input URI, resource ID, or image byte array given");
            return;
        }
        com.android.b.a.b.a(this.f);
        try {
            if (this.f411a != null) {
                this.f = new BufferedInputStream(this.b.getContentResolver().openInputStream(this.f411a));
            } else if (this.c != null) {
                this.f = this.b.openFileInput(this.c);
            } else if (this.d != null) {
                this.f = new BufferedInputStream(new ByteArrayInputStream(this.d));
            } else {
                this.f = new BufferedInputStream(this.p.openRawResource(this.e));
            }
        } catch (FileNotFoundException e) {
            Log.w("Launcher3.CropActivity", "cannot read file: " + this.f411a.toString(), e);
        }
    }

    public Point a() {
        d();
        if (this.f == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(this.f, null, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            return null;
        }
        return new Point(options.outWidth, options.outHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        return Boolean.valueOf(c());
    }

    public void a(RectF rectF) {
        this.g = rectF;
    }

    public void a(nf nfVar) {
        this.q = nfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (this.o != null) {
            this.o.run();
        }
    }

    public void a(Runnable runnable) {
        this.o = runnable;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public Bitmap b() {
        return this.n;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:87:0x02bb  */
    public boolean c() throws IOException {
        boolean z;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        Bitmap bitmapDecodeRegion;
        Bitmap bitmapCreateBitmap;
        boolean z2;
        Bitmap bitmapDecodeStream = null;
        d();
        WallpaperManager wallpaperManager = this.l ? WallpaperManager.getInstance(this.b.getApplicationContext()) : null;
        LauncherApplication.l = true;
        SharedPreferences.Editor editorEdit = com.syu.g.l.c().edit();
        editorEdit.putBoolean("mAppWallPaper", LauncherApplication.l);
        editorEdit.commit();
        if (this.l && this.r && this.f != null) {
            try {
                wallpaperManager.setStream(this.f);
                z2 = false;
            } catch (IOException e) {
                Log.w("Launcher3.CropActivity", "cannot write stream to wallpaper", e);
                z2 = true;
            }
            return !z2;
        }
        if (this.f != null) {
            Rect rect = new Rect();
            Matrix matrix = new Matrix();
            Matrix matrix2 = new Matrix();
            if (this.j > 0) {
                matrix.setRotate(this.j);
                matrix2.setRotate(-this.j);
                this.g.roundOut(rect);
                this.g = new RectF(rect);
                Point pointA = a();
                float[] fArr = {pointA.x, pointA.y};
                matrix.mapPoints(fArr);
                fArr[0] = Math.abs(fArr[0]);
                fArr[1] = Math.abs(fArr[1]);
                this.g.offset((-fArr[0]) / 2.0f, (-fArr[1]) / 2.0f);
                matrix2.mapRect(this.g);
                this.g.offset(pointA.x / 2, pointA.y / 2);
                d();
            }
            this.g.roundOut(rect);
            if (rect.width() <= 0 || rect.height() <= 0) {
                Log.w("Launcher3.CropActivity", "crop has bad values for full size image");
                return false;
            }
            int iMin = Math.min(rect.width() / this.h, rect.height() / this.i);
            try {
                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(this.f, true);
            } catch (IOException e2) {
                Log.w("Launcher3.CropActivity", "cannot open region decoder for file: " + this.f411a.toString(), e2);
                bitmapRegionDecoderNewInstance = null;
            }
            if (bitmapRegionDecoderNewInstance != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (iMin > 1) {
                    options.inSampleSize = iMin;
                }
                bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                bitmapRegionDecoderNewInstance.recycle();
            } else {
                bitmapDecodeRegion = null;
            }
            if (bitmapDecodeRegion == null) {
                d();
                if (this.f != null) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    if (iMin > 1) {
                        options2.inSampleSize = iMin;
                    }
                    bitmapDecodeStream = BitmapFactory.decodeStream(this.f, null, options2);
                }
                if (bitmapDecodeStream != null) {
                    this.g.left /= iMin;
                    this.g.top /= iMin;
                    this.g.bottom /= iMin;
                    this.g.right /= iMin;
                    this.g.roundOut(rect);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream);
                } else {
                    bitmapCreateBitmap = bitmapDecodeRegion;
                }
            } else {
                bitmapCreateBitmap = bitmapDecodeRegion;
            }
            if (bitmapCreateBitmap == null) {
                Log.w("Launcher3.CropActivity", "cannot decode file: " + this.f411a.toString());
                return false;
            }
            if ((this.h > 0 && this.i > 0) || this.j > 0) {
                float[] fArr2 = {bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()};
                matrix.mapPoints(fArr2);
                fArr2[0] = Math.abs(fArr2[0]);
                fArr2[1] = Math.abs(fArr2[1]);
                if (this.h <= 0 || this.i <= 0) {
                    this.h = Math.round(fArr2[0]);
                    this.i = Math.round(fArr2[1]);
                }
                RectF rectF = new RectF(0.0f, 0.0f, fArr2[0], fArr2[1]);
                RectF rectF2 = new RectF(0.0f, 0.0f, this.h, this.i);
                Matrix matrix3 = new Matrix();
                if (this.j == 0) {
                    matrix3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                } else {
                    Matrix matrix4 = new Matrix();
                    matrix4.setTranslate((-bitmapCreateBitmap.getWidth()) / 2.0f, (-bitmapCreateBitmap.getHeight()) / 2.0f);
                    Matrix matrix5 = new Matrix();
                    matrix5.setRotate(this.j);
                    Matrix matrix6 = new Matrix();
                    matrix6.setTranslate(fArr2[0] / 2.0f, fArr2[1] / 2.0f);
                    Matrix matrix7 = new Matrix();
                    matrix7.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                    Matrix matrix8 = new Matrix();
                    matrix8.setConcat(matrix5, matrix4);
                    Matrix matrix9 = new Matrix();
                    matrix9.setConcat(matrix7, matrix6);
                    matrix3.setConcat(matrix9, matrix8);
                }
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap((int) rectF2.width(), (int) rectF2.height(), Bitmap.Config.ARGB_8888);
                if (bitmapCreateBitmap2 != null) {
                    Canvas canvas = new Canvas(bitmapCreateBitmap2);
                    Paint paint = new Paint();
                    paint.setFilterBitmap(true);
                    canvas.drawBitmap(bitmapCreateBitmap, matrix3, paint);
                    bitmapCreateBitmap = bitmapCreateBitmap2;
                }
            }
            if (this.m) {
                this.n = bitmapCreateBitmap;
            }
            Bitmap.CompressFormat compressFormatB = WallpaperCropActivity.b(WallpaperCropActivity.c(this.k));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
            if (!bitmapCreateBitmap.compress(compressFormatB, 90, byteArrayOutputStream)) {
                Log.w("Launcher3.CropActivity", "cannot compress bitmap");
                z = true;
            } else if (!this.l || wallpaperManager == null) {
                z = false;
            } else {
                try {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    wallpaperManager.setStream(new ByteArrayInputStream(byteArray));
                    if (this.q != null) {
                        this.q.a(byteArray);
                        z = false;
                    } else {
                        z = false;
                    }
                } catch (IOException e3) {
                    Log.w("Launcher3.CropActivity", "cannot write stream to wallpaper", e3);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        return !z;
    }
}
