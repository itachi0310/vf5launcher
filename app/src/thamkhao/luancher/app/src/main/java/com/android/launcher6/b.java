package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList f123a = new ArrayList(42);
    public ArrayList b = new ArrayList(42);
    public ArrayList c = new ArrayList();
    public ArrayList d = new ArrayList();
    private dv e;
    private c f;

    public b(dv dvVar, c cVar) {
        this.e = dvVar;
        this.f = cVar;
    }

    private d a(String str, String str2) {
        for (d dVar : f123a) {
            ComponentName component = dVar.f170a.getComponent();
            if (str.equals(component.getPackageName()) && str2.equals(component.getClassName())) {
                return dVar;
            }
        }
        return null;
    }

    private static boolean a(ArrayList arrayList, ComponentName componentName) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((d) arrayList.get(i)).d.equals(componentName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(List list, ComponentName componentName) {
        String className = componentName.getClassName();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ResolveInfo) it.next()).activityInfo.name.equals(className)) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        if (SystemProperties.get("persist.sys.navi.packagename", "").equals("")) {
            com.syu.a.a.a(LauncherApplication.f88a).k.a(0, 9, "com.autonavi.amapauto");
        }
    }

    static List c(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        return listQueryIntentActivities != null ? listQueryIntentActivities : new ArrayList();
    }

    public void a() {
        f123a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    public void a(Context context, String str) {
        List listC = c(context, str);
        if (a.a.b == 8 && (str.equals("com.ludashi.benchmark") || str.equals("com.antutu.ABenchMark"))) {
            return;
        }
        if (a.a.d == 5 && str.equals("com.android.settings")) {
            return;
        }
        switch (a.a.d) {
            case 5:
                if (LauncherApplication.i != null && LauncherApplication.i.equals("0") && str.equals("com.syu.unicar")) {
                    return;
                }
                break;
        }
        if (listC.size() > 0) {
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                a(new d(context.getPackageManager(), (ResolveInfo) it.next(), this.e, null));
            }
        }
    }

    public void a(d dVar) {
        if (((LauncherApplication.j != null && LauncherApplication.j.equals("false")) || LauncherApplication.j == null) && dVar.d.getPackageName().equals("com.android.launcher6") && dVar.d.getClassName().equals("com.android.launcher6.GoogleSettingActivity")) {
            return;
        }
        if ((this.f != null && !this.f.a(dVar.d)) || a(f123a, dVar.d) || dVar.d.getPackageName().contains("com.android.launcher")) {
            return;
        }
        if ((a.a.d == 5 && dVar.d.getPackageName().equals("com.android.settings")) || dVar.d.getPackageName().equals("com.syu.onekeynavi")) {
            return;
        }
        if (a.a.b == 8 && (dVar.d.getPackageName().equals("com.ludashi.benchmark") || dVar.d.getPackageName().equals("com.antutu.ABenchMark"))) {
            return;
        }
        if (dVar.d.getPackageName().equals("com.autonavi.amapauto")) {
            a.a.e = true;
            b();
        }
        if (dVar.d.getPackageName().equals("com.syu.voice")) {
            a.a.f = true;
        }
        f123a.add(dVar);
        this.b.add(dVar);
    }

    public void a(String str) {
        if (a.a.d == 6 && str.equals("com.syu.dvd")) {
            LauncherApplication.k = false;
        }
        ArrayList arrayList = f123a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList.get(size);
            if (str.equals(dVar.f170a.getComponent().getPackageName())) {
                this.c.add(dVar);
                arrayList.remove(size);
            }
            if (str.equals("com.autonavi.amapauto")) {
                a.a.e = false;
            }
            if (str.equals("com.syu.voice")) {
                a.a.f = false;
            }
        }
        this.e.b();
    }

    public void b(Context context, String str) {
        List listC = c(context, str);
        if (a.a.b == 8 && (str.equals("com.ludashi.benchmark") || str.equals("com.antutu.ABenchMark"))) {
            return;
        }
        if (a.a.d == 5 && str.equals("com.android.settings")) {
            return;
        }
        switch (a.a.d) {
            case 5:
                if (LauncherApplication.i != null && LauncherApplication.i.equals("0") && str.equals("com.syu.unicar")) {
                    return;
                }
                break;
        }
        if (str.equals("com.autonavi.amapauto")) {
            a.a.e = true;
            b();
        }
        if (str.equals("com.syu.voice")) {
            a.a.f = true;
        }
        if (listC.size() <= 0) {
            for (int size = f123a.size() - 1; size >= 0; size--) {
                d dVar = (d) f123a.get(size);
                ComponentName component = dVar.f170a.getComponent();
                if (str.equals(component.getPackageName())) {
                    this.c.add(dVar);
                    this.e.a(component);
                    f123a.remove(size);
                }
            }
            return;
        }
        for (int size2 = f123a.size() - 1; size2 >= 0; size2--) {
            d dVar2 = (d) f123a.get(size2);
            ComponentName component2 = dVar2.f170a.getComponent();
            if (str.equals(component2.getPackageName()) && !a(listC, component2)) {
                this.c.add(dVar2);
                this.e.a(component2);
                f123a.remove(size2);
            }
        }
        int size3 = listC.size();
        for (int i = 0; i < size3; i++) {
            ResolveInfo resolveInfo = (ResolveInfo) listC.get(i);
            d dVarA = a(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name);
            if (dVarA == null) {
                a(new d(context.getPackageManager(), resolveInfo, this.e, null));
            } else {
                this.e.a(dVarA.d);
                this.e.a(dVarA, resolveInfo, (HashMap) null);
                this.d.add(dVarA);
            }
        }
    }
}
