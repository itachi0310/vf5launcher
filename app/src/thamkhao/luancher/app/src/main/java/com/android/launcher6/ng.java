package com.android.launcher6;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
class ng implements az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    kt f412a;
    final /* synthetic */ WallpaperPickerActivity b;

    ng(WallpaperPickerActivity wallpaperPickerActivity) {
        this.b = wallpaperPickerActivity;
    }

    @Override // com.android.launcher6.az
    public void a() {
        if (this.f412a != null) {
            this.f412a.cancel();
        }
        if (this.b.j.getAlpha() == 1.0f) {
            this.b.g = true;
        }
        this.f412a = new kt(this.b.j);
        this.f412a.d(0.0f).setDuration(150L).addListener(new nh(this));
        this.f412a.setInterpolator(new AccelerateInterpolator(0.75f));
        this.f412a.start();
    }

    @Override // com.android.launcher6.az
    public void b() {
        boolean z = this.b.g;
        this.b.g = false;
        if (z) {
            return;
        }
        if (this.f412a != null) {
            this.f412a.cancel();
        }
        this.b.j.setVisibility(0);
        this.f412a = new kt(this.b.j);
        this.f412a.d(1.0f).setDuration(150L).setInterpolator(new DecelerateInterpolator(0.75f));
        this.f412a.start();
    }

    @Override // com.android.launcher6.az
    public void c() {
        this.b.g = false;
    }
}
