package com.android.c.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f64a;

    private d() {
    }

    /* synthetic */ d(d dVar) {
        this();
    }

    private boolean b(b bVar) {
        for (b bVar2 = this.f64a; bVar2 != null; bVar2 = bVar2.l) {
            if (bVar2 == bVar) {
                return true;
            }
        }
        return false;
    }

    public b a() {
        b bVar = this.f64a;
        if (bVar != null) {
            this.f64a = bVar.l;
        }
        return bVar;
    }

    public boolean a(b bVar) {
        boolean z = false;
        if (b(bVar)) {
            Log.w("TiledImageRenderer", "Attempting to add a tile already in the queue!");
        } else {
            z = this.f64a == null;
            bVar.l = this.f64a;
            this.f64a = bVar;
        }
        return z;
    }

    public void b() {
        this.f64a = null;
    }
}
