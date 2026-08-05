package com.fyt.b.a;

import android.app.Application;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Application b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f471a;

    private a() {
        this.f471a = b.getSharedPreferences("skin-peeler-lib", 0);
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static a a() {
        return b.f472a;
    }

    public static void a(Application application) {
        b = application;
    }

    public void a(String str) {
        this.f471a.edit().putString("skin-path", str).apply();
    }
}
