package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mv extends BaseAdapter implements ListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutInflater f402a;
    private final PackageManager b;
    private final int c;
    private List d = new ArrayList();

    public mv(Context context) {
        this.f402a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = context.getPackageManager();
        this.c = context.getResources().getDimensionPixelSize(R.dimen.wallpaperItemIconSize);
        PackageManager packageManager = this.b;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.SET_WALLPAPER"), 0);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        List<ResolveInfo> listQueryIntentActivities2 = packageManager.queryIntentActivities(intent, 0);
        ComponentName[] componentNameArr = new ComponentName[listQueryIntentActivities2.size()];
        for (int i = 0; i < listQueryIntentActivities2.size(); i++) {
            ActivityInfo activityInfo = listQueryIntentActivities2.get(i).activityInfo;
            componentNameArr[i] = new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            String packageName = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name).getPackageName();
            if (!packageName.equals(context.getPackageName()) && !packageName.equals("com.android.launcher") && !packageName.equals("com.android.wallpaper.livepicker")) {
                Iterator<ResolveInfo> it = listQueryIntentActivities2.iterator();
                do {
                    if (!it.hasNext()) {
                        this.d.add(new mw(resolveInfo));
                        break;
                    }
                } while (!packageName.equals(it.next().activityInfo.packageName));
            }
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public mw getItem(int i) {
        return (mw) this.d.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f402a.inflate(R.layout.wallpaper_picker_third_party_item, viewGroup, false) : view;
        WallpaperPickerActivity.a((FrameLayout) viewInflate);
        ResolveInfo resolveInfo = ((mw) this.d.get(i)).b;
        TextView textView = (TextView) viewInflate.findViewById(R.id.wallpaper_item_label);
        textView.setText(resolveInfo.loadLabel(this.b));
        Drawable drawableLoadIcon = resolveInfo.loadIcon(this.b);
        drawableLoadIcon.setBounds(new Rect(0, 0, this.c, this.c));
        textView.setCompoundDrawables(null, drawableLoadIcon, null, null);
        return viewInflate;
    }
}
