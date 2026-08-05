package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fn implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f232a;

    fn(Launcher launcher) {
        this.f232a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f232a.H == null) {
            return;
        }
        if (com.syu.a.a.g == 1) {
            this.f232a.H.a(0, 0, 0);
            this.f232a.aB.setBackgroundResource(R.drawable.radio_pause_icon);
        } else {
            this.f232a.H.a(0, 0, 1);
            this.f232a.aB.setBackgroundResource(R.drawable.radio_playpause_icon);
        }
    }
}
