package com.vf5regenlauncher;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WeatherWidgetController {
    private static final String TAG = "WeatherWidgetController";
    
    private final AndrewLauncherActivity activity;
    private TextView tvCity;
    private TextView tvStatus;
    private TextView tvTemp;
    private TextView tvEmoji;

    private boolean isRegistered = false;
    private WeatherManager weatherManager;

    public WeatherWidgetController(AndrewLauncherActivity activity) {
        this.activity = activity;
        this.weatherManager = new WeatherManager(activity);
        initViews();
    }

    private void initViews() {
        tvCity = activity.findViewById(R.id.tv_weather_city);
        tvStatus = activity.findViewById(R.id.tv_weather_status);
        tvTemp = activity.findViewById(R.id.tv_weather_temp);
        tvEmoji = activity.findViewById(R.id.tv_weather_icon_emoji);
        
        View container = activity.findViewById(R.id.container_weather_widget);
        if (container != null) {
            container.setOnClickListener(v -> openWeatherApp());
        }

        weatherManager.setCallback((temp, state, city) -> {
            updateUI(Math.round(temp) + "°C", WeatherCodeMapper.getDescription(state), city, WeatherCodeMapper.getEmoji(state));
        });
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

    public void register() {
        if (!isRegistered) {
            weatherManager.start();
            isRegistered = true;
            Log.d(TAG, "WeatherManager started");
        }
    }

    public void unregister() {
        isRegistered = false;
    }

    private void updateUI(String temp, String condition, String city, String emoji) {
        if (activity == null) return;
        activity.runOnUiThread(() -> {
            if (tvTemp != null) tvTemp.setText(temp);
            if (tvStatus != null) tvStatus.setText(condition);
            if (tvCity != null) tvCity.setText(city);
            if (tvEmoji != null) tvEmoji.setText(emoji);
            Log.d(TAG, "Updated Weather UI -> Temp: " + temp + ", Status: " + condition + ", City: " + city + ", Emoji: " + emoji);
        });
    }
}
