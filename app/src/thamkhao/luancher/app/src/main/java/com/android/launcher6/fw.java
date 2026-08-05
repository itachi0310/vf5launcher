package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyt.car.MusicService;

/* JADX INFO: loaded from: classes.dex */
class fw extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f241a;

    fw(Launcher launcher) {
        this.f241a = launcher;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.fyt.systemui.remove".equals(intent.getAction())) {
            String string = intent.getExtras().getString("pkg");
            if ("com.syu.music".equals(string)) {
                MusicService.d = false;
                this.f241a.bp.postDelayed(new fx(this), 1000L);
            } else if ("com.autonavi.amapauto".equals(string)) {
                this.f241a.bp.postDelayed(new fy(this), 1000L);
            }
        }
    }
}
