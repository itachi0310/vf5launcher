package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fp implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f234a;

    fp(Launcher launcher) {
        this.f234a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.syu.music.prev");
        intent.setPackage("com.syu.music");
        this.f234a.startService(intent);
    }
}
