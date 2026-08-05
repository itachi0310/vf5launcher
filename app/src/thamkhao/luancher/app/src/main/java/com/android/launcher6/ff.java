package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ff implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f224a;

    ff(Launcher launcher) {
        this.f224a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f224a.b(view, com.syu.g.g.a(this.f224a, "com.newsmy.ncarmanagerclient"), "newsmy");
    }
}
