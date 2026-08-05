package com.android.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class ck implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f155a = System.currentTimeMillis();

    ck() {
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        cj.g++;
    }
}
