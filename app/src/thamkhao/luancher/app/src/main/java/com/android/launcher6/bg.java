package com.android.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
class bg implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f130a;

    bg(DeleteDropTarget deleteDropTarget) {
        this.f130a = deleteDropTarget;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f * f * f * f * f * f * f * f;
    }
}
