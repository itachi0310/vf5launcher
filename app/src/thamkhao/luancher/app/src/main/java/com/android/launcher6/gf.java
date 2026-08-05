package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gf implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f251a;

    gf(Launcher launcher) {
        this.f251a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f251a.b(view, com.syu.g.g.a(Launcher.o, "com.syu.radio"), "bt");
    }
}
