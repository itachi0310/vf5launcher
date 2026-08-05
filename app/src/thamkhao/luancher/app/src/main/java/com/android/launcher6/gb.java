package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gb implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f247a;

    gb(Launcher launcher) {
        this.f247a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.syu.bt.byav.widgetPrev");
        intent.setPackage("com.syu.bt");
        this.f247a.startService(intent);
    }
}
