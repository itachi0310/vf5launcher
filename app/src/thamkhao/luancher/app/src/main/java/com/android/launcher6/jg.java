package com.android.launcher6;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class jg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f327a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ ArrayList c;
    private final /* synthetic */ ArrayList d;
    private final /* synthetic */ jn e;

    jg(iv ivVar, Context context, ArrayList arrayList, ArrayList arrayList2, jn jnVar) {
        this.f327a = ivVar;
        this.b = context;
        this.c = arrayList;
        this.d = arrayList2;
        this.e = jnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair pairA;
        mp mpVarC;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        TreeMap treeMapD = iv.d(this.b);
        Iterator it = treeMapD.keySet().iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf(((Long) treeMapD.get((Integer) it.next())).longValue()));
        }
        if (arrayList3.size() <= 0) {
            arrayList3.add(1L);
        }
        synchronized (iv.c) {
            for (ec ecVar : this.c) {
                String string = ecVar.q.toString();
                Intent intentB = ecVar.b();
                if (!iv.a(this.b, string, intentB)) {
                    Pair pairA2 = iv.a(this.b, string, intentB, 0, arrayList3);
                    if (pairA2 == null) {
                        LauncherProvider launcherProviderG = ip.g();
                        for (int iMax = Math.max(1, 1 - arrayList3.size()); iMax > 0; iMax--) {
                            long jB = launcherProviderG.b() + ((Long) arrayList3.get(0)).longValue();
                            arrayList3.add(Long.valueOf(jB));
                            arrayList2.add(Long.valueOf(jB));
                        }
                        pairA = iv.a(this.b, string, intentB, 0, arrayList3);
                    } else {
                        pairA = pairA2;
                    }
                    if (pairA == null) {
                        throw new RuntimeException("Coordinates should not be null");
                    }
                    if (ecVar instanceof mp) {
                        mpVarC = (mp) ecVar;
                    } else {
                        if (!(ecVar instanceof d)) {
                            throw new RuntimeException("Unexpected info type");
                        }
                        mpVarC = ((d) ecVar).c();
                    }
                    iv.a(this.b, (ec) mpVarC, -100L, ((Long) pairA.first).longValue(), ((int[]) pairA.second)[0], ((int[]) pairA.second)[1], false);
                    arrayList.add(mpVarC);
                }
            }
        }
        this.f327a.a(this.b, arrayList3);
        if ((arrayList == null || arrayList.isEmpty()) && (this.d == null || this.d.isEmpty())) {
            return;
        }
        this.f327a.a(new jh(this, this.e, arrayList, arrayList2, this.d));
    }
}
