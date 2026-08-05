package com.syu.i;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
