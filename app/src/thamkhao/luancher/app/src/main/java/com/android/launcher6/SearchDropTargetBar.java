package com.android.launcher6;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class SearchDropTargetBar extends FrameLayout implements bp {
    private static final AccelerateInterpolator c = new AccelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f96a;
    private ObjectAnimator b;
    private boolean d;
    private View e;
    private View f;
    private ac g;
    private int h;
    private boolean i;
    private Drawable j;
    private boolean k;

    public SearchDropTargetBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchDropTargetBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
    }

    private void a(ObjectAnimator objectAnimator, View view) {
        objectAnimator.setInterpolator(c);
        objectAnimator.setDuration(200L);
        objectAnimator.addListener(new mn(this, view));
    }

    private void a(View view) {
        view.setLayerType(2, null);
    }

    public void a() {
        a(this.f);
        this.f96a.reverse();
        a(this.e);
        this.b.reverse();
    }

    public void a(Launcher launcher, bo boVar) {
        boVar.a((bp) this);
        boVar.a((bp) this.g);
        boVar.a((ce) this.g);
        boVar.c(this.g);
        this.g.setLauncher(launcher);
        this.e = launcher.N();
        if (this.k) {
            this.b = ik.a(this.e, "translationY", 0.0f, -this.h);
        } else {
            this.b = ik.a(this.e, "alpha", 1.0f, 0.0f);
        }
        a(this.b, this.e);
    }

    @Override // com.android.launcher6.bp
    public void a(bz bzVar, Object obj, int i) {
        a(this.f);
        this.f96a.start();
        if (DeleteDropTarget.a(obj) && Launcher.G().s != null) {
            Launcher.G().s.setVisibility(8);
        }
        if (this.e != null) {
            a(this.e);
            this.b.start();
        }
    }

    public void a(boolean z) {
        if (this.e == null && this.d) {
            if (z) {
                a(this.e);
                this.b.reverse();
            } else {
                this.b.cancel();
                if (this.k) {
                    this.e.setTranslationY(0.0f);
                } else {
                    this.e.setAlpha(1.0f);
                }
            }
            this.d = false;
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.e != null) {
            Drawable background = this.e.getBackground();
            if (background != null && !z && !z2) {
                this.j = background;
                this.e.setBackgroundResource(0);
            } else if (this.j != null) {
                if (z || z2) {
                    this.e.setBackground(this.j);
                }
            }
        }
    }

    @Override // com.android.launcher6.bp
    public void b() {
        if (this.i) {
            this.i = false;
            return;
        }
        a(this.f);
        this.f96a.reverse();
        if (Launcher.G().s != null) {
            Launcher.G().s.setVisibility(0);
        }
        if (this.d || this.e == null) {
            return;
        }
        a(this.e);
        this.b.reverse();
    }

    public void b(boolean z) {
        if (this.e == null || this.d) {
            return;
        }
        if (z) {
            a(this.e);
            this.b.start();
        } else {
            this.b.cancel();
            if (this.k) {
                this.e.setTranslationY(-this.h);
            } else {
                this.e.setAlpha(0.0f);
            }
        }
        this.d = true;
    }

    public void c() {
        this.i = true;
    }

    public Rect getSearchBarBounds() {
        if (this.e == null) {
            return null;
        }
        int[] iArr = new int[2];
        this.e.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = iArr[0] + this.e.getWidth();
        rect.bottom = iArr[1] + this.e.getHeight();
        return rect;
    }

    public int getTransitionInDuration() {
        return HttpStatus.SC_OK;
    }

    public int getTransitionOutDuration() {
        return 175;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f = findViewById(R.id.drag_target_bar);
        this.g = (ac) this.f.findViewById(R.id.delete_target_text);
        this.e = findViewById(R.id.qsb_search_bar);
        this.g.setSearchDropTargetBar(this);
        this.k = getResources().getBoolean(R.bool.config_useDropTargetDownTransition);
        if (this.k) {
            this.h = ip.a().i().a().L;
            this.f.setTranslationY(-this.h);
            this.f96a = ik.a(this.f, "translationY", -this.h, 0.0f);
            this.b = ik.a(this.e, "translationY", 0.0f, -this.h);
        } else {
            this.f.setAlpha(0.0f);
            this.f96a = ik.a(this.f, "alpha", 0.0f, 1.0f);
            this.b = ik.a(this.e, "alpha", 1.0f, 0.0f);
        }
        a(this.f96a, this.f);
        a(this.b, this.e);
    }
}
