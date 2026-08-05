package com.android.launcher6;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ag implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CellLayout f104a;
    private final /* synthetic */ al b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;
    private final /* synthetic */ View g;

    ag(CellLayout cellLayout, al alVar, int i, int i2, int i3, int i4, View view) {
        this.f104a = cellLayout;
        this.b = alVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.k = (int) (((1.0f - fFloatValue) * this.c) + (this.d * fFloatValue));
        this.b.l = (int) ((fFloatValue * this.f) + ((1.0f - fFloatValue) * this.e));
        this.g.requestLayout();
    }
}
