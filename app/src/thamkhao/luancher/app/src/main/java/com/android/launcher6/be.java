package com.android.launcher6;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
class be implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f128a;
    private final /* synthetic */ ComponentName b;
    private final /* synthetic */ bz c;

    be(DeleteDropTarget deleteDropTarget, ComponentName componentName, bz bzVar) {
        this.f128a = deleteDropTarget;
        this.b = componentName;
        this.c = bzVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f128a.p = false;
        boolean z = b.c(this.f128a.getContext(), this.b.getPackageName()).size() == 0;
        if (this.c instanceof Folder) {
            ((Folder) this.c).b(z);
        } else if (this.c instanceof Workspace) {
            ((Workspace) this.c).c(z);
        }
    }
}
