package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dn implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HolographicImageView f182a;

    dn(HolographicImageView holographicImageView) {
        this.f182a = holographicImageView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (this.f182a.isFocused() != this.f182a.d) {
            this.f182a.d = this.f182a.isFocused();
            this.f182a.refreshDrawableState();
        }
    }
}
