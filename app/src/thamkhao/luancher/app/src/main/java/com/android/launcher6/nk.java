package com.android.launcher6;

import android.database.DataSetObserver;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
class nk extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WallpaperPickerActivity f416a;
    private final /* synthetic */ LinearLayout b;
    private final /* synthetic */ kv c;

    nk(WallpaperPickerActivity wallpaperPickerActivity, LinearLayout linearLayout, kv kvVar) {
        this.f416a = wallpaperPickerActivity;
        this.b = linearLayout;
        this.c = kvVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.b.removeAllViews();
        this.f416a.a((ViewGroup) this.b, (BaseAdapter) this.c, false, false);
        this.f416a.i();
        this.f416a.j();
    }
}
