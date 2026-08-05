package com.syu.g;

import android.content.Intent;
import com.android.launcher6.LauncherApplication;

/* JADX INFO: loaded from: classes.dex */
class o implements Runnable {
    o() {
    }

    @Override // java.lang.Runnable
    public void run() {
        n.c = g.a(LauncherApplication.f88a, n.f541a);
        if (n.f541a.equals("com.syu.camera360")) {
            LauncherApplication.f88a.sendBroadcast(new Intent("com.syu.camera360.show"));
        }
        com.syu.d.a.b("PIP show  " + n.c.getComponent().getPackageName());
        n.c.putExtra("force_pip", true);
        LauncherApplication.f88a.startActivity(n.c);
    }
}
