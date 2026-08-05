package com.fyt.a;

import android.a.a.c.l;
import android.view.View;
import android.view.ViewGroup;
import com.android.launcher6.Launcher;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a extends l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f469a;
    private Launcher b;

    public a(Launcher launcher, ArrayList arrayList) {
        this.b = launcher;
        this.f469a = arrayList;
    }

    private void c(View view) {
        com.syu.d.a.b("setViews");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            com.syu.d.a.b("ViewGroup:" + viewGroup.getChildCount());
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setOnClickListener(this);
            }
        }
    }

    @Override // android.a.a.c.l
    public int a() {
        return this.f469a.size();
    }

    @Override // android.a.a.c.l
    public Object a(ViewGroup viewGroup, int i) {
        View view = (View) this.f469a.get(i);
        c(view);
        viewGroup.addView(view);
        return view;
    }

    @Override // android.a.a.c.l
    public void a(ViewGroup viewGroup, int i, Object obj) {
        super.a(viewGroup, i, obj);
        viewGroup.removeView((View) this.f469a.get(i));
    }

    @Override // android.a.a.c.l
    public boolean a(View view, Object obj) {
        return view == obj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
