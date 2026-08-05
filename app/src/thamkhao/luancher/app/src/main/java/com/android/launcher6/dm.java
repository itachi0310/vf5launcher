package com.android.launcher6;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dm implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HolographicImageView f181a;

    dm(HolographicImageView holographicImageView) {
        this.f181a = holographicImageView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f181a.isPressed() == this.f181a.c) {
            return false;
        }
        this.f181a.c = this.f181a.isPressed();
        this.f181a.refreshDrawableState();
        return false;
    }
}
