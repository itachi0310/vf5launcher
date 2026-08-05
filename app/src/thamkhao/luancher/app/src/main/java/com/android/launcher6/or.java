package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class or implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f445a;

    or(Workspace workspace) {
        this.f445a = workspace;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f445a.ap();
    }
}
