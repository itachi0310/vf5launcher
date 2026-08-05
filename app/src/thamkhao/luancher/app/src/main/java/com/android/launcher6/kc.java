package com.android.launcher6;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class kc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f348a;
    String[] b;
    final /* synthetic */ iv c;

    public kc(iv ivVar, int i, String[] strArr) {
        this.c = ivVar;
        this.f348a = i;
        this.b = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList<d> arrayList2;
        Context contextB = this.c.o.b();
        String[] strArr = this.b;
        int length = strArr.length;
        switch (this.f348a) {
            case 1:
                for (String str : strArr) {
                    this.c.b.a(contextB, str);
                }
                break;
            case 2:
                for (int i = 0; i < length; i++) {
                    this.c.b.b(contextB, strArr[i]);
                    ob.a(this.c.o.f(), strArr[i]);
                }
                break;
            case 3:
            case 4:
                for (int i2 = 0; i2 < length; i2++) {
                    this.c.b.a(strArr[i2]);
                    ob.a(this.c.o.f(), strArr[i2]);
                }
                break;
        }
        ArrayList arrayList3 = new ArrayList();
        if (this.c.b.b.size() > 0) {
            ArrayList arrayList4 = new ArrayList(this.c.b.b);
            this.c.b.b.clear();
            arrayList = arrayList4;
        } else {
            arrayList = null;
        }
        if (this.c.b.d.size() > 0) {
            ArrayList arrayList5 = new ArrayList(this.c.b.d);
            this.c.b.d.clear();
            arrayList2 = arrayList5;
        } else {
            arrayList2 = null;
        }
        if (this.c.b.c.size() > 0) {
            arrayList3.addAll(this.c.b.c);
            this.c.b.c.clear();
        }
        jn jnVar = this.c.y != null ? (jn) this.c.y.get() : null;
        if (jnVar == null) {
            Log.w("Launcher.Model", "Nobody to tell about the new app.  Launcher is probably loading.");
            return;
        }
        if (arrayList != null) {
            jn jnVar2 = this.c.y != null ? (jn) this.c.y.get() : null;
            if (AppsCustomizePagedView.b) {
                this.c.a(contextB, new ArrayList(arrayList), jnVar2, arrayList);
            } else {
                this.c.a(contextB, new ArrayList(), jnVar2, arrayList);
            }
        }
        if (arrayList2 != null) {
            for (d dVar : arrayList2) {
                for (ec ecVar : this.c.a(dVar.d)) {
                    if (iv.b(ecVar)) {
                        mp mpVar = (mp) ecVar;
                        mpVar.q = dVar.q.toString();
                        iv.a(contextB, mpVar);
                    }
                }
            }
            this.c.q.a(new kd(this, jnVar, arrayList2));
        }
        if (this.f348a == 3 || !arrayList3.isEmpty()) {
            boolean z = this.f348a == 3;
            ArrayList arrayList6 = new ArrayList(Arrays.asList(strArr));
            if (z) {
                Iterator it = arrayList6.iterator();
                while (it.hasNext()) {
                    Iterator it2 = this.c.a((String) it.next()).iterator();
                    while (it2.hasNext()) {
                        iv.b(contextB, (ec) it2.next());
                    }
                }
                InstallShortcutReceiver.a(contextB.getSharedPreferences(ip.h(), 0), arrayList6);
            } else {
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    Iterator it4 = this.c.a(((d) it3.next()).d).iterator();
                    while (it4.hasNext()) {
                        iv.b(contextB, (ec) it4.next());
                    }
                }
            }
            this.c.q.a(new ke(this, jnVar, arrayList6, arrayList3, z));
        }
        this.c.q.a(new kf(this, jnVar, iv.b(contextB)));
        this.c.q.a(new kg(this, jnVar));
    }
}
