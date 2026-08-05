package com.android.launcher6;

import android.app.WallpaperInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class ky extends nt {
    private Drawable b;
    private WallpaperInfo c;

    public ky(Drawable drawable, WallpaperInfo wallpaperInfo, Intent intent) {
        this.b = drawable;
        this.c = wallpaperInfo;
    }

    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
        intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", this.c.getComponent());
        wallpaperPickerActivity.g();
        my.a(wallpaperPickerActivity, intent, 7);
    }
}
