package com.android.launcher6;

import android.view.View;
import android.widget.Advanceable;

/* JADX INFO: loaded from: classes.dex */
class en implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ em f205a;
    private final /* synthetic */ View b;

    en(em emVar, View view) {
        this.f205a = emVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((Advanceable) this.b).advance();
    }
}
