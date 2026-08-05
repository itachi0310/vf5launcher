package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class nj implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f415a;

    nj(WallpaperPickerActivity wallpaperPickerActivity) {
        this.f415a = wallpaperPickerActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ((CheckableFrameLayout) view).toggle();
        if (this.f415a.l != null) {
            this.f415a.l.invalidate();
            return true;
        }
        this.f415a.l = this.f415a.startActionMode(this.f415a.k);
        int childCount = this.f415a.i.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.f415a.i.getChildAt(i).setSelected(false);
        }
        return true;
    }
}
