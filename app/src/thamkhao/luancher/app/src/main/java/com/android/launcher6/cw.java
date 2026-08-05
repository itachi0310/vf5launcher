package com.android.launcher6;

import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class cw extends android.a.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f166a;

    public cw(ScrollView scrollView) {
        super(scrollView);
        this.f166a = scrollView;
        b(0);
        a(1);
        b(true);
        a(1500.0f, 1500.0f);
        d(0);
        c(0);
    }

    @Override // android.a.a.d.a
    public void a(int i, int i2) {
        this.f166a.scrollBy(i, i2);
    }

    @Override // android.a.a.d.a
    public boolean e(int i) {
        return false;
    }

    @Override // android.a.a.d.a
    public boolean f(int i) {
        return this.f166a.canScrollVertically(i);
    }
}
