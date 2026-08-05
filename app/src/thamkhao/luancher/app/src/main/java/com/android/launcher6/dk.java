package com.android.launcher6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dk extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f179a = new ArrayList();
    private LayoutInflater b;
    private Context c;
    private PackageManager d;

    public dk(List list, Context context) {
        this.d = context.getPackageManager();
        this.c = context;
        this.b = LayoutInflater.from(context);
        a(context, list);
    }

    public void a(Context context, List list) {
        PackageManager packageManager = context.getPackageManager();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                com.fyt.widget.a aVar = new com.fyt.widget.a(str, packageManager.getApplicationLabel(applicationInfo).toString());
                for (com.syu.g.e eVar : com.syu.g.d.b) {
                    if (eVar.a().equals(str)) {
                        aVar.a(com.fyt.b.g.a(eVar.b()));
                    }
                }
                if (aVar.c() == null) {
                    aVar.a(new BitmapDrawable(my.b(packageManager.getApplicationIcon(applicationInfo), context)));
                }
                this.f179a.add(aVar);
            } catch (Exception e) {
            }
        }
    }

    public void a(String str) {
        Intent launchIntentForPackage = this.d.getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(270532608);
            this.c.startActivity(launchIntentForPackage);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f179a == null) {
            return 0;
        }
        return this.f179a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f179a == null ? "" : this.f179a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.b.inflate(R.layout.item_app, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_item_app_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_item_app_lebel);
        com.fyt.widget.a aVar = (com.fyt.widget.a) this.f179a.get(i);
        textView.setText(aVar.b());
        imageView.setImageDrawable(aVar.c());
        viewInflate.setOnClickListener(new dl(this, aVar));
        return viewInflate;
    }
}
