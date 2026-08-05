package com.android.launcher6;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class nr extends nt {
    private Uri b;

    public nr(Uri uri) {
        this.b = uri;
    }

    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        CropView cropViewE = wallpaperPickerActivity.e();
        cropViewE.a(new com.android.c.a(wallpaperPickerActivity, this.b, 1024, WallpaperCropActivity.a(wallpaperPickerActivity, this.b)), (Runnable) null);
        cropViewE.setTouchEnabled(true);
    }

    @Override // com.android.launcher6.nt
    public boolean a() {
        return true;
    }

    @Override // com.android.launcher6.nt
    public void b(WallpaperPickerActivity wallpaperPickerActivity) {
        wallpaperPickerActivity.a(this.b, (nf) new ns(this, wallpaperPickerActivity), true);
    }

    @Override // com.android.launcher6.nt
    public boolean b() {
        return true;
    }
}
