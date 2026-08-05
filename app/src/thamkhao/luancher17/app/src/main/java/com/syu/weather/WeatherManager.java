package com.syu.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.syu.esri.ShapeDB;
import com.syu.esri.ShapeData;
import com.syu.esri.ShapeIndex;
import com.syu.esri.ShapeReader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/WeatherManager.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class WeatherManager {
    public static final int ERROR_CODE = -1;
    public static final String FYT_GEO_URL = "http://apk.carsql.com/CarMarke/findAddress.action?longitude=%f&latitude=%f";
    public static final String FYT_RECENTWEATHER_URL = "http://apk.carsql.com/Weather/WetherMain?name=%s";
    public static final int GET_CITY_DELAY = 120000;
    public static final int GET_WEATHER_DELAY = 3600000;
    public static final String GOOGLE_GEO_URL = "http://maps.google.com/maps/api/geocode/json?latlng=";
    public static final String GOOGLE_GEO_URL_NEW = "http://apk.carsql.com:8211/city/latlonlang=";
    public static final String GOOGLE_URL_ARG = "&sensor=true";
    public static final String GOOGLE_URL_LAN = "&language=zh-CN";
    public static final int LOCATION_LOC_DELAY = 60000;
    public static final int LOCATION_RUN_DELAY = 900000;
    public static final int NONE_CODE = -2;
    public static final String OPEN_WEATHER_APPID = "&APPID=4a87b2f097e39a2cb9c75916073e75a7";
    public static final String OPEN_WEATHER_IMG_URL = "http://openweathermap.org/img/w/";
    public static final String OPEN_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String OPEN_WEATHER_URL_NEW = "http://apk.carsql.com:8211/weather/latlon=";
    public static final int SUCCESS_CODE = 1;
    public static final String SYU_WEATHER_URL = "http://apk.carsql.com/Weather/CurrentDay?city=";
    public static WeatherManager instance;
    String cityName;
    Handler handler;
    HandlerThread handlerThread;
    boolean inChina;
    boolean isGettingWeather;
    Context mContext;
    Location mCurLocation;
    WeatherDescription mCurWeather;
    LocationManager mLocationManager;
    NetworkCheck mNetworkCheck;
    String tmpCity;
    public List<OnWeatherChangedListener> weatherListeners;
    boolean isRunning = false;
    long lastLocationTime = 0;
    long lastWeatherTime = 0;
    boolean isFirst = true;
    int minDis = 3;
    GpsStatus.Listener mListener = new GpsStatus.Listener() { // from class: com.syu.weather.WeatherManager.1
        long time;

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int event) {
            if (SystemClock.elapsedRealtime() - this.time > 10000) {
                this.time = SystemClock.elapsedRealtime();
                GpsStatus status = WeatherManager.this.mLocationManager.getGpsStatus(null);
                WeatherManager.this.updateGpsStatus(event, status);
            }
        }
    };
    LocationListener mNetListener = new LocationListener() { // from class: com.syu.weather.WeatherManager.2
        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
        }
    };
    LocationListener mGpsListener = new LocationListener() { // from class: com.syu.weather.WeatherManager.3
        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                boolean flag = WeatherManager.this.isBetterLocation(location, WeatherManager.this.mCurLocation);
                if (flag) {
                    WeatherManager.this.mCurLocation = location;
                    if (WeatherManager.this.minDis == 0) {
                        WeatherManager.this.stop();
                        WeatherManager.this.minDis = 2000;
                        if (WeatherManager.this.mLocationManager.isProviderEnabled("gps")) {
                            WeatherManager.this.mLocationManager.requestLocationUpdates("gps", 2L, WeatherManager.this.minDis, WeatherManager.this.mGpsListener);
                        }
                    }
                    WeatherManager.this.updateLocation(WeatherManager.this.mCurLocation);
                }
            }
        }
    };
    public mThread_readLocalData mThread_readLocalData = new mThread_readLocalData();

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/WeatherManager$OnWeatherChangedListener.class
  classes.dex
 */
    public interface OnWeatherChangedListener {
        void onWeatherChanged(WeatherDescription weatherDescription);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/WeatherManager$RecentWeatherListener.class
  classes.dex
 */
    public interface RecentWeatherListener {
        void onResult(int i, RecentWeather recentWeather);
    }

    public void addOnWeatherChangedListener(OnWeatherChangedListener listener) {
        if (listener != null) {
            if (this.weatherListeners == null) {
                this.weatherListeners = new ArrayList();
            }
            if (!this.weatherListeners.contains(listener)) {
                listener.onWeatherChanged(this.mCurWeather);
                this.weatherListeners.add(listener);
            }
        }
    }

    public void removeOnWeatherChangedListener(OnWeatherChangedListener listener) {
        if (this.weatherListeners != null && listener != null && this.weatherListeners.size() != 0 && this.weatherListeners.contains(listener)) {
            this.weatherListeners.remove(listener);
        }
    }

    public static WeatherManager initialize(Context context) {
        if (instance == null) {
            instance = new WeatherManager(context);
        }
        return instance;
    }

    public static WeatherManager getInstance() {
        return instance;
    }

    WeatherManager(Context context) {
        this.inChina = false;
        this.mContext = context.getApplicationContext();
        SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
        String string = preferences.getString("city", "");
        this.cityName = string;
        this.tmpCity = string;
        this.inChina = preferences.getBoolean("inChina", this.inChina);
        this.mLocationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
        this.mNetworkCheck = new NetworkCheck(this.mContext);
        this.mNetworkCheck.registerLisenter(new NetworkCheck.OnNetworkStateChangeLisenter() { // from class: com.syu.weather.WeatherManager.4
            @Override // com.syu.weather.NetworkCheck.OnNetworkStateChangeLisenter
            public void onChanged(boolean vaild) {
                if (vaild) {
                    WeatherManager.this.start();
                    if (WeatherManager.this.isRunning && WeatherManager.this.mCurLocation != null) {
                        WeatherManager.this.getWeatherNew(Double.valueOf(WeatherManager.this.mCurLocation.getLatitude()), Double.valueOf(WeatherManager.this.mCurLocation.getLongitude()), "gogogo");
                        return;
                    }
                    return;
                }
                WeatherManager.this.stop();
            }
        });
        this.mNetworkCheck.register(this.mContext);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.syu.weather.WeatherManager$5] */
    public void start() {
        if (this.mNetworkCheck != null && this.mNetworkCheck.hasNet && !this.isRunning) {
            this.lastWeatherTime = 0L;
            this.lastLocationTime = 0L;
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(false);
            criteria.setPowerRequirement(1);
            Location location = this.mLocationManager.getLastKnownLocation("gps");
            if (location == null) {
                location = this.mLocationManager.getLastKnownLocation("network");
            }
            if (this.mCurLocation == null) {
                if (location != null) {
                    updateLocation(location);
                    this.isFirst = false;
                } else {
                    new Thread() { // from class: com.syu.weather.WeatherManager.5
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            boolean flag = true;
                            while (flag) {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Location location2 = WeatherManager.this.mLocationManager.getLastKnownLocation("gps");
                                if (location2 == null) {
                                    location2 = WeatherManager.this.mLocationManager.getLastKnownLocation("network");
                                }
                                if (WeatherManager.this.mCurLocation != null || location2 != null) {
                                    WeatherManager.this.updateLocation(location2);
                                    WeatherManager.this.isFirst = false;
                                    flag = false;
                                }
                            }
                        }
                    }.start();
                }
            }
            if (this.mLocationManager.isProviderEnabled("gps")) {
                this.mLocationManager.requestLocationUpdates("gps", 30000L, this.minDis, this.mGpsListener);
            }
            if (this.mLocationManager.isProviderEnabled("network")) {
                this.mLocationManager.requestLocationUpdates("network", 30000L, this.minDis, this.mNetListener);
            }
            this.isRunning = true;
        }
    }

    void stop() {
        if (this.mLocationManager != null) {
            try {
                this.mLocationManager.removeUpdates(this.mGpsListener);
            } catch (Exception e) {
            }
            try {
                this.mLocationManager.removeUpdates(this.mNetListener);
            } catch (Exception e2) {
            }
        }
        this.isRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.syu.weather.WeatherManager$6] */
    public void updateLocation(Location location) {
        Log.d("hzq", "call updateLocation ** location = " + location);
        if (location != null) {
            boolean ischina = inChina(location);
            if (this.inChina != ischina) {
                this.inChina = ischina;
                SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
                preferences.edit().putBoolean("inChina", this.inChina).commit();
            }
            final long temptime = SystemClock.elapsedRealtime();
            if (this.mCurLocation == null || this.mCurWeather == null || !this.mCurWeather.vaild() || temptime - this.lastLocationTime > 120000) {
                this.mCurLocation = location;
                new AsyncTask<Location, Void, String>() { // from class: com.syu.weather.WeatherManager.6
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public String doInBackground(Location... params) throws Throwable {
                        if (params == null || params.length <= 0) {
                            return null;
                        }
                        String city = "";
                        if ("" == 0 || "".equals("")) {
                            Locale locale = WeatherManager.this.mContext.getResources().getConfiguration().locale;
                            String language = locale.getLanguage();
                            String url = WeatherManager.GOOGLE_GEO_URL_NEW + params[0].getLongitude() + "," + params[0].getLatitude() + "," + language;
                            if (!url.isEmpty()) {
                                city = WeatherManager.this.geoForNew(url);
                            }
                        }
                        return WeatherManager.this.checkCity(city);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Code duplicated, block: B:14:0x0031 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:10:0x0025, B:12:0x002b, B:16:0x0051, B:18:0x0057, B:20:0x005d, B:22:0x0067, B:24:0x0075, B:14:0x0031), top: B:29:0x0025 }] */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(String result) {
                        super.onPostExecute(result);
                        if (result != null && !result.isEmpty()) {
                            boolean changed = false;
                            WeatherManager.this.lastLocationTime = SystemClock.elapsedRealtime();
                            if (!result.equals(WeatherManager.this.cityName)) {
                                WeatherManager.this.tmpCity = result;
                                changed = true;
                            }
                            if (changed) {
                                WeatherManager.this.getWeatherNew(Double.valueOf(WeatherManager.this.mCurLocation.getLatitude()), Double.valueOf(WeatherManager.this.mCurLocation.getLongitude()), "gogogo");
                            } else {
                                try {
                                    if (WeatherManager.this.isFirst || WeatherManager.this.mCurWeather == null) {
                                        WeatherManager.this.getWeatherNew(Double.valueOf(WeatherManager.this.mCurLocation.getLatitude()), Double.valueOf(WeatherManager.this.mCurLocation.getLongitude()), "gogogo");
                                    } else if (WeatherManager.this.mCurLocation != null && WeatherManager.this.mCurWeather != null && WeatherManager.this.mCurWeather.vaild() && temptime - WeatherManager.this.lastWeatherTime >= 3600000) {
                                        WeatherManager.this.getWeatherNew(Double.valueOf(WeatherManager.this.mCurLocation.getLatitude()), Double.valueOf(WeatherManager.this.mCurLocation.getLongitude()), WeatherManager.this.tmpCity);
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }.execute(this.mCurLocation);
            }
        }
    }

    protected boolean isBetterLocation(Location newLocation, Location oldLocation) {
        if (oldLocation == null) {
            return newLocation != null;
        }
        long timeDelta = newLocation.getTime() - oldLocation.getTime();
        if (Math.abs(newLocation.getLatitude() - oldLocation.getLatitude()) >= 0.02d || Math.abs(newLocation.getLongitude() - oldLocation.getLongitude()) < 0.02d) {
        }
        boolean isRunNewer = timeDelta > 900000;
        boolean isOlder = timeDelta < -900000;
        boolean isNewer = timeDelta > 60000;
        if (isRunNewer) {
            return true;
        }
        if (isOlder) {
            return false;
        }
        int accuracyDelta = (int) (newLocation.getAccuracy() - oldLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;
        boolean isFromSameProvider = isSameProvider(newLocation.getProvider(), oldLocation.getProvider());
        if (isMoreAccurate) {
            return true;
        }
        if (isNewer && !isLessAccurate) {
            return true;
        }
        if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            return true;
        }
        return false;
    }

    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    boolean inChina(Location location) {
        double lon = location.getLongitude();
        double lat = location.getLatitude();
        return lon >= 73.33d && lon <= 135.05d && lat >= 3.51d && lat <= 53.33d;
    }

    public String getContentFromUrl(String url) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            HttpResponse response = httpclient.execute(get);
            int responseCode = response.getStatusLine().getStatusCode();
            Log.i("hzq", " getContentFromUrl: " + url + "  result responseCode :" + responseCode);
            if (responseCode != 200) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x006c A[Catch: IOException -> 0x00ac, TRY_LEAVE, TryCatch #10 {IOException -> 0x00ac, blocks: (B:11:0x0067, B:13:0x006c), top: B:64:0x0067 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x007b A[Catch: IOException -> 0x00c0, TRY_LEAVE, TryCatch #5 {IOException -> 0x00c0, blocks: (B:19:0x0076, B:21:0x007b), top: B:56:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x009a A[Catch: IOException -> 0x009e, TRY_LEAVE, TryCatch #7 {IOException -> 0x009e, blocks: (B:27:0x0095, B:29:0x009a), top: B:60:0x0095 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a8 A[Catch: IOException -> 0x00b0, TRY_LEAVE, TryCatch #6 {IOException -> 0x00b0, blocks: (B:35:0x00a3, B:37:0x00a8), top: B:58:0x00a3 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2  */
    public static String sendGet(String url) throws Throwable {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            try {
                URL realUrl = new URL(url);
                URLConnection conn = realUrl.openConnection();
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                conn.setRequestProperty(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
                conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                conn.setConnectTimeout(500000);
                conn.setReadTimeout(500000);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                try {
                    OutputStream os = conn.getOutputStream();
                    PrintWriter out2 = new PrintWriter(os);
                    try {
                        out2.print("");
                        out2.flush();
                        BufferedReader in2 = new BufferedReader(new InputStreamReader(conn.getInputStream(), HTTP.UTF_8));
                        while (true) {
                            try {
                                String line = in2.readLine();
                                if (line == null) {
                                    break;
                                }
                                result = String.valueOf(result) + line;
                            } catch (Exception e) {
                                in = in2;
                                out = out2;
                                if (out != null) {
                                    try {
                                        out.close();
                                        if (in != null) {
                                            in.close();
                                        }
                                    } catch (IOException e2) {
                                    }
                                } else if (in != null) {
                                    in.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                in = in2;
                                out = out2;
                                if (out != null) {
                                    try {
                                        out.close();
                                        if (in != null) {
                                            in.close();
                                        }
                                    } catch (IOException e3) {
                                        throw th;
                                    }
                                } else if (in != null) {
                                    in.close();
                                }
                                throw th;
                            }
                        }
                        if (out2 != null) {
                            try {
                                out2.close();
                                if (in2 != null) {
                                    in2.close();
                                }
                            } catch (IOException e4) {
                            }
                        } else if (in2 != null) {
                            in2.close();
                        }
                    } catch (Exception e5) {
                        out = out2;
                    } catch (Throwable th2) {
                        th = th2;
                        out = out2;
                    }
                    return result;
                } catch (Exception e6) {
                    if (0 != 0) {
                        try {
                            out.close();
                            if (0 != 0) {
                                in.close();
                            }
                        } catch (IOException e7) {
                            return null;
                        }
                    } else if (0 != 0) {
                        in.close();
                    }
                    return null;
                }
            } catch (Exception e8) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    String geoForSyu(String url) throws Throwable {
        String entry = sendGet(url);
        if (entry == null || entry.isEmpty()) {
            return null;
        }
        try {
            JSONObject json = new JSONObject(entry);
            if (!"OK".equals(json.getString("status")) || !json.has("address")) {
                return null;
            }
            String city = json.getString("address");
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    String geoForNew(String url) throws Throwable {
        String entry = sendGet(url);
        Log.d("hzq", "call geoForNew ** entry = " + entry);
        if (entry == null || entry.isEmpty()) {
            return null;
        }
        try {
            JSONObject json = new JSONObject(entry);
            if (!"1".equals(json.getString("status")) || !json.has("result")) {
                return null;
            }
            JSONObject result = json.getJSONObject("result");
            if (!result.has("city")) {
                return null;
            }
            String city = result.getString("city");
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    String geoForBaidu(String url) throws Throwable {
        JSONObject ret;
        JSONObject ret2;
        String entry = sendGet(url);
        if (entry == null || entry.isEmpty()) {
            return null;
        }
        try {
            JSONObject json = new JSONObject(entry);
            if (!"OK".equals(json.getString("status")) || !json.has("result") || (ret = json.getJSONObject("result")) == null || !ret.has("addressComponent") || (ret2 = ret.getJSONObject("addressComponent")) == null || !ret2.has("city")) {
                return null;
            }
            String city = ret2.getString("city");
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    String geoForGoogle(String url) throws Throwable {
        JSONObject result;
        JSONObject ret;
        String entry = sendGet(url);
        String city = null;
        if (entry == null || entry.isEmpty()) {
            return null;
        }
        try {
            JSONObject json = new JSONObject(entry);
            if (json == null || !"OK".equals(json.getString("status"))) {
                return null;
            }
            if (json.has("result")) {
                JSONObject ret2 = json.getJSONObject("result");
                if (ret2 == null || !ret2.has("addressComponent") || (ret = ret2.getJSONObject("addressComponent")) == null || !ret.has("city")) {
                    return null;
                }
                String city2 = ret.getString("city");
                return city2;
            }
            if (!json.has("results") || (result = JSONUtils.getObjFromArray(json, "results", 0)) == null || !result.has("address_components")) {
                return null;
            }
            JSONArray components = result.getJSONArray("address_components");
            int count = components != null ? components.length() : 0;
            for (int i = 0; i < count; i++) {
                JSONObject c = components.getJSONObject(i);
                if (c != null) {
                    String[] types = JSONUtils.jsonToStrArray(c, "types");
                    boolean locality = false;
                    boolean political = false;
                    for (String val : types) {
                        if (!locality && "locality".equals(val)) {
                            locality = true;
                        }
                        if (!political && "political".equals(val)) {
                            political = true;
                        }
                    }
                    if (locality && political && c.has("short_name")) {
                        city = JSONUtils.getStr(c, "short_name");
                    }
                }
            }
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    String checkCity(String city) {
        if (city == null) {
            return null;
        }
        if (city.length() <= 2) {
            return city;
        }
        if (!city.endsWith("市") && !city.endsWith("州") && !city.endsWith("县")) {
            return city;
        }
        String weatherCity = city.substring(0, city.length() - 1);
        return weatherCity;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.syu.weather.WeatherManager$7] */
    void getWeather(final String city, final boolean china) {
        if (!this.isGettingWeather && city != null && !city.isEmpty()) {
            this.isGettingWeather = true;
            new AsyncTask<String, Void, WeatherDescription>() { // from class: com.syu.weather.WeatherManager.7
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public WeatherDescription doInBackground(String... params) throws Throwable {
                    if (params != null && params.length > 0) {
                        String url = china ? WeatherManager.SYU_WEATHER_URL + city : WeatherManager.OPEN_WEATHER_URL + city + WeatherManager.OPEN_WEATHER_APPID;
                        String entry = WeatherManager.sendGet(url);
                        if (entry != null && !entry.isEmpty()) {
                            return china ? WeatherDescription.getWeatherInChina(entry) : WeatherDescription.getWeather(entry);
                        }
                    }
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(WeatherDescription result) {
                    WeatherManager.this.isGettingWeather = false;
                    if (result != null && result.vaild()) {
                        WeatherManager.this.cityName = WeatherManager.this.tmpCity;
                        SharedPreferences preferences = WeatherManager.this.mContext.getSharedPreferences(WeatherManager.this.mContext.getPackageName(), 0);
                        preferences.edit().putString("city", WeatherManager.this.cityName).commit();
                        WeatherManager.this.lastWeatherTime = SystemClock.elapsedRealtime();
                        WeatherManager.this.mCurWeather = result;
                        if (WeatherManager.this.weatherListeners != null && WeatherManager.this.weatherListeners.size() > 0) {
                            List<OnWeatherChangedListener> list = new ArrayList<>(WeatherManager.this.weatherListeners);
                            for (OnWeatherChangedListener listener : list) {
                                listener.onWeatherChanged(WeatherManager.this.mCurWeather);
                            }
                        }
                    }
                }
            }.execute(city);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.syu.weather.WeatherManager$8] */
    void getWeatherNew(final Double lat, final Double lon, String city) {
        if (!this.isGettingWeather && lat != null && lon != null) {
            this.isGettingWeather = true;
            new AsyncTask<String, Void, WeatherDescription>() { // from class: com.syu.weather.WeatherManager.8
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public WeatherDescription doInBackground(String... params) throws Throwable {
                    if (params != null && params.length > 0) {
                        Locale locale = WeatherManager.this.mContext.getResources().getConfiguration().locale;
                        locale.getLanguage();
                        String url = WeatherManager.OPEN_WEATHER_URL_NEW + lon + "," + lat;
                        Log.d("hzq", "getWeatherNew url = " + url);
                        String entry = WeatherManager.sendGet(url);
                        Log.d("hzq", "call getWeatherNew ** entry = " + entry);
                        if (entry != null && !entry.isEmpty()) {
                            return WeatherDescription.getWeatherNew(entry);
                        }
                    }
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(WeatherDescription result) {
                    WeatherManager.this.isGettingWeather = false;
                    if (result != null && result.vaild()) {
                        WeatherManager.this.cityName = WeatherManager.this.tmpCity;
                        SharedPreferences preferences = WeatherManager.this.mContext.getSharedPreferences(WeatherManager.this.mContext.getPackageName(), 0);
                        preferences.edit().putString("city", WeatherManager.this.cityName).commit();
                        WeatherManager.this.lastWeatherTime = SystemClock.elapsedRealtime();
                        WeatherManager.this.mCurWeather = result;
                        if (WeatherManager.this.weatherListeners != null && WeatherManager.this.weatherListeners.size() > 0) {
                            List<OnWeatherChangedListener> list = new ArrayList<>(WeatherManager.this.weatherListeners);
                            for (OnWeatherChangedListener listener : list) {
                                listener.onWeatherChanged(WeatherManager.this.mCurWeather);
                            }
                        }
                        Log.e("Logs", "mCurWeather city = " + WeatherManager.this.mCurWeather.city + "\nmCurWeather.weather = " + WeatherManager.this.mCurWeather.weather + "\nmCurWeather.curTem = " + WeatherManager.this.mCurWeather.curTem + "\nmCurWeather.temDescription = " + WeatherManager.this.mCurWeather.temDescription + "\nmCurWeather.wind = " + WeatherManager.this.mCurWeather.wind);
                    }
                }
            }.execute(city);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGpsStatus(int event, GpsStatus status) {
        if (event == 4) {
            int maxSatellites = status.getMaxSatellites();
            Iterator<GpsSatellite> it = status.getSatellites().iterator();
            for (int count = 0; it.hasNext() && count <= maxSatellites; count++) {
                it.next();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/WeatherManager$RecentWeather.class
  classes.dex
 */
    public static class RecentWeather {
        SparseArray<DailyWeather> mWeathers = new SparseArray<>();

        public DailyWeather getDailyWeatherAt(int day) {
            if (this.mWeathers == null || this.mWeathers.indexOfKey(day) < 0) {
                return null;
            }
            return this.mWeathers.get(day);
        }

        public void put(int day, DailyWeather weather) {
            if (this.mWeathers == null) {
                this.mWeathers = new SparseArray<>();
            }
            this.mWeathers.put(day, weather);
        }

        public SparseArray<DailyWeather> getAllWeathers() {
            return this.mWeathers;
        }

        public boolean isDataEmpty() {
            return size() <= 0;
        }

        public int size() {
            if (this.mWeathers == null) {
                return 0;
            }
            return this.mWeathers.size();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.syu.weather.WeatherManager$9] */
    public void requestRecentWeathers(String city, final RecentWeatherListener listener) {
        if (city != null && city.length() != 0) {
            String url = String.format(Locale.US, FYT_RECENTWEATHER_URL, checkCity(city));
            new AsyncTask<String, DailyWeather, RecentWeather>() { // from class: com.syu.weather.WeatherManager.9
                int resultCode = -2;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public RecentWeather doInBackground(String... params) throws Throwable {
                    RecentWeather recentWeather = null;
                    if (params != null && params.length > 0) {
                        String url2 = params[0];
                        recentWeather = new RecentWeather();
                        String entry = WeatherManager.sendGet(url2);
                        Log.e("weather", " entry :" + entry);
                        if (entry != null && entry.length() > 0) {
                            try {
                                JSONObject msg = new JSONObject(entry);
                                if (!msg.has("states") && JSONUtils.getInt(msg, "states", -1) != 1) {
                                    this.resultCode = -1;
                                } else {
                                    JSONArray daysjson = JSONUtils.getJSONArray(msg, "dayjson");
                                    if (daysjson != null && daysjson.length() > 0) {
                                        int count = daysjson.length();
                                        for (int index = 0; index < count; index++) {
                                            JSONObject obj = daysjson.getJSONObject(index);
                                            DailyWeather weather = DailyWeather.getDailyWeather(obj);
                                            if (!weather.isEmpty()) {
                                                recentWeather.put(index, weather);
                                            }
                                        }
                                    }
                                    if (!recentWeather.isDataEmpty()) {
                                        this.resultCode = 1;
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return recentWeather;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(RecentWeather result) {
                    if (result != null && listener != null) {
                        listener.onResult(this.resultCode, result);
                    }
                }
            }.execute(url);
        }
    }

    public WeatherDescription getThisWeather() {
        return this.mCurWeather;
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/WeatherManager$mThread_readLocalData.class
  classes.dex
 */
    public class mThread_readLocalData extends Thread {
        public mThread_readLocalData() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            InputStream inputStream_shx = null;
            InputStream inputStream_shp = null;
            ByteArrayOutputStream out = null;
            try {
                AssetManager assetManager = WeatherManager.this.mContext.getResources().getAssets();
                inputStream_shx = assetManager.open("CHN_adm2.shx");
                ShapeIndex shx = ShapeReader.readShapeIndex(new DataInputStream(inputStream_shx));
                inputStream_shp = assetManager.open("CHN_adm2.shp");
                ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                try {
                    byte[] buffer = new byte[4096];
                    while (true) {
                        int n = inputStream_shp.read(buffer);
                        if (n == -1) {
                            break;
                        } else {
                            out2.write(buffer, 0, n);
                        }
                    }
                    byte[] mBuffer = out2.toByteArray();
                    ShapeDB.SHAPE_DATA = new ShapeData(mBuffer, shx);
                    try {
                        inputStream_shx.close();
                        inputStream_shp.close();
                        out2.close();
                        out = out2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        out = out2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    out = out2;
                    String string = Log.getStackTraceString(e);
                    Log.i("hzq", string);
                    try {
                        inputStream_shx.close();
                        inputStream_shp.close();
                        out.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    out = out2;
                    try {
                        inputStream_shx.close();
                        inputStream_shp.close();
                        out.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
    }

    public void readLocalData() throws Throwable {
        InputStream inputStream_shx = null;
        InputStream inputStream_shp = null;
        ByteArrayOutputStream out = null;
        try {
            AssetManager assetManager = this.mContext.getResources().getAssets();
            inputStream_shx = assetManager.open("CHN_adm2.shx");
            ShapeIndex shx = ShapeReader.readShapeIndex(new DataInputStream(inputStream_shx));
            inputStream_shp = assetManager.open("CHN_adm2.shp");
            ByteArrayOutputStream out2 = new ByteArrayOutputStream();
            try {
                byte[] buffer = new byte[4096];
                while (true) {
                    int n = inputStream_shp.read(buffer);
                    if (n == -1) {
                        break;
                    } else {
                        out2.write(buffer, 0, n);
                    }
                }
                byte[] mBuffer = out2.toByteArray();
                ShapeDB.SHAPE_DATA = new ShapeData(mBuffer, shx);
                try {
                    inputStream_shx.close();
                    inputStream_shp.close();
                    out2.close();
                    out = out2;
                } catch (IOException e) {
                    e.printStackTrace();
                    out = out2;
                }
            } catch (Exception e2) {
                e = e2;
                out = out2;
                String string = Log.getStackTraceString(e);
                Log.i("hzq", string);
                try {
                    inputStream_shx.close();
                    inputStream_shp.close();
                    out.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                out = out2;
                try {
                    inputStream_shx.close();
                    inputStream_shp.close();
                    out.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}
