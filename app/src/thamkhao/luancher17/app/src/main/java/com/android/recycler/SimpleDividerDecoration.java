package com.android.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight = 0;

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(this.dividerHeight, 0, 0, 0);
    }
}
