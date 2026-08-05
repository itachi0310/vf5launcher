package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class lj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ li f374a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    lj(li liVar, int i, int i2) {
        this.f374a = liVar;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f374a.n(this.b);
        int i = this.c < this.b ? -1 : 1;
        int i2 = this.c < this.b ? this.c + 1 : this.b;
        int i3 = this.c > this.b ? this.c - 1 : this.b;
        for (int i4 = i2; i4 <= i3; i4++) {
            View childAt = this.f374a.getChildAt(i4);
            int i5 = this.f374a.i(i4) + this.f374a.getViewportOffsetX();
            int i6 = this.f374a.i(i4 + i) + this.f374a.getViewportOffsetX();
            AnimatorSet animatorSet = (AnimatorSet) childAt.getTag(100);
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            childAt.setTranslationX(i5 - i6);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(this.f374a.al);
            animatorSet2.playTogether(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f));
            animatorSet2.start();
            childAt.setTag(animatorSet2);
        }
        this.f374a.removeView(this.f374a.an);
        this.f374a.a(this.f374a.an, false);
        this.f374a.addView(this.f374a.an, this.b);
        this.f374a.a(this.f374a.an, this.b);
        this.f374a.aD = -1;
        this.f374a.av.setActiveMarker(this.f374a.getNextPage());
    }
}
