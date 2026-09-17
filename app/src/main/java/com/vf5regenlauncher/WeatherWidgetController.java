package com.vf5regenlauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONObject;

public class WeatherWidgetController {
    private static final String TAG = "WeatherWidgetController";
    
    // Action broadcast thời tiết phổ biến từ ROM ô tô FYT/Syu đẩy ra
    public static final String ACTION_WEATHER_INFO = "com.syu.weather"; 

    private final AndrewLauncherActivity activity;
    private TextView tvCity;
    private TextView tvStatus;
    private TextView tvTemp;
    private ImageView ivIcon;

    private boolean isRegistered = false;

    public WeatherWidgetController(AndrewLauncherActivity activity) {
        this.activity = activity;
        initViews();
    }

    private void initViews() {
        tvCity = activity.findViewById(R.id.tv_weather_city);
        tvStatus = activity.findViewById(R.id.tv_weather_status);
        tvTemp = activity.findViewById(R.id.tv_weather_temp);
        ivIcon = activity.findViewById(R.id.iv_weather_icon);
        
        android.view.View container = activity.findViewById(R.id.container_weather_widget);
        if (container != null) {
            container.setOnClickListener(v -> openWeatherApp());
        }
        
        // Tự động thử lấy vị trí hiện tại nếu ROM chưa cung cấp
        updateLocationFallback();
    }

    private void updateLocationFallback() {
        try {
            android.location.LocationManager lm = (android.location.LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            if (lm != null) {
                // Ưu tiên GPS, nếu không có lấy Network
                android.location.Location loc = null;
                if (androidx.core.content.ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    loc = lm.getLastKnownLocation(android.location.LocationManager.GPS_PROVIDER);
                    if (loc == null) loc = lm.getLastKnownLocation(android.location.LocationManager.NETWORK_PROVIDER);
                }
                
                if (loc != null) {
                    android.location.Geocoder geocoder = new android.location.Geocoder(activity, java.util.Locale.getDefault());
                    java.util.List<android.location.Address> addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                    if (addresses != null && !addresses.isEmpty()) {
                        String cityName = addresses.get(0).getLocality();
                        if (cityName == null) cityName = addresses.get(0).getAdminArea();
                        if (cityName != null && !cityName.isEmpty()) {
                            final String detectedCity = cityName;
                            activity.runOnUiThread(() -> {
                                if (tvCity != null && (tvCity.getText().toString().equals("Hà Nội") || tvCity.getText().toString().isEmpty())) {
                                    tvCity.setText(detectedCity);
                                }
                            });
                        }
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "Location fallback failed", e);
        }
    }

    private void openWeatherApp() {
        try {
            Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.syu.weather");
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
            }
        } catch (Throwable ignored) {}
    }

    private final BroadcastReceiver weatherReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) return;
            String action = intent.getAction();
            Log.d(TAG, "Received weather intent action: " + action);

            if (ACTION_WEATHER_INFO.equals(action)) {
                try {
                    // Dữ liệu thời tiết của ROM ô tô thường gửi dưới dạng String Extra chứa định dạng JSON hoặc các trường riêng lẻ
                    String jsonStr = intent.getStringExtra("weather_json");
                    if (jsonStr != null && !jsonStr.isEmpty()) {
                        JSONObject json = new JSONObject(jsonStr);
                        String city = json.optString("city");
                        if (city.isEmpty()) city = json.optString("cityName", "Hà Nội");
                        
                        String temp = json.optString("temp");
                        if (temp.isEmpty()) temp = json.optString("curTem", "28");
                        temp = temp + "°C";
                        
                        String condition = json.optString("weather");
                        if (condition.isEmpty()) condition = json.optString("condition", "Nhiều mây");

                        updateUI(city, temp, condition);
                        return;
                    }

                    // Hỗ trợ trường hợp ROM gửi các Extra dạng chuỗi đơn lẻ
                    String city = intent.getStringExtra("city");
                    if (city == null) city = intent.getStringExtra("cityName");
                    
                    String temp = intent.getStringExtra("temp");
                    if (temp == null) temp = intent.getStringExtra("curTem");
                    
                    String condition = intent.getStringExtra("weather");
                    if (condition == null) condition = intent.getStringExtra("condition");

                    if (city == null) city = "Hà Nội";
                    if (temp == null) temp = "32°C";
                    else if (!temp.contains("°")) temp = temp + "°C";
                    if (condition == null) condition = "Nhiều mây";

                    updateUI(city, temp, condition);

                } catch (Throwable e) {
                    Log.e(TAG, "Error parsing weather broadcast data", e);
                }
            }
        }
    };

    private void updateUI(String city, String temp, String condition) {
        if (activity == null) return;
        activity.runOnUiThread(() -> {
            if (tvCity != null) tvCity.setText(city);
            if (tvTemp != null) tvTemp.setText(temp);
            if (tvStatus != null) tvStatus.setText(condition);
            Log.d(TAG, "Updated Weather UI -> City: " + city + ", Temp: " + temp + ", Status: " + condition);
        });
    }

    public void register() {
        if (!isRegistered) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(ACTION_WEATHER_INFO);
            // Một số ROM dùng action phụ này
            filter.addAction("action.com.syu.weather.info");
            try {
                activity.registerReceiver(weatherReceiver, filter);
                isRegistered = true;
                Log.d(TAG, "Registered weatherReceiver successfully");
            } catch (Throwable e) {
                Log.e(TAG, "Failed to register weatherReceiver", e);
            }
        }
    }

    public void unregister() {
        if (isRegistered) {
            try {
                activity.unregisterReceiver(weatherReceiver);
                isRegistered = false;
                Log.d(TAG, "Unregistered weatherReceiver successfully");
            } catch (Throwable e) {
                Log.e(TAG, "Failed to unregister weatherReceiver", e);
            }
        }
    }
}
