package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class Workspace extends mq implements View.OnTouchListener, ViewGroup.OnHierarchyChangeListener, bp, by, bz, ce, dy, ks {
    private static boolean aE;
    static Rect c = null;
    static Rect d = null;
    public static MCellLayout[] k = new MCellLayout[LauncherApplication.f88a.getResources().getInteger(R.integer.apps_customepage_count)];
    public static int l = LauncherApplication.f88a.getResources().getInteger(R.integer.apps_customepage_count);
    private IBinder aA;
    private int aB;
    private int aC;
    private mo aD;
    private HashMap aF;
    private ArrayList aG;
    private aj aH;
    private int[] aI;
    private int aJ;
    private int aK;
    private float aL;
    private String aM;
    private CellLayout aN;
    private CellLayout aO;
    private CellLayout aP;
    private Launcher aQ;
    private dv aR;
    private bo aS;
    private int[] aT;
    private int[] aU;
    private int[] aV;
    private float[] aW;
    private float[] aX;
    private Matrix aY;
    private mt aZ;
    private float ar;
    private ValueAnimator as;
    private ValueAnimator at;
    private Drawable au;
    private float av;
    private long aw;
    private long ax;
    private LayoutTransition ay;
    private final WallpaperManager az;
    boolean b;
    private float bA;
    private float bB;
    private float bC;
    private int bD;
    private int bE;
    private int bF;
    private SparseArray bG;
    private final ArrayList bH;
    private int bI;
    private float bJ;
    private float bK;
    private float bL;
    private float bM;
    private float[] bN;
    private float[] bO;
    private float[] bP;
    private float[] bQ;
    private int bR;
    private float bS;
    private Runnable bT;
    private boolean bU;
    private boolean bV;
    private final Runnable bW;
    private final pe bX;
    private float ba;
    private float bb;
    private int bc;
    private pb bd;
    private boolean be;
    private boolean bf;
    private boolean bg;
    private dq bh;
    private Bitmap bi;
    private final Rect bj;
    private final int[] bk;
    private int[] bl;
    private boolean bm;
    private float bn;
    private boolean bo;
    private Runnable bp;
    private Runnable bq;
    private Point br;
    private int bs;
    private final a bt;
    private final a bu;
    private da bv;
    private FolderIcon bw;
    private boolean bx;
    private boolean by;
    private cf bz;
    id e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    pc j;
    private ObjectAnimator m;
    private ObjectAnimator n;

    public Workspace(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Workspace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ar = 0.0f;
        this.b = true;
        this.av = 0.0f;
        this.aw = -1L;
        this.ax = -1L;
        this.aF = new HashMap();
        this.aG = new ArrayList();
        this.aI = new int[2];
        this.aJ = -1;
        this.aK = -1;
        this.aL = -1.0f;
        this.aM = "";
        this.aN = null;
        this.aO = null;
        this.aP = null;
        this.aT = new int[2];
        this.aU = new int[2];
        this.aV = new int[2];
        this.aW = new float[2];
        this.aX = new float[2];
        this.aY = new Matrix();
        this.bd = pb.NORMAL;
        this.be = false;
        this.g = false;
        this.h = false;
        this.i = true;
        this.bf = false;
        this.bg = false;
        this.bi = null;
        this.bj = new Rect();
        this.bk = new int[2];
        this.bl = new int[2];
        this.br = new Point();
        this.bt = new a();
        this.bu = new a();
        this.bv = null;
        this.bw = null;
        this.bx = false;
        this.by = false;
        this.bD = 0;
        this.bE = -1;
        this.bF = -1;
        this.bH = new ArrayList();
        this.bR = -1;
        this.bW = new og(this);
        this.bX = new pe();
        this.ad = false;
        this.bh = dq.a(context);
        this.bz = new cf(context);
        n();
        this.aQ = (Launcher) context;
        Resources resources = getResources();
        this.bo = resources.getBoolean(R.bool.config_workspaceFadeAdjacentScreens);
        this.ae = false;
        this.az = WallpaperManager.getInstance(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mi.Workspace, i, 0);
        this.ba = resources.getInteger(R.integer.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        this.bb = resources.getInteger(R.integer.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.bc = resources.getDimensionPixelSize(R.dimen.overview_mode_page_offset);
        this.bs = resources.getInteger(R.integer.config_cameraDistance);
        int i2 = typedArrayObtainStyledAttributes.getInt(0, 1);
        this.aC = i2;
        this.aB = i2;
        typedArrayObtainStyledAttributes.recycle();
        setOnHierarchyChangeListener(this);
        setHapticFeedbackEnabled(false);
        j();
        setMotionEventSplittingEnabled(true);
        setImportantForAccessibility(1);
    }

    private static float a(float[] fArr, float[] fArr2) {
        float f = fArr[0] - fArr2[0];
        float f2 = fArr2[1] - fArr2[1];
        return (f * f) + (f2 * f2);
    }

    private Bitmap a(Bitmap bitmap, Canvas canvas, int i, int i2, int i3, boolean z) {
        int color = getResources().getColor(R.color.outline_color);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        float fMin = Math.min((i2 - i) / bitmap.getWidth(), (i3 - i) / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (fMin * bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, width, height);
        rect2.offset((i2 - width) / 2, (i3 - height) / 2);
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) null);
        this.bh.a(bitmapCreateBitmap, canvas, color, color, z);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    static Rect a(Launcher launcher, int i) {
        bl blVarA = ip.a().i().a();
        launcher.getResources();
        Display defaultDisplay = launcher.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getCurrentSizeRange(point, point2);
        int i2 = (int) blVarA.e;
        int i3 = (int) blVarA.d;
        int i4 = point2.y;
        int i5 = point.y;
        if (i == 0) {
            if (c == null) {
                Rect rectA = blVarA.a(0);
                int i6 = (i4 - rectA.left) - rectA.right;
                int i7 = (i5 - rectA.top) - rectA.bottom;
                c = new Rect();
                c.set(blVarA.a(i6, i2), blVarA.b(i7, i3), 0, 0);
            }
            return c;
        }
        if (i != 1) {
            return null;
        }
        if (d == null) {
            Rect rectA2 = blVarA.a(1);
            int i8 = (i5 - rectA2.left) - rectA2.right;
            int i9 = (i4 - rectA2.top) - rectA2.bottom;
            d = new Rect();
            d.set(blVarA.a(i8, i2), blVarA.b(i9, i3), 0, 0);
        }
        return d;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0099  */
    private CellLayout a(ca caVar, float f, float f2, boolean z) {
        float f3;
        CellLayout cellLayout;
        int childCount = getChildCount();
        CellLayout cellLayout2 = null;
        float f4 = Float.MAX_VALUE;
        int i = 0;
        while (i < childCount) {
            if (((Long) this.aG.get(i)).longValue() == -301) {
                f3 = f4;
                cellLayout = cellLayout2;
            } else {
                CellLayout cellLayout3 = (CellLayout) getChildAt(i);
                float[] fArr = {f, f2};
                cellLayout3.getMatrix().invert(this.aY);
                a(cellLayout3, fArr, this.aY);
                if (fArr[0] >= 0.0f && fArr[0] <= cellLayout3.getWidth() && fArr[1] >= 0.0f && fArr[1] <= cellLayout3.getHeight()) {
                    return cellLayout3;
                }
                if (z) {
                    f3 = f4;
                    cellLayout = cellLayout2;
                } else {
                    float[] fArr2 = this.aX;
                    fArr2[0] = cellLayout3.getWidth() / 2;
                    fArr2[1] = cellLayout3.getHeight() / 2;
                    a(cellLayout3, fArr2);
                    fArr[0] = f;
                    fArr[1] = f2;
                    float fA = a(fArr, fArr2);
                    if (fA < f4) {
                        cellLayout = cellLayout3;
                        f3 = fA;
                    } else {
                        f3 = f4;
                        cellLayout = cellLayout2;
                    }
                }
            }
            i++;
            cellLayout2 = cellLayout;
            f4 = f3;
        }
        return cellLayout2;
    }

    private void a(float f, boolean z) {
        if (this.au == null) {
            return;
        }
        if (this.as != null) {
            this.as.cancel();
            this.as = null;
        }
        if (this.at != null) {
            this.at.cancel();
            this.at = null;
        }
        float backgroundAlpha = getBackgroundAlpha();
        if (f != backgroundAlpha) {
            if (!z) {
                setBackgroundAlpha(f);
                return;
            }
            this.at = ik.a(this, backgroundAlpha, f);
            this.at.addUpdateListener(new oq(this));
            this.at.setInterpolator(new DecelerateInterpolator(1.5f));
            this.at.setDuration(350L);
            this.at.start();
        }
    }

    private void a(View view, Canvas canvas, int i, boolean z) {
        boolean z2;
        Rect rect = this.bj;
        view.getDrawingRect(rect);
        canvas.save();
        if ((view instanceof TextView) && z) {
            Drawable drawable = ((TextView) view).getCompoundDrawables()[LauncherApplication.f88a.getResources().getInteger(R.integer.appNameAlign)];
            rect.set(0, 0, drawable.getIntrinsicWidth() + i, drawable.getIntrinsicHeight() + i);
            canvas.translate(i / 2, i / 2);
            drawable.draw(canvas);
        } else {
            if (view instanceof FolderIcon) {
                if (((FolderIcon) view).getTextVisible()) {
                    ((FolderIcon) view).setTextVisible(false);
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else if (view instanceof BubbleTextView) {
                BubbleTextView bubbleTextView = (BubbleTextView) view;
                rect.bottom = bubbleTextView.getLayout().getLineTop(0) + (bubbleTextView.getExtendedPaddingTop() - 3);
                z2 = false;
            } else {
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    rect.bottom = textView.getLayout().getLineTop(0) + (textView.getExtendedPaddingTop() - textView.getCompoundDrawablePadding());
                }
                z2 = false;
            }
            canvas.translate((-view.getScrollX()) + (i / 2), (-view.getScrollY()) + (i / 2));
            canvas.clipRect(rect, Region.Op.REPLACE);
            view.draw(canvas);
            if (z2) {
                ((FolderIcon) view).setTextVisible(true);
            }
        }
        canvas.restore();
    }

    private void a(ec ecVar, CellLayout cellLayout, int[] iArr, float f, View view) {
        boolean zA = a(ecVar, cellLayout, iArr, f, false);
        if (this.bD == 0 && zA && !this.bt.b()) {
            this.bt.a(new oy(this, cellLayout, iArr[0], iArr[1]));
            this.bt.a(0L);
            return;
        }
        boolean zA2 = a(ecVar, cellLayout, iArr, f);
        if (zA2 && this.bD == 0) {
            this.bw = (FolderIcon) view;
            this.bw.b(ecVar);
            if (cellLayout != null) {
                cellLayout.f();
            }
            setDragMode(2);
            return;
        }
        if (this.bD == 2 && !zA2) {
            setDragMode(0);
        }
        if (this.bD != 1 || zA) {
            return;
        }
        setDragMode(0);
    }

    private void a(boolean z, int i, boolean z2) {
        this.aQ.b(true);
        pb pbVar = pb.OVERVIEW;
        if (!z) {
            pbVar = pb.NORMAL;
        }
        Animator animatorA = a(pbVar, z2, 0, i);
        if (animatorA != null) {
            aE();
            animatorA.addListener(new os(this));
            animatorA.start();
        }
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0300  */
    private void a(int[] iArr, Object obj, CellLayout cellLayout, boolean z, cg cgVar) {
        ec ecVar;
        View viewA;
        boolean z2;
        oi oiVar = new oi(this);
        ec ecVar2 = (ec) obj;
        int i = ecVar2.l;
        int i2 = ecVar2.m;
        if (this.aH != null) {
            i = this.aH.d;
            i2 = this.aH.e;
        }
        long j = this.aQ.b(cellLayout) ? -101 : -100;
        long jA = a(cellLayout);
        if (!this.aQ.b(cellLayout) && jA != a(this.v) && this.bd != pb.SPRING_LOADED) {
            a(jA, (Runnable) null);
        }
        if (!(ecVar2 instanceof md)) {
            switch (ecVar2.g) {
                case 0:
                case 1:
                    ec mpVar = (ecVar2.h == -1 && (ecVar2 instanceof d)) ? new mp((d) ecVar2) : ecVar2;
                    viewA = this.aQ.a(R.layout.application, cellLayout, (mp) mpVar);
                    ecVar = mpVar;
                    break;
                case 2:
                    ecVar = ecVar2;
                    viewA = FolderIcon.a(R.layout.folder_icon, this.aQ, cellLayout, (dg) ecVar2, this.aR);
                    break;
                default:
                    throw new IllegalStateException("Unknown item type: " + ecVar2.g);
            }
            if (iArr != null) {
                this.aI = a(iArr[0], iArr[1], i, i2, cellLayout, this.aI);
                float fA = cellLayout.a(this.aW[0], this.aW[1], this.aI);
                cgVar.i = oiVar;
                if (a(viewA, j, cellLayout, this.aI, fA, true, cgVar.f, cgVar.i)) {
                    return;
                }
                if (a(viewA, cellLayout, this.aI, fA, cgVar, true)) {
                    return;
                }
            }
            if (iArr != null) {
                this.aI = cellLayout.a((int) this.aW[0], (int) this.aW[1], 1, 1, 1, 1, (View) null, this.aI, (int[]) null, 2);
            } else {
                cellLayout.a(this.aI, 1, 1);
            }
            a(viewA, j, jA, this.aI[0], this.aI[1], ecVar.l, ecVar.m, z);
            cellLayout.b(viewA);
            al alVar = (al) viewA.getLayoutParams();
            cellLayout.getShortcutsAndWidgets().a(viewA);
            iv.a(this.aQ, ecVar, j, jA, alVar.f109a, alVar.b);
            if (cgVar.f != null) {
                setFinalTransitionTransform(cellLayout);
                this.aQ.f().a(cgVar.f, viewA, oiVar);
                b(cellLayout);
                return;
            }
            return;
        }
        md mdVar = (md) obj;
        if (mdVar.g == 1) {
            this.aI = a(iArr[0], iArr[1], i, i2, cellLayout, this.aI);
            float fA2 = cellLayout.a(this.aW[0], this.aW[1], this.aI);
            if (a((ec) cgVar.g, cellLayout, this.aI, fA2, true) || a((ec) cgVar.g, cellLayout, this.aI, fA2)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        ec ecVar3 = (ec) cgVar.g;
        boolean z3 = false;
        if (z2) {
            int i3 = ecVar3.l;
            int i4 = ecVar3.m;
            if (ecVar3.n > 0 && ecVar3.o > 0) {
                i3 = ecVar3.n;
                i4 = ecVar3.o;
            }
            int[] iArr2 = new int[2];
            this.aI = cellLayout.a((int) this.aW[0], (int) this.aW[1], i3, i4, ecVar2.l, ecVar2.m, (View) null, this.aI, iArr2, 2);
            boolean z4 = (iArr2[0] == ecVar3.l && iArr2[1] == ecVar3.m) ? false : true;
            ecVar3.l = iArr2[0];
            ecVar3.m = iArr2[1];
            z3 = z4;
        }
        oj ojVar = new oj(this, mdVar, ecVar3, j, jA);
        AppWidgetHostView appWidgetHostView = mdVar.g == 4 ? ((mf) mdVar).v : null;
        if ((appWidgetHostView instanceof AppWidgetHostView) && z3) {
            e.a(appWidgetHostView, this.aQ, ecVar3.l, ecVar3.m);
        }
        int i5 = 0;
        if (mdVar.g == 4 && ((mf) mdVar).u.configure != null) {
            i5 = 1;
        }
        a(ecVar2, cellLayout, cgVar.f, (Runnable) ojVar, i5, (View) appWidgetHostView, true);
    }

    private void a(int[] iArr, float[] fArr, ca caVar, CellLayout cellLayout, ec ecVar, int[] iArr2, boolean z, boolean z2) {
        float fWidth;
        float fHeight;
        Rect rectA = a(cellLayout, ecVar, iArr2[0], iArr2[1], ecVar.l, ecVar.m);
        iArr[0] = rectA.left;
        iArr[1] = rectA.top;
        setFinalTransitionTransform(cellLayout);
        float fA = this.aQ.f().a((View) cellLayout, iArr, true);
        b(cellLayout);
        if (z2) {
            fWidth = (1.0f * rectA.width()) / caVar.getMeasuredWidth();
            fHeight = (1.0f * rectA.height()) / caVar.getMeasuredHeight();
        } else {
            fWidth = 1.0f;
            fHeight = 1.0f;
        }
        iArr[0] = (int) (iArr[0] - ((caVar.getMeasuredWidth() - (rectA.width() * fA)) / 2.0f));
        iArr[1] = (int) (iArr[1] - ((caVar.getMeasuredHeight() - (rectA.height() * fA)) / 2.0f));
        fArr[0] = fWidth * fA;
        fArr[1] = fHeight * fA;
    }

    private float[] a(int i, int i2, int i3, int i4, ca caVar, float[] fArr) {
        if (fArr == null) {
            fArr = new float[2];
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dragViewOffsetX) + i;
        int dimensionPixelSize2 = (getResources().getDimensionPixelSize(R.dimen.dragViewOffsetY) + i2) - i4;
        fArr[0] = (dimensionPixelSize - i3) + (caVar.getDragRegion().width() / 2);
        fArr[1] = dimensionPixelSize2 + (caVar.getDragRegion().height() / 2);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] a(int i, int i2, int i3, int i4, CellLayout cellLayout, int[] iArr) {
        return cellLayout.c(i, i2, i3, i4, iArr);
    }

    private void aA() {
        this.ay = new LayoutTransition();
        this.ay.enableTransitionType(3);
        this.ay.enableTransitionType(1);
        this.ay.disableTransitionType(2);
        this.ay.disableTransitionType(0);
        setLayoutTransition(this.ay);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    private void aB() {
        int i;
        int i2;
        if (this.i) {
            int childCount = getChildCount();
            b(this.bl);
            int i3 = this.bl[0];
            int i4 = this.bl[1];
            if (i3 != i4) {
                i = i4;
                i2 = i3;
            } else if (i4 < childCount - 1) {
                i = i4 + 1;
                i2 = i3;
            } else if (i3 > 0) {
                i = i4;
                i2 = i3 - 1;
            } else {
                i = i4;
                i2 = i3;
            }
            CellLayout cellLayout = (CellLayout) this.aF.get(-301L);
            int i5 = 0;
            while (i5 < childCount) {
                CellLayout cellLayout2 = (CellLayout) c(i5);
                cellLayout2.a(cellLayout2 != cellLayout && i2 <= i5 && i5 <= i && e(cellLayout2));
                i5++;
            }
        }
    }

    private void aC() {
        int childCount = getChildCount();
        if (this.bR == childCount) {
            return;
        }
        this.bN = new float[childCount];
        this.bO = new float[childCount];
        this.bP = new float[childCount];
        this.bQ = new float[childCount];
    }

    private void aD() {
        setImportantForAccessibility(this.bd == pb.NORMAL ? 1 : 4);
    }

    private void aE() {
        this.be = true;
        invalidate();
        e(false);
        au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        int i = 0;
        this.be = false;
        e(false);
        if (!this.bo) {
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                ((CellLayout) getChildAt(i2)).setShortcutAndWidgetAlpha(1.0f);
                i = i2 + 1;
            }
        }
        at();
    }

    private void aG() {
        if (this.bv != null) {
            this.bv.b();
            this.bv = null;
        }
        this.bt.a((lf) null);
        this.bt.a();
    }

    private void aH() {
        if (this.bw != null) {
            this.bw.c((Object) null);
            this.bw = null;
        }
    }

    private void aI() {
        setCurrentDragOverlappingLayout(null);
        this.bg = false;
    }

    private Bitmap b(View view, Canvas canvas, int i) {
        int color = getResources().getColor(R.color.outline_color);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth() + i, view.getHeight() + i, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        a(view, canvas, i, true);
        this.bh.b(bitmapCreateBitmap, canvas, color, color);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private void b(int i, boolean z) {
        if (!ak()) {
            if (z) {
                n(i);
            } else {
                setCurrentPage(i);
            }
        }
        View childAt = getChildAt(i);
        if (childAt != null) {
            childAt.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        boolean z2 = true;
        boolean z3 = this.bd == pb.SMALL || this.bd == pb.OVERVIEW || this.be;
        if (!z && !z3 && !this.g && !v()) {
            z2 = false;
        }
        if (z2 != this.i) {
            this.i = z2;
            if (this.i) {
                aB();
                return;
            }
            for (int i = 0; i < getPageCount(); i++) {
                ((CellLayout) getChildAt(i)).a(false);
            }
        }
    }

    private void f(boolean z) {
        if (z) {
            this.bu.a();
        }
        this.bE = -1;
        this.bF = -1;
    }

    private boolean f(cg cgVar) {
        return (cgVar.g instanceof it) || (cgVar.g instanceof mf);
    }

    private boolean g(cg cgVar) {
        return cgVar.h != this && f(cgVar);
    }

    private void s(int i) {
        boolean z = this.aa < 0 || this.aa > this.z;
        if (!this.bo || this.bd != pb.NORMAL || this.be || z) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            CellLayout cellLayout = (CellLayout) getChildAt(i2);
            if (cellLayout != null) {
                float fA = a(i, cellLayout, i2);
                cellLayout.getShortcutsAndWidgets().setAlpha(1.0f - Math.abs(fA));
                if (this.h) {
                    cellLayout.setBackgroundAlphaMultiplier(1.0f);
                } else {
                    cellLayout.setBackgroundAlphaMultiplier(e(Math.abs(fA)));
                }
            }
        }
    }

    private void setChildrenBackgroundAlphaMultipliers(float f) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            ((CellLayout) getChildAt(i2)).setBackgroundAlphaMultiplier(f);
            i = i2 + 1;
        }
    }

    private void setState(pb pbVar) {
        this.bd = pbVar;
        ar();
        aD();
    }

    private void t(int i) {
        float fMax;
        float f;
        if (af()) {
            int iIndexOf = this.aG.indexOf(-301L);
            int scrollX = (getScrollX() - j(iIndexOf)) - k(iIndexOf);
            float fJ = j(iIndexOf + 1) - j(iIndexOf);
            float f2 = fJ - scrollX;
            float f3 = (fJ - scrollX) / fJ;
            float fMin = m() ? Math.min(0.0f, f2) : Math.max(0.0f, f2);
            fMax = Math.max(0.0f, f3);
            f = fMin;
        } else {
            fMax = 0.0f;
            f = 0.0f;
        }
        if (Float.compare(fMax, this.aL) == 0) {
            return;
        }
        CellLayout cellLayout = (CellLayout) this.aF.get(-301L);
        if (fMax > 0.0f && cellLayout.getVisibility() != 0 && !ak()) {
            cellLayout.setVisibility(0);
        }
        this.aL = fMax;
        setBackgroundAlpha(0.8f * fMax);
        if (this.aQ.D() != null) {
            this.aQ.D().setTranslationX(f);
        }
        if (getPageIndicator() != null) {
            getPageIndicator().setTranslationX(f);
        }
        if (this.e != null) {
            this.e.a(fMax);
        }
    }

    @Override // com.android.launcher6.li
    protected void J() {
        super.J();
        ac();
        M();
    }

    @Override // com.android.launcher6.li
    protected void K() {
        super.K();
        ad();
        this.aG.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.aG.add(Long.valueOf(a((CellLayout) getChildAt(i))));
        }
        Launcher.r().a(this.aQ, this.aG);
        k();
    }

    void M() {
        setLayoutTransition(null);
    }

    boolean N() {
        return this.F != 0;
    }

    public void O() {
        M();
        if (af()) {
            R();
        }
        removeAllViews();
        this.aG.clear();
        this.aF.clear();
        k();
    }

    public void P() {
        Log.i("hy", "createUserPage");
        if (k[0] == null) {
            k[0] = (MCellLayout) this.aQ.getLayoutInflater().inflate(a.b.a().bv, (ViewGroup) null);
        }
        if (k.length > 1 && k[1] == null && a.b.a().bv != 0) {
            k[1] = (MCellLayout) this.aQ.getLayoutInflater().inflate(a.b.a().bv, (ViewGroup) null);
        }
        if (k.length > 2 && k[2] == null && a.b.a().bv != 0) {
            k[2] = (MCellLayout) this.aQ.getLayoutInflater().inflate(a.b.a().bw, (ViewGroup) null);
        }
        if (k.length > 3 && k[3] == null && a.b.a().bv != 0) {
            k[3] = (MCellLayout) this.aQ.getLayoutInflater().inflate(a.b.a().bx, (ViewGroup) null);
        }
        for (int i = 0; i < LauncherApplication.f88a.getResources().getInteger(R.integer.apps_customepage_count); i++) {
            this.aF.put(Long.valueOf((-302) - ((long) i)), k[i]);
            this.aG.add(i, Long.valueOf((-302) - ((long) i)));
            if (k[i] != null) {
                ViewParent parent = k[i].getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(k[i]);
                }
                addView(k[i], i);
            }
        }
    }

    public void Q() {
        CellLayout cellLayout = (CellLayout) this.aQ.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) null);
        Log.i("hy", "createCustomContentPage");
        this.aF.put(-301L, cellLayout);
        this.aG.add(l, -301L);
        cellLayout.setPadding(0, 0, 0, 0);
        d(cellLayout);
        this.aC = this.aB + 1;
        this.aQ.V();
        if (this.w != -1001) {
            this.w++;
        } else {
            setCurrentPage(getCurrentPage() + 1);
        }
    }

    public void R() {
        CellLayout cellLayoutC = c(-301L);
        if (cellLayoutC == null) {
            return;
        }
        this.aF.remove(-301L);
        this.aG.remove((Object) (-301L));
        removeView(cellLayoutC);
        if (this.e != null) {
            this.e.a(0.0f);
            this.e.b();
        }
        this.e = null;
        this.aC = this.aB - 1;
        this.aQ.V();
        if (this.w != -1001) {
            this.w--;
        } else {
            setCurrentPage(getCurrentPage() - 1);
        }
    }

    public void S() {
        boolean z;
        boolean z2 = false;
        if (this.aD != null) {
            z = this.aD.getChildCount() == 1;
            if (indexOfChild((CellLayout) this.aD.getParent()) == getChildCount() - 1) {
                z2 = true;
            }
        } else {
            z = false;
        }
        if ((z && z2) || this.aF.containsKey(-201L) || !LauncherApplication.f88a.getResources().getBoolean(R.bool.page_increase)) {
            return;
        }
        b(-201L);
    }

    public boolean T() {
        if (this.aF.containsKey(-201L)) {
            return false;
        }
        b(-201L);
        return true;
    }

    public void U() {
        if (V()) {
            CellLayout cellLayout = (CellLayout) this.aF.get(-201L);
            this.aF.remove(-201L);
            this.aG.remove((Object) (-201L));
            removeView(cellLayout);
        }
    }

    public boolean V() {
        return this.aF.containsKey(-201L) && getChildCount() - ah() > 1;
    }

    public long W() {
        int iD = d(-201L);
        CellLayout cellLayout = (CellLayout) this.aF.get(-201L);
        this.aF.remove(-201L);
        this.aG.remove((Object) (-201L));
        long jB = ip.g().b();
        this.aF.put(Long.valueOf(jB), cellLayout);
        this.aG.add(Long.valueOf(jB));
        if (getPageIndicator() != null) {
            getPageIndicator().a(iD, h(iD));
        }
        Launcher.r().a(this.aQ, this.aG);
        return jB;
    }

    public void X() {
        if (v()) {
            this.bf = true;
            return;
        }
        int nextPage = getNextPage();
        ArrayList<Long> arrayList = new ArrayList();
        for (Long l2 : this.aF.keySet()) {
            CellLayout cellLayout = (CellLayout) this.aF.get(l2);
            if (l2.longValue() >= 0 && cellLayout.getShortcutsAndWidgets().getChildCount() == 0) {
                arrayList.add(l2);
            }
        }
        int iAh = ah() + 1;
        int i = 0;
        for (Long l3 : arrayList) {
            CellLayout cellLayout2 = (CellLayout) this.aF.get(l3);
            this.aF.remove(l3);
            this.aG.remove(l3);
            if (getChildCount() > iAh) {
                int i2 = indexOfChild(cellLayout2) < nextPage ? i + 1 : i;
                cellLayout2.setBackgroundAlpha(0.0f);
                removeView(cellLayout2);
                i = i2;
            } else {
                this.aF.put(-201L, cellLayout2);
                this.aG.add(-201L);
            }
        }
        if (!arrayList.isEmpty()) {
            Launcher.r().a(this.aQ, this.aG);
        }
        if (i >= 0) {
            setCurrentPage(nextPage - i);
        }
    }

    public boolean Y() {
        return this.be;
    }

    public boolean Z() {
        return !this.be || this.bS > 0.5f;
    }

    public long a(int i) {
        if (i < 0 || i >= this.aG.size()) {
            return -1L;
        }
        return ((Long) this.aG.get(i)).longValue();
    }

    public long a(long j) {
        int iIndexOf = this.aG.indexOf(-201L);
        if (iIndexOf < 0) {
            iIndexOf = this.aG.size();
        }
        return a(j, iIndexOf);
    }

    public long a(long j, int i) {
        if (!this.aF.containsKey(Long.valueOf(j))) {
            CellLayout cellLayout = (CellLayout) this.aQ.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) null);
            cellLayout.setOnLongClickListener(this.H);
            cellLayout.setOnClickListener(this.aQ);
            cellLayout.setSoundEffectsEnabled(false);
            this.aF.put(Long.valueOf(j), cellLayout);
            this.aG.add(i, Long.valueOf(j));
            addView(cellLayout, i);
        }
        return j;
    }

    public long a(CellLayout cellLayout) {
        Iterator it = this.aF.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (this.aF.get(Long.valueOf(jLongValue)) == cellLayout) {
                return jLongValue;
            }
        }
        return -1L;
    }

    Animator a(pb pbVar, boolean z) {
        return a(pbVar, z, 0, -1);
    }

    Animator a(pb pbVar, boolean z, int i, int i2) {
        int integer;
        float f;
        if (this.bd == pbVar) {
            return null;
        }
        Log.i("hy", "state222222" + pbVar);
        aC();
        AnimatorSet animatorSetB = z ? ik.b() : null;
        pb pbVar2 = this.bd;
        boolean z2 = pbVar2 == pb.NORMAL;
        if (pbVar2 == pb.SPRING_LOADED) {
        }
        boolean z3 = pbVar2 == pb.SMALL;
        boolean z4 = pbVar2 == pb.OVERVIEW;
        setState(pbVar);
        boolean z5 = pbVar == pb.NORMAL;
        boolean z6 = pbVar == pb.SPRING_LOADED;
        boolean z7 = pbVar == pb.SMALL;
        boolean z8 = pbVar == pb.OVERVIEW;
        float f2 = (z6 || z8) ? 1.0f : 0.0f;
        float f3 = (z8 || z7) ? 0.0f : 1.0f;
        float f4 = z8 ? 1.0f : 0.0f;
        float f5 = !z5 ? 0.0f : 1.0f;
        float overviewModeTranslationY = z8 ? getOverviewModeTranslationY() : 0;
        boolean z9 = z2 && z7;
        boolean z10 = z3 && z5;
        boolean z11 = z2 && z8;
        boolean z12 = z4 && z5;
        this.bM = 1.0f;
        if (z4) {
            l(i2);
        } else if (z8) {
            C();
        }
        if (pbVar != pb.NORMAL) {
            if (z6) {
                this.bM = this.ba;
            } else if (z8) {
                this.bM = this.bb;
            } else if (z7) {
                this.bM = this.bb - 0.3f;
            }
            if (z9) {
                e(false);
            }
        }
        if (z9) {
            integer = getResources().getInteger(R.integer.config_workspaceUnshrinkTime);
        } else {
            integer = (z11 || z12) ? getResources().getInteger(R.integer.config_overviewTransitionTime) : getResources().getInteger(R.integer.config_appsCustomizeWorkspaceShrinkTime);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= getChildCount()) {
                break;
            }
            CellLayout cellLayout = (CellLayout) getChildAt(i4);
            boolean z13 = i4 == getNextPage();
            float alpha = cellLayout.getShortcutsAndWidgets().getAlpha();
            float f6 = z7 ? 0.0f : 1.0f;
            if (!this.be && (z9 || z10)) {
                if (z10 && z13) {
                    f = 0.0f;
                } else if (z13) {
                    f = alpha;
                } else {
                    f6 = 0.0f;
                    f = 0.0f;
                }
                cellLayout.setShortcutAndWidgetAlpha(f);
                alpha = f;
            }
            this.bO[i4] = alpha;
            this.bQ[i4] = f6;
            if (z) {
                this.bN[i4] = cellLayout.getBackgroundAlpha();
                this.bP[i4] = f2;
            } else {
                cellLayout.setBackgroundAlpha(f2);
                cellLayout.setShortcutAndWidgetAlpha(f6);
            }
            i3 = i4 + 1;
        }
        View viewN = this.aQ.N();
        View viewE = this.aQ.E();
        if (z) {
            animatorSetB.setDuration(integer);
            kt ktVar = new kt(this);
            ktVar.b(this.bM).c(this.bM).a(overviewModeTranslationY).setInterpolator(this.bX);
            animatorSetB.play(ktVar);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= getChildCount()) {
                    break;
                }
                CellLayout cellLayout2 = (CellLayout) getChildAt(i6);
                float alpha2 = cellLayout2.getShortcutsAndWidgets().getAlpha();
                if (this.bO[i6] == 0.0f && this.bQ[i6] == 0.0f) {
                    cellLayout2.setBackgroundAlpha(this.bP[i6]);
                    cellLayout2.setShortcutAndWidgetAlpha(this.bQ[i6]);
                } else {
                    if (this.bO[i6] != this.bQ[i6] || alpha2 != this.bQ[i6]) {
                        kt ktVar2 = new kt(cellLayout2.getShortcutsAndWidgets());
                        ktVar2.d(this.bQ[i6]).setInterpolator(this.bX);
                        animatorSetB.play(ktVar2);
                    }
                    if (this.bN[i6] != 0.0f || this.bP[i6] != 0.0f) {
                        ValueAnimator valueAnimatorA = ik.a(cellLayout2, 0.0f, 1.0f);
                        valueAnimatorA.setInterpolator(this.bX);
                        valueAnimatorA.addUpdateListener(new ou(this, cellLayout2, i6));
                        animatorSetB.play(valueAnimatorA);
                    }
                }
                i5 = i6 + 1;
            }
            ObjectAnimator objectAnimatorOfFloat = getPageIndicator() != null ? ObjectAnimator.ofFloat(getPageIndicator(), "alpha", f3) : null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewN, "alpha", f5);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewE, "alpha", f4);
            objectAnimatorOfFloat3.addListener(new ox(viewE));
            objectAnimatorOfFloat2.addListener(new ox(viewN));
            if (!z11 && z12) {
                objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            if (getPageIndicator() != null) {
                objectAnimatorOfFloat.addListener(new ox(getPageIndicator()));
            }
            animatorSetB.play(objectAnimatorOfFloat3);
            animatorSetB.play(objectAnimatorOfFloat2);
            animatorSetB.play(objectAnimatorOfFloat);
            animatorSetB.setStartDelay(i);
        } else {
            viewE.setAlpha(f4);
            ox.a(viewE);
            if (getPageIndicator() != null) {
                getPageIndicator().setAlpha(f3);
                ox.a(getPageIndicator());
            }
            viewN.setAlpha(f5);
            ox.a(viewN);
            as();
            setScaleX(this.bM);
            setScaleY(this.bM);
            setTranslationY(overviewModeTranslationY);
        }
        this.aQ.j(false);
        if (z6) {
            a(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, false);
            return animatorSetB;
        }
        if (z8) {
            a(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, true);
            return animatorSetB;
        }
        a(0.0f, z);
        return animatorSetB;
    }

    Animator a(pb pbVar, boolean z, int i, int i2, q qVar) {
        int integer;
        float f;
        if (this.bd == pbVar) {
            return null;
        }
        Log.i("hy", "state111111" + pbVar);
        aC();
        AnimatorSet animatorSetB = z ? ik.b() : null;
        pb pbVar2 = this.bd;
        boolean z2 = pbVar2 == pb.NORMAL;
        if (pbVar2 == pb.SPRING_LOADED) {
        }
        boolean z3 = pbVar2 == pb.SMALL;
        boolean z4 = pbVar2 == pb.OVERVIEW;
        setState(pbVar);
        boolean z5 = pbVar == pb.NORMAL;
        boolean z6 = pbVar == pb.SPRING_LOADED;
        boolean z7 = pbVar == pb.SMALL;
        boolean z8 = pbVar == pb.OVERVIEW;
        float f2 = (z6 || z8) ? 1.0f : 0.0f;
        float f3 = (z8 || z7) ? 0.0f : 1.0f;
        float f4 = qVar == q.Widgets ? 1.0f : 0.0f;
        float f5 = !z5 ? 0.0f : 1.0f;
        float overviewModeTranslationY = z8 ? getOverviewModeTranslationY() : 0;
        boolean z9 = z2 && z7;
        boolean z10 = z3 && z5;
        boolean z11 = z2 && z8;
        boolean z12 = z4 && z5;
        this.bM = 1.0f;
        if (z4) {
            l(i2);
        } else if (z8) {
            C();
        }
        if (pbVar != pb.NORMAL) {
            if (z6) {
                this.bM = this.ba;
            } else if (z8) {
                this.bM = this.bb;
            } else if (z7) {
                this.bM = this.bb - 0.3f;
            }
            if (z9) {
                e(false);
            }
        }
        if (z9) {
            integer = getResources().getInteger(R.integer.config_workspaceUnshrinkTime);
        } else {
            integer = (z11 || z12) ? getResources().getInteger(R.integer.config_overviewTransitionTime) : getResources().getInteger(R.integer.config_appsCustomizeWorkspaceShrinkTime);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= getChildCount()) {
                break;
            }
            CellLayout cellLayout = (CellLayout) getChildAt(i4);
            boolean z13 = i4 == getNextPage();
            float alpha = cellLayout.getShortcutsAndWidgets().getAlpha();
            float f6 = z7 ? 0.0f : 1.0f;
            if (this.be || !(z9 || z10)) {
                f = alpha;
            } else {
                if ((!z10 || !z13) && !z13) {
                    f6 = 0.0f;
                }
                f = 0.0f;
                cellLayout.setShortcutAndWidgetAlpha(0.0f);
            }
            this.bO[i4] = f;
            this.bQ[i4] = f6;
            if (z) {
                this.bN[i4] = cellLayout.getBackgroundAlpha();
                this.bP[i4] = f2;
            } else {
                cellLayout.setBackgroundAlpha(f2);
                cellLayout.setShortcutAndWidgetAlpha(f6);
            }
            i3 = i4 + 1;
        }
        View viewN = this.aQ.N();
        View viewE = this.aQ.E();
        if (z) {
            animatorSetB.setDuration(integer);
            kt ktVar = new kt(this);
            ktVar.b(this.bM).c(this.bM).a(overviewModeTranslationY).setInterpolator(this.bX);
            animatorSetB.play(ktVar);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= getChildCount()) {
                    break;
                }
                CellLayout cellLayout2 = (CellLayout) getChildAt(i6);
                float alpha2 = cellLayout2.getShortcutsAndWidgets().getAlpha();
                if (this.bO[i6] == 0.0f && this.bQ[i6] == 0.0f) {
                    cellLayout2.setBackgroundAlpha(this.bP[i6]);
                    cellLayout2.setShortcutAndWidgetAlpha(this.bQ[i6]);
                } else {
                    if (this.bO[i6] != this.bQ[i6] || alpha2 != this.bQ[i6]) {
                        kt ktVar2 = new kt(cellLayout2.getShortcutsAndWidgets());
                        ktVar2.d(this.bQ[i6]).setInterpolator(this.bX);
                        animatorSetB.play(ktVar2);
                    }
                    if (this.bN[i6] != 0.0f || this.bP[i6] != 0.0f) {
                        ValueAnimator valueAnimatorA = ik.a(cellLayout2, 0.0f, 1.0f);
                        valueAnimatorA.setInterpolator(this.bX);
                        valueAnimatorA.addUpdateListener(new ot(this, cellLayout2, i6));
                        animatorSetB.play(valueAnimatorA);
                    }
                }
                i5 = i6 + 1;
            }
            ObjectAnimator objectAnimatorOfFloat = getPageIndicator() != null ? ObjectAnimator.ofFloat(getPageIndicator(), "alpha", f3) : null;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewN, "alpha", f5);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewE, "alpha", f4);
            objectAnimatorOfFloat3.addListener(new ox(viewE));
            objectAnimatorOfFloat2.addListener(new ox(viewN));
            if (!z11 && z12) {
                objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            if (getPageIndicator() != null) {
                objectAnimatorOfFloat.addListener(new ox(getPageIndicator()));
            }
            animatorSetB.play(objectAnimatorOfFloat3);
            animatorSetB.play(objectAnimatorOfFloat2);
            animatorSetB.play(objectAnimatorOfFloat);
            animatorSetB.setStartDelay(i);
        } else {
            viewE.setAlpha(f4);
            ox.a(viewE);
            if (getPageIndicator() != null) {
                getPageIndicator().setAlpha(f3);
                ox.a(getPageIndicator());
            }
            viewN.setAlpha(f5);
            ox.a(viewN);
            as();
            setScaleX(this.bM);
            setScaleY(this.bM);
            setTranslationY(overviewModeTranslationY);
        }
        this.aQ.j(false);
        if (z6) {
            a(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, false);
            return animatorSetB;
        }
        if (z8) {
            a(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, true);
            return animatorSetB;
        }
        a(0.0f, z);
        return animatorSetB;
    }

    Animator a(pb pbVar, boolean z, q qVar) {
        return a(pbVar, z, 0, -1, qVar);
    }

    public Bitmap a(View view, Canvas canvas, int i) {
        Bitmap bitmapCreateBitmap;
        if (view instanceof TextView) {
            Drawable drawable = ((TextView) view).getCompoundDrawables()[LauncherApplication.f88a.getResources().getInteger(R.integer.appNameAlign)];
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth() + i, drawable.getIntrinsicHeight() + i, Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth() + i, view.getHeight() + i, Bitmap.Config.ARGB_8888);
        }
        canvas.setBitmap(bitmapCreateBitmap);
        a(view, canvas, i, true);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public Bitmap a(ec ecVar, View view) {
        int[] iArrA = this.aQ.I().a(ecVar.l, ecVar.m, ecVar, false);
        int visibility = view.getVisibility();
        view.setVisibility(0);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iArrA[0], 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iArrA[1], 1073741824);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrA[0], iArrA[1], Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        view.layout(0, 0, iArrA[0], iArrA[1]);
        view.draw(canvas);
        canvas.setBitmap(null);
        view.setVisibility(visibility);
        return bitmapCreateBitmap;
    }

    public Rect a(CellLayout cellLayout, ec ecVar, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        cellLayout.b(i, i2, i3, i4, rect);
        return rect;
    }

    public Folder a(Object obj) {
        for (mo moVar : getAllShortcutAndWidgetContainers()) {
            int childCount = moVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = moVar.getChildAt(i);
                if (childAt instanceof Folder) {
                    Folder folder = (Folder) childAt;
                    if (folder.getInfo() == obj && folder.getInfo().f177a) {
                        return folder;
                    }
                }
            }
        }
        return null;
    }

    ArrayList a(boolean z, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a((CellLayout) getChildAt(i), arrayList2, arrayList, false);
        }
        return arrayList2;
    }

    @Override // com.android.launcher6.li
    protected void a(float f) {
        b(f);
    }

    void a(int i, int i2) {
        if (i <= i2) {
            i2 = i;
            i = i2;
        }
        int childCount = getChildCount();
        int iMax = Math.max(i2, 0);
        int iMin = Math.min(i, childCount - 1);
        for (int i3 = iMax; i3 <= iMin; i3++) {
            CellLayout cellLayout = (CellLayout) getChildAt(i3);
            cellLayout.setChildrenDrawnWithCacheEnabled(true);
            cellLayout.setChildrenDrawingCacheEnabled(true);
        }
    }

    protected void a(int i, Runnable runnable) {
        com.syu.d.a.b("snapToPage");
        if (this.bq != null) {
            this.bq.run();
        }
        this.bq = runnable;
        c(i, 950);
    }

    public void a(int i, boolean z) {
        a(false, i, z);
    }

    protected void a(long j, Runnable runnable) {
        a(d(j), runnable);
    }

    @Override // com.android.launcher6.ce
    public void a(Rect rect) {
        this.aQ.f().a(this, rect);
    }

    protected void a(MotionEvent motionEvent) {
        int[] iArr = this.aT;
        getLocationOnScreen(iArr);
        int actionIndex = motionEvent.getActionIndex();
        iArr[0] = iArr[0] + ((int) motionEvent.getX(actionIndex));
        iArr[1] = ((int) motionEvent.getY(actionIndex)) + iArr[1];
        this.az.sendWallpaperCommand(getWindowToken(), motionEvent.getAction() == 1 ? "android.wallpaper.tap" : "android.wallpaper.secondaryTap", iArr[0], iArr[1], 0, null);
    }

    public void a(View view) {
        this.bi = b(view, new Canvas(), 2);
    }

    void a(View view, long j, long j2, int i, int i2, int i3, int i4) {
        com.syu.g.i.a().a("addInScreen-1  screenId = " + j2 + " x = " + i + " y = " + i2);
        a(view, j, j2, i, i2, i3, i4, false, false);
    }

    void a(View view, long j, long j2, int i, int i2, int i3, int i4, boolean z) {
        com.syu.g.i.a().a("addInScreen-3  screenId = " + j2 + " x = " + i + " y = " + i2);
        a(view, j, j2, i, i2, i3, i4, z, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(View view, long j, long j2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        al alVar;
        if (j == -100 && c(j2) == null) {
            Log.e("JLog", "Skipping child, screenId " + j2 + " not found");
            b(j2);
        }
        if (j2 == -201) {
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }
        if (view instanceof FolderIcon) {
            ((FolderIcon) view).setTextVisible(true);
        }
        CellLayout cellLayoutC = c(j2);
        view.setOnKeyListener(new dx());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof al)) {
            alVar = new al(i, i2, i3, i4);
        } else {
            al alVar2 = (al) layoutParams;
            alVar2.f109a = i;
            alVar2.b = i2;
            alVar2.f = i3;
            alVar2.g = i4;
            alVar = alVar2;
        }
        if (i3 < 0 && i4 < 0) {
            alVar.h = false;
        }
        if (!cellLayoutC.a(view, z ? 0 : -1, iv.a(j, j2, i, i2, i3, i4), alVar, !(view instanceof Folder))) {
            Launcher.a("JLog", "Failed to add to item at (" + alVar.f109a + "," + alVar.b + ") to CellLayout", true);
        }
        if (!(view instanceof Folder)) {
            view.setHapticFeedbackEnabled(false);
            view.setOnLongClickListener(this.H);
        }
        if (view instanceof ce) {
            this.aS.a((ce) view);
        }
    }

    public void a(View view, bz bzVar) {
        Rect rect;
        Point point;
        Bitmap bitmapA = a(view, new Canvas(), 2);
        int width = bitmapA.getWidth();
        int height = bitmapA.getHeight();
        float fA = this.aQ.f().a(view, this.bk);
        int iRound = Math.round(this.bk[0] - ((width - (view.getWidth() * fA)) / 2.0f));
        int iRound2 = Math.round((this.bk[1] - ((height - (height * fA)) / 2.0f)) - 1.0f);
        bl blVarA = ip.a().i().a();
        if ((view instanceof BubbleTextView) || (view instanceof PagedViewIcon)) {
            int i = blVarA.u;
            int paddingTop = view.getPaddingTop();
            int i2 = (width - i) / 2;
            int i3 = i2 + i;
            int i4 = paddingTop + i;
            iRound2 += paddingTop;
            Point point2 = new Point(-1, 1);
            rect = new Rect(i2, paddingTop, i3, i4);
            point = point2;
        } else if (view instanceof FolderIcon) {
            rect = new Rect(0, view.getPaddingTop(), view.getWidth(), blVarA.z);
            point = null;
        } else {
            rect = null;
            point = null;
        }
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).b();
        }
        this.aS.a(bitmapA, iRound, iRound2, bzVar, view.getTag(), bo.f138a, point, rect, fA);
        if (view.getParent() instanceof mo) {
            this.aD = (mo) view.getParent();
        }
        bitmapA.recycle();
    }

    @Override // com.android.launcher6.bz
    public void a(View view, cg cgVar, boolean z, boolean z2) {
        if (this.bU) {
            this.bT = new ol(this, view, cgVar, z, z2);
            return;
        }
        boolean z3 = this.bT != null;
        if (!z2 || (z3 && !this.bV)) {
            if (this.aH != null) {
                c(this.aH.f).b(this.aH.f107a);
            }
        } else if (view != this && this.aH != null) {
            CellLayout cellLayoutB = b(this.aH.f107a);
            if (cellLayoutB != null) {
                cellLayoutB.removeView(this.aH.f107a);
            }
            if (this.aH.f107a instanceof ce) {
                this.aS.b((ce) this.aH.f107a);
            }
            X();
        }
        if ((cgVar.j || (z3 && !this.bV)) && this.aH.f107a != null) {
            this.aH.f107a.setVisibility(0);
        }
        new om(this).run();
        this.bi = null;
        this.aH = null;
    }

    void a(View view, float[] fArr) {
        fArr[0] = fArr[0] + view.getLeft();
        fArr[1] = fArr[1] + view.getTop();
    }

    void a(View view, float[] fArr, Matrix matrix) {
        fArr[0] = fArr[0] - view.getLeft();
        fArr[1] = fArr[1] - view.getTop();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:27:0x007f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:47:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1 A[SYNTHETIC] */
    void a(CellLayout cellLayout, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        FolderIcon folderIcon;
        ArrayList itemsInReadingOrder;
        int i;
        mp mpVar;
        ComponentName component;
        Uri data;
        int childCount = cellLayout.getShortcutsAndWidgets().getChildCount();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < childCount; i2++) {
            arrayList3.add(cellLayout.getShortcutsAndWidgets().getChildAt(i2));
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View view = (View) arrayList3.get(i3);
            Object tag = view.getTag();
            if (tag instanceof ec) {
                ec ecVar = (ec) tag;
                if (ecVar instanceof mp) {
                    mp mpVar2 = (mp) ecVar;
                    ComponentName component2 = mpVar2.f396a.getComponent();
                    Uri data2 = mpVar2.f396a.getData();
                    if (data2 == null || data2.equals(Uri.EMPTY)) {
                        if (arrayList.contains(component2)) {
                            if (z) {
                                cellLayout.removeViewInLayout(view);
                                iv.b(this.aQ, mpVar2);
                            }
                            if (arrayList2 != null) {
                                arrayList2.add(component2);
                            }
                        } else {
                            arrayList.add(component2);
                        }
                        if (view instanceof FolderIcon) {
                            folderIcon = (FolderIcon) view;
                            itemsInReadingOrder = folderIcon.getFolder().getItemsInReadingOrder();
                            for (i = 0; i < itemsInReadingOrder.size(); i++) {
                                if (((View) itemsInReadingOrder.get(i)).getTag() instanceof mp) {
                                    mpVar = (mp) ((View) itemsInReadingOrder.get(i)).getTag();
                                    component = mpVar.f396a.getComponent();
                                    data = mpVar.f396a.getData();
                                    if (data != null || data.equals(Uri.EMPTY)) {
                                        if (arrayList.contains(component)) {
                                            if (z) {
                                                folderIcon.getFolderInfo().b(mpVar);
                                                iv.b(this.aQ, mpVar);
                                            }
                                            if (arrayList2 != null) {
                                                arrayList2.add(component);
                                            }
                                        } else {
                                            arrayList.add(component);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (view instanceof FolderIcon) {
                    folderIcon = (FolderIcon) view;
                    itemsInReadingOrder = folderIcon.getFolder().getItemsInReadingOrder();
                    while (i < itemsInReadingOrder.size()) {
                        if (((View) itemsInReadingOrder.get(i)).getTag() instanceof mp) {
                            mpVar = (mp) ((View) itemsInReadingOrder.get(i)).getTag();
                            component = mpVar.f396a.getComponent();
                            data = mpVar.f396a.getData();
                            if (data != null) {
                                if (arrayList.contains(component)) {
                                    arrayList.add(component);
                                } else {
                                    if (z) {
                                        folderIcon.getFolderInfo().b(mpVar);
                                        iv.b(this.aQ, mpVar);
                                    }
                                    if (arrayList2 != null) {
                                        arrayList2.add(component);
                                    }
                                }
                            } else if (arrayList.contains(component)) {
                                arrayList.add(component);
                            } else {
                                if (z) {
                                    folderIcon.getFolderInfo().b(mpVar);
                                    iv.b(this.aQ, mpVar);
                                }
                                if (arrayList2 != null) {
                                    arrayList2.add(component);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, float f) {
        this.bS = f;
    }

    @Override // com.android.launcher6.ks
    public void a(Launcher launcher, boolean z, boolean z2) {
        aE();
    }

    void a(aj ajVar) {
        View view = ajVar.f107a;
        if (view.isInTouchMode()) {
            this.aH = ajVar;
            view.setVisibility(4);
            ((CellLayout) view.getParent().getParent()).a(view);
            view.clearFocus();
            view.setPressed(false);
            this.bi = b(view, new Canvas(), 2);
            a(view, this);
        }
    }

    @Override // com.android.launcher6.bp
    public void a(bz bzVar, Object obj, int i) {
        this.h = true;
        e(false);
        this.aQ.U();
        this.aQ.A();
        setChildrenBackgroundAlphaMultipliers(1.0f);
        InstallShortcutReceiver.a();
        UninstallShortcutReceiver.a();
        post(new op(this));
    }

    @Override // com.android.launcher6.ce
    public void a(cg cgVar, int i, int i2, PointF pointF) {
    }

    public void a(ec ecVar, CellLayout cellLayout, ca caVar, Runnable runnable, int i, View view, boolean z) {
        Rect rect = new Rect();
        this.aQ.f().b(caVar, rect);
        int[] iArr = new int[2];
        float[] fArr = new float[2];
        a(iArr, fArr, caVar, cellLayout, ecVar, this.aI, z, !(ecVar instanceof me));
        int integer = this.aQ.getResources().getInteger(R.integer.config_dropAnimMaxDuration) - 200;
        if ((view instanceof AppWidgetHostView) && z) {
            Log.d("JLog", "6557954 Animate widget drop, final view is appWidgetHostView");
            this.aQ.f().removeView(view);
        }
        if ((i == 2 || z) && view != null) {
            caVar.setCrossFadeBitmap(a(ecVar, view));
            caVar.a((int) (integer * 0.8f));
        } else if (ecVar.g == 4 && z) {
            float fMin = Math.min(fArr[0], fArr[1]);
            fArr[1] = fMin;
            fArr[0] = fMin;
        }
        DragLayer dragLayerF = this.aQ.f();
        if (i == 4) {
            this.aQ.f().a(caVar, iArr, 0.0f, 0.1f, 0.1f, 0, runnable, integer);
        } else {
            dragLayerF.a(caVar, rect.left, rect.top, iArr[0], iArr[1], 1.0f, 1.0f, 1.0f, fArr[0], fArr[1], new ok(this, view, runnable), i == 1 ? 2 : 0, integer, this);
        }
    }

    public void a(md mdVar, Bitmap bitmap, boolean z) {
        Canvas canvas = new Canvas();
        int[] iArrA = a(mdVar.l, mdVar.m, (ec) mdVar, false);
        this.bi = a(bitmap, canvas, 2, iArrA[0], iArrA[1], z);
    }

    void a(mp mpVar, CellLayout cellLayout, long j, long j2, int i, int i2, boolean z, int i3, int i4) {
        View viewA = this.aQ.a(R.layout.application, cellLayout, mpVar);
        int[] iArr = new int[2];
        cellLayout.a(iArr, 1, 1, i3, i4);
        a(viewA, j, j2, iArr[0], iArr[1], 1, 1, z);
        iv.a(this.aQ, mpVar, j, j2, iArr[0], iArr[1]);
    }

    void a(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        Iterator it = getWorkspaceAndHotseatCellLayouts().iterator();
        while (it.hasNext()) {
            mo shortcutsAndWidgets = ((CellLayout) it.next()).getShortcutsAndWidgets();
            int childCount = shortcutsAndWidgets.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Object tag = shortcutsAndWidgets.getChildAt(i).getTag();
                if (tag instanceof ec) {
                    hashSet2.add((ec) tag);
                }
            }
        }
        iv.a(hashSet2, new on(this, hashSet, hashSet3));
        a(hashSet3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(HashSet hashSet) {
        for (CellLayout cellLayout : getWorkspaceAndHotseatCellLayouts()) {
            mo shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= shortcutsAndWidgets.getChildCount()) {
                    break;
                }
                View childAt = shortcutsAndWidgets.getChildAt(i2);
                Object tag = childAt.getTag();
                if (tag instanceof ec) {
                    map.put((ec) tag, childAt);
                }
                i = i2 + 1;
            }
            ArrayList<View> arrayList = new ArrayList();
            HashMap map2 = new HashMap();
            iv.a(map.keySet(), new oo(this, hashSet, map2, arrayList, map));
            for (dg dgVar : map2.keySet()) {
                Iterator it = ((ArrayList) map2.get(dgVar)).iterator();
                while (it.hasNext()) {
                    dgVar.b((mp) it.next());
                }
            }
            for (View view : arrayList) {
                cellLayout.removeViewInLayout(view);
                if (view instanceof ce) {
                    this.aS.b((ce) view);
                }
            }
            if (arrayList.size() > 0) {
                shortcutsAndWidgets.requestLayout();
                shortcutsAndWidgets.invalidate();
            }
        }
        X();
    }

    @Override // com.android.launcher6.li
    protected void a(int[] iArr) {
        int iAh = ah();
        int childCount = getChildCount() - 1;
        iArr[0] = Math.max(0, Math.min(iAh, getChildCount() - 1));
        iArr[1] = Math.max(0, childCount);
    }

    @Override // com.android.launcher6.by
    public boolean a(int i, int i2, int i3) {
        boolean z = !ip.b(getContext());
        if (this.aQ.D() != null && z) {
            Rect rect = new Rect();
            this.aQ.D().getHitRect(rect);
            if (rect.contains(i, i2)) {
                return false;
            }
        }
        if (ak() || this.be || getOpenFolder() != null) {
            return false;
        }
        this.bg = true;
        int nextPage = (i3 == 0 ? -1 : 1) + getNextPage();
        setCurrentDropLayout(null);
        if (nextPage < 0 || nextPage >= getChildCount() || a(nextPage) == -301) {
            return false;
        }
        setCurrentDragOverlappingLayout((CellLayout) getChildAt(nextPage));
        invalidate();
        return true;
    }

    boolean a(int i, int i2, Rect rect) {
        if (rect == null) {
            new Rect();
        }
        this.aU[0] = i;
        this.aU[1] = i2;
        this.aQ.f().a((View) this, this.aU, true);
        return ip.a().i().a().a().contains(this.aU[0], this.aU[1]);
    }

    boolean a(View view, long j, CellLayout cellLayout, int[] iArr, float f, boolean z, ca caVar, Runnable runnable) {
        if (f > this.bA) {
            return false;
        }
        View viewF = cellLayout.f(iArr[0], iArr[1]);
        boolean z2 = false;
        if (this.aH != null) {
            z2 = this.aH.b == iArr[0] && this.aH.c == iArr[1] && b(this.aH.f107a) == cellLayout;
        }
        if (viewF == null || z2 || !this.bx) {
            return false;
        }
        this.bx = false;
        long jA = iArr == null ? this.aH.f : a(cellLayout);
        boolean z3 = viewF.getTag() instanceof mp;
        boolean z4 = view.getTag() instanceof mp;
        if (!z3 || !z4) {
            return false;
        }
        mp mpVar = (mp) view.getTag();
        mp mpVar2 = (mp) viewF.getTag();
        if (!z) {
            b(this.aH.f107a).removeView(this.aH.f107a);
        }
        Rect rect = new Rect();
        float fA = this.aQ.f().a(viewF, rect);
        cellLayout.removeView(viewF);
        FolderIcon folderIconA = this.aQ.a(cellLayout, j, jA, iArr[0], iArr[1]);
        mpVar2.j = -1;
        mpVar2.k = -1;
        mpVar.j = -1;
        mpVar.k = -1;
        if (caVar != null) {
            folderIconA.a(mpVar2, viewF, mpVar, caVar, rect, fA, runnable);
        } else {
            folderIconA.a(mpVar2);
            folderIconA.a(mpVar);
        }
        return true;
    }

    boolean a(View view, CellLayout cellLayout, int[] iArr, float f, cg cgVar, boolean z) {
        if (f > this.bA) {
            return false;
        }
        View viewF = cellLayout.f(iArr[0], iArr[1]);
        if (!this.by) {
            return false;
        }
        this.by = false;
        if (viewF instanceof FolderIcon) {
            FolderIcon folderIcon = (FolderIcon) viewF;
            if (folderIcon.a(cgVar.g)) {
                folderIcon.a(cgVar);
                if (!z) {
                    b(this.aH.f107a).removeView(this.aH.f107a);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.android.launcher6.ce
    public boolean a(cg cgVar) {
        int i;
        int i2;
        int i3;
        int i4;
        CellLayout cellLayout = this.aP;
        if (cgVar.h != this) {
            if (cellLayout == null || !av()) {
                return false;
            }
            this.aW = a(cgVar.f151a, cgVar.b, cgVar.c, cgVar.d, cgVar.f, this.aW);
            if (!this.aQ.b(cellLayout)) {
                a(cellLayout, this.aW, (Matrix) null);
            }
            if (this.aH != null) {
                aj ajVar = this.aH;
                i = ajVar.d;
                i2 = ajVar.e;
            } else {
                ec ecVar = (ec) cgVar.g;
                i = ecVar.l;
                i2 = ecVar.m;
            }
            if (cgVar.g instanceof mf) {
                i4 = ((mf) cgVar.g).n;
                i3 = ((mf) cgVar.g).o;
            } else {
                i3 = i2;
                i4 = i;
            }
            this.aI = a((int) this.aW[0], (int) this.aW[1], i4, i3, cellLayout, this.aI);
            float fA = cellLayout.a(this.aW[0], this.aW[1], this.aI);
            if (a((ec) cgVar.g, cellLayout, this.aI, fA, true) || a((ec) cgVar.g, cellLayout, this.aI, fA)) {
                return true;
            }
            this.aI = cellLayout.a((int) this.aW[0], (int) this.aW[1], i4, i3, i, i2, (View) null, this.aI, new int[2], 3);
            if (!(this.aI[0] >= 0 && this.aI[1] >= 0)) {
                boolean zB = this.aQ.b(cellLayout);
                if (this.aI != null) {
                }
                this.aQ.a(zB);
                return false;
            }
        }
        if (a(cellLayout) == -201) {
            W();
        }
        return true;
    }

    boolean a(ec ecVar, CellLayout cellLayout, int[] iArr, float f, boolean z) {
        if (f > this.bA) {
            return false;
        }
        View viewF = cellLayout.f(iArr[0], iArr[1]);
        if (viewF != null) {
            al alVar = (al) viewF.getLayoutParams();
            if (alVar.e && (alVar.c != alVar.f109a || alVar.d != alVar.d)) {
                return false;
            }
        }
        boolean z2 = this.aH != null && viewF == this.aH.f107a;
        if (viewF == null || z2) {
            return false;
        }
        if (!z || this.bx) {
            return (viewF.getTag() instanceof mp) && (ecVar.g == 0 || ecVar.g == 1);
        }
        return false;
    }

    boolean a(Object obj, CellLayout cellLayout, int[] iArr, float f) {
        if (f > this.bA) {
            return false;
        }
        View viewF = cellLayout.f(iArr[0], iArr[1]);
        if (viewF != null) {
            al alVar = (al) viewF.getLayoutParams();
            if (alVar.e && (alVar.c != alVar.f109a || alVar.d != alVar.d)) {
                return false;
            }
        }
        return (viewF instanceof FolderIcon) && ((FolderIcon) viewF).a(obj);
    }

    public int[] a(int i, int i2, ec ecVar, boolean z) {
        int[] iArr = new int[2];
        if (getChildCount() <= 0) {
            iArr[0] = Integer.MAX_VALUE;
            iArr[1] = Integer.MAX_VALUE;
            return iArr;
        }
        Rect rectA = a((CellLayout) getChildAt(ah()), ecVar, 0, 0, i, i2);
        iArr[0] = rectA.width();
        iArr[1] = rectA.height();
        if (z) {
            iArr[0] = (int) (iArr[0] * this.ba);
            iArr[1] = (int) (iArr[1] * this.ba);
        }
        return iArr;
    }

    protected void aa() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            CellLayout cellLayout = (CellLayout) getChildAt(i);
            mo shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            int childCount2 = shortcutsAndWidgets.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt = shortcutsAndWidgets.getChildAt(i2);
                if (childAt.getTag() instanceof it) {
                    it itVar = (it) childAt.getTag();
                    is isVar = (is) itVar.e;
                    if (isVar != null && isVar.b()) {
                        this.aQ.a(itVar);
                        cellLayout.removeView(isVar);
                        this.aQ.b(itVar);
                    }
                }
            }
        }
    }

    protected void ab() {
        WallpaperPickerActivity.a(this.aQ.getResources(), this.aQ.getSharedPreferences(WallpaperCropActivity.c(), 0), this.aQ.getWindowManager(), this.az);
    }

    void ac() {
        if (ak() || this.be) {
            return;
        }
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
        }
        this.m = ik.a(this, "childrenOutlineAlpha", 1.0f);
        this.m.setDuration(100L);
        this.m.start();
    }

    void ad() {
        if (ak() || this.be) {
            return;
        }
        if (this.m != null) {
            this.m.cancel();
        }
        if (this.n != null) {
            this.n.cancel();
        }
        this.n = ik.a(this, "childrenOutlineAlpha", 0.0f);
        this.n.setDuration(375L);
        this.n.setStartDelay(0L);
        this.n.start();
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (this.aQ.J()) {
            return;
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.addFocusables(arrayList, i);
        } else {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void ae() {
        if (this.ai || N()) {
            return;
        }
        n(this.v);
    }

    public boolean af() {
        return this.aG.size() > l + 1 && ((Long) this.aG.get(l)).longValue() == -301;
    }

    public boolean ag() {
        return this.aG.size() > LauncherApplication.f88a.getResources().getInteger(R.integer.apps_customepage_count) + (-1) && ((Long) this.aG.get(0)).longValue() == -302;
    }

    public int ah() {
        if (af()) {
            return l + 1;
        }
        return 0;
    }

    public boolean ai() {
        return af() && getNextPage() == 0;
    }

    protected void aj() {
        View.OnClickListener pageIndicatorClickListener;
        if (getPageIndicator() != null && (pageIndicatorClickListener = getPageIndicatorClickListener()) != null) {
            getPageIndicator().setOnClickListener(pageIndicatorClickListener);
        }
        aE = ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
    }

    public boolean ak() {
        return this.bd == pb.SMALL || this.bd == pb.SPRING_LOADED || this.bd == pb.OVERVIEW;
    }

    void al() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            CellLayout cellLayout = (CellLayout) getChildAt(i);
            cellLayout.setChildrenDrawnWithCacheEnabled(false);
            if (!isHardwareAccelerated()) {
                cellLayout.setChildrenDrawingCacheEnabled(false);
            }
        }
    }

    public void am() {
        e(true);
        if (getWindowToken() != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((CellLayout) getChildAt(i)).c();
            }
        }
        e(false);
    }

    public void an() {
        this.aQ.f().a();
    }

    public boolean ao() {
        return this.bd == pb.OVERVIEW;
    }

    public boolean ap() {
        if (this.F != 0) {
            return false;
        }
        if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.wallpaper_show)) {
            return true;
        }
        a(true, -1, true);
        return true;
    }

    boolean aq() {
        return !ai() && this.bd == pb.NORMAL;
    }

    public void ar() {
        if (this.bd != pb.NORMAL) {
            this.aQ.A();
        } else {
            this.aQ.z();
        }
    }

    void as() {
        int i = this.bd == pb.NORMAL ? 0 : 4;
        if (af()) {
            ((CellLayout) this.aF.get(-301L)).setVisibility(i);
        }
    }

    void at() {
        if ((this.bd == pb.NORMAL) && af()) {
            ((CellLayout) this.aF.get(-301L)).setVisibility(0);
        }
    }

    void au() {
        if ((this.bd != pb.NORMAL) && af()) {
            ((CellLayout) this.aF.get(-301L)).setVisibility(4);
        }
    }

    public boolean av() {
        return (!Y() || this.bS > 0.5f) && this.bd != pb.SMALL;
    }

    public void aw() {
        this.bU = true;
    }

    public void ax() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (!this.bH.contains(Integer.valueOf(i))) {
                r(i);
            }
        }
        this.bH.clear();
        this.bG = null;
    }

    void ay() {
        for (mo moVar : getAllShortcutAndWidgetContainers()) {
            int childCount = moVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                KeyEvent.Callback childAt = moVar.getChildAt(i);
                if (childAt instanceof ce) {
                    this.aS.b((ce) childAt);
                }
            }
        }
    }

    public long b(long j) {
        return a(j, getChildCount());
    }

    public View b(Object obj) {
        for (mo moVar : getAllShortcutAndWidgetContainers()) {
            int childCount = moVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = moVar.getChildAt(i);
                if (childAt.getTag() == obj) {
                    return childAt;
                }
            }
        }
        return null;
    }

    CellLayout b(View view) {
        for (CellLayout cellLayout : getWorkspaceAndHotseatCellLayouts()) {
            if (cellLayout.getShortcutsAndWidgets().indexOfChild(view) > -1) {
                return cellLayout;
            }
        }
        return null;
    }

    @Override // com.android.launcher6.bp
    public void b() {
        this.h = false;
        e(false);
        this.aQ.l(false);
        InstallShortcutReceiver.a(getContext());
        UninstallShortcutReceiver.a(getContext());
        U();
        this.aD = null;
        this.aQ.z();
    }

    public void b(int i) {
        if (i >= 0) {
            CellLayout cellLayout = (CellLayout) getChildAt(i);
            setScrollX(this.bI);
            cellLayout.setTranslationX(this.bK);
            cellLayout.setRotationY(this.bJ);
        }
    }

    @Override // com.android.launcher6.li
    protected void b(MotionEvent motionEvent) {
        boolean z = true;
        if (Z()) {
            float x = motionEvent.getX() - this.bB;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(motionEvent.getY() - this.bC);
            if (Float.compare(fAbs, 0.0f) != 0) {
                float fAtan = (float) Math.atan(fAbs2 / fAbs);
                if (fAbs > this.I || fAbs2 > this.I) {
                    B();
                }
                boolean z2 = this.aw - this.ax > 200;
                if (m()) {
                    if (x >= 0.0f) {
                        z = false;
                    }
                } else if (x <= 0.0f) {
                    z = false;
                }
                if (!(z && a(getCurrentPage()) == -301 && z2) && fAtan <= 1.0471976f) {
                    if (fAtan > 0.5235988f) {
                        super.a(motionEvent, (((float) Math.sqrt((fAtan - 0.5235988f) / 0.5235988f)) * 4.0f) + 1.0f);
                    } else {
                        super.b(motionEvent);
                    }
                }
            }
        }
    }

    void b(View view, long j, long j2, int i, int i2, int i3, int i4) {
        com.syu.g.i.a().a("addInScreen-2  screenId = " + j2 + " x = " + i + " y = " + i2);
        a(view, j, j2, i, i2, i3, i4, false, true);
    }

    public void b(CellLayout cellLayout) {
        if (Y()) {
            setScaleX(this.bL);
            setScaleY(this.bL);
        }
    }

    @Override // com.android.launcher6.ks
    public void b(Launcher launcher, boolean z, boolean z2) {
    }

    @Override // com.android.launcher6.ce
    public void b(cg cgVar) {
        boolean z;
        int i;
        is isVar;
        AppWidgetProviderInfo appWidgetInfo;
        this.aW = a(cgVar.f151a, cgVar.b, cgVar.c, cgVar.d, cgVar.f, this.aW);
        CellLayout cellLayout = this.aP;
        if (cellLayout != null && !this.aQ.b(cellLayout)) {
            a(cellLayout, this.aW, (Matrix) null);
        }
        int iD = -1;
        if (cgVar.h != this) {
            a(new int[]{(int) this.aW[0], (int) this.aW[1]}, cgVar.g, cellLayout, false, cgVar);
            return;
        }
        if (this.aH != null) {
            View view = this.aH.f107a;
            ow owVar = null;
            if (cellLayout == null || cgVar.j) {
                z = false;
                i = -1;
            } else {
                boolean z2 = b(view) != cellLayout;
                boolean zB = this.aQ.b(cellLayout);
                long j = zB ? -101 : -100;
                long jA = this.aI[0] < 0 ? this.aH.f : a(cellLayout);
                int i2 = this.aH != null ? this.aH.d : 1;
                int i3 = this.aH != null ? this.aH.e : 1;
                this.aI = a((int) this.aW[0], (int) this.aW[1], i2, i3, cellLayout, this.aI);
                float fA = cellLayout.a(this.aW[0], this.aW[1], this.aI);
                if (!this.bg && a(view, j, cellLayout, this.aI, fA, false, cgVar.f, (Runnable) null)) {
                    X();
                    return;
                }
                if (a(view, cellLayout, this.aI, fA, cgVar, false)) {
                    X();
                    return;
                }
                ec ecVar = (ec) cgVar.g;
                int i4 = ecVar.l;
                int i5 = ecVar.m;
                if (ecVar.n > 0 && ecVar.o > 0) {
                    i4 = ecVar.n;
                    i5 = ecVar.o;
                }
                int[] iArr = new int[2];
                this.aI = cellLayout.a((int) this.aW[0], (int) this.aW[1], i4, i5, i2, i3, view, this.aI, iArr, 1);
                boolean z3 = this.aI[0] >= 0 && this.aI[1] >= 0;
                if (z3 && (view instanceof AppWidgetHostView) && (iArr[0] != ecVar.l || iArr[1] != ecVar.m)) {
                    ecVar.l = iArr[0];
                    ecVar.m = iArr[1];
                    e.a((AppWidgetHostView) view, this.aQ, iArr[0], iArr[1]);
                    z = true;
                } else {
                    z = false;
                }
                if (a(this.v) != jA && !zB) {
                    iD = d(jA);
                    n(iD);
                }
                int i6 = iD;
                if (z3) {
                    ec ecVar2 = (ec) view.getTag();
                    if (z2) {
                        b(view).removeView(view);
                        a(view, j, jA, this.aI[0], this.aI[1], ecVar2.l, ecVar2.m);
                    }
                    al alVar = (al) view.getLayoutParams();
                    int i7 = this.aI[0];
                    alVar.c = i7;
                    alVar.f109a = i7;
                    int i8 = this.aI[1];
                    alVar.d = i8;
                    alVar.b = i8;
                    alVar.f = ecVar.l;
                    alVar.g = ecVar.m;
                    alVar.h = true;
                    view.setId(iv.a(j, this.aH.f, this.aI[0], this.aI[1], this.aH.d, this.aH.e));
                    ow owVar2 = (j == -101 || !(view instanceof is) || (appWidgetInfo = (isVar = (is) view).getAppWidgetInfo()) == null || appWidgetInfo.resizeMode == 0) ? null : new ow(this, new ov(this, ecVar2, isVar, cellLayout));
                    iv.a(this.aQ, ecVar2, j, jA, alVar.f109a, alVar.b, ecVar.l, ecVar.m);
                    owVar = owVar2;
                    i = i6;
                } else {
                    al alVar2 = (al) view.getLayoutParams();
                    this.aI[0] = alVar2.f109a;
                    this.aI[1] = alVar2.b;
                    ((CellLayout) view.getParent().getParent()).c(view);
                    i = i6;
                }
            }
            CellLayout cellLayout2 = (CellLayout) view.getParent().getParent();
            Runnable ohVar = new oh(this, owVar);
            this.g = true;
            if (cgVar.f.b()) {
                ec ecVar3 = (ec) view.getTag();
                if (ecVar3.g == 4) {
                    a(ecVar3, cellLayout2, cgVar.f, ohVar, z ? 2 : 0, view, false);
                } else {
                    this.aQ.f().a(cgVar.f, view, i < 0 ? -1 : HttpStatus.SC_MULTIPLE_CHOICES, ohVar, this);
                }
            } else {
                cgVar.k = false;
                view.setVisibility(0);
            }
            cellLayout2.b(view);
        }
    }

    void b(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(((d) it.next()).d);
        }
        a(hashSet);
    }

    public void b(boolean z) {
        a(-1, z);
    }

    public CellLayout c(long j) {
        return (CellLayout) this.aF.get(Long.valueOf(j));
    }

    @Override // com.android.launcher6.bz
    public void c() {
    }

    @Override // com.android.launcher6.li
    public void c(int i, boolean z) {
    }

    void c(CellLayout cellLayout) {
        int i;
        int childCount = cellLayout.getShortcutsAndWidgets().getChildCount();
        long jA = a(cellLayout);
        if (this.aQ.b(cellLayout)) {
            jA = -1;
            i = -101;
        } else {
            i = -100;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ec ecVar = (ec) cellLayout.getShortcutsAndWidgets().getChildAt(i2).getTag();
            if (ecVar != null && ecVar.p) {
                ecVar.p = false;
                iv.a(this.aQ, ecVar, i, jA, ecVar.j, ecVar.k, ecVar.l, ecVar.m);
            }
        }
    }

    @Override // com.android.launcher6.ks
    public void c(Launcher launcher, boolean z, boolean z2) {
        aF();
    }

    @Override // com.android.launcher6.ce
    public void c(cg cgVar) {
        this.bz.a();
        this.bx = false;
        this.by = false;
        this.aP = null;
        CellLayout currentDropLayout = getCurrentDropLayout();
        setCurrentDropLayout(currentDropLayout);
        setCurrentDragOverlappingLayout(currentDropLayout);
        if (ip.a().j()) {
            ac();
        }
    }

    void c(ArrayList arrayList) {
        for (mo moVar : getAllShortcutAndWidgetContainers()) {
            int childCount = moVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = moVar.getChildAt(i);
                Object tag = childAt.getTag();
                if ((tag instanceof ec) && iv.b((ec) tag)) {
                    mp mpVar = (mp) tag;
                    ComponentName component = mpVar.f396a.getComponent();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d dVar = (d) arrayList.get(i2);
                        if (dVar.d.equals(component)) {
                            mpVar.b(this.aR);
                            mpVar.q = dVar.q.toString();
                            ((BubbleTextView) childAt).a(mpVar, this.aR);
                        }
                    }
                }
            }
        }
    }

    public void c(boolean z) {
        this.bU = false;
        this.bV = z;
        if (this.bT != null) {
            this.bT.run();
        }
    }

    @Override // com.android.launcher6.li, com.android.launcher6.by
    public void c_() {
        if (!ak() && !this.be) {
            super.c_();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.j();
        }
    }

    @Override // com.android.launcher6.mq, com.android.launcher6.li, android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.j.b();
    }

    public int d(long j) {
        return indexOfChild((View) this.aF.get(Long.valueOf(j)));
    }

    void d(int i, int i2) {
        if (i == this.aJ && i2 == this.aK) {
            return;
        }
        this.aJ = i;
        this.aK = i2;
        setDragMode(0);
    }

    @Override // com.android.launcher6.ce
    public void d(cg cgVar) {
        if (this.bg || this.be || this.bd == pb.SMALL) {
            return;
        }
        Rect rect = new Rect();
        ec ecVar = (ec) cgVar.g;
        if (ecVar.l < 0 || ecVar.m < 0) {
            throw new RuntimeException("Improper spans found");
        }
        this.aW = a(cgVar.f151a, cgVar.b, cgVar.c, cgVar.d, cgVar.f, this.aW);
        View view = this.aH == null ? null : this.aH.f107a;
        if (ak()) {
            if (this.aQ.D() != null && !g(cgVar)) {
                a(cgVar.f151a, cgVar.b, rect);
            }
            CellLayout cellLayoutA = 0 == 0 ? a(cgVar.f, cgVar.f151a, cgVar.b, false) : null;
            if (cellLayoutA != this.aN) {
                setCurrentDropLayout(cellLayoutA);
                setCurrentDragOverlappingLayout(cellLayoutA);
                if (this.bd == pb.SPRING_LOADED) {
                    if (this.aQ.b(cellLayoutA)) {
                        this.aZ.a();
                    } else {
                        this.aZ.a(this.aN);
                    }
                }
            }
        } else {
            if (this.aQ.D() != null && !f(cgVar)) {
                a(cgVar.f151a, cgVar.b, rect);
            }
            CellLayout currentDropLayout = 0 == 0 ? getCurrentDropLayout() : null;
            if (currentDropLayout != this.aN) {
                setCurrentDropLayout(currentDropLayout);
                setCurrentDragOverlappingLayout(currentDropLayout);
            }
        }
        if (this.aN != null) {
            if (!this.aQ.b(this.aN)) {
                a(this.aN, this.aW, (Matrix) null);
            }
            ec ecVar2 = (ec) cgVar.g;
            int i = ecVar.l;
            int i2 = ecVar.m;
            if (ecVar.n > 0 && ecVar.o > 0) {
                i = ecVar.n;
                i2 = ecVar.o;
            }
            this.aI = a((int) this.aW[0], (int) this.aW[1], i, i2, this.aN, this.aI);
            int i3 = this.aI[0];
            int i4 = this.aI[1];
            d(this.aI[0], this.aI[1]);
            float fA = this.aN.a(this.aW[0], this.aW[1], this.aI);
            View viewF = this.aN.f(this.aI[0], this.aI[1]);
            if (getResources().getBoolean(R.bool.supportFolder)) {
                a(ecVar2, this.aN, this.aI, fA, viewF);
            }
            boolean zA = this.aN.a((int) this.aW[0], (int) this.aW[1], ecVar.l, ecVar.m, view, this.aI);
            if (!zA) {
                this.aN.a(view, this.bi, (int) this.aW[0], (int) this.aW[1], this.aI[0], this.aI[1], ecVar.l, ecVar.m, false, cgVar.f.getDragVisualizeOffset(), cgVar.f.getDragRegion());
            } else if ((this.bD == 0 || this.bD == 3) && !this.bu.b() && (this.bE != i3 || this.bF != i4)) {
                this.bu.a(new pa(this, this.aW, i, i2, ecVar.l, ecVar.m, cgVar.f, view));
                this.bu.a(250L);
            }
            if ((this.bD == 1 || this.bD == 2 || !zA) && this.aN != null) {
                this.aN.g();
            }
        }
    }

    void d(boolean z) {
        b(this.aC, z);
    }

    @Override // com.android.launcher6.bz
    public boolean d() {
        return true;
    }

    @Override // com.android.launcher6.li, com.android.launcher6.by
    public void d_() {
        if (!ak() && !this.be) {
            super.d_();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.bG = sparseArray;
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (ak() || !Z()) {
            return false;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    float e(float f) {
        if (f < 0.1f) {
            return 0.0f;
        }
        if (f > 0.4f) {
            return 1.0f;
        }
        return (f - 0.1f) / (0.4f - 0.1f);
    }

    @Override // com.android.launcher6.li
    protected void e(int i) {
        boolean zM = m();
        super.e(i);
        s(i);
        t(i);
        aB();
        if (!((this.aa < 0 && (!af() || m())) || (this.aa > this.z && !(af() && m())))) {
            if (this.bm) {
                this.bm = false;
                ((CellLayout) getChildAt(l - 1)).d();
                ((CellLayout) getChildAt(getChildCount() - 1)).d();
                return;
            }
            return;
        }
        int childCount = getChildCount() - 1;
        boolean z = this.aa < 0;
        int i2 = ((zM || !z) && (!zM || z)) ? childCount : 0;
        float f = z ? 0.75f : 0.25f;
        CellLayout cellLayout = (CellLayout) getChildAt(i2);
        float fA = a(i, cellLayout, i2);
        cellLayout.a(Math.abs(fA), z);
        float f2 = fA * (-24.0f);
        if (this.bm && Float.compare(this.bn, f) == 0) {
            return;
        }
        this.bm = true;
        this.bn = f;
        cellLayout.setCameraDistance(this.r * this.bs);
        cellLayout.setPivotX(f * cellLayout.getMeasuredWidth());
        cellLayout.setPivotY(cellLayout.getMeasuredHeight() * 0.5f);
        cellLayout.setOverscrollTransformsDirty(true);
    }

    @Override // com.android.launcher6.ce
    public void e(cg cgVar) {
        this.bz.c();
        if (!this.bg) {
            this.aP = this.aN;
        } else if (v()) {
            this.aP = (CellLayout) c(getNextPage());
        } else {
            this.aP = this.aO;
        }
        if (this.bD == 1) {
            this.bx = true;
        } else if (this.bD == 2) {
            this.by = true;
        }
        aI();
        setCurrentDropLayout(null);
        setCurrentDragOverlappingLayout(null);
        this.aZ.a();
        if (this.ai) {
            return;
        }
        ad();
    }

    @Override // com.android.launcher6.li
    protected boolean e(View view) {
        CellLayout cellLayout = (CellLayout) view;
        return super.e(view) && (this.be || cellLayout.getShortcutsAndWidgets().getAlpha() > 0.0f || cellLayout.getBackgroundAlpha() > 0.0f);
    }

    @Override // com.android.launcher6.ce
    public boolean e_() {
        return true;
    }

    @Override // com.android.launcher6.li
    public void f() {
    }

    @Override // com.android.launcher6.li
    protected void g() {
        super.g();
        if (isHardwareAccelerated()) {
            e(false);
        } else {
            al();
        }
        if (this.aS.a()) {
            if (ak()) {
                this.aS.e();
            }
        } else if (ip.a().j()) {
            ad();
        }
        if (this.bp != null) {
            this.bp.run();
            this.bp = null;
        }
        if (this.bq != null) {
            this.bq.run();
            this.bq = null;
        }
        if (this.bf) {
            X();
            this.bf = false;
        }
    }

    ArrayList getAllShortcutAndWidgetContainers() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(((CellLayout) getChildAt(i)).getShortcutsAndWidgets());
        }
        this.aQ.D();
        return arrayList;
    }

    public float getBackgroundAlpha() {
        return this.av;
    }

    public float getChildrenOutlineAlpha() {
        return this.ar;
    }

    @Override // com.android.launcher6.ks
    public View getContent() {
        return this;
    }

    public CellLayout getCurrentDropLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    @Override // com.android.launcher6.li
    protected String getCurrentPageDescription() {
        int i = this.y != -1 ? this.y : this.v;
        int iAh = ah();
        return (af() && getNextPage() == 0) ? this.aM : String.format(getContext().getString(R.string.workspace_scroll_format), Integer.valueOf((i + 1) - iAh), Integer.valueOf(getChildCount() - iAh));
    }

    protected id getCustomContentCallbacks() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (ak()) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    public aj getDragInfo() {
        return this.aH;
    }

    Folder getOpenFolder() {
        DragLayer dragLayerF = this.aQ.f();
        int childCount = dragLayerF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dragLayerF.getChildAt(i);
            if (childAt instanceof Folder) {
                Folder folder = (Folder) childAt;
                if (folder.getInfo().f177a) {
                    return folder;
                }
            }
        }
        return null;
    }

    int getOverviewModeTranslationY() {
        return this.bc - (((getViewportHeight() - ((int) (getNormalChildHeight() * this.bb))) / 2) / 4);
    }

    @Override // com.android.launcher6.li
    protected View.OnClickListener getPageIndicatorClickListener() {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            return new or(this);
        }
        return null;
    }

    @Override // com.android.launcher6.li
    protected String getPageIndicatorDescription() {
        return String.valueOf(getCurrentPageDescription()) + ", " + getResources().getString(R.string.settings_button_text);
    }

    public int getRestorePage() {
        return getNextPage() - ah();
    }

    ArrayList getScreenOrder() {
        return this.aG;
    }

    @Override // com.android.launcher6.mq
    protected int getScrollMode() {
        return 1;
    }

    ArrayList getWorkspaceAndHotseatCellLayouts() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            arrayList.add((CellLayout) getChildAt(i));
        }
        this.aQ.D();
        return arrayList;
    }

    @Override // com.android.launcher6.li
    protected lh h(int i) {
        if (a(i) != -201 || this.aG.size() - ah() <= 1) {
            return super.h(i);
        }
        return LauncherApplication.f88a.getResources().getBoolean(R.bool.app_indicator) ? new lh(a.b.a().ba, a.b.a().bb) : new lh(a.b.a().bc, R.drawable.ic_pageindicator_add);
    }

    @Override // com.android.launcher6.by
    public boolean i() {
        if (!this.bg) {
            return false;
        }
        invalidate();
        CellLayout currentDropLayout = getCurrentDropLayout();
        setCurrentDropLayout(currentDropLayout);
        setCurrentDragOverlappingLayout(currentDropLayout);
        this.bg = false;
        return true;
    }

    protected void j() {
        getContext();
        this.v = this.aC;
        Launcher.a(this.v);
        ip ipVarA = ip.a();
        bl blVarA = ipVarA.i().a();
        this.aR = ipVarA.d();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        setChildrenDrawnWithCacheEnabled(true);
        setMinScale(this.bb - 0.2f);
        aA();
        try {
            this.au = getResources().getDrawable(R.drawable.apps_customize_bg);
        } catch (Resources.NotFoundException e) {
        }
        this.j = new pc(this);
        this.aQ.getWindowManager().getDefaultDisplay().getSize(this.br);
        this.bA = 0.55f * blVarA.u;
        this.o = (int) (500.0f * this.r);
    }

    void k() {
        setLayoutTransition(this.ay);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.aA = getWindowToken();
        computeScroll();
        this.aS.a(this.aA);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (!(view2 instanceof CellLayout)) {
            throw new IllegalArgumentException("A Workspace can only have CellLayout children.");
        }
        CellLayout cellLayout = (CellLayout) view2;
        cellLayout.setOnInterceptTouchListener(this);
        cellLayout.setClickable(true);
        cellLayout.setImportantForAccessibility(2);
        super.onChildViewAdded(view, view2);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aA = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.au != null && this.av > 0.0f && this.b) {
            this.au.setAlpha((int) (this.av * 255.0f));
            this.au.setBounds(getScrollX(), 0, getScrollX() + getMeasuredWidth(), getMeasuredHeight());
            this.au.draw(canvas);
        }
        super.onDraw(canvas);
        post(this.bW);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bB = motionEvent.getX();
                this.bC = motionEvent.getY();
                this.aw = System.currentTimeMillis();
                break;
            case 1:
            case 6:
                if (this.F == 0 && !((CellLayout) getChildAt(this.v)).k()) {
                    a(motionEvent);
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.u && this.v >= 0 && this.v < getChildCount()) {
            this.j.b();
            this.j.d();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.android.launcher6.li, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (this.aQ.J()) {
            return false;
        }
        Folder openFolder = getOpenFolder();
        return openFolder != null ? openFolder.requestFocus(i, rect) : super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        Launcher.a(this.v);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return (!ak() && Z() && (ak() || indexOfChild(view) == this.v)) ? false : true;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        this.aQ.c(i);
    }

    public void r(int i) {
        if (this.bG != null) {
            this.bH.add(Integer.valueOf(i));
            ((CellLayout) getChildAt(i)).a(this.bG);
        }
    }

    @Override // com.android.launcher6.li
    protected void s() {
        super.s();
        Launcher.a(this.v);
        if (af() && getNextPage() == 0 && !this.f) {
            this.f = true;
            if (this.e != null) {
                this.e.a();
                this.ax = System.currentTimeMillis();
                this.aQ.j(false);
            }
        } else if (af() && getNextPage() != 0 && this.f) {
            this.f = false;
            if (this.e != null) {
                this.e.b();
                this.aQ.k();
                this.aQ.j(false);
            }
        }
        if (getPageIndicator() != null) {
            getPageIndicator().setContentDescription(getPageIndicatorDescription());
        }
    }

    public void setBackgroundAlpha(float f) {
        if (f != this.av) {
            this.av = f;
            invalidate();
        }
    }

    public void setChildrenOutlineAlpha(float f) {
        this.ar = f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            ((CellLayout) getChildAt(i2)).setBackgroundAlpha(f);
            i = i2 + 1;
        }
    }

    void setCurrentDragOverlappingLayout(CellLayout cellLayout) {
        if (this.aO != null) {
            this.aO.setIsDragOverlapping(false);
        }
        this.aO = cellLayout;
        if (this.aO != null) {
            this.aO.setIsDragOverlapping(true);
        }
        invalidate();
    }

    void setCurrentDropLayout(CellLayout cellLayout) {
        if (this.aN != null) {
            this.aN.g();
            this.aN.j();
        }
        this.aN = cellLayout;
        if (this.aN != null) {
            this.aN.i();
        }
        f(true);
        aG();
        d(-1, -1);
    }

    void setDragMode(int i) {
        if (i != this.bD) {
            if (i == 0) {
                aH();
                f(false);
                aG();
            } else if (i == 2) {
                f(true);
                aG();
            } else if (i == 1) {
                aH();
                f(true);
            } else if (i == 3) {
                aH();
                aG();
            }
            this.bD = i;
        }
    }

    public void setFinalScrollForPageChange(int i) {
        CellLayout cellLayout = (CellLayout) getChildAt(i);
        if (cellLayout != null) {
            this.bI = getScrollX();
            this.bK = cellLayout.getTranslationX();
            this.bJ = cellLayout.getRotationY();
            setScrollX(j(i));
            cellLayout.setTranslationX(0.0f);
            cellLayout.setRotationY(0.0f);
        }
    }

    public void setFinalTransitionTransform(CellLayout cellLayout) {
        if (Y()) {
            this.bL = getScaleX();
            setScaleX(this.bM);
            setScaleY(this.bM);
        }
    }

    @Override // com.android.launcher6.dy
    public void setInsets(Rect rect) {
        this.ap.set(rect);
    }

    void setup(bo boVar) {
        this.aZ = new mt(this.aQ);
        this.aS = boVar;
        e(false);
        ab();
    }

    @Override // com.android.launcher6.li
    protected void w() {
        int i = 0;
        super.w();
        if (isHardwareAccelerated()) {
            e(false);
        } else if (this.y != -1) {
            a(this.v, this.y);
        } else {
            a(this.v - 1, this.v + 1);
        }
        if (ip.a().j()) {
            ac();
        }
        if (this.bo) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            ((CellLayout) c(i2)).setShortcutAndWidgetAlpha(1.0f);
            i = i2 + 1;
        }
    }
}
