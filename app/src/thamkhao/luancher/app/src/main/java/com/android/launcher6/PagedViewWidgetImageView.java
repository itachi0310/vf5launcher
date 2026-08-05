package com.android.launcher6;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class PagedViewWidgetImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f95a;

    public PagedViewWidgetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95a = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(getScrollX() + getPaddingLeft(), getScrollY() + getPaddingTop(), ((getScrollX() + getRight()) - getLeft()) - getPaddingRight(), ((getScrollY() + getBottom()) - getTop()) - getPaddingBottom());
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void requestLayout() {
        if (this.f95a) {
            super.requestLayout();
        }
    }
}
