package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
class ib extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f300a;

    private ib(Launcher launcher) {
        this.f300a = launcher;
    }

    /* synthetic */ ib(Launcher launcher, ib ibVar) {
        this(launcher);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.HOME");
        if (!this.f300a.getPackageManager().resolveActivity(intent2, 65536).activityInfo.packageName.equals(this.f300a.getPackageName())) {
            this.f300a.s();
            return;
        }
        if ("com.lsec.tyz.action.voice.launcher".equals(intent.getAction())) {
            com.syu.g.n.b(null);
        } else if ("com.lsec.pipdie".equals(intent.getAction()) && com.syu.g.n.b) {
            new Thread(new ic(this)).start();
        }
    }
}
