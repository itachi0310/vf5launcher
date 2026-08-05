package com.android.launcher6;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class mp extends ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Intent f396a;
    boolean b;
    boolean c;
    Intent.ShortcutIconResource d;
    long e;
    int s;
    private Bitmap t;
    private int u;

    mp() {
        this.s = 0;
        this.g = 1;
    }

    public mp(d dVar) {
        super(dVar);
        this.s = 0;
        this.q = dVar.q.toString();
        this.f396a = new Intent(dVar.f170a);
        this.b = false;
        this.s = dVar.e;
        this.e = dVar.c;
        this.u = dVar.a();
    }

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("ShortcutInfo", "PackageManager.getPackageInfo failed for " + str);
            return null;
        }
    }

    public int a() {
        return this.u;
    }

    public Bitmap a(dv dvVar) {
        if (this.t == null) {
            b(dvVar);
        }
        return this.t;
    }

    public void a(int i) {
        this.u = i;
    }

    @Override // com.android.launcher6.ec
    void a(ContentValues contentValues) {
        super.a(contentValues);
        contentValues.put("title", this.q != null ? this.q.toString() : null);
        contentValues.put("intent", this.f396a != null ? this.f396a.toUri(0) : null);
        if (this.b) {
            contentValues.put("iconType", (Integer) 1);
            a(contentValues, this.t);
            return;
        }
        if (!this.c) {
            a(contentValues, this.t);
        }
        contentValues.put("iconType", (Integer) 0);
        if (this.d != null) {
            contentValues.put("iconPackage", this.d.packageName);
            contentValues.put("iconResource", this.d.resourceName);
        }
    }

    final void a(Context context, ComponentName componentName, int i) {
        this.f396a = new Intent("android.intent.action.MAIN");
        this.f396a.addCategory("android.intent.category.LAUNCHER");
        this.f396a.setComponent(componentName);
        this.f396a.setFlags(i);
        this.g = 0;
        a(a(context, this.f396a.getComponent().getPackageName()));
    }

    void a(PackageInfo packageInfo) {
        this.s = d.a(packageInfo);
        this.e = d.b(packageInfo);
    }

    @Override // com.android.launcher6.ec
    protected Intent b() {
        return this.f396a;
    }

    public void b(Bitmap bitmap) {
        this.t = bitmap;
    }

    public void b(dv dvVar) {
        this.t = dvVar.a(this.f396a);
        this.c = dvVar.a(this.t);
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "ShortcutInfo(title=" + this.q.toString() + "intent=" + this.f396a + "id=" + this.f + " type=" + this.g + " container=" + this.h + " screen=" + this.i + " cellX=" + this.j + " cellY=" + this.k + " spanX=" + this.l + " spanY=" + this.m + " dropPos=" + this.r + ")";
    }
}
