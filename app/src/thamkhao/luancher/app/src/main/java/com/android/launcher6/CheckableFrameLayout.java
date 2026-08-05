package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CheckableFrameLayout extends FrameLayout implements Checkable {
    private static final int[] b = {android.R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f74a;

    public CheckableFrameLayout(Context context) {
        super(context);
    }

    public CheckableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f74a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z != this.f74a) {
            this.f74a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f74a);
    }
}
