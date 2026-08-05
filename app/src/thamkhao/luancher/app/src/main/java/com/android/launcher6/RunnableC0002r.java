package com.android.launcher6;

/* JADX INFO: renamed from: com.android.launcher6.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0002r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizeTabHost f462a;

    RunnableC0002r(AppsCustomizeTabHost appsCustomizeTabHost) {
        this.f462a = appsCustomizeTabHost;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f462a.b.requestLayout();
        this.f462a.c.setAlpha(1.0f);
    }
}
