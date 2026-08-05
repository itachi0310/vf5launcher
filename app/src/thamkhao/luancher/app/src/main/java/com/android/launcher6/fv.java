package com.android.launcher6;

import android.view.View;
import cn.kuwo.autosdk.api.PlayState;

/* JADX INFO: loaded from: classes.dex */
class fv implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f240a;

    fv(Launcher launcher) {
        this.f240a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Launcher.bo != null) {
            this.f240a.ax();
            if (this.f240a.D) {
                Launcher.bo.setPlayState(Launcher.o, PlayState.STATE_PAUSE);
            } else {
                Launcher.bo.setPlayState(Launcher.o, PlayState.STATE_PLAY);
            }
        }
    }
}
