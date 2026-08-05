package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DragLayer extends FrameLayout implements ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bo f77a;
    private int[] b;
    private int c;
    private int d;
    private Launcher e;
    private final ArrayList f;
    private e g;
    private ValueAnimator h;
    private ValueAnimator i;
    private TimeInterpolator j;
    private ca k;
    private int l;
    private View m;
    private boolean n;
    private Rect o;
    private int p;
    private int q;
    private bx r;
    private final Rect s;
    private boolean t;
    private Drawable u;
    private Drawable v;

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[2];
        this.f = new ArrayList();
        this.h = null;
        this.i = null;
        this.j = new DecelerateInterpolator(1.5f);
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = false;
        this.o = new Rect();
        this.p = -1;
        this.q = -1;
        this.s = new Rect();
        setMotionEventSplittingEnabled(false);
        setChildrenDrawingOrderEnabled(true);
        setOnHierarchyChangeListener(this);
        this.u = getResources().getDrawable(R.drawable.page_hover_left_holo);
        this.v = getResources().getDrawable(R.drawable.page_hover_right_holo);
    }

    private void a(boolean z) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i = z ? R.string.folder_tap_to_rename : R.string.folder_tap_to_close;
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(8);
            onInitializeAccessibilityEvent(accessibilityEventObtain);
            accessibilityEventObtain.getText().add(getContext().getString(i));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        Rect rect = new Rect();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        for (e eVar : this.f) {
            eVar.getHitRect(rect);
            if (rect.contains(x, y) && eVar.a(x - eVar.getLeft(), y - eVar.getTop())) {
                this.g = eVar;
                this.c = x;
                this.d = y;
                requestDisallowInterceptTouchEvent(true);
                return true;
            }
        }
        Folder openFolder = this.e.I().getOpenFolder();
        if (openFolder != null && !this.e.ai() && z) {
            if (openFolder.b() && !a(openFolder, motionEvent)) {
                openFolder.f();
                return true;
            }
            a(openFolder, rect);
            if (!b(openFolder, motionEvent)) {
                this.e.C();
                return true;
            }
        }
        return false;
    }

    private boolean a(Folder folder, MotionEvent motionEvent) {
        a(folder.getEditTextRegion(), this.o);
        return this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean b(Folder folder, MotionEvent motionEvent) {
        a(folder, this.o);
        return this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = new ValueAnimator();
        this.i.setDuration(150L);
        this.i.setFloatValues(0.0f, 1.0f);
        this.i.removeAllUpdateListeners();
        this.i.addUpdateListener(new bu(this));
        this.i.addListener(new bv(this));
        this.i.start();
    }

    private void f() {
        if (this.e != null) {
            this.p = indexOfChild(this.e.I());
            this.q = indexOfChild(this.e.H());
        }
    }

    public float a(View view, Rect rect) {
        this.b[0] = 0;
        this.b[1] = 0;
        float fB = b(view, this.b);
        rect.set(this.b[0], this.b[1], (int) (this.b[0] + (view.getMeasuredWidth() * fB)), (int) (this.b[1] + (view.getMeasuredHeight() * fB)));
        return fB;
    }

    public float a(View view, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        return b(view, iArr);
    }

    public float a(View view, int[] iArr, boolean z) {
        return my.a(view, this, iArr, z);
    }

    public void a() {
        if (this.f.size() > 0) {
            for (e eVar : this.f) {
                eVar.a();
                removeView(eVar);
            }
            this.f.clear();
        }
    }

    void a(int i) {
        this.t = true;
        invalidate();
    }

    public void a(Launcher launcher, bo boVar) {
        this.e = launcher;
        this.f77a = boVar;
    }

    public void a(ca caVar, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, Runnable runnable, int i5, int i6, View view) {
        a(caVar, new Rect(i, i2, caVar.getMeasuredWidth() + i, caVar.getMeasuredHeight() + i2), new Rect(i3, i4, caVar.getMeasuredWidth() + i3, caVar.getMeasuredHeight() + i4), f, f2, f3, f4, f5, i6, (Interpolator) null, (Interpolator) null, runnable, i5, view);
    }

    public void a(ca caVar, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i, TimeInterpolator timeInterpolator, Runnable runnable, int i2, View view) {
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.k = caVar;
        this.k.c();
        this.k.d();
        if (view != null) {
            this.l = view.getScrollX();
        }
        this.m = view;
        this.h = new ValueAnimator();
        this.h.setInterpolator(timeInterpolator);
        this.h.setDuration(i);
        this.h.setFloatValues(0.0f, 1.0f);
        this.h.addUpdateListener(animatorUpdateListener);
        this.h.addListener(new bt(this, runnable, i2));
        this.h.start();
    }

    public void a(ca caVar, Rect rect, Rect rect2, float f, float f2, float f3, float f4, float f5, int i, Interpolator interpolator, Interpolator interpolator2, Runnable runnable, int i2, View view) {
        float fSqrt = (float) Math.sqrt(Math.pow(rect2.left - rect.left, 2.0d) + Math.pow(rect2.top - rect.top, 2.0d));
        Resources resources = getResources();
        float integer = resources.getInteger(R.integer.config_dropAnimMaxDist);
        if (i < 0) {
            int integer2 = resources.getInteger(R.integer.config_dropAnimMaxDuration);
            if (fSqrt < integer) {
                integer2 = (int) (integer2 * this.j.getInterpolation(fSqrt / integer));
            }
            i = Math.max(integer2, resources.getInteger(R.integer.config_dropAnimMinDuration));
        }
        a(caVar, new bs(this, caVar, interpolator2, interpolator, f2, caVar.getScaleX(), f3, f4, f5, f, caVar.getAlpha(), rect, rect2), i, (interpolator2 == null || interpolator == null) ? this.j : null, runnable, i2, view);
    }

    public void a(ca caVar, View view) {
        a(caVar, view, (Runnable) null);
    }

    public void a(ca caVar, View view, int i, Runnable runnable, View view2) {
        int iRound;
        int iRound2;
        mo moVar = (mo) view.getParent();
        al alVar = (al) view.getLayoutParams();
        moVar.a(view);
        Rect rect = new Rect();
        b(caVar, rect);
        float scaleX = view.getScaleX();
        int[] iArr = {alVar.k + ((int) ((view.getMeasuredWidth() * (1.0f - scaleX)) / 2.0f)), alVar.l + ((int) ((view.getMeasuredHeight() * (1.0f - scaleX)) / 2.0f))};
        float fB = b((View) view.getParent(), iArr) * scaleX;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (view instanceof TextView) {
            iRound = (int) ((Math.round(((TextView) view).getPaddingTop() * fB) + i3) - ((caVar.getMeasuredHeight() * (1.0f - fB)) / 2.0f));
            iRound2 = i2 - ((caVar.getMeasuredWidth() - Math.round(view.getMeasuredWidth() * fB)) / 2);
        } else if (view instanceof FolderIcon) {
            iRound = (int) (((int) ((Math.round((view.getPaddingTop() - caVar.getDragRegionTop()) * fB) + i3) - ((2.0f * fB) / 2.0f))) - (((1.0f - fB) * caVar.getMeasuredHeight()) / 2.0f));
            iRound2 = i2 - ((caVar.getMeasuredWidth() - Math.round(view.getMeasuredWidth() * fB)) / 2);
        } else {
            iRound = i3 - (Math.round((caVar.getHeight() - view.getMeasuredHeight()) * fB) / 2);
            iRound2 = i2 - (Math.round((caVar.getMeasuredWidth() - view.getMeasuredWidth()) * fB) / 2);
        }
        int i4 = rect.left;
        int i5 = rect.top;
        view.setVisibility(4);
        a(caVar, i4, i5, iRound2, iRound, 1.0f, 1.0f, 1.0f, fB, fB, new br(this, view, runnable), 0, i, view2);
    }

    public void a(ca caVar, View view, Runnable runnable) {
        a(caVar, view, -1, runnable, null);
    }

    public void a(ca caVar, int[] iArr, float f, float f2, float f3, int i, Runnable runnable, int i2) {
        Rect rect = new Rect();
        b(caVar, rect);
        a(caVar, rect.left, rect.top, iArr[0], iArr[1], f, 1.0f, 1.0f, f2, f3, runnable, i, i2, (View) null);
    }

    public void a(ec ecVar, is isVar, CellLayout cellLayout) {
        e eVar = new e(getContext(), isVar, cellLayout, this);
        bw bwVar = new bw(-1, -1);
        bwVar.c = true;
        addView(eVar, bwVar);
        this.f.add(eVar);
        eVar.a(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList arrayList) {
        Folder openFolder = this.e.I().getOpenFolder();
        if (openFolder != null) {
            arrayList.add(openFolder);
        } else {
            super.addChildrenForAccessibility(arrayList);
        }
    }

    public float b(View view, int[] iArr) {
        return a(view, iArr, false);
    }

    public void b() {
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.k != null) {
            this.f77a.a(this.k);
        }
        this.k = null;
        invalidate();
    }

    public void b(View view, Rect rect) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0] - i;
        int i4 = iArr[1] - i2;
        rect.set(i3, i4, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i4);
    }

    public float c(View view, int[] iArr) {
        return my.a(view, this, iArr);
    }

    void c() {
        this.t = false;
        invalidate();
    }

    public boolean d() {
        return getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.t || ip.a().j()) {
            return;
        }
        Workspace workspaceI = this.e.I();
        int measuredWidth = getMeasuredWidth();
        Rect rect = new Rect();
        a(workspaceI.getChildAt(0), rect);
        int nextPage = workspaceI.getNextPage();
        boolean zD = d();
        CellLayout cellLayout = (CellLayout) workspaceI.getChildAt(zD ? nextPage + 1 : nextPage - 1);
        CellLayout cellLayout2 = (CellLayout) workspaceI.getChildAt(zD ? nextPage - 1 : nextPage + 1);
        if (cellLayout != null && cellLayout.getIsDragOverlapping()) {
            this.u.setBounds(0, rect.top, this.u.getIntrinsicWidth(), rect.bottom);
            this.u.draw(canvas);
        } else {
            if (cellLayout2 == null || !cellLayout2.getIsDragOverlapping()) {
                return;
            }
            this.v.setBounds(measuredWidth - this.v.getIntrinsicWidth(), rect.top, measuredWidth, rect.bottom);
            this.v.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f77a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        return this.f77a.a(view, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt instanceof dy) {
                ((dy) childAt).setInsets(rect);
            } else {
                layoutParams.topMargin += rect.top - this.s.top;
                layoutParams.leftMargin += rect.left - this.s.left;
                layoutParams.rightMargin += rect.right - this.s.right;
                layoutParams.bottomMargin += rect.bottom - this.s.bottom;
            }
            childAt.setLayoutParams(layoutParams);
        }
        this.s.set(rect);
        return true;
    }

    public View getAnimatedView() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        return i2;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        f();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        f();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        boolean zB;
        if (this.e == null || this.e.I() == null) {
            return false;
        }
        Folder openFolder = this.e.I().getOpenFolder();
        if (openFolder == null) {
            return false;
        }
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            switch (motionEvent.getAction()) {
                case 7:
                    zB = b(openFolder, motionEvent);
                    if (zB && !this.n) {
                        a(openFolder.b());
                        this.n = true;
                        return true;
                    }
                    if (zB) {
                        return true;
                    }
                    this.n = false;
                    break;
                    break;
                case 9:
                    boolean zB2 = b(openFolder, motionEvent);
                    if (!zB2) {
                        a(openFolder.b());
                        this.n = true;
                        return true;
                    }
                    if (!zB2) {
                        return true;
                    }
                    this.n = false;
                    zB = b(openFolder, motionEvent);
                    if (zB) {
                    }
                    if (zB) {
                        return true;
                    }
                    this.n = false;
                    break;
                    break;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (a(motionEvent, true)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            if (this.r != null) {
                this.r.a();
            }
            this.r = null;
        }
        a();
        return this.f77a.a(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (layoutParams instanceof bw) {
                bw bwVar = (bw) layoutParams;
                if (bwVar.c) {
                    childAt.layout(bwVar.f145a, bwVar.b, bwVar.f145a + bwVar.width, bwVar.height + bwVar.b);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Folder openFolder = this.e.I().getOpenFolder();
        if (openFolder == null || view == openFolder) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0) {
            if (a(motionEvent, false)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            if (this.r != null) {
                this.r.a();
            }
            this.r = null;
        }
        if (this.g != null) {
            switch (action) {
                case 1:
                case 3:
                    this.g.c(x - this.c, y - this.d);
                    this.g.b();
                    this.g = null;
                    z = true;
                    break;
                case 2:
                    com.syu.d.a.b("MotionEvent.ACTION_MOVE");
                    this.g.c(x - this.c, y - this.d);
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        }
        if (z) {
            return true;
        }
        return this.f77a.b(motionEvent);
    }

    public void setTouchCompleteListener(bx bxVar) {
        this.r = bxVar;
    }
}
