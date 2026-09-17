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

    public static int getIconRes(WeatherState state) {
        switch (state) {
            case CLEAR:
                return android.R.drawable.ic_menu_day; // ☀️ placeholder
            case CLOUDY:
                return android.R.drawable.ic_menu_mylocation; // ☁️ placeholder
            case RAIN:
                return android.R.drawable.ic_menu_report_image; // 🌧️ placeholder
            case STORM:
                return android.R.drawable.ic_delete; // ⛈️ placeholder
            case FOG:
                return android.R.drawable.ic_menu_view; // 🌫️ placeholder
            case SNOW:
                return android.R.drawable.ic_menu_gallery; // ❄️ placeholder
            default:
                return android.R.drawable.ic_menu_help;
        }
    }
}
