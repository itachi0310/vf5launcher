package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gd implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f249a;

    gd(Launcher launcher) {
        this.f249a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.syu.bt.byav.widgetPlayPause");
        intent.setPackage("com.syu.bt");
        this.f249a.startService(intent);
    }
}
