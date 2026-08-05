package com.android.launcher6;

import android.graphics.Point;

/* JADX INFO: loaded from: classes.dex */
class na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperCropActivity f407a;
    private final /* synthetic */ Point b;
    private final /* synthetic */ boolean c;

    na(WallpaperCropActivity wallpaperCropActivity, Point point, boolean z) {
        this.f407a = wallpaperCropActivity;
        this.b = point;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f407a.a(this.b.x, this.b.y);
        if (this.c) {
            this.f407a.setResult(-1);
            this.f407a.finish();
        }
    }
}
