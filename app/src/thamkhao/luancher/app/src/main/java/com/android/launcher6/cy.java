package com.android.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
class cy implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FolderIcon f168a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ float c;
    private final /* synthetic */ df d;
    private final /* synthetic */ float e;

    cy(FolderIcon folderIcon, boolean z, float f, df dfVar, float f2) {
        this.f168a = folderIcon;
        this.b = z;
        this.c = f;
        this.d = dfVar;
        this.e = f2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.b) {
            fFloatValue = 1.0f - fFloatValue;
            this.f168a.i.setAlpha(fFloatValue);
        }
        this.f168a.u.f176a = this.c + ((this.d.f176a - this.c) * fFloatValue);
        this.f168a.u.b = this.e + ((this.d.b - this.e) * fFloatValue);
        this.f168a.u.c = (fFloatValue * (this.d.c - 1.0f)) + 1.0f;
        this.f168a.invalidate();
    }
}
