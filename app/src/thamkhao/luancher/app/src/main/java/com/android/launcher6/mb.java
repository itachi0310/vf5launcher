package com.android.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class mb extends li implements View.OnLongClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f389a;
    private boolean b;
    private boolean c;
    private float d;
    private Launcher e;

    public mb(Context context) {
        this(context, null);
    }

    public mb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public mb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = (Launcher) context;
    }

    private void d(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                M();
                this.c = true;
                break;
            case 2:
                if (this.F != 1 && !this.b && this.c) {
                    a(motionEvent);
                    break;
                }
                break;
        }
    }

    protected void M() {
        this.b = false;
        this.f389a = null;
        this.c = false;
    }

    protected void a(MotionEvent motionEvent) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.ab);
        float x = motionEvent.getX(iFindPointerIndex);
        float y = motionEvent.getY(iFindPointerIndex);
        int iAbs = (int) Math.abs(x - this.B);
        int iAbs2 = (int) Math.abs(y - this.D);
        boolean z = iAbs2 > this.I;
        if ((((float) iAbs2) / ((float) iAbs) > this.d) && z && this.f389a != null) {
            c(this.f389a);
            if (this.ak) {
                this.ak = false;
                View viewC = c(this.v);
                if (viewC != null) {
                    viewC.cancelLongPress();
                }
            }
        }
    }

    @Override // com.android.launcher6.li
    protected void b(MotionEvent motionEvent) {
        if (this.b) {
            return;
        }
        super.b(motionEvent);
    }

    protected boolean c(View view) {
        boolean z = this.b;
        this.b = true;
        return !z;
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        M();
        super.onDetachedFromWindow();
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.isInTouchMode() && this.y == -1 && this.e.J() && !this.e.I().Y() && this.e.g()) {
            return c(view);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f389a = view;
        this.c = true;
        return false;
    }

    @Override // com.android.launcher6.li, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setDragSlopeThreshold(float f) {
        this.d = f;
    }
}
