package com.android.launcher6;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ji implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f329a;
    private final /* synthetic */ ArrayList b;
    private final /* synthetic */ ArrayList c;

    ji(iv ivVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f329a = ivVar;
        this.b = arrayList;
        this.c = arrayList2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((ec) it.next()).b_();
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            ((ec) it2.next()).b_();
        }
    }
}
