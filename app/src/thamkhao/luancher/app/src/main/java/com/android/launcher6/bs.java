package com.android.launcher6;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class bs implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DragLayer f141a;
    private final /* synthetic */ ca b;
    private final /* synthetic */ Interpolator c;
    private final /* synthetic */ Interpolator d;
    private final /* synthetic */ float e;
    private final /* synthetic */ float f;
    private final /* synthetic */ float g;
    private final /* synthetic */ float h;
    private final /* synthetic */ float i;
    private final /* synthetic */ float j;
    private final /* synthetic */ float k;
    private final /* synthetic */ Rect l;
    private final /* synthetic */ Rect m;

    bs(DragLayer dragLayer, ca caVar, Interpolator interpolator, Interpolator interpolator2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Rect rect, Rect rect2) {
        this.f141a = dragLayer;
        this.b = caVar;
        this.c = interpolator;
        this.d = interpolator2;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = f5;
        this.j = f6;
        this.k = f7;
        this.l = rect;
        this.m = rect2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredHeight = this.b.getMeasuredHeight();
        float interpolation = this.c == null ? fFloatValue : this.c.getInterpolation(fFloatValue);
        float interpolation2 = this.d == null ? fFloatValue : this.d.getInterpolation(fFloatValue);
        float f = this.e * this.f;
        float f2 = this.g * this.f;
        float f3 = (this.h * fFloatValue) + ((1.0f - fFloatValue) * f);
        float f4 = ((1.0f - fFloatValue) * f2) + (this.i * fFloatValue);
        float f5 = (this.j * interpolation) + ((1.0f - interpolation) * this.k);
        float f6 = this.l.left + ((measuredWidth * (f - 1.0f)) / 2.0f);
        float f7 = this.l.top + ((measuredHeight * (f2 - 1.0f)) / 2.0f);
        int iRound = (int) (f6 + Math.round((this.m.left - f6) * interpolation2));
        int iRound2 = (int) (Math.round(interpolation2 * (this.m.top - f7)) + f7);
        int scrollX = (this.f141a.m != null ? this.f141a.l - this.f141a.m.getScrollX() : 0) + (iRound - this.f141a.k.getScrollX());
        int scrollY = iRound2 - this.f141a.k.getScrollY();
        this.f141a.k.setTranslationX(scrollX);
        this.f141a.k.setTranslationY(scrollY);
        this.f141a.k.setScaleX(f3);
        this.f141a.k.setScaleY(f4);
        this.f141a.k.setAlpha(f5);
    }
}
