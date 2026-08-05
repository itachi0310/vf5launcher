package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fj implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f228a;

    fj(Launcher launcher) {
        this.f228a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f228a.b(view, com.syu.g.g.a(this.f228a, "com.syu.music"), "music");
    }
}
