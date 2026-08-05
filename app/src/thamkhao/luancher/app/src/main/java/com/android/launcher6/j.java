package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f321a;

    j(AppsCustomizePagedView appsCustomizePagedView) {
        this.f321a = appsCustomizePagedView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f321a.b();
    }
}
