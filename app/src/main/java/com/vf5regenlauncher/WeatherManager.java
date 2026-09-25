package com.vf5regenlauncher;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class WeatherManager {
    private static final String TAG = "WeatherManager";
    private static final String PREFS_NAME = "weather_cache";
    private static final long UPDATE_INTERVAL = 15 * 60 * 1000; // 15 mins
    private static final float LOCATION_DISTANCE_THRESHOLD = 200; // 200m - Nhạy hơn khi di chuyển

    private final Context context;
    private final SharedPreferences prefs;
    private final LocationManager locationManager;
    
    private double lastLat = 0;
    private double lastLon = 0;
    private String lastCity = "Đang xác định...";
    private long lastUpdateTime = 0;

    public interface WeatherCallback {
        void onWeatherUpdated(float temp, WeatherState state, String city);
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
        // Gửi ngay dữ liệu vị trí/thời tiết ban đầu/cache
        if (callback != null) {
            callback.onWeatherUpdated(getCachedTemp(), getCachedState(), lastCity);
        }
    }

    public void start() {
        requestLocation();
        checkAndUpdate();
    }

    public void refreshWeather() {
        requestLocation();
        if (lastLat != 0 || lastLon != 0) {
            updateCityName(lastLat, lastLon);
            fetchWeather();
        } else if (callback != null) {
            callback.onWeatherUpdated(getCachedTemp(), getCachedState(), lastCity);
        }
    }

    private void requestLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.w(TAG, "Location permission not granted, skipping location request");
                return;
            }
        }
        
        try {
            if (locationManager != null) {
                if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 100, locationListener);
                }
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 100, locationListener);
                }
                
                @SuppressLint("MissingPermission")
                Location last = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (last == null) {
                    @SuppressLint("MissingPermission")
                    Location netLast = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    last = netLast;
                }
                
                if (last != null) {
                    handleNewLocation(last);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Request location failed", e);
        }
    }

    private void updateCityName(double lat, double lon) {
        if (lat == 0 && lon == 0) return;
        Log.d(TAG, "Starting Geocoder for: " + lat + ", " + lon);
        
        new Thread(() -> {
            boolean success = false;
            try {
                if (Geocoder.isPresent()) {
                    Geocoder geocoder = new Geocoder(context, new Locale("vi", "VN"));
                    List<Address> addresses = geocoder.getFromLocation(lat, lon, 1);
                    
                    if (addresses != null && !addresses.isEmpty()) {
                        Address address = addresses.get(0);
                        String city = extractCityFromAddress(address);
                        if (city != null) {
                            updateLastCity(city);
                            success = true;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "System Geocoder failed: " + e.getMessage());
            }

            // Fallback to Network Reverse Geocoding if System Geocoder fails
            if (!success) {
                Log.d(TAG, "System Geocoder failed, trying Network Fallback (Nominatim)");
                try {
                    String city = fetchCityNameFromNetwork(lat, lon);
                    if (city != null) {
                        updateLastCity(city);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Network Geocoder failed: " + e.getMessage());
                }
            }
        }).start();
    }

    private String extractCityFromAddress(Address address) {
        // Ưu tiên các cấp độ từ chi tiết đến bao quát
        String city = address.getSubLocality(); // Phường/Xã
        if (city == null || city.isEmpty()) city = address.getLocality(); // Quận/Huyện
        if (city == null || city.isEmpty()) city = address.getSubAdminArea(); // Tỉnh/Thành phố
        if (city == null || city.isEmpty()) city = address.getAdminArea();
        
        if (city != null) {
            return city.replace("Thành phố ", "").replace("TP. ", "").replace("Tỉnh ", "").replace("Quận ", "").replace("Huyện ", "");
        }
        return null;
    }

    private void updateLastCity(String city) {
        if (city == null || city.isEmpty()) return;
        lastCity = city;
        Log.d(TAG, "City name identified: " + lastCity);
        saveCacheCity(lastCity);
        if (callback != null) {
            callback.onWeatherUpdated(getCachedTemp(), getCachedState(), lastCity);
        }
    }

    private String fetchCityNameFromNetwork(double lat, double lon) {
        try {
            // Thêm accept-language=vi để lấy tên tiếng Việt
            String urlStr = String.format(Locale.US, 
                "https://nominatim.openstreetmap.org/reverse?format=json&lat=%.6f&lon=%.6f&zoom=14&addressdetails=1&accept-language=vi",
                lat, lon);
            
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "VF5Launcher/1.0"); 
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) result.append(line);
            reader.close();

            JSONObject json = new JSONObject(result.toString());
            if (json.has("address")) {
                JSONObject addr = json.getJSONObject("address");
                String city = null;
                
                // Cố gắng lấy cấp độ Phường/Quận/Thành phố
                if (addr.has("suburb")) city = addr.getString("suburb");
                else if (addr.has("neighbourhood")) city = addr.getString("neighbourhood");
                else if (addr.has("quarter")) city = addr.getString("quarter");
                else if (addr.has("town")) city = addr.getString("town");
                else if (addr.has("city")) city = addr.getString("city");
                else if (addr.has("district")) city = addr.getString("district");
                else if (addr.has("state")) city = addr.getString("state");
                
                if (city != null) {
                    return city.replace("Thành phố ", "").replace("TP. ", "").replace("Tỉnh ", "").replace("Quận ", "").replace("Huyện ", "");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Network reverse geocoding error", e);
        }
        return null;
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override public void onLocationChanged(Location location) { handleNewLocation(location); }
        @Override public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override public void onProviderEnabled(String provider) {}
        @Override public void onProviderDisabled(String provider) {}
    };

    private void handleNewLocation(Location location) {
        if (location == null) return;
        float distance = calculateDistance(lastLat, lastLon, location.getLatitude(), location.getLongitude());
        Log.d(TAG, String.format(Locale.US, "New location: %.6f, %.6f (Accuracy: %.1fm, Provider: %s, Distance: %.1fm)", 
            location.getLatitude(), location.getLongitude(), location.getAccuracy(), location.getProvider(), distance));
        
        lastLat = location.getLatitude();
        lastLon = location.getLongitude();
        // Ưu tiên cập nhật tên vị trí trước các nội dung khác
        updateCityName(lastLat, lastLon);
        fetchWeather();
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
                    callback.onWeatherUpdated(temp, state, lastCity);
                }
            } catch (Exception e) {
                Log.e(TAG, "Parse weather error", e);
            }
        }
    }

    private void saveCacheCity(String city) {
        prefs.edit().putString("city", city).apply();
    }

    private void saveCache(float temp, WeatherState state) {
        lastUpdateTime = System.currentTimeMillis();
        prefs.edit()
            .putFloat("temp", temp)
            .putString("state", state.name())
            .putLong("time", lastUpdateTime)
            .putFloat("lat", (float)lastLat)
            .putFloat("lon", (float)lastLon)
            .putString("city", lastCity)
            .apply();
    }

    private void loadCache() {
        lastUpdateTime = prefs.getLong("time", 0);
        lastLat = prefs.getFloat("lat", 0);
        lastLon = prefs.getFloat("lon", 0);
        lastCity = prefs.getString("city", "Hồ Chí Minh");
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
