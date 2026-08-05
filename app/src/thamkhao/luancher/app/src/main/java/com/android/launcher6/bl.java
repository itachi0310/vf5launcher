package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class bl {
    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    int N;
    HashMap O = new HashMap();
    String[] P = {"navi", "com.syu.radio", "com.syu.bt"};
    int[] Q = {a.b.a().aJ, a.b.a().aK, a.b.a().aL};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f135a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    int n;
    int o;
    Rect p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    int x;
    int y;
    int z;

    bl(Context context, ArrayList arrayList, float f, float f2, int i, int i2, int i3, int i4, Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ArrayList arrayList2 = new ArrayList();
        this.m = resources.getBoolean(R.bool.hotseat_transpose_layout_with_orientation);
        this.b = f;
        this.c = f2;
        this.p = AppWidgetHostView.getDefaultPaddingForWidget(context, new ComponentName(context.getPackageName(), getClass().getName()), null);
        this.o = resources.getDimensionPixelSize(R.dimen.dynamic_grid_edge_margin);
        this.n = this.o * 2;
        this.N = resources.getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_height);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bl blVar = (bl) it.next();
            arrayList2.add(new bn(blVar.b, blVar.c, blVar.d));
        }
        this.d = Math.round(a(f, f2, arrayList2));
        arrayList2.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            bl blVar2 = (bl) it2.next();
            arrayList2.add(new bn(blVar2.b, blVar2.c, blVar2.e));
        }
        this.e = Math.round(a(f, f2, arrayList2));
        arrayList2.clear();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            bl blVar3 = (bl) it3.next();
            arrayList2.add(new bn(blVar3.b, blVar3.c, blVar3.f));
        }
        this.f = a(f, f2, arrayList2);
        this.u = ch.a(this.f, displayMetrics);
        arrayList2.clear();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            bl blVar4 = (bl) it4.next();
            arrayList2.add(new bn(blVar4.b, blVar4.c, blVar4.g));
        }
        this.g = a(f, f2, arrayList2);
        this.v = ch.b(this.g, displayMetrics);
        arrayList2.clear();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            bl blVar5 = (bl) it5.next();
            arrayList2.add(new bn(blVar5.b, blVar5.c, blVar5.h));
        }
        this.h = Math.round(a(f, f2, arrayList2));
        arrayList2.clear();
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            bl blVar6 = (bl) it6.next();
            arrayList2.add(new bn(blVar6.b, blVar6.c, blVar6.i));
        }
        this.i = a(f, f2, arrayList2);
        this.E = ch.a(this.i, displayMetrics);
        this.G = (int) (this.h / 2.0f);
        a(resources, i, i2, i3, i4);
        this.K = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_max_width);
        this.M = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_height);
        this.J = Math.min(this.K, this.q);
        this.L = this.M + (this.o * 2);
        Paint paint = new Paint();
        paint.setTextSize(this.v);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.w = this.u;
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.istextPaint_abroad)) {
            this.x = (((int) Math.ceil(fontMetrics.bottom - fontMetrics.top)) + (this.u - LauncherApplication.f88a.getResources().getInteger(R.integer.utility_icon_height))) - LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.istextPaint_abroad);
        } else {
            this.x = this.u - LauncherApplication.f88a.getResources().getInteger(R.integer.utility_icon_height);
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.hotseat_layout)) {
            this.F = this.o * 4;
        } else {
            this.F = (int) (this.i + (this.o * 4));
        }
        this.C = ((int) this.i) + this.o;
        this.D = (int) this.i;
        this.A = this.w + (this.o * 3);
        this.B = this.x + ((int) (1.5f * this.o));
        this.y = -this.o;
        this.z = this.u + ((-this.y) * 2);
        if (resources.getBoolean(R.bool.hotseat_load_defualt_workspace)) {
            return;
        }
        for (int i5 = 0; i5 < this.P.length; i5++) {
            HashMap map = new HashMap();
            map.put(this.P[i5], Integer.valueOf(this.Q[i5]));
            this.O.put(Integer.valueOf(i5), map);
        }
    }

    bl(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!AppsCustomizePagedView.b && f7 % 2.0f == 0.0f) {
            throw new RuntimeException("All Device Profiles must have an odd number of hotseat spaces");
        }
        this.f135a = str;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        this.g = f6;
        this.h = f7;
        this.i = f8;
    }

    private float a(float f, float f2, ArrayList arrayList) {
        float fA = 0.0f;
        PointF pointF = new PointF(f, f2);
        Collections.sort(arrayList, new bm(this, pointF));
        float f3 = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            bn bnVar = (bn) arrayList.get(i);
            if (i < 3.0f) {
                float fA2 = a(pointF, bnVar.d, 5.0f);
                if (fA2 == Float.POSITIVE_INFINITY) {
                    return bnVar.c;
                }
                f3 += fA2;
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bn bnVar2 = (bn) arrayList.get(i2);
            if (i2 < 3.0f) {
                fA += (bnVar2.c * a(pointF, bnVar2.d, 5.0f)) / f3;
            }
        }
        return fA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(((pointF2.x - pointF.x) * (pointF2.x - pointF.x)) + ((pointF2.y - pointF.y) * (pointF2.y - pointF.y)));
    }

    private float a(PointF pointF, PointF pointF2, float f) {
        float fA = a(pointF, pointF2);
        if (fA == 0.0f) {
            return Float.POSITIVE_INFINITY;
        }
        return (float) (1.0d / Math.pow(fA, f));
    }

    int a(int i, int i2) {
        return i / i2;
    }

    Rect a() {
        return new Rect(0, this.t - this.F, this.s, Integer.MAX_VALUE);
    }

    Rect a(int i) {
        Rect rect = new Rect();
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.isHotseatHeight)) {
            rect.set(LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingLeft), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingTop), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingRight), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.hotseat_btn_height) + LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingBottom));
        } else {
            rect.set(LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingLeft), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingTop), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingRight), LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.workspace_paddingBottom));
        }
        return rect;
    }

    void a(Resources resources, int i, int i2, int i3, int i4) {
        this.j = resources.getConfiguration().orientation == 2;
        this.k = resources.getBoolean(R.bool.is_tablet);
        this.l = resources.getBoolean(R.bool.is_large_tablet);
        this.q = i;
        this.r = i2;
        this.s = i3;
        this.t = i4;
        this.H = resources.getInteger(R.integer.all_apps_customize_rows);
        this.I = resources.getInteger(R.integer.all_apps_customize_cols);
    }

    public void a(Launcher launcher) {
        launcher.getResources();
        View viewN = launcher.N();
        if (viewN != null) {
            ViewGroup.LayoutParams layoutParams = viewN.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            viewN.setLayoutParams(layoutParams);
        }
        View viewFindViewById = launcher.findViewById(R.id.voice_button_proxy);
        if (viewFindViewById != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams2.gravity = 8388661;
            layoutParams2.width = ((this.q - this.J) / 2) + (this.u * 2);
            layoutParams2.height = this.L;
        }
        View viewFindViewById2 = launcher.findViewById(R.id.workspace);
        if (viewFindViewById2 != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewFindViewById2.getLayoutParams();
            layoutParams3.gravity = 17;
            Rect rectA = a(this.j ? 0 : 1);
            viewFindViewById2.setPadding(rectA.left, rectA.top, rectA.right, rectA.bottom);
            viewFindViewById2.setLayoutParams(layoutParams3);
        }
        View viewFindViewById3 = launcher.findViewById(R.id.page_indicator);
        if (viewFindViewById3 != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) viewFindViewById3.getLayoutParams();
            layoutParams4.gravity = 81;
            layoutParams4.width = -2;
            layoutParams4.height = -2;
            layoutParams4.bottomMargin = this.F + LauncherApplication.f88a.getResources().getDimensionPixelSize(R.dimen.pageindicator_mariginBottom);
            viewFindViewById3.setLayoutParams(layoutParams4);
        }
    }

    int b(int i, int i2) {
        return i / i2;
    }

    boolean b() {
        return (this.k || this.l) ? false : true;
    }

    boolean c() {
        return this.k;
    }
}
