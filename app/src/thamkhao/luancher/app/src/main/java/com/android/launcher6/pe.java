package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
class pe implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oz f459a = new oz(0.35f);
    private final DecelerateInterpolator b = new DecelerateInterpolator(3.0f);

    pe() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.b.getInterpolation(this.f459a.getInterpolation(f));
    }
}
