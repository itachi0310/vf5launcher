package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class lz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PagedViewWidget f387a;

    lz(PagedViewWidget pagedViewWidget) {
        this.f387a = pagedViewWidget;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (PagedViewWidget.d != null) {
            return;
        }
        if (this.f387a.b != null) {
            this.f387a.b.a(this.f387a);
            PagedViewWidget.d = this.f387a;
        }
        this.f387a.c = true;
    }
}
