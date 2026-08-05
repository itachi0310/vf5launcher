package com.android.launcher6;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class mo extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f395a;
    private final WallpaperManager b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;

    public mo(Context context) {
        super(context);
        this.f395a = new int[2];
        this.j = false;
        this.b = WallpaperManager.getInstance(context);
    }

    private boolean b() {
        return this.j && a();
    }

    public View a(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            al alVar = (al) childAt.getLayoutParams();
            if (alVar.f109a <= i && i < alVar.f109a + alVar.f && alVar.b <= i2) {
                if (i2 < alVar.g + alVar.b) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    public void a(View view) {
        bl blVarA = ip.a().i().a();
        int i = this.d;
        int i2 = this.e;
        al alVar = (al) view.getLayoutParams();
        if (alVar.i) {
            alVar.k = 0;
            alVar.l = 0;
            alVar.width = getMeasuredWidth();
            alVar.height = getMeasuredHeight();
        } else {
            alVar.a(i, i2, this.f, this.g, b(), this.h);
            if (!(view instanceof is)) {
                int iMax = (int) Math.max(0.0f, (alVar.height - getCellContentHeight()) / 2.0f);
                int i3 = (int) (blVarA.o / 2.0f);
                view.setPadding(i3, iMax + LauncherApplication.f88a.getResources().getInteger(R.integer.image_cell_top), i3, 0);
            }
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(alVar.width, 1073741824), View.MeasureSpec.makeMeasureSpec(alVar.height, 1073741824));
    }

    public boolean a() {
        return getLayoutDirection() == 1;
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
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    int getCellContentHeight() {
        bl blVarA = ip.a().i().a();
        return Math.min(getMeasuredHeight(), this.c ? blVarA.D : blVarA.x);
    }

    int getCellContentWidth() {
        bl blVarA = ip.a().i().a();
        return Math.min(getMeasuredHeight(), this.c ? blVarA.C : blVarA.w);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                al alVar = (al) childAt.getLayoutParams();
                int i6 = alVar.k;
                int i7 = alVar.l;
                childAt.layout(i6, i7, alVar.width + i6, alVar.height + i7);
                if (alVar.m) {
                    alVar.m = false;
                    int[] iArr = this.f395a;
                    getLocationOnScreen(iArr);
                    this.b.sendWallpaperCommand(getWindowToken(), "android.home.drop", i6 + iArr[0] + (alVar.width / 2), (alVar.height / 2) + i7 + iArr[1], 0, null);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a(childAt);
            }
        }
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
            if (!childAt.isHardwareAccelerated() && z) {
                childAt.buildDrawingCache(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void setChildrenDrawnWithCacheEnabled(boolean z) {
        super.setChildrenDrawnWithCacheEnabled(z);
    }

    public void setInvertIfRtl(boolean z) {
        this.j = z;
    }

    public void setIsHotseat(boolean z) {
        this.c = z;
    }

    public void setupLp(al alVar) {
        alVar.a(this.d, this.e, this.f, this.g, b(), this.h);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
