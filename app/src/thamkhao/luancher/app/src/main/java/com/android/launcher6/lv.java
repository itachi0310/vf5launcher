package com.android.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class lv extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f384a;
    private int b;
    private int c;
    private int d;
    private int e;

    public lv(Context context) {
        super(context);
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        requestLayout();
    }

    public void b(int i, int i2) {
        this.b = i;
        this.c = i2;
        requestLayout();
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int iMax;
        int childCount = getChildCount();
        if (!this.f384a || childCount <= 0) {
            measuredWidth = 0;
        } else {
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            int i8 = 0;
            while (i7 < childCount) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    lu luVar = (lu) childAt.getLayoutParams();
                    int iMin = Math.min(i6, luVar.e);
                    iMax = Math.max(i8, luVar.width + luVar.e);
                    i5 = iMin;
                } else {
                    i5 = i6;
                    iMax = i8;
                }
                i7++;
                i8 = iMax;
                i6 = i5;
            }
            measuredWidth = (getMeasuredWidth() - (i8 - i6)) / 2;
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                lu luVar2 = (lu) childAt2.getLayoutParams();
                int i10 = luVar2.e + measuredWidth;
                int i11 = luVar2.f;
                childAt2.layout(i10, i11, luVar2.width + i10, luVar2.height + i11);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            lu luVar = (lu) childAt.getLayoutParams();
            luVar.a(getContext(), this.b, this.c, this.d, this.e, getPaddingLeft(), getPaddingTop());
            childAt.measure(View.MeasureSpec.makeMeasureSpec(luVar.width, 1073741824), View.MeasureSpec.makeMeasureSpec(luVar.height, 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (view != null) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            requestRectangleOnScreen(rect);
        }
    }

    @Override // android.view.ViewGroup
    protected void setChildrenDrawingCacheEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.setDrawingCacheEnabled(z);
            if (!childAt.isHardwareAccelerated()) {
                childAt.buildDrawingCache(true);
            }
        }
    }
}
