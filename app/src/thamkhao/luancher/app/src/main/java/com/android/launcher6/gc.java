package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gc implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f248a;

    gc(Launcher launcher) {
        this.f248a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.syu.bt.byav.widgetNext");
        intent.setPackage("com.syu.bt");
        this.f248a.startService(intent);
    }
}
