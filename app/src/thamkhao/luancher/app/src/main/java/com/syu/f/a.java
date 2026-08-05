package com.syu.f;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.syu.c.b {
    List b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f523a = new Handler(Looper.getMainLooper());

    @Override // com.syu.c.a
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        new c(this, i, iArr, fArr, strArr).a();
    }

    void a(e eVar) {
        for (b bVar : new ArrayList(this.b)) {
            if (bVar.f524a.equals(eVar) && this.b.contains(bVar)) {
                this.b.remove(bVar);
            }
        }
    }

    void a(e eVar, int i) {
        b bVar = new b(this, eVar, i);
        if (this.b.contains(bVar)) {
            return;
        }
        this.b.add(bVar);
    }
}
