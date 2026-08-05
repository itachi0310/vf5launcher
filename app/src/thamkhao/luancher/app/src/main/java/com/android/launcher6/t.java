package com.android.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizeTabHost f464a;
    private final /* synthetic */ q b;
    private final /* synthetic */ int c;

    t(AppsCustomizeTabHost appsCustomizeTabHost, q qVar, int i) {
        this.f464a = appsCustomizeTabHost;
        this.b = qVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f464a.d.getMeasuredWidth() <= 0 || this.f464a.d.getMeasuredHeight() <= 0) {
            this.f464a.f();
            return;
        }
        int[] iArr = new int[2];
        this.f464a.d.b(iArr);
        if (iArr[0] == -1 && iArr[1] == -1) {
            this.f464a.f();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = iArr[0]; i <= iArr[1]; i++) {
            arrayList.add(this.f464a.d.c(i));
        }
        this.f464a.e.scrollTo(this.f464a.d.getScrollX(), 0);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            View view = (View) arrayList.get(size);
            if (view instanceof i) {
                ((i) view).b();
            } else if (view instanceof lw) {
                ((lw) view).b();
            }
            PagedViewWidget.setDeletePreviewsWhenDetachedFromWindow(false);
            this.f464a.d.removeView(view);
            PagedViewWidget.setDeletePreviewsWhenDetachedFromWindow(true);
            this.f464a.e.setAlpha(1.0f);
            this.f464a.e.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight());
            layoutParams.setMargins(view.getLeft(), view.getTop(), 0, 0);
            this.f464a.e.addView(view, layoutParams);
        }
        this.f464a.e();
        this.f464a.b(this.b);
        ObjectAnimator objectAnimatorA = ik.a(this.f464a.e, "alpha", 0.0f);
        objectAnimatorA.addListener(new u(this));
        ObjectAnimator objectAnimatorA2 = ik.a(this.f464a.d, "alpha", 1.0f);
        objectAnimatorA2.addListener(new v(this));
        AnimatorSet animatorSetB = ik.b();
        animatorSetB.playTogether(objectAnimatorA, objectAnimatorA2);
        animatorSetB.setDuration(this.c);
        animatorSetB.start();
    }
}
