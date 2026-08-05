package com.syu.widget.a;

import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f561a;

    m(l lVar) {
        this.f561a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RemoteViews remoteViewsE = this.f561a.e();
        if (remoteViewsE != null) {
            this.f561a.c(remoteViewsE);
        }
    }
}
