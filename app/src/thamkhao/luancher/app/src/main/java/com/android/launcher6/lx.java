package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class lx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PagedViewIcon f386a;

    lx(PagedViewIcon pagedViewIcon) {
        this.f386a = pagedViewIcon;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f386a.refreshDrawableState();
    }
}
