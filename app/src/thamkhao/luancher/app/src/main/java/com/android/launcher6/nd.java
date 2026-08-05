package com.android.launcher6;

import android.app.WallpaperManager;
import android.content.SharedPreferences;
import android.graphics.Point;

/* JADX INFO: loaded from: classes.dex */
class nd extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f410a;
    private final /* synthetic */ Point b;
    private final /* synthetic */ WallpaperManager c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    nd(String str, SharedPreferences sharedPreferences, Point point, WallpaperManager wallpaperManager) {
        super(str);
        this.f410a = sharedPreferences;
        this.b = point;
        this.c = wallpaperManager;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.c.suggestDesiredDimensions(this.f410a.getInt("wallpaper.width", this.b.x), this.f410a.getInt("wallpaper.height", this.b.y));
    }
}
