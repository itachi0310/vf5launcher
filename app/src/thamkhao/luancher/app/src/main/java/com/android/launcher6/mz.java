package com.android.launcher6;

import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class mz implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperCropActivity f405a;
    private final /* synthetic */ Uri b;

    mz(WallpaperCropActivity wallpaperCropActivity, Uri uri) {
        this.f405a = wallpaperCropActivity;
        this.b = uri;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f405a.a(this.b, null, true);
    }
}
