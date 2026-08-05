package com.android.launcher6;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.android.launcher6.do, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
class Cdo implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HolographicLinearLayout f183a;

    Cdo(HolographicLinearLayout holographicLinearLayout) {
        this.f183a = holographicLinearLayout;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f183a.isPressed() == this.f183a.e) {
            return false;
        }
        this.f183a.e = this.f183a.isPressed();
        this.f183a.refreshDrawableState();
        return false;
    }
}
