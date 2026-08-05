package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gg implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f252a;

    gg(Launcher launcher) {
        this.f252a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f252a.b(view, com.syu.g.g.a(Launcher.o, "com.syu.music"), "bt");
    }
}
