package com.android.launcher6;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class no extends BaseAdapter implements ListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutInflater f420a;
    private ArrayList b;

    no(Activity activity, ArrayList arrayList) {
        this.f420a = activity.getLayoutInflater();
        this.b = arrayList;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public nq getItem(int i) {
        return (nq) this.b.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Drawable drawable = ((nq) this.b.get(i)).d;
        if (drawable == null) {
            Log.e("Launcher.WallpaperPickerActivity", "Error decoding thumbnail for wallpaper #" + i);
        }
        return WallpaperPickerActivity.a(this.f420a, i, view, viewGroup, drawable);
    }
}
