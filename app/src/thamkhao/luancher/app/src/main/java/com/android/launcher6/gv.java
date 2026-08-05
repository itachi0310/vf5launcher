package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class gv extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f267a;
    private final /* synthetic */ CellLayout b;
    private final /* synthetic */ FolderIcon c;

    gv(Launcher launcher, CellLayout cellLayout, FolderIcon folderIcon) {
        this.f267a = launcher;
        this.b = cellLayout;
        this.c = folderIcon;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.b != null) {
            this.b.e();
            this.f267a.au.removeView(this.f267a.f87cn);
            this.c.setVisibility(0);
        }
    }
}
