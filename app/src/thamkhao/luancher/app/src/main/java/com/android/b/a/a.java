package com.android.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.FloatMath;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a(float f) {
        int iFloor = (int) FloatMath.floor(1.0f / f);
        if (iFloor <= 1) {
            return 1;
        }
        return iFloor <= 8 ? b.b(iFloor) : (iFloor / 8) * 8;
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static Bitmap a(Bitmap bitmap, float f, boolean z) {
        int iRound = Math.round(bitmap.getWidth() * f);
        int iRound2 = Math.round(bitmap.getHeight() * f);
        if (iRound == bitmap.getWidth() && iRound2 == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, a(bitmap));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(f, f);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }
}
