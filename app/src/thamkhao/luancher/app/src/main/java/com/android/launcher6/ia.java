package com.android.launcher6;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class ia extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f299a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia(Launcher launcher) {
        super(new Handler());
        this.f299a = launcher;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f299a.aF();
    }
}
