package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class e extends FrameLayout {
    private static Rect N = new Rect();
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private Launcher O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f192a;
    int[] b;
    int[] c;
    final int d;
    final int e;
    final float f;
    final float g;
    private is h;
    private CellLayout i;
    private DragLayer j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public e(Context context, is isVar, CellLayout cellLayout, DragLayer dragLayer) {
        super(context);
        this.L = 0;
        this.M = 0;
        this.f192a = new int[2];
        this.b = new int[2];
        this.c = new int[2];
        this.d = 150;
        this.e = 24;
        this.f = 0.0f;
        this.g = 0.66f;
        this.O = (Launcher) context;
        this.i = cellLayout;
        this.h = isVar;
        this.A = isVar.getAppWidgetInfo().resizeMode;
        this.j = dragLayer;
        int[] iArrB = Launcher.b(this.O, isVar.getAppWidgetInfo());
        this.D = iArrB[0];
        this.E = iArrB[1];
        setBackgroundResource(R.drawable.widget_resize_frame_holo);
        setPadding(0, 0, 0, 0);
        this.k = new ImageView(context);
        this.k.setImageResource(R.drawable.widget_resize_handle_left);
        addView(this.k, new FrameLayout.LayoutParams(-2, -2, 19));
        this.l = new ImageView(context);
        this.l.setImageResource(R.drawable.widget_resize_handle_right);
        addView(this.l, new FrameLayout.LayoutParams(-2, -2, 21));
        this.m = new ImageView(context);
        this.m.setImageResource(R.drawable.widget_resize_handle_top);
        addView(this.m, new FrameLayout.LayoutParams(-2, -2, 49));
        this.n = new ImageView(context);
        this.n.setImageResource(R.drawable.widget_resize_handle_bottom);
        addView(this.n, new FrameLayout.LayoutParams(-2, -2, 81));
        Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(context, isVar.getAppWidgetInfo().provider, null);
        this.s = defaultPaddingForWidget.left;
        this.u = defaultPaddingForWidget.top;
        this.t = defaultPaddingForWidget.right;
        this.v = defaultPaddingForWidget.bottom;
        if (this.A == 1) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else if (this.A == 2) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.J = (int) Math.ceil(this.O.getResources().getDisplayMetrics().density * 24.0f);
        this.K = this.J * 2;
        this.i.d(this.h);
    }

    static Rect a(Launcher launcher, int i, int i2, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        Rect rectA = Workspace.a(launcher, 0);
        Rect rectA2 = Workspace.a(launcher, 1);
        float f = launcher.getResources().getDisplayMetrics().density;
        int i3 = rectA.left;
        int i4 = rectA.top;
        int i5 = (int) (((i3 * i) + (rectA.right * (i - 1))) / f);
        rect.set((int) (((rectA2.left * i) + (rectA2.right * (i - 1))) / f), (int) (((rectA.bottom * (i2 - 1)) + (i4 * i2)) / f), i5, (int) (((rectA2.bottom * (i2 - 1)) + (rectA2.top * i2)) / f));
        return rect;
    }

    private void a(int i, int i2, boolean z) {
        b(i, i2);
        bw bwVar = (bw) getLayoutParams();
        if (this.o) {
            bwVar.f145a = this.y + this.F;
            bwVar.width = this.w - this.F;
        } else if (this.p) {
            bwVar.width = this.w + this.F;
        }
        if (this.q) {
            bwVar.b = this.z + this.G;
            bwVar.height = this.x - this.G;
        } else if (this.r) {
            bwVar.height = this.x + this.G;
        }
        b(z);
        requestLayout();
    }

    static void a(AppWidgetHostView appWidgetHostView, Launcher launcher, int i, int i2) {
        a(launcher, i, i2, N);
        appWidgetHostView.updateAppWidgetSize(null, N.left, N.top, N.right, N.bottom);
    }

    private void b(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int cellWidth = this.i.getCellWidth() + this.i.getWidthGap();
        int cellHeight = this.i.getCellHeight() + this.i.getHeightGap();
        int i10 = this.F + this.H;
        int i11 = this.G + this.I;
        float f = ((i10 * 1.0f) / cellWidth) - this.B;
        float f2 = ((1.0f * i11) / cellHeight) - this.C;
        int countX = this.i.getCountX();
        int countY = this.i.getCountY();
        int iRound = Math.abs(f) > 0.66f ? Math.round(f) : 0;
        int iRound2 = Math.abs(f2) > 0.66f ? Math.round(f2) : 0;
        if (!z && iRound == 0 && iRound2 == 0) {
            return;
        }
        al alVar = (al) this.h.getLayoutParams();
        int i12 = alVar.f;
        int i13 = alVar.g;
        int i14 = alVar.e ? alVar.c : alVar.f109a;
        int i15 = alVar.e ? alVar.d : alVar.b;
        if (this.o) {
            int iMin = Math.min(alVar.f - this.D, Math.max(-i14, iRound));
            int iMax = Math.max(-(alVar.f - this.D), Math.min(i14, iRound * (-1)));
            i = -iMax;
            i3 = iMin;
            i2 = iMax;
        } else if (this.p) {
            int iMax2 = Math.max(-(alVar.f - this.D), Math.min(countX - (i14 + i12), iRound));
            i = iMax2;
            i2 = iMax2;
            i3 = 0;
        } else {
            i = 0;
            i2 = iRound;
            i3 = 0;
        }
        if (this.q) {
            int iMin2 = Math.min(alVar.g - this.E, Math.max(-i15, iRound2));
            int iMax3 = Math.max(-(alVar.g - this.E), Math.min(i15, iRound2 * (-1)));
            i4 = -iMax3;
            i5 = iMin2;
            i6 = iMax3;
        } else if (this.r) {
            int iMax4 = Math.max(-(alVar.g - this.E), Math.min(countY - (i15 + i13), iRound2));
            i4 = iMax4;
            i6 = iMax4;
            i5 = 0;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = iRound2;
        }
        this.f192a[0] = 0;
        this.f192a[1] = 0;
        if (this.o || this.p) {
            i7 = i2 + i12;
            i8 = i3 + i14;
            if (i != 0) {
                this.f192a[0] = this.o ? -1 : 1;
            }
        } else {
            i8 = i14;
            i7 = i12;
        }
        if (this.q || this.r) {
            int i16 = i6 + i13;
            i15 += i5;
            if (i4 != 0) {
                this.f192a[1] = this.q ? -1 : 1;
            }
            i9 = i16;
        } else {
            i9 = i13;
        }
        if (!z && i4 == 0 && i == 0) {
            return;
        }
        if (z) {
            this.f192a[0] = this.b[0];
            this.f192a[1] = this.b[1];
        } else {
            this.b[0] = this.f192a[0];
            this.b[1] = this.f192a[1];
        }
        if (this.i.a(i8, i15, i7, i9, this.h, this.f192a, z)) {
            alVar.c = i8;
            alVar.d = i15;
            alVar.f = i7;
            alVar.g = i9;
            this.C += i4;
            this.B += i;
            if (!z) {
                a(this.h, this.O, i7, i9);
            }
        }
        this.h.requestLayout();
    }

    public void a() {
        b(true);
        requestLayout();
    }

    public void a(boolean z) {
        bw bwVar = (bw) getLayoutParams();
        int width = ((this.h.getWidth() + (this.J * 2)) - this.s) - this.t;
        int height = ((this.h.getHeight() + (this.J * 2)) - this.u) - this.v;
        this.c[0] = this.h.getLeft();
        this.c[1] = this.h.getTop();
        this.j.b(this.i.getShortcutsAndWidgets(), this.c);
        int i = (this.c[0] - this.J) + this.s;
        int i2 = (this.c[1] - this.J) + this.u;
        if (i2 < 0) {
            this.L = -i2;
        } else {
            this.L = 0;
        }
        if (i2 + height > this.j.getHeight()) {
            this.M = -((i2 + height) - this.j.getHeight());
        } else {
            this.M = 0;
        }
        if (!z) {
            bwVar.width = width;
            bwVar.height = height;
            bwVar.f145a = i;
            bwVar.b = i2;
            this.k.setAlpha(1.0f);
            this.l.setAlpha(1.0f);
            this.m.setAlpha(1.0f);
            this.n.setAlpha(1.0f);
            requestLayout();
            return;
        }
        ObjectAnimator objectAnimatorA = ik.a(bwVar, this, PropertyValuesHolder.ofInt("width", bwVar.width, width), PropertyValuesHolder.ofInt("height", bwVar.height, height), PropertyValuesHolder.ofInt("x", bwVar.f145a, i), PropertyValuesHolder.ofInt("y", bwVar.b, i2));
        ObjectAnimator objectAnimatorA2 = ik.a(this.k, "alpha", 1.0f);
        ObjectAnimator objectAnimatorA3 = ik.a(this.l, "alpha", 1.0f);
        ObjectAnimator objectAnimatorA4 = ik.a(this.m, "alpha", 1.0f);
        ObjectAnimator objectAnimatorA5 = ik.a(this.n, "alpha", 1.0f);
        objectAnimatorA.addUpdateListener(new g(this));
        AnimatorSet animatorSetB = ik.b();
        if (this.A == 2) {
            animatorSetB.playTogether(objectAnimatorA, objectAnimatorA4, objectAnimatorA5);
        } else if (this.A == 1) {
            animatorSetB.playTogether(objectAnimatorA, objectAnimatorA2, objectAnimatorA3);
        } else {
            animatorSetB.playTogether(objectAnimatorA, objectAnimatorA2, objectAnimatorA3, objectAnimatorA4, objectAnimatorA5);
        }
        animatorSetB.setDuration(150L);
        animatorSetB.start();
    }

    public boolean a(int i, int i2) {
        boolean z = (this.A & 1) != 0;
        boolean z2 = (this.A & 2) != 0;
        this.o = i < this.K && z;
        this.p = i > getWidth() - this.K && z;
        this.q = i2 < this.K + this.L && z2;
        this.r = i2 > (getHeight() - this.K) + this.M && z2;
        boolean z3 = this.o || this.p || this.q || this.r;
        this.w = getMeasuredWidth();
        this.x = getMeasuredHeight();
        this.y = getLeft();
        this.z = getTop();
        if (z3) {
            this.k.setAlpha(this.o ? 1.0f : 0.0f);
            this.l.setAlpha(this.p ? 1.0f : 0.0f);
            this.m.setAlpha(this.q ? 1.0f : 0.0f);
            this.n.setAlpha(this.r ? 1.0f : 0.0f);
        }
        return z3;
    }

    public void b() {
        int cellWidth = this.i.getCellWidth() + this.i.getWidthGap();
        int cellHeight = this.i.getCellHeight() + this.i.getHeightGap();
        this.H = cellWidth * this.B;
        this.I = this.C * cellHeight;
        this.F = 0;
        this.G = 0;
        post(new f(this));
    }

    public void b(int i, int i2) {
        if (this.o) {
            this.F = Math.max(-this.y, i);
            this.F = Math.min(this.w - (this.K * 2), this.F);
        } else if (this.p) {
            this.F = Math.min(this.j.getWidth() - (this.y + this.w), i);
            this.F = Math.max((-this.w) + (this.K * 2), this.F);
        }
        if (this.q) {
            this.G = Math.max(-this.z, i2);
            this.G = Math.min(this.x - (this.K * 2), this.G);
        } else if (this.r) {
            this.G = Math.min(this.j.getHeight() - (this.z + this.x), i2);
            this.G = Math.max((-this.x) + (this.K * 2), this.G);
        }
    }

    public void c(int i, int i2) {
        a(i, i2, false);
    }
}
