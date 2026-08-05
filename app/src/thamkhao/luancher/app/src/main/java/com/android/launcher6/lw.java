package com.android.launcher6;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/* JADX INFO: loaded from: classes.dex */
public class lw extends GridLayout implements lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f385a;
    private int b;
    private Runnable c;

    public lw(Context context, int i, int i2) {
        super(context, null, 0);
        this.f385a = i;
        this.b = i2;
    }

    public View a(int i) {
        return getChildAt(i);
    }

    @Override // com.android.launcher6.lg
    public void a() {
        removeAllViews();
        this.c = null;
        setLayerType(0, null);
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setOnKeyListener(null);
        }
    }

    int getCellCountX() {
        return this.f385a;
    }

    int getCellCountY() {
        return this.b;
    }

    @Override // com.android.launcher6.lg
    public int getPageChildCount() {
        return getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = null;
    }

    @Override // android.widget.GridLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null) {
            this.c.run();
        }
    }

    @Override // android.widget.GridLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getSuggestedMinimumWidth(), View.MeasureSpec.getSize(i)), 1073741824), i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        int pageChildCount = getPageChildCount();
        if (pageChildCount > 0) {
            return zOnTouchEvent || motionEvent.getY() < ((float) a(pageChildCount + (-1)).getBottom());
        }
        return zOnTouchEvent;
    }

    public void setOnLayoutListener(Runnable runnable) {
        this.c = runnable;
    }
}
