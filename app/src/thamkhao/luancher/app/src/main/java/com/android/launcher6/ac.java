package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ac extends TextView implements bp, ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f101a;
    protected Launcher b;
    protected SearchDropTargetBar c;
    protected boolean d;
    protected int e;
    private int f;

    public ac(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ac(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        Resources resources = getResources();
        this.f101a = resources.getInteger(R.integer.config_dropTargetBgTransitionDuration);
        this.f = resources.getDimensionPixelSize(R.dimen.drop_target_drag_padding);
    }

    private boolean c() {
        return getLayoutDirection() == 1;
    }

    Rect a(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingRight;
        DragLayer dragLayerF = this.b.f();
        Rect rect = new Rect();
        dragLayerF.b(this, rect);
        if (c()) {
            paddingRight = rect.right - getPaddingRight();
            paddingLeft = paddingRight - i3;
        } else {
            paddingLeft = getPaddingLeft() + rect.left;
            paddingRight = paddingLeft + i3;
        }
        int measuredHeight = rect.top + ((getMeasuredHeight() - i4) / 2);
        rect.set(paddingLeft, measuredHeight, paddingRight, measuredHeight + i4);
        rect.offset((-(i - i3)) / 2, (-(i2 - i4)) / 2);
        return rect;
    }

    @Override // com.android.launcher6.ce
    public void a(Rect rect) {
        super.getHitRect(rect);
        rect.bottom += this.f;
        int[] iArr = new int[2];
        this.b.f().b(this, iArr);
        rect.offsetTo(iArr[0], iArr[1]);
    }

    public void a(bz bzVar, Object obj, int i) {
    }

    public void a(cg cgVar, int i, int i2, PointF pointF) {
    }

    public boolean a(cg cgVar) {
        return false;
    }

    public void b() {
    }

    public void b(cg cgVar) {
    }

    public void c(cg cgVar) {
        cgVar.f.setColor(this.e);
    }

    @Override // com.android.launcher6.ce
    public void d(cg cgVar) {
    }

    public void e(cg cgVar) {
        cgVar.f.setColor(0);
    }

    @Override // com.android.launcher6.ce
    public boolean e_() {
        return this.d;
    }

    protected Drawable getCurrentDrawable() {
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        for (int i = 0; i < compoundDrawablesRelative.length; i++) {
            if (compoundDrawablesRelative[i] != null) {
                return compoundDrawablesRelative[i];
            }
        }
        return null;
    }

    void setLauncher(Launcher launcher) {
        this.b = launcher;
    }

    public void setSearchDropTargetBar(SearchDropTargetBar searchDropTargetBar) {
        this.c = searchDropTargetBar;
    }
}
