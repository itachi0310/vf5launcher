package com.android.launcher6;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class ae implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CellLayout f102a;
    private final /* synthetic */ ea b;
    private final /* synthetic */ int c;

    ae(CellLayout cellLayout, ea eaVar, int i) {
        this.f102a = cellLayout;
        this.b = eaVar;
        this.c = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (((Bitmap) this.b.d()) == null) {
            valueAnimator.cancel();
        } else {
            this.f102a.Q[this.c] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f102a.invalidate(this.f102a.P[this.c]);
        }
    }
}
