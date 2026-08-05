package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public class cj extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private static ViewTreeObserver.OnDrawListener f;
    private static long g;
    private static boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f154a;
    private long b;
    private long c = -1;
    private boolean d;
    private boolean e;

    public cj(ValueAnimator valueAnimator, View view) {
        this.f154a = view;
        valueAnimator.addUpdateListener(this);
    }

    public cj(ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f154a = view;
        viewPropertyAnimator.setListener(this);
    }

    public static void a(View view) {
        if (f != null) {
            view.getViewTreeObserver().removeOnDrawListener(f);
        }
        f = new ck();
        view.getViewTreeObserver().addOnDrawListener(f);
        h = true;
    }

    public static void a(boolean z) {
        h = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        valueAnimator.addUpdateListener(this);
        onAnimationUpdate(valueAnimator);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.c == -1) {
            this.b = g;
            this.c = jCurrentTimeMillis;
        }
        if (this.d || !h || valueAnimator.getCurrentPlayTime() >= valueAnimator.getDuration()) {
            return;
        }
        this.d = true;
        long j = g - this.b;
        if (j == 0 && jCurrentTimeMillis < this.c + 1000) {
            this.f154a.getRootView().invalidate();
            valueAnimator.setCurrentPlayTime(0L);
        } else if (j == 1 && jCurrentTimeMillis < this.c + 1000 && !this.e && jCurrentTimeMillis > this.c + 16) {
            valueAnimator.setCurrentPlayTime(16L);
            this.e = true;
        } else if (j > 1) {
            this.f154a.post(new cl(this, valueAnimator));
        }
        this.d = false;
    }
}
