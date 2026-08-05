package com.android.launcher6;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class hw implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f295a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ View c;

    hw(Launcher launcher, ViewGroup viewGroup, View view) {
        this.f295a = launcher;
        this.b = viewGroup;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeView(this.c);
    }
}
