package com.android.launcher6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class FolderIcon extends LinearLayout implements dh {
    da b;
    boolean c;
    private Launcher d;
    private Folder e;
    private dg f;
    private ar h;
    private ImageView i;
    private BubbleTextView j;
    private int k;
    private float l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private Rect s;
    private df t;
    private df u;
    private ArrayList v;
    private static boolean g = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Drawable f81a = null;

    public FolderIcon(Context context) {
        super(context);
        this.b = null;
        this.o = -1;
        this.c = false;
        this.s = new Rect();
        this.t = new df(this, 0.0f, 0.0f, 0.0f, 0);
        this.u = new df(this, 0.0f, 0.0f, 0.0f, 0);
        this.v = new ArrayList();
        c();
    }

    public FolderIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.o = -1;
        this.c = false;
        this.s = new Rect();
        this.t = new df(this, 0.0f, 0.0f, 0.0f, 0);
        this.u = new df(this, 0.0f, 0.0f, 0.0f, 0);
        this.v = new ArrayList();
        c();
    }

    private float a(int i, int[] iArr) {
        this.t = a(Math.min(3, i), this.t);
        this.t.f176a += this.p;
        this.t.b += this.q;
        float f = this.t.f176a + ((this.t.c * this.k) / 2.0f);
        float f2 = this.t.b + ((this.t.c * this.k) / 2.0f);
        iArr[0] = Math.round(f);
        iArr[1] = Math.round(f2);
        return this.t.c;
    }

    static FolderIcon a(int i, Launcher launcher, ViewGroup viewGroup, dg dgVar, dv dvVar) {
        FolderIcon folderIcon = (FolderIcon) LayoutInflater.from(launcher).inflate(i, viewGroup, false);
        folderIcon.setClipToPadding(false);
        folderIcon.j = (BubbleTextView) folderIcon.findViewById(R.id.folder_icon_name);
        folderIcon.j.setText(dgVar.q);
        folderIcon.i = (ImageView) folderIcon.findViewById(R.id.preview_background);
        bl blVarA = ip.a().i().a();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) folderIcon.i.getLayoutParams();
        layoutParams.topMargin = blVarA.y;
        layoutParams.width = blVarA.z;
        layoutParams.height = blVarA.z;
        folderIcon.setTag(dgVar);
        folderIcon.setOnClickListener(launcher);
        folderIcon.f = dgVar;
        folderIcon.d = launcher;
        folderIcon.setContentDescription(String.format(launcher.getString(R.string.folder_name_format), dgVar.q));
        Folder folderA = Folder.a(launcher);
        folderA.setDragController(launcher.t());
        folderA.setFolderIcon(folderIcon);
        folderA.a(dgVar);
        folderIcon.e = folderA;
        folderIcon.b = new da(launcher, folderIcon);
        dgVar.a(folderIcon);
        return folderIcon;
    }

    private df a(int i, df dfVar) {
        float f = (((3 - i) - 1) * 1.0f) / 2.0f;
        float f2 = 1.0f - (0.35f * (1.0f - f));
        float f3 = (1.0f - f) * this.r;
        float f4 = this.m * f2;
        float f5 = (1.0f - f2) * this.m;
        float paddingTop = (this.n - ((f4 + f3) + f5)) + getPaddingTop();
        float f6 = f3 + f5;
        float f7 = this.l * f2;
        int i2 = (int) ((1.0f - f) * 80.0f);
        if (dfVar == null) {
            return new df(this, f6, paddingTop, f7, i2);
        }
        dfVar.f176a = f6;
        dfVar.b = paddingTop;
        dfVar.c = f7;
        dfVar.d = i2;
        return dfVar;
    }

    private void a(int i, int i2) {
        if (this.k == i && this.o == i2) {
            return;
        }
        bl blVarA = ip.a().i().a();
        this.k = i;
        this.o = i2;
        int i3 = this.i.getLayoutParams().height;
        int i4 = da.i;
        this.n = i3 - (i4 * 2);
        this.l = (((int) ((this.n / 2) * 1.8f)) * 1.0f) / ((int) (this.k * 1.24f));
        this.m = (int) (this.k * this.l);
        this.r = this.m * 0.24f;
        this.p = (this.o - this.n) / 2;
        this.q = blVarA.y + i4;
    }

    private void a(Canvas canvas, df dfVar) {
        canvas.save();
        canvas.translate(dfVar.f176a + this.p, dfVar.b + this.q);
        canvas.scale(dfVar.c, dfVar.c);
        Drawable drawable = dfVar.e;
        if (drawable != null) {
            this.s.set(drawable.getBounds());
            drawable.setBounds(0, 0, this.k, this.k);
            drawable.setFilterBitmap(true);
            drawable.setColorFilter(Color.argb(dfVar.d, 255, 255, 255), PorterDuff.Mode.SRC_ATOP);
            drawable.draw(canvas);
            drawable.clearColorFilter();
            drawable.setFilterBitmap(false);
            drawable.setBounds(this.s);
        }
        canvas.restore();
    }

    private void a(Drawable drawable) {
        a(drawable.getIntrinsicWidth(), getMeasuredWidth());
    }

    private void a(Drawable drawable, int i, boolean z, Runnable runnable) {
        df dfVarA = a(0, (df) null);
        float intrinsicWidth = (this.n - drawable.getIntrinsicWidth()) / 2;
        float intrinsicHeight = ((this.n - drawable.getIntrinsicHeight()) / 2) + getPaddingTop();
        this.u.e = drawable;
        ValueAnimator valueAnimatorA = ik.a(this, 0.0f, 1.0f);
        valueAnimatorA.addUpdateListener(new cy(this, z, intrinsicWidth, dfVarA, intrinsicHeight));
        valueAnimatorA.addListener(new cz(this, runnable));
        valueAnimatorA.setDuration(i);
        valueAnimatorA.start();
    }

    private void a(mp mpVar, ca caVar, Rect rect, float f, int i, Runnable runnable, cg cgVar) {
        Rect rect2;
        mpVar.j = -1;
        mpVar.k = -1;
        if (caVar == null) {
            a(mpVar);
            return;
        }
        DragLayer dragLayerF = this.d.f();
        Rect rect3 = new Rect();
        dragLayerF.b(caVar, rect3);
        if (rect == null) {
            rect2 = new Rect();
            Workspace workspaceI = this.d.I();
            workspaceI.setFinalTransitionTransform((CellLayout) getParent().getParent());
            float scaleX = getScaleX();
            float scaleY = getScaleY();
            setScaleX(1.0f);
            setScaleY(1.0f);
            f = dragLayerF.a(this, rect2);
            setScaleX(scaleX);
            setScaleY(scaleY);
            workspaceI.b((CellLayout) getParent().getParent());
        } else {
            rect2 = rect;
        }
        int[] iArr = new int[2];
        float fA = a(i, iArr);
        iArr[0] = Math.round(iArr[0] * f);
        iArr[1] = Math.round(iArr[1] * f);
        rect2.offset(iArr[0] - (caVar.getMeasuredWidth() / 2), iArr[1] - (caVar.getMeasuredHeight() / 2));
        float f2 = fA * f;
        dragLayerF.a(caVar, rect3, rect2, i < 3 ? 0.5f : 0.0f, 1.0f, 1.0f, f2, f2, HttpStatus.SC_BAD_REQUEST, new DecelerateInterpolator(2.0f), new AccelerateInterpolator(2.0f), runnable, 0, (View) null);
        a(mpVar);
        this.v.add(mpVar);
        this.e.c(mpVar);
        postDelayed(new cx(this, mpVar), 400L);
    }

    private boolean a(ec ecVar) {
        int i = ecVar.g;
        return ((i != 0 && i != 1) || this.e.m() || ecVar == this.f || this.f.f177a) ? false : true;
    }

    private void c() {
        this.h = new ar(this);
    }

    public void a() {
        this.b.b();
    }

    public void a(View view, Runnable runnable) {
        Drawable drawable = ((TextView) view).getCompoundDrawables()[1];
        a(drawable.getIntrinsicWidth(), view.getMeasuredWidth());
        a(drawable, HttpStatus.SC_OK, true, runnable);
    }

    public void a(cg cgVar) {
        mp mpVarC = cgVar.g instanceof d ? ((d) cgVar.g).c() : (mp) cgVar.g;
        this.e.l();
        a(mpVarC, cgVar.f, (Rect) null, 1.0f, this.f.b.size(), cgVar.i, cgVar);
    }

    public void a(mp mpVar) {
        this.f.a(mpVar);
    }

    public void a(mp mpVar, View view, mp mpVar2, ca caVar, Rect rect, float f, Runnable runnable) {
        Drawable drawable = ((TextView) view).getCompoundDrawables()[LauncherApplication.f88a.getResources().getInteger(R.integer.appNameAlign)];
        a(drawable.getIntrinsicWidth(), view.getMeasuredWidth());
        a(drawable, 350, false, null);
        a(mpVar);
        a(mpVar2, caVar, rect, f, 1, runnable, (cg) null);
    }

    @Override // com.android.launcher6.dh
    public void a(CharSequence charSequence) {
        this.j.setText(charSequence.toString());
        setContentDescription(String.format(getContext().getString(R.string.folder_name_format), charSequence));
    }

    public boolean a(Object obj) {
        return !this.e.n() && a((ec) obj);
    }

    public void b(Object obj) {
        if (this.e.n() || !a((ec) obj)) {
            return;
        }
        al alVar = (al) getLayoutParams();
        CellLayout cellLayout = (CellLayout) getParent().getParent();
        this.b.a(alVar.f109a, alVar.b);
        this.b.a(cellLayout);
        this.b.a();
        cellLayout.a(this.b);
    }

    public void c(Object obj) {
        a();
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.h.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.e == null) {
            return;
        }
        if (this.e.getItemCount() != 0 || this.c) {
            ArrayList itemsInReadingOrder = this.e.getItemsInReadingOrder();
            if (this.c) {
                a(this.u.e);
            } else {
                a(((TextView) itemsInReadingOrder.get(0)).getCompoundDrawables()[1]);
            }
            int iMin = Math.min(itemsInReadingOrder.size(), 3);
            if (this.c) {
                a(canvas, this.u);
                return;
            }
            for (int i = iMin - 1; i >= 0; i--) {
                TextView textView = (TextView) itemsInReadingOrder.get(i);
                if (!this.v.contains(textView.getTag())) {
                    Drawable drawable = textView.getCompoundDrawables()[1];
                    this.t = a(i, this.t);
                    this.t.e = drawable;
                    a(canvas, this.t);
                }
            }
        }
    }

    @Override // com.android.launcher6.dh
    public void e(mp mpVar) {
        invalidate();
        requestLayout();
    }

    @Override // com.android.launcher6.dh
    public void f(mp mpVar) {
        invalidate();
        requestLayout();
    }

    Folder getFolder() {
        return this.e;
    }

    dg getFolderInfo() {
        return this.f;
    }

    public boolean getTextVisible() {
        return this.j.getVisibility() == 0;
    }

    @Override // com.android.launcher6.dh
    public void o() {
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        g = true;
        return super.onSaveInstanceState();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.h.a();
                return zOnTouchEvent;
            case 1:
            case 3:
                this.h.b();
                return zOnTouchEvent;
            case 2:
            default:
                return zOnTouchEvent;
        }
    }

    public void setTextVisible(boolean z) {
        if (z) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(4);
        }
    }
}
