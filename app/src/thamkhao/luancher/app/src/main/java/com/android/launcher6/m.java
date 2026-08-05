package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f388a;

    m(AppsCustomizePagedView appsCustomizePagedView) {
        this.f388a = appsCustomizePagedView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f388a.as.t().a()) {
            this.f388a.k();
            this.f388a.as.K();
        }
    }
}
