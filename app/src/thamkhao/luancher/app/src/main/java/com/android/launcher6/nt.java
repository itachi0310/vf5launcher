package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f422a;

    public void a(View view) {
        this.f422a = view;
    }

    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
    }

    public void a(CharSequence charSequence) {
        if (b()) {
            this.f422a.setContentDescription(charSequence);
        }
    }

    public boolean a() {
        return false;
    }

    public void b(WallpaperPickerActivity wallpaperPickerActivity) {
    }

    public boolean b() {
        return false;
    }

    public void c(WallpaperPickerActivity wallpaperPickerActivity) {
    }
}
