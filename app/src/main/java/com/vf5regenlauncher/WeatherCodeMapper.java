package com.vf5regenlauncher;

public class WeatherCodeMapper {

    public static WeatherState getState(int code) {
        switch (code) {
            case 0:
                return WeatherState.CLEAR;
            case 1:
            case 2:
            case 3:
                return WeatherState.CLOUDY;
            case 45:
            case 48:
                return WeatherState.FOG;
            case 51:
            case 53:
            case 55:
            case 56:
            case 57:
            case 61:
            case 63:
            case 65:
            case 66:
            case 67:
            case 80:
            case 81:
            case 82:
                return WeatherState.RAIN;
            case 95:
            case 96:
            case 99:
                return WeatherState.STORM;
            case 71:
            case 73:
            case 75:
            case 77:
            case 85:
            case 86:
                return WeatherState.SNOW;
            default:
                return WeatherState.UNKNOWN;
        }
    }

    public static String getEmoji(WeatherState state) {
        switch (state) {
            case CLEAR:
                return "☀️";
            case CLOUDY:
                return "☁️";
            case RAIN:
                return "🌧️";
            case STORM:
                return "⛈️";
            case FOG:
                return "🌫️";
            case SNOW:
                return "❄️";
            default:
                return "❓";
        }
    }

    public static String getDescription(WeatherState state) {
        switch (state) {
            case CLEAR:
                return "Trời quang";
            case CLOUDY:
                return "Nhiều mây";
            case RAIN:
                return "Có mưa";
            case STORM:
                return "Có dông";
            case FOG:
                return "Có sương mù";
            case SNOW:
                return "Có tuyết";
            default:
                return "Không xác định";
        }
    }

    public static int getIconRes(WeatherState state) {
        return 0; // No longer used, but kept for compatibility if needed
    }
}
