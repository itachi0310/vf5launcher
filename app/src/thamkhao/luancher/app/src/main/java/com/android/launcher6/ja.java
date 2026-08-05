package com.android.launcher6;

import android.content.ContentResolver;

/* JADX INFO: loaded from: classes.dex */
class ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ContentResolver f322a;
    private final /* synthetic */ dg b;

    ja(ContentResolver contentResolver, dg dgVar) {
        this.f322a = contentResolver;
        this.b = dgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f322a.delete(kq.a(this.b.f, false), null, null);
        synchronized (iv.c) {
            iv.d.remove(Long.valueOf(this.b.f));
            iv.g.remove(Long.valueOf(this.b.f));
            iv.h.remove(this.b);
            iv.e.remove(this.b);
        }
        this.f322a.delete(kq.c, "container=" + this.b.f, null);
        synchronized (iv.c) {
            for (ec ecVar : this.b.b) {
                iv.d.remove(Long.valueOf(ecVar.f));
                iv.h.remove(ecVar);
            }
        }
    }
}
