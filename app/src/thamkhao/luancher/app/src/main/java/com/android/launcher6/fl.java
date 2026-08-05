package com.android.launcher6;

import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
class fl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f230a;

    fl(Launcher launcher) {
        this.f230a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f230a.getApplicationContext(), this.f230a.F, 1).show();
        this.f230a.g = true;
    }
}
