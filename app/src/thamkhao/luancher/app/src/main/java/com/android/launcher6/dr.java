package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Canvas f186a = new Canvas();
    private boolean b;
    private int c;
    private int d;

    public dr(Context context) {
        Resources resources = context.getResources();
        this.c = resources.getColor(android.R.color.holo_blue_light);
        this.d = resources.getColor(android.R.color.holo_green_light);
    }

    private Bitmap a(ImageView imageView, Canvas canvas) {
        Drawable drawable = imageView.getDrawable();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.save();
        drawable.draw(canvas);
        canvas.restore();
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private Bitmap a(ImageView imageView, Canvas canvas, int i) {
        Drawable drawable = imageView.getDrawable();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.save();
        drawable.draw(canvas);
        canvas.restore();
        canvas.drawColor(i, PorterDuff.Mode.SRC_IN);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    void a(ImageView imageView) {
        if (this.b || imageView == null) {
            return;
        }
        this.b = true;
        Bitmap bitmapA = a(imageView, this.f186a);
        Bitmap bitmapA2 = a(imageView, this.f186a, this.c);
        Bitmap bitmapA3 = a(imageView, this.f186a, this.d);
        ci ciVar = new ci(bitmapA);
        ci ciVar2 = new ci(bitmapA2);
        ci ciVar3 = new ci(bitmapA3);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, ciVar2);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, ciVar2);
        stateListDrawable.addState(new int[]{R.attr.stateHotwordOn}, ciVar3);
        stateListDrawable.addState(new int[0], ciVar);
        imageView.setImageDrawable(stateListDrawable);
    }

    void b(ImageView imageView) {
        this.b = false;
        if (imageView != null) {
            imageView.invalidate();
        }
    }
}
