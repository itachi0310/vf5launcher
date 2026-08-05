package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class op implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f443a;

    op(Workspace workspace) {
        this.f443a = workspace;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f443a.h) {
            this.f443a.S();
        }
    }
}
