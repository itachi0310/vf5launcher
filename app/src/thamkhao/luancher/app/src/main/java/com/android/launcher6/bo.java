package com.android.launcher6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f138a = 0;
    public static int b = 1;
    private VelocityTracker C;
    protected int c;
    private Launcher d;
    private Handler e;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private cg l;
    private ce o;
    private IBinder p;
    private View q;
    private View r;
    private by s;
    private ce v;
    private InputMethodManager w;
    private Rect f = new Rect();
    private final int[] g = new int[2];
    private ArrayList m = new ArrayList();
    private ArrayList n = new ArrayList();
    private int t = 0;
    private bq u = new bq(this);
    private int[] x = new int[2];
    private long y = -1;
    private int z = 0;
    private int[] A = new int[2];
    private Rect B = new Rect();

    public bo(Launcher launcher) {
        Resources resources = launcher.getResources();
        this.d = launcher;
        this.e = new Handler();
        this.k = resources.getDimensionPixelSize(R.dimen.scroll_zone);
        this.C = VelocityTracker.obtain();
        this.c = (int) (resources.getInteger(R.integer.config_flingToDeleteMinVelocity) * resources.getDisplayMetrics().density);
    }

    private PointF a(bz bzVar) {
        if (this.o == null || !bzVar.d()) {
            return null;
        }
        this.C.computeCurrentVelocity(1000, ViewConfiguration.get(this.d).getScaledMaximumFlingVelocity());
        if (this.C.getYVelocity() >= this.c) {
            return null;
        }
        PointF pointF = new PointF(this.C.getXVelocity(), this.C.getYVelocity());
        PointF pointF2 = new PointF(0.0f, -1.0f);
        if (((float) Math.acos(((pointF.x * pointF2.x) + (pointF.y * pointF2.y)) / (pointF2.length() * pointF.length()))) <= Math.toRadians(35.0d)) {
            return pointF;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ce a(int i, int i2, int[] iArr) {
        Rect rect = this.f;
        ArrayList arrayList = this.m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) arrayList.get(size);
            if (ceVar.e_()) {
                ceVar.a(rect);
                this.l.f151a = i;
                this.l.b = i2;
                if (rect.contains(i, i2)) {
                    iArr[0] = i;
                    iArr[1] = i2;
                    this.d.f().c((View) ceVar, iArr);
                    return ceVar;
                }
            }
        }
        return null;
    }

    private void a(float f, float f2, PointF pointF) {
        boolean z;
        int[] iArr = this.g;
        this.l.f151a = iArr[0];
        this.l.b = iArr[1];
        if (this.v != null && this.o != this.v) {
            this.v.e(this.l);
        }
        this.o.c(this.l);
        this.l.e = true;
        this.o.e(this.l);
        if (this.o.a(this.l)) {
            this.o.a(this.l, this.l.f151a, this.l.b, pointF);
            z = true;
        } else {
            z = false;
        }
        this.l.h.a((View) this.o, this.l, true, z);
    }

    private void a(int i, int i2) {
        this.l.f.b(i, i2);
        int[] iArr = this.g;
        ce ceVarA = a(i, i2, iArr);
        this.l.f151a = iArr[0];
        this.l.b = iArr[1];
        d(ceVarA);
        this.z = (int) (((double) this.z) + Math.sqrt(Math.pow(this.x[0] - i, 2.0d) + Math.pow(this.x[1] - i2, 2.0d)));
        this.x[0] = i;
        this.x[1] = i2;
        b(i, i2);
    }

    private int[] a(float f, float f2) {
        this.d.f().getLocalVisibleRect(this.B);
        this.A[0] = (int) Math.max(this.B.left, Math.min(f, this.B.right - 1));
        this.A[1] = (int) Math.max(this.B.top, Math.min(f2, this.B.bottom - 1));
        return this.A;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(float f, float f2) {
        boolean z = true;
        int[] iArr = this.g;
        ce ceVarA = a((int) f, (int) f2, iArr);
        this.l.f151a = iArr[0];
        this.l.b = iArr[1];
        if (ceVarA != 0) {
            this.l.e = true;
            ceVarA.e(this.l);
            if (ceVarA.a(this.l)) {
                ceVarA.b(this.l);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.l.h.a((View) ceVarA, this.l, false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        int i3 = this.z < ViewConfiguration.get(this.d).getScaledWindowTouchSlop() ? 900 : HttpStatus.SC_INTERNAL_SERVER_ERROR;
        DragLayer dragLayerF = this.d.f();
        boolean z = dragLayerF.getLayoutDirection() == 1;
        int i4 = z ? 1 : 0;
        int i5 = z ? 0 : 1;
        if (i < this.k) {
            if (this.t == 0) {
                this.t = 1;
                if (this.s.a(i, i2, i4)) {
                    dragLayerF.a(i4);
                    this.u.a(i4);
                    this.e.postDelayed(this.u, i3);
                    return;
                }
                return;
            }
            return;
        }
        if (i <= this.q.getWidth() - this.k) {
            g();
            return;
        }
        if (this.t == 0) {
            this.t = 1;
            if (this.s.a(i, i2, i5)) {
                dragLayerF.a(i5);
                this.u.a(i5);
                this.e.postDelayed(this.u, i3);
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
    }

    private void d(ce ceVar) {
        if (ceVar != null) {
            if (this.v != ceVar) {
                if (this.v != null) {
                    this.v.e(this.l);
                }
                ceVar.c(this.l);
            }
            ceVar.d(this.l);
        } else if (this.v != null) {
            this.v.e(this.l);
        }
        this.v = ceVar;
    }

    private void f() {
        boolean z = false;
        if (this.h) {
            this.h = false;
            g();
            if (this.l.f != null) {
                z = this.l.k;
                if (!z) {
                    this.l.f.e();
                }
                this.l.f = null;
            }
            if (!z) {
                Iterator it = this.n.iterator();
                while (it.hasNext()) {
                    ((bp) it.next()).b();
                }
            }
        }
        h();
    }

    private void g() {
        this.e.removeCallbacks(this.u);
        if (this.t == 1) {
            this.t = 0;
            this.u.a(1);
            this.s.i();
            this.d.f().c();
        }
    }

    private void h() {
        if (this.C != null) {
            this.C.recycle();
            this.C = null;
        }
    }

    public void a(Bitmap bitmap, int i, int i2, bz bzVar, Object obj, int i3, Point point, Rect rect, float f) {
        if (this.w == null) {
            this.w = (InputMethodManager) this.d.getSystemService("input_method");
        }
        this.w.hideSoftInputFromWindow(this.p, 0);
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            ((bp) it.next()).a(bzVar, obj, i3);
        }
        int i4 = this.i - i;
        int i5 = this.j - i2;
        int i6 = rect == null ? 0 : rect.left;
        int i7 = rect == null ? 0 : rect.top;
        this.h = true;
        this.l = new cg();
        this.l.e = false;
        this.l.c = this.i - (i6 + i);
        this.l.d = this.j - (i7 + i2);
        this.l.h = bzVar;
        this.l.g = obj;
        cg cgVar = this.l;
        ca caVar = new ca(this.d, bitmap, i4, i5, 0, 0, bitmap.getWidth(), bitmap.getHeight(), f);
        cgVar.f = caVar;
        if (point != null) {
            caVar.setDragVisualizeOffset(new Point(point));
        }
        if (rect != null) {
            caVar.setDragRegion(new Rect(rect));
        }
        this.d.f().performHapticFeedback(0);
        caVar.a(this.i, this.j);
        a(this.i, this.j);
    }

    public void a(IBinder iBinder) {
        this.p = iBinder;
    }

    void a(View view) {
        this.r = view;
    }

    public void a(View view, Bitmap bitmap, bz bzVar, Object obj, int i, Point point, float f) {
        int[] iArr = this.g;
        this.d.f().a(view, iArr);
        a(bitmap, ((int) (((bitmap.getWidth() * f) - bitmap.getWidth()) / 2.0f)) + (point != null ? point.x : 0) + iArr[0] + view.getPaddingLeft(), (point != null ? point.y : 0) + iArr[1] + view.getPaddingTop() + ((int) (((bitmap.getHeight() * f) - bitmap.getHeight()) / 2.0f)), bzVar, obj, i, null, null, f);
        if (i == f138a) {
            view.setVisibility(8);
        }
    }

    public void a(bp bpVar) {
        this.n.add(bpVar);
    }

    public void a(by byVar) {
        this.s = byVar;
    }

    void a(ca caVar) {
        caVar.e();
        if (this.l.k) {
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ((bp) it.next()).b();
            }
        }
    }

    public void a(ce ceVar) {
        this.m.add(ceVar);
    }

    void a(cg cgVar) {
        cgVar.h.c();
    }

    public void a(ArrayList arrayList, Context context) {
        if (this.l != null) {
            Object obj = this.l.g;
            if (obj instanceof mp) {
                mp mpVar = (mp) obj;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (mpVar != null && mpVar.f396a != null && mpVar.f396a.getComponent().equals(dVar.d)) {
                        b();
                        return;
                    }
                }
            }
        }
    }

    public boolean a() {
        return this.h;
    }

    public boolean a(KeyEvent keyEvent) {
        return this.h;
    }

    public boolean a(MotionEvent motionEvent) {
        c(motionEvent);
        int action = motionEvent.getAction();
        int[] iArrA = a(motionEvent.getX(), motionEvent.getY());
        int i = iArrA[0];
        int i2 = iArrA[1];
        switch (action) {
            case 0:
                this.i = i;
                this.j = i2;
                this.v = null;
                break;
            case 1:
                this.y = System.currentTimeMillis();
                if (this.h) {
                    PointF pointFA = DeleteDropTarget.a(this.l.g) ? a(this.l.h) : null;
                    if (pointFA != null) {
                        a(i, i2, pointFA);
                    } else {
                        b(i, i2);
                    }
                }
                f();
                break;
            case 3:
                b();
                break;
        }
        return this.h;
    }

    public boolean a(View view, int i) {
        return this.r != null && this.r.dispatchUnhandledMove(view, i);
    }

    public void b() {
        if (this.h) {
            if (this.v != null) {
                this.v.e(this.l);
            }
            this.l.k = false;
            this.l.j = true;
            this.l.e = true;
            this.l.h.a(null, this.l, false, false);
        }
        f();
    }

    public void b(View view) {
        this.q = view;
    }

    public void b(ce ceVar) {
        this.m.remove(ceVar);
    }

    public boolean b(MotionEvent motionEvent) {
        if (!this.h) {
            return false;
        }
        c(motionEvent);
        int action = motionEvent.getAction();
        int[] iArrA = a(motionEvent.getX(), motionEvent.getY());
        int i = iArrA[0];
        int i2 = iArrA[1];
        switch (action) {
            case 0:
                this.i = i;
                this.j = i2;
                if (i < this.k || i > this.q.getWidth() - this.k) {
                    this.t = 1;
                    this.e.postDelayed(this.u, 500L);
                } else {
                    this.t = 0;
                }
                a(i, i2);
                break;
            case 1:
                a(i, i2);
                this.e.removeCallbacks(this.u);
                if (this.h) {
                    PointF pointFA = a(this.l.h);
                    if (!DeleteDropTarget.a(this.l.g)) {
                        pointFA = null;
                    }
                    if (pointFA != null) {
                        a(i, i2, pointFA);
                    } else {
                        b(i, i2);
                    }
                }
                f();
                break;
            case 2:
                a(i, i2);
                break;
            case 3:
                this.e.removeCallbacks(this.u);
                b();
                break;
        }
        return true;
    }

    long c() {
        return this.h ? System.currentTimeMillis() : this.y;
    }

    public void c(ce ceVar) {
        this.o = ceVar;
    }

    void d() {
        this.y = -1L;
    }

    public void e() {
        int[] iArr = this.g;
        ce ceVarA = a(this.x[0], this.x[1], iArr);
        this.l.f151a = iArr[0];
        this.l.b = iArr[1];
        d(ceVarA);
    }
}
