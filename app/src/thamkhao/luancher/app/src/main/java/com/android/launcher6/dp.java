package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dp implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ HolographicLinearLayout f184a;

    dp(HolographicLinearLayout holographicLinearLayout) {
        this.f184a = holographicLinearLayout;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (this.f184a.isFocused() != this.f184a.f) {
            this.f184a.f = this.f184a.isFocused();
            this.f184a.refreshDrawableState();
        }
    }
}
