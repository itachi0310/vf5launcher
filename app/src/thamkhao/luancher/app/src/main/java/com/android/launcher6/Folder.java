package com.android.launcher6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class Folder extends LinearLayout implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener, TextView.OnEditorActionListener, bz, ce, dh {
    private static String M;
    private static String N;
    private a A;
    private a B;
    private int C;
    private Rect D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private float I;
    private float J;
    private boolean K;
    private InputMethodManager L;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private android.a.a.d.a S;
    private Runnable T;
    private boolean U;
    private boolean V;
    private ActionMode.Callback W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected bo f79a;
    protected Launcher b;
    protected dg c;
    protected CellLayout d;
    boolean e;
    boolean f;
    FolderEditText g;
    lf h;
    lf i;
    private int j;
    private ScrollView k;
    private final LayoutInflater l;
    private final dv m;
    private int n;
    private boolean o;
    private FolderIcon p;
    private int q;
    private int r;
    private int s;
    private ArrayList t;
    private Drawable u;
    private mp v;
    private View w;
    private int[] x;
    private int[] y;
    private int[] z;

    public Folder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = -1;
        this.o = false;
        this.t = new ArrayList();
        this.e = false;
        this.f = false;
        this.x = new int[2];
        this.y = new int[2];
        this.z = new int[2];
        this.A = new a();
        this.B = new a();
        this.D = new Rect();
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.K = false;
        this.O = 0;
        this.P = 1;
        this.Q = this.O;
        this.W = new co(this);
        this.h = new cp(this);
        this.i = new cq(this);
        ip ipVarA = ip.a();
        bl blVarA = ipVarA.i().a();
        setAlwaysDrawnWithCacheEnabled(false);
        this.l = LayoutInflater.from(context);
        this.m = ipVarA.d();
        Resources resources = getResources();
        this.q = (int) blVarA.e;
        this.r = (int) blVarA.d;
        this.s = this.q * this.r;
        this.L = (InputMethodManager) getContext().getSystemService("input_method");
        this.j = resources.getInteger(R.integer.config_folderAnimDuration);
        if (M == null) {
            M = resources.getString(R.string.folder_name);
        }
        if (N == null) {
            N = resources.getString(R.string.folder_hint_text);
        }
        this.b = (Launcher) context;
        setFocusableInTouchMode(true);
    }

    static Folder a(Context context) {
        return (Folder) LayoutInflater.from(context).inflate(R.layout.user_folder, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
            onInitializeAccessibilityEvent(accessibilityEventObtain);
            accessibilityEventObtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    private void a(ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            mp mpVar = (mp) arrayList.get(i);
            i++;
            i2 = mpVar.j > i2 ? mpVar.j : i2;
        }
        Collections.sort(arrayList, new cv(this, i2 + 1));
        int countX = this.d.getCountX();
        for (int i3 = 0; i3 < size; i3++) {
            mp mpVar2 = (mp) arrayList.get(i3);
            mpVar2.j = i3 % countX;
            mpVar2.k = i3 / countX;
        }
    }

    private float[] a(int i, int i2, int i3, int i4, ca caVar, float[] fArr) {
        if (fArr == null) {
            fArr = new float[2];
        }
        fArr[0] = (i - i3) + (caVar.getDragRegion().width() / 2);
        fArr[1] = (i2 - i4) + (caVar.getDragRegion().height() / 2);
        return fArr;
    }

    private void b(ArrayList arrayList) {
        int[] iArr = new int[2];
        if (arrayList == null) {
            arrayList = getItemsInReadingOrder();
        }
        this.d.removeAllViews();
        for (int i = 0; i < arrayList.size(); i++) {
            View view = (View) arrayList.get(i);
            this.d.b(iArr, 1, 1);
            al alVar = (al) view.getLayoutParams();
            alVar.f109a = iArr[0];
            alVar.b = iArr[1];
            ec ecVar = (ec) view.getTag();
            if (ecVar.j != iArr[0] || ecVar.k != iArr[1]) {
                ecVar.j = iArr[0];
                ecVar.k = iArr[1];
                iv.a(this.b, ecVar, this.c.f, 0L, ecVar.j, ecVar.k);
            }
            this.d.a(view, -1, (int) ecVar.f, alVar, true);
        }
        this.e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int[] iArr2) {
        int i = 0;
        float f = 30.0f;
        if (!a(iArr2, iArr)) {
            int i2 = iArr[0] == 0 ? iArr[1] - 1 : iArr[1];
            while (i2 >= iArr2[1]) {
                int countX = i2 == iArr[1] ? iArr[0] - 1 : this.d.getCountX() - 1;
                int i3 = i2 > iArr2[1] ? 0 : iArr2[0];
                float f2 = f;
                for (int i4 = countX; i4 >= i3; i4--) {
                    if (this.d.a(this.d.f(i4, i2), iArr[0], iArr[1], 230, i, true, true)) {
                        iArr[0] = i4;
                        iArr[1] = i2;
                        i = (int) (i + f2);
                        f2 = (float) (((double) f2) * 0.9d);
                    }
                }
                i2--;
                f = f2;
            }
            return;
        }
        int i5 = iArr[0] >= this.d.getCountX() + (-1) ? iArr[1] + 1 : iArr[1];
        float f3 = 30.0f;
        while (i5 <= iArr2[1]) {
            int i6 = i5 == iArr[1] ? iArr[0] + 1 : 0;
            int countX2 = i5 < iArr2[1] ? this.d.getCountX() - 1 : iArr2[0];
            float f4 = f3;
            for (int i7 = i6; i7 <= countX2; i7++) {
                if (this.d.a(this.d.f(i7, i5), iArr[0], iArr[1], 230, i, true, true)) {
                    iArr[0] = i7;
                    iArr[1] = i5;
                    i = (int) (i + f4);
                    f4 = (float) (((double) f4) * 0.9d);
                }
            }
            i5++;
            f3 = f4;
        }
    }

    private View g(mp mpVar) {
        for (int i = 0; i < this.d.getCountY(); i++) {
            for (int i2 = 0; i2 < this.d.getCountX(); i2++) {
                View viewF = this.d.f(i2, i);
                if (viewF.getTag() == mpVar) {
                    return viewF;
                }
            }
        }
        return null;
    }

    private int getContentAreaHeight() {
        bl blVarA = ip.a().i().a();
        Rect rectA = blVarA.a(blVarA.j ? 0 : 1);
        return Math.min((((((blVarA.t - (blVarA.o * 4)) - rectA.top) - rectA.bottom) - getPaddingTop()) - getPaddingBottom()) - this.C, this.d.getDesiredHeight());
    }

    private int getFolderHeight() {
        return getPaddingTop() + getPaddingBottom() + getContentAreaHeight() + this.C;
    }

    private void p() {
        if (getParent() instanceof DragLayer) {
            setScaleX(0.8f);
            setScaleY(0.8f);
            setAlpha(0.0f);
            this.n = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        View viewF = this.d.f(0, 0);
        if (viewF != null) {
            viewF.requestFocus();
        }
    }

    private void r() {
        ArrayList itemsInReadingOrder = getItemsInReadingOrder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= itemsInReadingOrder.size()) {
                return;
            }
            ec ecVar = (ec) ((View) itemsInReadingOrder.get(i2)).getTag();
            iv.b(this.b, ecVar, this.c.f, 0L, ecVar.j, ecVar.k);
            i = i2 + 1;
        }
    }

    private void s() {
        ArrayList itemsInReadingOrder = getItemsInReadingOrder();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < itemsInReadingOrder.size(); i++) {
            arrayList.add((ec) ((View) itemsInReadingOrder.get(i)).getTag());
        }
        iv.a(this.b, arrayList, this.c.f, 0);
    }

    private void setupContentDimensions(int i) {
        int iMax;
        int iMax2;
        int i2;
        int i3;
        ArrayList itemsInReadingOrder = getItemsInReadingOrder();
        int countX = this.d.getCountX();
        int countY = this.d.getCountY();
        boolean z = false;
        while (!z) {
            if (countX * countY < i) {
                if ((countX <= countY || countY == this.r) && countX < this.q) {
                    i2 = countX + 1;
                    i3 = countY;
                } else if (countY < this.r) {
                    i3 = countY + 1;
                    i2 = countX;
                } else {
                    i3 = countY;
                    i2 = countX;
                }
                if (i3 == 0) {
                    iMax2 = i2;
                    iMax = i3 + 1;
                } else {
                    iMax2 = i2;
                    iMax = i3;
                }
            } else if ((countY - 1) * countX >= i && countY >= countX) {
                iMax = Math.max(0, countY - 1);
                iMax2 = countX;
            } else if ((countX - 1) * countY >= i) {
                iMax = countY;
                iMax2 = Math.max(0, countX - 1);
            } else {
                iMax = countY;
                iMax2 = countX;
            }
            z = iMax2 == countX && iMax == countY;
            countY = iMax;
            countX = iMax2;
        }
        this.d.b(countX, countY);
        b(itemsInReadingOrder);
    }

    private void setupContentForNumItems(int i) {
        setupContentDimensions(i);
        if (((bw) getLayoutParams()) == null) {
            bw bwVar = new bw(0, 0);
            bwVar.c = true;
            setLayoutParams(bwVar);
        }
        t();
    }

    private void t() {
        bw bwVar = (bw) getLayoutParams();
        DragLayer dragLayer = (DragLayer) this.b.findViewById(R.id.drag_layer);
        int desiredWidth = this.d.getDesiredWidth() + getPaddingLeft() + getPaddingRight();
        int folderHeight = getFolderHeight();
        float fA = dragLayer.a(this.p, this.D);
        bl blVarA = ip.a().i().a();
        int iWidth = ((int) (this.D.left + ((this.D.width() * fA) / 2.0f))) - (desiredWidth / 2);
        int iHeight = ((int) (((fA * this.D.height()) / 2.0f) + this.D.top)) - (folderHeight / 2);
        int nextPage = this.b.I().getNextPage();
        this.b.I().setFinalScrollForPageChange(nextPage);
        mo shortcutsAndWidgets = ((CellLayout) this.b.I().getChildAt(nextPage)).getShortcutsAndWidgets();
        Rect rect = new Rect();
        dragLayer.a(shortcutsAndWidgets, rect);
        this.b.I().b(nextPage);
        int iMin = Math.min(Math.max(rect.left, iWidth), (rect.left + rect.width()) - desiredWidth);
        int iMin2 = Math.min(Math.max(rect.top, iHeight), (rect.top + rect.height()) - folderHeight);
        if (blVarA.b() && blVarA.s - desiredWidth < blVarA.u) {
            iMin = (blVarA.s - desiredWidth) / 2;
        } else if (desiredWidth >= rect.width()) {
            iMin = rect.left + ((rect.width() - desiredWidth) / 2);
        }
        if (folderHeight >= rect.height()) {
            iMin2 = rect.top + ((rect.height() - folderHeight) / 2);
        }
        int i = (desiredWidth / 2) + (iWidth - iMin);
        int i2 = (folderHeight / 2) + (iHeight - iMin2);
        setPivotX(i);
        setPivotY(i2);
        this.I = (int) (((i * 1.0f) / desiredWidth) * this.p.getMeasuredWidth());
        this.J = (int) (this.p.getMeasuredHeight() * ((i2 * 1.0f) / folderHeight));
        bwVar.width = desiredWidth;
        bwVar.height = folderHeight;
        bwVar.f145a = iMin;
        bwVar.b = iMin2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        DragLayer dragLayer = (DragLayer) getParent();
        if (dragLayer != null) {
            dragLayer.removeView(this);
        }
        this.f79a.b((ce) this);
        clearFocus();
        this.p.requestFocus();
        if (this.o) {
            setupContentForNumItems(getItemCount());
            this.o = false;
        }
        if (getItemCount() <= 1) {
            if (!this.E && !this.G) {
                v();
            } else if (this.E) {
                this.F = true;
            }
        }
        this.G = false;
    }

    private void v() {
        cu cuVar = new cu(this);
        View viewA = a(0);
        if (viewA != null) {
            this.p.a(viewA, cuVar);
        }
        this.R = true;
    }

    private void w() {
        View viewA = a(getItemCount() - 1);
        a(getItemCount() - 1);
        if (viewA != null) {
            this.g.setNextFocusDownId(viewA.getId());
            this.g.setNextFocusRightId(viewA.getId());
            this.g.setNextFocusLeftId(viewA.getId());
            this.g.setNextFocusUpId(viewA.getId());
        }
    }

    public View a(int i) {
        return this.d.getShortcutsAndWidgets().getChildAt(i);
    }

    @Override // com.android.launcher6.ce
    public void a(Rect rect) {
        getHitRect(rect);
    }

    @Override // com.android.launcher6.bz
    public void a(View view, cg cgVar, boolean z, boolean z2) {
        if (this.U) {
            Log.d("Launcher.Folder", "Deferred handling drop because waiting for uninstall.");
            this.T = new ct(this, view, cgVar, z, z2);
            return;
        }
        boolean z3 = z2 && (!(this.T != null) || this.V);
        if (!z3) {
            setupContentForNumItems(getItemCount());
            this.p.a(cgVar);
        } else if (this.F && !this.H) {
            v();
        }
        if (view != this && this.B.b()) {
            this.B.a();
            if (!z3) {
                this.G = true;
            }
            j();
        }
        this.F = false;
        this.E = false;
        this.H = false;
        this.v = null;
        this.w = null;
        this.f = false;
        s();
    }

    @Override // com.android.launcher6.ce
    public void a(cg cgVar, int i, int i2, PointF pointF) {
    }

    void a(dg dgVar) {
        this.c = dgVar;
        ArrayList arrayList = dgVar.b;
        ArrayList<mp> arrayList2 = new ArrayList();
        setupContentForNumItems(arrayList.size());
        a(arrayList);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            mp mpVar = (mp) arrayList.get(i2);
            if (b(mpVar)) {
                i++;
            } else {
                arrayList2.add(mpVar);
            }
        }
        setupContentForNumItems(i);
        for (mp mpVar2 : arrayList2) {
            this.c.b(mpVar2);
            iv.b(this.b, mpVar2);
        }
        this.e = true;
        w();
        this.c.a(this);
        if (M.contentEquals(this.c.q)) {
            this.g.setText("");
        } else {
            this.g.setText(this.c.q);
        }
        r();
    }

    @Override // com.android.launcher6.dh
    public void a(CharSequence charSequence) {
    }

    public void a(boolean z) {
        this.g.setHint(N);
        String string = this.g.getText().toString();
        this.c.a(string);
        iv.a((Context) this.b, (ec) this.c);
        if (z) {
            a(32, String.format(getContext().getString(R.string.folder_renamed), string));
        }
        requestFocus();
        Selection.setSelection(this.g.getText(), 0, 0);
        this.K = false;
    }

    @Override // com.android.launcher6.ce
    public boolean a(cg cgVar) {
        int i = ((ec) cgVar.g).g;
        return (i == 0 || i == 1) && !m();
    }

    protected boolean a(mp mpVar) {
        int[] iArr = new int[2];
        if (!this.d.a(iArr, mpVar.l, mpVar.m)) {
            return false;
        }
        mpVar.j = iArr[0];
        mpVar.k = iArr[1];
        return true;
    }

    boolean a(int[] iArr, int[] iArr2) {
        return iArr[1] > iArr2[1] || (iArr[1] == iArr2[1] && iArr[0] > iArr2[0]);
    }

    @Override // com.android.launcher6.ce
    public void b(cg cgVar) {
        mp mpVar;
        if (cgVar.g instanceof d) {
            mp mpVarC = ((d) cgVar.g).c();
            mpVarC.l = 1;
            mpVarC.m = 1;
            mpVar = mpVarC;
        } else {
            mpVar = (mp) cgVar.g;
        }
        if (mpVar == this.v) {
            mp mpVar2 = (mp) this.w.getTag();
            al alVar = (al) this.w.getLayoutParams();
            int i = this.z[0];
            alVar.f109a = i;
            mpVar2.j = i;
            int i2 = this.z[1];
            alVar.b = i2;
            mpVar2.j = i2;
            this.d.a(this.w, -1, (int) mpVar.f, alVar, true);
            if (cgVar.f.b()) {
                this.b.f().a(cgVar.f, this.w);
            } else {
                cgVar.k = false;
                this.w.setVisibility(0);
            }
            this.e = true;
            setupContentDimensions(getItemCount());
            this.f = true;
        }
        this.c.a(mpVar);
    }

    public void b(boolean z) {
        this.U = false;
        this.V = z;
        if (this.T != null) {
            this.T.run();
        }
    }

    public boolean b() {
        return this.K;
    }

    protected boolean b(mp mpVar) {
        BubbleTextView bubbleTextView = (BubbleTextView) this.l.inflate(R.layout.application, (ViewGroup) this, false);
        bubbleTextView.setCompoundDrawables(null, my.a(mpVar.a(this.m)), null, null);
        bubbleTextView.setText(mpVar.q);
        bubbleTextView.setTag(mpVar);
        bubbleTextView.setTextColor(getResources().getColor(R.color.folder_items_text_color));
        bubbleTextView.setShadowsEnabled(false);
        bubbleTextView.setOnClickListener(this);
        bubbleTextView.setOnLongClickListener(this);
        if (this.d.f(mpVar.j, mpVar.k) != null || mpVar.j < 0 || mpVar.k < 0 || mpVar.j >= this.d.getCountX() || mpVar.k >= this.d.getCountY()) {
            Log.e("Launcher.Folder", "Folder order not properly persisted during bind");
            if (!a(mpVar)) {
                return false;
            }
        }
        al alVar = new al(mpVar.j, mpVar.k, mpVar.l, mpVar.m);
        bubbleTextView.setOnKeyListener(new di());
        this.d.a((View) bubbleTextView, -1, (int) mpVar.f, alVar, true);
        return true;
    }

    @Override // com.android.launcher6.bz
    public void c() {
    }

    @Override // com.android.launcher6.ce
    public void c(cg cgVar) {
        this.y[0] = -1;
        this.y[1] = -1;
        this.B.a();
    }

    public void c(mp mpVar) {
        g(mpVar).setVisibility(4);
    }

    @Override // com.android.launcher6.ce
    public void d(cg cgVar) {
        com.syu.d.a.b("onDragOver(DragObject d)...");
        ca caVar = cgVar.f;
        int scrollY = this.k.getScrollY();
        float[] fArrA = a(cgVar.f151a, cgVar.b, cgVar.c, cgVar.d, caVar, null);
        fArrA[0] = fArrA[0] - getPaddingLeft();
        fArrA[1] = fArrA[1] - getPaddingTop();
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 2, cgVar.f151a, cgVar.b, 0);
        if (!this.S.a()) {
            this.S.a(true);
        }
        boolean zOnTouch = this.S.onTouch(this, motionEventObtain);
        motionEventObtain.recycle();
        if (zOnTouch) {
            this.A.a();
            return;
        }
        this.x = this.d.c((int) fArrA[0], ((int) fArrA[1]) + scrollY, 1, 1, this.x);
        if (i()) {
            this.x[0] = (this.d.getCountX() - this.x[0]) - 1;
        }
        if (this.x[0] == this.y[0] && this.x[1] == this.y[1]) {
            this.Q = this.O;
            return;
        }
        this.A.a();
        this.A.a(this.h);
        this.A.a(250L);
        this.y[0] = this.x[0];
        this.y[1] = this.x[1];
        this.Q = this.P;
    }

    public void d(mp mpVar) {
        g(mpVar).setVisibility(0);
    }

    @Override // com.android.launcher6.bz
    public boolean d() {
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public void e() {
        this.g.setHint("");
        this.K = true;
    }

    @Override // com.android.launcher6.ce
    public void e(cg cgVar) {
        this.S.a(false);
        if (!cgVar.e) {
            this.B.a(this.i);
            this.B.a(800L);
        }
        this.A.a();
        this.Q = this.O;
    }

    @Override // com.android.launcher6.dh
    public void e(mp mpVar) {
        this.e = true;
        if (this.f) {
            return;
        }
        if (!a(mpVar)) {
            setupContentForNumItems(getItemCount() + 1);
            a(mpVar);
        }
        b(mpVar);
        iv.a(this.b, mpVar, this.c.f, 0L, mpVar.j, mpVar.k);
    }

    @Override // com.android.launcher6.ce
    public boolean e_() {
        return true;
    }

    public void f() {
        this.L.hideSoftInputFromWindow(getWindowToken(), 0);
        a(true);
    }

    @Override // com.android.launcher6.dh
    public void f(mp mpVar) {
        this.e = true;
        if (mpVar == this.v) {
            return;
        }
        this.d.removeView(g(mpVar));
        if (this.n == 1) {
            this.o = true;
        } else {
            setupContentForNumItems(getItemCount());
        }
        if (getItemCount() <= 1) {
            v();
        }
    }

    public void g() {
        p();
        if (getParent() instanceof DragLayer) {
            t();
            ObjectAnimator objectAnimatorA = ik.a(this, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
            objectAnimatorA.addListener(new cr(this));
            objectAnimatorA.setDuration(this.j);
            setLayerType(2, null);
            objectAnimatorA.start();
        }
    }

    public Drawable getDragDrawable() {
        return this.u;
    }

    public View getEditTextRegion() {
        return this.g;
    }

    dg getInfo() {
        return this.c;
    }

    public int getItemCount() {
        return this.d.getShortcutsAndWidgets().getChildCount();
    }

    public ArrayList getItemsInReadingOrder() {
        if (this.e) {
            this.t.clear();
            for (int i = 0; i < this.d.getCountY(); i++) {
                for (int i2 = 0; i2 < this.d.getCountX(); i2++) {
                    View viewF = this.d.f(i2, i);
                    if (viewF != null) {
                        this.t.add(viewF);
                    }
                }
            }
            this.e = false;
        }
        return this.t;
    }

    float getPivotXForIconAnimation() {
        return this.I;
    }

    float getPivotYForIconAnimation() {
        return this.J;
    }

    public void h() {
        if (getParent() instanceof DragLayer) {
            ObjectAnimator objectAnimatorA = ik.a(this, PropertyValuesHolder.ofFloat("alpha", 0.0f), PropertyValuesHolder.ofFloat("scaleX", 0.9f), PropertyValuesHolder.ofFloat("scaleY", 0.9f));
            objectAnimatorA.addListener(new cs(this));
            objectAnimatorA.setDuration(this.j);
            setLayerType(2, null);
            objectAnimatorA.start();
        }
    }

    public boolean i() {
        return getLayoutDirection() == 1;
    }

    public void j() {
        this.b.C();
        this.v = null;
        this.w = null;
        this.f = false;
        this.o = true;
    }

    public void k() {
        this.U = true;
    }

    public void l() {
        if (this.E) {
            this.H = true;
        }
    }

    public boolean m() {
        return getItemCount() >= this.s;
    }

    boolean n() {
        return this.R;
    }

    @Override // com.android.launcher6.dh
    public void o() {
        w();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof mp) {
            this.b.onClick(view);
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        f();
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.k = (ScrollView) findViewById(R.id.scroll_view);
        this.d = (CellLayout) findViewById(R.id.folder_content);
        bl blVarA = ip.a().i().a();
        this.d.a(blVarA.A, blVarA.B);
        this.d.b(0, 0);
        this.d.getShortcutsAndWidgets().setMotionEventSplittingEnabled(false);
        this.d.setInvertIfRtl(true);
        this.g = (FolderEditText) findViewById(R.id.folder_name);
        this.g.setFolder(this);
        this.g.setOnFocusChangeListener(this);
        this.g.measure(0, 0);
        this.C = this.g.getMeasuredHeight();
        this.g.setCustomSelectionActionModeCallback(this.W);
        this.g.setOnEditorActionListener(this);
        this.g.setSelectAllOnFocus(true);
        this.g.setInputType(this.g.getInputType() | 524288 | 8192);
        this.S = new cw(this.k);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view == this.g && z) {
            e();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.b.g()) {
            return true;
        }
        Object tag = view.getTag();
        if (tag instanceof mp) {
            mp mpVar = (mp) tag;
            if (!view.isInTouchMode()) {
                return false;
            }
            this.b.dismissFolderCling(null);
            this.b.I().a(view);
            this.b.I().a(view, this);
            this.u = ((TextView) view).getCompoundDrawables()[1];
            this.v = mpVar;
            this.z[0] = mpVar.j;
            this.z[1] = mpVar.k;
            this.w = view;
            this.d.removeView(this.w);
            this.c.b(this.v);
            this.E = true;
            this.H = false;
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight() + this.d.getDesiredWidth();
        int folderHeight = getFolderHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.d.getDesiredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getContentAreaHeight(), 1073741824);
        this.d.e(this.d.getDesiredWidth(), this.d.getDesiredHeight());
        this.k.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.g.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.C, 1073741824));
        setMeasuredDimension(paddingLeft, folderHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setDragController(bo boVar) {
        this.f79a = boVar;
    }

    void setFolderIcon(FolderIcon folderIcon) {
        this.p = folderIcon;
    }
}
