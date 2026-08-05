package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ey implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f216a;

    ey(Launcher launcher) {
        this.f216a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f216a.v();
    }
}
