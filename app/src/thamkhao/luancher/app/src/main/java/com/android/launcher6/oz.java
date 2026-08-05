package com.android.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
class oz implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pd f453a;

    public oz(float f) {
        this.f453a = new pd(f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return 1.0f - this.f453a.getInterpolation(1.0f - f);
    }
}
