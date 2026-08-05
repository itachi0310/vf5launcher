package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class nc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperCropActivity f409a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ boolean d;

    nc(WallpaperCropActivity wallpaperCropActivity, int i, int i2, boolean z) {
        this.f409a = wallpaperCropActivity;
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f409a.a(this.b, this.c);
        if (this.d) {
            this.f409a.setResult(-1);
            this.f409a.finish();
        }
    }
}
