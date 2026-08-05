package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
class bk implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DragLayer f134a;
    private PointF b;
    private Rect c;
    private long d;
    private boolean e;
    private float f;
    private final TimeInterpolator g = new DecelerateInterpolator(0.75f);

    public bk(DragLayer dragLayer, PointF pointF, Rect rect, long j, float f) {
        this.f134a = dragLayer;
        this.b = pointF;
        this.c = rect;
        this.d = j;
        this.f = 1.0f - (dragLayer.getResources().getDisplayMetrics().density * f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ca caVar = (ca) this.f134a.getAnimatedView();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!this.e) {
            this.e = true;
            float scaleX = caVar.getScaleX();
            float measuredWidth = ((scaleX - 1.0f) * caVar.getMeasuredWidth()) / 2.0f;
            float measuredHeight = ((scaleX - 1.0f) * caVar.getMeasuredHeight()) / 2.0f;
            Rect rect = this.c;
            rect.left = (int) (measuredWidth + rect.left);
            Rect rect2 = this.c;
            rect2.top = (int) (measuredHeight + rect2.top);
        }
        Rect rect3 = this.c;
        rect3.left = (int) (rect3.left + ((this.b.x * (jCurrentAnimationTimeMillis - this.d)) / 1000.0f));
        Rect rect4 = this.c;
        rect4.top = (int) (rect4.top + ((this.b.y * (jCurrentAnimationTimeMillis - this.d)) / 1000.0f));
        caVar.setTranslationX(this.c.left);
        caVar.setTranslationY(this.c.top);
        caVar.setAlpha(1.0f - this.g.getInterpolation(fFloatValue));
        this.b.x *= this.f;
        this.b.y *= this.f;
        this.d = jCurrentAnimationTimeMillis;
    }
}
