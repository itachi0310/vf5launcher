package android.a.a.c;

import android.R;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.syu.jni.SyuJniNative;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class af extends ViewGroup {
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private android.a.a.d.e Q;
    private android.a.a.d.e R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private am W;
    private am aa;
    private al ab;
    private an ac;
    private Method ad;
    private int ae;
    private ArrayList af;
    private final Runnable ah;
    private int ai;
    private int b;
    private final ArrayList e;
    private final aj f;
    private final Rect g;
    private l h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private ao n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f11a = {R.attr.layout_gravity};
    private static final Comparator c = new ag();
    private static final Interpolator d = new ah();
    private static final ar ag = new ar();

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.N || Math.abs(i2) <= this.L) {
            i = (int) ((i >= this.i ? 0.4f : 0.6f) + i + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.e.size() > 0) {
            return Math.max(((aj) this.e.get(0)).b, Math.min(i, ((aj) this.e.get(this.e.size() - 1)).b));
        }
        return i;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.e.isEmpty()) {
            aj ajVarB = b(this.i);
            int iMin = (int) ((ajVarB != null ? Math.min(ajVarB.e, this.t) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                a(false);
                scrollTo(iMin, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) ((((i - getPaddingLeft()) - getPaddingRight()) + i3) * (getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)));
        scrollTo(paddingLeft, getScrollY());
        if (this.m.isFinished()) {
            return;
        }
        this.m.startScroll(paddingLeft, 0, (int) (b(this.i).e * i), 0, this.m.getDuration() - this.m.timePassed());
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int iMax;
        aj ajVarB = b(i);
        if (ajVarB != null) {
            iMax = (int) (Math.max(this.s, Math.min(ajVarB.e, this.t)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (z) {
            a(iMax, 0, i2);
            if (z2 && this.W != null) {
                this.W.a(i);
            }
            if (!z2 || this.aa == null) {
                return;
            }
            this.aa.a(i);
            return;
        }
        if (z2 && this.W != null) {
            this.W.a(i);
        }
        if (z2 && this.aa != null) {
            this.aa.a(i);
        }
        a(false);
        scrollTo(iMax, 0);
        d(iMax);
    }

    private void a(aj ajVar, int i, aj ajVar2) {
        aj ajVar3;
        aj ajVar4;
        int iA = this.h.a();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.o / clientWidth : 0.0f;
        if (ajVar2 != null) {
            int i2 = ajVar2.b;
            if (i2 < ajVar.b) {
                float fA = ajVar2.e + ajVar2.d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= ajVar.b && i4 < this.e.size()) {
                    Object obj = this.e.get(i4);
                    while (true) {
                        ajVar4 = (aj) obj;
                        if (i3 <= ajVar4.b || i4 >= this.e.size() - 1) {
                            break;
                        }
                        i4++;
                        obj = this.e.get(i4);
                    }
                    while (i3 < ajVar4.b) {
                        fA += this.h.a(i3) + f;
                        i3++;
                    }
                    ajVar4.e = fA;
                    fA += ajVar4.d + f;
                    i3++;
                }
            } else if (i2 > ajVar.b) {
                int size = this.e.size() - 1;
                float fA2 = ajVar2.e;
                int i5 = i2 - 1;
                while (i5 >= ajVar.b && size >= 0) {
                    Object obj2 = this.e.get(size);
                    while (true) {
                        ajVar3 = (aj) obj2;
                        if (i5 >= ajVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.e.get(size);
                    }
                    while (i5 > ajVar3.b) {
                        fA2 -= this.h.a(i5) + f;
                        i5--;
                    }
                    fA2 -= ajVar3.d + f;
                    ajVar3.e = fA2;
                    i5--;
                }
            }
        }
        int size2 = this.e.size();
        float f2 = ajVar.e;
        int i6 = ajVar.b - 1;
        this.s = ajVar.b == 0 ? ajVar.e : -3.4028235E38f;
        this.t = ajVar.b == iA + (-1) ? (ajVar.e + ajVar.d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            aj ajVar5 = (aj) this.e.get(i7);
            float fA3 = f2;
            while (i6 > ajVar5.b) {
                fA3 -= this.h.a(i6) + f;
                i6--;
            }
            f2 = fA3 - (ajVar5.d + f);
            ajVar5.e = f2;
            if (ajVar5.b == 0) {
                this.s = f2;
            }
            i6--;
        }
        float f3 = ajVar.e + ajVar.d + f;
        int i8 = ajVar.b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            aj ajVar6 = (aj) this.e.get(i9);
            float fA4 = f3;
            while (i8 < ajVar6.b) {
                fA4 = this.h.a(i8) + f + fA4;
                i8++;
            }
            if (ajVar6.b == iA - 1) {
                this.t = (ajVar6.d + fA4) - 1.0f;
            }
            ajVar6.e = fA4;
            f3 = fA4 + ajVar6.d + f;
            i8++;
        }
        this.T = false;
    }

    private void a(MotionEvent motionEvent) {
        int iB = g.b(motionEvent);
        if (g.b(motionEvent, iB) == this.J) {
            int i = iB == 0 ? 1 : 0;
            this.F = g.c(motionEvent, i);
            this.J = g.b(motionEvent, i);
            if (this.K != null) {
                this.K.clear();
            }
        }
    }

    private void a(boolean z) {
        boolean z2 = this.ai == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.e.size(); i++) {
            aj ajVar = (aj) this.e.get(i);
            if (ajVar.c) {
                ajVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                r.a(this, this.ah);
            } else {
                this.ah.run();
            }
        }
    }

    private boolean a(float f, float f2) {
        return (f < ((float) this.D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.D)) && f2 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            r.a(getChildAt(i), z ? 2 : 0, (Paint) null);
        }
    }

    private boolean b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean zA = false;
        float f3 = this.F - f;
        this.F = f;
        float scrollX = getScrollX() + f3;
        int clientWidth = getClientWidth();
        float f4 = clientWidth * this.s;
        float f5 = clientWidth * this.t;
        aj ajVar = (aj) this.e.get(0);
        aj ajVar2 = (aj) this.e.get(this.e.size() - 1);
        if (ajVar.b != 0) {
            f4 = ajVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (ajVar2.b != this.h.a() - 1) {
            f2 = ajVar2.e * clientWidth;
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                zA = this.Q.a(Math.abs(f4 - scrollX) / clientWidth);
            }
        } else if (scrollX > f2) {
            zA = z2 ? this.R.a(Math.abs(scrollX - f2) / clientWidth) : false;
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.F += f4 - ((int) f4);
        scrollTo((int) f4, getScrollY());
        d((int) f4);
        return zA;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean d(int i) {
        if (this.e.size() == 0) {
            this.U = false;
            a(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        aj ajVarH = h();
        int clientWidth = getClientWidth();
        int i2 = this.o + clientWidth;
        float f = this.o / clientWidth;
        int i3 = ajVarH.b;
        float f2 = ((i / clientWidth) - ajVarH.e) / (ajVarH.d + f);
        this.U = false;
        a(i3, f2, (int) (i2 * f2));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            if (!((ak) getChildAt(i2).getLayoutParams()).f13a) {
                removeViewAt(i2);
                i2--;
            }
            i = i2 + 1;
        }
    }

    private void g() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private aj h() {
        int i;
        aj ajVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.o / clientWidth : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        aj ajVar2 = null;
        while (i3 < this.e.size()) {
            aj ajVar3 = (aj) this.e.get(i3);
            if (z || ajVar3.b == i2 + 1) {
                i = i3;
                ajVar = ajVar3;
            } else {
                aj ajVar4 = this.f;
                ajVar4.e = f2 + f3 + f;
                ajVar4.b = i2 + 1;
                ajVar4.d = this.h.a(ajVar4.b);
                i = i3 - 1;
                ajVar = ajVar4;
            }
            float f4 = ajVar.e;
            float f5 = ajVar.d + f4 + f;
            if (!z && scrollX < f4) {
                return ajVar2;
            }
            if (scrollX < f5 || i == this.e.size() - 1) {
                return ajVar;
            }
            f3 = f4;
            i2 = ajVar.b;
            z = false;
            f2 = ajVar.d;
            ajVar2 = ajVar;
            i3 = i + 1;
        }
        return ajVar2;
    }

    private void i() {
        this.A = false;
        this.B = false;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ai == i) {
            return;
        }
        this.ai = i;
        if (this.ac != null) {
            b(i != 0);
        }
        if (this.W != null) {
            this.W.b(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.x != z) {
            this.x = z;
        }
    }

    float a(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    aj a(int i, int i2) {
        aj ajVar = new aj();
        ajVar.b = i;
        ajVar.f12a = this.h.a((ViewGroup) this, i);
        ajVar.d = this.h.a(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(ajVar);
        } else {
            this.e.add(i2, ajVar);
        }
        return ajVar;
    }

    aj a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return null;
            }
            aj ajVar = (aj) this.e.get(i2);
            if (this.h.a(view, ajVar.f12a)) {
                return ajVar;
            }
            i = i2 + 1;
        }
    }

    void a() {
        int i;
        boolean z;
        int iMax;
        boolean z2;
        int iA = this.h.a();
        this.b = iA;
        boolean z3 = this.e.size() < (this.z * 2) + 1 && this.e.size() < iA;
        boolean z4 = false;
        int i2 = this.i;
        boolean z5 = z3;
        int i3 = 0;
        while (i3 < this.e.size()) {
            aj ajVar = (aj) this.e.get(i3);
            int iA2 = this.h.a(ajVar.f12a);
            if (iA2 == -1) {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            } else if (iA2 == -2) {
                this.e.remove(i3);
                int i4 = i3 - 1;
                if (!z4) {
                    this.h.a((ViewGroup) this);
                    z4 = true;
                }
                this.h.a((ViewGroup) this, ajVar.b, ajVar.f12a);
                if (this.i == ajVar.b) {
                    i = i4;
                    z = z4;
                    iMax = Math.max(0, Math.min(this.i, iA - 1));
                    z2 = true;
                } else {
                    i = i4;
                    z = z4;
                    iMax = i2;
                    z2 = true;
                }
            } else if (ajVar.b != iA2) {
                if (ajVar.b == this.i) {
                    i2 = iA2;
                }
                ajVar.b = iA2;
                i = i3;
                z = z4;
                iMax = i2;
                z2 = true;
            } else {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            }
            z5 = z2;
            i2 = iMax;
            z4 = z;
            i3 = i + 1;
        }
        if (z4) {
            this.h.b((ViewGroup) this);
        }
        Collections.sort(this.e, c);
        if (z5) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ak akVar = (ak) getChildAt(i5).getLayoutParams();
                if (!akVar.f13a) {
                    akVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    void a(int i) {
        aj ajVar;
        int i2;
        String hexString;
        int i3;
        aj ajVar2;
        aj ajVarA;
        if (this.i != i) {
            int i4 = this.i < i ? 66 : 17;
            aj ajVarB = b(this.i);
            this.i = i;
            ajVar = ajVarB;
            i2 = i4;
        } else {
            ajVar = null;
            i2 = 2;
        }
        if (this.h == null) {
            g();
            return;
        }
        if (this.y) {
            g();
            return;
        }
        if (getWindowToken() != null) {
            this.h.a((ViewGroup) this);
            int i5 = this.z;
            int iMax = Math.max(0, this.i - i5);
            int iA = this.h.a();
            int iMin = Math.min(iA - 1, i5 + this.i);
            if (iA != this.b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + iA + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
            }
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i3 < this.e.size()) {
                    ajVar2 = (aj) this.e.get(i3);
                    if (ajVar2.b >= this.i) {
                        if (ajVar2.b != this.i) {
                            break;
                        } else {
                            break;
                        }
                    }
                    i6 = i3 + 1;
                }
                ajVar2 = null;
                break;
            }
            aj ajVarA2 = (ajVar2 != null || iA <= 0) ? ajVar2 : a(this.i, i3);
            if (ajVarA2 != null) {
                int i7 = i3 - 1;
                aj ajVar3 = i7 >= 0 ? (aj) this.e.get(i7) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - ajVarA2.d) + (getPaddingLeft() / clientWidth);
                float f = 0.0f;
                int i8 = i3;
                int i9 = i7;
                for (int i10 = this.i - 1; i10 >= 0; i10--) {
                    if (f >= paddingLeft && i10 < iMax) {
                        if (ajVar3 == null) {
                            break;
                        }
                        if (i10 == ajVar3.b && !ajVar3.c) {
                            this.e.remove(i9);
                            this.h.a((ViewGroup) this, i10, ajVar3.f12a);
                            i9--;
                            i8--;
                            ajVar3 = i9 >= 0 ? (aj) this.e.get(i9) : null;
                        }
                    } else if (ajVar3 == null || i10 != ajVar3.b) {
                        f += a(i10, i9 + 1).d;
                        i8++;
                        ajVar3 = i9 >= 0 ? (aj) this.e.get(i9) : null;
                    } else {
                        f += ajVar3.d;
                        i9--;
                        ajVar3 = i9 >= 0 ? (aj) this.e.get(i9) : null;
                    }
                }
                float f2 = ajVarA2.d;
                int i11 = i8 + 1;
                if (f2 < 2.0f) {
                    aj ajVar4 = i11 < this.e.size() ? (aj) this.e.get(i11) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    aj ajVar5 = ajVar4;
                    int i12 = i11;
                    int i13 = this.i + 1;
                    while (i13 < iA) {
                        if (f2 >= paddingRight && i13 > iMin) {
                            if (ajVar5 == null) {
                                break;
                            }
                            if (i13 == ajVar5.b && !ajVar5.c) {
                                this.e.remove(i12);
                                this.h.a((ViewGroup) this, i13, ajVar5.f12a);
                                ajVar5 = i12 < this.e.size() ? (aj) this.e.get(i12) : null;
                            }
                        } else if (ajVar5 == null || i13 != ajVar5.b) {
                            aj ajVarA3 = a(i13, i12);
                            i12++;
                            f2 += ajVarA3.d;
                            ajVar5 = i12 < this.e.size() ? (aj) this.e.get(i12) : null;
                        } else {
                            f2 += ajVar5.d;
                            i12++;
                            ajVar5 = i12 < this.e.size() ? (aj) this.e.get(i12) : null;
                        }
                        i13++;
                        ajVar5 = ajVar5;
                        f2 = f2;
                    }
                }
                a(ajVarA2, i8, ajVar);
            }
            this.h.b((ViewGroup) this, this.i, ajVarA2 != null ? ajVarA2.f12a : null);
            this.h.b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                ak akVar = (ak) childAt.getLayoutParams();
                akVar.f = i14;
                if (!akVar.f13a && akVar.c == 0.0f && (ajVarA = a(childAt)) != null) {
                    akVar.c = ajVarA.d;
                    akVar.e = ajVarA.b;
                }
            }
            g();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                aj ajVarB2 = viewFindFocus != null ? b(viewFindFocus) : null;
                if (ajVarB2 == null || ajVarB2.b != this.i) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        aj ajVarA4 = a(childAt2);
                        if (ajVarA4 != null && ajVarA4.b == this.i && childAt2.requestFocus(i2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    protected void a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.V > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                ak akVar = (ak) childAt.getLayoutParams();
                if (akVar.f13a) {
                    switch (akVar.b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i6 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i6;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i9 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        if (this.W != null) {
            this.W.a(i, f, i2);
        }
        if (this.aa != null) {
            this.aa.a(i, f, i2);
        }
        if (this.ac != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((ak) childAt2.getLayoutParams()).f13a) {
                    this.ac.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.U = true;
    }

    void a(int i, int i2, int i3) {
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a(false);
            b();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float fA = (i6 * a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientWidth))) + i6;
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(1000.0f * Math.abs(fA / iAbs2)) * 4;
        } else {
            iAbs = (int) (((Math.abs(i4) / ((clientWidth * this.h.a(this.i)) + this.o)) + 1.0f) * 100.0f);
        }
        this.m.startScroll(scrollX, scrollY, i4, i5, Math.min(iAbs, 600));
        r.b(this);
    }

    public void a(int i, boolean z) {
        this.y = false;
        a(i, z, false);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.h == null || this.h.a() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.i == i && this.e.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.h.a()) {
            i = this.h.a() - 1;
        }
        int i3 = this.z;
        if (i > this.i + i3 || i < this.i - i3) {
            for (int i4 = 0; i4 < this.e.size(); i4++) {
                ((aj) this.e.get(i4)).c = true;
            }
        }
        boolean z3 = this.i != i;
        if (!this.S) {
            a(i);
            a(i, z, i2, z3);
            return;
        }
        this.i = i;
        if (z3 && this.W != null) {
            this.W.a(i);
        }
        if (z3 && this.aa != null) {
            this.aa.a(i);
        }
        requestLayout();
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                return c(17);
            case MotionEventCompat.AXIS_GAS /* 22 */:
                return c(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (a.a(keyEvent)) {
                    return c(2);
                }
                if (a.a(keyEvent, 1)) {
                    return c(1);
                }
                return false;
            default:
                return false;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && r.a(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        aj ajVarA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (ajVarA = a(childAt)) != null && ajVarA.b == this.i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        aj ajVarA;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ajVarA = a(childAt)) != null && ajVarA.b == this.i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        ak akVar = (ak) layoutParamsGenerateLayoutParams;
        akVar.f13a |= view instanceof ai;
        if (!this.w) {
            super.addView(view, i, layoutParamsGenerateLayoutParams);
        } else {
            if (akVar != null && akVar.f13a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            akVar.d = true;
            addViewInLayout(view, i, layoutParamsGenerateLayoutParams);
        }
    }

    aj b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.e.size()) {
                return null;
            }
            aj ajVar = (aj) this.e.get(i3);
            if (ajVar.b == i) {
                return ajVar;
            }
            i2 = i3 + 1;
        }
    }

    aj b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    void b() {
        a(this.i);
    }

    boolean c() {
        if (this.i <= 0) {
            return false;
        }
        a(this.i - 1, true);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    public boolean c(int i) {
        View view;
        boolean z;
        boolean zC;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            view = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (z) {
                view = viewFindFocus;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                view = null;
            }
        } else {
            view = viewFindFocus;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (viewFindNextFocus == null || viewFindNextFocus == view) {
            if (i == 17 || i == 1) {
                zC = c();
            } else if (i == 66 || i == 2) {
                zC = d();
            } else {
                zC = false;
            }
        } else if (i == 17) {
            zC = (view == null || a(this.g, viewFindNextFocus).left < a(this.g, view).left) ? viewFindNextFocus.requestFocus() : c();
        } else if (i == 66) {
            zC = (view == null || a(this.g, viewFindNextFocus).left > a(this.g, view).left) ? viewFindNextFocus.requestFocus() : d();
        } else {
            zC = false;
        }
        if (zC) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zC;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.s));
        }
        if (i > 0) {
            return scrollX < ((int) (((float) clientWidth) * this.t));
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ak) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        r.b(this);
    }

    boolean d() {
        if (this.h == null || this.i >= this.h.a() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        aj ajVarA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ajVarA = a(childAt)) != null && ajVarA.b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean zA = false;
        int iA = r.a(this);
        if (iA == 0 || (iA == 1 && this.h != null && this.h.a() > 1)) {
            if (!this.Q.a()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.s * width);
                this.Q.a(height, width);
                zA = false | this.Q.a(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.R.a()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.t + 1.0f)) * width2);
                this.R.a(height2, width2);
                zA |= this.R.a(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.Q.b();
            this.R.b();
        }
        if (zA) {
            r.b(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ak();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ak(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public l getAdapter() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ak) ((View) this.af.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getOffscreenPageLimit() {
        return this.z;
    }

    public int getPageMargin() {
        return this.o;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.o <= 0 || this.p == null || this.e.size() <= 0 || this.h == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f2 = this.o / width;
        aj ajVar = (aj) this.e.get(0);
        float f3 = ajVar.e;
        int size = this.e.size();
        int i = ajVar.b;
        int i2 = ((aj) this.e.get(size - 1)).b;
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            while (i4 > ajVar.b && i3 < size) {
                i3++;
                ajVar = (aj) this.e.get(i3);
            }
            if (i4 == ajVar.b) {
                f = (ajVar.e + ajVar.d) * width;
                f3 = ajVar.e + ajVar.d + f2;
            } else {
                float fA = this.h.a(i4);
                f = (f3 + fA) * width;
                f3 += fA + f2;
            }
            if (this.o + f > scrollX) {
                this.p.setBounds((int) f, this.q, (int) (this.o + f + 0.5f), this.r);
                this.p.draw(canvas);
            }
            if (f > scrollX + width) {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.A = false;
            this.B = false;
            this.J = -1;
            if (this.K == null) {
                return false;
            }
            this.K.recycle();
            this.K = null;
            return false;
        }
        if (action != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                float y = motionEvent.getY();
                this.I = y;
                this.G = y;
                this.J = g.b(motionEvent, 0);
                this.B = false;
                this.m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O) {
                    this.m.abortAnimation();
                    this.y = false;
                    b();
                    this.A = true;
                    c(true);
                    setScrollState(1);
                } else {
                    a(false);
                    this.A = false;
                }
                break;
            case 2:
                int i = this.J;
                if (i != -1) {
                    int iA = g.a(motionEvent, i);
                    float fC = g.c(motionEvent, iA);
                    float f = fC - this.F;
                    float fAbs = Math.abs(f);
                    float fD = g.d(motionEvent, iA);
                    float fAbs2 = Math.abs(fD - this.I);
                    if (f != 0.0f && !a(this.F, f) && a(this, false, (int) f, (int) fC, (int) fD)) {
                        this.F = fC;
                        this.G = fD;
                        this.B = true;
                        return false;
                    }
                    if (fAbs > this.E && 0.5f * fAbs > fAbs2) {
                        this.A = true;
                        c(true);
                        setScrollState(1);
                        this.F = f > 0.0f ? this.H + this.E : this.H - this.E;
                        this.G = fD;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > this.E) {
                        this.B = true;
                    }
                    if (this.A && b(fC)) {
                        r.b(this);
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        return this.A;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0141  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aj ajVarA;
        int i5;
        int i6;
        int iMax;
        int measuredHeight;
        int i7;
        int i8;
        int childCount = getChildCount();
        int i9 = i3 - i;
        int i10 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i11 = 0;
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                ak akVar = (ak) childAt.getLayoutParams();
                if (akVar.f13a) {
                    int i13 = akVar.b & 7;
                    int i14 = akVar.b & SyuJniNative.JNI_EXE_CMD_112_IS_AREAACTIVED;
                    switch (i13) {
                        case 1:
                            iMax = Math.max((i9 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            iMax = paddingLeft;
                            break;
                        case 3:
                            iMax = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i9 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            iMax = measuredWidth;
                            break;
                    }
                    switch (i14) {
                        case 16:
                            measuredHeight = Math.max((i10 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i15 = paddingBottom;
                            i7 = paddingTop;
                            i8 = i15;
                            break;
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i16 = paddingTop;
                            i8 = paddingBottom;
                            i7 = measuredHeight2;
                            measuredHeight = i16;
                            break;
                        case 80:
                            measuredHeight = (i10 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i7 = paddingTop;
                            i8 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i17 = paddingBottom;
                            i7 = paddingTop;
                            i8 = i17;
                            break;
                    }
                    int i18 = iMax + scrollX;
                    childAt.layout(i18, measuredHeight, childAt.getMeasuredWidth() + i18, childAt.getMeasuredHeight() + measuredHeight);
                    i5 = i11 + 1;
                    i6 = i7;
                    paddingBottom = i8;
                } else {
                    i5 = i11;
                    i6 = paddingTop;
                }
            } else {
                i5 = i11;
                i6 = paddingTop;
            }
            i12++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i11 = i5;
        }
        int i19 = (i9 - paddingLeft) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                ak akVar2 = (ak) childAt2.getLayoutParams();
                if (!akVar2.f13a && (ajVarA = a(childAt2)) != null) {
                    int i21 = ((int) (ajVarA.e * i19)) + paddingLeft;
                    if (akVar2.d) {
                        akVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (akVar2.c * i19), 1073741824), View.MeasureSpec.makeMeasureSpec((i10 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i21, paddingTop, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.q = paddingTop;
        this.r = i10 - paddingBottom;
        this.V = i11;
        if (this.S) {
            a(this.i, false, 0, false);
        }
        this.S = false;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x010a A[PHI: r1
  0x010a: PHI (r1v18 int) = (r1v17 int), (r1v20 int) binds: [B:28:0x0088, B:30:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ak akVar;
        ak akVar2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.D = Math.min(measuredWidth / 10, this.C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (akVar2 = (ak) childAt.getLayoutParams()) != null && akVar2.f13a) {
                int i7 = akVar2.b & 7;
                int i8 = akVar2.b & SyuJniNative.JNI_EXE_CMD_112_IS_AREAACTIVED;
                int i9 = ExploreByTouchHelper.INVALID_ID;
                int i10 = ExploreByTouchHelper.INVALID_ID;
                boolean z = i8 == 48 || i8 == 80;
                boolean z2 = i7 == 3 || i7 == 5;
                if (z) {
                    i9 = 1073741824;
                } else if (z2) {
                    i10 = 1073741824;
                }
                if (akVar2.width != -2) {
                    i3 = 1073741824;
                    i4 = akVar2.width != -1 ? akVar2.width : paddingLeft;
                } else {
                    i3 = i9;
                    i4 = paddingLeft;
                }
                if (akVar2.height != -2) {
                    i10 = 1073741824;
                    if (akVar2.height != -1) {
                        i5 = akVar2.height;
                    } else {
                        i5 = measuredHeight;
                    }
                } else {
                    i5 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5, i10));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
        }
        this.u = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.w = true;
        b();
        this.w = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((akVar = (ak) childAt2.getLayoutParams()) == null || !akVar.f13a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (akVar.c * paddingLeft), 1073741824), this.v);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        aj ajVarA;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (ajVarA = a(childAt)) != null && ajVarA.b == this.i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ap)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ap apVar = (ap) parcelable;
        super.onRestoreInstanceState(apVar.getSuperState());
        if (this.h != null) {
            this.h.a(apVar.b, apVar.c);
            a(apVar.f15a, false, true);
        } else {
            this.j = apVar.f15a;
            this.k = apVar.b;
            this.l = apVar.c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ap apVar = new ap(super.onSaveInstanceState());
        apVar.f15a = this.i;
        if (this.h != null) {
            apVar.b = this.h.b();
        }
        return apVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.o, this.o);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zC = false;
        if (this.P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.a() == 0) {
            return false;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.y = false;
                b();
                float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                float y = motionEvent.getY();
                this.I = y;
                this.G = y;
                this.J = g.b(motionEvent, 0);
                break;
            case 1:
                if (this.A) {
                    VelocityTracker velocityTracker = this.K;
                    velocityTracker.computeCurrentVelocity(1000, this.M);
                    int iA = (int) m.a(velocityTracker, this.J);
                    this.y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    aj ajVarH = h();
                    a(a(ajVarH.b, ((scrollX / clientWidth) - ajVarH.e) / ajVarH.d, iA, (int) (g.c(motionEvent, g.a(motionEvent, this.J)) - this.H)), true, true, iA);
                    this.J = -1;
                    i();
                    zC = this.R.c() | this.Q.c();
                }
                break;
            case 2:
                if (!this.A) {
                    int iA2 = g.a(motionEvent, this.J);
                    float fC = g.c(motionEvent, iA2);
                    float fAbs = Math.abs(fC - this.F);
                    float fD = g.d(motionEvent, iA2);
                    float fAbs2 = Math.abs(fD - this.G);
                    if (fAbs > this.E && fAbs > fAbs2) {
                        this.A = true;
                        c(true);
                        this.F = fC - this.H > 0.0f ? this.H + this.E : this.H - this.E;
                        this.G = fD;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.A) {
                    zC = false | b(g.c(motionEvent, g.a(motionEvent, this.J)));
                }
                break;
            case 3:
                if (this.A) {
                    a(this.i, true, 0, false);
                    this.J = -1;
                    i();
                    zC = this.R.c() | this.Q.c();
                }
                break;
            case 5:
                int iB = g.b(motionEvent);
                this.F = g.c(motionEvent, iB);
                this.J = g.b(motionEvent, iB);
                break;
            case 6:
                a(motionEvent);
                this.F = g.c(motionEvent, g.a(motionEvent, this.J));
                break;
        }
        if (zC) {
            r.b(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(l lVar) {
        if (this.h != null) {
            this.h.b(this.n);
            this.h.a((ViewGroup) this);
            for (int i = 0; i < this.e.size(); i++) {
                aj ajVar = (aj) this.e.get(i);
                this.h.a((ViewGroup) this, ajVar.b, ajVar.f12a);
            }
            this.h.b((ViewGroup) this);
            this.e.clear();
            f();
            this.i = 0;
            scrollTo(0, 0);
        }
        l lVar2 = this.h;
        this.h = lVar;
        this.b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new ao(this, null);
            }
            this.h.a((DataSetObserver) this.n);
            this.y = false;
            boolean z = this.S;
            this.S = true;
            this.b = this.h.a();
            if (this.j >= 0) {
                this.h.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
        if (this.ab == null || lVar2 == lVar) {
            return;
        }
        this.ab.a(lVar2, lVar);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ad.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.y = false;
        a(i, !this.S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.z) {
            this.z = i;
            b();
        }
    }

    void setOnAdapterChangeListener(al alVar) {
        this.ab = alVar;
    }

    public void setOnPageChangeListener(am amVar) {
        this.W = amVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.o;
        this.o = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }
}
