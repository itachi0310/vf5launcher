package com.android.launcher6;

import android.content.Intent;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
class nb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperCropActivity f408a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ String c;

    nb(WallpaperCropActivity wallpaperCropActivity, boolean z, String str) {
        this.f408a = wallpaperCropActivity;
        this.b = z;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f408a.a(0, 0);
        if (this.b) {
            this.f408a.setResult(-1);
            Intent intent = new Intent();
            intent.putExtra("wallpaperRes", this.c.replace("_n", ""));
            this.f408a.setResult(HttpStatus.SC_ACCEPTED, intent);
            this.f408a.finish();
        }
    }
}
