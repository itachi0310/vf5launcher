package com.android.launcher6;

import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDropTarget extends ac {
    private static int f = 285;
    private static int g = 350;
    private static float h = 0.035f;
    private static int i = 0;
    private static int j = 1;
    private final int k;
    private ColorStateList l;
    private TransitionDrawable m;
    private TransitionDrawable n;
    private TransitionDrawable o;
    private boolean p;

    public DeleteDropTarget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DeleteDropTarget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = j;
        this.p = false;
    }

    private ValueAnimator.AnimatorUpdateListener a(DragLayer dragLayer, cg cgVar, PointF pointF, long j2, int i2, ViewConfiguration viewConfiguration) {
        Rect rect = new Rect();
        dragLayer.b(cgVar.f, rect);
        return new bk(dragLayer, pointF, rect, j2, h);
    }

    private ValueAnimator.AnimatorUpdateListener a(DragLayer dragLayer, cg cgVar, PointF pointF, ViewConfiguration viewConfiguration) {
        Rect rectA = a(cgVar.f.getMeasuredWidth(), cgVar.f.getMeasuredHeight(), this.o.getIntrinsicWidth(), this.o.getIntrinsicHeight());
        Rect rect = new Rect();
        dragLayer.b(cgVar.f, rect);
        int iMin = (int) (Math.min(1.0f, Math.abs(pointF.length()) / (viewConfiguration.getScaledMaximumFlingVelocity() / 2.0f)) * (-rect.top));
        int i2 = (int) (iMin / (pointF.y / pointF.x));
        float f2 = iMin + rect.top;
        float f3 = rect.left + i2;
        return new bh(this, dragLayer, new bg(this), rect.left, f3, rectA.left, rect.top, f2, rectA.top);
    }

    private boolean a(bz bzVar, Object obj) {
        return (bzVar instanceof AppsCustomizePagedView) && (obj instanceof d);
    }

    public static boolean a(Object obj) {
        if ((obj instanceof mp) && ((mp) obj).q.equals(Launcher.o.getResources().getString(R.string.apps))) {
            return false;
        }
        if (obj instanceof ec) {
            ec ecVar = (ec) obj;
            if (ecVar.g == 4) {
                return obj.toString().substring(0, 9).contains("AppWidget");
            }
            if (ecVar.g == 1) {
                return true;
            }
            if (!AppsCustomizePagedView.b && ecVar.g == 2) {
                return true;
            }
            if (!AppsCustomizePagedView.b && ecVar.g == 0 && (ecVar instanceof d)) {
                return (((d) obj).e & 1) != 0;
            }
            if (ecVar.g == 0 && (ecVar instanceof mp)) {
                if (AppsCustomizePagedView.b && (((mp) obj).s & 1) == 0) {
                    return false;
                }
                return true;
            }
        }
        com.syu.g.i.a().a("DeleteDropTarget willAcceptDrop false");
        return false;
    }

    private boolean b(bz bzVar, Object obj) {
        if ((bzVar instanceof AppsCustomizePagedView) && (obj instanceof md)) {
            switch (((md) obj).g) {
                case 1:
                case 4:
                    return true;
            }
        }
        return false;
    }

    private void c() {
        this.o.startTransition(this.f101a);
        setTextColor(this.e);
    }

    private void d() {
        this.o.resetTransition();
        setTextColor(this.l);
    }

    private boolean f(cg cgVar) {
        return (cgVar.h instanceof Workspace) || (cgVar.h instanceof Folder);
    }

    private boolean g(cg cgVar) {
        return f(cgVar) && (cgVar.g instanceof mp);
    }

    private boolean h(cg cgVar) {
        return f(cgVar) && (cgVar.g instanceof it);
    }

    private boolean i(cg cgVar) {
        return (cgVar.h instanceof Workspace) && (cgVar.g instanceof dg);
    }

    private void j(cg cgVar) {
        DragLayer dragLayerF = this.b.f();
        Rect rect = new Rect();
        dragLayerF.b(cgVar.f, rect);
        Rect rectA = a(cgVar.f.getMeasuredWidth(), cgVar.f.getMeasuredHeight(), this.o.getIntrinsicWidth(), this.o.getIntrinsicHeight());
        float fWidth = rectA.width() / rect.width();
        this.c.c();
        k(cgVar);
        dragLayerF.a(cgVar.f, rect, rectA, fWidth, 1.0f, 1.0f, 0.1f, 0.1f, f, new DecelerateInterpolator(2.0f), new LinearInterpolator(), new bd(this, cgVar), 0, (View) null);
    }

    private void k(cg cgVar) {
        this.p = false;
        if (l(cgVar)) {
            if (cgVar.h instanceof Folder) {
                ((Folder) cgVar.h).k();
            } else if (cgVar.h instanceof Workspace) {
                ((Workspace) cgVar.h).aw();
            }
            this.p = true;
        }
    }

    private boolean l(cg cgVar) {
        if (AppsCustomizePagedView.b && g(cgVar)) {
            mp mpVar = (mp) cgVar.g;
            if (mpVar.f396a != null && mpVar.f396a.getComponent() != null) {
                Set<String> categories = mpVar.f396a.getCategories();
                if (categories != null) {
                    Iterator<String> it = categories.iterator();
                    while (it.hasNext()) {
                        if (it.next().equals("android.intent.category.LAUNCHER")) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(cg cgVar) {
        ec ecVar = (ec) cgVar.g;
        boolean z = this.p;
        this.p = false;
        if (a(cgVar.h, ecVar)) {
            d dVar = (d) ecVar;
            this.b.a(dVar.d, dVar.e);
        } else if (l(cgVar)) {
            mp mpVar = (mp) ecVar;
            if (mpVar.f396a != null && mpVar.f396a.getComponent() != null) {
                ComponentName component = mpVar.f396a.getComponent();
                bz bzVar = cgVar.h;
                this.p = this.b.a(component, d.a(mp.a(getContext(), component.getPackageName())));
                if (this.p) {
                    this.b.a(new be(this, component, bzVar));
                }
            }
        } else if (g(cgVar)) {
            iv.b(this.b, ecVar);
        } else if (i(cgVar)) {
            dg dgVar = (dg) ecVar;
            this.b.a(dgVar);
            iv.a((Context) this.b, dgVar);
        } else if (h(cgVar)) {
            this.b.a((it) ecVar);
            iv.b(this.b, ecVar);
            it itVar = (it) ecVar;
            ir irVarQ = this.b.q();
            if (irVarQ != null) {
                new bf(this, "deleteAppWidgetId", irVarQ, itVar).start();
            }
        }
        if (!z || this.p) {
            return;
        }
        if (cgVar.h instanceof Folder) {
            ((Folder) cgVar.h).b(false);
        } else if (cgVar.h instanceof Workspace) {
            ((Workspace) cgVar.h).c(false);
        }
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.bp
    public void a(bz bzVar, Object obj, int i2) {
        boolean z = !AppsCustomizePagedView.b && a(bzVar, obj);
        boolean z2 = a(obj) && !b(bzVar, obj);
        this.b.m(false);
        if (z) {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, this.m);
        } else {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, this.n);
        }
        this.o = (TransitionDrawable) getCurrentDrawable();
        this.d = z2;
        d();
        ((ViewGroup) getParent()).setVisibility(z2 ? 0 : 8);
        if (getText().length() > 0) {
            setText(z ? R.string.delete_target_uninstall_label : R.string.delete_target_label);
        }
        com.syu.g.i.a().a("DeleteDropTarget onDragStart isVisible = " + z2 + "width = " + getWidth() + " height = " + getHeight());
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.ce
    public void a(cg cgVar, int i2, int i3, PointF pointF) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA;
        boolean z = cgVar.h instanceof AppsCustomizePagedView;
        cgVar.f.setColor(0);
        cgVar.f.a();
        if (z) {
            d();
        }
        if (this.k == i) {
            this.c.c();
            this.c.a();
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.b);
        DragLayer dragLayerF = this.b.f();
        int i4 = g;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        bi biVar = new bi(this, jCurrentAnimationTimeMillis, i4);
        if (this.k == i) {
            animatorUpdateListenerA = a(dragLayerF, cgVar, pointF, viewConfiguration);
        } else {
            animatorUpdateListenerA = this.k == j ? a(dragLayerF, cgVar, pointF, jCurrentAnimationTimeMillis, i4, viewConfiguration) : null;
        }
        k(cgVar);
        dragLayerF.a(cgVar.f, animatorUpdateListenerA, i4, biVar, new bj(this, z, cgVar), 0, null);
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.ce
    public boolean a(cg cgVar) {
        return a(cgVar.g);
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.bp
    public void b() {
        super.b();
        this.b.m(true);
        this.d = false;
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.ce
    public void b(cg cgVar) {
        j(cgVar);
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.ce
    public void c(cg cgVar) {
        super.c(cgVar);
        c();
    }

    @Override // com.android.launcher6.ac, com.android.launcher6.ce
    public void e(cg cgVar) {
        super.e(cgVar);
        if (cgVar.e) {
            cgVar.f.setColor(this.e);
        } else {
            d();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.l = getTextColors();
        Resources resources = getResources();
        this.e = resources.getColor(R.color.delete_target_hover_tint);
        this.m = (TransitionDrawable) resources.getDrawable(R.drawable.uninstall_target_selector);
        this.n = (TransitionDrawable) resources.getDrawable(R.drawable.remove_target_selector);
        this.n.setCrossFadeEnabled(true);
        this.m.setCrossFadeEnabled(true);
        this.o = (TransitionDrawable) getCurrentDrawable();
        if (getResources().getConfiguration().orientation != 2 || ip.a().j()) {
            return;
        }
        setText("");
    }
}
