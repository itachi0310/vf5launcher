package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ni implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f414a;

    ni(WallpaperPickerActivity wallpaperPickerActivity) {
        this.f414a = wallpaperPickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f414a.l != null) {
            if (view.isLongClickable()) {
                this.f414a.m.onLongClick(view);
                return;
            }
            return;
        }
        nt ntVar = (nt) view.getTag();
        if (ntVar.a()) {
            if (this.f414a.f != null) {
                this.f414a.f.setSelected(false);
                this.f414a.f = null;
            }
            this.f414a.f = view;
            view.setSelected(true);
            view.announceForAccessibility(this.f414a.getString(R.string.announce_selection, new Object[]{view.getContentDescription()}));
        }
        ntVar.a(this.f414a);
    }
}
