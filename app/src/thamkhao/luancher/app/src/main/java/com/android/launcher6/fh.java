package com.android.launcher6;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fh implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f226a;

    fh(Launcher launcher) {
        this.f226a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f226a.aB();
        Intent intent = new Intent();
        intent.setAction("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.putExtra("KEY_TYPE", 10040);
        intent.putExtra("DEST", 1);
        intent.putExtra("IS_START_NAVI", 0);
        intent.putExtra("SOURCE_APP", "");
        this.f226a.sendBroadcast(intent);
    }
}
