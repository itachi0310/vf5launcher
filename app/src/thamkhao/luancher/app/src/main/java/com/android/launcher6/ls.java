package com.android.launcher6;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class ls implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
