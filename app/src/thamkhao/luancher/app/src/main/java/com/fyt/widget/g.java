package com.fyt.widget;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class g extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorizontalListView f498a;

    g(HorizontalListView horizontalListView) {
        this.f498a = horizontalListView;
    }

    private boolean a(MotionEvent motionEvent, View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int width = view.getWidth() + i;
        int i2 = iArr[1];
        rect.set(i, i2, width, view.getHeight() + i2);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.f498a.a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.f498a.a(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        int childCount = this.f498a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f498a.getChildAt(i);
            if (a(motionEvent, childAt)) {
                if (this.f498a.n != null) {
                    this.f498a.n.onItemLongClick(this.f498a, childAt, this.f498a.f + 1 + i, this.f498a.b.getItemId(i + this.f498a.f + 1));
                    return;
                }
                return;
            }
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.f498a) {
            this.f498a.d += (int) f;
        }
        this.f498a.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f498a.getChildCount()) {
                return true;
            }
            View childAt = this.f498a.getChildAt(i2);
            if (a(motionEvent, childAt)) {
                if (this.f498a.m != null) {
                    this.f498a.m.onItemClick(this.f498a, childAt, this.f498a.f + 1 + i2, this.f498a.b.getItemId(this.f498a.f + 1 + i2));
                }
                if (this.f498a.l == null) {
                    return true;
                }
                this.f498a.l.onItemSelected(this.f498a, childAt, this.f498a.f + 1 + i2, this.f498a.b.getItemId(this.f498a.f + 1 + i2));
                return true;
            }
            i = i2 + 1;
        }
    }
}
