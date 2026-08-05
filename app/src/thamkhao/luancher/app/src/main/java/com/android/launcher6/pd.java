package com.android.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
class pd implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f458a;

    public pd(float f) {
        this.f458a = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (1.0f - (this.f458a / (this.f458a + f))) / (1.0f - (this.f458a / (this.f458a + 1.0f)));
    }
}
