package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class cu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Folder f164a;

    cu(Folder folder) {
        this.f164a = folder;
    }

    @Override // java.lang.Runnable
    public void run() {
        CellLayout cellLayoutA = this.f164a.b.a(this.f164a.c.h, this.f164a.c.i);
        View view = null;
        if (this.f164a.getItemCount() == 1) {
            mp mpVar = (mp) this.f164a.c.b.get(0);
            View viewA = this.f164a.b.a(R.layout.application, cellLayoutA, mpVar);
            iv.a(this.f164a.b, mpVar, this.f164a.c.h, this.f164a.c.i, this.f164a.c.j, this.f164a.c.k);
            view = viewA;
        }
        if (this.f164a.getItemCount() <= 1) {
            iv.b(this.f164a.b, this.f164a.c);
            cellLayoutA.removeView(this.f164a.p);
            if (this.f164a.p instanceof ce) {
                this.f164a.f79a.b((ce) this.f164a.p);
            }
            this.f164a.b.a(this.f164a.c);
        }
        if (view != null) {
            this.f164a.b.I().b(view, this.f164a.c.h, this.f164a.c.i, this.f164a.c.j, this.f164a.c.k, this.f164a.c.l, this.f164a.c.m);
        }
    }
}
