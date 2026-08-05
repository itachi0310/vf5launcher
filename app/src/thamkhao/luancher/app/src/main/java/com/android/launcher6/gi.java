package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gi implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f254a;

    gi(Launcher launcher) {
        this.f254a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.syu.a.a.a(this.f254a.getApplicationContext()).k.a(0, 20, 10);
    }
}
