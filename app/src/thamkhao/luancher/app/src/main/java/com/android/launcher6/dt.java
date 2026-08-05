package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dt implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Hotseat f188a;

    dt(Hotseat hotseat) {
        this.f188a = hotseat;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f188a.b != null) {
            this.f188a.b.onClickAllAppsButton(view);
        }
    }
}
