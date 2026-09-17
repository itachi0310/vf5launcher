package com.vf5regenlauncher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class WeatherManager {
    private static final String TAG = "WeatherManager";
    private static final String PREFS_NAME = "weather_cache";
    private static final long UPDATE_INTERVAL = 15 * 60 * 1000; // 15 mins
    private static final float LOCATION_DISTANCE_THRESHOLD = 5000; // 5km

    private final Context context;
    private final SharedPreferences prefs;
    private final LocationManager locationManager;
    
    private double lastLat = 0;
    private double lastLon = 0;
    private long lastUpdateTime = 0;

    public interface WeatherCallback {
        void onWeatherUpdated(float temp, WeatherState state);
    }

    private WeatherCallback callback;

    public WeatherManager(Context context) {
        this.context = context;
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        loadCache();
    }

    public void setCallback(WeatherCallback callback) {
        this.callback = callback;
        // Gửi ngay dữ liệu cache nếu có
        if (callback != null && lastUpdateTime > 0) {
            callback.onWeatherUpdated(getCachedTemp(), getCachedState());
        }
    }

    public void start() {
        requestLocation();
        checkAndUpdate();
    }

    @SuppressLint("MissingPermission")
    private void requestLocation() {
        try {
            if (locationManager != null) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 300000, 1000, locationListener);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300000, 1000, locationListener);
                
                Location last = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (last == null) last = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (last != null) {
                    handleNewLocation(last);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Request location failed", e);
        }
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override public void onLocationChanged(Location location) { handleNewLocation(location); }
        @Override public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override public void onProviderEnabled(String provider) {}
        @Override public void onProviderDisabled(String provider) {}
    };

    private void handleNewLocation(Location location) {
        float distance = calculateDistance(lastLat, lastLon, location.getLatitude(), location.getLongitude());
        if (distance > LOCATION_DISTANCE_THRESHOLD || lastLat == 0) {
            lastLat = location.getLatitude();
            lastLon = location.getLongitude();
            Log.d(TAG, "Location moved > 5km, triggering weather update");
            fetchWeather();
        }
    }

    private void checkAndUpdate() {
        long now = System.currentTimeMillis();
        if (now - lastUpdateTime > UPDATE_INTERVAL) {
            fetchWeather();
        }
    }

    public void fetchWeather() {
        if (lastLat == 0 && lastLon == 0) {
            Log.w(TAG, "No location yet, skipping API call");
            return;
        }
        new FetchWeatherTask().execute(lastLat, lastLon);
    }

    private class FetchWeatherTask extends AsyncTask<Double, Void, String> {
        @Override
        protected String doInBackground(Double... params) {
            try {
                String urlStr = String.format(Locale.US, 
                    "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current=temperature_2m,weather_code&timezone=auto",
                    params[0], params[1]);
                
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) result.append(line);
                reader.close();
                return result.toString();
            } catch (Exception e) {
                Log.e(TAG, "Fetch weather API error", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String json) {
            if (json == null) return;
            try {
                JSONObject root = new JSONObject(json);
                JSONObject current = root.getJSONObject("current");
                float temp = (float) current.getDouble("temperature_2m");
                int code = current.getInt("weather_code");
                
                WeatherState state = WeatherCodeMapper.getState(code);
                saveCache(temp, state);
                
                if (callback != null) {
                    callback.onWeatherUpdated(temp, state);
                }
            } catch (Exception e) {
                Log.e(TAG, "Parse weather error", e);
            }
        }
    }

    private void saveCache(float temp, WeatherState state) {
        lastUpdateTime = System.currentTimeMillis();
        prefs.edit()
            .putFloat("temp", temp)
            .putString("state", state.name())
            .putLong("time", lastUpdateTime)
            .putFloat("lat", (float)lastLat)
            .putFloat("lon", (float)lastLon)
            .apply();
    }

    private void loadCache() {
        lastUpdateTime = prefs.getLong("time", 0);
        lastLat = prefs.getFloat("lat", 0);
        lastLon = prefs.getFloat("lon", 0);
    }

    private float getCachedTemp() { return prefs.getFloat("temp", 25.0f); }
    private WeatherState getCachedState() {
        try {
            return WeatherState.valueOf(prefs.getString("state", "CLEAR"));
        } catch (Exception e) {
            return WeatherState.CLEAR;
        }
    }

    private float calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        float[] results = new float[1];
        Location.distanceBetween(lat1, lon1, lat2, lon2, results);
        return results[0];
    }
}
