package com.android.launcher17;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class MCellLayout extends CellLayout implements View.OnLongClickListener {
    public MCellLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context) {
        super(context);
        setOnLongClickListener(this);
    }

    @Override // com.android.launcher17.CellLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override // com.android.launcher17.CellLayout
    boolean existsEmptyCell() {
        return false;
    }

    @Override // com.android.launcher17.CellLayout
    public boolean animateChildToPosition(View child, int cellX, int cellY, int duration, int delay, boolean permanent, boolean adjustOccupied) {
        return false;
    }

    @Override // com.android.launcher17.CellLayout
    public boolean addViewToCellLayout(View child, int index, int childId, CellLayout.LayoutParams params, boolean markCells) {
        if (params.cellX < 0 || params.cellX > getCountX() || params.cellY < 0 || params.cellY > getCountY()) {
            return false;
        }
        if (params.cellHSpan < 0) {
            params.cellHSpan = getCountX();
        }
        if (params.cellVSpan < 0) {
            params.cellVSpan = getCountY();
        }
        child.setId(childId);
        if (markCells) {
            markCellsAsOccupiedForView(child);
        }
        return true;
    }

    @Override // com.android.launcher17.CellLayout
    int[] createArea(int pixelX, int pixelY, int minSpanX, int minSpanY, int spanX, int spanY, View dragView, int[] result, int[] resultSpan, int mode) {
        return new int[]{-1, -1};
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (!(v instanceof MCellLayout) || Launcher.getWorkSpace().isInOverviewMode()) {
            return true;
        }
        if (Launcher.getWorkSpace().enterOverviewMode()) {
            if (Launcher.getLauncher() != null) {
                Launcher.getLauncher().hideHotseat(true);
            }
            Launcher.getWorkSpace().performHapticFeedback(0, 1);
            return true;
        }
        if (Launcher.getLauncher() != null) {
            Launcher.getLauncher().showHotseat(true);
        }
        return false;
    }
}
