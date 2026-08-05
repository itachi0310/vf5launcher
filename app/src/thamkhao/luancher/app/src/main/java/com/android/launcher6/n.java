package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class n implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f406a;
    private final /* synthetic */ int b;

    n(AppsCustomizePagedView appsCustomizePagedView, int i) {
        this.f406a = appsCustomizePagedView;
        this.b = i;
    }

    @Override // com.android.launcher6.x
    public void a(h hVar, y yVar) {
        try {
            try {
                Thread.sleep(this.b);
            } catch (Exception e) {
            }
            this.f406a.a(hVar, yVar);
        } finally {
            if (hVar.isCancelled()) {
                yVar.a(true);
            }
        }
    }
}
