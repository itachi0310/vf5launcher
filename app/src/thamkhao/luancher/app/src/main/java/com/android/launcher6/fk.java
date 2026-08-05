package com.android.launcher6;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class fk implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f229a;

    fk(Launcher launcher) {
        this.f229a = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
        this.f229a.startActivity(intent);
    }
}
