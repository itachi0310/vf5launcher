package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ez implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f217a;

    ez(Launcher launcher) {
        this.f217a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f217a.p();
    }
}
