package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bl f152a;
    private float b;
    private float c;

    public ch(Context context, Resources resources, int i, int i2, int i3, int i4, int i5, int i6) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ArrayList arrayList = new ArrayList();
        if (AppsCustomizePagedView.b) {
        }
        int integer = LauncherApplication.f88a.getResources().getInteger(R.integer.shortcut_icon_size);
        int integer2 = LauncherApplication.f88a.getResources().getInteger(R.integer.numRows_size);
        int integer3 = LauncherApplication.f88a.getResources().getInteger(R.integer.numCols_size);
        LauncherApplication.f88a.getResources().getInteger(R.integer.hoteseat3G_icon_size);
        int integer4 = LauncherApplication.f88a.getResources().getInteger(R.integer.hoteseatwifi_icon_size);
        int integer5 = LauncherApplication.f88a.getResources().getInteger(R.integer.nhotseat_count);
        int integer6 = LauncherApplication.f88a.getResources().getInteger(R.integer.shortcut_textSize);
        arrayList.add(new bl("fyt 10", 1024.0f, 600.0f, integer2, integer3, integer, integer6, integer5, integer4));
        arrayList.add(new bl("fyt 12", 800.0f, 480.0f, integer2, integer3, integer, integer6, integer5, integer4));
        arrayList.add(new bl("fyt 12", 980.0f, 420.0f, integer2, integer3, integer, integer6, integer5, integer4));
        this.b = a(i, displayMetrics);
        this.c = a(i2, displayMetrics);
        this.f152a = new bl(context, arrayList, this.b, this.c, i3, i4, i5, i6, resources);
    }

    public static float a(int i, DisplayMetrics displayMetrics) {
        return i / (displayMetrics.densityDpi / 160.0f);
    }

    public static int a(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, f, displayMetrics));
    }

    public static int b(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(2, f, displayMetrics));
    }

    bl a() {
        return this.f152a;
    }

    public String toString() {
        return "-------- DYNAMIC GRID ------- \nWd: " + this.f152a.b + ", Hd: " + this.f152a.c + ", W: " + this.f152a.q + ", H: " + this.f152a.r + " [r: " + this.f152a.d + ", c: " + this.f152a.e + ", is: " + this.f152a.u + ", its: " + this.f152a.g + ", cw: " + this.f152a.w + ", ch: " + this.f152a.x + ", hc: " + this.f152a.h + ", his: " + this.f152a.E + "]";
    }
}
