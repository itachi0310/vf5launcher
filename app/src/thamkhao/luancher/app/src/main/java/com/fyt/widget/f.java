package com.fyt.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
class f extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorizontalListView f497a;

    f(HorizontalListView horizontalListView) {
        this.f497a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.f497a) {
            this.f497a.o = true;
        }
        this.f497a.invalidate();
        this.f497a.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f497a.b();
        this.f497a.invalidate();
        this.f497a.requestLayout();
    }
}
