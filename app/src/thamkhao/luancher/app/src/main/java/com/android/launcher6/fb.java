package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fb implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f220a;

    fb(Launcher launcher) {
        this.f220a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f220a.l();
    }
}
