package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gh implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f253a;

    gh(Launcher launcher) {
        this.f253a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f253a.dF != null) {
            if (this.f253a.dF.equals("true")) {
                com.syu.a.a.a(this.f253a.getApplicationContext()).k.a(0, 20, 2);
            } else {
                com.syu.a.a.a(this.f253a.getApplicationContext()).k.a(0, 20, 1);
            }
        }
    }
}
