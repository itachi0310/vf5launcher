package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ft implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f238a;

    ft(Launcher launcher) {
        this.f238a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.syu.music.playpause");
        intent.setPackage("com.syu.music");
        this.f238a.startService(intent);
    }
}
