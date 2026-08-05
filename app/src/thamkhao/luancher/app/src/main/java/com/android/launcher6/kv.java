package com.android.launcher6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kv extends BaseAdapter implements ListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutInflater f362a;
    private final PackageManager b;
    private List c;

    public kv(Context context) {
        this.f362a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = context.getPackageManager();
        List<ResolveInfo> listQueryIntentServices = this.b.queryIntentServices(new Intent("android.service.wallpaper.WallpaperService"), 128);
        this.c = new ArrayList();
        new kw(this, context).execute(listQueryIntentServices);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ky getItem(int i) {
        return (ky) this.c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f362a.inflate(R.layout.wallpaper_picker_live_wallpaper_item, viewGroup, false) : view;
        WallpaperPickerActivity.a((FrameLayout) viewInflate);
        ky kyVar = (ky) this.c.get(i);
        kyVar.a(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.wallpaper_image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.wallpaper_icon);
        if (kyVar.b != null) {
            imageView.setImageDrawable(kyVar.b);
            imageView2.setVisibility(8);
        } else {
            imageView2.setImageDrawable(kyVar.c.loadIcon(this.b));
            imageView2.setVisibility(0);
        }
        ((TextView) viewInflate.findViewById(R.id.wallpaper_item_label)).setText(kyVar.c.loadLabel(this.b));
        return viewInflate;
    }
}
