package com.android.launcher17;

import android.view.View;

/* JADX INFO: compiled from: PagedView.java */
/* JADX INFO: loaded from: classes.dex */
interface Page {
    View getChildOnPageAt(int i);

    int getPageChildCount();

    int indexOfChildOnPage(View view);

    void removeAllViewsOnPage();

    void removeViewOnPageAt(int i);
}
