package com.syu.i;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import com.syu.weather.WeatherManager;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class l extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f552a;
    private final /* synthetic */ Double b;
    private final /* synthetic */ Double c;

    l(e eVar, Double d, Double d2) {
        this.f552a = eVar;
        this.b = d;
        this.c = d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d doInBackground(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f552a.b.getResources().getConfiguration().locale.getLanguage();
            String str = WeatherManager.OPEN_WEATHER_URL_NEW + this.b + "," + this.c;
            Log.d("hzq", "getWeatherNew url = " + str);
            String strA = e.a(str);
            Log.d("hzq", "call getWeatherNew ** entry = " + strA);
            if (strA != null && !strA.isEmpty()) {
                return d.a(strA);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(d dVar) {
        this.f552a.d = false;
        if (dVar == null || !dVar.f()) {
            return;
        }
        this.f552a.k = this.f552a.l;
        this.f552a.b.getSharedPreferences(this.f552a.b.getPackageName(), 0).edit().putString("city", this.f552a.k).commit();
        this.f552a.f = SystemClock.elapsedRealtime();
        this.f552a.n = dVar;
        if (this.f552a.p != null && this.f552a.p.size() > 0) {
            Iterator it = new ArrayList(this.f552a.p).iterator();
            while (it.hasNext()) {
                ((m) it.next()).a(this.f552a.n);
            }
        }
        Log.e("Logs", "mCurWeather city = " + this.f552a.n.f544a + "\nmCurWeather.weather = " + this.f552a.n.b + "\nmCurWeather.curTem = " + this.f552a.n.d + "\nmCurWeather.temDescription = " + this.f552a.n.e + "\nmCurWeather.wind = " + this.f552a.n.c);
    }
}
