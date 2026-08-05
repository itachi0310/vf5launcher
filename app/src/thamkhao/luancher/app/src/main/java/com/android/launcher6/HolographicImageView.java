package com.android.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class HolographicImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dr f82a;
    private boolean b;
    private boolean c;
    private boolean d;

    public HolographicImageView(Context context) {
        this(context, null);
    }

    public HolographicImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HolographicImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f82a = new dr(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.HolographicLinearLayout, i, 0);
        this.b = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(new dm(this));
        setOnFocusChangeListener(new dn(this));
    }

    private boolean b() {
        return this.b;
    }

    void a() {
        this.f82a.b(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f82a.a(this);
        Drawable drawable = getDrawable();
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            stateListDrawable.setState(getDrawableState());
            stateListDrawable.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (b()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.stateHotwordOn});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f82a.a(this);
    }

    public void setHotwordState(boolean z) {
        if (z == this.b) {
            return;
        }
        this.b = z;
        refreshDrawableState();
    }
}
