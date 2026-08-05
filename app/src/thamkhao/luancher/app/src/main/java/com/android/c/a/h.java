package com.android.c.a;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes.dex */
class h implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f67a;

    h(f fVar) {
        this.f67a = fVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.f67a.f = false;
        this.f67a.c.requestRender();
    }
}
