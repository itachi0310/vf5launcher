package com.syu.i;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
class j extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f550a;

    j(e eVar) {
        this.f550a = eVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z = true;
        while (z) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Location lastKnownLocation = this.f550a.i.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                lastKnownLocation = this.f550a.i.getLastKnownLocation("network");
            }
            if (this.f550a.j != null || lastKnownLocation != null) {
                this.f550a.b(lastKnownLocation);
                this.f550a.g = false;
                z = false;
            }
        }
    }
}
