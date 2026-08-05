package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class al extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ViewDebug.ExportedProperty
    public int f109a;

    @ViewDebug.ExportedProperty
    public int b;
    public int c;
    public int d;
    public boolean e;

    @ViewDebug.ExportedProperty
    public int f;

    @ViewDebug.ExportedProperty
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;

    @ViewDebug.ExportedProperty
    int k;

    @ViewDebug.ExportedProperty
    int l;
    boolean m;

    public al(int i, int i2, int i3, int i4) {
        super(-1, -1);
        this.h = true;
        this.i = false;
        this.j = true;
        this.f109a = i;
        this.b = i2;
        this.f = i3;
        this.g = i4;
    }

    public al(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = true;
        this.i = false;
        this.j = true;
        this.f = 1;
        this.g = 1;
    }

    public al(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.h = true;
        this.i = false;
        this.j = true;
        this.f = 1;
        this.g = 1;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, int i5) {
        if (this.h) {
            int i6 = this.f;
            int i7 = this.g;
            int i8 = this.e ? this.c : this.f109a;
            int i9 = this.e ? this.d : this.b;
            if (z) {
                i8 = (i5 - i8) - this.f;
            }
            this.width = ((((i6 - 1) * i3) + (i6 * i)) - this.leftMargin) - this.rightMargin;
            this.height = (((i7 * i2) + ((i7 - 1) * i4)) - this.topMargin) - this.bottomMargin;
            this.k = (i8 * (i + i3)) + this.leftMargin;
            this.l = ((i2 + i4) * i9) + this.topMargin;
        }
    }

    public String toString() {
        return "(" + this.f109a + ", " + this.b + ")";
    }
}
