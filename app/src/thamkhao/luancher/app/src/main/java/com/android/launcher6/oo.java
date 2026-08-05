package com.android.launcher6;

import android.content.ComponentName;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
class oo implements jo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f442a;
    private final /* synthetic */ HashSet b;
    private final /* synthetic */ HashMap c;
    private final /* synthetic */ ArrayList d;
    private final /* synthetic */ HashMap e;

    oo(Workspace workspace, HashSet hashSet, HashMap map, ArrayList arrayList, HashMap map2) {
        this.f442a = workspace;
        this.b = hashSet;
        this.c = map;
        this.d = arrayList;
        this.e = map2;
    }

    @Override // com.android.launcher6.jo
    public boolean a(ec ecVar, ec ecVar2, ComponentName componentName) {
        ArrayList arrayList;
        if (ecVar instanceof dg) {
            if (this.b.contains(componentName)) {
                dg dgVar = (dg) ecVar;
                if (this.c.containsKey(dgVar)) {
                    arrayList = (ArrayList) this.c.get(dgVar);
                } else {
                    arrayList = new ArrayList();
                    this.c.put(dgVar, arrayList);
                }
                arrayList.add((mp) ecVar2);
                return true;
            }
        } else if (this.b.contains(componentName)) {
            this.d.add((View) this.e.get(ecVar2));
            return true;
        }
        return false;
    }
}
