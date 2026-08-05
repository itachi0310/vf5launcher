package com.android.launcher6;

import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ex implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f215a;

    ex(Launcher launcher) {
        this.f215a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f215a.h(true);
        this.f215a.b(false);
        Log.i("hy", "onClick");
        this.f215a.a(true, q.Widgets, true);
    }
}
