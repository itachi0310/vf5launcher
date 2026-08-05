package com.syu.i;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
class h implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f548a;

    h(e eVar) {
        this.f548a = eVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null && this.f548a.a(location, this.f548a.j)) {
            this.f548a.j = location;
            if (this.f548a.o == 0) {
                this.f548a.b();
                this.f548a.o = 2000;
                if (this.f548a.i.isProviderEnabled("gps")) {
                    this.f548a.i.requestLocationUpdates("gps", 2L, this.f548a.o, this.f548a.s);
                }
            }
            this.f548a.b(this.f548a.j);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
