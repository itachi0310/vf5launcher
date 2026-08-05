package com.android.launcher6;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ob {
    private static HashSet v = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f429a;
    private int b;
    private String c;
    private Context d;
    private PackageManager e;
    private lt f;
    private String n;
    private int p;
    private dv q;
    private of s;
    private HashMap t;
    private ArrayList u;
    private aa g = new aa();
    private mc h = new mc();
    private ad i = new ad();
    private ad j = new ad();
    private mj k = new mj();
    private mj l = new mj();
    private mc m = new mc();
    private ab o = new ab();
    private final float r = 0.25f;

    public ob(Context context) {
        ip ipVarA = ip.a();
        bl blVarA = ipVarA.i().a();
        this.d = context;
        this.e = this.d.getPackageManager();
        this.p = blVarA.u;
        this.q = ipVarA.d();
        this.s = ipVarA.f();
        this.t = new HashMap();
        this.u = new ArrayList();
    }

    private Bitmap a(ResolveInfo resolveInfo, int i, int i2, Bitmap bitmap) {
        Bitmap bitmapCreateBitmap;
        Bitmap bitmap2 = (Bitmap) this.g.c();
        Canvas canvas = (Canvas) this.i.c();
        if (bitmap2 != null && bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            canvas.setBitmap(bitmap2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.setBitmap(null);
            bitmapCreateBitmap = bitmap2;
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.g.a(bitmapCreateBitmap);
        }
        Drawable drawableA = this.q.a(resolveInfo);
        int dimensionPixelOffset = this.d.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_top);
        int dimensionPixelOffset2 = this.d.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_left);
        int dimensionPixelOffset3 = (i - dimensionPixelOffset2) - this.d.getResources().getDimensionPixelOffset(R.dimen.shortcut_preview_padding_right);
        a(drawableA, bitmapCreateBitmap, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset3, dimensionPixelOffset3);
        if (bitmap != null && (bitmap.getWidth() != i || bitmap.getHeight() != i2)) {
            throw new RuntimeException("Improperly sized bitmap passed as argument");
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        canvas.setBitmap(bitmap);
        Paint paint = (Paint) this.h.c();
        if (paint == null) {
            paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            paint.setAlpha(15);
            this.h.a(paint);
        }
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        a(drawableA, bitmap, 0, 0, this.p, this.p);
        return bitmap;
    }

    private Bitmap a(String str, Bitmap bitmap) {
        if (this.n == null) {
            this.n = "name = ? AND size = ?";
        }
        Cursor cursorQuery = this.s.getReadableDatabase().query("shortcut_and_widget_previews", new String[]{"preview_bitmap"}, this.n, new String[]{str, this.c}, null, null, null, null);
        if (cursorQuery.getCount() <= 0) {
            cursorQuery.close();
            return null;
        }
        cursorQuery.moveToFirst();
        byte[] blob = cursorQuery.getBlob(0);
        cursorQuery.close();
        BitmapFactory.Options options = (BitmapFactory.Options) this.o.c();
        options.inBitmap = bitmap;
        options.inSampleSize = 1;
        try {
            return BitmapFactory.decodeByteArray(blob, 0, blob.length, options);
        } catch (IllegalArgumentException e) {
            b(this.s, str);
            return null;
        }
    }

    public static void a(Drawable drawable, Bitmap bitmap, int i, int i2, int i3, int i4) {
        a(drawable, bitmap, i, i2, i3, i4, 1.0f);
    }

    private static void a(Drawable drawable, Bitmap bitmap, int i, int i2, int i3, int i4, float f) {
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.scale(f, f);
            Rect rectCopyBounds = drawable.copyBounds();
            drawable.setBounds(i, i2, i + i3, i2 + i4);
            drawable.draw(canvas);
            drawable.setBounds(rectCopyBounds);
            canvas.setBitmap(null);
        }
    }

    public static void a(of ofVar, String str) {
        synchronized (v) {
            v.add(str);
        }
        new od(ofVar, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    private static String b(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof AppWidgetProviderInfo) {
            sb.append("Widget:");
            sb.append(((AppWidgetProviderInfo) obj).provider.flattenToString());
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        sb.append("Shortcut:");
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        sb.append(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name).flattenToString());
        String string2 = sb.toString();
        sb.setLength(0);
        return string2;
    }

    public static void b(of ofVar, String str) {
        new oe(ofVar, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    private String c(Object obj) {
        return obj instanceof AppWidgetProviderInfo ? ((AppWidgetProviderInfo) obj).provider.getPackageName() : ((ResolveInfo) obj).activityInfo.packageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj, Bitmap bitmap) {
        String strB = b(obj);
        SQLiteDatabase writableDatabase = this.s.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", strB);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        contentValues.put("preview_bitmap", byteArrayOutputStream.toByteArray());
        contentValues.put("size", this.c);
        writableDatabase.insert("shortcut_and_widget_previews", null, contentValues);
    }

    public int a(int i) {
        return Math.min(this.f429a, this.f.b(i));
    }

    public Bitmap a(AppWidgetProviderInfo appWidgetProviderInfo, Bitmap bitmap) {
        int[] iArrA = Launcher.a(this.d, appWidgetProviderInfo);
        return a(appWidgetProviderInfo.provider, appWidgetProviderInfo.previewImage, appWidgetProviderInfo.icon, iArrA[0], iArrA[1], a(iArrA[0]), b(iArrA[1]), bitmap, null);
    }

    public Bitmap a(ComponentName componentName, int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap, int[] iArr) {
        Drawable drawable;
        int intrinsicHeight;
        int intrinsicWidth;
        Bitmap bitmap2;
        String packageName = componentName.getPackageName();
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        if (i6 < 0) {
        }
        if (i != 0) {
            Drawable drawable2 = this.e.getDrawable(packageName, i, null);
            if (drawable2 == null) {
                Log.w("WidgetPreviewLoader", "Can't load widget preview drawable 0x" + Integer.toHexString(i) + " for provider: " + componentName);
            }
            drawable = drawable2;
        } else {
            drawable = null;
        }
        boolean z = drawable != null;
        if (z) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
            bitmap2 = null;
        } else {
            if (i3 < 1) {
                i3 = 1;
            }
            if (i4 < 1) {
                i4 = 1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.d.getResources().getDrawable(R.drawable.widget_tile);
            int intrinsicWidth2 = bitmapDrawable.getIntrinsicWidth();
            int intrinsicHeight2 = bitmapDrawable.getIntrinsicHeight();
            int i7 = intrinsicWidth2 * i3;
            int i8 = intrinsicHeight2 * i4;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
            Canvas canvas = (Canvas) this.j.c();
            canvas.setBitmap(bitmapCreateBitmap);
            bitmapDrawable.setBounds(0, 0, i7, i8);
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            bitmapDrawable.draw(canvas);
            canvas.setBitmap(null);
            float fMin = Math.min(Math.min(i7, i8) / ((((int) (this.p * 0.25f)) * 2) + this.p), 1.0f);
            try {
                int i9 = (int) ((intrinsicWidth2 - (this.p * fMin)) / 2.0f);
                int i10 = (int) ((intrinsicHeight2 - (this.p * fMin)) / 2.0f);
                Drawable drawableA = i2 > 0 ? this.q.a(packageName, i2) : null;
                if (drawableA != null) {
                    a(drawableA, bitmapCreateBitmap, i9, i10, (int) (this.p * fMin), (int) (this.p * fMin));
                    intrinsicHeight = i8;
                    intrinsicWidth = i7;
                    bitmap2 = bitmapCreateBitmap;
                } else {
                    intrinsicHeight = i8;
                    intrinsicWidth = i7;
                    bitmap2 = bitmapCreateBitmap;
                }
            } catch (Resources.NotFoundException e) {
                intrinsicHeight = i8;
                intrinsicWidth = i7;
                bitmap2 = bitmapCreateBitmap;
            }
        }
        if (iArr != null) {
            iArr[0] = intrinsicWidth;
        }
        float f = intrinsicWidth > i5 ? i5 / intrinsicWidth : 1.0f;
        if (f != 1.0f) {
            intrinsicWidth = (int) (intrinsicWidth * f);
            intrinsicHeight = (int) (f * intrinsicHeight);
        }
        Bitmap bitmapCreateBitmap2 = bitmap == null ? Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888) : bitmap;
        int width = (bitmapCreateBitmap2.getWidth() - intrinsicWidth) / 2;
        if (z) {
            a(drawable, bitmapCreateBitmap2, width, 0, intrinsicWidth, intrinsicHeight);
        } else {
            Canvas canvas2 = (Canvas) this.j.c();
            Rect rect = (Rect) this.k.c();
            Rect rect2 = (Rect) this.l.c();
            canvas2.setBitmap(bitmapCreateBitmap2);
            rect.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            rect2.set(width, 0, intrinsicWidth + width, intrinsicHeight);
            Paint paint = (Paint) this.m.c();
            if (paint == null) {
                paint = new Paint();
                paint.setFilterBitmap(true);
                this.m.a(paint);
            }
            canvas2.drawBitmap(bitmap2, rect, rect2, paint);
            canvas2.setBitmap(null);
        }
        return bitmapCreateBitmap2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x006c A[Catch: all -> 0x00c5, TryCatch #2 {, blocks: (B:33:0x0056, B:35:0x005c, B:37:0x0064, B:42:0x0076, B:43:0x008b, B:39:0x006c, B:57:0x00b4), top: B:78:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4 A[Catch: all -> 0x00c5, LOOP:0: B:32:0x0054->B:57:0x00b4, LOOP_END, TRY_ENTER, TryCatch #2 {, blocks: (B:33:0x0056, B:35:0x005c, B:37:0x0064, B:42:0x0076, B:43:0x008b, B:39:0x006c, B:57:0x00b4), top: B:78:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0074 A[EDGE_INSN: B:84:0x0074->B:41:0x0074 BREAK  A[LOOP:0: B:32:0x0054->B:57:0x00b4], SYNTHETIC] */
    public Bitmap a(Object obj) {
        boolean z;
        Bitmap bitmapCreateBitmap;
        String strB = b(obj);
        String strC = c(obj);
        synchronized (v) {
            z = !v.contains(strC);
        }
        if (!z) {
            return null;
        }
        if (z) {
            synchronized (this.t) {
                if (this.t.containsKey(strB) && ((WeakReference) this.t.get(strB)).get() != null) {
                    return (Bitmap) ((WeakReference) this.t.get(strB)).get();
                }
            }
        }
        synchronized (this.u) {
            bitmapCreateBitmap = null;
            while (true) {
                if (bitmapCreateBitmap != null) {
                    if (bitmapCreateBitmap.isMutable() && bitmapCreateBitmap.getWidth() == this.f429a && bitmapCreateBitmap.getHeight() == this.b) {
                        break;
                    }
                    if (this.u.size() <= 0) {
                        break;
                    }
                    bitmapCreateBitmap = (Bitmap) ((SoftReference) this.u.remove(0)).get();
                } else {
                    if (this.u.size() <= 0) {
                        break;
                        break;
                    }
                    bitmapCreateBitmap = (Bitmap) ((SoftReference) this.u.remove(0)).get();
                }
                throw th;
            }
            if (bitmapCreateBitmap != null) {
                Canvas canvas = (Canvas) this.j.c();
                canvas.setBitmap(bitmapCreateBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.setBitmap(null);
            }
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(this.f429a, this.b, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmapA = z ? a(strB, bitmapCreateBitmap) : null;
        if (bitmapA != null) {
            synchronized (this.t) {
                this.t.put(strB, new WeakReference(bitmapA));
            }
            return bitmapA;
        }
        Bitmap bitmapB = b(obj, bitmapCreateBitmap);
        if (bitmapB != bitmapCreateBitmap) {
            throw new RuntimeException("generatePreview is not recycling the bitmap " + obj);
        }
        synchronized (this.t) {
            this.t.put(strB, new WeakReference(bitmapB));
        }
        new oc(this, obj, bitmapB).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        return bitmapB;
    }

    public void a(int i, int i2, lt ltVar) {
        this.f429a = i;
        this.b = i2;
        this.c = String.valueOf(i) + "x" + i2;
        this.f = ltVar;
    }

    public void a(Object obj, Bitmap bitmap) {
        String strB = b(obj);
        synchronized (this.t) {
            if (this.t.containsKey(strB)) {
                Bitmap bitmap2 = (Bitmap) ((WeakReference) this.t.get(strB)).get();
                if (bitmap2 != bitmap) {
                    throw new RuntimeException("Bitmap passed in doesn't match up");
                }
                this.t.remove(strB);
                if (bitmap.isMutable()) {
                    synchronized (this.u) {
                        this.u.add(new SoftReference(bitmap2));
                    }
                }
            }
        }
    }

    public int b(int i) {
        return Math.min(this.b, this.f.c(i));
    }

    public Bitmap b(Object obj, Bitmap bitmap) {
        if (bitmap == null || (bitmap.getWidth() == this.f429a && bitmap.getHeight() == this.b)) {
            return obj instanceof AppWidgetProviderInfo ? a((AppWidgetProviderInfo) obj, bitmap) : a((ResolveInfo) obj, this.f429a, this.b, bitmap);
        }
        throw new RuntimeException("Improperly sized bitmap passed as argument");
    }
}
