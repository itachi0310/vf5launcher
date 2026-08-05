package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class nl implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f417a;

    nl(WallpaperPickerActivity wallpaperPickerActivity) {
        this.f417a = wallpaperPickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f417a.f != null) {
            ((nt) this.f417a.f.getTag()).b(this.f417a);
        }
    }
}
