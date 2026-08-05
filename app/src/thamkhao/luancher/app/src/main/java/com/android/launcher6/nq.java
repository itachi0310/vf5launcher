package com.android.launcher6;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class nq extends nt {
    private Resources b;
    private int c;
    private Drawable d;
    private String e;

    public nq(Resources resources, int i, Drawable drawable, String str) {
        this.b = resources;
        this.c = i;
        this.d = drawable;
        this.e = str;
    }

    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        WallpaperPickerActivity.b = this.e;
        com.android.c.a aVar = new com.android.c.a(this.b, wallpaperPickerActivity, this.c, 1024, WallpaperCropActivity.a(this.b, this.c));
        CropView cropViewE = wallpaperPickerActivity.e();
        cropViewE.a(aVar, (Runnable) null);
        Point pointA = WallpaperCropActivity.a(wallpaperPickerActivity.getResources(), wallpaperPickerActivity.getWindowManager());
        WallpaperCropActivity.a(aVar.b(), aVar.c(), pointA.x, pointA.y, false);
        cropViewE.setTouchEnabled(false);
    }

    @Override // com.android.launcher6.nt
    public boolean a() {
        return true;
    }

    @Override // com.android.launcher6.nt
    public void b(WallpaperPickerActivity wallpaperPickerActivity) {
        wallpaperPickerActivity.a(this.b, this.c, true, WallpaperPickerActivity.b);
    }

    @Override // com.android.launcher6.nt
    public boolean b() {
        return true;
    }
}
