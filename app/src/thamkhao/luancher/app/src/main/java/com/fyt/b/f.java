package com.fyt.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f479a = true;
    private Resources b;
    private Resources c;
    private String d;
    private Context e;

    protected f(Context context) {
        this.e = context;
        this.c = context.getResources();
    }

    public int a(int i) {
        if (this.f479a) {
            return i;
        }
        return this.b.getIdentifier(this.c.getResourceEntryName(i), this.c.getResourceTypeName(i), this.d);
    }

    public void a() {
        this.d = "";
        this.b = null;
        this.f479a = true;
    }

    public void a(Resources resources, String str) {
        this.b = resources;
        this.d = str;
        this.f479a = TextUtils.isEmpty(str) || resources == null;
    }

    public int b(int i) {
        int iA;
        if (!this.f479a && (iA = a(i)) != 0) {
            return this.b.getColor(iA);
        }
        return this.c.getColor(i);
    }

    public ColorStateList c(int i) {
        int iA;
        if (!this.f479a && (iA = a(i)) != 0) {
            return this.b.getColorStateList(iA);
        }
        return this.c.getColorStateList(i);
    }

    public Drawable d(int i) {
        int iA;
        if (!this.f479a && (iA = a(i)) != 0) {
            return this.b.getDrawable(iA);
        }
        return this.c.getDrawable(i);
    }

    public Object e(int i) {
        return this.c.getResourceTypeName(i).equals("color") ? Integer.valueOf(b(i)) : d(i);
    }
}
