package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class bh implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f131a;
    private final /* synthetic */ DragLayer b;
    private final /* synthetic */ TimeInterpolator c;
    private final /* synthetic */ float d;
    private final /* synthetic */ float e;
    private final /* synthetic */ float f;
    private final /* synthetic */ float g;
    private final /* synthetic */ float h;
    private final /* synthetic */ float i;

    bh(DeleteDropTarget deleteDropTarget, DragLayer dragLayer, TimeInterpolator timeInterpolator, float f, float f2, float f3, float f4, float f5, float f6) {
        this.f131a = deleteDropTarget;
        this.b = dragLayer;
        this.c = timeInterpolator;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = f5;
        this.i = f6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ca caVar = (ca) this.b.getAnimatedView();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float interpolation = this.c.getInterpolation(fFloatValue);
        float initialScale = caVar.getInitialScale();
        float scaleX = caVar.getScaleX();
        float measuredWidth = ((1.0f - scaleX) * caVar.getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((1.0f - scaleX) * caVar.getMeasuredHeight()) / 2.0f;
        float f = ((1.0f - fFloatValue) * (1.0f - fFloatValue) * (this.d - measuredWidth)) + ((1.0f - fFloatValue) * 2.0f * fFloatValue * (this.e - measuredWidth)) + (fFloatValue * fFloatValue * this.f);
        float f2 = (fFloatValue * fFloatValue * this.i) + ((this.g - measuredHeight) * (1.0f - fFloatValue) * (1.0f - fFloatValue)) + ((this.h - measuredWidth) * (1.0f - fFloatValue) * 2.0f * fFloatValue);
        caVar.setTranslationX(f);
        caVar.setTranslationY(f2);
        caVar.setScaleX((1.0f - interpolation) * initialScale);
        caVar.setScaleY((1.0f - interpolation) * initialScale);
        caVar.setAlpha(((1.0f - 0.5f) * (1.0f - interpolation)) + 0.5f);
    }
}
