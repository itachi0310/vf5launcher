package com.android.launcher6;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap f108a;
    ArrayList b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    final /* synthetic */ CellLayout h;
    private HashMap i;

    private ak(CellLayout cellLayout) {
        this.h = cellLayout;
        this.f108a = new HashMap();
        this.i = new HashMap();
        this.b = new ArrayList();
        this.c = false;
    }

    /* synthetic */ ak(CellLayout cellLayout, ak akVar) {
        this(cellLayout);
    }

    void a() {
        for (View view : this.f108a.keySet()) {
            ((ai) this.f108a.get(view)).a((ai) this.i.get(view));
        }
    }

    void a(View view, ai aiVar) {
        this.f108a.put(view, aiVar);
        this.i.put(view, new ai(this.h));
        this.b.add(view);
    }

    void b() {
        for (View view : this.i.keySet()) {
            ((ai) this.i.get(view)).a((ai) this.f108a.get(view));
        }
    }

    int c() {
        return this.f * this.g;
    }
}
