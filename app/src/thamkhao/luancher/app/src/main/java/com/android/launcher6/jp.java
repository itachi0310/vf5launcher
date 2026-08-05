package com.android.launcher6;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class jp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f334a;
    private Context b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private HashMap g = new HashMap();

    jp(iv ivVar, Context context, boolean z) {
        this.f334a = ivVar;
        this.b = context;
        this.c = z;
    }

    private void a(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((ec) it.next()) == null) {
                it.remove();
            }
        }
        if (i < 0) {
            arrayList2.addAll(arrayList);
        }
        HashSet hashSet = new HashSet();
        Collections.sort(arrayList, new ju(this));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ec ecVar = (ec) it2.next();
            if (ecVar.h == -100) {
                if (ecVar.i == i) {
                    arrayList2.add(ecVar);
                    hashSet.add(Long.valueOf(ecVar.f));
                } else {
                    arrayList3.add(ecVar);
                }
            } else if (ecVar.h == -101) {
                arrayList2.add(ecVar);
                hashSet.add(Long.valueOf(ecVar.f));
            } else if (hashSet.contains(Long.valueOf(ecVar.h))) {
                arrayList2.add(ecVar);
                hashSet.add(Long.valueOf(ecVar.f));
            } else {
                arrayList3.add(ecVar);
            }
        }
    }

    private void a(int i, HashMap map, HashMap map2, HashMap map3, HashMap map4) {
        if (i < 0) {
            map3.putAll(map2);
        }
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            ec ecVar = (ec) map.get(Long.valueOf(jLongValue));
            dg dgVar = (dg) map2.get(Long.valueOf(jLongValue));
            if (ecVar != null && dgVar != null) {
                if (ecVar.h == -100 && ecVar.i == i) {
                    map3.put(Long.valueOf(jLongValue), dgVar);
                } else {
                    map4.put(Long.valueOf(jLongValue), dgVar);
                }
            }
        }
    }

    private void a(int i, boolean z) {
        com.syu.d.a.b("bindWorkspace");
        long jUptimeMillis = SystemClock.uptimeMillis();
        jn jnVar = (jn) this.f334a.y.get();
        if (jnVar == null) {
            Log.w("Launcher.Model", "LoaderTask running with no launcher");
            return;
        }
        boolean z2 = i > -1;
        int iQ = z2 ? i : jnVar.Q();
        this.f334a.c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        synchronized (iv.c) {
            arrayList.addAll(iv.e);
            arrayList2.addAll(iv.f);
            map.putAll(iv.g);
            map2.putAll(iv.d);
            arrayList3.addAll(iv.i);
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        a(iQ, arrayList, arrayList4, arrayList5);
        b(iQ, arrayList2, arrayList6, arrayList7);
        a(iQ, map2, map, map3, map4);
        a(arrayList4);
        a(arrayList5);
        this.f334a.a(new ka(this, jnVar), 1);
        a(jnVar, arrayList3);
        a(jnVar, arrayList4, arrayList6, map3, (ArrayList) null);
        if (z2) {
            this.f334a.a(new kb(this, jnVar, iQ), 1);
        }
        iv.f316a.clear();
        a(jnVar, arrayList5, arrayList7, map4, z2 ? iv.f316a : null);
        jr jrVar = new jr(this, jnVar, z, jUptimeMillis);
        if (z2) {
            iv.f316a.add(jrVar);
        } else {
            this.f334a.a(jrVar, 1);
        }
    }

    private void a(jn jnVar, ArrayList arrayList) {
        this.f334a.a(new jw(this, jnVar, arrayList), 1);
    }

    private void a(jn jnVar, ArrayList arrayList, ArrayList arrayList2, HashMap map, ArrayList arrayList3) {
        boolean z = arrayList3 != null;
        int size = arrayList.size();
        for (int i = 0; i < size; i += 6) {
            jx jxVar = new jx(this, jnVar, arrayList, i, i + 6 <= size ? 6 : size - i);
            if (z) {
                arrayList3.add(jxVar);
            } else {
                this.f334a.a(jxVar, 1);
            }
        }
        if (!map.isEmpty()) {
            jy jyVar = new jy(this, jnVar, map);
            if (z) {
                arrayList3.add(jyVar);
            } else {
                this.f334a.a(jyVar, 1);
            }
        }
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            jz jzVar = new jz(this, jnVar, (it) arrayList2.get(i2));
            if (z) {
                arrayList3.add(jzVar);
            } else {
                this.f334a.a(jzVar, 1);
            }
        }
    }

    private void a(ArrayList arrayList) {
        Collections.sort(arrayList, new jv(this, ip.a().i().a()));
    }

    private boolean a(ec ecVar) {
        bl blVarA = ip.a().i().a();
        return ecVar.j + ecVar.l > ((int) blVarA.e) || ecVar.k + ecVar.m > ((int) blVarA.d);
    }

    private boolean a(HashMap map, ec ecVar, AtomicBoolean atomicBoolean) {
        bl blVarA = ip.a().i().a();
        int i = (int) blVarA.e;
        int i2 = (int) blVarA.d;
        long j = ecVar.i;
        if (ecVar.h == -101) {
            if (this.f334a.y == null || ((jn) this.f334a.y.get()).e((int) ecVar.i)) {
                atomicBoolean.set(true);
                return false;
            }
            if (!map.containsKey(-101)) {
                ec[][] ecVarArr = (ec[][]) Array.newInstance((Class<?>) ec.class, i + 1, i2 + 1);
                ecVarArr[(int) ecVar.i][0] = ecVar;
                map.put(-101L, ecVarArr);
                return true;
            }
            if (((ec[][]) map.get(-101))[(int) ecVar.i][0] != null) {
                Log.e("Launcher.Model", "Error loading shortcut into hotseat " + ecVar + " into position (" + ecVar.i + ":" + ecVar.j + "," + ecVar.k + ") occupied by " + ((ec[][]) map.get(-101))[(int) ecVar.i][0]);
                return false;
            }
        } else if (ecVar.h != -100) {
            return true;
        }
        if (!map.containsKey(Long.valueOf(ecVar.i))) {
            map.put(Long.valueOf(ecVar.i), (ec[][]) Array.newInstance((Class<?>) ec.class, i + 1, i2 + 1));
        }
        ec[][] ecVarArr2 = (ec[][]) map.get(Long.valueOf(ecVar.i));
        for (int i3 = ecVar.j; i3 < ecVar.j + ecVar.l; i3++) {
            for (int i4 = ecVar.k; i4 < ecVar.k + ecVar.m; i4++) {
                if (ecVarArr2[i3][i4] != null) {
                    Log.e("Launcher.Model", "Error loading shortcut " + ecVar + " into cell (" + j + "-" + ecVar.i + ":" + i3 + "," + i4 + ") occupied by " + ecVarArr2[i3][i4]);
                    return false;
                }
            }
        }
        for (int i5 = ecVar.j; i5 < ecVar.j + ecVar.l; i5++) {
            for (int i6 = ecVar.k; i6 < ecVar.k + ecVar.m; i6++) {
                ecVarArr2[i5][i6] = ecVar;
            }
        }
        return true;
    }

    private void b(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        if (i < 0) {
            arrayList2.addAll(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it itVar = (it) it.next();
            if (itVar != null) {
                if (itVar.h == -100 && itVar.i == i) {
                    arrayList2.add(itVar);
                } else {
                    arrayList3.add(itVar);
                }
            }
        }
    }

    private boolean e() {
        com.syu.d.a.b("loadAndBindWorkspace");
        this.d = true;
        boolean zI = false;
        if (this.f334a.w) {
            a(-1, zI);
        } else {
            zI = i();
            synchronized (this) {
                if (!this.e) {
                    this.f334a.w = true;
                    a(-1, zI);
                }
            }
        }
        return zI;
    }

    private void f() {
        synchronized (this) {
            this.f334a.q.b(new jq(this));
            while (!this.e && !this.f && !this.f334a.t) {
                try {
                    wait(1000L);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private void g() {
        Context contextB = this.f334a.o.b();
        ArrayList arrayList = new ArrayList();
        synchronized (iv.c) {
            for (d dVar : b.f123a) {
                if (this.f334a.a(dVar.d).isEmpty()) {
                    arrayList.add(dVar);
                    Log.e("Launcher.Model", "Missing Application on load: " + dVar);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f334a.a(contextB, arrayList, this.f334a.y != null ? (jn) this.f334a.y.get() : null, (ArrayList) null);
    }

    private void h() {
        synchronized (iv.c) {
            iv.e.clear();
            iv.f.clear();
            iv.g.clear();
            iv.d.clear();
            iv.h.clear();
            iv.i.clear();
        }
    }

    private boolean i() {
        mp mpVarA;
        Context context = this.b;
        ContentResolver contentResolver = context.getContentResolver();
        PackageManager packageManager = context.getPackageManager();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        boolean zIsSafeMode = packageManager.isSafeMode();
        bl blVarA = ip.a().i().a();
        ip.g().a(0);
        boolean zC = ip.g().c();
        synchronized (iv.c) {
            try {
                h();
                ArrayList arrayList = new ArrayList();
                Uri uri = kq.f358a;
                Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                HashMap map = new HashMap();
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("intent");
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("title");
                    int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("iconType");
                    int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("icon");
                    int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("iconPackage");
                    int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("iconResource");
                    int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("container");
                    int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("itemType");
                    int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("appWidgetId");
                    int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("appWidgetProvider");
                    int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("screen");
                    int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("cellX");
                    int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("cellY");
                    int columnIndexOrThrow15 = cursorQuery.getColumnIndexOrThrow("spanX");
                    int columnIndexOrThrow16 = cursorQuery.getColumnIndexOrThrow("spanY");
                    while (!this.e && cursorQuery.moveToNext()) {
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        try {
                            int i = cursorQuery.getInt(columnIndexOrThrow9);
                            switch (i) {
                                case 0:
                                case 1:
                                    long j = cursorQuery.getLong(columnIndexOrThrow);
                                    String string = cursorQuery.getString(columnIndexOrThrow2);
                                    try {
                                        Intent uri2 = Intent.parseUri(string, 0);
                                        ComponentName component = uri2.getComponent();
                                        if (component == null || this.f334a.a(packageManager, component)) {
                                            if (i == 0) {
                                                mpVarA = this.f334a.a(packageManager, uri2, context, cursorQuery, columnIndexOrThrow5, columnIndexOrThrow3, this.g);
                                            } else {
                                                mpVarA = this.f334a.a(cursorQuery, context, columnIndexOrThrow4, columnIndexOrThrow6, columnIndexOrThrow7, columnIndexOrThrow5, columnIndexOrThrow3);
                                                if (uri2.getAction() != null && uri2.getCategories() != null && uri2.getAction().equals("android.intent.action.MAIN") && uri2.getCategories().contains("android.intent.category.LAUNCHER")) {
                                                    uri2.addFlags(270532608);
                                                }
                                            }
                                            if (mpVarA == null) {
                                                throw new RuntimeException("Unexpected null ShortcutInfo");
                                            }
                                            mpVarA.f = j;
                                            mpVarA.f396a = uri2;
                                            int i2 = cursorQuery.getInt(columnIndexOrThrow8);
                                            mpVarA.h = i2;
                                            mpVarA.i = cursorQuery.getInt(columnIndexOrThrow12);
                                            mpVarA.j = cursorQuery.getInt(columnIndexOrThrow13);
                                            mpVarA.k = cursorQuery.getInt(columnIndexOrThrow14);
                                            mpVarA.l = 1;
                                            mpVarA.m = 1;
                                            if (i2 == -100 && a(mpVarA)) {
                                                Launcher.a("Launcher.Model", "Skipped loading out of bounds shortcut: " + mpVarA + ", " + blVarA.e + "x" + blVarA.d, true);
                                            } else {
                                                atomicBoolean.set(false);
                                                if (a(map, mpVarA, atomicBoolean)) {
                                                    switch (i2) {
                                                        case -101:
                                                        case -100:
                                                            iv.e.add(mpVarA);
                                                            break;
                                                        default:
                                                            iv.b(iv.g, i2).a(mpVarA);
                                                            break;
                                                    }
                                                    iv.d.put(Long.valueOf(mpVarA.f), mpVarA);
                                                    this.f334a.a(iv.h, mpVarA, cursorQuery, columnIndexOrThrow5);
                                                } else if (atomicBoolean.get()) {
                                                    arrayList.add(Long.valueOf(j));
                                                }
                                            }
                                        } else if (this.f334a.n) {
                                            Launcher.a("Launcher.Model", "Invalid package found: " + component, true);
                                        } else {
                                            Launcher.a("Launcher.Model", "Invalid package removed: " + component, true);
                                            arrayList.add(Long.valueOf(j));
                                        }
                                    } catch (URISyntaxException e) {
                                        Launcher.a("Launcher.Model", "Invalid uri: " + string, true);
                                    }
                                    break;
                                case 2:
                                    long j2 = cursorQuery.getLong(columnIndexOrThrow);
                                    dg dgVarB = iv.b(iv.g, j2);
                                    dgVarB.q = cursorQuery.getString(columnIndexOrThrow3);
                                    dgVarB.f = j2;
                                    int i3 = cursorQuery.getInt(columnIndexOrThrow8);
                                    dgVarB.h = i3;
                                    dgVarB.i = cursorQuery.getInt(columnIndexOrThrow12);
                                    dgVarB.j = cursorQuery.getInt(columnIndexOrThrow13);
                                    dgVarB.k = cursorQuery.getInt(columnIndexOrThrow14);
                                    dgVarB.l = 1;
                                    dgVarB.m = 1;
                                    if (i3 == -100 && a(dgVarB)) {
                                        Log.d("Launcher.Model", "Skipped loading out of bounds folder");
                                    } else {
                                        atomicBoolean.set(false);
                                        if (a(map, dgVarB, atomicBoolean)) {
                                            switch (i3) {
                                                case -101:
                                                case -100:
                                                    iv.e.add(dgVarB);
                                                    break;
                                            }
                                            iv.d.put(Long.valueOf(dgVarB.f), dgVarB);
                                            iv.g.put(Long.valueOf(dgVarB.f), dgVarB);
                                        } else if (atomicBoolean.get()) {
                                            arrayList.add(Long.valueOf(j2));
                                        }
                                    }
                                    break;
                                case 3:
                                default:
                                    break;
                                case 4:
                                    int i4 = cursorQuery.getInt(columnIndexOrThrow10);
                                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                                    long j3 = cursorQuery.getLong(columnIndexOrThrow);
                                    AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(i4);
                                    if (zIsSafeMode || !(appWidgetInfo == null || appWidgetInfo.provider == null || appWidgetInfo.provider.getPackageName() == null)) {
                                        it itVar = new it(i4, appWidgetInfo.provider);
                                        itVar.f = j3;
                                        itVar.i = cursorQuery.getInt(columnIndexOrThrow12);
                                        itVar.j = cursorQuery.getInt(columnIndexOrThrow13);
                                        itVar.k = cursorQuery.getInt(columnIndexOrThrow14);
                                        itVar.l = cursorQuery.getInt(columnIndexOrThrow15);
                                        itVar.m = cursorQuery.getInt(columnIndexOrThrow16);
                                        int[] iArrB = Launcher.b(context, appWidgetInfo);
                                        itVar.n = iArrB[0];
                                        itVar.o = iArrB[1];
                                        int i5 = cursorQuery.getInt(columnIndexOrThrow8);
                                        if (i5 == -100 || i5 == -101) {
                                            itVar.h = cursorQuery.getInt(columnIndexOrThrow8);
                                            if (i5 == -100 && a(itVar)) {
                                                Log.d("Launcher.Model", "Skipped loading out of bounds app widget");
                                            } else {
                                                atomicBoolean.set(false);
                                                if (a(map, itVar, atomicBoolean)) {
                                                    String strFlattenToString = appWidgetInfo.provider.flattenToString();
                                                    if (!strFlattenToString.equals(string2)) {
                                                        ContentValues contentValues = new ContentValues();
                                                        contentValues.put("appWidgetProvider", strFlattenToString);
                                                        contentResolver.update(uri, contentValues, "_id= ?", new String[]{Integer.toString(cursorQuery.getInt(columnIndexOrThrow))});
                                                    }
                                                    iv.d.put(Long.valueOf(itVar.f), itVar);
                                                    iv.f.add(itVar);
                                                } else if (atomicBoolean.get()) {
                                                    arrayList.add(Long.valueOf(j3));
                                                }
                                            }
                                        } else {
                                            Log.e("Launcher.Model", "Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
                                        }
                                    } else {
                                        String str = "Deleting widget that isn't installed anymore: id=" + j3 + " appWidgetId=" + i4;
                                        Log.e("Launcher.Model", str);
                                        Launcher.a("Launcher.Model", str, false);
                                        arrayList.add(Long.valueOf(j3));
                                    }
                                    break;
                            }
                        } catch (Exception e2) {
                            Launcher.a("Launcher.Model", "Desktop items loading interrupted: " + e2, true);
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (this.e) {
                        h();
                        return false;
                    }
                    if (arrayList.size() > 0) {
                        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(kq.f358a);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            long jLongValue = ((Long) it.next()).longValue();
                            try {
                                contentProviderClientAcquireContentProviderClient.delete(kq.a(jLongValue, false), null, null);
                            } catch (RemoteException e3) {
                                Log.w("Launcher.Model", "Could not remove id = " + jLongValue);
                            }
                        }
                    }
                    if (zC) {
                        long j4 = 0;
                        for (ec ecVar : iv.d.values()) {
                            long j5 = ecVar.i;
                            if (ecVar.h == -100 && !iv.i.contains(Long.valueOf(j5))) {
                                iv.i.add(Long.valueOf(j5));
                                if (j5 > j4) {
                                    j4 = j5;
                                }
                            }
                        }
                        Collections.sort(iv.i);
                        ip.g().b(j4);
                        this.f334a.a(context, iv.i);
                        Iterator it2 = iv.d.values().iterator();
                        long jMax = 0;
                        while (it2.hasNext()) {
                            jMax = Math.max(jMax, ((ec) it2.next()).f);
                        }
                        ip.g().a(jMax);
                    } else {
                        TreeMap treeMapD = iv.d(this.b);
                        Iterator it3 = treeMapD.keySet().iterator();
                        while (it3.hasNext()) {
                            iv.i.add((Long) treeMapD.get((Integer) it3.next()));
                        }
                        ArrayList arrayList2 = new ArrayList(iv.i);
                        for (ec ecVar2 : iv.d.values()) {
                            long j6 = ecVar2.i;
                            if (ecVar2.h == -100 && arrayList2.contains(Long.valueOf(j6))) {
                                arrayList2.remove(Long.valueOf(j6));
                            }
                        }
                        if (arrayList2.size() != 0) {
                            iv.i.removeAll(arrayList2);
                            this.f334a.a(context, iv.i);
                        }
                    }
                    return zC;
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void j() {
        if (this.f334a.x) {
            k();
            return;
        }
        l();
        synchronized (this) {
            if (!this.e) {
                this.f334a.x = true;
            }
        }
    }

    private void k() {
        jn jnVar = (jn) this.f334a.y.get();
        if (jnVar == null) {
            Log.w("Launcher.Model", "LoaderTask running with no launcher (onlyBindAllApps)");
            return;
        }
        js jsVar = new js(this, jnVar, (ArrayList) b.f123a.clone());
        if (iv.u.getThreadId() != Process.myTid()) {
            jsVar.run();
        } else {
            this.f334a.q.a(jsVar);
        }
    }

    private void l() {
        int i = 0;
        jn jnVar = (jn) this.f334a.y.get();
        if (jnVar == null) {
            Log.w("Launcher.Model", "LoaderTask running with no launcher (loadAllApps)");
            return;
        }
        PackageManager packageManager = this.b.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        this.f334a.b.a();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
            return;
        }
        Collections.sort(listQueryIntentActivities, new kh(packageManager, this.g));
        while (true) {
            int i2 = i;
            if (i2 >= listQueryIntentActivities.size()) {
                ArrayList arrayList = this.f334a.b.b;
                this.f334a.b.b = new ArrayList();
                this.f334a.q.a(new jt(this, jnVar, arrayList));
                return;
            }
            this.f334a.b.a(new d(packageManager, listQueryIntentActivities.get(i2), this.f334a.z, this.g));
            i = i2 + 1;
        }
    }

    jn a(jn jnVar) {
        synchronized (this.f334a.p) {
            if (this.e) {
                return null;
            }
            if (this.f334a.y == null) {
                return null;
            }
            jn jnVar2 = (jn) this.f334a.y.get();
            if (jnVar2 != jnVar) {
                return null;
            }
            if (jnVar2 != null) {
                return jnVar2;
            }
            Log.w("Launcher.Model", "no mCallbacks");
            return null;
        }
    }

    void a(int i) {
        com.syu.d.a.b("runBindSynchronousPage");
        if (i < 0) {
            throw new RuntimeException("Should not call runBindSynchronousPage() without valid page index");
        }
        if (!this.f334a.x || !this.f334a.w) {
            throw new RuntimeException("Expecting AllApps and Workspace to be loaded");
        }
        synchronized (this.f334a.p) {
            if (this.f334a.s) {
                throw new RuntimeException("Error! Background loading is already running");
            }
        }
        this.f334a.q.a();
        a(i, false);
        k();
    }

    boolean a() {
        return this.c;
    }

    boolean b() {
        return this.d;
    }

    public void c() {
        synchronized (this) {
            this.e = true;
            notify();
        }
    }

    public void d() {
        synchronized (iv.c) {
            Log.d("Launcher.Model", "mLoaderTask.mContext=" + this.b);
            Log.d("Launcher.Model", "mLoaderTask.mIsLaunching=" + this.c);
            Log.d("Launcher.Model", "mLoaderTask.mStopped=" + this.e);
            Log.d("Launcher.Model", "mLoaderTask.mLoadAndBindStepFinished=" + this.f);
            Log.d("Launcher.Model", "mItems size=" + iv.e.size());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f334a.p) {
            this.f334a.s = true;
        }
        synchronized (this.f334a.p) {
            Process.setThreadPriority(this.c ? 0 : 10);
        }
        e();
        if (!this.e) {
            synchronized (this.f334a.p) {
                if (this.c) {
                    Process.setThreadPriority(10);
                }
            }
            f();
            j();
            synchronized (this.f334a.p) {
                Process.setThreadPriority(0);
            }
        }
        synchronized (iv.c) {
            for (Object obj : iv.h.keySet()) {
                this.f334a.a(this.b, (mp) obj, (byte[]) iv.h.get(obj));
            }
            iv.h.clear();
        }
        if (AppsCustomizePagedView.b) {
            g();
        }
        this.b = null;
        synchronized (this.f334a.p) {
            if (this.f334a.r == this) {
                this.f334a.r = null;
            }
            this.f334a.s = false;
        }
    }
}
