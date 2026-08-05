package com.android.launcher6;

import android.view.View;
import cn.kuwo.autosdk.api.PlayState;

/* JADX INFO: loaded from: classes.dex */
class ga implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f246a;

    ga(Launcher launcher) {
        this.f246a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Launcher.bo != null) {
            this.f246a.ax();
            Launcher.bo.setPlayState(this.f246a.getApplicationContext(), PlayState.STATE_NEXT);
        }
    }
}
