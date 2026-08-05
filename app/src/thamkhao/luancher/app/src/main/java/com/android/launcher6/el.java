package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
class el extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f203a;

    el(Launcher launcher) {
        this.f203a = launcher;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.SCREEN_OFF".equals(action)) {
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.f203a.bR = true;
                this.f203a.aC();
                return;
            }
            return;
        }
        this.f203a.bR = false;
        this.f203a.au.a();
        this.f203a.aC();
        if (this.f203a.bz == null || this.f203a.bs.h != -1) {
            return;
        }
        this.f203a.d(true);
    }
}
