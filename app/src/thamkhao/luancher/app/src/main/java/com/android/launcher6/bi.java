package com.android.launcher6;

import android.animation.TimeInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
class bi implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f132a;
    private int b = -1;
    private float c = 0.0f;
    private final /* synthetic */ long d;
    private final /* synthetic */ int e;

    bi(DeleteDropTarget deleteDropTarget, long j, int i) {
        this.f132a = deleteDropTarget;
        this.d = j;
        this.e = i;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (this.b < 0) {
            this.b++;
        } else if (this.b == 0) {
            this.c = Math.min(0.5f, (AnimationUtils.currentAnimationTimeMillis() - this.d) / this.e);
            this.b++;
        }
        return Math.min(1.0f, this.c + f);
    }
}
