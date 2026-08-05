package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class lt extends ViewGroup implements lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected lv f382a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public lt(Context context) {
        this(context, null);
    }

    public lt(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public lt(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setAlwaysDrawnWithCacheEnabled(false);
        bl blVarA = ip.a().i().a();
        int i2 = blVarA.w;
        this.f = i2;
        this.d = i2;
        int i3 = blVarA.x;
        this.g = i3;
        this.e = i3;
        this.b = (int) blVarA.e;
        this.c = (int) blVarA.d;
        this.k = -1;
        this.j = -1;
        this.i = -1;
        this.h = -1;
        this.f382a = new lv(context);
        this.f382a.b(this.f, this.g);
        this.f382a.a(this.j, this.k);
        addView(this.f382a);
    }

    public View a(int i) {
        return this.f382a.getChildAt(i);
    }

    @Override // com.android.launcher6.lg
    public void a() {
        this.f382a.removeAllViews();
        setLayerType(0, null);
    }

    public int[] a(int i, int i2) {
        return new int[]{getPaddingLeft() + (this.f * i) + (this.j * i) + (this.f / 2), getPaddingTop() + (this.g * i2) + (this.k * i2) + (this.g / 2)};
    }

    public int b(int i) {
        return this.f * i;
    }

    public int c(int i) {
        return this.g * i;
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof lu;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new lu(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new lu(layoutParams);
    }

    public int getCellCountX() {
        return this.b;
    }

    public int getCellCountY() {
        return this.c;
    }

    public int getCellHeight() {
        return this.g;
    }

    public int getCellWidth() {
        return this.f;
    }

    public lv getChildrenLayout() {
        return this.f382a;
    }

    int getContentHeight() {
        if (this.c <= 0) {
            return 0;
        }
        return (Math.max(0, this.k) * (this.c - 1)) + (this.c * this.g);
    }

    int getContentWidth() {
        return getWidthBeforeFirstLayout() + getPaddingLeft() + getPaddingRight();
    }

    @Override // com.android.launcher6.lg
    public int getPageChildCount() {
        return this.f382a.getChildCount();
    }

    int getWidthBeforeFirstLayout() {
        if (this.b <= 0) {
            return 0;
        }
        return (Math.max(0, this.j) * (this.b - 1)) + (this.b * this.f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int paddingLeft;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        int i3 = this.b - 1;
        int i4 = this.c - 1;
        if (this.h < 0 || this.i < 0) {
            int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (size2 - getPaddingTop()) - getPaddingBottom();
            int i5 = paddingLeft2 - (this.b * this.d);
            int i6 = paddingTop2 - (this.c * this.e);
            this.j = i3 > 0 ? i5 / i3 : 0;
            this.k = i4 > 0 ? i6 / i4 : 0;
            this.f382a.a(this.j, this.k);
        } else {
            this.j = this.h;
            this.k = this.i;
        }
        if (mode == Integer.MIN_VALUE) {
            paddingLeft = ((this.b - 1) * this.j) + getPaddingLeft() + getPaddingRight() + (this.b * this.f);
            paddingTop = getPaddingTop() + getPaddingBottom() + (this.c * this.g) + ((this.c - 1) * this.k);
            setMeasuredDimension(paddingLeft, paddingTop);
        } else {
            paddingTop = size2;
            paddingLeft = size;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7).measure(View.MeasureSpec.makeMeasureSpec((paddingLeft - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((paddingTop - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        int pageChildCount = getPageChildCount();
        if (pageChildCount <= 0) {
            return zOnTouchEvent;
        }
        int bottom = a(pageChildCount - 1).getBottom();
        if (((int) Math.ceil(getPageChildCount() / getCellCountX())) < getCellCountY()) {
            bottom += this.g / 2;
        }
        return zOnTouchEvent || motionEvent.getY() < ((float) bottom);
    }

    @Override // android.view.ViewGroup
    protected void setChildrenDrawingCacheEnabled(boolean z) {
        this.f382a.setChildrenDrawingCacheEnabled(z);
    }
}
