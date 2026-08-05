package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fe implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f223a;

    fe(Launcher launcher) {
        this.f223a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f223a.b(view, com.syu.g.g.a(this.f223a, "com.newsmy.ncarmanagerclient"), "newsmy");
    }
}
