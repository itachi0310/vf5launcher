package com.android.launcher6;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
class iq extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ip f311a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    iq(ip ipVar, Handler handler) {
        super(handler);
        this.f311a = ipVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f311a.b.a(false, true);
        this.f311a.b.e();
    }
}
