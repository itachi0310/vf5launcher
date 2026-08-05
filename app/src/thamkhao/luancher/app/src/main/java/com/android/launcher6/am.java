package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f110a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    Animator h;
    final /* synthetic */ CellLayout i;

    public am(CellLayout cellLayout, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        this.i = cellLayout;
        cellLayout.a(i, i2, i5, i6, cellLayout.v);
        int i7 = cellLayout.v[0];
        int i8 = cellLayout.v[1];
        cellLayout.a(i3, i4, i5, i6, cellLayout.v);
        int i9 = cellLayout.v[0] - i7;
        int i10 = cellLayout.v[1] - i8;
        this.b = 0.0f;
        this.c = 0.0f;
        if (i9 != i10 || i9 != 0) {
            if (i10 == 0) {
                this.b = (-Math.signum(i9)) * cellLayout.ah;
            } else if (i9 == 0) {
                this.c = (-Math.signum(i10)) * cellLayout.ah;
            } else {
                double dAtan = Math.atan(i10 / i9);
                this.b = (int) (((double) (-Math.signum(i9))) * Math.abs(Math.cos(dAtan) * ((double) cellLayout.ah)));
                this.c = (int) (((double) (-Math.signum(i10))) * Math.abs(Math.sin(dAtan) * ((double) cellLayout.ah)));
            }
        }
        this.d = view.getTranslationX();
        this.e = view.getTranslationY();
        this.f = cellLayout.getChildrenScale() - (4.0f / view.getWidth());
        this.g = view.getScaleX();
        this.f110a = view;
    }

    private void b() {
        if (this.h != null) {
            this.h.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.h != null) {
            this.h.cancel();
        }
        AnimatorSet animatorSetB = ik.b();
        this.h = animatorSetB;
        animatorSetB.playTogether(ik.a(this.f110a, "scaleX", this.i.getChildrenScale()), ik.a(this.f110a, "scaleY", this.i.getChildrenScale()), ik.a(this.f110a, "translationX", 0.0f), ik.a(this.f110a, "translationY", 0.0f));
        animatorSetB.setDuration(150L);
        animatorSetB.setInterpolator(new DecelerateInterpolator(1.5f));
        animatorSetB.start();
    }

    void a() {
        if (this.i.W.containsKey(this.f110a)) {
            ((am) this.i.W.get(this.f110a)).b();
            this.i.W.remove(this.f110a);
            if (this.b == 0.0f && this.c == 0.0f) {
                c();
                return;
            }
        }
        if (this.b == 0.0f && this.c == 0.0f) {
            return;
        }
        ValueAnimator valueAnimatorA = ik.a(this.f110a, 0.0f, 1.0f);
        this.h = valueAnimatorA;
        valueAnimatorA.setRepeatMode(2);
        valueAnimatorA.setRepeatCount(-1);
        valueAnimatorA.setDuration(300L);
        valueAnimatorA.setStartDelay((int) (Math.random() * 60.0d));
        valueAnimatorA.addUpdateListener(new an(this));
        valueAnimatorA.addListener(new ao(this));
        this.i.W.put(this.f110a, this);
        valueAnimatorA.start();
    }
}
