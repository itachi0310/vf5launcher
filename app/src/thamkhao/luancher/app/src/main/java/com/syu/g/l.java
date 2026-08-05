package com.syu.g;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.TextView;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.ip;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static LauncherApplication a() {
        return LauncherApplication.f88a;
    }

    public static void a(TextView textView, int i) {
        if (textView != null) {
            textView.setText(i);
        }
    }

    public static void a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public static boolean a(String str) {
        try {
            Resources resources = a().getResources();
            return resources.getBoolean(resources.getIdentifier(str, "bool", a().getPackageName()));
        } catch (Exception e) {
            return false;
        }
    }

    public static Resources b() {
        return LauncherApplication.f88a.getResources();
    }

    public static String b(String str) {
        try {
            Resources resources = a().getResources();
            return resources.getString(resources.getIdentifier(str, "string", a().getPackageName()));
        } catch (Exception e) {
            return "";
        }
    }

    public static SharedPreferences c() {
        return LauncherApplication.f88a.getSharedPreferences(ip.h(), 0);
    }
}
