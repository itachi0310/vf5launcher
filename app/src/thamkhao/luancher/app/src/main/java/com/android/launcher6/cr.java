package com.android.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class cr extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Folder f161a;

    cr(Folder folder) {
        this.f161a = folder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f161a.n = 2;
        this.f161a.setLayerType(0, null);
        Cling clingAh = this.f161a.b.ah();
        if (clingAh != null) {
            clingAh.b();
            this.f161a.bringToFront();
            clingAh.bringToFront();
        }
        this.f161a.q();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f161a.a(32, String.format(this.f161a.getContext().getString(R.string.folder_opened), Integer.valueOf(this.f161a.d.getCountX()), Integer.valueOf(this.f161a.d.getCountY())));
        this.f161a.n = 1;
    }
}
