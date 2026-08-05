package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fi implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f227a;

    fi(Launcher launcher) {
        this.f227a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f227a.b(view, com.syu.g.g.a(this.f227a, "com.syu.radio"), "radio");
    }
}
