package com.syu.weather;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/JSONUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class JSONUtils {
    JSONUtils() {
    }

    public static JSONObject getJSONObject(JSONObject json, String name) {
        if (json == null || !json.has(name)) {
            return null;
        }
        try {
            JSONObject result = json.getJSONObject(name);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray getJSONArray(JSONObject json, String name) {
        if (json == null || !json.has(name)) {
            return null;
        }
        try {
            JSONArray result = json.getJSONArray(name);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int[] jsonToIntArray(JSONObject object, String name) {
        int len;
        if (!object.has(name)) {
            return null;
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array == null || (len = array.length()) == 0) {
                return null;
            }
            int[] values = new int[len];
            for (int i = 0; i < len; i++) {
                values[i] = array.getInt(i);
            }
            return values;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] jsonToStrArray(JSONObject object, String name) {
        int len;
        if (!object.has(name)) {
            return null;
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array == null || (len = array.length()) == 0) {
                return null;
            }
            String[] values = new String[len];
            for (int i = 0; i < len; i++) {
                values[i] = array.getString(i);
            }
            return values;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getStr(JSONObject object, String name) {
        if (!object.has(name)) {
            return "";
        }
        try {
            return object.getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getInt(JSONObject object, String name, int def) {
        if (object.has(name)) {
            try {
                int val = object.getInt(name);
                return val;
            } catch (JSONException e) {
                e.printStackTrace();
                return def;
            }
        }
        return def;
    }

    public static String getTempName(JSONObject object, String name) {
        return getDoubleName(object, name, -273.15d, "");
    }

    public static String getDoubleName(JSONObject object, String name) {
        return getDoubleName(object, name, 0.0d, "");
    }

    private static String getDoubleName(JSONObject object, String name, double base, String def) {
        if (object.has(name)) {
            try {
                double val = object.getDouble(name);
                DecimalFormat format = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
                String str = format.format(val + base);
                return str;
            } catch (JSONException e) {
                e.printStackTrace();
                return def;
            }
        }
        return def;
    }

    public static JSONObject getObjFromArray(JSONObject object, String name, int index) {
        JSONObject ret = null;
        if (!object.has(name)) {
            return null;
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array == null || array.length() <= index) {
                return null;
            }
            ret = array.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getFromArray(JSONObject object, String name, int index) {
        String ret = "";
        if (!object.has(name)) {
            return "";
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array != null) {
                int len = array.length();
                if (len > index) {
                    ret = array.getString(index);
                    return ret;
                }
            }
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
