package com.syu.i;

import android.location.Location;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.syu.weather.WeatherManager;

/* JADX INFO: loaded from: classes.dex */
class k extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f551a;
    private final /* synthetic */ long b;

    k(e eVar, long j) {
        this.f551a = eVar;
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Location... locationArr) {
        if (locationArr == null || locationArr.length <= 0) {
            return null;
        }
        String strB = "";
        if ("" == 0 || "".equals("")) {
            String str = WeatherManager.GOOGLE_GEO_URL_NEW + locationArr[0].getLongitude() + "," + locationArr[0].getLatitude() + "," + this.f551a.b.getResources().getConfiguration().locale.getLanguage();
            if (!str.isEmpty()) {
                strB = this.f551a.b(str);
            }
        }
        return this.f551a.c(strB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:14:0x0031 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:10:0x0025, B:12:0x002b, B:16:0x0051, B:18:0x0057, B:20:0x005d, B:22:0x0067, B:24:0x0075, B:14:0x0031), top: B:29:0x0025 }] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str == null || str.isEmpty()) {
            return;
        }
        boolean z = false;
        this.f551a.e = SystemClock.elapsedRealtime();
        if (!str.equals(this.f551a.k)) {
            this.f551a.l = str;
            z = true;
        }
        if (z) {
            this.f551a.a(Double.valueOf(this.f551a.j.getLatitude()), Double.valueOf(this.f551a.j.getLongitude()), "gogogo");
        } else {
            try {
                if (this.f551a.g || this.f551a.n == null) {
                    this.f551a.a(Double.valueOf(this.f551a.j.getLatitude()), Double.valueOf(this.f551a.j.getLongitude()), "gogogo");
                } else if (this.f551a.j != null && this.f551a.n != null && this.f551a.n.f() && this.b - this.f551a.f >= 3600000) {
                    this.f551a.a(Double.valueOf(this.f551a.j.getLatitude()), Double.valueOf(this.f551a.j.getLongitude()), this.f551a.l);
                }
            } catch (Exception e) {
            }
        }
    }
}
