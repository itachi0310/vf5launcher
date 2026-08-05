package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gk implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f256a;

    gk(Launcher launcher) {
        this.f256a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.syu.a.a.a(this.f256a.getApplicationContext()).k.a(0, 20, 11);
    }
}
