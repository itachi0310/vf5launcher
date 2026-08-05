package com.fyt.widget;

/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorizontalListView f499a;

    h(HorizontalListView horizontalListView) {
        this.f499a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f499a.requestLayout();
    }
}
