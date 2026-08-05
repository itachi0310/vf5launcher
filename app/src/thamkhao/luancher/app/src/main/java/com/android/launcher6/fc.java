package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fc implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f221a;

    fc(Launcher launcher) {
        this.f221a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f221a.t != null) {
            this.f221a.t.setVisibility(8);
        }
    }
}
