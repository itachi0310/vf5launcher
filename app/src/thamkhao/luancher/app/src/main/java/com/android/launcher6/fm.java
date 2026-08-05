package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fm implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f231a;

    fm(Launcher launcher) {
        this.f231a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.syu.a.a.g != 1 || this.f231a.H == null) {
            return;
        }
        this.f231a.H.a(1, 1, 0);
    }
}
