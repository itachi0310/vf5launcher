package com.android.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class DrawableStateProxyView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f78a;
    private int b;

    public DrawableStateProxyView(Context context) {
        this(context, null);
    }

    public DrawableStateProxyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableStateProxyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.DrawableStateProxyView, i, 0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f78a == null) {
            this.f78a = ((View) getParent()).findViewById(this.b);
        }
        if (this.f78a != null) {
            this.f78a.setPressed(isPressed());
            this.f78a.setHovered(isHovered());
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }
}
