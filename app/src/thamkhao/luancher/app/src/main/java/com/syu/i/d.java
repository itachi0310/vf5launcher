package com.syu.i;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f544a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;

    public static d a(String str) {
        JSONObject jSONObjectA;
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null && (jSONObjectA = a.a(jSONObject, "result")) != null && jSONObjectA.getInt("status") == 1) {
                JSONObject jSONObjectA2 = a.a(jSONObjectA, "city");
                if (jSONObjectA2 != null) {
                    dVar.f544a = a.b(jSONObjectA2, "city");
                }
                dVar.b = a.b(jSONObjectA, "weather");
                dVar.d = a.b(jSONObjectA, "temp");
                dVar.e = a.b(jSONObjectA, "temp");
                dVar.g = a.b(jSONObjectA, "humidity");
                dVar.c = a.b(jSONObjectA, "wind");
                dVar.h = a.b(jSONObjectA, "updatetime");
                dVar.f = a.b(jSONObjectA, "washindex");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (dVar.f()) {
            return dVar;
        }
        return null;
    }

    public String a() {
        return this.f544a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean f() {
        return (this.f544a == null || this.b == null || this.d == null || this.c == null) ? false : true;
    }

    public String toString() {
        return "city:" + this.f544a + "\nweather:" + this.b + "\ncurTem:" + this.d + "\ntemDescription:" + this.e + "\nwind" + this.c + "\nmorningExe:" + this.i + "\ncarWash:" + this.f + "\nhumidity:" + this.g + "\nupdateTime:" + this.h;
    }
}
