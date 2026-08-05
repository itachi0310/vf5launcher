package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
class pf implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DecelerateInterpolator f460a = new DecelerateInterpolator(0.75f);
    private final pd b = new pd(0.13f);

    pf() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.f460a.getInterpolation(this.b.getInterpolation(f));
    }
}
