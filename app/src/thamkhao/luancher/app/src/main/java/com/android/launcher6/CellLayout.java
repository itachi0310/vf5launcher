package com.android.launcher6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class CellLayout extends ViewGroup {
    private static final PorterDuffXfermode an = new PorterDuffXfermode(PorterDuff.Mode.ADD);
    private static final Paint ao = new Paint();
    private float A;
    private int B;
    private float C;
    private float D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Rect J;
    private Rect K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private Rect[] P;
    private float[] Q;
    private ea[] R;
    private int S;
    private final Paint T;
    private BubbleTextView U;
    private HashMap V;
    private HashMap W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f73a;
    private boolean aa;
    private final int[] ab;
    private boolean ac;
    private TimeInterpolator ad;
    private mo ae;
    private boolean af;
    private float ag;
    private float ah;
    private ArrayList ai;
    private Rect aj;
    private int[] ak;
    private cf al;
    private Rect am;
    private final Stack ap;
    boolean[][] b;
    boolean[][] c;
    boolean d;
    int[] e;
    private Launcher f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private final Rect s;
    private final aj t;
    private final int[] u;
    private final int[] v;
    private boolean w;
    private View.OnTouchListener x;
    private ArrayList y;
    private int[] z;

    public CellLayout(Context context) {
        this(context, null);
    }

    public CellLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = 0;
        this.r = false;
        this.s = new Rect();
        this.t = new aj();
        this.u = new int[2];
        this.v = new int[2];
        this.f73a = new int[2];
        this.w = false;
        this.y = new ArrayList();
        this.z = new int[]{-1, -1};
        this.A = 0.65f;
        this.B = 0;
        this.D = 1.0f;
        this.M = -1;
        this.N = -1;
        this.O = false;
        this.d = false;
        this.P = new Rect[4];
        this.Q = new float[this.P.length];
        this.R = new ea[this.P.length];
        this.S = 0;
        this.T = new Paint();
        this.V = new HashMap();
        this.W = new HashMap();
        this.aa = false;
        this.ab = new int[2];
        this.ac = false;
        this.af = false;
        this.ag = 1.0f;
        this.ai = new ArrayList();
        this.aj = new Rect();
        this.ak = new int[2];
        this.e = new int[2];
        this.am = new Rect();
        this.ap = new Stack();
        this.al = new cf(context);
        setWillNotDraw(false);
        setClipToPadding(false);
        this.f = (Launcher) context;
        bl blVarA = ip.a().i().a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.CellLayout, i, 0);
        this.h = -1;
        this.g = -1;
        this.j = -1;
        this.j = -1;
        this.m = 0;
        this.o = 0;
        this.n = 0;
        this.p = 0;
        this.q = Integer.MAX_VALUE;
        this.k = (int) blVarA.e;
        this.l = (int) blVarA.d;
        this.b = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.k, this.l);
        this.c = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.k, this.l);
        this.e[0] = -100;
        this.e[1] = -100;
        typedArrayObtainStyledAttributes.recycle();
        setAlwaysDrawnWithCacheEnabled(false);
        Resources resources = getResources();
        this.ag = blVarA.i / blVarA.f;
        this.E = resources.getDrawable(R.drawable.screenpanel);
        this.F = resources.getDrawable(R.drawable.screenpanel_hover);
        this.H = resources.getDrawable(R.drawable.overscroll_glow_left);
        this.I = resources.getDrawable(R.drawable.overscroll_glow_right);
        this.L = resources.getDimensionPixelSize(R.dimen.workspace_overscroll_drawable_padding);
        this.ah = 0.12f * blVarA.u;
        this.E.setFilterBitmap(true);
        this.F.setFilterBitmap(true);
        this.ad = new DecelerateInterpolator(2.5f);
        int[] iArr = this.ab;
        this.ab[1] = -1;
        iArr[0] = -1;
        for (int i3 = 0; i3 < this.P.length; i3++) {
            this.P[i3] = new Rect(-1, -1, -1, -1);
        }
        int integer = resources.getInteger(R.integer.config_dragOutlineFadeTime);
        float integer2 = resources.getInteger(R.integer.config_dragOutlineMaxAlpha);
        Arrays.fill(this.Q, 0.0f);
        while (true) {
            int i4 = i2;
            if (i4 >= this.R.length) {
                this.J = new Rect();
                this.K = new Rect();
                this.ae = new mo(context);
                this.ae.a(this.g, this.h, this.o, this.p, this.k, this.l);
                addView(this.ae);
                return;
            }
            ea eaVar = new ea(this, integer, 0.0f, integer2);
            eaVar.e().setInterpolator(this.ad);
            eaVar.e().addUpdateListener(new ae(this, eaVar, i4));
            eaVar.e().addListener(new af(this, eaVar));
            this.R[i4] = eaVar;
            i2 = i4 + 1;
        }
    }

    private void a() {
        aj ajVar = this.t;
        ajVar.f107a = null;
        ajVar.b = -1;
        ajVar.c = -1;
        ajVar.d = 0;
        ajVar.e = 0;
        setTag(ajVar);
    }

    private void a(int i, int i2, int i3, int i4, View view, Rect rect, ArrayList arrayList) {
        if (rect != null) {
            rect.set(i, i2, i + i3, i2 + i4);
        }
        arrayList.clear();
        Rect rect2 = new Rect(i, i2, i + i3, i2 + i4);
        Rect rect3 = new Rect();
        int childCount = this.ae.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = this.ae.getChildAt(i5);
            if (childAt != view) {
                al alVar = (al) childAt.getLayoutParams();
                rect3.set(alVar.f109a, alVar.b, alVar.f109a + alVar.f, alVar.g + alVar.b);
                if (Rect.intersects(rect2, rect3)) {
                    this.ai.add(childAt);
                    if (rect != null) {
                        rect.union(rect3);
                    }
                }
            }
        }
    }

    private void a(int i, int i2, int i3, int i4, boolean[][] zArr, boolean z) {
        if (i < 0 || i2 < 0) {
            return;
        }
        for (int i5 = i; i5 < i + i3 && i5 < this.k; i5++) {
            for (int i6 = i2; i6 < i2 + i4 && i6 < this.l; i6++) {
                zArr[i5][i6] = z;
            }
        }
    }

    private void a(Rect rect, boolean[][] zArr, boolean z) {
        a(rect.left, rect.top, rect.width(), rect.height(), zArr, z);
    }

    private void a(BubbleTextView bubbleTextView) {
        int pressedOrFocusedBackgroundPadding = bubbleTextView.getPressedOrFocusedBackgroundPadding();
        invalidate((bubbleTextView.getLeft() + getPaddingLeft()) - pressedOrFocusedBackgroundPadding, (bubbleTextView.getTop() + getPaddingTop()) - pressedOrFocusedBackgroundPadding, bubbleTextView.getRight() + getPaddingLeft() + pressedOrFocusedBackgroundPadding, pressedOrFocusedBackgroundPadding + bubbleTextView.getBottom() + getPaddingTop());
    }

    private void a(ak akVar, View view) {
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.l; i2++) {
                this.c[i][i2] = false;
            }
        }
        int childCount = this.ae.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.ae.getChildAt(i3);
            if (childAt != view) {
                al alVar = (al) childAt.getLayoutParams();
                ai aiVar = (ai) akVar.f108a.get(childAt);
                if (aiVar != null) {
                    alVar.c = aiVar.f106a;
                    alVar.d = aiVar.b;
                    alVar.f = aiVar.c;
                    alVar.g = aiVar.d;
                    a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, this.c, true);
                }
            }
        }
        a(akVar.d, akVar.e, akVar.f, akVar.g, this.c, true);
    }

    private void a(ak akVar, View view, int i) {
        int childCount = this.ae.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ae.getChildAt(i2);
            if (childAt != view) {
                ai aiVar = (ai) akVar.f108a.get(childAt);
                al alVar = (al) childAt.getLayoutParams();
                if (aiVar != null) {
                    new am(this, childAt, alVar.f109a, alVar.b, aiVar.f106a, aiVar.b, aiVar.c, aiVar.d).a();
                }
            }
        }
    }

    private void a(ak akVar, View view, boolean z) {
        ai aiVar;
        boolean[][] zArr = this.c;
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.l; i2++) {
                zArr[i][i2] = false;
            }
        }
        int childCount = this.ae.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.ae.getChildAt(i3);
            if (childAt != view && (aiVar = (ai) akVar.f108a.get(childAt)) != null) {
                a(childAt, aiVar.f106a, aiVar.b, 150, 0, false, false);
                a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, zArr, true);
            }
        }
        if (z) {
            a(akVar.d, akVar.e, akVar.f, akVar.g, zArr, true);
        }
    }

    private void a(ak akVar, boolean z) {
        int childCount = this.ae.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ae.getChildAt(i);
            al alVar = (al) childAt.getLayoutParams();
            akVar.a(childAt, z ? new ai(this, alVar.c, alVar.d, alVar.f, alVar.g) : new ai(this, alVar.f109a, alVar.b, alVar.f, alVar.g));
        }
    }

    private void a(Stack stack) {
        while (!stack.isEmpty()) {
            this.ap.push((Rect) stack.pop());
        }
    }

    private void a(boolean[][] zArr) {
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.l; i2++) {
                zArr[i][i2] = this.b[i][i2];
            }
        }
    }

    private boolean a(int i, int i2, int i3, int i4, int[] iArr, View view, ak akVar) {
        ai aiVar;
        if (i < 0 || i2 < 0) {
            return false;
        }
        this.ai.clear();
        this.aj.set(i, i2, i + i3, i2 + i4);
        if (view != null && (aiVar = (ai) akVar.f108a.get(view)) != null) {
            aiVar.f106a = i;
            aiVar.b = i2;
        }
        Rect rect = new Rect(i, i2, i + i3, i2 + i4);
        Rect rect2 = new Rect();
        for (View view2 : akVar.f108a.keySet()) {
            if (view2 != view) {
                ai aiVar2 = (ai) akVar.f108a.get(view2);
                al alVar = (al) view2.getLayoutParams();
                rect2.set(aiVar2.f106a, aiVar2.b, aiVar2.f106a + aiVar2.c, aiVar2.d + aiVar2.b);
                if (!Rect.intersects(rect, rect2)) {
                    continue;
                } else {
                    if (!alVar.j) {
                        return false;
                    }
                    this.ai.add(view2);
                }
            }
        }
        if (c(this.ai, this.aj, iArr, view, akVar) || b(this.ai, this.aj, iArr, view, akVar)) {
            return true;
        }
        Iterator it = this.ai.iterator();
        while (it.hasNext()) {
            if (!a((View) it.next(), this.aj, iArr, akVar)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(View view, Rect rect, int[] iArr, ak akVar) {
        boolean z;
        ai aiVar = (ai) akVar.f108a.get(view);
        a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, this.c, false);
        a(rect, this.c, true);
        a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, iArr, this.c, (boolean[][]) null, this.f73a);
        if (this.f73a[0] < 0 || this.f73a[1] < 0) {
            z = false;
        } else {
            aiVar.f106a = this.f73a[0];
            aiVar.b = this.f73a[1];
            z = true;
        }
        a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, this.c, true);
        return z;
    }

    private boolean a(ArrayList arrayList, Rect rect, int[] iArr, View view, ak akVar) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        ap apVar = new ap(this, arrayList, akVar);
        Rect rectB = apVar.b();
        boolean z3 = false;
        if (iArr[0] < 0) {
            i = rectB.right - rect.left;
            i2 = 0;
        } else if (iArr[0] > 0) {
            i = rect.right - rectB.left;
            i2 = 2;
        } else if (iArr[1] < 0) {
            i = rectB.bottom - rect.top;
            i2 = 1;
        } else {
            i = rect.bottom - rectB.top;
            i2 = 3;
        }
        if (i <= 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ai aiVar = (ai) akVar.f108a.get((View) it.next());
            a(aiVar.f106a, aiVar.b, aiVar.c, aiVar.d, this.c, false);
        }
        akVar.a();
        apVar.b(i2);
        while (i > 0 && !z3) {
            Iterator it2 = akVar.b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = z3;
                    break;
                }
                View view2 = (View) it2.next();
                if (!apVar.f113a.contains(view2) && view2 != view && apVar.a(view2, i2)) {
                    if (!((al) view2.getLayoutParams()).j) {
                        z2 = true;
                        break;
                    }
                    apVar.a(view2);
                    ai aiVar2 = (ai) akVar.f108a.get(view2);
                    a(aiVar2.f106a, aiVar2.b, aiVar2.c, aiVar2.d, this.c, false);
                }
            }
            apVar.a(i2, 1);
            z3 = z2;
            i--;
        }
        Rect rectB2 = apVar.b();
        if (z3 || rectB2.left < 0 || rectB2.right > this.k || rectB2.top < 0 || rectB2.bottom > this.l) {
            akVar.b();
            z = false;
        } else {
            z = true;
        }
        Iterator it3 = apVar.f113a.iterator();
        while (it3.hasNext()) {
            ai aiVar3 = (ai) akVar.f108a.get((View) it3.next());
            a(aiVar3.f106a, aiVar3.b, aiVar3.c, aiVar3.d, this.c, true);
        }
        return z;
    }

    static boolean a(int[] iArr, int i, int i2, int i3, int i4, boolean[][] zArr) {
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                boolean z = !zArr[i6][i5];
                for (int i7 = i6; i7 < (i6 + i) - 1 && i6 < i3; i7++) {
                    for (int i8 = i5; i8 < (i5 + i2) - 1 && i5 < i4; i8++) {
                        z = z && !zArr[i7][i8];
                        if (!z) {
                            break;
                        }
                    }
                }
                if (z) {
                    iArr[0] = i6;
                    iArr[1] = i5;
                    return true;
                }
            }
        }
        return false;
    }

    private int[] a(int i, int i2, int i3, int i4, int[] iArr, boolean[][] zArr, boolean[][] zArr2, int[] iArr2) {
        float f;
        if (iArr2 == null) {
            iArr2 = new int[2];
        }
        float f2 = Float.MAX_VALUE;
        int i5 = ExploreByTouchHelper.INVALID_ID;
        int i6 = this.k;
        int i7 = this.l;
        int i8 = 0;
        while (i8 < i7 - (i4 - 1)) {
            int i9 = 0;
            int i10 = i5;
            while (i9 < i6 - (i3 - 1)) {
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 >= i3) {
                        float fSqrt = (float) Math.sqrt(((i9 - i) * (i9 - i)) + ((i8 - i2) * (i8 - i2)));
                        int[] iArr3 = this.v;
                        b(i9 - i, i8 - i2, iArr3);
                        int i13 = (iArr[0] * iArr3[0]) + (iArr[1] * iArr3[1]);
                        if (!(iArr[0] == iArr3[0] && iArr[0] == iArr3[0])) {
                        }
                        if (Float.compare(fSqrt, f2) >= 0 && (Float.compare(fSqrt, f2) != 0 || i13 <= i10)) {
                            f = f2;
                            break;
                        }
                        iArr2[0] = i9;
                        iArr2[1] = i8;
                        i10 = i13;
                        f = fSqrt;
                        break;
                    }
                    int i14 = 0;
                    while (true) {
                        if (i14 >= i4) {
                            i11 = i12 + 1;
                        } else {
                            if (zArr[i9 + i12][i8 + i14]) {
                                if (zArr2 == null) {
                                    f = f2;
                                    break;
                                    break;
                                }
                                if (zArr2[i12][i14]) {
                                    f = f2;
                                    break;
                                }
                            }
                            i14++;
                        }
                    }
                }
                i9++;
                f2 = f;
            }
            i8++;
            i5 = i10;
        }
        if (f2 == Float.MAX_VALUE) {
            iArr2[0] = -1;
            iArr2[1] = -1;
        }
        return iArr2;
    }

    private void b() {
        if (this.ap.isEmpty()) {
            for (int i = 0; i < this.k * this.l; i++) {
                this.ap.push(new Rect());
            }
        }
    }

    private void b(float f, float f2, int[] iArr) {
        double dAtan = Math.atan(f2 / f);
        iArr[0] = 0;
        iArr[1] = 0;
        if (Math.abs(Math.cos(dAtan)) > 0.5d) {
            iArr[0] = (int) Math.signum(f);
        }
        if (Math.abs(Math.sin(dAtan)) > 0.5d) {
            iArr[1] = (int) Math.signum(f2);
        }
    }

    private boolean b(ArrayList arrayList, Rect rect, int[] iArr, View view, ak akVar) {
        boolean z;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator it = arrayList.iterator();
        Rect rect2 = null;
        while (it.hasNext()) {
            ai aiVar = (ai) akVar.f108a.get((View) it.next());
            if (rect2 == null) {
                rect2 = new Rect(aiVar.f106a, aiVar.b, aiVar.f106a + aiVar.c, aiVar.d + aiVar.b);
            } else {
                rect2.union(aiVar.f106a, aiVar.b, aiVar.f106a + aiVar.c, aiVar.d + aiVar.b);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ai aiVar2 = (ai) akVar.f108a.get((View) it2.next());
            a(aiVar2.f106a, aiVar2.b, aiVar2.c, aiVar2.d, this.c, false);
        }
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, rect2.width(), rect2.height());
        int i = rect2.top;
        int i2 = rect2.left;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ai aiVar3 = (ai) akVar.f108a.get((View) it3.next());
            a(aiVar3.f106a - i2, aiVar3.b - i, aiVar3.c, aiVar3.d, zArr, true);
        }
        a(rect, this.c, true);
        a(rect2.left, rect2.top, rect2.width(), rect2.height(), iArr, this.c, zArr, this.f73a);
        if (this.f73a[0] < 0 || this.f73a[1] < 0) {
            z = false;
        } else {
            int i3 = this.f73a[0] - rect2.left;
            int i4 = this.f73a[1] - rect2.top;
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                ai aiVar4 = (ai) akVar.f108a.get((View) it4.next());
                aiVar4.f106a += i3;
                aiVar4.b += i4;
            }
            z = true;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ai aiVar5 = (ai) akVar.f108a.get((View) it5.next());
            a(aiVar5.f106a, aiVar5.b, aiVar5.c, aiVar5.d, this.c, true);
        }
        return z;
    }

    private void c(int i, int i2, int i3, int i4, View view, int[] iArr) {
        int[] iArr2 = new int[2];
        c(i, i2, i3, i4, iArr2);
        Rect rect = new Rect();
        a(iArr2[0], iArr2[1], i3, i4, rect);
        rect.offset(i - rect.centerX(), i2 - rect.centerY());
        Rect rect2 = new Rect();
        a(iArr2[0], iArr2[1], i3, i4, view, rect2, this.ai);
        int iWidth = rect2.width();
        int iHeight = rect2.height();
        a(rect2.left, rect2.top, rect2.width(), rect2.height(), rect2);
        int iCenterX = (rect2.centerX() - i) / i3;
        int iCenterY = (rect2.centerY() - i2) / i4;
        if (iWidth == this.k || i3 == this.k) {
            iCenterX = 0;
        }
        if (iHeight == this.l || i4 == this.l) {
            iCenterY = 0;
        }
        if (iCenterX != 0 || iCenterY != 0) {
            b(iCenterX, iCenterY, iArr);
        } else {
            iArr[0] = 1;
            iArr[1] = 0;
        }
    }

    private boolean c(ArrayList arrayList, Rect rect, int[] iArr, View view, ak akVar) {
        if (Math.abs(iArr[0]) + Math.abs(iArr[1]) > 1) {
            int i = iArr[1];
            iArr[1] = 0;
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[1] = i;
            int i2 = iArr[0];
            iArr[0] = 0;
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = i2;
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
            int i3 = iArr[1];
            iArr[1] = 0;
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[1] = i3;
            int i4 = iArr[0];
            iArr[0] = 0;
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = i4;
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
        } else {
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
            int i5 = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = i5;
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
            if (a(arrayList, rect, iArr, view, akVar)) {
                return true;
            }
            iArr[0] = iArr[0] * (-1);
            iArr[1] = iArr[1] * (-1);
            int i6 = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = i6;
        }
        return false;
    }

    public static int[] d(int i, int i2, int[] iArr) {
        bl blVarA = ip.a().i().a();
        Rect rectA = blVarA.a(blVarA.j ? 0 : 1);
        int iMin = Math.min(blVarA.a((blVarA.q - rectA.left) - rectA.right, (int) blVarA.e), blVarA.b((blVarA.r - rectA.top) - rectA.bottom, (int) blVarA.d));
        int iCeil = (int) Math.ceil(i / iMin);
        int iCeil2 = (int) Math.ceil(i2 / iMin);
        if (iArr == null) {
            return new int[]{iCeil, iCeil2};
        }
        iArr[0] = iCeil;
        iArr[1] = iCeil2;
        return iArr;
    }

    private void l() {
        Iterator it = this.W.values().iterator();
        while (it.hasNext()) {
            ((am) it.next()).c();
        }
        this.W.clear();
    }

    private void m() {
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.l; i2++) {
                this.b[i][i2] = this.c[i][i2];
            }
        }
        int childCount = this.ae.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.ae.getChildAt(i3);
            al alVar = (al) childAt.getLayoutParams();
            ec ecVar = (ec) childAt.getTag();
            if (ecVar != null) {
                if (ecVar.j != alVar.c || ecVar.k != alVar.d || ecVar.l != alVar.f || ecVar.m != alVar.g) {
                    ecVar.p = true;
                }
                int i4 = alVar.c;
                alVar.f109a = i4;
                ecVar.j = i4;
                int i5 = alVar.d;
                alVar.b = i5;
                ecVar.k = i5;
                ecVar.l = alVar.f;
                ecVar.m = alVar.g;
            }
        }
        this.f.I().c(this);
    }

    private void n() {
        for (int i = 0; i < this.k; i++) {
            for (int i2 = 0; i2 < this.l; i2++) {
                this.b[i][i2] = false;
            }
        }
    }

    public float a(float f, float f2, int[] iArr) {
        c(iArr[0], iArr[1], this.v);
        return (float) Math.sqrt(Math.pow(f - this.v[0], 2.0d) + Math.pow(f2 - this.v[1], 2.0d));
    }

    ak a(int i, int i2, int i3, int i4, int i5, int i6, View view, ak akVar) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        a(i, i2, i3, i4, i5, i6, null, iArr, iArr2);
        if (iArr[0] < 0 || iArr[1] < 0) {
            akVar.c = false;
        } else {
            a(akVar, false);
            akVar.d = iArr[0];
            akVar.e = iArr[1];
            akVar.f = iArr2[0];
            akVar.g = iArr2[1];
            akVar.c = true;
        }
        return akVar;
    }

    ak a(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, View view, boolean z, ak akVar) {
        a(akVar, false);
        a(this.c);
        int[] iArrC = c(i, i2, i5, i6, new int[2]);
        if (a(iArrC[0], iArrC[1], i5, i6, iArr, view, akVar)) {
            akVar.c = true;
            akVar.d = iArrC[0];
            akVar.e = iArrC[1];
            akVar.f = i5;
            akVar.g = i6;
            return akVar;
        }
        if (i5 > i3 && (i4 == i6 || z)) {
            return a(i, i2, i3, i4, i5 - 1, i6, iArr, view, false, akVar);
        }
        if (i6 > i4) {
            return a(i, i2, i3, i4, i5, i6 - 1, iArr, view, true, akVar);
        }
        akVar.c = false;
        return akVar;
    }

    void a(float f, boolean z) {
        if (z && this.G != this.H) {
            this.G = this.H;
        } else if (!z && this.G != this.I) {
            this.G = this.I;
        }
        this.B = Math.round(this.A * f * 255.0f);
        this.G.setAlpha(this.B);
        invalidate();
    }

    public void a(int i, int i2) {
        this.g = i;
        this.i = i;
        this.h = i2;
        this.j = i2;
        this.ae.a(this.g, this.h, this.o, this.p, this.k, this.l);
    }

    void a(int i, int i2, int i3, int i4, Rect rect) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = paddingLeft + ((this.g + this.o) * i);
        int i6 = paddingTop + ((this.h + this.p) * i2);
        rect.set(i5, i6, (this.g * i3) + ((i3 - 1) * this.o) + i5, (this.h * i4) + ((i4 - 1) * this.p) + i6);
    }

    void a(int i, int i2, int i3, int i4, int[] iArr) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        iArr[0] = paddingLeft + ((this.g + this.o) * i) + (((this.g * i3) + ((i3 - 1) * this.o)) / 2);
        iArr[1] = paddingTop + ((this.h + this.p) * i2) + (((this.h * i4) + ((i4 - 1) * this.p)) / 2);
    }

    void a(int i, int i2, int[] iArr) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        iArr[0] = (i - paddingLeft) / (this.g + this.o);
        iArr[1] = (i2 - paddingTop) / (this.h + this.p);
        int i3 = this.k;
        int i4 = this.l;
        if (iArr[0] < 0) {
            iArr[0] = 0;
        }
        if (iArr[0] >= i3) {
            iArr[0] = i3 - 1;
        }
        if (iArr[1] < 0) {
            iArr[1] = 0;
        }
        if (iArr[1] >= i4) {
            iArr[1] = i4 - 1;
        }
    }

    public void a(SparseArray sparseArray) {
        dispatchRestoreInstanceState(sparseArray);
    }

    public void a(View view) {
        d(view);
    }

    void a(View view, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Point point, Rect rect) {
        int width;
        int height;
        int i7 = this.ab[0];
        int i8 = this.ab[1];
        if (bitmap == null && view == null) {
            return;
        }
        if (i3 == i7 && i4 == i8) {
            return;
        }
        this.ab[0] = i3;
        this.ab[1] = i4;
        int[] iArr = this.v;
        b(i3, i4, iArr);
        int i9 = iArr[0];
        int i10 = iArr[1];
        if (view != null && point == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i11 = i9 + marginLayoutParams.leftMargin;
            height = marginLayoutParams.topMargin + i10 + ((view.getHeight() - bitmap.getHeight()) / 2);
            width = i11 + ((((this.g * i5) + ((i5 - 1) * this.o)) - bitmap.getWidth()) / 2);
        } else if (point == null || rect == null) {
            width = i9 + ((((this.g * i5) + ((i5 - 1) * this.o)) - bitmap.getWidth()) / 2);
            height = ((((this.h * i6) + ((i6 - 1) * this.p)) - bitmap.getHeight()) / 2) + i10;
        } else {
            width = i9 + point.x + ((((this.g * i5) + ((i5 - 1) * this.o)) - rect.width()) / 2);
            height = ((int) Math.max(0.0f, (this.h - getShortcutsAndWidgets().getCellContentHeight()) / 2.0f)) + point.y + i10;
        }
        int i12 = this.S;
        this.R[i12].c();
        this.S = (i12 + 1) % this.P.length;
        Rect rect2 = this.P[this.S];
        rect2.set(width, height, bitmap.getWidth() + width, bitmap.getHeight() + height);
        if (z) {
            b(i3, i4, i5, i6, rect2);
        }
        this.R[this.S].a(bitmap);
        this.R[this.S].b();
    }

    public void a(View view, boolean[][] zArr) {
        if (view == null || view.getParent() != this.ae) {
            return;
        }
        al alVar = (al) view.getLayoutParams();
        a(alVar.f109a, alVar.b, alVar.f, alVar.g, zArr, true);
    }

    public void a(da daVar) {
        this.y.add(daVar);
    }

    public void a(ec ecVar) {
        int i;
        int i2;
        if (ecVar instanceof it) {
            i = ((it) ecVar).c;
            i2 = ((it) ecVar).d;
        } else if (!(ecVar instanceof mf)) {
            ecVar.m = 1;
            ecVar.l = 1;
            return;
        } else {
            i = ((mf) ecVar).b;
            i2 = ((mf) ecVar).c;
        }
        int[] iArrD = d(i, i2, null);
        ecVar.l = iArrD[0];
        ecVar.m = iArrD[1];
    }

    public void a(boolean z) {
        this.ae.setLayerType(z ? 2 : 0, ao);
    }

    boolean a(int i, int i2, int i3, int i4, View view, int[] iArr) {
        int[] iArrC = c(i, i2, i3, i4, iArr);
        a(iArrC[0], iArrC[1], i3, i4, view, (Rect) null, this.ai);
        return !this.ai.isEmpty();
    }

    boolean a(int i, int i2, int i3, int i4, View view, int[] iArr, boolean z) {
        int[] iArr2 = new int[2];
        a(i, i2, i3, i4, iArr2);
        ak akVarA = a(iArr2[0], iArr2[1], i3, i4, i3, i4, iArr, view, true, new ak(this, null));
        setUseTempCoords(true);
        if (akVarA != null && akVarA.c) {
            a(akVarA, view);
            setItemPlacementDirty(true);
            a(akVarA, view, z);
            if (z) {
                m();
                l();
                setItemPlacementDirty(false);
            } else {
                a(akVarA, view, 150);
            }
            this.ae.requestLayout();
        }
        return akVarA.c;
    }

    public boolean a(View view, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        mo shortcutsAndWidgets = getShortcutsAndWidgets();
        boolean[][] zArr = !z ? this.c : this.b;
        if (shortcutsAndWidgets.indexOfChild(view) == -1) {
            return false;
        }
        al alVar = (al) view.getLayoutParams();
        ec ecVar = (ec) view.getTag();
        if (this.V.containsKey(alVar)) {
            ((Animator) this.V.get(alVar)).cancel();
            this.V.remove(alVar);
        }
        int i5 = alVar.k;
        int i6 = alVar.l;
        if (z2) {
            zArr[alVar.f109a][alVar.b] = false;
            zArr[i][i2] = true;
        }
        alVar.h = true;
        if (z) {
            ecVar.j = i;
            alVar.f109a = i;
            ecVar.k = i2;
            alVar.b = i2;
        } else {
            alVar.c = i;
            alVar.d = i2;
        }
        shortcutsAndWidgets.setupLp(alVar);
        alVar.h = false;
        int i7 = alVar.k;
        int i8 = alVar.l;
        alVar.k = i5;
        alVar.l = i6;
        if (i5 == i7 && i6 == i8) {
            alVar.h = true;
            return true;
        }
        ValueAnimator valueAnimatorA = ik.a(view, 0.0f, 1.0f);
        valueAnimatorA.setDuration(i3);
        this.V.put(alVar, valueAnimatorA);
        valueAnimatorA.addUpdateListener(new ag(this, alVar, i5, i7, i6, i8, view));
        valueAnimatorA.addListener(new ah(this, alVar, view));
        valueAnimatorA.setStartDelay(i4);
        valueAnimatorA.start();
        return true;
    }

    public boolean a(View view, int i, int i2, al alVar, boolean z) {
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).setTextVisibility(!this.af);
        }
        view.setScaleX(getChildrenScale());
        view.setScaleY(getChildrenScale());
        if (alVar.f109a < 0 || alVar.f109a > this.k - 1 || alVar.b < 0 || alVar.b > this.l - 1) {
            return false;
        }
        if (alVar.f < 0) {
            alVar.f = this.k;
        }
        if (alVar.g < 0) {
            alVar.g = this.l;
        }
        view.setId(i2);
        this.ae.addView(view, i, alVar);
        if (!z) {
            return true;
        }
        c(view);
        return true;
    }

    boolean a(int[] iArr, int i, int i2) {
        return a(iArr, i, i2, -1, -1, (View) null, this.b);
    }

    boolean a(int[] iArr, int i, int i2, int i3, int i4) {
        return a(iArr, i, i2, i3, i4, (View) null, this.b);
    }

    boolean a(int[] iArr, int i, int i2, int i3, int i4, View view, boolean[][] zArr) {
        int iMin;
        b(view, zArr);
        boolean z = false;
        while (true) {
            int iMax = i3 >= 0 ? Math.max(0, i3 - (i - 1)) : 0;
            int i5 = this.k - (i - 1);
            int iMin2 = i3 >= 0 ? Math.min(i5, (i == 1 ? 1 : 0) + i3 + (i - 1)) : i5;
            int iMax2 = i4 >= 0 ? Math.max(0, i4 - (i2 - 1)) : 0;
            int i6 = this.l - (i2 - 1);
            if (i4 >= 0) {
                iMin = Math.min(i6, (i2 == 1 ? 1 : 0) + i4 + (i2 - 1));
            } else {
                iMin = i6;
            }
            boolean z2 = z;
            for (int i7 = iMax2; i7 < iMin && !z2; i7++) {
                int i8 = iMax;
                while (i8 < iMin2) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= i) {
                            if (iArr != null) {
                                iArr[0] = i8;
                                iArr[1] = i7;
                            }
                            z2 = true;
                            break;
                        }
                        int i10 = 0;
                        while (true) {
                            if (i10 >= i2) {
                                i9++;
                            } else {
                                if (zArr[i8 + i9][i7 + i10]) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    }
                    i8 = i8 + i9 + 1;
                }
            }
            if (i3 == -1 && i4 == -1) {
                a(view, zArr);
                return z2;
            }
            i3 = -1;
            i4 = -1;
            z = z2;
        }
    }

    int[] a(int i, int i2, int i3, int i4, int i5, int i6, View view, boolean z, int[] iArr, int[] iArr2, boolean[][] zArr) {
        int i7;
        int i8;
        boolean z2;
        double d;
        int i9;
        boolean z3;
        int i10;
        boolean z4;
        b();
        b(view, zArr);
        int i11 = (int) (i - (((this.g + this.o) * (i5 - 1)) / 2.0f));
        int i12 = (int) (i2 - (((this.h + this.p) * (i6 - 1)) / 2.0f));
        if (iArr == null) {
            iArr = new int[2];
        }
        double d2 = Double.MAX_VALUE;
        Rect rect = new Rect(-1, -1, -1, -1);
        Stack stack = new Stack();
        int i13 = this.k;
        int i14 = this.l;
        if (i3 > 0 && i4 > 0 && i5 > 0 && i6 > 0 && i5 >= i3 && i6 >= i4) {
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= i14 - (i4 - 1)) {
                    break;
                }
                int i17 = 0;
                while (i17 < i13 - (i3 - 1)) {
                    if (z) {
                        int i18 = 0;
                        while (true) {
                            int i19 = i18;
                            if (i19 >= i3) {
                                boolean z5 = i3 >= i5;
                                boolean z6 = i4 >= i6;
                                boolean z7 = true;
                                int i20 = i4;
                                int i21 = i3;
                                while (true) {
                                    if (z5 && z6) {
                                        break;
                                    }
                                    if (z7 && !z5) {
                                        boolean z8 = z5;
                                        for (int i22 = 0; i22 < i20; i22++) {
                                            if (i17 + i21 > i13 - 1 || zArr[i17 + i21][i16 + i22]) {
                                                z8 = true;
                                            }
                                        }
                                        if (z8) {
                                            i10 = i20;
                                            z4 = z8;
                                            int i23 = i21;
                                            z3 = z6;
                                            i9 = i23;
                                        } else {
                                            int i24 = i21 + 1;
                                            i10 = i20;
                                            z4 = z8;
                                            z3 = z6;
                                            i9 = i24;
                                        }
                                    } else if (z6) {
                                        boolean z9 = z6;
                                        i9 = i21;
                                        z3 = z9;
                                        boolean z10 = z5;
                                        i10 = i20;
                                        z4 = z10;
                                    } else {
                                        boolean z11 = z6;
                                        for (int i25 = 0; i25 < i21; i25++) {
                                            if (i16 + i20 > i14 - 1 || zArr[i17 + i25][i16 + i20]) {
                                                z11 = true;
                                            }
                                        }
                                        if (z11) {
                                            i9 = i21;
                                            z3 = z11;
                                            boolean z12 = z5;
                                            i10 = i20;
                                            z4 = z12;
                                        } else {
                                            i9 = i21;
                                            z3 = z11;
                                            boolean z13 = z5;
                                            i10 = i20 + 1;
                                            z4 = z13;
                                        }
                                    }
                                    boolean z14 = z4 | (i9 >= i5);
                                    boolean z15 = z3 | (i10 >= i6);
                                    z7 = !z7;
                                    i20 = i10;
                                    z5 = z14;
                                    int i26 = i9;
                                    z6 = z15;
                                    i21 = i26;
                                }
                                if (i21 >= i5) {
                                }
                                if (i20 >= i6) {
                                }
                                i8 = i20;
                                i7 = i21;
                            } else {
                                int i27 = 0;
                                while (true) {
                                    if (i27 >= i4) {
                                        i18 = i19 + 1;
                                    } else if (zArr[i17 + i19][i16 + i27]) {
                                        d = d2;
                                    } else {
                                        i27++;
                                    }
                                }
                            }
                            i17++;
                            d2 = d;
                        }
                    } else {
                        i7 = -1;
                        i8 = -1;
                    }
                    int[] iArr3 = this.u;
                    c(i17, i16, iArr3);
                    Rect rect2 = (Rect) this.ap.pop();
                    rect2.set(i17, i16, i17 + i7, i16 + i8);
                    Iterator it = stack.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (((Rect) it.next()).contains(rect2)) {
                            z2 = true;
                            break;
                        }
                    }
                    stack.push(rect2);
                    double dSqrt = Math.sqrt(Math.pow(iArr3[1] - i12, 2.0d) + Math.pow(iArr3[0] - i11, 2.0d));
                    if ((dSqrt > d2 || z2) && !rect2.contains(rect)) {
                        d = d2;
                    } else {
                        iArr[0] = i17;
                        iArr[1] = i16;
                        if (iArr2 != null) {
                            iArr2[0] = i7;
                            iArr2[1] = i8;
                        }
                        rect.set(rect2);
                        d = dSqrt;
                    }
                    i17++;
                    d2 = d;
                }
                i15 = i16 + 1;
            }
            a(view, zArr);
            if (d2 == Double.MAX_VALUE) {
                iArr[0] = -1;
                iArr[1] = -1;
            }
            a(stack);
        }
        return iArr;
    }

    int[] a(int i, int i2, int i3, int i4, int i5, int i6, View view, int[] iArr, int[] iArr2) {
        return a(i, i2, i3, i4, i5, i6, view, true, iArr, iArr2, this.b);
    }

    int[] a(int i, int i2, int i3, int i4, int i5, int i6, View view, int[] iArr, int[] iArr2, int i7) {
        boolean z;
        int[] iArrC = c(i, i2, i5, i6, iArr);
        if (iArr2 == null) {
            iArr2 = new int[2];
        }
        if ((i7 == 1 || i7 == 2 || i7 == 3) && this.e[0] != -100) {
            this.ak[0] = this.e[0];
            this.ak[1] = this.e[1];
            if (i7 == 1 || i7 == 2) {
                this.e[0] = -100;
                this.e[1] = -100;
            }
        } else {
            c(i, i2, i5, i6, view, this.ak);
            this.e[0] = this.ak[0];
            this.e[1] = this.ak[1];
        }
        ak akVarA = a(i, i2, i3, i4, i5, i6, this.ak, view, true, new ak(this, null));
        ak akVarA2 = a(i, i2, i3, i4, i5, i6, view, new ak(this, null));
        if (akVarA.c && akVarA.c() >= akVarA2.c()) {
            akVarA2 = akVarA;
        } else if (!akVarA2.c) {
            akVarA2 = null;
        }
        setUseTempCoords(true);
        if (akVarA2 != null) {
            iArrC[0] = akVarA2.d;
            iArrC[1] = akVarA2.e;
            iArr2[0] = akVarA2.f;
            iArr2[1] = akVarA2.g;
            if (i7 == 0 || i7 == 1 || i7 == 2) {
                a(akVarA2, view);
                setItemPlacementDirty(true);
                a(akVarA2, view, i7 == 1);
                if (i7 == 1 || i7 == 2) {
                    m();
                    l();
                    setItemPlacementDirty(false);
                    z = true;
                } else {
                    a(akVarA2, view, 150);
                    z = true;
                }
            } else {
                z = true;
            }
        } else {
            z = false;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArrC[1] = -1;
            iArrC[0] = -1;
        }
        if (i7 == 1 || !z) {
            setUseTempCoords(false);
        }
        this.ae.requestLayout();
        return iArrC;
    }

    int[] a(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2) {
        return a(i, i2, i3, i4, i5, i6, null, iArr, iArr2);
    }

    int[] a(int i, int i2, int i3, int i4, View view, boolean z, int[] iArr) {
        return a(i, i2, i3, i4, i3, i4, view, z, iArr, (int[]) null, this.b);
    }

    public void b(int i, int i2) {
        this.k = i;
        this.l = i2;
        this.b = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.k, this.l);
        this.c = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.k, this.l);
        this.ap.clear();
        this.ae.a(this.g, this.h, this.o, this.p, this.k, this.l);
        requestLayout();
    }

    public void b(int i, int i2, int i3, int i4, Rect rect) {
        int i5 = this.g;
        int i6 = this.h;
        int i7 = this.o;
        int i8 = this.p;
        int i9 = (i3 * i5) + ((i3 - 1) * i7);
        int i10 = (i4 * i6) + ((i4 - 1) * i8);
        int paddingLeft = ((i5 + i7) * i) + getPaddingLeft();
        int paddingTop = ((i6 + i8) * i2) + getPaddingTop();
        rect.set(paddingLeft, paddingTop, paddingLeft + i9, paddingTop + i10);
    }

    void b(int i, int i2, int[] iArr) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        iArr[0] = paddingLeft + ((this.g + this.o) * i);
        iArr[1] = paddingTop + ((this.h + this.p) * i2);
    }

    void b(View view) {
        if (view != null) {
            ((al) view.getLayoutParams()).m = true;
            view.requestLayout();
        }
    }

    public void b(View view, boolean[][] zArr) {
        if (view == null || view.getParent() != this.ae) {
            return;
        }
        al alVar = (al) view.getLayoutParams();
        a(alVar.f109a, alVar.b, alVar.f, alVar.g, zArr, false);
    }

    public void b(da daVar) {
        if (this.y.contains(daVar)) {
            this.y.remove(daVar);
        }
        invalidate();
    }

    public boolean b(int[] iArr, int i, int i2) {
        return a(iArr, i, i2, this.k, this.l, this.b);
    }

    int[] b(int i, int i2, int i3, int i4, View view, int[] iArr) {
        return a(i, i2, i3, i4, view, true, iArr);
    }

    int[] b(int i, int i2, int i3, int i4, int[] iArr) {
        return b(i, i2, i3, i4, null, iArr);
    }

    public void c() {
        this.ae.buildLayer();
    }

    public void c(int i, int i2) {
        this.z[0] = i;
        this.z[1] = i2;
        invalidate();
    }

    void c(int i, int i2, int[] iArr) {
        a(i, i2, 1, 1, iArr);
    }

    public void c(View view) {
        a(view, this.b);
    }

    int[] c(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, (View) null, false, iArr);
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof al;
    }

    protected void d() {
        if (this.r) {
            setOverscrollTransformsDirty(false);
            setTranslationX(0.0f);
            setRotationY(0.0f);
            a(0.0f, false);
            setPivotX(getMeasuredWidth() / 2);
            setPivotY(getMeasuredHeight() / 2);
        }
    }

    public void d(int i, int i2) {
        boolean z;
        aj ajVar = this.t;
        Rect rect = this.s;
        int scrollX = i + getScrollX();
        int scrollY = i2 + getScrollY();
        int childCount = this.ae.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                z = false;
                break;
            }
            View childAt = this.ae.getChildAt(childCount);
            al alVar = (al) childAt.getLayoutParams();
            if ((childAt.getVisibility() == 0 || childAt.getAnimation() != null) && alVar.h) {
                childAt.getHitRect(rect);
                float scaleX = childAt.getScaleX();
                rect = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                rect.offset(getPaddingLeft(), getPaddingTop());
                rect.inset((int) ((rect.width() * (1.0f - scaleX)) / 2.0f), (int) (((1.0f - scaleX) * rect.height()) / 2.0f));
                if (rect.contains(scrollX, scrollY)) {
                    ajVar.f107a = childAt;
                    ajVar.b = alVar.f109a;
                    ajVar.c = alVar.b;
                    ajVar.d = alVar.f;
                    ajVar.e = alVar.g;
                    z = true;
                    break;
                }
            }
            childCount--;
            rect = rect;
        }
        this.w = z;
        if (!z) {
            int[] iArr = this.u;
            a(scrollX, scrollY, iArr);
            ajVar.f107a = null;
            ajVar.b = iArr[0];
            ajVar.c = iArr[1];
            ajVar.d = 1;
            ajVar.e = 1;
        }
        setTag(ajVar);
    }

    public void d(View view) {
        b(view, this.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.B > 0) {
            this.G.setBounds(this.K);
            this.G.draw(canvas);
        }
    }

    public void e() {
        this.z[0] = -1;
        this.z[1] = -1;
        invalidate();
    }

    public void e(int i, int i2) {
        this.M = i;
        this.N = i2;
    }

    public View f(int i, int i2) {
        return this.ae.a(i, i2);
    }

    public void f() {
        this.R[this.S].c();
        int[] iArr = this.ab;
        this.ab[1] = -1;
        iArr[0] = -1;
    }

    void g() {
        if (h()) {
            int childCount = this.ae.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ae.getChildAt(i);
                al alVar = (al) childAt.getLayoutParams();
                if (alVar.c != alVar.f109a || alVar.d != alVar.b) {
                    alVar.c = alVar.f109a;
                    alVar.d = alVar.b;
                    a(childAt, alVar.f109a, alVar.b, 150, 0, false, false);
                }
            }
            l();
            setItemPlacementDirty(false);
        }
    }

    public boolean g(int i, int i2) {
        if (i >= this.k || i2 >= this.l) {
            throw new RuntimeException("Position exceeds the bound of this CellLayout");
        }
        return this.b[i][i2];
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new al(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new al(layoutParams);
    }

    public float getBackgroundAlpha() {
        return this.C;
    }

    public float getBackgroundAlphaMultiplier() {
        return this.D;
    }

    int getCellHeight() {
        return this.h;
    }

    int getCellWidth() {
        return this.g;
    }

    public float getChildrenScale() {
        if (this.af) {
            return this.ag;
        }
        return 1.0f;
    }

    int getCountX() {
        return this.k;
    }

    int getCountY() {
        return this.l;
    }

    public int getDesiredHeight() {
        return getPaddingTop() + getPaddingBottom() + (this.l * this.h) + (Math.max(this.l - 1, 0) * this.p);
    }

    public int getDesiredWidth() {
        return getPaddingLeft() + getPaddingRight() + (this.k * this.g) + (Math.max(this.k - 1, 0) * this.o);
    }

    int getHeightGap() {
        return this.p;
    }

    boolean getIsDragOverlapping() {
        return this.O;
    }

    public mo getShortcutsAndWidgets() {
        if (getChildCount() > 0) {
            return (mo) getChildAt(0);
        }
        return null;
    }

    @Override // android.view.View
    public aj getTag() {
        return (aj) super.getTag();
    }

    int getWidthGap() {
        return this.o;
    }

    boolean h() {
        return this.aa;
    }

    void i() {
        this.al.a();
        this.ac = true;
    }

    void j() {
        this.al.c();
        if (this.ac) {
            this.ac = false;
        }
        int[] iArr = this.ab;
        this.ab[1] = -1;
        iArr[0] = -1;
        this.R[this.S].c();
        this.S = (this.S + 1) % this.R.length;
        g();
        setIsDragOverlapping(false);
    }

    public boolean k() {
        return this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof Workspace) {
            Workspace workspace = (Workspace) getParent();
            this.t.f = workspace.a(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.C > 0.0f) {
            Drawable drawable = this.d ? this.F : this.E;
            drawable.setAlpha((int) (this.C * this.D * 255.0f));
            drawable.setBounds(this.J);
            drawable.draw(canvas);
        }
        Paint paint = this.T;
        for (int i = 0; i < this.P.length; i++) {
            float f = this.Q[i];
            if (f > 0.0f) {
                this.am.set(this.P[i]);
                my.b(this.am, getChildrenScale());
                Bitmap bitmap = (Bitmap) this.R[i].d();
                paint.setAlpha((int) (f + 0.5f));
                canvas.drawBitmap(bitmap, (Rect) null, this.am, paint);
            }
        }
        if (this.U != null) {
            int pressedOrFocusedBackgroundPadding = this.U.getPressedOrFocusedBackgroundPadding();
            Bitmap pressedOrFocusedBackground = this.U.getPressedOrFocusedBackground();
            if (pressedOrFocusedBackground != null) {
                canvas.drawBitmap(pressedOrFocusedBackground, ((((int) Math.ceil((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.k * this.g)) / 2.0f)) + getPaddingLeft()) + this.U.getLeft()) - pressedOrFocusedBackgroundPadding, (getPaddingTop() + this.U.getTop()) - pressedOrFocusedBackgroundPadding, (Paint) null);
            }
        }
        int i2 = da.h;
        bl blVarA = ip.a().i().a();
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            da daVar = (da) this.y.get(i3);
            b(daVar.f171a, daVar.b, this.f73a);
            View viewF = f(daVar.f171a, daVar.b);
            if (viewF != null) {
                int i4 = this.f73a[0] + (this.g / 2);
                int paddingTop = viewF.getPaddingTop() + this.f73a[1] + (i2 / 2) + blVarA.y;
                Drawable drawable2 = da.f;
                int iC = (int) (daVar.c() * getChildrenScale());
                canvas.save();
                canvas.translate(i4 - (iC / 2), paddingTop - (iC / 2));
                drawable2.setBounds(0, 0, iC, iC);
                drawable2.draw(canvas);
                canvas.restore();
                Drawable drawable3 = da.g;
                int iD = (int) (daVar.d() * getChildrenScale());
                canvas.save();
                canvas.translate(i4 - (iD / 2), paddingTop - (iD / 2));
                drawable3.setBounds(0, 0, iD, iD);
                drawable3.draw(canvas);
                canvas.restore();
            }
        }
        if (this.z[0] < 0 || this.z[1] < 0) {
            return;
        }
        Drawable drawable4 = FolderIcon.f81a;
        int intrinsicWidth = drawable4.getIntrinsicWidth();
        int intrinsicHeight = drawable4.getIntrinsicHeight();
        b(this.z[0], this.z[1], this.f73a);
        View viewF2 = f(this.z[0], this.z[1]);
        if (viewF2 != null) {
            int i5 = this.f73a[0] + (this.g / 2);
            int paddingTop2 = (i2 / 2) + this.f73a[1] + viewF2.getPaddingTop() + blVarA.y;
            canvas.save();
            canvas.translate(i5 - (intrinsicWidth / 2), paddingTop2 - (intrinsicWidth / 2));
            drawable4.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable4.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a();
        }
        if (this.x != null && this.x.onTouch(this, motionEvent)) {
            return true;
        }
        if (action == 0) {
            d((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft() + ((int) Math.ceil((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.k * this.g)) / 2.0f));
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(paddingLeft, paddingTop, (paddingLeft + i3) - i, (paddingTop + i4) - i2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        bl blVarA = ip.a().i().a();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = size - (getPaddingLeft() + getPaddingRight());
        int paddingTop = size2 - (getPaddingTop() + getPaddingBottom());
        if (this.i < 0 || this.j < 0) {
            int iA = blVarA.a(paddingLeft, this.k);
            int iB = blVarA.b(paddingTop, this.l);
            if (iA != this.g || iB != this.h) {
                com.syu.g.i.a().a("mCellWidth = " + this.g + " mCellHeight = " + this.h);
                if (this.af) {
                    int iMax = Math.max(iA, iB);
                    this.h = iMax;
                    this.g = iMax;
                } else {
                    this.g = iA;
                    this.h = iB;
                }
                this.ae.a(this.g, this.h, this.o, this.p, this.k, this.l);
            }
        }
        if (this.M > 0 && this.N > 0) {
            int i5 = this.M;
            i3 = this.N;
            i4 = i5;
        } else {
            if (mode == 0 || mode2 == 0) {
                throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
            }
            i3 = paddingTop;
            i4 = paddingLeft;
        }
        int i6 = this.k - 1;
        int i7 = this.l - 1;
        if (this.m < 0 || this.n < 0) {
            int i8 = paddingLeft - (this.k * this.g);
            int i9 = paddingTop - (this.l * this.h);
            this.o = Math.min(this.q, i6 > 0 ? i8 / i6 : 0);
            this.p = Math.min(this.q, i7 > 0 ? i9 / i7 : 0);
            this.ae.a(this.g, this.h, this.o, this.p, this.k, this.l);
        } else {
            this.o = this.m;
            this.p = this.n;
        }
        int childCount = getChildCount();
        int iMax2 = 0;
        int iMax3 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
            iMax3 = Math.max(iMax3, childAt.getMeasuredHeight());
        }
        if (this.M <= 0 || this.N <= 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(iMax2, iMax3);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = new Rect();
        this.E.getPadding(rect);
        this.J.set(-rect.left, -rect.top, rect.right + i, rect.bottom + i2);
        this.K.set(this.L, this.L, i - this.L, i2 - this.L);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        n();
        this.ae.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        if (this.ae.getChildCount() > 0) {
            n();
            this.ae.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        d(view);
        this.ae.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        d(this.ae.getChildAt(i));
        this.ae.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        d(view);
        this.ae.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            d(this.ae.getChildAt(i3));
        }
        this.ae.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            d(this.ae.getChildAt(i3));
        }
        this.ae.removeViewsInLayout(i, i2);
    }

    public void setBackgroundAlpha(float f) {
        if (this.C != f) {
            this.C = f;
            invalidate();
        }
    }

    public void setBackgroundAlphaMultiplier(float f) {
        if (this.D != f) {
            this.D = f;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected void setChildrenDrawingCacheEnabled(boolean z) {
        this.ae.setChildrenDrawingCacheEnabled(z);
    }

    @Override // android.view.ViewGroup
    protected void setChildrenDrawnWithCacheEnabled(boolean z) {
        this.ae.setChildrenDrawnWithCacheEnabled(z);
    }

    public void setInvertIfRtl(boolean z) {
        this.ae.setInvertIfRtl(z);
    }

    void setIsDragOverlapping(boolean z) {
        if (this.O != z) {
            this.O = z;
            setUseActiveGlowBackground(this.O);
            invalidate();
        }
    }

    public void setIsHotseat(boolean z) {
        this.af = z;
        this.ae.setIsHotseat(z);
    }

    void setItemPlacementDirty(boolean z) {
        this.aa = z;
    }

    public void setOnInterceptTouchListener(View.OnTouchListener onTouchListener) {
        this.x = onTouchListener;
    }

    protected void setOverscrollTransformsDirty(boolean z) {
        this.r = z;
    }

    void setPressedOrFocusedIcon(BubbleTextView bubbleTextView) {
        BubbleTextView bubbleTextView2 = this.U;
        this.U = bubbleTextView;
        if (bubbleTextView2 != null) {
            a(bubbleTextView2);
        }
        if (this.U != null) {
            a(this.U);
        }
    }

    public void setShortcutAndWidgetAlpha(float f) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setAlpha(f);
        }
    }

    void setUseActiveGlowBackground(boolean z) {
        this.d = z;
    }

    public void setUseTempCoords(boolean z) {
        int childCount = this.ae.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((al) this.ae.getChildAt(i).getLayoutParams()).e = z;
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
