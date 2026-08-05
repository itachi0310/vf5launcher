package com.android.launcher6;

import android.app.ActionBar;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperCropActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CropView f98a;

    public static int a(Context context, Uri uri) {
        return a((String) null, (Resources) null, 0, context, uri);
    }

    public static int a(Resources resources, int i) {
        return a((String) null, resources, i, (Context) null, (Uri) null);
    }

    public static int a(String str) {
        return a(str, (Resources) null, 0, (Context) null, (Uri) null);
    }

    private static int a(String str, Resources resources, int i, Context context, Uri uri) {
        com.android.b.b.c cVar = new com.android.b.b.c();
        try {
            if (str != null) {
                cVar.a(str);
            } else if (uri != null) {
                cVar.a((InputStream) new BufferedInputStream(context.getContentResolver().openInputStream(uri)));
            } else {
                cVar.a((InputStream) new BufferedInputStream(resources.openRawResource(i)));
            }
            Integer numC = cVar.c(com.android.b.b.c.j);
            if (numC != null) {
                return com.android.b.b.c.b(numC.shortValue());
            }
        } catch (Exception e) {
            Log.w("Launcher3.CropActivity", "Getting exif data failed", e);
        }
        return 0;
    }

    protected static Point a(Resources resources, WindowManager windowManager) {
        int iMin;
        Point point = new Point();
        Point point2 = new Point();
        windowManager.getDefaultDisplay().getCurrentSizeRange(point, point2);
        int iMax = Math.max(point2.x, point2.y);
        int iMax2 = Math.max(point.x, point.y);
        if (Build.VERSION.SDK_INT >= 17) {
            Point point3 = new Point();
            windowManager.getDefaultDisplay().getRealSize(point3);
            iMax = Math.max(point3.x, point3.y);
            iMax2 = Math.min(point3.x, point3.y);
        }
        if (a(resources)) {
            iMin = (int) (b(iMax, iMax2) * iMax);
        } else {
            int i = iMax2;
            iMin = Math.min((int) (iMax2 * 2.0f), iMax);
            iMax = i;
        }
        return new Point(iMin, iMax);
    }

    protected static RectF a(int i, int i2, int i3, int i4, boolean z) {
        RectF rectF = new RectF();
        if (i / i2 > i3 / i4) {
            rectF.top = 0.0f;
            rectF.bottom = i2;
            rectF.left = (i - ((i3 / i4) * i2)) / 2.0f;
            rectF.right = i - rectF.left;
            if (z) {
                rectF.right -= rectF.left;
                rectF.left = 0.0f;
            }
        } else {
            rectF.left = 0.0f;
            rectF.right = i;
            rectF.top = (i2 - ((i4 / i3) * i)) / 2.0f;
            rectF.bottom = i2 - rectF.top;
        }
        return rectF;
    }

    public static void a(Resources resources, SharedPreferences sharedPreferences, WindowManager windowManager, WallpaperManager wallpaperManager) {
        new nd("suggestWallpaperDimension", sharedPreferences, a(resources, windowManager), wallpaperManager).start();
    }

    private static boolean a(Resources resources) {
        return resources.getConfiguration().smallestScreenWidthDp > 721;
    }

    private static float b(int i, int i2) {
        return ((i / i2) * 0.30769226f) + 1.0076923f;
    }

    protected static Bitmap.CompressFormat b(String str) {
        return str.equals("png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public static String c() {
        return WallpaperCropActivity.class.getName();
    }

    protected static String c(String str) {
        if (str == null) {
            str = "jpg";
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.equals("png") || lowerCase.equals("gif")) ? "png" : "jpg";
    }

    protected void a() {
        setContentView(R.layout.wallpaper_cropper);
        this.f98a = (CropView) findViewById(R.id.cropView);
        Uri data = getIntent().getData();
        if (data == null) {
            Log.e("Launcher3.CropActivity", "No URI passed in intent, exiting WallpaperCropActivity");
            finish();
            return;
        }
        this.f98a.a(new com.android.c.a(this, data, 1024, a(this, data)), (Runnable) null);
        this.f98a.setTouchEnabled(true);
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(R.layout.actionbar_set_wallpaper);
        actionBar.getCustomView().setOnClickListener(new mz(this, data));
    }

    protected void a(int i, int i2) {
        SharedPreferences sharedPreferences = getSharedPreferences(c(), 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (i == 0 || i2 == 0) {
            editorEdit.remove("wallpaper.width");
            editorEdit.remove("wallpaper.height");
        } else {
            editorEdit.putInt("wallpaper.width", i);
            editorEdit.putInt("wallpaper.height", i2);
        }
        editorEdit.commit();
        a(getResources(), sharedPreferences, getWindowManager(), WallpaperManager.getInstance(this));
    }

    protected void a(Resources resources, int i, boolean z, String str) {
        int iA = a(resources, i);
        Point sourceDimensions = this.f98a.getSourceDimensions();
        Point pointA = a(getResources(), getWindowManager());
        new ne(this, resources, i, a(sourceDimensions.x, sourceDimensions.y, pointA.x, pointA.y, false), iA, pointA.x, pointA.y, true, false, new nb(this, z, str)).execute(new Void[0]);
    }

    protected void a(Uri uri, nf nfVar, boolean z) {
        boolean z2 = this.f98a.getLayoutDirection() == 0;
        Point point = new Point();
        Point point2 = new Point();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(point, point2);
        Point point3 = new Point();
        defaultDisplay.getSize(point3);
        int iMax = Math.max(point2.x, point2.y);
        int iMin = Math.min(point.x, point.y);
        int iB = a(getResources()) ? (int) (b(iMax, iMin) * iMax) : Math.max((int) (iMin * 2.0f), iMax);
        boolean z3 = point3.x < point3.y;
        int height = z3 ? this.f98a.getHeight() : Math.max(point2.x, point2.y);
        if (Build.VERSION.SDK_INT >= 17) {
            Point point4 = new Point();
            defaultDisplay.getRealSize(point4);
            height = Math.max(point4.x, point4.y);
        }
        RectF crop = this.f98a.getCrop();
        int imageRotation = this.f98a.getImageRotation();
        float width = this.f98a.getWidth() / crop.width();
        Point sourceDimensions = this.f98a.getSourceDimensions();
        Matrix matrix = new Matrix();
        matrix.setRotate(imageRotation);
        float[] fArr = {sourceDimensions.x, sourceDimensions.y};
        matrix.mapPoints(fArr);
        fArr[0] = Math.abs(fArr[0]);
        fArr[1] = Math.abs(fArr[1]);
        float fMin = Math.min(z2 ? fArr[0] - crop.right : crop.left, (iB / width) - crop.width());
        if (z2) {
            crop.right += fMin;
        } else {
            crop.left -= fMin;
        }
        if (z3) {
            crop.bottom = crop.top + (height / width);
        } else {
            float fMin2 = Math.min(Math.min(fArr[1] - crop.bottom, crop.top), ((height / width) - crop.height()) / 2.0f);
            crop.top -= fMin2;
            crop.bottom = fMin2 + crop.bottom;
        }
        int iRound = Math.round(crop.width() * width);
        int iRound2 = Math.round(crop.height() * width);
        ne neVar = new ne((Context) this, uri, crop, imageRotation, iRound, iRound2, true, false, (Runnable) new nc(this, iRound, iRound2, z));
        if (nfVar != null) {
            neVar.a(nfVar);
        }
        neVar.execute(new Void[0]);
    }

    protected void a(String str, boolean z) {
        ne neVar = new ne((Context) this, str, (RectF) null, a(str), 0, 0, true, false, (Runnable) null);
        neVar.a(new na(this, neVar.a(), z));
        neVar.a(true);
        neVar.execute(new Void[0]);
    }

    public boolean b() {
        return getResources().getBoolean(R.bool.allow_rotation);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        if (b()) {
            return;
        }
        setRequestedOrientation(1);
    }
}
