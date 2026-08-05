package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fo implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f233a;

    fo(Launcher launcher) {
        this.f233a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.syu.a.a.g != 1 || this.f233a.H == null) {
            return;
        }
        this.f233a.H.a(1, 0, 0);
    }
}
