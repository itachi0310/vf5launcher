package com.android.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
class ay implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CropView f122a;

    ay(CropView cropView) {
        this.f122a = cropView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f122a.a();
        this.f122a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
