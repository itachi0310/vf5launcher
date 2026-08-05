package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public abstract class li extends ViewGroup implements ViewGroup.OnHierarchyChangeListener {
    protected Scroller A;
    protected float B;
    protected float C;
    protected float D;
    protected float E;
    protected int F;
    protected boolean G;
    protected View.OnLongClickListener H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected int O;
    protected int P;
    protected int Q;
    protected int R;
    protected boolean S;
    protected boolean T;
    protected int U;
    protected int[] V;
    protected boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f373a;
    private float aA;
    private boolean aB;
    private Runnable aC;
    private int aD;
    private boolean aE;
    private boolean aF;
    private int aG;
    private int aH;
    private Runnable aI;
    private Matrix aJ;
    private float[] aK;
    private int[] aL;
    private Rect aM;
    private Rect aN;
    private int aO;
    private float aP;
    private float aQ;
    private boolean aR;
    private int aS;
    private int aT;
    private View aU;
    private boolean aV;
    private boolean aW;
    private boolean aX;
    protected int aa;
    protected int ab;
    protected ArrayList ac;
    protected boolean ad;
    protected boolean ae;
    protected boolean af;
    protected boolean ag;
    protected boolean ah;
    protected boolean ai;
    protected boolean aj;
    protected boolean ak;
    protected int al;
    protected int am;
    protected View an;
    protected int ao;
    protected final Rect ap;
    protected int aq;
    private int ar;
    private int as;
    private lr at;
    private int au;
    private PageIndicator av;
    private boolean aw;
    private Rect ax;
    private int ay;
    private int az;
    private int b;
    private int c;
    private int d;
    private VelocityTracker e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private int l;
    private boolean m;
    private int[] n;
    protected int o;
    protected int p;
    protected int q;
    protected float r;
    protected float s;
    protected float t;
    protected boolean u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected int z;

    public li(Context context) {
        this(context, null);
    }

    public li(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public li(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f373a = false;
        this.b = -1;
        this.c = -1;
        this.u = true;
        this.w = -1001;
        this.y = -1;
        this.l = -1;
        this.F = 0;
        this.G = false;
        this.Q = 0;
        this.R = 0;
        this.T = true;
        this.V = new int[2];
        this.ab = -1;
        this.ad = true;
        this.ae = false;
        this.af = true;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = true;
        this.aw = true;
        this.ax = new Rect();
        this.ay = HttpStatus.SC_OK;
        this.al = HttpStatus.SC_MULTIPLE_CHOICES;
        this.am = 250;
        this.az = 80;
        this.aA = 1.0f;
        this.aB = false;
        this.aD = -1;
        this.aE = false;
        this.aG = 2;
        this.aJ = new Matrix();
        this.aK = new float[2];
        this.aL = new int[2];
        this.aM = new Rect();
        this.aN = new Rect();
        this.aO = 350;
        this.aP = 0.035f;
        this.aQ = 65.0f;
        this.ao = -1400;
        this.aR = false;
        this.aS = 250;
        this.aT = 350;
        this.aV = false;
        this.aW = false;
        this.aX = false;
        this.ap = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.PagedView, i, 0);
        setPageSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        if (this.J < 0) {
            this.aW = true;
            this.aV = true;
        }
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.au = typedArrayObtainStyledAttributes.getResourceId(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setHapticFeedbackEnabled(false);
        a();
    }

    private Runnable a(View view) {
        return new ln(this, view);
    }

    private void a(int i) {
        if (this.av == null || a(false)) {
            return;
        }
        this.av.b(i, this.aw);
    }

    private void a(MotionEvent motionEvent) {
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        this.e.addMovement(motionEvent);
    }

    private void a(boolean z, int i) {
        this.f373a = z;
        if (i == -1) {
            i = getPageNearestToCenterOfScreen();
        }
        if (this.f373a) {
            D();
            a(this.V);
            if (getCurrentPage() < this.V[0]) {
                setCurrentPage(this.V[0]);
            } else if (getCurrentPage() > this.V[1]) {
                setCurrentPage(this.V[1]);
            }
        } else {
            n(i);
        }
        setEnableOverscroll(z ? false : true);
    }

    private boolean a(int i, int i2) {
        this.aM.set(this.ax.left - (this.ax.width() / 2), this.ax.top, this.ax.right + (this.ax.width() / 2), this.ax.bottom);
        return this.aM.contains(i, i2);
    }

    private void b() {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(4096);
            accessibilityEventObtain.setItemCount(getChildCount());
            accessibilityEventObtain.setFromIndex(this.v);
            accessibilityEventObtain.setAction(getNextPage() >= this.v ? 4096 : 8192);
            sendAccessibilityEventUnchecked(accessibilityEventObtain);
        }
    }

    private void c() {
        d();
        L();
        this.m = false;
        this.F = 0;
        this.ab = -1;
    }

    private void d() {
        if (this.e != null) {
            this.e.clear();
            this.e.recycle();
            this.e = null;
        }
    }

    private void d(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.ab) {
            int i = action == 0 ? 1 : 0;
            float x = motionEvent.getX(i);
            this.h = x;
            this.B = x;
            this.D = motionEvent.getY(i);
            this.C = 0.0f;
            this.ab = motionEvent.getPointerId(i);
            if (this.e != null) {
                this.e.clear();
            }
        }
    }

    private boolean d(int i, int i2) {
        if (this.aU == null) {
            return false;
        }
        this.aN.set(0, 0, 0, 0);
        View view = (View) this.aU.getParent();
        if (view != null) {
            view.getGlobalVisibleRect(this.aN);
        }
        this.aU.getGlobalVisibleRect(this.aM);
        this.aM.offset(-this.aN.left, -this.aN.top);
        return this.aM.contains(i, i2);
    }

    private float e(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.aH--;
        if (this.aI == null || this.aH != 0) {
            return;
        }
        this.aI.run();
        this.aI = null;
    }

    private void j() {
        View view = this.an;
        ArrayList arrayList = new ArrayList();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new DecelerateInterpolator(2.0f));
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 0.0f), ObjectAnimator.ofFloat(view, "scaleY", 0.0f));
        arrayList.add(animatorSet);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setInterpolator(new LinearInterpolator());
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f));
        arrayList.add(animatorSet2);
        Runnable runnableA = a(view);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        animatorSet3.setDuration(this.aT);
        animatorSet3.addListener(new lp(this, runnableA));
        animatorSet3.start();
        this.aR = true;
    }

    private void setEnableOverscroll(boolean z) {
        this.T = z;
    }

    protected void A() {
        this.aw = false;
    }

    protected void B() {
        View viewC;
        if (!this.ak || (viewC = c(this.v)) == null) {
            return;
        }
        viewC.cancelLongPress();
    }

    protected void C() {
        a(true, -1);
    }

    void D() {
        a(this.V);
        if (m()) {
            this.b = j(this.V[1]);
            this.c = j(this.V[0]);
        } else {
            this.b = j(this.V[0]);
            this.c = j(this.V[1]);
        }
    }

    public void E() {
    }

    protected void F() {
        c(getPageNearestToCenterOfScreen(), 750);
    }

    public boolean G() {
        return this.ak;
    }

    protected void H() {
        e(-1, false);
    }

    void I() {
        if (this.an != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(this.ay);
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.an, "translationX", 0.0f), ObjectAnimator.ofFloat(this.an, "translationY", 0.0f), ObjectAnimator.ofFloat(this.an, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.an, "scaleY", 1.0f));
            animatorSet.addListener(new lk(this));
            animatorSet.start();
        }
    }

    protected void J() {
        this.F = 4;
        this.aF = true;
        invalidate();
    }

    protected void K() {
        this.aF = false;
    }

    void L() {
        if (this.aE) {
            this.aE = false;
            ll llVar = new ll(this);
            if (this.aR) {
                return;
            }
            this.aI = new lm(this, llVar);
            this.aH = this.aG;
            c(indexOfChild(this.an), 0);
            I();
        }
    }

    protected float a(int i, View view, int i2) {
        return Math.max(Math.min((i - ((getViewportWidth() / 2) + j(i2))) / ((view.getMeasuredWidth() + this.J) * 1.0f), getMaxScrollProgress()), -getMaxScrollProgress());
    }

    protected void a() {
        this.ac = new ArrayList();
        this.ac.ensureCapacity(32);
        this.A = new Scroller(getContext(), new ls());
        this.v = 0;
        this.S = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.I = viewConfiguration.getScaledPagingTouchSlop();
        this.ar = viewConfiguration.getScaledPagingTouchSlop();
        this.as = viewConfiguration.getScaledMaximumFlingVelocity();
        this.r = getResources().getDisplayMetrics().density;
        this.ao = (int) (this.ao * this.r);
        this.o = (int) (500.0f * this.r);
        this.p = (int) (250.0f * this.r);
        this.q = (int) (1500.0f * this.r);
        setOnHierarchyChangeListener(this);
    }

    protected void a(float f) {
        c(f);
    }

    protected void a(int i, int i2, int i3, boolean z) {
        int iAbs;
        this.y = i;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && i != this.v && focusedChild == c(this.v)) {
            focusedChild.clearFocus();
        }
        b();
        t();
        awakenScrollBars(i3);
        if (z) {
            iAbs = 0;
        } else {
            iAbs = i3 == 0 ? Math.abs(i2) : i3;
        }
        if (!this.A.isFinished()) {
            this.A.abortAnimation();
        }
        this.A.startScroll(this.U, 0, i2, 0, iAbs);
        s();
        if (z) {
            computeScroll();
        }
        this.ah = true;
        this.G = true;
        invalidate();
    }

    protected void a(int i, int i2, boolean z) {
        int iMax = Math.max(0, Math.min(i, getPageCount() - 1));
        a(iMax, j(iMax) - this.U, i2, z);
    }

    protected void a(MotionEvent motionEvent, float f) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.ab);
        if (iFindPointerIndex == -1) {
            return;
        }
        float x = motionEvent.getX(iFindPointerIndex);
        float y = motionEvent.getY(iFindPointerIndex);
        if (a((int) x, (int) y)) {
            int iAbs = (int) Math.abs(x - this.B);
            int iAbs2 = (int) Math.abs(y - this.D);
            int iRound = Math.round(this.I * f);
            boolean z = iAbs > this.ar;
            boolean z2 = iAbs > iRound;
            boolean z3 = iAbs2 > iRound;
            if (z2 || z || z3) {
                if (this.af) {
                    if (!z) {
                        return;
                    }
                } else if (!z2) {
                    return;
                }
                this.F = 1;
                this.E += Math.abs(this.B - x);
                this.B = x;
                this.C = 0.0f;
                this.t = getViewportOffsetX() + getScrollX();
                this.s = System.nanoTime() / 1.0E9f;
                t();
            }
        }
    }

    public void a(View view, int i) {
    }

    public void a(View view, boolean z) {
    }

    protected void a(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = Math.max(0, getChildCount() - 1);
    }

    boolean a(boolean z) {
        boolean z2 = this.aF;
        if (z) {
            return (this.F == 4) & z2;
        }
        return z2;
    }

    float[] a(View view, float f, float f2) {
        this.aK[0] = f;
        this.aK[1] = f2;
        view.getMatrix().mapPoints(this.aK);
        float[] fArr = this.aK;
        fArr[0] = fArr[0] + view.getLeft();
        float[] fArr2 = this.aK;
        fArr2[1] = fArr2[1] + view.getTop();
        return this.aK;
    }

    protected void a_(int i, int i2, int i3) {
        a(i, i2, i3, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (this.v >= 0 && this.v < getPageCount()) {
            c(this.v).addFocusables(arrayList, i, i2);
        }
        if (i == 17) {
            if (this.v > 0) {
                c(this.v - 1).addFocusables(arrayList, i, i2);
            }
        } else {
            if (i != 66 || this.v >= getPageCount() - 1) {
                return;
            }
            c(this.v + 1).addFocusables(arrayList, i, i2);
        }
    }

    protected void b(float f) {
        int viewportWidth = getViewportWidth();
        float fAbs = 2.0f * (f / viewportWidth);
        if (fAbs == 0.0f) {
            return;
        }
        if (Math.abs(fAbs) >= 1.0f) {
            fAbs /= Math.abs(fAbs);
        }
        int iRound = Math.round(fAbs * viewportWidth);
        if (f < 0.0f) {
            this.aa = iRound;
            super.scrollTo(0, getScrollY());
        } else {
            this.aa = iRound + this.z;
            super.scrollTo(this.z, getScrollY());
        }
        invalidate();
    }

    protected void b(int i, int i2) {
        int iMax = Math.max(0, Math.min(i, getChildCount() - 1));
        int viewportWidth = getViewportWidth() / 2;
        int iJ = j(iMax) - this.U;
        if (Math.abs(i2) < this.p) {
            c(iMax, 750);
            return;
        }
        a_(iMax, iJ, Math.round(Math.abs(((viewportWidth * d(Math.min(1.0f, (Math.abs(iJ) * 1.0f) / (viewportWidth * 2)))) + viewportWidth) / Math.max(this.q, Math.abs(i2))) * 1000.0f) * 4);
    }

    protected void b(MotionEvent motionEvent) {
        a(motionEvent, 1.0f);
    }

    protected void b(int[] iArr) {
        int childCount = getChildCount();
        int[] iArr2 = this.aL;
        this.aL[1] = 0;
        iArr2[0] = 0;
        iArr[0] = -1;
        iArr[1] = -1;
        if (childCount <= 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int viewportWidth = getViewportWidth();
        int childCount2 = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount2; i2++) {
            View viewC = c(i2);
            this.aL[0] = 0;
            my.a(viewC, this, this.aL, false);
            if (this.aL[0] <= viewportWidth) {
                this.aL[0] = viewC.getMeasuredWidth();
                my.a(viewC, this, this.aL, false);
                if (this.aL[0] < 0) {
                    if (iArr[0] != -1) {
                        break;
                    }
                } else {
                    if (iArr[0] < 0) {
                        iArr[0] = i2;
                    }
                    i = i2;
                }
            } else {
                if (iArr[0] != -1) {
                    break;
                }
            }
        }
        iArr[1] = i;
    }

    float[] b(View view, float f, float f2) {
        this.aK[0] = f - view.getLeft();
        this.aK[1] = f2 - view.getTop();
        view.getMatrix().invert(this.aJ);
        this.aJ.mapPoints(this.aK);
        return this.aK;
    }

    View c(int i) {
        return getChildAt(i);
    }

    protected void c(float f) {
        int viewportWidth = getViewportWidth();
        float f2 = f / viewportWidth;
        if (f2 == 0.0f) {
            return;
        }
        float fE = e(Math.abs(f2)) * (f2 / Math.abs(f2));
        if (Math.abs(fE) >= 1.0f) {
            fE /= Math.abs(fE);
        }
        int iRound = Math.round(fE * 0.14f * viewportWidth);
        if (f < 0.0f) {
            this.aa = iRound;
            super.scrollTo(0, getScrollY());
        } else {
            this.aa = iRound + this.z;
            super.scrollTo(this.z, getScrollY());
        }
        invalidate();
    }

    protected void c(int i, int i2) {
        a(i, i2, false);
    }

    public abstract void c(int i, boolean z);

    protected void c(MotionEvent motionEvent) {
        ((Launcher) getContext()).onClick(this);
    }

    public void c_() {
        if (getNextPage() > 0) {
            n(getNextPage() - 1);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        x();
    }

    float d(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    protected int d(int i) {
        return i;
    }

    protected void d(int i, boolean z) {
        int childCount;
        if (!this.ad || i >= (childCount = getChildCount())) {
            return;
        }
        int iF = f(i);
        int iG = g(i);
        for (int i2 = 0; i2 < childCount; i2++) {
            lg lgVar = (lg) c(i2);
            if (i2 < iF || i2 > iG) {
                if (lgVar.getPageChildCount() > 0) {
                    lgVar.a();
                }
                this.ac.set(i2, true);
            }
        }
        int i3 = 0;
        while (i3 < childCount) {
            if ((i3 == i || !z) && iF <= i3 && i3 <= iG && ((Boolean) this.ac.get(i3)).booleanValue()) {
                c(i3, i3 == i && z);
                this.ac.set(i3, false);
            }
            i3++;
        }
    }

    public void d(View view) {
        lq lqVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        lqVarGenerateDefaultLayoutParams.f381a = true;
        super.addView(view, 0, lqVarGenerateDefaultLayoutParams);
    }

    public void d_() {
        if (getNextPage() < getChildCount() - 1) {
            n(getNextPage() + 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int viewportWidth = (getViewportWidth() / 2) + this.aa;
        if (viewportWidth != this.l || this.G) {
            this.G = false;
            e(viewportWidth);
            this.l = viewportWidth;
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            b(this.V);
            int i = this.V[0];
            int i2 = this.V[1];
            if (i == -1 || i2 == -1) {
                return;
            }
            long drawingTime = getDrawingTime();
            canvas.save();
            canvas.clipRect(getScrollX(), getScrollY(), (getScrollX() + getRight()) - getLeft(), (getScrollY() + getBottom()) - getTop());
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View viewC = c(i3);
                if (viewC != this.an && (this.W || (i <= i3 && i3 <= i2 && e(viewC)))) {
                    drawChild(canvas, viewC, drawingTime);
                }
            }
            if (this.an != null) {
                drawChild(canvas, this.an, drawingTime);
            }
            this.W = false;
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (i == 17) {
            if (getCurrentPage() > 0) {
                n(getCurrentPage() - 1);
                return true;
            }
        } else if (i == 66 && getCurrentPage() < getPageCount() - 1) {
            n(getCurrentPage() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    protected void e(int i) {
        boolean z = this.aa < 0 || this.aa > this.z;
        if (!this.ae || z) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setAlpha(1.0f - Math.abs(a(i, childAt, i2)));
            }
        }
        invalidate();
    }

    protected void e(int i, boolean z) {
        if (this.aj) {
            if (this.ad) {
                this.A.forceFinished(true);
                this.y = -1;
                f();
                measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                if (i > -1) {
                    setCurrentPage(Math.min(getPageCount() - 1, i));
                }
                int childCount = getChildCount();
                this.ac.clear();
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.ac.add(true);
                }
                d(this.v, z);
                requestLayout();
            }
            if (v()) {
                F();
            }
        }
    }

    protected boolean e(View view) {
        return view.getAlpha() > 0.0f && view.getVisibility() == 0;
    }

    protected int f(int i) {
        return Math.max(0, i - 1);
    }

    public int f(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (parent == c(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public abstract void f();

    protected void f(int i, boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        View viewC = c(this.v);
        for (View view2 = view; view2 != viewC; view2 = (View) view2.getParent()) {
            if (view2 == this || !(view2.getParent() instanceof View)) {
                return;
            }
        }
        super.focusableViewAvailable(view);
    }

    protected int g(int i) {
        return Math.min(i + 1, getChildCount() - 1);
    }

    protected void g() {
    }

    public boolean g(View view) {
        int iIndexOfChild = indexOfChild(view);
        if (this.F != 0) {
            return false;
        }
        this.V[0] = 0;
        this.V[1] = getPageCount() - 1;
        a(this.V);
        this.aE = true;
        if (this.V[0] > iIndexOfChild || iIndexOfChild > this.V[1]) {
            return false;
        }
        this.an = getChildAt(iIndexOfChild);
        this.an.animate().scaleX(1.15f).scaleY(1.15f).setDuration(100L).start();
        this.k = this.an.getLeft();
        l(-1);
        J();
        return true;
    }

    int getCurrentPage() {
        return this.v;
    }

    protected String getCurrentPageDescription() {
        return String.format(getContext().getString(R.string.default_scroll_format), Integer.valueOf(getNextPage() + 1), Integer.valueOf(getChildCount()));
    }

    protected int getFirstChildLeft() {
        return this.aq;
    }

    protected float getMaxScrollProgress() {
        return 1.0f;
    }

    int getNearestHoverOverPageIndex() {
        if (this.an == null) {
            return -1;
        }
        int left = (int) (this.an.getLeft() + (this.an.getMeasuredWidth() / 2) + this.an.getTranslationX());
        a(this.V);
        int i = Integer.MAX_VALUE;
        int iIndexOfChild = indexOfChild(this.an);
        for (int i2 = this.V[0]; i2 <= this.V[1]; i2++) {
            View viewC = c(i2);
            int iAbs = Math.abs(left - ((viewC.getMeasuredWidth() / 2) + viewC.getLeft()));
            if (iAbs < i) {
                iIndexOfChild = i2;
                i = iAbs;
            }
        }
        return iIndexOfChild;
    }

    int getNextPage() {
        return this.y != -1 ? this.y : this.v;
    }

    public int getNormalChildHeight() {
        return this.d;
    }

    int getPageCount() {
        return getChildCount();
    }

    PageIndicator getPageIndicator() {
        return this.av;
    }

    protected View.OnClickListener getPageIndicatorClickListener() {
        return null;
    }

    protected String getPageIndicatorDescription() {
        return getCurrentPageDescription();
    }

    int getPageNearestToCenterOfScreen() {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int viewportOffsetX = getViewportOffsetX() + getScrollX() + (getViewportWidth() / 2);
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            int iAbs = Math.abs(((c(i3).getMeasuredWidth() / 2) + (getViewportOffsetX() + i(i3))) - viewportOffsetX);
            if (iAbs < i) {
                i2 = i3;
            } else {
                iAbs = i;
            }
            i3++;
            i = iAbs;
        }
        return i2;
    }

    int getViewportHeight() {
        return this.ax.height();
    }

    int getViewportOffsetX() {
        return (getMeasuredWidth() - getViewportWidth()) / 2;
    }

    int getViewportOffsetY() {
        return (getMeasuredHeight() - getViewportHeight()) / 2;
    }

    int getViewportWidth() {
        return this.ax.width();
    }

    protected lh h(int i) {
        return new lh();
    }

    protected int i(int i) {
        if (i < 0 || i > getChildCount() - 1) {
            return 0;
        }
        return c(i).getLeft() - getViewportOffsetX();
    }

    public int j(int i) {
        if (this.n == null || i >= this.n.length || i < 0) {
            return 0;
        }
        return this.n[i];
    }

    public int k(int i) {
        if (this.n == null || i >= this.n.length || i < 0) {
            return 0;
        }
        View childAt = getChildAt(i);
        return (int) (childAt.getX() - ((((getViewportWidth() - childAt.getMeasuredWidth()) / 2) + this.n[i]) + getViewportOffsetX()));
    }

    void l() {
        if (this.an != null) {
            float scrollX = (this.B - this.h) + (getScrollX() - this.j) + (this.k - this.an.getLeft());
            float f = this.D - this.i;
            this.an.setTranslationX(scrollX);
            this.an.setTranslationY(f);
        }
    }

    protected void l(int i) {
        a(false, i);
    }

    protected int m(int i) {
        return c(i).getMeasuredWidth();
    }

    public boolean m() {
        return getLayoutDirection() == 1;
    }

    protected void n() {
        this.aj = true;
    }

    protected void n(int i) {
        c(i, 750);
    }

    protected void o(int i) {
        a(i, 750, true);
    }

    protected boolean o() {
        return this.aj;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (this.av != null || this.au <= -1) {
            return;
        }
        this.av = (PageIndicator) viewGroup.findViewById(this.au);
        this.av.a(this.aw);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            arrayList.add(h(i));
        }
        this.av.a(arrayList, this.aw);
        View.OnClickListener pageIndicatorClickListener = getPageIndicatorClickListener();
        if (pageIndicatorClickListener != null) {
            this.av.setOnClickListener(pageIndicatorClickListener);
        }
        this.av.setContentDescription(getPageIndicatorDescription());
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.av != null && !a(false)) {
            int iIndexOfChild = indexOfChild(view2);
            this.av.a(iIndexOfChild, h(iIndexOfChild), this.aw);
        }
        this.G = true;
        this.aW = true;
        D();
        invalidate();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        this.G = true;
        D();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.av = null;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        boolean z = false;
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if ((motionEvent.getMetaState() & 1) != 0) {
                        axisValue = motionEvent.getAxisValue(9);
                        f = 0.0f;
                    } else {
                        f = -motionEvent.getAxisValue(9);
                        axisValue = motionEvent.getAxisValue(10);
                    }
                    if (axisValue != 0.0f || f != 0.0f) {
                        if (m()) {
                            if (axisValue < 0.0f || f < 0.0f) {
                                z = true;
                            }
                        } else if (axisValue > 0.0f || f > 0.0f) {
                            z = true;
                        }
                        if (z) {
                            d_();
                            return true;
                        }
                        c_();
                        return true;
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(true);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setScrollable(getPageCount() > 1);
        if (getCurrentPage() < getPageCount() - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        if (getCurrentPage() > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        if (getChildCount() <= 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.F == 1) {
            return true;
        }
        switch (action & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.h = x;
                this.i = y;
                this.j = getScrollX();
                this.B = x;
                this.D = y;
                float[] fArrA = a(this, x, y);
                this.f = fArrA[0];
                this.g = fArrA[1];
                this.C = 0.0f;
                this.E = 0.0f;
                this.ab = motionEvent.getPointerId(0);
                if (this.A.isFinished() || Math.abs(this.A.getFinalX() - this.A.getCurrX()) < this.I) {
                    this.F = 0;
                    this.A.abortAnimation();
                } else if (!a((int) this.h, (int) this.i)) {
                    this.F = 0;
                } else {
                    this.F = 1;
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                if (this.ab != -1) {
                    b(motionEvent);
                }
                break;
            case 6:
                d(motionEvent);
                d();
                break;
        }
        return this.F != 0;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0150  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int viewportWidth;
        int paddingTop;
        if (!this.aj || getChildCount() == 0) {
            return;
        }
        int childCount = getChildCount();
        int viewportWidth2 = getViewportWidth();
        int viewportOffsetX = getViewportOffsetX();
        int viewportOffsetY = getViewportOffsetY();
        this.ax.offset(viewportOffsetX, viewportOffsetY);
        boolean zM = m();
        int i5 = zM ? childCount - 1 : 0;
        int i6 = zM ? -1 : childCount;
        int i7 = zM ? -1 : 1;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iM = ((viewportWidth2 - m(i5)) / 2) + viewportOffsetX;
        this.aq = iM;
        if (this.n == null || getChildCount() != this.x) {
            this.n = new int[getChildCount()];
        }
        int i8 = i5;
        int i9 = iM;
        while (i8 != i6) {
            View viewC = c(i8);
            if (viewC.getVisibility() == 8) {
                viewportWidth = i9;
            } else {
                if (((lq) viewC.getLayoutParams()).f381a) {
                    paddingTop = viewportOffsetY;
                } else {
                    paddingTop = getPaddingTop() + viewportOffsetY + this.ap.top;
                    if (this.S) {
                        paddingTop += ((((getViewportHeight() - this.ap.top) - this.ap.bottom) - paddingBottom) - viewC.getMeasuredHeight()) / 2;
                    }
                }
                int measuredWidth = viewC.getMeasuredWidth();
                viewC.layout(i9, paddingTop, viewC.getMeasuredWidth() + i9, viewC.getMeasuredHeight() + paddingTop);
                int viewportWidth3 = (getViewportWidth() - measuredWidth) / 2;
                this.n[i8] = (i9 - viewportWidth3) - viewportOffsetX;
                if (i8 != i6 - i7) {
                    viewportWidth = viewportWidth3 + measuredWidth + i9 + ((getViewportWidth() - m(i8 + i7)) / 2);
                } else {
                    viewportWidth = i9;
                }
            }
            i8 += i7;
            i9 = viewportWidth;
        }
        if (this.u && this.v >= 0 && this.v < getChildCount()) {
            setHorizontalScrollBarEnabled(false);
            p();
            setHorizontalScrollBarEnabled(true);
            this.u = false;
        }
        if (childCount > 0) {
            this.z = j(m() ? 0 : childCount - 1);
        } else {
            this.z = 0;
        }
        if (this.A.isFinished() && this.x != getChildCount() && !this.aR) {
            if (this.w != -1001) {
                setCurrentPage(this.w);
                this.w = -1001;
            } else {
                setCurrentPage(getNextPage());
            }
        }
        this.x = getChildCount();
        if (a(true)) {
            l();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingLeft;
        int paddingTop;
        if (!this.aj || getChildCount() == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels + this.ap.top + this.ap.bottom);
        if (this.aB) {
            i4 = (int) (((int) (1.5f * iMax)) / this.aA);
            i3 = (int) (iMax / this.aA);
        } else {
            i3 = size2;
            i4 = size;
        }
        this.ax.set(0, 0, size, size2);
        if (mode == 0 || mode2 == 0) {
            super.onMeasure(i, i2);
            return;
        }
        if (size <= 0 || size2 <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int paddingTop2 = getPaddingTop() + getPaddingBottom();
        int paddingLeft2 = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View viewC = c(i7);
            if (viewC.getVisibility() != 8) {
                lq lqVar = (lq) viewC.getLayoutParams();
                if (lqVar.f381a) {
                    i5 = 1073741824;
                    i6 = 1073741824;
                    if (this.aB) {
                        paddingLeft = getViewportWidth();
                        paddingTop = getViewportHeight();
                    } else {
                        paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                        paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                    }
                } else {
                    int i8 = lqVar.width == -2 ? ExploreByTouchHelper.INVALID_ID : 1073741824;
                    int i9 = lqVar.height == -2 ? ExploreByTouchHelper.INVALID_ID : 1073741824;
                    int i10 = ((size2 - paddingTop2) - this.ap.top) - this.ap.bottom;
                    this.d = i10;
                    i6 = i9;
                    paddingTop = i10;
                    i5 = i8;
                    paddingLeft = size - paddingLeft2;
                }
                viewC.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(paddingTop, i6));
            }
        }
        setMeasuredDimension(i4, i3);
        if (childCount > 0 && this.aV && this.aW) {
            int viewportWidth = (getViewportWidth() - m(0)) / 2;
            setPageSpacing(Math.max(viewportWidth, (size - viewportWidth) - getChildAt(0).getMeasuredWidth()));
            this.aW = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View viewC = c(this.y != -1 ? this.y : this.v);
        if (viewC != null) {
            return viewC.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        super.onTouchEvent(motionEvent);
        if (getChildCount() <= 0) {
            return super.onTouchEvent(motionEvent);
        }
        a(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (!this.A.isFinished()) {
                    this.A.abortAnimation();
                }
                float x = motionEvent.getX();
                this.B = x;
                this.h = x;
                float y = motionEvent.getY();
                this.D = y;
                this.i = y;
                this.j = getScrollX();
                float[] fArrA = a(this, this.B, this.D);
                this.f = fArrA[0];
                this.g = fArrA[1];
                this.C = 0.0f;
                this.E = 0.0f;
                this.ab = motionEvent.getPointerId(0);
                if (this.F != 1) {
                    return true;
                }
                t();
                return true;
            case 1:
                if (this.F == 1) {
                    int i = this.ab;
                    float x2 = motionEvent.getX(motionEvent.findPointerIndex(i));
                    VelocityTracker velocityTracker = this.e;
                    velocityTracker.computeCurrentVelocity(1000, this.as);
                    int xVelocity = (int) velocityTracker.getXVelocity(i);
                    int i2 = (int) (x2 - this.h);
                    int measuredWidth = c(this.v).getMeasuredWidth();
                    boolean z3 = ((float) Math.abs(i2)) > ((float) measuredWidth) * 0.4f;
                    this.E = Math.abs((this.B + this.C) - x2) + this.E;
                    boolean z4 = this.E > 25.0f && Math.abs(xVelocity) > this.o;
                    if (!this.f373a) {
                        boolean z5 = ((float) Math.abs(i2)) > ((float) measuredWidth) * 0.33f && Math.signum((float) xVelocity) != Math.signum((float) i2) && z4;
                        boolean zM = m();
                        if (zM) {
                            z = i2 > 0;
                        } else {
                            z = i2 < 0;
                        }
                        if (zM) {
                            if (xVelocity > 0) {
                                z2 = true;
                            }
                        } else if (xVelocity < 0) {
                            z2 = true;
                        }
                        if (((z3 && !z && !z4) || (z4 && !z2)) && this.v > 0) {
                            b(z5 ? this.v : this.v - 1, xVelocity);
                        } else if (!((z3 && z && !z4) || (z4 && z2)) || this.v >= getChildCount() - 1) {
                            F();
                        } else {
                            b(z5 ? this.v : this.v + 1, xVelocity);
                        }
                    } else if (this.F == 2) {
                        int iMax = Math.max(0, this.v - 1);
                        if (iMax != this.v) {
                            n(iMax);
                        } else {
                            F();
                        }
                    } else {
                        if (!this.A.isFinished()) {
                            this.A.abortAnimation();
                        }
                        float scaleX = getScaleX();
                        this.A.fling((int) (scaleX * getScrollX()), getScrollY(), (int) ((-xVelocity) * scaleX), 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0);
                        invalidate();
                    }
                } else if (this.F == 3) {
                    int iMin = Math.min(getChildCount() - 1, this.v + 1);
                    if (iMin != this.v) {
                        n(iMin);
                    } else {
                        F();
                    }
                } else if (this.F == 4) {
                    this.B = motionEvent.getX();
                    this.D = motionEvent.getY();
                    float[] fArrA2 = a(this, this.B, this.D);
                    this.f = fArrA2[0];
                    this.g = fArrA2[1];
                    l();
                    if (d((int) this.f, (int) this.g)) {
                        j();
                    }
                } else if (!this.m) {
                    c(motionEvent);
                }
                removeCallbacks(this.aC);
                c();
                return true;
            case 2:
                if (this.F == 1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.ab);
                    if (iFindPointerIndex == -1) {
                        return true;
                    }
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float f = (this.B + this.C) - x3;
                    this.E += Math.abs(f);
                    if (Math.abs(f) < 1.0f) {
                        awakenScrollBars();
                        return true;
                    }
                    this.t += f;
                    this.s = System.nanoTime() / 1.0E9f;
                    if (this.ag) {
                        invalidate();
                    } else {
                        scrollBy((int) f, 0);
                    }
                    this.B = x3;
                    this.C = f - ((int) f);
                    return true;
                }
                if (this.F != 4) {
                    b(motionEvent);
                    return true;
                }
                this.B = motionEvent.getX();
                this.D = motionEvent.getY();
                float[] fArrA3 = a(this, this.B, this.D);
                this.f = fArrA3[0];
                this.g = fArrA3[1];
                l();
                int iIndexOfChild = indexOfChild(this.an);
                boolean zD = d((int) this.f, (int) this.g);
                f(iIndexOfChild, zD);
                int nearestHoverOverPageIndex = getNearestHoverOverPageIndex();
                if (nearestHoverOverPageIndex <= -1 || nearestHoverOverPageIndex == indexOfChild(this.an) || zD) {
                    removeCallbacks(this.aC);
                    this.aD = -1;
                    return true;
                }
                this.V[0] = 0;
                this.V[1] = getPageCount() - 1;
                a(this.V);
                if (this.V[0] > nearestHoverOverPageIndex || nearestHoverOverPageIndex > this.V[1] || nearestHoverOverPageIndex == this.aD || !this.A.isFinished()) {
                    return true;
                }
                this.aD = nearestHoverOverPageIndex;
                this.aC = new lj(this, nearestHoverOverPageIndex, iIndexOfChild);
                postDelayed(this.aC, this.az);
                return true;
            case 3:
                if (this.F == 1) {
                    F();
                }
                c();
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                d(motionEvent);
                d();
                return true;
        }
    }

    protected void p() {
        int iJ = (this.v < 0 || this.v >= getPageCount()) ? 0 : j(this.v);
        scrollTo(iJ, 0);
        this.A.setFinalX(iJ);
        this.A.forceFinished(true);
    }

    protected void p(int i) {
        d(i, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (getCurrentPage() < getPageCount() - 1) {
                    d_();
                    return true;
                }
                return false;
            case 8192:
                if (getCurrentPage() > 0) {
                    c_();
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        this.m = true;
        return super.performLongClick();
    }

    void q() {
        this.A.forceFinished(true);
    }

    protected void q(int i) {
        e(i, false);
    }

    void r() {
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        if (this.av != null) {
            this.av.a(this.aw);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(indexOfChild(view));
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        removeViewAt(i);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(indexOfChild(view));
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int iD = d(indexOfChild(view));
        if (iD < 0 || iD == getCurrentPage() || isInTouchMode()) {
            return;
        }
        n(iD);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int iD = d(indexOfChild(view));
        if (iD == this.v && this.A.isFinished()) {
            return false;
        }
        n(iD);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            c(this.v).cancelLongPress();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    protected void s() {
        if (this.at != null) {
            this.at.a(c(this.v), this.v);
        }
        if (this.av == null || a(false)) {
            return;
        }
        this.av.setActiveMarker(getNextPage());
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        scrollTo(this.U + i, getScrollY() + i2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        boolean z;
        boolean z2;
        if (this.f373a) {
            i = Math.max(Math.min(i, this.c), this.b);
        }
        boolean zM = m();
        this.U = i;
        if (zM) {
            z = i > this.z;
        } else {
            z = i < 0;
        }
        if (zM) {
            z2 = i < 0;
        } else {
            z2 = i > this.z;
        }
        if (z) {
            super.scrollTo(0, i2);
            if (this.T) {
                if (zM) {
                    a(i - this.z);
                } else {
                    a(i);
                }
            }
        } else if (z2) {
            super.scrollTo(this.z, i2);
            if (this.T) {
                if (zM) {
                    a(i);
                } else {
                    a(i - this.z);
                }
            }
        } else {
            this.aa = i;
            super.scrollTo(i, i2);
        }
        this.t = i;
        this.s = System.nanoTime() / 1.0E9f;
        if (a(true)) {
            float[] fArrB = b(this, this.f, this.g);
            this.B = fArrB[0];
            this.D = fArrB[1];
            l();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i != 4096) {
            super.sendAccessibilityEvent(i);
        }
    }

    public void setAllowLongPress(boolean z) {
        this.ak = z;
    }

    void setCurrentPage(int i) {
        if (!this.A.isFinished()) {
            this.A.abortAnimation();
            this.y = -1;
        }
        if (getChildCount() == 0) {
            return;
        }
        this.G = true;
        this.v = Math.max(0, Math.min(i, getPageCount() - 1));
        p();
        s();
        invalidate();
    }

    void setDeleteDropTarget(View view) {
        this.aU = view;
    }

    public void setMinScale(float f) {
        this.aA = f;
        this.aB = true;
        requestLayout();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.H = onLongClickListener;
        int pageCount = getPageCount();
        for (int i = 0; i < pageCount; i++) {
            c(i).setOnLongClickListener(onLongClickListener);
        }
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setPageSpacing(int i) {
        this.J = i;
        requestLayout();
    }

    public void setPageSwitchListener(lr lrVar) {
        this.at = lrVar;
        if (this.at != null) {
            this.at.a(c(this.v), this.v);
        }
    }

    void setRestorePage(int i) {
        this.w = i;
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        if (a(true)) {
            float[] fArrB = b(this, this.f, this.g);
            this.B = fArrB[0];
            this.D = fArrB[1];
            l();
        }
    }

    protected void t() {
        if (this.ai) {
            return;
        }
        this.ai = true;
        w();
    }

    protected void u() {
        if (this.ai) {
            this.ai = false;
            g();
        }
    }

    protected boolean v() {
        return this.ai;
    }

    protected void w() {
    }

    protected boolean x() {
        if (this.A.computeScrollOffset()) {
            if (getScrollX() != this.A.getCurrX() || getScrollY() != this.A.getCurrY() || this.aa != this.A.getCurrX()) {
                scrollTo((int) ((1.0f / (this.f373a ? getScaleX() : 1.0f)) * this.A.getCurrX()), this.A.getCurrY());
            }
            invalidate();
            return true;
        }
        if (this.y == -1) {
            return false;
        }
        b();
        this.v = Math.max(0, Math.min(this.y, getPageCount() - 1));
        this.y = -1;
        s();
        if (this.ah) {
            p(this.v);
            this.ah = false;
        }
        if (this.F == 0) {
            u();
        }
        i();
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            announceForAccessibility(getCurrentPageDescription());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public lq generateDefaultLayoutParams() {
        return new lq(-2, -2);
    }

    protected void z() {
        this.aw = true;
    }
}
