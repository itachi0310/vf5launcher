package com.android.launcher6;

import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class mm extends nt {
    private int b;
    private Drawable c;

    public mm(int i, Drawable drawable) {
        this.b = i;
        this.c = drawable;
    }

    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        File file = new File(wallpaperPickerActivity.getFilesDir(), wallpaperPickerActivity.f().b(this.b));
        CropView cropViewE = wallpaperPickerActivity.e();
        cropViewE.a(new com.android.c.a(wallpaperPickerActivity, file.getAbsolutePath(), 1024, WallpaperCropActivity.a(file.getAbsolutePath())), (Runnable) null);
        cropViewE.a();
        cropViewE.setTouchEnabled(false);
    }

    @Override // com.android.launcher6.nt
    public boolean a() {
        return true;
    }

    @Override // com.android.launcher6.nt
    public void b(WallpaperPickerActivity wallpaperPickerActivity) {
        com.syu.d.a.b("SavedWallpaperImages");
        wallpaperPickerActivity.a(wallpaperPickerActivity.f().b(this.b), true);
    }

    @Override // com.android.launcher6.nt
    public boolean b() {
        return true;
    }

    @Override // com.android.launcher6.nt
    public void c(WallpaperPickerActivity wallpaperPickerActivity) {
        wallpaperPickerActivity.f().c(this.b);
    }
}
