package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class o implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f428a;

    o(AppsCustomizePagedView appsCustomizePagedView) {
        this.f428a = appsCustomizePagedView;
    }

    @Override // com.android.launcher6.x
    public void a(h hVar, y yVar) {
        this.f428a.c.remove(hVar);
        if (hVar.isCancelled()) {
            return;
        }
        this.f428a.a(yVar);
    }
}
