package com.android.launcher6;

import android.view.View;
import cn.kuwo.autosdk.api.PlayState;

/* JADX INFO: loaded from: classes.dex */
class fz implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f244a;

    fz(Launcher launcher) {
        this.f244a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Launcher.bo != null) {
            this.f244a.ax();
            Launcher.bo.setPlayState(this.f244a.getApplicationContext(), PlayState.STATE_PRE);
        }
    }
}
