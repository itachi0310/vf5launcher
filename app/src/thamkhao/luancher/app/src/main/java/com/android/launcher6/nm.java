package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class nm implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f418a;

    nm(WallpaperPickerActivity wallpaperPickerActivity) {
        this.f418a = wallpaperPickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f418a.f != null) {
            ((nt) this.f418a.f.getTag()).b(this.f418a);
        }
    }
}
