package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ln implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ li f378a;
    private final /* synthetic */ View b;

    ln(li liVar, View view) {
        this.f378a = liVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int viewportOffsetX;
        int i;
        int iIndexOfChild = this.f378a.indexOfChild(this.b);
        this.f378a.a(this.f378a.V);
        boolean z = this.f378a.V[0] == this.f378a.V[1];
        boolean z2 = z || iIndexOfChild > this.f378a.V[0];
        if (z2) {
            this.f378a.o(iIndexOfChild - 1);
        }
        int i2 = z ? 0 : this.f378a.V[0];
        int iMin = Math.min(this.f378a.V[1], this.f378a.getPageCount() - 1);
        int i3 = z2 ? i2 : iIndexOfChild + 1;
        if (z2) {
            iMin = iIndexOfChild - 1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = i3;
        while (i4 <= iMin) {
            View childAt = this.f378a.getChildAt(i4);
            if (z2) {
                int viewportOffsetX2 = i4 == 0 ? ((this.f378a.getViewportOffsetX() + this.f378a.i(i4)) - this.f378a.m(i4)) - this.f378a.J : this.f378a.getViewportOffsetX() + this.f378a.i(i4 - 1);
                viewportOffsetX = this.f378a.getViewportOffsetX() + this.f378a.i(i4);
                i = viewportOffsetX2;
            } else {
                viewportOffsetX = 0;
                i = this.f378a.i(i4) - this.f378a.i(i4 - 1);
            }
            AnimatorSet animatorSet = (AnimatorSet) childAt.getTag();
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            childAt.setAlpha(Math.max(childAt.getAlpha(), 0.01f));
            childAt.setTranslationX(i - viewportOffsetX);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f), ObjectAnimator.ofFloat(childAt, "alpha", 1.0f));
            arrayList.add(animatorSet2);
            childAt.setTag(100, animatorSet2);
            i4++;
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        animatorSet3.setDuration(this.f378a.aS);
        animatorSet3.addListener(new lo(this));
        animatorSet3.start();
        this.f378a.removeView(this.b);
        this.f378a.a(this.b, true);
    }
}
