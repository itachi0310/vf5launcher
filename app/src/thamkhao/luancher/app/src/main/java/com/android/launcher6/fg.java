package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fg implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f225a;

    fg(Launcher launcher) {
        this.f225a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f225a.aB();
        Intent intent = new Intent();
        intent.setAction("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.putExtra("KEY_TYPE", 10040);
        intent.putExtra("DEST", 0);
        intent.putExtra("IS_START_NAVI", 0);
        intent.putExtra("SOURCE_APP", "");
        this.f225a.sendBroadcast(intent);
    }
}
