package com.android.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class HolographicLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dr f83a;
    private ImageView b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;

    public HolographicLinearLayout(Context context) {
        this(context, null);
    }

    public HolographicLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HolographicLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.HolographicLinearLayout, i, 0);
        this.c = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.d = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.f83a = new dr(context);
        setOnTouchListener(new Cdo(this));
        setOnFocusChangeListener(new dp(this));
    }

    private boolean b() {
        return this.d;
    }

    void a() {
        this.f83a.b(this.b);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.f83a.a(this.b);
            Drawable drawable = this.b.getDrawable();
            if (drawable instanceof StateListDrawable) {
                StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                stateListDrawable.setState(getDrawableState());
                stateListDrawable.invalidateSelf();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (b()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.stateHotwordOn});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            this.b = (ImageView) findViewById(this.c);
        }
        this.f83a.a(this.b);
    }

    public void setHotwordState(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        refreshDrawableState();
    }
}
