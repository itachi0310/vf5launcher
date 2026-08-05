package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class br implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DragLayer f140a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Runnable c;

    br(DragLayer dragLayer, View view, Runnable runnable) {
        this.f140a = dragLayer;
        this.b = view;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setVisibility(0);
        if (this.c != null) {
            this.c.run();
        }
    }
}
