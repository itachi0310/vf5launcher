package com.android.launcher6;

import android.content.Intent;
import android.os.SystemProperties;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class ic implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f301a;

    ic(ib ibVar) {
        this.f301a = ibVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intentA = com.syu.g.g.a(Launcher.G(), com.syu.g.n.f541a);
        SystemProperties.set("sys.lsec.force_pip", "true");
        intentA.putExtra("force_pip", true);
        Log.i("mql", "--- com.lsec.pipdie");
        Launcher.o.startActivity(intentA);
        if (com.syu.g.n.f541a.equals("com.syu.camera360")) {
            Launcher.o.sendBroadcast(new Intent("com.syu.camera360.show"));
        }
    }
}
