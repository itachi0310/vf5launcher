package com.syu.g;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f540a = new HashMap();
    public static final String[] b = {"特大暴雨", "大暴雨", "暴雨", "大雨", "中雨", "小雨", "冻雨", "雷阵雨", "阵雨", "暴雪", "大雪", "中雪", "小雪", "雨夹雪", "阵雪", "强沙尘暴", "沙尘暴", "浮尘", "扬沙", "雾", "阴", "闪电", "晴", "雷阵雨伴冰雹", "多云", "冰雹", "sunny", "overcast", "drizzle", "storm", "blizzard", "snowstorm", "windy", "Haze", "breeze", "gale", "typhoon", "hurricane", "foggy", "frosty", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail"};
    public static final String[] c = {"storm", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail", "sunshine", "cloudy_sky", "rain", "lightning", "great_snow", "heavy_snow", "blowing", "fog", "dust", "sandstorm", "sandstorm", "strong_sandstorm", "fog", "freezing", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail"};

    static {
        for (int i = 0; i < b.length; i++) {
            f540a.put(b[i], c[i]);
        }
    }

    public static int a(Context context, String str) {
        String str2;
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                str2 = strArr[i];
                if (str != null && str.toLowerCase().contains(str2)) {
                    break;
                }
                i++;
            } else {
                str2 = null;
                break;
            }
        }
        if (str2 != null && !str2.equals("")) {
            str2 = (String) f540a.get(str2);
        }
        return a(context, "fyt_ic_" + str2, "drawable");
    }

    public static int a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        if (resources == null) {
            return 0;
        }
        return resources.getIdentifier(str, str2, context.getPackageName());
    }
}
