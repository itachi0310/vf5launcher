package com.syu.i;

import android.location.GpsStatus;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
class f implements GpsStatus.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f546a;
    final /* synthetic */ e b;

    f(e eVar) {
        this.b = eVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        if (SystemClock.elapsedRealtime() - this.f546a > 10000) {
            this.f546a = SystemClock.elapsedRealtime();
            this.b.a(i, this.b.i.getGpsStatus(null));
        }
    }
}
