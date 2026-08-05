package com.android.launcher6;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d extends ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Intent f170a;
    Bitmap b;
    long c;
    ComponentName d;
    int e;
    private int s;

    d() {
        this.e = 0;
        this.g = 1;
    }

    public d(PackageManager packageManager, ResolveInfo resolveInfo, dv dvVar, HashMap map) {
        this.e = 0;
        String str = resolveInfo.activityInfo.applicationInfo.packageName;
        this.d = new ComponentName(str, resolveInfo.activityInfo.name);
        this.h = -1L;
        a(this.d, 270532608);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            this.e = a(packageInfo);
            this.c = b(packageInfo);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("Launcher3.AppInfo", "PackageManager.getApplicationInfo failed for " + str);
        }
        this.s = com.syu.g.d.a(resolveInfo.activityInfo);
        dvVar.a(this, resolveInfo, map);
    }

    public static int a(PackageInfo packageInfo) {
        int i = packageInfo.applicationInfo.flags;
        if ((i & 1) == 0) {
            return (i & 128) != 0 ? 3 : 1;
        }
        return 0;
    }

    public static void a(String str, String str2, ArrayList arrayList) {
        Log.d(str, String.valueOf(str2) + " size=" + arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Log.d(str, "   title=\"" + ((Object) dVar.q) + "\" iconBitmap=" + dVar.b + " firstInstallTime=" + dVar.c);
        }
    }

    public static long b(PackageInfo packageInfo) {
        return packageInfo.firstInstallTime;
    }

    public int a() {
        return this.s;
    }

    final void a(ComponentName componentName, int i) {
        this.f170a = new Intent("android.intent.action.MAIN");
        this.f170a.addCategory("android.intent.category.LAUNCHER");
        this.f170a.setComponent(componentName);
        this.f170a.setFlags(i);
        this.g = 0;
    }

    @Override // com.android.launcher6.ec
    protected Intent b() {
        return this.f170a;
    }

    public mp c() {
        return new mp(this);
    }

    String d() {
        if (this.f170a != null) {
            String packageName = this.f170a.getPackage();
            if (packageName == null && this.f170a.getComponent() != null) {
                packageName = this.f170a.getComponent().getPackageName();
            }
            if (packageName != null) {
                return packageName;
            }
        }
        return "";
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "ApplicationInfo(title=" + this.q.toString() + " id=" + this.f + " type=" + this.g + " container=" + this.h + " screen=" + this.i + " cellX=" + this.j + " cellY=" + this.k + " spanX=" + this.l + " spanY=" + this.m + " dropPos=" + this.r + ")";
    }
}
