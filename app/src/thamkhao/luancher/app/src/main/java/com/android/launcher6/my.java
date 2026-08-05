package com.android.launcher6;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class my {
    static int[] d;
    static int e;
    private static int f = -1;
    private static int g = -1;
    private static int h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f404a = -1;
    public static int b = -1;
    public static int c = 0;
    private static final Paint i = new Paint();
    private static final Paint j = new Paint();
    private static final Paint k = new Paint();
    private static final Paint l = new Paint();
    private static final Rect m = new Rect();
    private static final Canvas n = new Canvas();

    static {
        n.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        d = new int[]{SupportMenu.CATEGORY_MASK, -16711936, -16776961};
        e = 0;
    }

    public static float a(View view, View view2, int[] iArr) {
        float scaleX;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        while (view != view2) {
            arrayList.add(view);
            view = (View) view.getParent();
        }
        arrayList.add(view2);
        float f2 = 1.0f;
        Matrix matrix = new Matrix();
        int size = arrayList.size() - 1;
        while (size >= 0) {
            View view3 = (View) arrayList.get(size);
            View view4 = size > 0 ? (View) arrayList.get(size - 1) : null;
            fArr[0] = fArr[0] + view3.getScrollX();
            fArr[1] = view3.getScrollY() + fArr[1];
            if (view4 != null) {
                fArr[0] = fArr[0] - view4.getLeft();
                fArr[1] = fArr[1] - view4.getTop();
                view4.getMatrix().invert(matrix);
                matrix.mapPoints(fArr);
                scaleX = view4.getScaleX() * f2;
            } else {
                scaleX = f2;
            }
            size--;
            f2 = scaleX;
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return f2;
    }

    public static float a(View view, View view2, int[] iArr, boolean z) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        for (View view3 = view; view3 != view2 && view3 != null; view3 = (View) view3.getParent()) {
            arrayList.add(view3);
        }
        arrayList.add(view2);
        int size = arrayList.size();
        float scaleX = 1.0f;
        for (int i2 = 0; i2 < size; i2++) {
            View view4 = (View) arrayList.get(i2);
            if (view4 != view || z) {
                fArr[0] = fArr[0] - view4.getScrollX();
                fArr[1] = fArr[1] - view4.getScrollY();
            }
            view4.getMatrix().mapPoints(fArr);
            fArr[0] = fArr[0] + view4.getLeft();
            fArr[1] = fArr[1] + view4.getTop();
            scaleX *= view4.getScaleX();
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return scaleX;
    }

    static Bitmap a(Bitmap bitmap, Context context) {
        int i2 = f404a;
        int i3 = b;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i2 || height <= i3) {
            return (width == i2 && height == i3) ? bitmap : a(new BitmapDrawable(context.getResources(), bitmap), context);
        }
        return Bitmap.createBitmap(bitmap, (width - i2) / 2, (height - i3) / 2, i2, i3);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    static Bitmap a(Drawable drawable, Context context) {
        int i2;
        int i3;
        Bitmap bitmapCreateBitmap;
        synchronized (n) {
            if (g == -1) {
                a(context);
            }
            int i4 = g;
            int i5 = h;
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(i4);
                paintDrawable.setIntrinsicHeight(i5);
            } else if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                i2 = i5;
                i3 = i4;
            } else {
                float f2 = intrinsicWidth / intrinsicHeight;
                if (intrinsicWidth > intrinsicHeight) {
                    i2 = (int) (i4 / f2);
                    i3 = i4;
                } else if (intrinsicHeight > intrinsicWidth) {
                    i3 = (int) (i5 * f2);
                    i2 = i5;
                } else {
                    i2 = i5;
                    i3 = i4;
                }
            }
            int i6 = f404a;
            int i7 = b;
            bitmapCreateBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = n;
            canvas.setBitmap(bitmapCreateBitmap);
            int i8 = (i6 - i3) / 2;
            int i9 = (i7 - i2) / 2;
            m.set(drawable.getBounds());
            drawable.setBounds(i8, i9, i3 + i8, i2 + i9);
            drawable.draw(canvas);
            drawable.setBounds(m);
            canvas.setBitmap(null);
        }
        return bitmapCreateBitmap;
    }

    static Drawable a(Bitmap bitmap) {
        ci ciVar = new ci(bitmap);
        ciVar.setFilterBitmap(true);
        a(ciVar);
        return ciVar;
    }

    public static void a(int i2) {
        g = i2;
        h = g - LauncherApplication.f88a.getResources().getInteger(R.integer.utility_icon_height);
        f404a = g;
        b = h;
    }

    public static void a(Activity activity, Intent intent, int i2) {
        try {
            activity.startActivityForResult(intent, i2);
        } catch (ActivityNotFoundException e2) {
            Toast.makeText(activity, R.string.activity_not_found, 0).show();
        } catch (SecurityException e3) {
            Toast.makeText(activity, R.string.activity_not_found, 0).show();
            Log.e("Launcher.Utilities", "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e3);
        }
    }

    private static void a(Context context) {
        Resources resources = context.getResources();
        float f2 = resources.getDisplayMetrics().density;
        f = (int) resources.getDimension(R.dimen.icon_size);
        g = (int) resources.getDimension(R.dimen.app_icon_size);
        h = g - LauncherApplication.f88a.getResources().getInteger(R.integer.utility_icon_height);
        f404a = g;
        b = h;
        i.setMaskFilter(new BlurMaskFilter(f2 * 5.0f, BlurMaskFilter.Blur.NORMAL));
        j.setColor(-15616);
        k.setColor(-29184);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.2f);
        l.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        l.setAlpha(136);
    }

    public static void a(Rect rect, float f2) {
        if (f2 != 1.0f) {
            rect.left = (int) ((rect.left * f2) + 0.5f);
            rect.top = (int) ((rect.top * f2) + 0.5f);
            rect.right = (int) ((rect.right * f2) + 0.5f);
            rect.bottom = (int) ((rect.bottom * f2) + 0.5f);
        }
    }

    static void a(Drawable drawable) {
        drawable.setBounds(0, 0, f404a, b);
    }

    static Bitmap b(Bitmap bitmap, Context context) {
        synchronized (n) {
            if (g == -1) {
                a(context);
            }
            if (bitmap.getWidth() != g || bitmap.getHeight() != h) {
                bitmap = a(new BitmapDrawable(context.getResources(), bitmap), context);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x011e  */
    static Bitmap b(Drawable drawable, Context context) {
        int i2;
        int i3;
        Bitmap bitmapCreateBitmap;
        synchronized (n) {
            if (g == -1) {
                a(context);
            }
            int i4 = g;
            int i5 = h;
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(i4);
                paintDrawable.setIntrinsicHeight(i5);
            } else if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                i2 = i5;
                i3 = i4;
            } else {
                float f2 = intrinsicWidth / intrinsicHeight;
                if (intrinsicWidth > intrinsicHeight) {
                    i2 = (int) (i4 / f2);
                    i3 = i4;
                } else if (intrinsicHeight > intrinsicWidth) {
                    i3 = (int) (i5 * f2);
                    i2 = i5;
                } else {
                    i2 = i5;
                    i3 = i4;
                }
            }
            int i6 = f404a;
            int i7 = b;
            bitmapCreateBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = n;
            canvas.setBitmap(bitmapCreateBitmap);
            int i8 = (i6 - i3) / 2;
            int i9 = (i7 - i2) / 2;
            int i10 = (int) (((double) i3) / (((double) i3) / ((double) f)));
            int i11 = (int) (((double) i2) / (((double) i2) / ((double) f)));
            int i12 = (i6 - i10) / 2;
            int i13 = ((i7 - i11) / 2) - 2;
            Drawable drawableA = com.fyt.b.g.a(R.drawable.icon_bg + c);
            if (context.getResources().getBoolean(R.bool.apps_thrid_icon)) {
                c++;
                if (c >= context.getResources().getInteger(R.integer.utility_minfiy_icon_count)) {
                    c = 0;
                }
            }
            int intrinsicWidth2 = drawableA.getIntrinsicWidth();
            int intrinsicHeight2 = drawableA.getIntrinsicHeight();
            drawableA.setBounds((i6 - intrinsicWidth2) / 2, (i7 - intrinsicHeight2) / 2, ((i6 - intrinsicWidth2) / 2) + intrinsicWidth2, ((i7 - intrinsicHeight2) / 2) + intrinsicHeight2);
            drawableA.draw(canvas);
            drawableA.setBounds(m);
            int integer = LauncherApplication.f88a.getResources().getInteger(R.integer.utility_minfiy_gap);
            m.set(drawable.getBounds());
            drawable.setBounds(i12 + integer, (i13 + integer) - 0, (i10 + i12) - integer, ((i11 + i13) - integer) - 0);
            drawable.draw(canvas);
            drawable.setBounds(m);
        }
        return bitmapCreateBitmap;
    }

    public static void b(Rect rect, float f2) {
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        rect.offset(-iCenterX, -iCenterY);
        a(rect, f2);
        rect.offset(iCenterX, iCenterY);
    }

    static void b(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicWidth());
    }

    public static Bitmap c(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        synchronized (n) {
            if (g == -1) {
                a(com.syu.g.l.a());
            }
            int i2 = g;
            int i3 = h;
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(i2);
                paintDrawable.setIntrinsicHeight(i3);
            } else if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(com.syu.g.l.a().getResources().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0) {
            }
            int i4 = f404a;
            int i5 = b;
            bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            Canvas canvas = n;
            canvas.setBitmap(bitmapCreateBitmap);
            int i6 = (i4 - i2) / 2;
            int i7 = (i5 - i3) / 2;
            Drawable drawableA = com.fyt.b.g.a(R.drawable.icon_bg);
            drawableA.getIntrinsicWidth();
            drawableA.getIntrinsicHeight();
            drawableA.draw(canvas);
            drawableA.setBounds(m);
            m.set(drawable.getBounds());
            drawable.setBounds(i6 + 0, 0 + i7, i6 + i2, i7 + i3);
            drawable.draw(canvas);
            drawable.setBounds(m);
        }
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0115  */
    public static Bitmap d(Drawable drawable) {
        int i2;
        int i3;
        Bitmap bitmapCreateBitmap;
        synchronized (n) {
            if (g == -1) {
                a(com.syu.g.l.a());
            }
            int i4 = g;
            int i5 = h;
            if (drawable instanceof PaintDrawable) {
                PaintDrawable paintDrawable = (PaintDrawable) drawable;
                paintDrawable.setIntrinsicWidth(i4);
                paintDrawable.setIntrinsicHeight(i5);
            } else if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap().getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(com.fyt.b.g.c().getDisplayMetrics());
                }
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                i2 = i5;
                i3 = i4;
            } else {
                float f2 = intrinsicWidth / intrinsicHeight;
                if (intrinsicWidth > intrinsicHeight) {
                    i2 = (int) (i4 / f2);
                    i3 = i4;
                } else if (intrinsicHeight > intrinsicWidth) {
                    i3 = (int) (i5 * f2);
                    i2 = i5;
                } else {
                    i2 = i5;
                    i3 = i4;
                }
            }
            int i6 = f404a;
            int i7 = b;
            bitmapCreateBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = n;
            canvas.setBitmap(bitmapCreateBitmap);
            int i8 = (i6 - i3) / 2;
            int i9 = (i7 - i2) / 2;
            int i10 = (int) (((double) i3) / (((double) i3) / ((double) f)));
            int i11 = (int) (((double) i2) / (((double) i2) / ((double) f)));
            int i12 = (i6 - i10) / 2;
            int i13 = ((i7 - i11) / 2) - 2;
            Drawable drawableA = com.fyt.b.g.a(R.drawable.icon_bg);
            int intrinsicWidth2 = drawableA.getIntrinsicWidth();
            int intrinsicHeight2 = drawableA.getIntrinsicHeight();
            drawableA.setBounds((i6 - intrinsicWidth2) / 2, (i7 - intrinsicHeight2) / 2, ((i6 - intrinsicWidth2) / 2) + intrinsicWidth2, ((i7 - intrinsicHeight2) / 2) + intrinsicHeight2);
            drawableA.draw(canvas);
            drawableA.setBounds(m);
            int integer = LauncherApplication.f88a.getResources().getInteger(R.integer.utility_minfiy_gap);
            int integer2 = LauncherApplication.f88a.getResources().getInteger(R.integer.utility_minfiy_top_offest);
            int integer3 = LauncherApplication.f88a.getResources().getInteger(R.integer.utility_minfiy_left_offest);
            m.set(drawable.getBounds());
            drawable.setBounds((i12 + integer) - integer3, (i13 + integer) - integer2, ((i10 + i12) - integer) - integer3, ((i11 + i13) - integer) - integer2);
            drawable.draw(canvas);
            drawable.setBounds(m);
        }
        return bitmapCreateBitmap;
    }
}
