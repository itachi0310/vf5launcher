package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class lu extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ViewDebug.ExportedProperty
    public int f383a;

    @ViewDebug.ExportedProperty
    public int b;

    @ViewDebug.ExportedProperty
    public int c;

    @ViewDebug.ExportedProperty
    public int d;

    @ViewDebug.ExportedProperty
    int e;

    @ViewDebug.ExportedProperty
    int f;

    public lu() {
        super(-1, -1);
        this.c = 1;
        this.d = 1;
    }

    public lu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1;
        this.d = 1;
    }

    public lu(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.c = 1;
        this.d = 1;
    }

    public void a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = this.c;
        int i8 = this.d;
        int i9 = this.f383a;
        int i10 = this.b;
        this.width = ((((i7 - 1) * i3) + (i7 * i)) - this.leftMargin) - this.rightMargin;
        this.height = (((i8 * i2) + ((i8 - 1) * i4)) - this.topMargin) - this.bottomMargin;
        if (ip.a().j()) {
            this.e = ((i + i3) * i9) + i5 + this.leftMargin;
            this.f = ((i2 + i4) * i10) + i6 + this.topMargin;
        } else {
            this.e = ((i + i3) * i9) + this.leftMargin;
            this.f = ((i2 + i4) * i10) + this.topMargin;
        }
    }

    public String toString() {
        return "(" + this.f383a + ", " + this.b + ", " + this.c + ", " + this.d + ")";
    }
}
