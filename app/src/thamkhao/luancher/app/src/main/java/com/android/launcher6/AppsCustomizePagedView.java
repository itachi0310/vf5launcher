package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class AppsCustomizePagedView extends mb implements View.OnClickListener, View.OnKeyListener, bz, ks, ly, ma {
    private static float aP = 6500.0f;
    private static float aQ = 0.74f;
    private static float aR = 0.65f;
    private static float aS = 22.0f;
    public static boolean b = LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_all_disable);
    private static String[] bf = {"com.syu.widget.DateTimeProvider", "com.syu.music.MAppWidget"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    pd f70a;
    private ArrayList aA;
    private boolean aB;
    private int aC;
    private int aD;
    private Canvas aE;
    private dv aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;
    private int aL;
    private lt aM;
    private int aN;
    private int aO;
    private AccelerateInterpolator aT;
    private DecelerateInterpolator aU;
    private Runnable aV;
    private Runnable aW;
    private boolean aX;
    private Toast aY;
    private boolean aZ;
    private q ar;
    private Launcher as;
    private bo at;
    private final LayoutInflater au;
    private final PackageManager av;
    private Handler aw;
    private int ax;
    private PagedViewIcon ay;
    private ArrayList az;
    private ArrayList ba;
    private ArrayList bb;
    private Rect bc;
    private boolean bd;
    private boolean be;
    ArrayList c;
    int d;
    int e;
    mf f;
    aa g;
    mc h;
    ad i;
    ad j;
    mj k;
    mj l;
    mc m;
    ob n;

    public AppsCustomizePagedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ar = q.Applications;
        this.aw = new Handler(Looper.getMainLooper());
        this.ax = -1;
        this.f70a = new pd(0.5f);
        this.aT = new AccelerateInterpolator(0.9f);
        this.aU = new DecelerateInterpolator(4.0f);
        this.aV = null;
        this.aW = null;
        this.d = -1;
        this.e = -1;
        this.f = null;
        this.aX = false;
        this.ba = new ArrayList();
        this.bb = new ArrayList();
        this.bc = new Rect();
        this.g = new aa();
        this.h = new mc();
        this.i = new ad();
        this.j = new ad();
        this.k = new mj();
        this.l = new mj();
        this.m = new mc();
        this.au = LayoutInflater.from(context);
        this.av = context.getPackageManager();
        this.az = new ArrayList();
        this.aA = new ArrayList();
        this.aF = ip.a().d();
        this.aE = new Canvas();
        this.c = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.AppsCustomizePagedView, 0, 0);
        int i = ip.a().i().a().o;
        this.aL = i;
        this.aK = i;
        this.aI = typedArrayObtainStyledAttributes.getInt(4, 2);
        this.aJ = typedArrayObtainStyledAttributes.getInt(5, 2);
        this.aC = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.aD = typedArrayObtainStyledAttributes.getInt(7, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.aM = new lt(getContext());
        this.ae = false;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setClipChildren(false);
    }

    private void N() {
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.iswidgetpages)) {
            this.aO = (int) Math.ceil(this.aA.size() / (this.aI * this.aJ));
        } else {
            this.aO = 0;
        }
        this.aN = (int) Math.ceil(this.az.size() / (this.Q * this.R));
    }

    private void O() {
        if (this.bd) {
            this.be = true;
            return;
        }
        N();
        R();
        this.be = false;
    }

    private void P() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            hVar.cancel(false);
            it.remove();
            this.ac.set(hVar.b, true);
            View viewC = c(hVar.b);
            if (viewC instanceof lw) {
                ((lw) viewC).a();
            }
        }
        this.ba.clear();
        this.bb.clear();
    }

    private void Q() {
        int childCount = getChildCount();
        b(this.V);
        int i = this.V[0];
        int i2 = this.V[1];
        int i3 = -1;
        if (i != i2) {
            i3 = i + 1;
        } else if (i2 < childCount - 1) {
            i3 = i2 + 1;
            i2 = i3;
        } else if (i > 0) {
            i3 = i - 1;
            i = i3;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View viewC = c(i4);
            if (i > i4 || i4 > i2 || (i4 != i3 && !e(viewC))) {
                viewC.setLayerType(0, null);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View viewC2 = c(i5);
            if (i <= i5 && i5 <= i2 && ((i5 == i3 || e(viewC2)) && viewC2.getLayerType() != 2)) {
                viewC2.setLayerType(2, null);
            }
        }
    }

    private void R() {
        if (!o()) {
            requestLayout();
        } else {
            P();
            H();
        }
    }

    private int a(List list, d dVar) {
        ComponentName component = dVar.f170a.getComponent();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((d) list.get(i)).f170a.getComponent().equals(component)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList arrayList, int i2, int i3, int i4) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            int i5 = hVar.b;
            if (i5 < f(this.v) || i5 > g(this.v)) {
                hVar.cancel(false);
                it.remove();
            } else {
                hVar.a(t(i5));
            }
        }
        y yVar = new y(i, arrayList, i2, i3, new n(this, u(i)), new o(this), this.n);
        h hVar2 = new h(i, z.LoadWidgetPreviewData);
        hVar2.a(t(i));
        hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, yVar);
        this.c.add(hVar2);
    }

    private void a(View view, boolean z, boolean z2) {
        if (z || !z2 || (view != this.as.I() && !(view instanceof DeleteDropTarget))) {
            this.as.L();
        }
        this.as.l(false);
    }

    private void a(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, y yVar) {
        if (hVar != null) {
            hVar.a();
        }
        ArrayList arrayList = yVar.b;
        ArrayList arrayList2 = yVar.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (hVar != null) {
                if (hVar.isCancelled()) {
                    return;
                } else {
                    hVar.a();
                }
            }
            arrayList2.add(this.n.a(arrayList.get(i)));
        }
    }

    private void a(mf mfVar) {
        AppWidgetProviderInfo appWidgetProviderInfo = mfVar.u;
        Bundle bundleA = a(this.as, mfVar);
        if (appWidgetProviderInfo.configure != null) {
            mfVar.w = bundleA;
            return;
        }
        this.d = 0;
        this.aW = new k(this, bundleA, mfVar);
        post(this.aW);
        this.aV = new l(this, appWidgetProviderInfo, mfVar);
        post(this.aV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        if (this.aZ) {
            this.ba.add(yVar);
            return;
        }
        try {
            lw lwVar = (lw) c(yVar.f467a);
            int size = yVar.b.size();
            for (int i = 0; i < size; i++) {
                PagedViewWidget pagedViewWidget = (PagedViewWidget) lwVar.getChildAt(i);
                if (pagedViewWidget != null) {
                    pagedViewWidget.a(new ci((Bitmap) yVar.c.get(i)), i);
                }
            }
            Q();
            for (h hVar : this.c) {
                hVar.a(t(hVar.b));
            }
        } finally {
            yVar.a(false);
        }
    }

    private boolean a(String str) {
        for (int i = 0; i < bf.length; i++) {
            if (str.contains(bf[i])) {
                return true;
            }
        }
        return false;
    }

    private void b(boolean z) {
        if (!z) {
            mf mfVar = this.f;
            this.f = null;
            if (this.d == 0) {
                removeCallbacks(this.aW);
                removeCallbacks(this.aV);
            } else if (this.d == 1) {
                if (this.e != -1) {
                    this.as.q().deleteAppWidgetId(this.e);
                }
                removeCallbacks(this.aV);
            } else if (this.d == 2) {
                if (this.e != -1) {
                    this.as.q().deleteAppWidgetId(this.e);
                }
                this.as.f().removeView(mfVar.v);
            }
        }
        this.d = -1;
        this.e = -1;
        this.f = null;
        PagedViewWidget.a();
    }

    private void e(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            int iBinarySearch = Collections.binarySearch(this.az, dVar, iv.i());
            if (iBinarySearch < 0) {
                this.az.add(-(iBinarySearch + 1), dVar);
            }
        }
    }

    private void f(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int iA = a(this.az, (d) arrayList.get(i));
            if (iA > -1) {
                this.az.remove(iA);
            }
        }
    }

    private int getMiddleComponentIndexOnCurrentPage() {
        if (getPageCount() > 0) {
            int currentPage = getCurrentPage();
            if (ip.f310a) {
                if (this.ar == q.Applications) {
                    mo shortcutsAndWidgets = ((i) c(currentPage)).getShortcutsAndWidgets();
                    int i = this.Q * this.R;
                    int childCount = shortcutsAndWidgets.getChildCount();
                    if (childCount > 0) {
                        return (childCount / 2) + (currentPage * i);
                    }
                } else {
                    if (this.ar != q.Widgets) {
                        throw new RuntimeException("Invalid ContentType");
                    }
                    int size = this.az.size();
                    lw lwVar = (lw) c(currentPage);
                    int i2 = this.aI * this.aJ;
                    int childCount2 = lwVar.getChildCount();
                    if (childCount2 > 0) {
                        return (childCount2 / 2) + (currentPage * i2) + size;
                    }
                }
            } else if (currentPage < this.aN) {
                mo shortcutsAndWidgets2 = ((i) c(currentPage)).getShortcutsAndWidgets();
                int i3 = this.Q * this.R;
                int childCount3 = shortcutsAndWidgets2.getChildCount();
                if (childCount3 > 0) {
                    return (childCount3 / 2) + (currentPage * i3);
                }
            } else {
                int size2 = this.az.size();
                lw lwVar2 = (lw) c(currentPage);
                int i4 = this.aI * this.aJ;
                int childCount4 = lwVar2.getChildCount();
                if (childCount4 > 0) {
                    return (childCount4 / 2) + ((currentPage - this.aN) * i4) + size2;
                }
            }
        }
        return -1;
    }

    private AppsCustomizeTabHost getTabHost() {
        return (AppsCustomizeTabHost) this.as.findViewById(R.id.apps_customize_pane);
    }

    private void h(View view) {
        this.as.I().a(view);
        this.as.I().a(view, this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean i(View view) {
        Bitmap bitmapA;
        md mdVar;
        Point point;
        this.aX = true;
        ImageView imageView = (ImageView) view.findViewById(R.id.widget_preview);
        md mdVar2 = (md) view.getTag();
        if (imageView.getDrawable() == null) {
            this.aX = false;
            return false;
        }
        float width = 1.0f;
        if (!(mdVar2 instanceof mf)) {
            Drawable drawableA = this.aF.a(((me) view.getTag()).b);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.aE.setBitmap(bitmapCreateBitmap);
            this.aE.save();
            ob.a(drawableA, bitmapCreateBitmap, 0, 0, drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight());
            this.aE.restore();
            this.aE.setBitmap(null);
            mdVar2.m = 1;
            mdVar2.l = 1;
            bitmapA = bitmapCreateBitmap;
            mdVar = mdVar2;
            point = null;
        } else {
            if (this.f == null) {
                return false;
            }
            mf mfVar = this.f;
            int i = mfVar.l;
            int i2 = mfVar.m;
            int[] iArrA = this.as.I().a(i, i2, (ec) mfVar, true);
            ci ciVar = (ci) imageView.getDrawable();
            int[] iArr = new int[1];
            bitmapA = this.n.a(mfVar.f390a, mfVar.s, mfVar.t, i, i2, Math.min((int) (ciVar.getIntrinsicWidth() * 1.25f), iArrA[0]), Math.min((int) (1.25f * ciVar.getIntrinsicHeight()), iArrA[1]), null, iArr);
            int iMin = Math.min(iArr[0], this.n.a(i));
            width = iMin / bitmapA.getWidth();
            if (iMin < ciVar.getIntrinsicWidth()) {
                point = new Point((ciVar.getIntrinsicWidth() - iMin) / 2, 0);
                mdVar = mfVar;
            } else {
                point = null;
                mdVar = mfVar;
            }
        }
        boolean z = ((mdVar instanceof mf) && ((mf) mdVar).s == 0) ? false : true;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, bitmapA.getWidth(), bitmapA.getHeight(), false);
        this.as.U();
        this.as.I().a(mdVar, bitmapCreateScaledBitmap, z);
        this.at.a(imageView, bitmapA, this, mdVar, bo.b, point, width);
        bitmapCreateScaledBitmap.recycle();
        bitmapA.recycle();
        return true;
    }

    private void r(int i) {
        String currentTabTag;
        AppsCustomizeTabHost tabHost = getTabHost();
        if (tabHost == null || (currentTabTag = tabHost.getCurrentTabTag()) == null) {
            return;
        }
        if (i >= this.aN && !currentTabTag.equals(tabHost.a(q.Widgets))) {
            tabHost.setCurrentTabFromContent(q.Widgets);
        } else {
            if (i >= this.aN || currentTabTag.equals(tabHost.a(q.Applications))) {
                return;
            }
            tabHost.setCurrentTabFromContent(q.Applications);
        }
    }

    private int s(int i) {
        int i2 = this.y > -1 ? this.y : this.v;
        Iterator it = this.c.iterator();
        int iAbs = Integer.MAX_VALUE;
        while (it.hasNext()) {
            iAbs = Math.abs(((h) it.next()).b - i2);
        }
        int iAbs2 = Math.abs(i - i2);
        return iAbs2 - Math.min(iAbs2, iAbs);
    }

    private void setupPage(i iVar) {
        iVar.b(this.Q, this.R);
        a((ViewGroup) iVar, 8);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.aG, ExploreByTouchHelper.INVALID_ID);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aH, ExploreByTouchHelper.INVALID_ID);
        iVar.setMinimumWidth(getPageContentWidth());
        iVar.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        a((ViewGroup) iVar, 0);
    }

    private void setupPage(lw lwVar) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.aG, ExploreByTouchHelper.INVALID_ID);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.aH, ExploreByTouchHelper.INVALID_ID);
        lwVar.setMinimumWidth(getPageContentWidth());
        lwVar.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    private int t(int i) {
        int iS = s(i);
        if (iS <= 0) {
            return 1;
        }
        return iS <= 1 ? 19 : 19;
    }

    private int u(int i) {
        return Math.max(0, s(i) * HttpStatus.SC_OK);
    }

    int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (ip.f310a) {
            if (i < this.az.size()) {
                return i / (this.Q * this.R);
            }
            return (i - this.az.size()) / (this.aI * this.aJ);
        }
        if (i < this.az.size()) {
            return i / (this.Q * this.R);
        }
        int i2 = this.aI * this.aJ;
        if (b) {
            return (i - this.az.size()) / i2;
        }
        return ((i - this.az.size()) / i2) + this.aN;
    }

    Bundle a(Launcher launcher, mf mfVar) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        e.a(this.as, mfVar.l, mfVar.m, this.bc);
        Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(this.as, mfVar.f390a, null);
        float f = getResources().getDisplayMetrics().density;
        int i = (int) ((defaultPaddingForWidget.left + defaultPaddingForWidget.right) / f);
        int i2 = (int) ((defaultPaddingForWidget.bottom + defaultPaddingForWidget.top) / f);
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMinWidth", this.bc.left - i);
        bundle.putInt("appWidgetMinHeight", this.bc.top - i2);
        bundle.putInt("appWidgetMaxWidth", this.bc.right - i);
        bundle.putInt("appWidgetMaxHeight", this.bc.bottom - i2);
        return bundle;
    }

    @Override // com.android.launcher6.li
    protected void a() {
        super.a();
        this.S = false;
        setDragSlopeThreshold(getContext().getResources().getInteger(R.integer.config_appsCustomizeDragSlopeThreshold) / 100.0f);
    }

    @Override // com.android.launcher6.li
    protected void a(float f) {
        b(f);
    }

    protected void a(int i, int i2) {
        if (this.n == null) {
            this.n = new ob(this.as);
        }
        bl blVarA = ip.a().i().a();
        this.aM.setPadding(this.M, this.K, this.N, this.L);
        this.Q = blVarA.I;
        this.R = blVarA.H;
        N();
        this.aG = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.aH = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        Log.i("hy", "mContentWidth1111111:" + getMeasuredWidth() + "mContentHeight:" + getMeasuredHeight());
        this.aM.measure(View.MeasureSpec.makeMeasureSpec(this.aG, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(this.aH, ExploreByTouchHelper.INVALID_ID));
        boolean zD = getTabHost().d();
        e(Math.max(0, a(this.ax)), zD);
        if (zD) {
            return;
        }
        post(new j(this));
    }

    public void a(int i, boolean z) {
        boolean zM = m();
        int i2 = this.Q * this.R;
        int i3 = i * i2;
        int iMin = Math.min(i2 + i3, this.az.size());
        i iVar = (i) c(i);
        iVar.a();
        for (int i4 = i3; i4 < iMin; i4++) {
            d dVar = (d) this.az.get(i4);
            PagedViewIcon pagedViewIcon = (PagedViewIcon) this.au.inflate(R.layout.apps_customize_application, (ViewGroup) iVar, false);
            pagedViewIcon.a(dVar, true, this);
            pagedViewIcon.setOnClickListener(this);
            pagedViewIcon.setOnLongClickListener(this);
            pagedViewIcon.setOnTouchListener(this);
            pagedViewIcon.setOnKeyListener(this);
            int i5 = i4 - i3;
            int i6 = i5 % this.Q;
            int i7 = i5 / this.Q;
            if (zM) {
                i6 = (this.Q - i6) - 1;
            }
            iVar.a((View) pagedViewIcon, -1, i4, new al(i6, i7, 1, 1), false);
        }
        Q();
    }

    @Override // com.android.launcher6.mb
    protected void a(MotionEvent motionEvent) {
    }

    @Override // com.android.launcher6.ma
    public void a(View view) {
        if (this.f != null) {
            b(false);
        }
        this.f = new mf((mf) view.getTag());
        a(this.f);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    @Override // com.android.launcher6.bz
    public void a(View view, cg cgVar, boolean z, boolean z2) {
        boolean z3;
        if (z) {
            return;
        }
        a(view, false, z2);
        if (!z2) {
            if (view instanceof Workspace) {
                CellLayout cellLayout = (CellLayout) ((Workspace) view).getChildAt(this.as.Q());
                ec ecVar = (ec) cgVar.g;
                if (cellLayout != null) {
                    cellLayout.a(ecVar);
                    z3 = !cellLayout.a((int[]) null, ecVar.l, ecVar.m);
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            if (z3) {
                this.as.a(false);
            }
            cgVar.k = false;
        }
        b(z2);
        this.aX = false;
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, float f) {
    }

    public void a(Launcher launcher, bo boVar) {
        this.as = launcher;
        this.at = boVar;
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, boolean z, boolean z2) {
        this.aZ = true;
        if (z2) {
            P();
        }
    }

    @Override // com.android.launcher6.ly
    public void a(PagedViewIcon pagedViewIcon) {
        if (this.ay != null) {
            this.ay.b();
        }
        this.ay = pagedViewIcon;
    }

    public void a(ArrayList arrayList) {
        ip ipVarA = ip.a();
        bl blVarA = ipVarA.i().a();
        this.aA.clear();
        for (Object obj : arrayList) {
            if (obj instanceof AppWidgetProviderInfo) {
                AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) obj;
                if (ipVarA.a(appWidgetProviderInfo.provider) && !a(appWidgetProviderInfo.provider.getClassName()) && (a.a.b != 8 || (!appWidgetProviderInfo.provider.getPackageName().contains("antutu") && !appWidgetProviderInfo.provider.getPackageName().contains("ludashi")))) {
                    appWidgetProviderInfo.label = appWidgetProviderInfo.label.trim();
                    if (appWidgetProviderInfo.minWidth > 0 && appWidgetProviderInfo.minHeight > 0) {
                        int[] iArrA = Launcher.a(this.as, appWidgetProviderInfo);
                        int[] iArrB = Launcher.b(this.as, appWidgetProviderInfo);
                        int iMin = Math.min(iArrA[0], iArrB[0]);
                        int iMin2 = Math.min(iArrA[1], iArrB[1]);
                        if (iMin <= ((int) blVarA.e) && iMin2 <= ((int) blVarA.d)) {
                            Boolean bool = true;
                            if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_design) && appWidgetProviderInfo.provider.getPackageName() != null && appWidgetProviderInfo.provider.getPackageName().contains("com.android.launcher")) {
                                bool = false;
                            }
                            if (bool.booleanValue()) {
                                if (appWidgetProviderInfo.provider.getPackageName().contains("com.android.launcher")) {
                                    if (appWidgetProviderInfo.provider.getPackageName().contains("com.android.launcher" + LauncherApplication.f88a.getResources().getInteger(R.integer.apps_launcher_packagename))) {
                                        this.aA.add(appWidgetProviderInfo);
                                    }
                                } else {
                                    this.aA.add(appWidgetProviderInfo);
                                }
                            }
                        }
                    }
                }
            }
        }
        O();
    }

    @Override // com.android.launcher6.li
    protected void a_(int i, int i2, int i3) {
        super.a_(i, i2, i3);
        r(i);
        for (h hVar : this.c) {
            int i4 = hVar.b;
            if ((this.y <= this.v || i4 < this.v) && (this.y >= this.v || i4 > this.v)) {
                hVar.a(19);
            } else {
                hVar.a(t(i4));
            }
        }
    }

    void b() {
        if (this.aB || !o()) {
            return;
        }
        this.aB = true;
        int[] iArr = new int[2];
        int[] iArrA = this.aM.a(this.aC, this.aD);
        this.as.f().a(this, iArr);
        iArrA[0] = iArrA[0] + ((getMeasuredWidth() - this.aM.getMeasuredWidth()) / 2) + iArr[0];
        iArrA[1] = (iArr[1] - this.as.f().getPaddingTop()) + iArrA[1];
    }

    void b(int i) {
        if (i < 0) {
            return;
        }
        this.ax = i;
    }

    public void b(int i, boolean z) {
        int i2 = this.aI * this.aJ;
        ArrayList arrayList = new ArrayList();
        int i3 = (((this.aG - this.M) - this.N) - ((this.aI - 1) * this.aK)) / this.aI;
        int i4 = (((this.aH - this.K) - this.L) - ((this.aJ - 1) * this.aL)) / this.aJ;
        Log.e("lxx", " mNumAppsPages = " + this.aN + " mNumWidgetPages = " + this.aO + " LauncherAppState.appsWidgetsDetach = " + ip.f310a);
        int i5 = ip.f310a ? i * i2 : (i - this.aN) * i2;
        for (int i6 = i5; i6 < Math.min(i5 + i2, this.aA.size()); i6++) {
            arrayList.add(this.aA.get(i6));
        }
        lw lwVar = (lw) c(i);
        lwVar.setColumnCount(lwVar.getCellCountX());
        com.syu.g.i.a().a("mWidgets size == " + arrayList.size());
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= arrayList.size()) {
                lwVar.setOnLayoutListener(new p(this, i3, i4, lwVar, z, i, arrayList));
                return;
            }
            Object obj = arrayList.get(i8);
            PagedViewWidget pagedViewWidget = (PagedViewWidget) this.au.inflate(R.layout.apps_customize_widget, (ViewGroup) lwVar, false);
            if (obj instanceof AppWidgetProviderInfo) {
                AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) obj;
                mf mfVar = new mf(appWidgetProviderInfo, null, null);
                int[] iArrA = Launcher.a(this.as, appWidgetProviderInfo);
                mfVar.l = iArrA[0];
                mfVar.m = iArrA[1];
                int[] iArrB = Launcher.b(this.as, appWidgetProviderInfo);
                mfVar.n = iArrB[0];
                mfVar.o = iArrB[1];
                com.syu.g.i.a().a("AppWidgetProviderInfo  " + i8 + "\n spanX == " + iArrA[0] + "  spanY = " + iArrA[1]);
                pagedViewWidget.a(appWidgetProviderInfo, -1, iArrA, this.n);
                pagedViewWidget.setTag(mfVar);
                pagedViewWidget.setShortPressListener(this);
            } else if (obj instanceof ResolveInfo) {
                ResolveInfo resolveInfo = (ResolveInfo) obj;
                me meVar = new me(resolveInfo.activityInfo);
                meVar.g = 1;
                meVar.f390a = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                pagedViewWidget.a(this.av, resolveInfo, this.n);
                pagedViewWidget.setTag(meVar);
            }
            pagedViewWidget.setOnClickListener(this);
            pagedViewWidget.setOnLongClickListener(this);
            pagedViewWidget.setOnTouchListener(this);
            pagedViewWidget.setOnKeyListener(this);
            int i9 = i8 % this.aI;
            int i10 = i8 / this.aI;
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i10, GridLayout.START), GridLayout.spec(i9, GridLayout.TOP));
            layoutParams.width = i3;
            layoutParams.height = i4;
            layoutParams.setGravity(8388659);
            if (i9 > 0) {
                layoutParams.leftMargin = this.aK;
            }
            if (i10 > 0) {
                layoutParams.topMargin = this.aL;
            }
            lwVar.addView(pagedViewWidget, layoutParams);
            com.syu.g.i.a().a("ResolveInfo ");
            i7 = i8 + 1;
        }
    }

    @Override // com.android.launcher6.ma
    public void b(View view) {
        if (this.aX) {
            return;
        }
        b(false);
    }

    @Override // com.android.launcher6.ks
    public void b(Launcher launcher, boolean z, boolean z2) {
    }

    public void b(ArrayList arrayList) {
        if (b) {
            return;
        }
        e(arrayList);
        O();
    }

    @Override // com.android.launcher6.li
    View c(int i) {
        return getChildAt(d(i));
    }

    @Override // com.android.launcher6.bz
    public void c() {
        a((View) null, true, true);
        b(false);
        this.aX = false;
    }

    @Override // com.android.launcher6.li
    public void c(int i, boolean z) {
        if (ip.f310a) {
            if (this.ar == q.Widgets) {
                b(i, z);
                return;
            } else {
                a(i, z);
                return;
            }
        }
        if (i < this.aN) {
            a(i, z);
        } else {
            b(i, z);
        }
    }

    @Override // com.android.launcher6.ks
    public void c(Launcher launcher, boolean z, boolean z2) {
        this.aZ = false;
        Iterator it = this.ba.iterator();
        while (it.hasNext()) {
            a((y) it.next());
        }
        this.ba.clear();
        Iterator it2 = this.bb.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        this.bb.clear();
        this.W = !z2;
    }

    public void c(ArrayList arrayList) {
        if (b) {
            return;
        }
        f(arrayList);
        O();
    }

    @Override // com.android.launcher6.mb
    protected boolean c(View view) {
        if (!super.c(view)) {
            return false;
        }
        if (view instanceof PagedViewIcon) {
            h(view);
        } else if ((view instanceof PagedViewWidget) && !i(view)) {
            return false;
        }
        postDelayed(new m(this), 150L);
        return true;
    }

    @Override // com.android.launcher6.li
    protected int d(int i) {
        return (getChildCount() - i) - 1;
    }

    public void d(ArrayList arrayList) {
        if (b) {
            return;
        }
        f(arrayList);
        e(arrayList);
        O();
    }

    @Override // com.android.launcher6.bz
    public boolean d() {
        return true;
    }

    public void e() {
        P();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewC = c(i);
            if (viewC instanceof lw) {
                ((lw) viewC).a();
                this.ac.set(i, true);
            }
        }
    }

    @Override // com.android.launcher6.li
    protected void e(int i) {
        float measuredWidth;
        float interpolation;
        float f;
        float f2;
        boolean zM = m();
        super.e(i);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View viewC = c(i2);
            if (viewC != null) {
                float fA = a(i, viewC, i2);
                float fMax = Math.max(0.0f, fA);
                float fMin = Math.min(0.0f, fA);
                if (zM) {
                    measuredWidth = viewC.getMeasuredWidth() * fMax;
                    interpolation = this.f70a.getInterpolation(Math.abs(fMax));
                } else {
                    measuredWidth = viewC.getMeasuredWidth() * fMin;
                    interpolation = this.f70a.getInterpolation(Math.abs(fMin));
                }
                float f3 = (1.0f - interpolation) + (interpolation * aQ);
                float interpolation2 = (!zM || fA <= 0.0f) ? (zM || fA >= 0.0f) ? this.aU.getInterpolation(1.0f - fA) : this.aT.getInterpolation(1.0f - Math.abs(fA)) : this.aT.getInterpolation(1.0f - Math.abs(fMax));
                viewC.setCameraDistance(this.r * aP);
                int measuredWidth2 = viewC.getMeasuredWidth();
                int measuredHeight = viewC.getMeasuredHeight();
                float f4 = zM ? 1.0f - aR : aR;
                boolean z = zM ? fA > 0.0f : fA < 0.0f;
                boolean z2 = zM ? fA < 0.0f : fA > 0.0f;
                if (i2 == 0 && z) {
                    viewC.setPivotX(measuredWidth2 * f4);
                    viewC.setRotationY((-aS) * fA);
                    f2 = 1.0f;
                    interpolation2 = 1.0f;
                    f = 0.0f;
                } else if (i2 == getChildCount() - 1 && z2) {
                    viewC.setPivotX((1.0f - f4) * measuredWidth2);
                    viewC.setRotationY((-aS) * fA);
                    f2 = 1.0f;
                    interpolation2 = 1.0f;
                    f = 0.0f;
                } else {
                    viewC.setPivotY(measuredHeight / 2.0f);
                    viewC.setPivotX(measuredWidth2 / 2.0f);
                    viewC.setRotationY(0.0f);
                    f = measuredWidth;
                    f2 = f3;
                }
                viewC.setTranslationX(f);
                viewC.setScaleX(f2);
                viewC.setScaleY(f2);
                viewC.setAlpha(interpolation2);
                if (interpolation2 == 0.0f) {
                    viewC.setVisibility(4);
                } else if (viewC.getVisibility() != 0) {
                    viewC.setVisibility(0);
                }
            }
        }
        Q();
    }

    @Override // com.android.launcher6.li
    protected int f(int i) {
        int childCount = getChildCount();
        return Math.max(Math.min(i - 2, childCount - Math.min(childCount, 5)), 0);
    }

    @Override // com.android.launcher6.li
    public void f() {
        int i = 0;
        if (ip.f310a) {
            A();
        }
        removeAllViews();
        P();
        Context context = getContext();
        if (!ip.f310a) {
            for (int i2 = 0; i2 < this.aO; i2++) {
                lw lwVar = new lw(context, this.aI, this.aJ);
                setupPage(lwVar);
                addView(lwVar, new lq(-1, -1));
            }
            if (!b) {
                while (i < this.aN) {
                    i iVar = new i(context);
                    setupPage(iVar);
                    addView(iVar, new lq(-1, -1));
                    i++;
                }
            }
        } else if (this.ar == q.Applications) {
            while (i < this.aN) {
                i iVar2 = new i(context);
                setupPage(iVar2);
                addView(iVar2, new lq(-1, -1));
                i++;
            }
        } else {
            if (this.ar != q.Widgets) {
                throw new RuntimeException("Invalid ContentType");
            }
            while (i < this.aO) {
                lw lwVar2 = new lw(context, this.aI, this.aJ);
                setupPage(lwVar2);
                addView(lwVar2, new lq(-1, -1));
                i++;
            }
        }
        z();
    }

    @Override // com.android.launcher6.li
    protected int g(int i) {
        int childCount = getChildCount();
        return Math.min(Math.max(i + 2, Math.min(childCount, 5) - 1), childCount - 1);
    }

    @Override // com.android.launcher6.li
    protected void g() {
        super.g();
        this.W = true;
        this.ax = -1;
    }

    @Override // com.android.launcher6.ks
    public View getContent() {
        return null;
    }

    public q getContentType() {
        return this.ar;
    }

    @Override // com.android.launcher6.li
    protected String getCurrentPageDescription() {
        int i;
        int i2 = R.string.apps_customize_apps_scroll_format;
        int i3 = this.y != -1 ? this.y : this.v;
        if (ip.f310a) {
            if (this.ar == q.Applications) {
                i = this.aN;
            } else {
                if (this.ar != q.Widgets) {
                    throw new RuntimeException("Invalid ContentType");
                }
                i = this.aO;
                i2 = R.string.apps_customize_widgets_scroll_format;
            }
        } else if (i3 < this.aN) {
            i = this.aN;
        } else {
            i = this.aO;
            i2 = R.string.apps_customize_widgets_scroll_format;
        }
        return String.format(getContext().getString(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i));
    }

    public int getPageContentWidth() {
        return this.aG;
    }

    int getSaveInstanceStateIndex() {
        if (this.ax == -1) {
            this.ax = getMiddleComponentIndexOnCurrentPage();
        }
        return this.ax;
    }

    public void h() {
        this.ax = -1;
        AppsCustomizeTabHost tabHost = getTabHost();
        String currentTabTag = tabHost.getCurrentTabTag();
        if (currentTabTag != null && !currentTabTag.equals(tabHost.a(q.Applications))) {
            tabHost.setCurrentTabFromContent(q.Applications);
        }
        if (this.v != 0) {
            q(0);
        }
    }

    public void i() {
    }

    public void j() {
        P();
    }

    public void k() {
        Log.i("hy", "mAppsCustomizeContentresetDrawableState");
        if (this.ay != null) {
            this.ay.b();
            this.ay = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.as.J() || this.as.I().Y()) {
            return;
        }
        if (view instanceof PagedViewIcon) {
            d dVar = (d) view.getTag();
            if (this.ay != null) {
                this.ay.a();
            }
            this.as.b(view, dVar.f170a, dVar);
            this.as.e().a(dVar.f170a);
            return;
        }
        if (view instanceof PagedViewWidget) {
            if (this.aY != null) {
                this.aY.cancel();
            }
            this.aY = Toast.makeText(getContext(), R.string.long_press_widget_to_add, 0);
            this.aY.show();
            float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dragViewOffsetY);
            ImageView imageView = (ImageView) view.findViewById(R.id.widget_preview);
            AnimatorSet animatorSetB = ik.b();
            ObjectAnimator objectAnimatorA = ik.a(imageView, "translationY", dimensionPixelSize);
            objectAnimatorA.setDuration(125L);
            ObjectAnimator objectAnimatorA2 = ik.a(imageView, "translationY", 0.0f);
            objectAnimatorA2.setDuration(100L);
            animatorSetB.play(objectAnimatorA).before(objectAnimatorA2);
            animatorSetB.setInterpolator(new AccelerateInterpolator());
            animatorSetB.start();
        }
    }

    @Override // com.android.launcher6.mb, com.android.launcher6.li, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        P();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ip.a().i().a();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return cm.b(view, i, keyEvent);
    }

    @Override // com.android.launcher6.li, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!o() && (b || !this.az.isEmpty())) {
            n();
            setMeasuredDimension(size, size2);
            a(size, size2);
        }
        super.onMeasure(i, i2);
    }

    public void setApps(ArrayList arrayList) {
        if (b) {
            return;
        }
        this.az = arrayList;
        Collections.sort(this.az, iv.i());
        O();
    }

    public void setBulkBind(boolean z) {
        if (z) {
            this.bd = true;
            return;
        }
        this.bd = false;
        if (this.be) {
            O();
        }
    }

    public void setContentType(q qVar) {
        int i = 0;
        int currentPage = getCurrentPage();
        if (ip.f310a) {
            if (this.ar == qVar) {
                i = currentPage;
            }
        } else if (qVar == q.Widgets) {
            i = this.aN;
        }
        this.ar = qVar;
        e(i, true);
    }
}
